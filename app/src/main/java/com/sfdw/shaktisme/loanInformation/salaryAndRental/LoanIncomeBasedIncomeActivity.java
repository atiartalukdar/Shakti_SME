package com.sfdw.shaktisme.loanInformation.salaryAndRental;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.LoanAssessmentActivity;

import bp.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.MemberListDM;
import objectBox.LoanIncomeBasedIncomeBox;
import services.ObjectBoxManager;

public class LoanIncomeBasedIncomeActivity extends BaseActivity {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();

    @BindView(R.id.radioBtnGovtJob)                     RadioButton _radioBtnGovtJob;
    @BindView(R.id.radioBtnNonGovtJob)                  RadioButton _radioBtnNonGovtJob;
    @BindView(R.id.radiogroupJobSector)                 RadioGroup _radiogroupJobSector;

    @BindView(R.id.radioBtnEmployee_parmanent)          RadioButton _radioBtnEmployeeParmanent;
    @BindView(R.id.radioBtnEmployee_temporary)          RadioButton _radioBtnEmployeeTemporary;
    @BindView(R.id.radioGroupJobType)                   RadioGroup _radioGroupJobType;

    @BindView(R.id.radioBtn_bank_yes)                   RadioButton _radioBtn_bank_yes;
    @BindView(R.id.radioBtn_bank_no)                    RadioButton _radioBtn_bank_no;
    @BindView(R.id.radiogroup_bank_deposit)             RadioGroup _radiogroup_bank_deposit;

    @BindView(R.id.income_based_income_on_house_age)    EditText _incomeBasedIncomeOnHouseAge;
    @BindView(R.id.salaryLiniarLayout)                  LinearLayout _salaryLiniarLayout;
    @BindView(R.id.rentLiniarLayout)                    LinearLayout _rentLiniarLayout;
    @BindView(R.id.name)                                TextView _name;
    @BindView(R.id.memberID)                            TextView _memberID;

    @BindView(R.id.income_based_income_source)          Spinner _incomeBasedIncomeSource;
    @BindView(R.id.income_based_basic_salary)           EditText _incomeBasedBasicSalary;
    @BindView(R.id.income_based_Gross_salary)           EditText _incomeBasedGrossSalary;
    @BindView(R.id.income_based_net_salary)             EditText _income_based_net_salary;
    @BindView(R.id.income_based_income_on_house_rent)   EditText _incomeBasedIncomeOnHouseRent;
    @BindView(R.id.income_based_income_total)           TextView _incomeBasedIncomeTotal;
    @BindView(R.id.saveBtn)                             Button _saveBtn;

    private MemberListDM.Data member;

    ArrayAdapter arrayAdapter;
    String[] incomeSource = {"বাড়ি ভাড়া", "বেতন", "উভয়"};

    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_income_based_income);
        ButterKnife.bind(this);
        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, incomeSource);
        _incomeBasedIncomeSource.setAdapter(arrayAdapter);
        _incomeBasedIncomeSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                customizeUI(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        loadUIIfAvailable();
    }

    private void customizeUI(int position) {
        switch (position) {
            case 0:
                _salaryLiniarLayout.setVisibility(View.GONE);
                _rentLiniarLayout.setVisibility(View.VISIBLE);
                break;
            case 1:
                _salaryLiniarLayout.setVisibility(View.VISIBLE);
                _rentLiniarLayout.setVisibility(View.GONE);
                break;
            case 2:
                _salaryLiniarLayout.setVisibility(View.VISIBLE);
                _rentLiniarLayout.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void setLoanIncomeBasedIncomeBox(LoanIncomeBasedIncomeBox data) {
        data.setMEMBER_ID(member.getMEMBER_ID());
        data.setBRANCH_ID(member.getBRANCH_ID());
        data.setCENTER_ID(member.getCENTER_ID());
        data.setINCOME_SECTOR(_incomeBasedIncomeSource.getSelectedItemPosition() + 1 + "");
        data.setBASE_SALARY(_incomeBasedBasicSalary.getText()!=null ? _incomeBasedBasicSalary.getText().toString() : "");
        data.setGROSS_SALARY(_incomeBasedGrossSalary.getText()!=null ? _incomeBasedGrossSalary.getText().toString():"");
        data.setNEAT_SALARY(_income_based_net_salary.getText() != null ? _income_based_net_salary.getText().toString():"");
        data.setAVG_HOUSE_RENT(_incomeBasedIncomeOnHouseRent.getText() != null ? _incomeBasedIncomeOnHouseRent.getText().toString():"");
        data.setJOB_SECTOR(_radiogroupJobSector.getCheckedRadioButtonId()==R.id.radioBtnGovtJob ? "1" : "0");
        data.setJOB_TYPE( _radioGroupJobType.getCheckedRadioButtonId()==R.id.radioBtnEmployee_parmanent ? "1" : "0");
        data.setHOUSE_AGE(_incomeBasedIncomeOnHouseAge.getText() != null ? _incomeBasedIncomeOnHouseAge.getText().toString() : "");
        data.setIS_BANK_PAID(_radiogroup_bank_deposit.getCheckedRadioButtonId()==R.id.radioBtn_bank_yes ? "1" : "0");
    }

    private void saveToLocalStorage() {
        LoanIncomeBasedIncomeBox incomeBasedIncome = objectBoxManager.GetLoanIncomeBasedIncomeBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (incomeBasedIncome == null) {
            LoanIncomeBasedIncomeBox newData = new LoanIncomeBasedIncomeBox();
            setLoanIncomeBasedIncomeBox(newData);
            objectBoxManager.SaveLoanIncomeBasedIncomeBox(newData);
        } else {
            setLoanIncomeBasedIncomeBox(incomeBasedIncome);
            objectBoxManager.SaveLoanIncomeBasedIncomeBox(incomeBasedIncome);
        }

        Intent intent = new Intent(LoanIncomeBasedIncomeActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails", member);
        startActivity(intent);
        finish();

    }

    private void loadUIIfAvailable() {
        LoanIncomeBasedIncomeBox data = objectBoxManager.GetLoanIncomeBasedIncomeBox(member.getBRANCH_ID(), member.getMEMBER_ID());
        if (data != null) {
            _incomeBasedIncomeSource.setSelection(Integer.parseInt(data.getINCOME_SECTOR()) - 1);
            _incomeBasedBasicSalary.setText(data.getBASE_SALARY());
            _incomeBasedGrossSalary.setText(data.getGROSS_SALARY());
            _income_based_net_salary.setText(data.getNEAT_SALARY());
            _incomeBasedIncomeOnHouseRent.setText(data.getAVG_HOUSE_RENT());
            _incomeBasedIncomeOnHouseAge.setText(data.getHOUSE_AGE());
            _radiogroup_bank_deposit.check(data.getIS_BANK_PAID().equals("1") ? R.id.radioBtn_bank_yes : R.id.radioBtn_bank_no);
            _radiogroupJobSector.check(data.getJOB_SECTOR().equals("1") ? R.id.radioBtnGovtJob : R.id.radioBtnNonGovtJob);
            _radioGroupJobType.check(data.getJOB_TYPE().equals("1")  ? R.id.radioBtnEmployee_parmanent : R.id.radioBtnEmployee_temporary);

        }
    }

}
