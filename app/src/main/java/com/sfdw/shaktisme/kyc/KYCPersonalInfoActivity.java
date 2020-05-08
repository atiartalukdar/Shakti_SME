package com.sfdw.shaktisme.kyc;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.KYCActivity;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.LoadConfigurationDM;
import dataModelNew.MemberListDM;
import de.hdodenhof.circleimageview.CircleImageView;
import interfaces.IObjectBoxManager;
import objectBox.KYCPersonalInfoBox;
import services.ObjectBoxManager;
import services.ServiceManager;

public class KYCPersonalInfoActivity extends Fragment {
    private final String TAG = getClass().getName() + " Atiar - ";
    ServiceManager serviceManager = new ServiceManager();
    private IObjectBoxManager _objectBoxManager = new ObjectBoxManager();
    private String _profileImageBase64;

    public KYCPersonalInfoActivity() {
    }

    @BindView(R.id.memberID)
    TextView _memberID;
    @BindView(R.id.profile_image)
    CircleImageView _profileImage;
    @BindView(R.id.ed_applicantName)
    EditText _applicantName;
    @BindView(R.id.dateOfBirth)
    TextView _dateOfBirth;
    @BindView(R.id.age)
    EditText _age;
    @BindView(R.id.nid)
    EditText _nid;
    @BindView(R.id.mobileNumber)
    EditText _mobileNumber;
    @BindView(R.id.ed_ocupation)
    EditText _occupation;
    @BindView(R.id.ed_ocupation_experience)
    EditText _occupation_experience;
    @BindView(R.id.education_qualification_spinner)
    Spinner _educationalQualificationSpinner;
    @BindView(R.id.ed_spouse_name)
    EditText _spouseName;
    @BindView(R.id.ed_father_name)
    EditText _fatherName;
    @BindView(R.id.ed_mother_name)
    EditText _motherName;
    @BindView(R.id.ed_passport_number)
    EditText _passportNo;
    @BindView(R.id.ed_driving_license_number)
    EditText _drivingNo;
    @BindView(R.id.mobileNumber1)
    EditText _mobileNumber1;
    @BindView(R.id.radioSex)
    RadioGroup _radioGender;
    @BindView(R.id.ed_income_holder)
    EditText _incomeHolder;
    @BindView(R.id.relation_spinner)
    Spinner _relationSpinner;
    @BindView(R.id.saveBtn)
    Button _saveBtn;

    private MemberListDM.Data member;
    ArrayList<LoadConfigurationDM.OptionList> eduArray = new ArrayList<>();
    ArrayList<LoadConfigurationDM.OptionList> relationArray = new ArrayList<>();

