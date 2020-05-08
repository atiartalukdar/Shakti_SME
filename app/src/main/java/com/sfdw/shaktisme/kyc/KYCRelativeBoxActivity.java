package com.sfdw.shaktisme.kyc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.KYCActivity;

import java.util.ArrayList;

import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.LoadConfigurationDM;
import dataModelNew.MemberListDM;
import interfaces.IObjectBoxManager;
import objectBox.KYCRelativeBox;

import retrofit2.Retrofit;
import rettrofit.APIInterface;
import rettrofit.RetrofitClientInstance;
import services.ObjectBoxManager;
import services.ServiceManager;

public class KYCRelativeBoxActivity extends Fragment {
    private final String TAG = getClass().getName() + " Atiar - ";
    ServiceManager serviceManager = new ServiceManager();
    public KYCRelativeBoxActivity() {
    }


    @BindView(R.id.ed_name)                  EditText   _nameRelative;
    @BindView(R.id.ed_father_name)           EditText   _fatherName;
    @BindView(R.id.ed_occupation)            EditText   _occupation;
    @BindView(R.id.relation_spinner)         Spinner    _relationSpinner;

    @BindView(R.id.ed_house_no)              EditText   _houseNo;
    @BindView(R.id.ed_road_no)               EditText   _roadNo;
    @BindView(R.id.ed_road_name)             EditText   _roadName;
    @BindView(R.id.ed_house_owner_name)      EditText   _houseOwner;
    @BindView(R.id.ed_village)               EditText   _moholla;
    @BindView(R.id.ed_post_office)           EditText   _postOffice;
    @BindView(R.id.ed_thana)                 EditText   _thana;
    @BindView(R.id.ed_district)              EditText   _district;
    @BindView(R.id.ed_mobile_number)         EditText   _mobile;


    @BindView(R.id.ed_name_father_or_father_in_law)               EditText   _fname;
    @BindView(R.id.ed_family_head_name_father_or_father_in_law)   EditText   _FIHeadofFamily;
    @BindView(R.id.ed_occupation_father_or_father_in_law)         EditText   _FIShoccupation;
    @BindView(R.id.ed_house_no_1)                                 EditText   _FIhouseNo;
    @BindView(R.id.ed_road_no_1)                                  EditText   _FIroadNo;
    @BindView(R.id.ed_road_name_1)                                EditText   _FIroadName;
    @BindView(R.id.ed_house_owner_name_1)                         EditText   _FIhouseOwner;
    @BindView(R.id.ed_village_1)                                  EditText   _FImohollaOrVillage;
    @BindView(R.id.ed_post_office_1)                              EditText   _FIpostoffice;
    @BindView(R.id.ed_thana_1)                                    EditText   _FIthana;
    @BindView(R.id.ed_district_1)                                 EditText   _FIdistrict;
    @BindView(R.id.ed_mobile_number_father_or_father_in_law)      EditText   _FImobile;

    @BindView(R.id.radioFatherOrFatherInLawsHouse)                RadioGroup _FIisInLaw;
    @BindView(R.id.radioBtnFatherPlace)                           RadioButton _fathersPlace;
    @BindView(R.id.radioBtnFatherInLawPlace)                      RadioButton _fatherInLawsPlace;
    @BindView(R.id.saveBtn)    Button _saveBtn;


    Retrofit retrofit;
    APIInterface apiInterface;
    private MemberListDM.Data member;
    private IObjectBoxManager _objectBoxManager = new ObjectBoxManager();

