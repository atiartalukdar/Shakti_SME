package com.sfdw.shaktisme.kyc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.KYCActivity;

import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.MemberListDM;
import interfaces.IObjectBoxManager;
import objectBox.KYCBusinessInfoBox;
import retrofit2.Retrofit;
import rettrofit.APIInterface;
import rettrofit.RetrofitClientInstance;
import services.ObjectBoxManager;

public class KYCBusinessInfoActivity extends Fragment {
    private final String TAG = getClass().getName() + " Atiar - ";

    public KYCBusinessInfoActivity() {
    }


    @BindView(R.id.father_name_tv)           TextView _spouseNameTV;
    @BindView(R.id.ed_father_name)           EditText _spouseName;

    @BindView(R.id.occupation_tv)            TextView   _occupationTV;
    @BindView(R.id.ed_occupation)            EditText   _occupation;

    @BindView(R.id.relation_tv)              TextView _relationSpinner_tv;
    @BindView(R.id.relation_spinner)         Spinner _relationSpinner;

    @BindView(R.id.ed_family_head_name_father_or_father_in_law_tv)      TextView   _FIHeadofFamily_tv;
    @BindView(R.id.ed_family_head_name_father_or_father_in_law)         EditText   _FIHeadofFamily;

    @BindView(R.id.radioFatherOrFatherInLawsHouse)                      RadioGroup _FIisInLaw;
    @BindView(R.id.radioBtnFatherPlace)                                 RadioButton _fathersPlace;
    @BindView(R.id.radioBtnFatherInLawPlace)                            RadioButton _fatherInLawsPlace;

    @BindView(R.id.ed_occupation_father_or_father_in_law_tv)            TextView   _FIShoccupationTV;
    @BindView(R.id.ed_occupation_father_or_father_in_law)               EditText   _FIShoccupation;



    //Visible Items
    @BindView(R.id.topText1)                 TextView _topText1;
    @BindView(R.id.topText2)                 TextView _topText2;


    @BindView(R.id.name_tv)                  TextView _orgNameTV;
    @BindView(R.id.ed_name)                  EditText   _edOrgName;
    @BindView(R.id.ed_road_no)               EditText   _roadNo;
    @BindView(R.id.ed_road_name)             EditText   _roadName;
    @BindView(R.id.ed_house_no)              EditText   _houseNo;
    @BindView(R.id.ed_house_owner_name)      EditText   _houseOwner;
    @BindView(R.id.ed_village)               EditText   _moholla;
    @BindView(R.id.ed_post_office)           EditText _postOffice;
    @BindView(R.id.ed_thana)                 EditText   _thana;
    @BindView(R.id.ed_district)              EditText   _district;
    @BindView(R.id.ed_mobile_number)         EditText   _mobile;

    @BindView(R.id.father_name_tv1)                                     TextView   _fname_tv;
    @BindView(R.id.ed_name_father_or_father_in_law)                     EditText   _fname; //as xOrgName

    @BindView(R.id.ed_house_no_1)                                       EditText   _FIhouseNo;
    //@BindView(R.id.ed_village)                                        EditText   _FIhouseName; //No House Name
    @BindView(R.id.ed_road_no_1)                                        EditText   _FIroadNo;
    @BindView(R.id.ed_road_name_1)                                      EditText   _FIroadName;
    @BindView(R.id.ed_house_owner_name_1)                               EditText   _FIhouseOwner;
    @BindView(R.id.ed_village_1)                                        EditText   _FImohollaOrVillage;
    @BindView(R.id.ed_post_office_1)                                    EditText   _FIpostoffice;
    @BindView(R.id.ed_thana_1)                                          EditText   _FIthana;
    @BindView(R.id.ed_district_1)                                       EditText   _FIdistrict;
    @BindView(R.id.ed_mobile_number_father_or_father_in_law)            EditText   _FImobile;

    @BindView(R.id.saveBtn)                                             Button     _saveBtn;
    private MemberListDM.Data member;

