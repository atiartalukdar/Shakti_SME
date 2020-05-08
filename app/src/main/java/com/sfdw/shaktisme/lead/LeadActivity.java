package com.sfdw.shaktisme.lead;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sfdw.shaktisme.R;
import com.theartofdev.edmodo.cropper.CropImage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import bp.SP;
import bp.Session;
import bp.TimeUtils;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.LoadConfigurationDM;
import objectBox.LeadBox;
import services.ObjectBoxManager;
import services.ServiceManager;

public class LeadActivity extends AppCompatActivity {
    private final String TAG = getClass().getName() + " Atiar - ";
    ObjectBoxManager _objectBoxManager = new ObjectBoxManager();
    ServiceManager _serviceManager = new ServiceManager();
    LeadBox _leadBox;
    List<LoadConfigurationDM.LeadOptionList> _leadOptionLists;

    private final int minimumAge = 25;
    private final int maximumAge = 65;
    private final int vibrationDurationInMilisec = 300;
    Vibrator vibe;
    ArrayAdapter<LoadConfigurationDM.LeadOptionList> spinnerArrayAdapter;

    @BindView(R.id.leadID)                      TextView _leadID;
    @BindView(R.id.ed_applicantName)            TextView _applicantName;
    @BindView(R.id.org_name)                    TextView _orgName;
    @BindView(R.id.radioSex)                    RadioGroup _radioGender;
    @BindView(R.id.mobileNumber)                EditText _mobileNumber;
    @BindView(R.id.nid)                         EditText _nid;
    @BindView(R.id.type_of_loan_spinner)        Spinner _typeOfLoanSpinner;
    @BindView(R.id.requiredLoanAmount)          EditText _requiredLoanAmount;
    @BindView(R.id.requiredLoanText)            TextView _requiredLoanText;
    @BindView(R.id.profile_image)               ImageView _profileImage;
    @BindView(R.id.dateOfBirth)                 TextView _dateOfBirth;
    @BindView(R.id.age)                         EditText _age;
    @BindView(R.id.currentAddressEd)            EditText _currentAddressEd;
    @BindView(R.id.workingAddressEd)            EditText _workingAddressEd;
    @BindView(R.id.currentAddress)              ImageView _currentAddressBtn;
    @BindView(R.id.workingAddress)              ImageView _workingAddressBtn;
    @BindView(R.id.saveBtn)                     Button _saveLeadBtn;
    @BindView(R.id.nid_1st_page)                ImageView _nid_1st_page;
    @BindView(R.id.nid_2nd_page)                ImageView _nid_2nd_page;

