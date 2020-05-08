package com.sfdw.shaktisme.kyc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.KYCActivity;

import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.MemberListDM;
import interfaces.IObjectBoxManager;
import objectBox.KYCPermanentAddressBox;
import retrofit2.Retrofit;
import rettrofit.APIInterface;
import rettrofit.RetrofitClientInstance;
import services.ObjectBoxManager;

public class KYCPermanentAddressActivity extends Fragment {

    private final String TAG = getClass().getName() + " Atiar - ";

    public KYCPermanentAddressActivity() {
    }

    @BindView(R.id.ed_house_no)              EditText _houseNo;
    @BindView(R.id.ed_road_no)               EditText _roadNo;
    @BindView(R.id.ed_road_name)             EditText _roadName;
    @BindView(R.id.ed_house_owner_name)      EditText _houseOwnerName;
    @BindView(R.id.ed_village)               EditText _village;
    @BindView(R.id.ed_post_office)           EditText _postOffice;
    @BindView(R.id.ed_thana)                 EditText _thana;
    @BindView(R.id.ed_district)              EditText _district;
    @BindView(R.id.saveBtn)                  Button _saveBtn;

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

        View view = inflater.inflate(R.layout.activity_parmanent_address, container, false);
        member = ((KYCActivity) getActivity()).getMember();
        ButterKnife.bind(this,view);

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

    private void setkycParmanentAddress(KYCPermanentAddressBox data) {
        data.setMember_id(member.getMEMBER_ID());
        data.setBranch_id(member.getBRANCH_ID());
        data.setCenter_id(member.getCENTER_ID());
        data.setHouse_no(_houseNo.getText().toString());
        data.setRoad_no(_roadNo.getText().toString());
        data.setRoad_name(_roadName.getText().toString());
        data.setHouse_owner(_houseOwnerName.getText().toString());
        data.setMoholla(_village.getText().toString());
        data.setPost_office(_postOffice.getText().toString());
        data.setThana(_thana.getText().toString());
        data.setDistrict(_district.getText().toString());
    }

    private void saveDataToLocalStorage(){

        KYCPermanentAddressBox kycPermanentAddress = _objectBoxManager.GetKYCPermanentAddressBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (kycPermanentAddress == null) {
            KYCPermanentAddressBox newData = new KYCPermanentAddressBox();
            setkycParmanentAddress(newData);
            _objectBoxManager.SaveKYCPermanentAddressBox(newData);
        } else {
            setkycParmanentAddress(kycPermanentAddress);
            _objectBoxManager.SaveKYCPermanentAddressBox(kycPermanentAddress);
        }

        Utils.showDialog(getContext(), "Data Saved");

    }

    private void loadFormIfDataAvailable(){
        KYCPermanentAddressBox data = _objectBoxManager.GetKYCPermanentAddressBox(member.getBRANCH_ID(), member.getMEMBER_ID());
        if (data != null){
                _houseNo.setText(data.getHouse_no());
                _roadNo.setText(data.getRoad_no());
                _roadName.setText(data.getRoad_name());
                _houseOwnerName.setText(data.getHouse_owner());
                _village.setText(data.getMoholla());
                _postOffice.setText(data.getPost_office());
                _thana.setText(data.getThana());
                _district.setText(data.getDistrict());
        }
    }
}
