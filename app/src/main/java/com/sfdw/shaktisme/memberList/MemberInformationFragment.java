package com.sfdw.shaktisme.memberList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.kyc.KYCBusinessInfoActivity;
import com.sfdw.shaktisme.kyc.KYCBusinessDetailActivity;
import com.sfdw.shaktisme.kyc.KYCFamilyMemberActivity;
import com.sfdw.shaktisme.kyc.KYCPermanentAddressActivity;
import com.sfdw.shaktisme.kyc.KYCPersonalInfoActivity;
import com.sfdw.shaktisme.kyc.KYCPresentAddressActivity;
import com.sfdw.shaktisme.kyc.KYCRelativeBoxActivity;

import java.util.ArrayList;
import java.util.List;

import bp.Session;
import bp.Utils;
import dataModelForUpload.KYCDM;
import dataModelNew.MemberListDM;
import io.objectbox.Box;
import objectBox.KYCBusinessDetailBox;
import objectBox.KYCBusinessDetailBox_;
import objectBox.KYCBusinessInfoBox;
import objectBox.KYCBusinessInfoBox_;
import objectBox.KYCFamilyMemberBox;
import objectBox.KYCFamilyMemberBox_;
import objectBox.KYCPermanentAddressBox;
import objectBox.KYCPermanentAddressBox_;
import objectBox.KYCPersonalInfoBox;
import objectBox.KYCPersonalInfoBox_;
import objectBox.KYCPresentAddressBox;
import objectBox.KYCPresentAddressBox_;
import objectBox.KYCRelativeBox;
import objectBox.KYCRelativeBox_;
import objectBox.ObjectBox;
import responseDataModel.CommonUploadResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rettrofit.APIInterface;
import rettrofit.RetrofitClientInstance;

public class MemberInformationFragment extends Fragment {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";


    Retrofit retrofit;
    APIInterface apiInterface;
    private MemberListDM.Data member;


    public MemberInformationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        retrofit = RetrofitClientInstance.getRetrofitInstanceNew();
        apiInterface = retrofit.create(APIInterface.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_information, container, false);


        member = ((KYCActivity) getActivity()).getMember();

        LinearLayout _personalInfo = v.findViewById(R.id.personal_information);
        LinearLayout _presentAddress = v.findViewById(R.id.present_address);
        LinearLayout _parmanentAddress = v.findViewById(R.id.parmanent_address);
        LinearLayout _guarantorInformation = v.findViewById(R.id.guarantor_information);
        LinearLayout _familyMembers = v.findViewById(R.id.family_members);
        LinearLayout _bizAddress1 = v.findViewById(R.id.bizAddress1);
        LinearLayout _bizAddress2 = v.findViewById(R.id.bizAddress2);
        Button _kycUploadBtn = v.findViewById(R.id.uploadKycToServer);



