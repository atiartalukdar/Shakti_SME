package com.sfdw.shaktisme.loanInformation.remittance;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.LoanAssessmentActivity;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import bp.BaseActivity;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.LoadConfigurationDM;
import dataModelNew.MemberListDM;
import de.hdodenhof.circleimageview.CircleImageView;
import objectBox.LoanRemittanceInfoBox;
import services.ObjectBoxManager;
import services.ServiceManager;

public class LoanRemitenceActivity extends BaseActivity {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    ServiceManager _serviceManager = new ServiceManager();
    private String _remittanceWorkPermitBase64;
    private String _remittanceSlipBase64;

    @BindView(R.id.remittance_slip_file)
    ImageView _remittanceSlipFile;
    @BindView(R.id.remittance_work_permit_file)
    ImageView _remittanceWorkPermitFile;
    private MemberListDM.Data member;

    @BindView(R.id.name)    TextView _name;
    @BindView(R.id.memberID)    TextView _memberID;
    @BindView(R.id.remittance_nrb_name)    EditText _remittanceNrbName;
    @BindView(R.id.remittance_relation_applicant)    EditText _remittanceRelationApplicant;
    @BindView(R.id.remittance_amount)    EditText _remittanceAmount;
    @BindView(R.id.remittance_receiver_name)    EditText _remittanceReceiverName;
    @BindView(R.id.remittance_country_code)    Spinner _remittanceCountryCodeSpinner;
    @BindView(R.id.remittance_nrb_day)    EditText _remittanceNrbDay;
    @BindView(R.id.remittance_is_valid_visa_permit_yes)    RadioButton _remittanceIsValidVisaPermitYes;
    @BindView(R.id.remittance_is_valid_visa_permit_no)    RadioButton _remittanceIsValidVisaPermitNo;
    @BindView(R.id.radioGroup_remittance_is_valid_visa_permit)    RadioGroup _radioGroupRemittanceIsValidVisaPermit;

    @BindView(R.id.remittance_visa_date_line)    TextView _remittanceVisaDateLine;
    @BindView(R.id.remittance_work_permit_date_line)    TextView _remittanceWorkPermitDateLine;
    @BindView(R.id.remittance_org_name_in_nrb)    EditText _remittanceOrgNameInNrb;
    @BindView(R.id.remittance_nrb_passport)    EditText _remittanceNrbPassport;

    @BindView(R.id.saveBtn)
    Button _saveBtn;