    ArrayAdapter<LoadConfigurationDM.OptionList> edcationalQualificationAdapter;
    ArrayAdapter<LoadConfigurationDM.OptionList> relationTypeAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.activity_personal_information, container, false);
        member = ((KYCActivity) getActivity()).getMember();
        ButterKnife.bind(this, view);

        initializeSpinner();

        loadOptionList();

        loadUnEditableData();

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadFormIfDataAvailable();
            }
        });

        _saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToLocalStorage();
            }
        });

        return view;
    }

    private void initializeSpinner() {
        relationTypeAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, relationArray);
        _relationSpinner.setAdapter(relationTypeAdapter);


        edcationalQualificationAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, eduArray);
        _educationalQualificationSpinner.setAdapter(edcationalQualificationAdapter);

    }

    private void loadOptionList() {
        /*
         * Relation 3
         * education 2
         * job 1
         */

        eduArray.clear();
        eduArray.addAll(serviceManager.getOptionList("2"));

        relationArray.clear();
        relationArray.addAll(serviceManager.getOptionList("3"));

        edcationalQualificationAdapter.notifyDataSetChanged();
        relationTypeAdapter.notifyDataSetChanged();
    }

    private void loadUnEditableData() {
        _memberID.setEnabled(false);
        _profileImage.setEnabled(false);
        _applicantName.setEnabled(false);
        _mobileNumber.setEnabled(false);
        _nid.setEnabled(false);
        _dateOfBirth.setEnabled(false);

        _memberID.setTextColor(Color.BLACK);
        _applicantName.setTextColor(Color.BLACK);
        _mobileNumber.setTextColor(Color.BLACK);
        _nid.setTextColor(Color.BLACK);
        _dateOfBirth.setTextColor(Color.BLACK);

        _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());
        if (member.getMEMBER_PHOTO_URL() == null || member.getMEMBER_PHOTO_URL().equals("")) {
            _profileImage.setEnabled(true);
            _profileImage.setImageResource(R.drawable.profile);
            _profileImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    captureProfilePicture();
                }
            });
        } else {
            Picasso.get()
                    .load(member.getMEMBER_PHOTO_URL())
                    .placeholder(R.drawable.dummy_profile)
                    .error(R.drawable.dummy_profile)
                    .into(_profileImage);
        }
        _applicantName.setText(member.getMEMBER_NAME());
        _mobileNumber.setText(member.getMOBILE_NO());
        _nid.setText(member.getNID());
        _dateOfBirth.setText(member.getDATE_OF_BIRTH());

    }

    private void setKycPersonalInfo(KYCPersonalInfoBox data) {

        data.setBranch_id(member.getBRANCH_ID());
        data.setMember_id(member.getMEMBER_ID());
        data.setCenter_id(member.getCENTER_ID());
        data.setPHOTO_DOC(_profileImageBase64);
        data.setMember_name(member.getMEMBER_NAME());
        data.setDate_of_birth(member.getDATE_OF_BIRTH());
        data.setOccupation(_occupation.getText().toString());
        String experience = _occupation_experience.getText().toString().trim();
        data.setExperience(Integer.parseInt(experience.equals("")? "0" : experience));
        data.setEducation(_educationalQualificationSpinner.getSelectedItem().toString());
        data.setSpouse_name(_spouseName.getText().toString());
        data.setFathers_name(_fatherName.getText().toString());
        data.setMothers_name(_motherName.getText().toString());
        data.setNational_id(member.getNID());
        data.setPassport_no(_passportNo.getText().toString());
        data.setDrivinglicense(_drivingNo.getText().toString());
        data.setMobile_no(member.getMOBILE_NO());
        data.setMobileno2(_mobileNumber1.getText().toString());
        data.setBreadwinner(_incomeHolder.getText().toString());
        data.setRelation(_relationSpinner.getSelectedItem().toString());
        data.setNationality("BD");
    }

    private void saveDataToLocalStorage() {

        KYCPersonalInfoBox kycPersonalInfo = _objectBoxManager.GetKYCPersonalInfoBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (kycPersonalInfo == null) {
            KYCPersonalInfoBox newData = new KYCPersonalInfoBox();
            setKycPersonalInfo(newData);
            _objectBoxManager.SaveKYCPersonalInfoBox(newData);
        } else {
            setKycPersonalInfo(kycPersonalInfo);
            _objectBoxManager.SaveKYCPersonalInfoBox(kycPersonalInfo);
        }

        Utils.showDialog(getContext(), "Data Saved");
    }

    private void loadFormIfDataAvailable() {

        KYCPersonalInfoBox data = _objectBoxManager.GetKYCPersonalInfoBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (data != null) {

            _occupation.setText(data.getOccupation());
            _occupation_experience.setText(data.getExperience().toString());
            _educationalQualificationSpinner.setSelection(eduArray.indexOf(data.getEducation()));
            _spouseName.setText(data.getSpouse_name());
            _fatherName.setText(data.getFathers_name());
            _motherName.setText(data.getMothers_name());
            _passportNo.setText(data.getPassport_no());
            _drivingNo.setText(data.getDrivinglicense());
            _mobileNumber1.setText(data.getMobileno2());
            _incomeHolder.setText(data.getBreadwinner());
            _relationSpinner.setSelection(relationArray.indexOf(data.getRelation()));

            if (data.getPHOTO_DOC() != null) {
                byte[] decodedString = Base64.decode(data.getPHOTO_DOC(), Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                _profileImage.setImageBitmap(decodedByte);
            }
        }

    }

    static final int REQUEST_PROFILE_IMAGE = 1000;
    static final int REQUEST_PROFILE_IMAGE_CROP = 1001;

    private void captureProfilePicture() {
        Utils.captureImage(getActivity(),REQUEST_PROFILE_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            // Check for the integer request code originally supplied to startResolutionForResult().

            case REQUEST_PROFILE_IMAGE:
                Intent i = CropImage.activity(Utils.photoURI)
                        .getIntent(getContext());
                getActivity().startActivityForResult(i,REQUEST_PROFILE_IMAGE_CROP);
                break;
            case REQUEST_PROFILE_IMAGE_CROP:
            case CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE:
                Bitmap image = Utils.getBitMapImageFromIntent(getActivity(),requestCode,resultCode,data);
                if (image != null){
                    _profileImage.setImageBitmap(image);
                    _profileImageBase64 = Utils.convertToBase64(image);
                }
                break;

        }
    }


}
