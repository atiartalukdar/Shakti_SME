package com.sfdw.shaktisme.memberList;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.kyc.KYCBusinessInfoActivity;
import com.sfdw.shaktisme.kyc.KYCBusinessDetailActivity;
import com.sfdw.shaktisme.kyc.KYCFamilyMemberActivity;
import com.sfdw.shaktisme.kyc.KYCPermanentAddressActivity;
import com.sfdw.shaktisme.kyc.KYCPersonalInfoActivity;
import com.sfdw.shaktisme.kyc.KYCPresentAddressActivity;
import com.sfdw.shaktisme.kyc.KYCRelativeBoxActivity;
import com.theartofdev.edmodo.cropper.CropImage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bp.Session;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelForUpload.KYCDM;
import dataModelNew.KYCDMNew;
import dataModelNew.MemberListDM;
import de.hdodenhof.circleimageview.CircleImageView;
import io.objectbox.Box;
import objectBox.KYCBusinessDetailBox;
import objectBox.KYCBusinessInfoBox;
import objectBox.KYCFamilyMemberBox;
import objectBox.KYCPermanentAddressBox;
import objectBox.KYCPersonalInfoBox;
import objectBox.KYCPresentAddressBox;
import objectBox.KYCRelativeBox;
import objectBox.ObjectBox;
import responseDataModel.CommonUploadResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rettrofit.APIInterface;
import rettrofit.APIManager;
import rettrofit.RequestListener;
import rettrofit.RetrofitClientInstance;
import services.KYCManager;
import services.ObjectBoxManager;