    ArrayList<LoadConfigurationDM.CountryList> countryArray = new ArrayList<>();
    ArrayAdapter<LoadConfigurationDM.CountryList> countryAdapter;

    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_remitence);
        ButterKnife.bind(this);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        Log.e(TAG, member.getMEMBER_ID());

        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());

        countryArray.addAll(_serviceManager.getCountryList());

        _remittanceWorkPermitFile.setEnabled(true);
        _remittanceWorkPermitFile.setImageResource(R.drawable.profile);
        _remittanceWorkPermitFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureWorkPermitDoc();
            }
        });

        _remittanceSlipFile.setEnabled(true);
        _remittanceSlipFile.setImageResource(R.drawable.profile);
        _remittanceSlipFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureRemittanceSlip();
            }
        });

        loadUIIfAvailable();

        datePicker();

        countryAdapter = new ArrayAdapter<>(LoanRemitenceActivity.this, android.R.layout.simple_spinner_dropdown_item, countryArray);
        _remittanceCountryCodeSpinner.setAdapter(countryAdapter);
        countryAdapter.notifyDataSetChanged();
    }

    private void setLoanRemittanceInfoBox(LoanRemittanceInfoBox data) {
        data.setMEMBER_ID(member.getMEMBER_ID());
        data.setBRANCH_ID(member.getBRANCH_ID());
        data.setCENTER_ID(member.getCENTER_ID());
        data.setNRB_NAME(_remittanceNrbName.getText().toString());
        data.setRELATION_WITH_APPLICANT(_remittanceRelationApplicant.getText().toString());
        data.setREMITTANCE_AMOUNT(_remittanceAmount.getText().toString());
        data.setREMITTANCE_RECEIVER_NAME(_remittanceReceiverName.getText().toString());
        data.setCOUNTRY_CODE(countryArray.get(_remittanceCountryCodeSpinner.getSelectedItemPosition()).getCOUNTRY_CODE());
        data.setDAYS_IN_NRB(_remittanceNrbDay.getText().toString());

        String isValidPermit = "";
        switch (_radioGroupRemittanceIsValidVisaPermit.getCheckedRadioButtonId()) {
            case R.id.remittance_is_valid_visa_permit_yes:
                isValidPermit = "1";
                break;
            case R.id.remittance_is_valid_visa_permit_no:
                isValidPermit = "0";
                break;
        }
        data.setIS_VALID_VISA_PERMIT(isValidPermit);
        data.setVISA_WORK_PERMIT_DOC(_remittanceWorkPermitBase64);

        //TODO Image File Set data.setVISA_WORK_PERMIT_DOC(_remittanceWorkPermitFile.setImageBitmap());
        data.setVISA_EXPIRY_DATE(_remittanceVisaDateLine.getText().toString());
        data.setWORK_PERMIT_EXPIRY_DATE(_remittanceWorkPermitDateLine.getText().toString());
        data.setORG_NAME_IN_NRB(_remittanceOrgNameInNrb.getText().toString());
        data.setNRB_PASSPORT(_remittanceNrbPassport.getText().toString());
        data.setREMITTANCE_SLIP_DOC(_remittanceSlipBase64);

    }

    private void saveToLocalStorage() {

        LoanRemittanceInfoBox loanRemittanceInfo = objectBoxManager.GetLoanRemittanceInfoBox(member.getBRANCH_ID(), member.getMEMBER_ID());
        if (loanRemittanceInfo == null) {
            LoanRemittanceInfoBox newData = new LoanRemittanceInfoBox();
            setLoanRemittanceInfoBox(newData);
            objectBoxManager.SaveLoanRemittanceInfoBox(newData);
        } else {
            setLoanRemittanceInfoBox(loanRemittanceInfo);
            objectBoxManager.SaveLoanRemittanceInfoBox(loanRemittanceInfo);
        }
        Intent intent = new Intent(LoanRemitenceActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails", member);
        startActivity(intent);
        finish();
    }

    static final int REQUEST_WORK_PERMIT_DOC = 1000;
    static final int REQUEST_REMITTANCE_SLIP = 1001;

    private void captureWorkPermitDoc() {
        Utils.captureImage(this,REQUEST_WORK_PERMIT_DOC);
    }

    private void captureRemittanceSlip() {
        Utils.captureImage(this,REQUEST_REMITTANCE_SLIP);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // Check for the integer request code originally supplied to startResolutionForResult().

            case REQUEST_WORK_PERMIT_DOC:
                Intent i1 = CropImage.activity(Utils.photoURI)
                        .getIntent(this);
                startActivityForResult(i1, 1);
                break;

            case REQUEST_REMITTANCE_SLIP:
                Intent i2 = CropImage.activity(Utils.photoURI)
                        .getIntent(this);
                startActivityForResult(i2, 2);
                break;
            case 1:
                Bitmap image = Utils.getBitMapImageFromIntent(this,requestCode,resultCode,data);
                if (image != null) {
                    _remittanceWorkPermitFile.setImageBitmap(image);
                    _remittanceWorkPermitBase64 = Utils.convertToBase64(image);
                }
                break;
            case 2:
                Bitmap image1 = Utils.getBitMapImageFromIntent(this,requestCode,resultCode,data);
                if (image1 != null) {
                    _remittanceSlipFile.setImageBitmap(image1);
                    _remittanceSlipBase64 = Utils.convertToBase64(image1);
                }
                break;

        }
    }

    private void loadUIIfAvailable() {
        LoanRemittanceInfoBox data = objectBoxManager.GetLoanRemittanceInfoBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (data != null) {
            _remittanceNrbName.setText(data.getNRB_NAME());
            _remittanceRelationApplicant.setText(data.getRELATION_WITH_APPLICANT());
            _remittanceAmount.setText(data.getREMITTANCE_AMOUNT());
            _remittanceReceiverName.setText(data.getREMITTANCE_RECEIVER_NAME());
            _remittanceNrbDay.setText(data.getDAYS_IN_NRB());

            switch (data.getIS_VALID_VISA_PERMIT()) {

                case "0":
                    _radioGroupRemittanceIsValidVisaPermit.check(R.id.remittance_is_valid_visa_permit_no);
                    break;
                case "1":
                    _radioGroupRemittanceIsValidVisaPermit.check(R.id.remittance_is_valid_visa_permit_yes);
                    break;
            }

            _remittanceVisaDateLine.setText(data.getVISA_EXPIRY_DATE());
            _remittanceWorkPermitDateLine.setText(data.getWORK_PERMIT_EXPIRY_DATE());
            _remittanceOrgNameInNrb.setText(data.getORG_NAME_IN_NRB());
            _remittanceNrbPassport.setText(data.getNRB_PASSPORT());

            if(data.getREMITTANCE_SLIP_DOC() != null)
            {
                _remittanceSlipBase64 = data.getREMITTANCE_SLIP_DOC();
                byte[] decodedString = Base64.decode(data.getREMITTANCE_SLIP_DOC(), Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                _remittanceSlipFile.setImageBitmap(decodedByte);
            }

            if(data.getVISA_WORK_PERMIT_DOC() != null)
            {
                _remittanceWorkPermitBase64 = data.getVISA_WORK_PERMIT_DOC();
                byte[] decodedString = Base64.decode(data.getVISA_WORK_PERMIT_DOC(), Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                _remittanceWorkPermitFile.setImageBitmap(decodedByte);
            }

            try{
                _remittanceCountryCodeSpinner.post(()->{
                    _remittanceCountryCodeSpinner.setSelection(getSelectedCountryItemPosition(data.getCOUNTRY_CODE()));
                });
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private int getSelectedCountryItemPosition(String countryCode){
        for (int i=0; i<countryArray.size(); i++){
            if (countryArray.get(i).getCOUNTRY_CODE().equals(countryCode)){
                return i;
            }
        }
        return 0;
    }

    private void datePicker() {
        _remittanceVisaDateLine.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dateDialog = new DatePickerDialog(LoanRemitenceActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Calendar c = Calendar.getInstance();
                    c.set(Calendar.YEAR, year);
                    c.set(Calendar.MONTH, month);
                    c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    String format = new SimpleDateFormat("dd MMM yyyy").format(c.getTime());
                    _remittanceVisaDateLine.setText(format);
                }
            }, mYear, mMonth, mDay);
            //dateDialog.getDatePicker().setMaxDate(new Date().getTime());
            dateDialog.show();
        });

        _remittanceWorkPermitDateLine.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dateDialog = new DatePickerDialog(LoanRemitenceActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Calendar c = Calendar.getInstance();
                    c.set(Calendar.YEAR, year);
                    c.set(Calendar.MONTH, month);
                    c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    String format = new SimpleDateFormat("dd MMM yyyy").format(c.getTime());
                    _remittanceWorkPermitDateLine.setText(format);
                }
            }, mYear, mMonth, mDay);
            //dateDialog.getDatePicker().setMaxDate(new Date().getTime());
            dateDialog.show();
        });
    }
}
