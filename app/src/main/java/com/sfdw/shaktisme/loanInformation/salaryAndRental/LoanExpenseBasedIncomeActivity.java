package com.sfdw.shaktisme.loanInformation.salaryAndRental;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import objectBox.LoanExpenseBasedIncomeBox;
import services.ObjectBoxManager;

import static bp.Utils.getNumberFromEditText;

public class LoanExpenseBasedIncomeActivity extends BaseActivity implements View.OnFocusChangeListener {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)                                        TextView _name;
    @BindView(R.id.memberID)                                    TextView _memberID;
    @BindView(R.id.income_based_expence_house_maintenance)      EditText _incomeBasedExpenceHouseMaintenance;
    @BindView(R.id.income_based_expence_house_development)      EditText _incomeBasedExpenceHouseDevelopment;
    @BindView(R.id.income_based_expence_utility_bill)           EditText _incomeBasedExpenceUtilityBill;
    @BindView(R.id.income_based_expence_home_tax)               EditText _incomeBasedExpenceHomeTax;
    @BindView(R.id.income_based_expence_on_other)               EditText _incomeBasedExpenceOnOther;
    @BindView(R.id.income_based_expence_total)                  TextView _incomeBasedExpenceTotal;
    @BindView(R.id.saveBtn)                                     Button _saveBtn;

    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_expense_based_income);
        ButterKnife.bind(this);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        Log.e(TAG,member.getMEMBER_ID());

        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) +member.getMEMBER_ID());

        loadUIIfAvailable();

        initializeListner();
    }

    private void setLoanExpenseBasedIncomeBox(LoanExpenseBasedIncomeBox data) {
        data.setMEMBER_ID(member.getMEMBER_ID());
        data.setBRANCH_ID(member.getBRANCH_ID());
        data.setCENTER_ID(member.getCENTER_ID());
        data.setHOUSE_MAINTENANCE_COST(_incomeBasedExpenceHouseMaintenance.getText().toString());

        data.setAVG_DEV_COST(_incomeBasedExpenceHouseDevelopment.getText().toString());
        data.setAVG_UTILITY_COST(_incomeBasedExpenceUtilityBill.getText().toString());
        data.setAVG_TAX(_incomeBasedExpenceHomeTax.getText().toString());
        data.setOTHER(_incomeBasedExpenceOnOther.getText().toString());

    }

    private void saveToLocalStorage(){
        LoanExpenseBasedIncomeBox expenseBasedIncome = objectBoxManager.GetLoanExpenseBasedIncomeBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (expenseBasedIncome == null){
            LoanExpenseBasedIncomeBox newData = new LoanExpenseBasedIncomeBox();
            setLoanExpenseBasedIncomeBox(newData);
            objectBoxManager.SaveLoanExpenseBasedIncomeBox(newData);
        }else
        {
            setLoanExpenseBasedIncomeBox(expenseBasedIncome);
            objectBoxManager.SaveLoanExpenseBasedIncomeBox(expenseBasedIncome);
        }

        Intent intent = new Intent(LoanExpenseBasedIncomeActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails",member);
        startActivity(intent);
        finish();

    }

    private void loadUIIfAvailable(){
        LoanExpenseBasedIncomeBox data = objectBoxManager.GetLoanExpenseBasedIncomeBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (data!=null){
            _incomeBasedExpenceHouseMaintenance.setText(data.getHOUSE_MAINTENANCE_COST());
            _incomeBasedExpenceHouseDevelopment.setText(data.getAVG_DEV_COST());
            _incomeBasedExpenceUtilityBill.setText(data.getAVG_UTILITY_COST());
            _incomeBasedExpenceHomeTax.setText(data.getAVG_TAX());
            _incomeBasedExpenceOnOther.setText(data.getOTHER());
            calculate();
        }

    }

    private void initializeListner(){
       _incomeBasedExpenceHouseMaintenance.setOnFocusChangeListener(this);
       _incomeBasedExpenceHouseDevelopment.setOnFocusChangeListener(this);
       _incomeBasedExpenceUtilityBill.setOnFocusChangeListener(this);
       _incomeBasedExpenceHomeTax.setOnFocusChangeListener(this);
       _incomeBasedExpenceOnOther.setOnFocusChangeListener(this);
    }

    private void calculate() {
        int incomeBasedExpenceHouseMaintenance = getNumberFromEditText(_incomeBasedExpenceHouseMaintenance);
        int incomeBasedExpenceHouseDevelopment = getNumberFromEditText(_incomeBasedExpenceHouseDevelopment);
        int incomeBasedExpenceUtilityBill = getNumberFromEditText(_incomeBasedExpenceUtilityBill);
        int incomeBasedExpenceHomeTax = getNumberFromEditText(_incomeBasedExpenceHomeTax);
        int incomeBasedExpenceOnOther = getNumberFromEditText(_incomeBasedExpenceOnOther);

        long sum = incomeBasedExpenceHouseMaintenance + incomeBasedExpenceHouseDevelopment + incomeBasedExpenceUtilityBill +
                incomeBasedExpenceHomeTax + incomeBasedExpenceOnOther;

        _incomeBasedExpenceTotal.setText(Utils.formatNumber(sum)+"/-");

    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            calculate();
    }
}
