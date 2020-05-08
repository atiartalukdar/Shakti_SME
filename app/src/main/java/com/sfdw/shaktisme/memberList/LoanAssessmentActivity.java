package com.sfdw.shaktisme.memberList;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.loanInformation.agro.LoanAgroLiveStockActivity;
import com.sfdw.shaktisme.loanInformation.agro.LoanExpenseAgroActivity;
import com.sfdw.shaktisme.loanInformation.agro.LoanIncomeAgroActivity;
import com.sfdw.shaktisme.loanInformation.common.LoanBankAccountActivity;
import com.sfdw.shaktisme.loanInformation.common.LoanCurrentLoanActivity;
import com.sfdw.shaktisme.loanInformation.common.LoanDocumentsActivity;
import com.sfdw.shaktisme.loanInformation.common.LoanFamilyIncomeExpenseAssetActivity;
import com.sfdw.shaktisme.loanInformation.common.LoanGuarantorInfoActivity;
import com.sfdw.shaktisme.loanInformation.common.LoanOtherExpenseActivity;
import com.sfdw.shaktisme.loanInformation.common.LoanOtherIncomeActivity;
import com.sfdw.shaktisme.loanInformation.common.LoanPropertyValueActivity;
import com.sfdw.shaktisme.loanInformation.common.LoanQualitativeAssessmentActivity;
import com.sfdw.shaktisme.loanInformation.remittance.LoanRemitenceActivity;
import com.sfdw.shaktisme.loanInformation.salaryAndRental.LoanExpenseBasedIncomeActivity;
import com.sfdw.shaktisme.loanInformation.salaryAndRental.LoanIncomeBasedIncomeActivity;
import com.sfdw.shaktisme.loanInformation.tradeAndManufactoring.LoanBusinessSaleActivity;
import com.sfdw.shaktisme.loanInformation.tradeAndManufactoring.LoanCostOfGoodsActivity;
import com.sfdw.shaktisme.loanInformation.tradeAndManufactoring.LoanCreditorActivity;
import com.sfdw.shaktisme.loanInformation.tradeAndManufactoring.LoanDebtorActivity;
import com.sfdw.shaktisme.loanInformation.tradeAndManufactoring.LoanEquipmentValueActivity;
import com.sfdw.shaktisme.loanInformation.tradeAndManufactoring.LoanFundWithdrawActivity;
import com.sfdw.shaktisme.loanInformation.tradeAndManufactoring.LoanStockOfGoodsActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import adapters.BusinessHomePageGridViewAdapter;
import bp.MyGridView;
import bp.Session;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dataModel.BusinessHomePageDataModel;
import dataModelForUpload.LoanAgroDM;
import dataModelForUpload.LoanApplicationDM;
import dataModelForUpload.LoanRemittanceDM;
import dataModelForUpload.LoanSalariedRentalBasedIncomeDM;
import dataModelForUpload.LoanTradeManufactoringDM;
import dataModelNew.MemberListDM;
import de.hdodenhof.circleimageview.CircleImageView;
import io.objectbox.Box;
import objectBox.LoanApplicationBox;
import objectBox.LoanApplicationBox_;
import objectBox.ObjectBox;
import responseDataModel.CommonUploadResponse;
import retrofit2.Retrofit;
import rettrofit.APIInterface;
import rettrofit.APIManager;
import rettrofit.RequestListener;
import rettrofit.RetrofitClientInstance;
import services.LoanApplicationManager;
import services.ServiceManager;