    private IObjectBoxManager _objectBoxManager = new ObjectBoxManager();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.activity_biz_address, container, false);
        ButterKnife.bind(this,v);


        member = ((KYCActivity) getActivity()).getMember();
        hideUItoAdjustBizAddress();

        _saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToLocalStorage();
            }
        });


        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadFormIfDataAvailable();
            }
        });

        return v;
    }

    private void hideUItoAdjustBizAddress(){
        _topText1.setText(R.string.biz_address);
        _topText1.setTextSize(24);
        _topText2.setText(R.string.biz_address_other);
        _topText2.setTextSize(24);
        _orgNameTV.setText(R.string.biz_name);
        _fname_tv.setText(R.string.biz_name);


        _spouseName.setVisibility(View.GONE);
        _spouseNameTV.setVisibility(View.GONE);

        _occupation.setVisibility(View.GONE);
        _occupationTV.setVisibility(View.GONE);

        _relationSpinner_tv.setVisibility(View.GONE);
        _relationSpinner.setVisibility(View.GONE);


        _FIHeadofFamily.setVisibility(View.GONE);
        _FIHeadofFamily_tv.setVisibility(View.GONE);

        _FIisInLaw.setVisibility(View.GONE);

        _FIShoccupationTV.setVisibility(View.GONE);
        _FIShoccupation.setVisibility(View.GONE);

    }

    private void setkycBusinessInfo(KYCBusinessInfoBox data) {
        data.setBranch_id(member.getBRANCH_ID());
        data.setMember_id( member.getMEMBER_ID());
        data.setCenter_id(member.getCENTER_ID());
        data.setOrg_name(_edOrgName.getText().toString());
        data.setHouse_no(_houseNo.getText().toString());
        data.setRoad_no(_roadNo.getText().toString());
        data.setRoad_name(_roadName.getText().toString());
        data.setMoholla(_moholla.getText().toString());
        data.setPosto_ffice(_postOffice.getText().toString());
        data.setThana(_thana.getText().toString());
        data.setDistrict(_district.getText().toString());
        data.setMobile_no(_mobile.getText().toString());

        data.setXorg_name(_fname.getText().toString());
        data.setXhouseno(_FIhouseNo.getText().toString());
        data.setXroadno(_FIroadNo.getText().toString());
        data.setXroadname(_FIroadName.getText().toString());
        data.setXmoholla(_FImohollaOrVillage.getText().toString());
        data.setXpostoffice(_FIpostoffice.getText().toString());
        data.setXthana(_FIthana.getText().toString());
        data.setXdistrict(_FIdistrict.getText().toString());
        data.setXmobileno(_FImobile.getText().toString());
    }

    private void saveDataToLocalStorage(){

        KYCBusinessInfoBox kycBusinessInfo = _objectBoxManager.GetKYCBusinessInfoBoxBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (kycBusinessInfo == null) {
            KYCBusinessInfoBox newData = new KYCBusinessInfoBox();
            setkycBusinessInfo(newData);
            _objectBoxManager.SaveKYCBusinessInfoBox(newData);
        } else {
            setkycBusinessInfo(kycBusinessInfo);
            _objectBoxManager.SaveKYCBusinessInfoBox(kycBusinessInfo);
        }

        Utils.showDialog(getContext(), "Data Saved");

    }

    private void loadFormIfDataAvailable(){

        KYCBusinessInfoBox data = _objectBoxManager.GetKYCBusinessInfoBoxBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (data != null){

                _edOrgName.setText(data.getOrg_name());
                _houseNo.setText(data.getHouse_no());
                _roadNo.setText(data.getRoad_no());
                _roadName.setText(data.getRoad_name());
                //_houseOwner.setText(k.getOrg_name()); //TODO: House Owner Name is missing
                _moholla.setText(data.getMoholla());
                _postOffice.setText(data.getPosto_ffice());
                _thana.setText(data.getThana());
                _district.setText(data.getDistrict());
                _mobile.setText(data.getMobile_no());

                _fname.setText(data.getXorg_name());
                _FIhouseNo.setText(data.getXhouseno());
                _FIroadNo.setText(data.getXroadno());
                _FIroadName.setText(data.getXroadname());
                //_FIhouseOwner.setText(k.getXorg_name());//TODO: House Owner Name is missing
                _FImohollaOrVillage.setText(data.getXmoholla());
                _FIpostoffice.setText(data.getXpostoffice());
                _FIthana.setText(data.getXthana());
                _FIdistrict.setText(data.getXdistrict());
                _FImobile.setText(data.getXmobileno());

        }

    }



}