public class KYCActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";


    KYCManager _kycManager = new KYCManager();
    APIManager _apiManager = new APIManager();

    @BindView(R.id.custom_member_list_name)
    TextView _memberName;
    @BindView(R.id.custom_member_list_phone_number)
    TextView _mobileNumber;
    @BindView(R.id.custom_member_list_profile_image)
    CircleImageView _profileImage;
    @BindView(R.id.custom_member_list_member_id)
    TextView _memberID;
    @BindView(R.id.custom_member_list_nid)
    TextView _nid;
    @BindView(R.id.custom_member_list_total_loan)
    TextView _totalLoan;
    @BindView(R.id.custom_member_list_total_savings)
    TextView _totalSavings;
    @BindView(R.id.custom_member_list_total_odBalance)
    TextView _totalOverdue;
    @BindView(R.id.memberCardView)
    CardView _memberCardView;
    @BindView(R.id.custom_member_list_personal_info)
    Button _personalInfoBtn;


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MemberListDM.Data member;

    public MemberListDM.Data getMember() {
        member.setCENTER_ID("0000"); //TODO: center id added by hardcoded
        return member;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_details);
        ButterKnife.bind(this);
        member = (MemberListDM.Data) getIntent().getSerializableExtra("memberDetails");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setUpInitialUI();

        //loadMemberKyc();
        _personalInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.showDialog(KYCActivity.this, getString(R.string.uploadKyc)).getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Utils.alert.dismiss();

                        if (!Utils.isNetworkConnected()){
                            Utils.showDialog(KYCActivity.this,"Internet is not available. Please connect with internet.");
                            return;
                        }
                        uploadKyc();
                    }
                });
            }
        });

    }

    private HashMap<Boolean, String> checkMemberKYC(KYCDM kycdm) {

        if (kycdm == null) {
            HashMap<Boolean, String> result = new HashMap<Boolean, String>();
            result.put(false, "Invalid KYC.");
            return result;
        }
        if (kycdm.getPersonalInfo() == null) {
            HashMap<Boolean, String> result = new HashMap<Boolean, String>();
            result.put(false, "Invalid personal info.");
            return result;
        }
        if (kycdm.getBusinessInfo() == null) {
            HashMap<Boolean, String> result = new HashMap<Boolean, String>();
            result.put(false, "Invalid business info.");
            return result;
        }
        if (kycdm.getPresentAddress() == null) {
            HashMap<Boolean, String> result = new HashMap<Boolean, String>();
            result.put(false, "Invalid present address.");
            return result;
        }
        if (kycdm.getPermanentAddress() == null) {
            HashMap<Boolean, String> result = new HashMap<Boolean, String>();
            result.put(false, "Invalid permanent address.");
            return result;
        }
        if (kycdm.getFamilyMemberList() == null) {
            HashMap<Boolean, String> result = new HashMap<Boolean, String>();
            result.put(false, "Invalid family member.");
            return result;
        }
        if (kycdm.getRelative() == null) {
            HashMap<Boolean, String> result = new HashMap<Boolean, String>();
            result.put(false, "Invalid relative info.");
            return result;
        }
        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
        result.put(true, "");
        return result;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new KYCPersonalInfoActivity(), getResources().getString(R.string.kyc_personal_info));
        adapter.addFragment(new KYCPresentAddressActivity(), getResources().getString(R.string.kyc_present_address));
        adapter.addFragment(new KYCPermanentAddressActivity(), getResources().getString(R.string.kyc_parmanent_address));
        adapter.addFragment(new KYCFamilyMemberActivity(), getResources().getString(R.string.kyc_family_member));
        adapter.addFragment(new KYCRelativeBoxActivity(), getResources().getString(R.string.kyc_relative_info));
        adapter.addFragment(new KYCBusinessInfoActivity(), getResources().getString(R.string.kyc_business_info));

        if (getMember().getLEAD_OPTION_ID() == 1 || member.getLEAD_OPTION_ID() == 2 || member.getLEAD_OPTION_ID() == 3) {
            adapter.addFragment(new KYCBusinessDetailActivity(), getResources().getString(R.string.kyc_business_detail));
        }
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    private void setUpInitialUI() {
        try {
            _memberName.setTextColor(Color.BLACK);
            _mobileNumber.setTextColor(Color.BLACK);
            _memberID.setTextColor(Color.BLACK);
            _nid.setTextColor(Color.BLACK);
            _totalLoan.setTextColor(Color.BLACK);
            _totalSavings.setTextColor(Color.BLACK);
            _totalOverdue.setTextColor(Color.BLACK);

            _personalInfoBtn.setText("KYC Upload");
            _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());
            _memberName.setText(member.getMEMBER_NAME());
            _mobileNumber.setText(member.getMOBILE_NO());
            _nid.setText(member.getNID());
            _totalLoan.setText(member.getLOAN_OUTSTANDING() + "/-");
            _totalSavings.setText(member.getTOTAL_SAVINGS() + "/-");
 /*           _totalOverdue.setText( member.getOdBalance() + "/-" );

            if (member.getOdBalance()<=0){
                _totalOverdue.setTextColor(Color.BLACK);
            }if (member.getOdBalance()>0){
                _memberCardView.setBackgroundColor(Color.parseColor("#ECA8A8"));
            }
*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void uploadKyc() {
        KProgressHUD kProgressHUD = Utils.showProgressDialog(this,getResources().getString(R.string.uploading));

        KYCDM kycdm = _kycManager.GetKYCInformation(member.getBRANCH_ID(), member.getMEMBER_ID());
        HashMap<Boolean, String> checkResult = checkMemberKYC(kycdm);
        if (checkResult.containsKey(false)) {
            Utils.showDialog(KYCActivity.this, checkResult.get(false));
        } else {
            _apiManager.createMemberKYC(kycdm, new RequestListener<CommonUploadResponse>() {
                @Override
                public void onSuccess(CommonUploadResponse response) {
                    if (response.getIsSuccessful()) {
                        _kycManager.RemoveKYCInformation(member.getBRANCH_ID(), member.getMEMBER_ID());
                        Utils.showDialog(KYCActivity.this, response.getMessage()).getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(KYCActivity.this, MemberList.class));
                                finish();
                            }
                        });
                    } else {
                        Utils.showDialog(KYCActivity.this, response.getMessage());
                    }
                    kProgressHUD.dismiss();
                }

                @Override
                public void onError(Throwable t) {
                    kProgressHUD.dismiss();
                    Utils.showDialog(KYCActivity.this, t.getMessage());
                }
            });
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MemberList.class));
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Fragment fragment = getSupportFragmentManager().getFragments().get(0);
        fragment.onActivityResult(requestCode, resultCode, data);

    }

}