public class LoanAssessmentActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ServiceManager _serviceManager = new ServiceManager();
    APIManager _apiManager = new APIManager();

    @BindView(R.id.custom_member_item)
    LinearLayout _topMemberInfoItem;
    @BindView(R.id.biz_info_member_photo)
    CircleImageView _memberPhoto;
    @BindView(R.id.biz_info_member_name)
    TextView _memberName;
    @BindView(R.id.biz_info_member_phone)
    TextView _memberPhone;
    @BindView(R.id.biz_info_member_id)
    TextView _memberID;
    @BindView(R.id.biz_info_member_nid)
    TextView _memberNID;
    @BindView(R.id.biz_info_member_prokolpo)
    TextView _memberProkolpo;
    @BindView(R.id.biz_info_loan_amount)
    TextView _memberLoanAmount;
    @BindView(R.id.biz_info_service_charge_percentage)
    TextView _memberInterestRate;
    @BindView(R.id.biz_info_kistir_dhoron)
    TextView _memberEMIType;
    @BindView(R.id.biz_info_number_of_EMI)
    TextView _memberEMIDuration;
    @BindView(R.id.biz_info_grid_view_1)
    MyGridView _gridView1;
    @BindView(R.id.biz_info_grid_view_2)
    GridView _gridView2;
    @BindView(R.id.uploadBizInfoToServer)
    Button _uploadBizInfoToServer;

    public MemberListDM.Data member;
    BusinessHomePageGridViewAdapter adapterPart1;
    BusinessHomePageGridViewAdapter adapterPart2;
    Box<LoanApplicationBox> applicationDetailBoxBox;
    Retrofit retrofit;
    APIInterface apiInterface;
    int leadOptionID = 0;

    public MemberListDM.Data getMember() {
        member.setCENTER_ID("0000"); //TODO: center id added by hardcoded
        return member;
    }

    List<BusinessHomePageDataModel> viewDataCommon = new ArrayList<>();
    List<BusinessHomePageDataModel> viewDataForTread = new ArrayList<>();
    List<BusinessHomePageDataModel> viewDataForDeiry = new ArrayList<>();
    List<BusinessHomePageDataModel> viewDataForManufacture = new ArrayList<>();
    List<BusinessHomePageDataModel> viewDataForSalaried = new ArrayList<>();
    List<BusinessHomePageDataModel> viewDataForRent = new ArrayList<>();
    List<BusinessHomePageDataModel> viewDataForRemittance = new ArrayList<>();
    List<BusinessHomePageDataModel> part2AlwaysSame = new ArrayList<>();

    private void updateInitialUI() {

        try {

            int leadOptionID = (int) Math.round(member.getLEAD_OPTION_ID());
            _memberName.setText(member.getMEMBER_NAME() + " ");
            _memberID.setText("Member ID: " + member.getMEMBER_ID() + " ");
            _memberNID.setText("NID: " + member.getNID() + " ");
            _memberPhone.setText(member.getMOBILE_NO() + " ");
            _memberProkolpo.setText(getString(R.string.biz_info_prokolpo) + _serviceManager.getLeadOptionObject(leadOptionID).getOPTIONNAMEBN() + " ");

            if (member.getMEMBER_PHOTO_URL() == null || member.getMEMBER_PHOTO_URL().equals("")) {
                _memberPhoto.setImageResource(R.drawable.dummy_profile);
            } else {
                // thumbnail image
                Picasso.get()
                        .load(member.getMEMBER_PHOTO_URL())
                        .placeholder(R.drawable.dummy_profile)
                        .error(R.drawable.dummy_profile)
                        .into(_memberPhoto);
            }

            LoanApplicationBox l = applicationDetailBoxBox.query().equal(LoanApplicationBox_.MEMBER_ID, member.getMEMBER_ID()).build().findFirst();
            if (l != null) {
                _memberLoanAmount.setText(l.getREQUEST_AMOUNT() + " ");
                _memberInterestRate.setText(l.getINTEREST_RATE() + " ");
                _memberEMIType.setText(l.getINSTALLMENT_TYPE() + " ");
                _memberEMIDuration.setText(l.getLOAN_DURATION() + " ");

            }


        } catch (Exception e) {
            Log.e(TAG, "Getting issue when updating Initial UI" + e.getMessage());
            e.printStackTrace();
        }


    }

    //LeadOption ID 1 : Tread  34
    //LeadOption ID 2 : Dairy 34
    //LeadOption ID 3 : Manufacturing 34
    //LeadOption ID 4 : Salary 35
    //LeadOption ID 5 : Rental 35
    //LeadOption ID 6 : Remittance
    private void initializeObjectBox() {
        applicationDetailBoxBox = ObjectBox.get().boxFor(LoanApplicationBox.class);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_home_page);
        ButterKnife.bind(this);
        initializeObjectBox();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        retrofit = RetrofitClientInstance.getRetrofitInstanceNew();
        apiInterface = retrofit.create(APIInterface.class);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    //retriving lead member's details from intent to start pre screening
                    member = (MemberListDM.Data) getIntent().getSerializableExtra("memberDetails");
                    Log.e(TAG, "Member ID: " + member.getMEMBER_ID());
                    Log.e(TAG, "LoanType: " + member.getLEAD_OPTION_ID());

                    updateInitialUI();
                    initializeUIData();
                    loadAdapterByLeadOptionID();

                    adapterPart1.notifyDataSetChanged();
                    adapterPart2.notifyDataSetChanged();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        allOnClick();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (_memberLoanAmount.getText().length() <= 0){
            poupMemberApplicationInfo();
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MemberList.class);
        startActivity(i);
        finish();
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private void loadAdapterByLeadOptionID() {

        adapterPart2 = new BusinessHomePageGridViewAdapter(this, part2AlwaysSame);
        _gridView2.setAdapter(adapterPart2);

        leadOptionID = (int) Math.round(member.getLEAD_OPTION_ID());

        switch (leadOptionID) {
            case 1:     //LeadOption ID 1 : Tread  34
                adapterPart1 = new BusinessHomePageGridViewAdapter(this, viewDataForTread);
                _gridView1.setAdapter(adapterPart1);
                break;
            case 2:     //LeadOption ID 2 : Dairy 34
                adapterPart1 = new BusinessHomePageGridViewAdapter(this, viewDataForDeiry);
                _gridView1.setAdapter(adapterPart1);
                break;
            case 3:     //LeadOption ID 3 : Manufacturing 34
                adapterPart1 = new BusinessHomePageGridViewAdapter(this, viewDataForManufacture);
                _gridView1.setAdapter(adapterPart1);
                break;
            case 4:     //LeadOption ID 4 : Salary 35
                adapterPart1 = new BusinessHomePageGridViewAdapter(this, viewDataForSalaried);
                _gridView1.setAdapter(adapterPart1);
                break;
            case 5:     //LeadOption ID 5 : Rental 35
                adapterPart1 = new BusinessHomePageGridViewAdapter(this, viewDataForRent);
                _gridView1.setAdapter(adapterPart1);
                break;
            case 6:     //LeadOption ID 6 : Remittance
                adapterPart1 = new BusinessHomePageGridViewAdapter(this, viewDataForRemittance);
                _gridView1.setAdapter(adapterPart1);
                break;

        }


    }

    private void initializeUIData() {
        //viewData for common
        viewDataCommon.add(new BusinessHomePageDataModel(R.drawable.biz_info_bank_info, getString(R.string.biz_info_bank_account_details)));
        viewDataCommon.add(new BusinessHomePageDataModel(R.drawable.biz_info_others_loan, getString(R.string.biz_info_others_loan)));
        viewDataCommon.add(new BusinessHomePageDataModel(R.drawable.biz_info_family_income_expense, getString(R.string.biz_info_family_income_expense_details)));
        viewDataCommon.add(new BusinessHomePageDataModel(R.drawable.biz_info_others_expense, getString(R.string.biz_info_others_cost)));
        viewDataCommon.add(new BusinessHomePageDataModel(R.drawable.biz_info_income, getString(R.string.biz_info_others_income)));
        viewDataCommon.add(new BusinessHomePageDataModel(R.drawable.biz_info_land_price, getString(R.string.biz_info_land_price)));


        //this part will be always same, no need to be changed
        part2AlwaysSame.add(new BusinessHomePageDataModel(R.drawable.biz_info_nothi_pottro, getString(R.string.biz_info_papers_and_images)));
        //part2AlwaysSame.add(new BusinessHomePageDataModel(R.drawable.guranter, getString(R.string.biz_info_gunonoto_mullayon)));
        part2AlwaysSame.add(new BusinessHomePageDataModel(R.drawable.biz_info_quality, getString(R.string.biz_info_guarantor_information)));
        //part2AlwaysSame.add(new BusinessHomePageDataModel(R.drawable.biz_info_comment, getString(R.string.biz_info_comments)));


        //LeadOption ID 1 : Tread  34
        viewDataForTread.add(new BusinessHomePageDataModel(R.drawable.sell, getString(R.string.biz_info_sell)));
        viewDataForTread.add(new BusinessHomePageDataModel(R.drawable.taka, getString(R.string.biz_info_raw_meterials_price)));
        viewDataForTread.add(new BusinessHomePageDataModel(R.drawable.biz_info_baki_sell, getString(R.string.biz_info_baki_sell)));
        viewDataForTread.add(new BusinessHomePageDataModel(R.drawable.biz_info_baki_buy, getString(R.string.biz_info_baki_buy)));
        viewDataForTread.add(new BusinessHomePageDataModel(R.drawable.biz_info_decoration_price, getString(R.string.biz_info_decoration)));
        viewDataForTread.add(new BusinessHomePageDataModel(R.drawable.biz_info_fund_withdraw, getString(R.string.biz_info_fund_uttolon)));
        viewDataForTread.add(new BusinessHomePageDataModel(R.drawable.biz_info_ponner_mojud, getString(R.string.biz_info_ponner_mojud)));
        viewDataForTread.addAll(viewDataCommon);


        //LeadOption ID 2 : Dairy 34
        //TODO: need to add dairy datas, common are already added below
        viewDataForDeiry.add(new BusinessHomePageDataModel(R.drawable.biz_info_income, getString(R.string.agro_info_income)));
        viewDataForDeiry.add(new BusinessHomePageDataModel(R.drawable.biz_infop_expense, getString(R.string.agro_info_expense)));
        viewDataForDeiry.add(new BusinessHomePageDataModel(R.drawable.biz_info_ponner_mojud, getString(R.string.agro_live_stock)));
        viewDataForDeiry.add(new BusinessHomePageDataModel(R.drawable.biz_info_fund_withdraw, getString(R.string.biz_info_fund_uttolon)));
        viewDataForDeiry.addAll(viewDataCommon);

        //LeadOption ID 3 : Manufacturing 34
        viewDataForManufacture.addAll(viewDataForTread);

        //LeadOption ID 4 : Salary 35
        viewDataForSalaried.add(new BusinessHomePageDataModel(R.drawable.biz_info_income, getString(R.string.biz_info_income_details)));
        viewDataForSalaried.add(new BusinessHomePageDataModel(R.drawable.biz_infop_expense, getString(R.string.biz_info_expense_details)));
        viewDataForSalaried.addAll(viewDataCommon);

        //For rental / Lead Type 5
        viewDataForRent.addAll(viewDataForSalaried);

        //LeadOption ID 6 : Remittance
        viewDataForRemittance.add(new BusinessHomePageDataModel(R.drawable.biz_info_income, getString(R.string.remittance_info)));
        viewDataForRemittance.add(new BusinessHomePageDataModel(R.drawable.biz_infop_expense, getString(R.string.biz_info_expense_details)));
        viewDataForRemittance.addAll(viewDataCommon);

    }

    private void allOnClick() {
        _topMemberInfoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poupMemberApplicationInfo();
            }
        });

        //No Need to change
        _gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // নথিপত্র ও ছবি
                if (part2AlwaysSame.get(position).getItemName().equals(getString(R.string.biz_info_papers_and_images))) {
                    Intent intent = new Intent(v.getContext(), LoanDocumentsActivity.class);
                    intent.putExtra("member", member);
                    startActivity(intent);
                }//গুনগত মুল্যায়ন
                else if (part2AlwaysSame.get(position).getItemName().equals(getString(R.string.biz_info_gunonoto_mullayon))) {
                    Intent intent = new Intent(v.getContext(), LoanQualitativeAssessmentActivity.class);
                    intent.putExtra("member", member);
                    startActivity(intent);
                }//জামিনদারের তথ্য
                else if (part2AlwaysSame.get(position).getItemName().equals(getString(R.string.biz_info_guarantor_information))) {
                    Intent intent = new Intent(v.getContext(), LoanGuarantorInfoActivity.class);
                    intent.putExtra("member", member);
                    startActivity(intent);
                }
            }
        });

        //All loan info
        _gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                int commonViewPosition = 0;
                switch (leadOptionID) {
                    case 1:
                        //For Tread items onClick
                        if (viewDataForTread.get(position).getItemName().equals(getString(R.string.biz_info_sell))) {
                            Intent intent = new Intent(v.getContext(), LoanBusinessSaleActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        }//ব্যবসায় বিক্রয়
                        else if (viewDataForTread.get(position).getItemName().equals(getString(R.string.biz_info_raw_meterials_price))) {
                            Intent intent = new Intent(v.getContext(), LoanCostOfGoodsActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } //কাঁচামাল/পন্যের দাম
                        else if (viewDataForTread.get(position).getItemName().equals(getString(R.string.biz_info_baki_sell))) {
                            Intent intent = new Intent(v.getContext(), LoanDebtorActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } else if (viewDataForTread.get(position).getItemName().equals(getString(R.string.biz_info_baki_buy))) {
                            Intent intent = new Intent(v.getContext(), LoanCreditorActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        }//বাকিতে কেনা
                        else if (viewDataForTread.get(position).getItemName().equals(getString(R.string.biz_info_decoration))) {
                            Intent intent = new Intent(v.getContext(), LoanEquipmentValueActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        }//সাজসরঞ্জামের মুল্য
                        else if (viewDataForTread.get(position).getItemName().equals(getString(R.string.biz_info_fund_uttolon))) {
                            Intent intent = new Intent(v.getContext(), LoanFundWithdrawActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } //অর্থ উত্তলন
                        else if (viewDataForTread.get(position).getItemName().equals(getString(R.string.biz_info_ponner_mojud))) {
                            Intent intent = new Intent(v.getContext(), LoanStockOfGoodsActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } //কাঁচামাল/পন্যের মজুদ
                        commonViewPosition = position - 7;
                        break;
                    case 2:
                        //For Dairy items onClick
                        //TODO: ui is not added yet
                        if (viewDataForDeiry.get(position).getItemName().equals(getString(R.string.agro_info_income))) {
                            Intent intent = new Intent(v.getContext(), LoanIncomeAgroActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } else if (viewDataForDeiry.get(position).getItemName().equals(getString(R.string.agro_info_expense))) {
                            Intent intent = new Intent(v.getContext(), LoanExpenseAgroActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } else if (viewDataForDeiry.get(position).getItemName().equals(getString(R.string.agro_live_stock))) {
                            Intent intent = new Intent(v.getContext(), LoanAgroLiveStockActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } else if (viewDataForDeiry.get(position).getItemName().equals(getString(R.string.biz_info_fund_uttolon))) {
                            Intent intent = new Intent(v.getContext(), LoanFundWithdrawActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        }
                        commonViewPosition = position - 4;

                        break;
                    case 3:
                        if (viewDataForManufacture.get(position).getItemName().equals(getString(R.string.biz_info_sell))) {
                            Intent intent = new Intent(v.getContext(), LoanBusinessSaleActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        }//ব্যবসায় বিক্রয়
                        else if (viewDataForManufacture.get(position).getItemName().equals(getString(R.string.biz_info_raw_meterials_price))) {
                            Intent intent = new Intent(v.getContext(), LoanCostOfGoodsActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } //কাঁচামাল/পন্যের দাম
                        else if (viewDataForManufacture.get(position).getItemName().equals(getString(R.string.biz_info_baki_sell))) {
                            Intent intent = new Intent(v.getContext(), LoanDebtorActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } else if (viewDataForManufacture.get(position).getItemName().equals(getString(R.string.biz_info_baki_buy))) {
                            Intent intent = new Intent(v.getContext(), LoanCreditorActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        }//বাকিতে কেনা
                        else if (viewDataForManufacture.get(position).getItemName().equals(getString(R.string.biz_info_decoration))) {
                            Intent intent = new Intent(v.getContext(), LoanEquipmentValueActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        }//সাজসরঞ্জামের মুল্য
                        else if (viewDataForManufacture.get(position).getItemName().equals(getString(R.string.biz_info_fund_uttolon))) {
                            Intent intent = new Intent(v.getContext(), LoanFundWithdrawActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } //অর্থ উত্তলন
                        else if (viewDataForManufacture.get(position).getItemName().equals(getString(R.string.biz_info_ponner_mojud))) {
                            Intent intent = new Intent(v.getContext(), LoanStockOfGoodsActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } //কাঁচামাল/পন্যের মজুদ
                        commonViewPosition = position - 7;

                        break;
                    case 4:
                        if (viewDataForSalaried.get(position).getItemName().equals(getString(R.string.biz_info_income_details))) {
                            Intent intent = new Intent(v.getContext(), LoanIncomeBasedIncomeActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } //আয় এর বিবরন
                        else if (viewDataForSalaried.get(position).getItemName().equals(getString(R.string.biz_info_expense_details))) {
                            Intent intent = new Intent(v.getContext(), LoanExpenseBasedIncomeActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } //ব্যয় এর বিবরন
                        commonViewPosition = position - 2;

                        break;
                    case 5:
                        if (viewDataForRent.get(position).getItemName().equals(getString(R.string.biz_info_income_details))) {
                            Intent intent = new Intent(v.getContext(), LoanIncomeBasedIncomeActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } //আয় এর বিবরন
                        else if (viewDataForRent.get(position).getItemName().equals(getString(R.string.biz_info_expense_details))) {
                            Intent intent = new Intent(v.getContext(), LoanExpenseBasedIncomeActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } //ব্যয় এর বিবরন
                        commonViewPosition = position - 2;

                        break;
                    case 6:
                        //For Remittance items onClick

                        if (viewDataForRemittance.get(position).getItemName().equals(getString(R.string.remittance_info))) {
                            Intent intent = new Intent(v.getContext(), LoanRemitenceActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        } else if (viewDataForRemittance.get(position).getItemName().equals(getString(R.string.biz_info_expense_details))) {
                            Intent intent = new Intent(v.getContext(), LoanExpenseBasedIncomeActivity.class);
                            intent.putExtra("member", member);
                            startActivity(intent);
                        }
                        commonViewPosition = position - 2;

                        break;

                }

                try {
                    //Common UI onClickEvent
                    if (viewDataCommon.get(commonViewPosition).getItemName().equals(getString(R.string.biz_info_bank_account_details))) {
                        Intent intent = new Intent(v.getContext(), LoanBankAccountActivity.class);
                        intent.putExtra("member", member);
                        startActivity(intent);
                    }//ব্যাঙ্ক অ্যাকাউন্টের তথ্যাদি
                    else if (viewDataCommon.get(commonViewPosition).getItemName().equals(getString(R.string.biz_info_others_loan))) {
                        Intent intent = new Intent(v.getContext(), LoanCurrentLoanActivity.class);
                        intent.putExtra("member", member);
                        startActivity(intent);
                    }//অন্যান্য বর্তমান ঋণ
                    else if (viewDataCommon.get(commonViewPosition).getItemName().equals(getString(R.string.biz_info_family_income_expense_details))) {
                        Intent intent = new Intent(v.getContext(), LoanFamilyIncomeExpenseAssetActivity.class);
                        intent.putExtra("member", member);
                        startActivity(intent);
                    }//পারিবারিক আয়,ব্যয় ও সম্পত্তির বিবরন
                    else if (viewDataCommon.get(commonViewPosition).getItemName().equals(getString(R.string.biz_info_others_cost))) {
                        Intent intent = new Intent(v.getContext(), LoanOtherExpenseActivity.class);
                        intent.putExtra("member", member);
                        startActivity(intent);
                    }//পাওনা/বাকিতে দেয়া
                    else if (viewDataCommon.get(commonViewPosition).getItemName().equals(getString(R.string.biz_info_others_income))) {
                        Intent intent = new Intent(v.getContext(), LoanOtherIncomeActivity.class);
                        intent.putExtra("member", member);
                        startActivity(intent);
                    }//অন্যান্য আয়
                    else if (viewDataCommon.get(commonViewPosition).getItemName().equals(getString(R.string.biz_info_land_price))) {
                        Intent intent = new Intent(v.getContext(), LoanPropertyValueActivity.class);
                        intent.putExtra("member", member);
                        startActivity(intent);
                    }//ভুসম্পত্তির মূল্য
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

    }

    // =========================   Popup dialog view. =====================

    ArrayList<String> duration = new ArrayList<>();
    ArrayAdapter<String> durationAdapter;
    View popupInputDialogView = null;
    private EditText _loanAmount = null;
    private EditText _serviceCharge = null;
    private EditText _emiType = null;
    private Spinner _durationSpinner = null;
    private Button _save = null;
    private Button _cancelInput = null;

    private void poupMemberApplicationInfo() {
        //======================    /* Initialize popup dialog view and ui controls in the popup dialog. */   =====================

        // Get layout inflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(LoanAssessmentActivity.this);
        popupInputDialogView = layoutInflater.inflate(R.layout.custom_popup_member_sf_application, null);

        // Get user input edittext and button ui controls in the popup dialog.
        _loanAmount = popupInputDialogView.findViewById(R.id.custom_dialog_member_application_loan_amount);
        _serviceCharge = popupInputDialogView.findViewById(R.id.custom_dialog_member_application_service_charge);
        _emiType = popupInputDialogView.findViewById(R.id.custom_dialog_member_application_emi_type);
        _durationSpinner = popupInputDialogView.findViewById(R.id.custom_dialog_member_application_duration_spinner);
        _save = popupInputDialogView.findViewById(R.id.button_save_user_data);
        _cancelInput = popupInputDialogView.findViewById(R.id.button_cancel_user_data);


        durationAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, duration);
        _durationSpinner.setAdapter(durationAdapter);


        //adding duration data to spinner
        //int maxDuration = leadOptionsData.get  //TODO: need to add maxDuration from leadOptinosData
        int maxDuration = 24;
        duration.clear();
        switch (maxDuration) {
            case 24:
                duration.add(12 + "");
                duration.add(18 + "");
                duration.add(24 + "");
                break;
            case 18:
                duration.add(12 + "");
                duration.add(18 + "");
                break;
            case 12:
                duration.add(12 + "");
                break;
        }

        durationAdapter.notifyDataSetChanged();

        durationAdapter.notifyDataSetChanged();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoanAssessmentActivity.this);
        alertDialogBuilder.setTitle("Add Loan Info");
        alertDialogBuilder.setIcon(R.drawable.logo);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setView(popupInputDialogView);
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        _save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validate()){
                    return;
                }
                // Get user data from popup dialog editeext.
                String loanAmount = _loanAmount.getText().toString();
                String serviceCharge = _serviceCharge.getText() + "";
                String emiType = "M";
                String durationMonths = _durationSpinner.getSelectedItem() + "";

                LoanApplicationBox applicationData = new LoanApplicationBox();
                applicationData.setMEMBER_ID(member.getMEMBER_ID());
                applicationData.setBRANCH_ID(member.getBRANCH_ID());
                applicationData.setCENTER_ID(member.getCENTER_ID());

                applicationData.setRO_ID(Session.getUserID());
                applicationData.setREQUEST_AMOUNT(loanAmount);
                applicationData.setINTEREST_RATE(serviceCharge);
                applicationData.setINSTALLMENT_TYPE(emiType);
                applicationData.setLOAN_DURATION(durationMonths);
                applicationData.setLEAD_OPTION_ID(leadOptionID);

                if (applicationDetailBoxBox.query().equal(LoanApplicationBox_.MEMBER_ID, member.getMEMBER_ID()).build().findFirst() != null) {
                    Box<LoanApplicationBox> oldDataBox = ObjectBox.get().boxFor(LoanApplicationBox.class);
                    LoanApplicationBox oldData = oldDataBox.query().equal(LoanApplicationBox_.MEMBER_ID, member.getMEMBER_ID()).build().findFirst();

                    oldData.setMEMBER_ID(member.getMEMBER_ID());
                    oldData.setBRANCH_ID(member.getBRANCH_ID());
                    oldData.setCENTER_ID(member.getCENTER_ID());
                    oldData.setRO_ID(Session.getUserID());
                    oldData.setREQUEST_AMOUNT(loanAmount);
                    oldData.setINTEREST_RATE(serviceCharge);
                    oldData.setINSTALLMENT_TYPE(emiType);
                    oldData.setLOAN_DURATION(durationMonths);
                    oldData.setLEAD_OPTION_ID(member.getLEAD_OPTION_ID());

                    oldDataBox.put(oldData);
                } else {
                    applicationDetailBoxBox.put(applicationData);
                }

                _memberLoanAmount.setText(loanAmount);
                _memberInterestRate.setText(serviceCharge);
                _memberEMIType.setText(emiType);
                _memberEMIDuration.setText(durationMonths);

                alertDialog.cancel();
            }
        });
        _cancelInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.cancel();
            }
        });
    }

    // =========================   To Upload on server. =====================

    public void uploadBizInfoToServer() throws Exception{
        if (!Utils.isNetworkConnected()) {
            Utils.showDialog(this, "Internet is not available. Please connect with internet.");
            return;
        }

        KProgressHUD kProgressHUD = Utils.showProgressDialog(LoanAssessmentActivity.this, getResources().getString(R.string.uploading));

        LoanApplicationManager loanApplicationManager = new LoanApplicationManager();
        HashMap<Boolean, String> checkResult = checkMemberLoanAssement(loanApplicationManager);
        if (checkResult.containsKey(false)) {
            kProgressHUD.dismiss();
            Utils.showDialog(LoanAssessmentActivity.this, checkResult.get(false));
        } else {
            try {
                switch (leadOptionID) {

                    case 2:
                        KProgressHUD kProgressHUD2 = Utils.showProgressDialog(LoanAssessmentActivity.this, getResources().getString(R.string.uploading));
                        LoanAgroDM loanAgro = loanApplicationManager.GetAgroLoan(member.getBRANCH_ID(), member.getMEMBER_ID());
                        _apiManager.createAgroLoan(loanAgro, new RequestListener<CommonUploadResponse>() {
                            @Override
                            public void onSuccess(CommonUploadResponse response) {
                                kProgressHUD2.dismiss();
                                if (response.getIsSuccessful()) {
                                    loanApplicationManager.RemoveLoanAgro(member.getBRANCH_ID(), member.getMEMBER_ID());
                                    uploadSuccessfull();
                                } else {
                                    Utils.showDialog(LoanAssessmentActivity.this, response.getMessage());
                                }
                            }

                            @Override
                            public void onError(Throwable t) {
                                kProgressHUD2.dismiss();
                                Utils.showDialog(LoanAssessmentActivity.this, t.getMessage());
                            }
                        });
                        break;
                    case 1:
                    case 3:
                        KProgressHUD kProgressHUD3 = Utils.showProgressDialog(LoanAssessmentActivity.this, getResources().getString(R.string.uploading));
                        LoanTradeManufactoringDM loanManufactoring = loanApplicationManager.GetTradeManufactoringLoan(member.getBRANCH_ID(), member.getMEMBER_ID());
                        _apiManager.createTradeAndManufacturingLoan(loanManufactoring, new RequestListener<CommonUploadResponse>() {
                            @Override
                            public void onSuccess(CommonUploadResponse response) {
                                kProgressHUD3.dismiss();
                                if (response.getIsSuccessful()) {
                                    loanApplicationManager.RemoveLoanTradeManufactoring(member.getBRANCH_ID(), member.getMEMBER_ID());
                                    uploadSuccessfull();
                                } else {
                                    Utils.showDialog(LoanAssessmentActivity.this, response.getMessage());
                                }
                            }

                            @Override
                            public void onError(Throwable t) {
                                kProgressHUD3.dismiss();
                                Utils.showDialog(LoanAssessmentActivity.this, t.getMessage());
                            }
                        });
                        break;

                    case 4:
                    case 5:
                        KProgressHUD kProgressHUD5 = Utils.showProgressDialog(LoanAssessmentActivity.this, getResources().getString(R.string.uploading));
                        LoanSalariedRentalBasedIncomeDM loanRentalBasedIncome = loanApplicationManager.GetSalariedRentalBasedIncomeLoan(member.getBRANCH_ID(), member.getMEMBER_ID());
                        _apiManager.createSalariedAndRentalBasedIncomeLoan(loanRentalBasedIncome, new RequestListener<CommonUploadResponse>() {
                            @Override
                            public void onSuccess(CommonUploadResponse response) {
                                kProgressHUD5.dismiss();
                                if (response != null){
                                    if (response.getIsSuccessful()) {
                                        loanApplicationManager.RemoveLoanSalariedRentalBasedIncome(member.getBRANCH_ID(), member.getMEMBER_ID());
                                        uploadSuccessfull();
                                    } else {
                                        Utils.showDialog(LoanAssessmentActivity.this, response.getMessage());
                                    }
                                }

                            }

                            @Override
                            public void onError(Throwable t) {
                                kProgressHUD5.dismiss();
                                Utils.showDialog(LoanAssessmentActivity.this, t.getMessage());
                            }
                        });
                        break;

                    case 6:
                        KProgressHUD kProgressHUD6 = Utils.showProgressDialog(LoanAssessmentActivity.this, getResources().getString(R.string.uploading));
                        LoanRemittanceDM loanRemittanceDM = loanApplicationManager.GetRemittanceLoan(member.getBRANCH_ID(), member.getMEMBER_ID());
                        _apiManager.createRemittanceLoan(loanRemittanceDM, new RequestListener<CommonUploadResponse>() {
                            @Override
                            public void onSuccess(CommonUploadResponse response) {
                                kProgressHUD6.dismiss();
                                if (response.getIsSuccessful()) {
                                    loanApplicationManager.RemoveLoanRemittance(member.getBRANCH_ID(), member.getMEMBER_ID());
                                    uploadSuccessfull();
                                } else {
                                    Utils.showDialog(LoanAssessmentActivity.this, response.getMessage());
                                }
                            }

                            @Override
                            public void onError(Throwable t) {
                                kProgressHUD6.dismiss();
                                Utils.showDialog(LoanAssessmentActivity.this, t.getMessage());
                            }
                        });
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                kProgressHUD.dismiss();
            }
        }

    }

    private void uploadSuccessfull() {
        AlertDialog alert;
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.uploadSuccessful))
                .setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startActivity(new Intent(LoanAssessmentActivity.this, MemberList.class));
                        finish();
                    }
                });
        alert = builder.create();
        alert.show();
    }

    @OnClick(R.id.uploadBizInfoToServer)
    public void onViewClicked() {
        try {
            uploadBizInfoToServer();
        } catch (Exception e) {
            e.printStackTrace();
            Utils.showDialog(this,"Server Error");
        }
    }

    // =========================   Validator with Error Message. =====================

    private HashMap<Boolean, String> checkMemberLoanAssement(LoanApplicationManager loanApplicationManager) {

        if (loanApplicationManager == null) {
            HashMap<Boolean, String> result = new HashMap<Boolean, String>();
            result.put(false, "Invalid Loan Application.");
            return result;
        }

        if (loanApplicationManager.GetLoanApplication(member.getBRANCH_ID(), member.getMEMBER_ID()) != null) {
            LoanApplicationDM loanApplicationDM = loanApplicationManager.GetLoanApplication(member.getBRANCH_ID(), member.getMEMBER_ID());
            if (loanApplicationDM.getBankAccount() == null) {
                HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                result.put(false, "Invalid Bank Account Information.");
                return result;
            }
            if (loanApplicationDM.getGuarantorList() == null) {
                HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                result.put(false, "Invalid Guarantor Information.");
                return result;
            }
            if (loanApplicationDM.getFamilyIncomeExpenseAsset() == null) {
                HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                result.put(false, "Invalid family income expense asset Information.");
                return result;
            }
            if (loanApplicationDM.getDocumentList() == null) {
                HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                result.put(false, "Invalid Documents List");
                return result;
            }

        }

        switch (leadOptionID) {
            case 2:
                if (loanApplicationManager.GetAgroLoan(member.getBRANCH_ID(), member.getMEMBER_ID()) != null) {
                    LoanAgroDM loanAgro = loanApplicationManager.GetAgroLoan(member.getBRANCH_ID(), member.getMEMBER_ID());
                    if (loanAgro.getIncomeAgro() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Income Details.");
                        return result;
                    }
                    if (loanAgro.getExpenseAgro() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Expense Details.");
                        return result;
                    }
                    if (loanAgro.getAgroLiveStock() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Agro liveStock.");
                        return result;
                    }
                    if (loanAgro.getFundWithdraw() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Fund Withdraw.");
                        return result;
                    }

                }
                break;
            case 1:
            case 3:
                if (loanApplicationManager.GetTradeManufactoringLoan(member.getBRANCH_ID(), member.getMEMBER_ID()) != null) {
                    LoanTradeManufactoringDM tradeManufactoringDM = loanApplicationManager.GetTradeManufactoringLoan(member.getBRANCH_ID(), member.getMEMBER_ID());
                    if (tradeManufactoringDM.getBusinessSale() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Business Sales Info.");
                        return result;
                    }
                    if (tradeManufactoringDM.getCostOfGoods() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Cost of Goodgs.");
                        return result;
                    }
                    if (tradeManufactoringDM.getDebtorCreditor() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Debtor or creditor.");
                        return result;
                    }
                    if (tradeManufactoringDM.getStockOfGoodsList() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Stock of Goods.");
                        return result;
                    }
                    if (tradeManufactoringDM.getEquipmentValue() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Equipment value.");
                        return result;
                    }
                    if (tradeManufactoringDM.getFundWithdraw() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Fund Withdraw.");
                        return result;
                    }

                }
                break;
            case 4:
            case 5:
                if (loanApplicationManager.GetSalariedRentalBasedIncomeLoan(member.getBRANCH_ID(), member.getMEMBER_ID()) != null) {
                    LoanSalariedRentalBasedIncomeDM loanSalariedRentalBasedIncome = loanApplicationManager.GetSalariedRentalBasedIncomeLoan(member.getBRANCH_ID(), member.getMEMBER_ID());
                    if (loanSalariedRentalBasedIncome.getIncomeBasedIncome() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Income Details.");
                        return result;
                    }
                    if (loanSalariedRentalBasedIncome.getExpenseBasedIncome() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Expense Details.");
                        return result;
                    }

                }
                break;
            case 6:
                if (loanApplicationManager.GetRemittanceLoan(member.getBRANCH_ID(), member.getMEMBER_ID()) != null) {
                    LoanRemittanceDM loanRemittance = loanApplicationManager.GetRemittanceLoan(member.getBRANCH_ID(), member.getMEMBER_ID());
                    if (loanRemittance.getRemittanceInfo() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Remittance Information.");
                        return result;
                    }
                    if (loanRemittance.getExpenseBasedIncome() == null) {
                        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
                        result.put(false, "Invalid Expense Details.");
                        return result;
                    }

                }
                break;
        }

        /*
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
        }*/

        HashMap<Boolean, String> result = new HashMap<Boolean, String>();
        result.put(true, "");
        return result;
    }

    private boolean validate() {
        boolean validationStatus = true;

        if (_loanAmount.getText().length() == 0) {
            setError(_loanAmount, getResources().getString(R.string.loanAmountError));
            validationStatus = false;
        } else {
            int leadOptionId = member.getLEAD_OPTION_ID();
            int roundFigure = (int) Math.round(_serviceManager.getLeadOptionObject(leadOptionId).getLOANROUNDAMOUNT());
            double minimumAmount = Double.parseDouble(_serviceManager.getLeadOptionObject(leadOptionId).getLOANMIN().toString());
            double maximumAmount = Double.parseDouble(_serviceManager.getLeadOptionObject(leadOptionId).getLOANMAX().toString());

            double insertedAmount = Double.parseDouble(_loanAmount.getText().toString());
            if (insertedAmount % roundFigure != 0) {
                setError(_loanAmount, Utils.formatNumber(roundFigure) + getResources().getString(R.string.leadOptionsMultiplayer));
                validationStatus = false;
            }
            if ((insertedAmount < minimumAmount) || (insertedAmount > maximumAmount)) {
                setError(_loanAmount, Utils.formatNumber(minimumAmount) + " - " + Utils.formatNumber(maximumAmount) + getResources().getString(R.string.errorRequiredAmount));
                validationStatus = false;
            }
        }
        return validationStatus;
    }

    private TranslateAnimation shakeError() {
        TranslateAnimation shake = new TranslateAnimation(0, 10, 0, 0);
        shake.setDuration(500);
        shake.setInterpolator(new CycleInterpolator(7));
        return shake;
    }

    private void setError(EditText editText, String errorMessage) {
        Vibrator vibe = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        editText.setError(errorMessage);
        editText.startAnimation(shakeError());
        vibe.vibrate(300);
        editText.setTextColor(getResources().getColor(R.color.errorColor));
    }
}