    String nidImg1, nidImg2;
    static final int REQUEST_IMAGE_NID_PAGE1 = 1000;
    static final int REQUEST_IMAGE_NID_PAGE2 = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_lead);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        vibe = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);

        _leadOptionLists = _serviceManager.getLeadOptionList();

        _leadBox = (LeadBox) getIntent().getSerializableExtra("LeadDataModelObjectBox");

        if (_leadBox != null) {
            setUIInformation(_leadBox);
        }

        dateOfBirthPicker();

        allOnClickListener();

        SP.updateLocation();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_IMAGE_NID_PAGE1:
                Intent i1 = CropImage.activity(Utils.photoURI)
                        .getIntent(this);
                startActivityForResult(i1, 1);
                break;
            case REQUEST_IMAGE_NID_PAGE2:
                Intent i2 = CropImage.activity(Utils.photoURI)
                        .getIntent(this);
                startActivityForResult(i2, 2);
                break;
            case 1:
                Bitmap image = Utils.getBitMapImageFromIntent(this,requestCode,resultCode,data);
                if (image != null){
                    _nid_1st_page.setImageBitmap(image);
                    nidImg1 = Utils.convertToBase64(image);
                }
                break;
            case 2:
                Bitmap image1 = Utils.getBitMapImageFromIntent(this,requestCode,resultCode,data);
                if (image1 != null){
                    _nid_2nd_page.setImageBitmap(image1);
                    nidImg2 = Utils.convertToBase64(image1);
                }
                break;
        }
    }

    private void allOnClickListener() {
        spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, _leadOptionLists);
        _typeOfLoanSpinner.setAdapter(spinnerArrayAdapter);

        _typeOfLoanSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                _requiredLoanText.setText(getResources().getString(R.string.required_loan_amount) +
                        Utils.formatNumber(_serviceManager.getLeadOptionList().get(pos).getLOANMIN()) + " - " + Utils.formatNumber(_serviceManager.getLeadOptionList().get(pos).getLOANMAX()) + " টাকা");

                _requiredLoanAmount.setHint(Utils.formatNumber(_serviceManager.getLeadOptionList().get(pos).getLOANROUNDAMOUNT()) + getResources().getString(R.string.leadOptionsMultiplayer));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        _currentAddressBtn.setOnClickListener(v -> {
            updateLocationUI(_currentAddressEd);
        });

        _workingAddressBtn.setOnClickListener(v -> {
            updateLocationUI(_workingAddressEd);
        });

        _nid_1st_page.setOnClickListener(v -> takeNidImage1());
        /*_nid_1st_page.setOnClickListener(v -> {
            Uri outputFileUri = getCaptureImageOutputUri(this);

            Intent intent = CropImage.activity()
                    .getIntent(getContext())
                    ;

            intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

            startActivityForResult(intent, 1);
        });*/

        _nid_2nd_page.setOnClickListener(v -> takeNidImage2());
        /*_nid_2nd_page.setOnClickListener(v -> {

            Intent intent = CropImage.activity()
                    .getIntent(getContext());
            startActivityForResult(intent, 2);
        });*/

        _saveLeadBtn.setOnClickListener(v -> {
            if (validate()) {
                _objectBoxManager.SaveLeadBox(SetLeadBox());
                startActivity(new Intent(LeadActivity.this, LeadListActivity.class));
                finish();
            } else {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.errorAddNewLead), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void takeNidImage1() {
        Utils.captureImage(this,REQUEST_IMAGE_NID_PAGE1);
    }

    private void takeNidImage2() {
        Utils.captureImage(this,REQUEST_IMAGE_NID_PAGE2);
    }

    private void dateOfBirthPicker() {
        DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.YEAR, year);
                c.set(Calendar.MONTH, month);
                c.set(Calendar.DAY_OF_MONTH, day);
                String format = new SimpleDateFormat("dd MMM yyyy").format(c.getTime());
                String dob = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
                TimeUtils timeUtils = new TimeUtils(dob);
                Log.e(TAG, "Atiar dob = " + timeUtils.getYears());

                _dateOfBirth.setText(format);
                _age.setText(timeUtils.getYearMonthDate());
                if (timeUtils.getYears() < minimumAge) {
                    setError(_age, getString(R.string.ageErrorMin));
                    _dateOfBirth.setTextColor(getResources().getColor(R.color.errorColor));
                } else if (timeUtils.getYears() > maximumAge) {
                    _age.setError(getString(R.string.ageErrorMax));
                    _dateOfBirth.setTextColor(getResources().getColor(R.color.errorColor));
                    _age.setTextColor(getResources().getColor(R.color.errorColor));
                    _dateOfBirth.startAnimation(shakeError());
                    _age.startAnimation(shakeError());
                    vibe.vibrate(300); // 50 is time in ms
                } else {
                    _age.setError(null);
                    _age.setTextColor(Color.BLACK);
                    _dateOfBirth.setTextColor(Color.BLACK);
                }
            }
        };
        _dateOfBirth.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR) - 25;
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dateDialog = new DatePickerDialog(v.getContext(), datePickerListener, mYear, mMonth, mDay);
            dateDialog.getDatePicker().setMaxDate(new Date().getTime());
            dateDialog.show();
        });
    }

    private LeadBox SetLeadBox() {
        String user_id = Session.getUserID();
        String orgName = _orgName.getText().toString();
        String applicantName = _applicantName.getText().toString();
        String nidNo = _nid.getText().toString();
        String mobileNo = _mobileNumber.getText().toString();
        String dateOfBirth = _dateOfBirth.getText().toString();
        String preAddress = _currentAddressEd.getText().toString();
        String permanentAddress = SP.getAddress();
        String workAddress = _workingAddressEd.getText().toString();
        Integer leadOptionId = _serviceManager.getLeadOptionID(_typeOfLoanSpinner.getSelectedItem().toString());
        Double loanAmount = Double.parseDouble(_requiredLoanAmount.getText().toString());
        String branchId = Session.getSeassionDataNew().getData().getBRANCHID();
        String screeningStatus = getResources().getString(R.string.prescreen_result_init);
        String gender = "";
        String imeiNo = SP.getDeviceIMEI();
        String leadStatus = "";
        String latitude = SP.getLatitude();
        String longitude = SP.getLongitude();
        String leadGpsAddress = SP.getAddress();
        String devPhone = SP.getMyPhoneNO();
        String nid_front = nidImg1;
        String nid_back = nidImg2;

        int radioSex = _radioGender.getCheckedRadioButtonId();
        switch (radioSex) {
            case R.id.radioMale:
                gender = "M";
                break;
            case R.id.radioFemale:
                gender = "F";
                break;
        }

        LeadBox leadBox;
        if (_leadBox == null) {
            leadBox = new LeadBox();
            leadBox.setLEAD_ID(Utils.getTempLeadID());
            leadBox.setIS_OFFLINE(true);
        } else {
            leadBox = _leadBox;
        }
        leadBox.setAPPLICANT_NAME(applicantName);
        leadBox.setORG_NAME(orgName);
        leadBox.setNID_NO(nidNo);
        leadBox.setMOBILE_NO(mobileNo);
        leadBox.setDATE_OF_BIRTH(dateOfBirth);
        leadBox.setPRESENT_ADDRESS(preAddress);
        leadBox.setBUSINESS_ADDRESS(permanentAddress);
        leadBox.setWORK_ADDRESS(workAddress);
        leadBox.setLEADOPTION_ID(leadOptionId);
        leadBox.setLOAN_AMOUNT(loanAmount);
        leadBox.setBRANCH_ID(branchId);
        leadBox.setRO_ID(user_id);
        leadBox.setPRESCREENING_STATUS(screeningStatus);
        leadBox.setGENDER(gender);
        leadBox.setIMEI(imeiNo);
        leadBox.setSTATUS(leadStatus);
        leadBox.setLATITUDE(latitude);
        leadBox.setLONGITUDE(longitude);
        leadBox.setNID_FRONT_DOC(nid_front);
        leadBox.setNID_BACK_DOC(nid_back);
        leadBox.setLEAD_GPS_ADDRESS(leadGpsAddress);
        leadBox.setDEVICEPHONE_NUMBER(devPhone);
        return leadBox;
    }

    private void setUIInformation(LeadBox leadBox) {
        int position = _serviceManager.getPosition(_leadOptionLists, leadBox.getLEADOPTION_ID());

        _typeOfLoanSpinner.post(() -> _typeOfLoanSpinner.setSelection(position));

        _orgName.setText(leadBox.getORG_NAME());
        _applicantName.setText(leadBox.getAPPLICANT_NAME());
        _nid.setText(leadBox.getNID_NO());
        _mobileNumber.setText(leadBox.getMOBILE_NO());
        _dateOfBirth.setText(leadBox.getDATE_OF_BIRTH());
        _currentAddressEd.setText(leadBox.getPRESENT_ADDRESS());
        _workingAddressEd.setText(leadBox.getWORK_ADDRESS());
        _requiredLoanAmount.setText(leadBox.getLOAN_AMOUNT().toString());

        _radioGender.check(leadBox.getGENDER().toLowerCase().equals("m") ? R.id.radioMale : R.id.radioFemale);

        if (leadBox.getNID_FRONT_DOC() != null) {
            byte[] decodedString = Base64.decode(leadBox.getNID_FRONT_DOC(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            _nid_1st_page.setImageBitmap(decodedByte);
            nidImg1 = leadBox.getNID_FRONT_DOC();
        }
        if (leadBox.getNID_BACK_DOC() != null) {
            byte[] decodedString = Base64.decode(leadBox.getNID_BACK_DOC(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            _nid_2nd_page.setImageBitmap(decodedByte);
            nidImg2 = leadBox.getNID_BACK_DOC();

        }
    }

    private TranslateAnimation shakeError() {
        TranslateAnimation shake = new TranslateAnimation(0, 10, 0, 0);
        shake.setDuration(500);
        shake.setInterpolator(new CycleInterpolator(7));
        return shake;
    }

    private void setError(EditText editText, String errorMessage) {
        editText.setError(errorMessage);
        editText.startAnimation(shakeError());
        vibe.vibrate(vibrationDurationInMilisec);
        editText.setTextColor(getResources().getColor(R.color.errorColor));
    }

    private void updateLocationUI(EditText editText) {
        editText.setText(SP.getAddress());

        // giving a blink animation on TextView
        editText.setAlpha(0);
        editText.animate().alpha(1).setDuration(300);
    }

    private boolean validate() {
        boolean validationStatus = true;
        if (_mobileNumber.getText().length() != 11) {
            setError(_mobileNumber, getResources().getString(R.string.mobileError));
            validationStatus = false;
        }

        String nid = _nid.getText().toString();
        if (!(nid.length() == 10 || nid.length() == 13 || nid.length() == 17)) {
            setError(_nid, getResources().getString(R.string.nidError));
            validationStatus = false;
        }

        if (_requiredLoanAmount.getText().length() == 0) {
            setError(_requiredLoanAmount, getResources().getString(R.string.loanAmountError));
            validationStatus = false;
        } else {
            int leadOptionId = _serviceManager.getLeadOptionID(_typeOfLoanSpinner.getSelectedItem().toString());
            int roundFigure = (int) Math.round(_serviceManager.getLeadOptionObject(leadOptionId).getLOANROUNDAMOUNT());
            double minimumAmount = Double.parseDouble(_serviceManager.getLeadOptionObject(leadOptionId).getLOANMIN().toString());
            double maximumAmount = Double.parseDouble(_serviceManager.getLeadOptionObject(leadOptionId).getLOANMAX().toString());

            double insertedAmount = Double.parseDouble(_requiredLoanAmount.getText().toString());
            if (insertedAmount % roundFigure != 0) {
                setError(_requiredLoanAmount, Utils.formatNumber(roundFigure) + getResources().getString(R.string.leadOptionsMultiplayer));
                validationStatus = false;
            }
            if ((insertedAmount < minimumAmount) || (insertedAmount > maximumAmount)) {
                setError(_requiredLoanAmount, Utils.formatNumber(minimumAmount) + " - " + Utils.formatNumber(maximumAmount) + getResources().getString(R.string.errorRequiredAmount));
                validationStatus = false;
            }
        }
        return validationStatus;
    }
}