        _kycUploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadInfoToServer();
            }
        });


        _personalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), KYCPersonalInfoActivity.class);
                intent.putExtra("member", ((KYCActivity) getActivity()).getMember());
                startActivity(intent);
            }
        });

        _presentAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), KYCPresentAddressActivity.class);
                intent.putExtra("member", ((KYCActivity) getActivity()).getMember());
                startActivity(intent);
            }
        });

        _parmanentAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), KYCPermanentAddressActivity.class);
                intent.putExtra("member", ((KYCActivity) getActivity()).getMember());
                startActivity(intent);
            }
        });

        _guarantorInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), KYCRelativeBoxActivity.class);
                intent.putExtra("member", ((KYCActivity) getActivity()).getMember());
                startActivity(intent);
            }
        });

        _familyMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), KYCFamilyMemberActivity.class);
                intent.putExtra("member", ((KYCActivity) getActivity()).getMember());
                startActivity(intent);
            }
        });


        //============================== Biz Info ==========================//

        _bizAddress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), KYCBusinessInfoActivity.class);
                intent.putExtra("member", ((KYCActivity) getActivity()).getMember());
                startActivity(intent);
            }
        });

        _bizAddress2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), KYCBusinessDetailActivity.class);
                intent.putExtra("member", ((KYCActivity) getActivity()).getMember());
                startActivity(intent);
            }
        });




        return v;
    }

    private void uploadInfoToServer() {
        Log.e(TAG, "memberID: " +member.getMEMBER_ID());


        Box<KYCPersonalInfoBox> kycPersonalInfoBoxBox = ObjectBox.get().boxFor(KYCPersonalInfoBox.class);
        Box<KYCPresentAddressBox> kycPresentAddressBoxBox = ObjectBox.get().boxFor(KYCPresentAddressBox.class);
        Box<KYCPermanentAddressBox> kycPermanentAddressBoxBox  = ObjectBox.get().boxFor(KYCPermanentAddressBox.class);
        Box<KYCRelativeBox> kycRelativeBoxBox = ObjectBox.get().boxFor(KYCRelativeBox.class);
        Box<KYCFamilyMemberBox> familyMemberListBoxBox  = ObjectBox.get().boxFor(KYCFamilyMemberBox.class);;

        Box<KYCBusinessInfoBox> kycBusinessInfoBoxBox  = ObjectBox.get().boxFor(KYCBusinessInfoBox.class);
        Box<KYCBusinessDetailBox> kycBusinessDetailsBoxBox = ObjectBox.get().boxFor(KYCBusinessDetailBox.class);

        KYCPersonalInfoBox personalData = kycPersonalInfoBoxBox.query().equal(KYCPersonalInfoBox_.member_id,member.getMEMBER_ID() + " ").build().findFirst();
        KYCPresentAddressBox presentAddressData = kycPresentAddressBoxBox.query().equal(KYCPresentAddressBox_.member_id,member.getMEMBER_ID()).build().findFirst();
        KYCPermanentAddressBox permanentAddressData = kycPermanentAddressBoxBox.query().equal(KYCPermanentAddressBox_.member_id,member.getMEMBER_ID()).build().findFirst();
        KYCRelativeBox relativeData = kycRelativeBoxBox.query().equal(KYCRelativeBox_.member_id,member.getMEMBER_ID()).build().findFirst();
        List<KYCFamilyMemberBox> familyMemberListBoxes = familyMemberListBoxBox.query().equal(KYCFamilyMemberBox_.member_id,member.getMEMBER_ID()).order(KYCFamilyMemberBox_.age).build().find();
        KYCBusinessInfoBox businessInfoData = kycBusinessInfoBoxBox.query().equal(KYCBusinessInfoBox_.member_id,member.getMEMBER_ID()).build().findFirst();
        KYCBusinessDetailBox businessDetailsData = kycBusinessDetailsBoxBox.query().equal(KYCBusinessDetailBox_.member_id,member.getMEMBER_ID()).build().findFirst();



        KYCDM kycDMUpload = new KYCDM();

        //........................
        kycDMUpload.setBRANCH_ID(Session.getSeassionDataNew().getData().getBRANCHID());
        kycDMUpload.setMEMBER_ID(member.getMEMBER_ID());
        kycDMUpload.setCENTER_ID(member.getCENTER_ID());




        if (personalData != null){
            Log.e(TAG, "personalData: " + personalData.toString());
            kycDMUpload.setPersonalInfo(personalData);

        }else {
            Log.e(TAG, "personalData: " + "is null");
        }


        if (presentAddressData != null){
            Log.e(TAG, "presentAddressData: " + presentAddressData.toString());
            kycDMUpload.setPresentAddress(presentAddressData);

        }else {
            Log.e(TAG, "presentAddressData: " + "is null");
        }


        if (permanentAddressData != null){
            Log.e(TAG, "permanentAddressData: " + permanentAddressData.toString());
            kycDMUpload.setPermanentAddress(permanentAddressData);

        }else {
            Log.e(TAG, "permanentAddressData: " + "is null");
        }


        if (relativeData != null){
            Log.e(TAG, "relativeData: " + relativeData.toString());
            kycDMUpload.setRelative(relativeData);

        }else {
            Log.e(TAG, "relativeData: " + "is null");
        }


        if (familyMemberListBoxes != null){
            Log.e(TAG, "familyMemberListBoxes: " + familyMemberListBoxes.toString());
            List<KYCFamilyMemberBox> familyMembers = new ArrayList<>();

            for (KYCFamilyMemberBox a : familyMemberListBoxes) {
                familyMembers.add(a);
            }

            kycDMUpload.setFamilyMemberList(familyMembers);

        }else {
            Log.e(TAG, "familyMemberListBoxes: " + "is null");
        }


        if (businessInfoData != null){
            Log.e(TAG, "businessInfoData: " + businessInfoData.toString());
            kycDMUpload.setBusinessInfo(businessInfoData);

        }else {
            Log.e(TAG, "businessInfoData: " + "is null");
        }


        if (businessDetailsData != null){
            Log.e(TAG, "businessDetailsData: " + businessDetailsData.toString());
            kycDMUpload.setBusinessDetail(businessDetailsData);

        }else {
            Log.e(TAG, "businessDetailsData: " + "is null");
        }



        Log.e(TAG, Utils.convetToJsonString(kycDMUpload));


        KProgressHUD kProgressHUD = Utils.showProgressDialog(getActivity(), "Uploading Kyc Information ...");
        Call call = apiInterface.createMemberKYC(Session.getHeaders(), kycDMUpload);


        call.enqueue(new Callback<CommonUploadResponse>() {
            @Override
            public void onResponse(Call<CommonUploadResponse> call, Response<CommonUploadResponse> response) {

                Log.e(TAG, response.toString());
                Log.e(TAG, response.body().toString());

                if (response.body() != null & response.isSuccessful()) {
                    if (response.body().getIsSuccessful()){
                        Utils.showError(TAG,response.body().getMessage());
                    }else {
                        Utils.showError(TAG,"upload error");
                    }

                }

                kProgressHUD.dismiss();

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                kProgressHUD.dismiss();
                Log.e(TAG, call.toString());
            }

        });

    }





}
