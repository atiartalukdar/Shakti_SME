package com.sfdw.shaktisme.loanInformation.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.LoanAssessmentActivity;

import bp.BaseActivity;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.MemberListDM;
import objectBox.LoanFamilyIncomeExpenseAssetBox;
import services.ObjectBoxManager;

import static bp.Utils.getNumberFromEditText;

public class LoanFamilyIncomeExpenseAssetActivity extends BaseActivity implements View.OnFocusChangeListener {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    private ObjectBoxManager _objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)                                            TextView _name;
    @BindView(R.id.memberID)                                        TextView _memberID;
    @BindView(R.id.family_income_own_land_price)                    EditText _familyIncomeOwnLandPrice;
    @BindView(R.id.family_income_own_house_price)                   EditText _familyIncomeOwnHousePrice;
    @BindView(R.id.family_income_current_house_furniture_price)     EditText _familyIncomeCurrentHouseFurniturePrice;
    @BindView(R.id.family_income_other_family_assets_price)         EditText _familyIncomeOtherFamilyAssetsPrice;
    @BindView(R.id.family_income_saving_deposit_org)                EditText _familyIncomeSavingDepositOrg;
    @BindView(R.id.family_income_family_other_income)               EditText _familyIncomeFamilyOtherIncome;
    @BindView(R.id.family_income_family_take_remitance)             EditText _familyIncomeFamilyTakeRemitance;
    @BindView(R.id.totalFamilyIncome)                               TextView _totalFamilyIncome;
    @BindView(R.id.family_expanse_profit_spent)                     EditText _familyExpanseProfitSpent;
    @BindView(R.id.family_expanse_cost_rent_home)                   EditText _familyExpanseCostRentHome;
    @BindView(R.id.family_expanse_cost_children_study)              EditText _familyExpanseCostChildrenStudy;
    @BindView(R.id.family_expanse_cost_medical)                     EditText _familyExpanseCostMedical;
    @BindView(R.id.family_expanse_cost_other_bil)                   EditText _familyExpanseCostOtherBil;
    @BindView(R.id.family_expanse_cost_support)                     EditText _familyExpanseCostSupport;
    @BindView(R.id.family_expanse_cost_outside_family)              EditText _familyExpanseCostOutsideFamily;
    @BindView(R.id.totalFamilyExpance)                              TextView _totalFamilyExpance;
    @BindView(R.id.saveBtn)                                         Button _saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_family_income_expense_asset);
        ButterKnife.bind(this);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadForm();
            }
        });

        initializeListner();
    }

    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    private void setLoanFamilyIncomeExpenseAsset(LoanFamilyIncomeExpenseAssetBox data) {
        data.setBRANCH_ID(member.getBRANCH_ID());
        data.setCENTER_ID(member.getCENTER_ID());
        data.setMEMBER_ID(member.getMEMBER_ID());
        data.setOWN_LAND(_familyIncomeOwnLandPrice.getText().toString());
        data.setOWN_HOUSE(_familyIncomeOwnHousePrice.getText().toString());
        data.setHOUSE_FURNITURE(_familyIncomeCurrentHouseFurniturePrice.getText().toString());
        data.setOTHER_FAMILY_ASSETS(_familyIncomeOtherFamilyAssetsPrice.getText().toString());
        data.setSAVING_DEPOSIT_ORG(_familyIncomeSavingDepositOrg.getText().toString());
        data.setINC_OTHER_INCOME(_familyIncomeFamilyOtherIncome.getText().toString());
        data.setINC_TAKE_REMITTANCE(_familyIncomeFamilyTakeRemitance.getText().toString());
        data.setCOST_SPENT_FAMILY(_familyExpanseProfitSpent.getText().toString());
        data.setCOST_RENT_HOME(_familyExpanseCostRentHome.getText().toString());
        data.setCOST_CHILDREN_STUDY(_familyExpanseCostChildrenStudy.getText().toString());
        data.setCOST_MEDICAL(_familyExpanseCostMedical.getText().toString());
        data.setCOST_OTHER_BIL(_familyExpanseCostOtherBil.getText().toString());
        data.setCOST_SUPPORT(_familyExpanseCostSupport.getText().toString());
        data.setCOST_OUTSIDE_FAMILY(_familyExpanseCostOutsideFamily.getText().toString());
    }

    private void saveToLocalStorage() {
        LoanFamilyIncomeExpenseAssetBox loanFamilyIncomeExpenseAsset = _objectBoxManager.GetLoanFamilyIncomeExpenseAssetBox(member.getBRANCH_ID(), member.getMEMBER_ID());


        if (loanFamilyIncomeExpenseAsset == null) {
            LoanFamilyIncomeExpenseAssetBox newData = new LoanFamilyIncomeExpenseAssetBox();
            setLoanFamilyIncomeExpenseAsset(newData);
            _objectBoxManager.SaveLoanFamilyIncomeExpenseAssetBox(newData);
        } else {
            setLoanFamilyIncomeExpenseAsset(loanFamilyIncomeExpenseAsset);
            _objectBoxManager.SaveLoanFamilyIncomeExpenseAssetBox(loanFamilyIncomeExpenseAsset);
        }

        Intent intent = new Intent(LoanFamilyIncomeExpenseAssetActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails", member);
        startActivity(intent);
        finish();

    }

    private void loadForm() {

        LoanFamilyIncomeExpenseAssetBox resultDB = _objectBoxManager.GetLoanFamilyIncomeExpenseAssetBox(member.getBRANCH_ID(), member.getMEMBER_ID());
        if (resultDB != null) {
            _familyIncomeOwnLandPrice.setText(resultDB.getOWN_LAND());
            _familyIncomeOwnHousePrice.setText(resultDB.getOWN_HOUSE());
            _familyIncomeCurrentHouseFurniturePrice.setText(resultDB.getHOUSE_FURNITURE());
            _familyIncomeOtherFamilyAssetsPrice.setText(resultDB.getOTHER_FAMILY_ASSETS());
            _familyIncomeSavingDepositOrg.setText(resultDB.getSAVING_DEPOSIT_ORG());
            _familyIncomeFamilyOtherIncome.setText(resultDB.getINC_OTHER_INCOME());
            _familyIncomeFamilyTakeRemitance.setText(resultDB.getINC_TAKE_REMITTANCE());
            _familyExpanseProfitSpent.setText(resultDB.getCOST_SPENT_FAMILY());
            _familyExpanseCostRentHome.setText(resultDB.getCOST_RENT_HOME());
            _familyExpanseCostChildrenStudy.setText(resultDB.getCOST_CHILDREN_STUDY());
            _familyExpanseCostMedical.setText(resultDB.getCOST_MEDICAL());
            _familyExpanseCostOtherBil.setText(resultDB.getCOST_OTHER_BIL());
            _familyExpanseCostSupport.setText(resultDB.getCOST_SUPPORT());
            _familyExpanseCostOutsideFamily.setText(resultDB.getCOST_OUTSIDE_FAMILY());
            calculate();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initializeListner(){
        _familyIncomeOwnLandPrice.setOnFocusChangeListener(this);
        _familyIncomeOwnHousePrice.setOnFocusChangeListener(this);
        _familyIncomeCurrentHouseFurniturePrice.setOnFocusChangeListener(this);
        _familyIncomeOtherFamilyAssetsPrice.setOnFocusChangeListener(this);
        _familyIncomeSavingDepositOrg.setOnFocusChangeListener(this);
        _familyIncomeFamilyOtherIncome.setOnFocusChangeListener(this);
        _familyIncomeFamilyTakeRemitance.setOnFocusChangeListener(this);
        _totalFamilyIncome.setOnFocusChangeListener(this);
        _familyExpanseProfitSpent.setOnFocusChangeListener(this);
        _familyExpanseCostRentHome.setOnFocusChangeListener(this);
        _familyExpanseCostChildrenStudy.setOnFocusChangeListener(this);
        _familyExpanseCostMedical.setOnFocusChangeListener(this);
        _familyExpanseCostOtherBil.setOnFocusChangeListener(this);
        _familyExpanseCostSupport.setOnFocusChangeListener(this);
        _familyExpanseCostOutsideFamily.setOnFocusChangeListener(this);
        _totalFamilyExpance.setOnFocusChangeListener(this);
    }

    private void calculate() {
        int familyIncomeOwnLandPrice = getNumberFromEditText(_familyIncomeOwnLandPrice);
        int familyIncomeOwnHousePrice = getNumberFromEditText(_familyIncomeOwnHousePrice);
        int familyIncomeCurrentHouseFurniturePrice = getNumberFromEditText(_familyIncomeCurrentHouseFurniturePrice);
        int familyIncomeOtherFamilyAssetsPrice = getNumberFromEditText(_familyIncomeOtherFamilyAssetsPrice);
        int familyIncomeSavingDepositOrg = getNumberFromEditText(_familyIncomeSavingDepositOrg);

        int familyIncomeFamilyOtherIncome = getNumberFromEditText(_familyIncomeFamilyOtherIncome);
        int familyIncomeFamilyTakeRemitance = getNumberFromEditText(_familyIncomeFamilyTakeRemitance);

        int familyExpanseProfitSpent = getNumberFromEditText(_familyExpanseProfitSpent);
        int familyExpanseCostRentHome = getNumberFromEditText(_familyExpanseCostRentHome);
        int familyExpanseCostChildrenStudy = getNumberFromEditText(_familyExpanseCostChildrenStudy);
        int familyExpanseCostMedical = getNumberFromEditText(_familyExpanseCostMedical);
        int familyExpanseCostOtherBil = getNumberFromEditText(_familyExpanseCostOtherBil);
        int familyExpanseCostSupport = getNumberFromEditText(_familyExpanseCostSupport);
        int familyExpanseCostOutsideFamily = getNumberFromEditText(_familyExpanseCostOutsideFamily);

        long totalAsset = familyIncomeOwnLandPrice + familyIncomeOwnHousePrice + familyIncomeCurrentHouseFurniturePrice + familyIncomeOtherFamilyAssetsPrice + familyIncomeSavingDepositOrg;
        long totalIncome = familyIncomeFamilyOtherIncome + familyIncomeFamilyTakeRemitance;
        long totalExpense = familyExpanseProfitSpent + familyExpanseCostRentHome + familyExpanseCostChildrenStudy + familyExpanseCostMedical + familyExpanseCostOtherBil + familyExpanseCostSupport + familyExpanseCostOutsideFamily;

        _totalFamilyIncome.setText("সম্পত্তির মুল্যঃ " + Utils.formatNumber(totalAsset) + "/- এবং  মাসিক আয়ঃ " + Utils.formatNumber(totalIncome) + "/-");
        _totalFamilyExpance.setText(Utils.formatNumber(totalExpense) + "/-");

    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            calculate();
    }

}