    ArrayList<LoadConfigurationDM.OptionList> relationArray = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.activity_guarantor_information, container, false);
        member = ((KYCActivity) getActivity()).getMember();
        ButterKnife.bind(this,view);

        retrofit = RetrofitClientInstance.getRetrofitInstanceNew();
        apiInterface = retrofit.create(APIInterface.class);
        /*
         * Relation 3
         * education 2
         * job 1
         */
        relationArray.addAll(serviceManager.getOptionList("3"));

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadFormIfDataAvailable();
            }
        });

        ArrayAdapter<LoadConfigurationDM.OptionList> relationTypeAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,relationArray );
        _relationSpinner.setAdapter(relationTypeAdapter);

        _saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToLocalStorage();
            }
        });

        return view;
    }

    private void setkycRelative(KYCRelativeBox data) {
        data.setBranch_id(member.getBRANCH_ID());
        data.setMember_id( member.getMEMBER_ID());
        data.setCenter_id(member.getCENTER_ID());
        
        data.setName(_nameRelative.getText().toString());
        data.setSpouse_name(_fatherName.getText().toString());
        data.setOccupation(_occupation.getText().toString());
        data.setRelation(_relationSpinner.getSelectedItem().toString());
        data.setHouse_no(_houseNo.getText().toString());
        data.setRoadno(_roadNo.getText().toString());
        data.setRoad_name(_roadName.getText().toString());
        data.setHouseo_wner(_houseOwner.getText().toString());
        data.setMoholla(_moholla.getText().toString());
        data.setPost_office(_postOffice.getText().toString());
        data.setThana(_thana.getText().toString());
        data.setDistrict(_district.getText().toString());
        data.setMobile_no(_mobile.getText().toString());

        data.setFathers_name(_fname.getText().toString());
        data.setFilw_head_of_family(_FIHeadofFamily.getText().toString());
        String FIisInLaw        =  "";
        if (_FIisInLaw.getCheckedRadioButtonId() == _fathersPlace.getId()){
            FIisInLaw = "0";
        }else {
            FIisInLaw = "1";
        }
        data.setFilw_isinlaw(Integer.parseInt(FIisInLaw));
        
        data.setFilw_occupation(_FIShoccupation.getText().toString());
        data.setFilw_house_no(_FIhouseNo.getText().toString());
        data.setFilw_house_name("");
        data.setFilw_road_no(_FIroadNo.getText().toString());
        data.setFilw_road_name(_FIroadName.getText().toString());
        data.setFilw_house_owner(_FIhouseOwner.getText().toString());
        data.setFilw_moholla(_FImohollaOrVillage.getText().toString());
        data.setFilw_post_office(_FIpostoffice.getText().toString());
        data.setFilw_thana(_FIthana.getText().toString());
        data.setFilw_district(_FIdistrict.getText().toString());
        data.setFilw_mobile_no(_FImobile.getText().toString());
        
    }

    private void saveDataToLocalStorage(){

        KYCRelativeBox kycRelative = _objectBoxManager.GetKYCRelativeBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (kycRelative == null) {
            KYCRelativeBox newData = new KYCRelativeBox();
            setkycRelative(newData);
            _objectBoxManager.SaveKYCRelativeBox(newData);
        } else {
            setkycRelative(kycRelative);
            _objectBoxManager.SaveKYCRelativeBox(kycRelative);
        }

        Utils.showDialog(getContext(), "Data Saved");
    }

    private void loadFormIfDataAvailable(){
        KYCRelativeBox data = _objectBoxManager.GetKYCRelativeBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (data != null){
            

               /* int location = 0;
                for (int i=0; i<relationArray.size(); i++){
                    if (relationArray.get(i).getOptionName().equals(data.getRelation())){
                        location = i;
                    }
                }*/

                _nameRelative.setText(data.getName());
                _fatherName.setText(data.getSpouse_name());
                _occupation.setText(data.getOccupation());
                //_relationSpinner.setSelection(location); //TODO: Set Spin Array

                _houseNo.setText(data.getHouse_no());
                _roadNo.setText(data.getRoadno());
                _roadName.setText(data.getRoad_name());
                _houseOwner.setText(data.getHouseo_wner());
                _moholla.setText(data.getMoholla());
                _postOffice.setText(data.getPost_office());
                _thana.setText(data.getThana());
                _district.setText(data.getDistrict());
                _mobile.setText(data.getMobile_no());

                _fname.setText(data.getFathers_name());
                _FIHeadofFamily.setText(data.getFilw_head_of_family());
                _FIShoccupation.setText(data.getFilw_occupation());
                _FIhouseNo.setText(data.getFilw_house_no());
                _FIroadNo.setText(data.getFilw_road_no());
                _FIroadName.setText(data.getFilw_road_name());
                _FIhouseOwner.setText(data.getFilw_house_owner());
                _FImohollaOrVillage.setText(data.getFilw_moholla());
                _FIpostoffice.setText(data.getFilw_post_office());
                _FIthana.setText(data.getFilw_thana());
                _FIdistrict.setText(data.getFilw_district());
                _FImobile.setText(data.getFilw_mobile_no());

                switch (data.getFilw_isinlaw()){
                    case 0:
                        _FIisInLaw.check(R.id.radioBtnFatherPlace);
                        break;
                    case 1:
                        _FIisInLaw.check(R.id.radioBtnFatherInLawPlace);
                        break;

                }
            
        }
    }
}

