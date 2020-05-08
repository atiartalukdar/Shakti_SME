package com.sfdw.shaktisme.loanInformation.agro;

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
import objectBox.LoanIncomeAgroBox;
import services.ObjectBoxManager;

import static bp.Utils.getNumberFromEditText;

public class LoanIncomeAgroActivity extends BaseActivity implements View.OnFocusChangeListener {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    private ObjectBoxManager _objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)                    TextView _name;
    @BindView(R.id.memberID)                TextView _memberID;
    @BindView(R.id.agro_milk_production)    EditText _agroMilkProduction;
    @BindView(R.id.agro_avg_milk_sale)      EditText _agroAvgMilkSale;
    @BindView(R.id.agro_dairy_product_sale) EditText _agroDairyProductSale;
    @BindView(R.id.agro_live_stock_sale)    EditText _agroLiveStockSale;
    @BindView(R.id.agro_other_income)       EditText _agroOtherIncome;
    @BindView(R.id.agro_total_income)       TextView _agroTotalIncome;
    @BindView(R.id.saveBtn)                 Button _saveBtn;

    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_income_agro);
        ButterKnife.bind(this);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        Log.e(TAG, member.getMEMBER_ID());
        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());

        loadUIIfAvailable();

        initializeListner();
    }

    private void setLoanIncomeAgro(LoanIncomeAgroBox data) {
        data.setMEMBER_ID(member.getMEMBER_ID());
        data.setBRANCH_ID(member.getBRANCH_ID());
        data.setCENTER_ID(member.getCENTER_ID());
        data.setMILK_PRODUCTION(_agroMilkProduction.getText().toString());
        data.setAVG_MILK_SALE(_agroAvgMilkSale.getText().toString());
        data.setDAIRY_PRODUCT_SALE(_agroDairyProductSale.getText().toString());
        data.setLIVE_STOCK_SALE(_agroLiveStockSale.getText().toString());
        data.setOTHER_INCOME(_agroOtherIncome.getText().toString());

    }

    private void saveToLocalStorage() {
        LoanIncomeAgroBox incomeAgro = _objectBoxManager.GetLoanIncomeAgroBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (incomeAgro == null) {
            LoanIncomeAgroBox newData = new LoanIncomeAgroBox();
            setLoanIncomeAgro(newData);
            _objectBoxManager.SaveLoanIncomeAgroBox(newData);
        } else {
            setLoanIncomeAgro(incomeAgro);
            _objectBoxManager.SaveLoanIncomeAgroBox(incomeAgro);
        }


        Intent intent = new Intent(LoanIncomeAgroActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails", member);
        startActivity(intent);
        finish();

    }

    private void loadUIIfAvailable() {
        LoanIncomeAgroBox data = _objectBoxManager.GetLoanIncomeAgroBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (data != null) {
            _agroMilkProduction.setText(data.getMILK_PRODUCTION());
            _agroAvgMilkSale.setText(data.getAVG_MILK_SALE());
            _agroDairyProductSale.setText(data.getDAIRY_PRODUCT_SALE());
            _agroLiveStockSale.setText(data.getLIVE_STOCK_SALE());
            _agroOtherIncome.setText(data.getOTHER_INCOME());
        }

    }

    private void initializeListner(){
        _agroMilkProduction.setOnFocusChangeListener(this);
        _agroAvgMilkSale.setOnFocusChangeListener(this);
        _agroDairyProductSale.setOnFocusChangeListener(this);
        _agroLiveStockSale.setOnFocusChangeListener(this);
        _agroOtherIncome.setOnFocusChangeListener(this);
    }
    private void calculate() {
        int agroMilkProduction = getNumberFromEditText(_agroMilkProduction);
        int agroAvgMilkSale = getNumberFromEditText(_agroAvgMilkSale);
        int agroDairyProductSale = getNumberFromEditText(_agroDairyProductSale);
        int agroLiveStockSale = getNumberFromEditText(_agroLiveStockSale);
        int agroOtherIncome = getNumberFromEditText(_agroOtherIncome);

        long sum = agroMilkProduction + agroAvgMilkSale + agroDairyProductSale +
                agroLiveStockSale + agroOtherIncome;

        _agroTotalIncome.setText(Utils.formatNumber(sum)+"/-");

    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            calculate();
    }
}