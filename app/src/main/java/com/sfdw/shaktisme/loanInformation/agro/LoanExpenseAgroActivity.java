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
import objectBox.LoanExpenseAgroBox;
import services.ObjectBoxManager;

import static bp.Utils.getNumberFromEditText;

public class LoanExpenseAgroActivity extends BaseActivity implements View.OnFocusChangeListener {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    private ObjectBoxManager _objectBoxManager = new ObjectBoxManager();

    @BindView(R.id.name)                        TextView _name;
    @BindView(R.id.memberID)                    TextView _memberID;
    @BindView(R.id.agro_cattle_feed_cost)       EditText _agroCattleFeedCost;
    @BindView(R.id.agro_veterinary_cost)        EditText _agroVeterinaryCost;
    @BindView(R.id.agro_salary_Paid)            EditText _agroSalaryPaid;
    @BindView(R.id.agro_live_stock_purchase)    EditText _agroLiveStockPurchase;
    @BindView(R.id.agro_dairy_production_cost)  EditText _agroDairyProductionCost;
    @BindView(R.id.agro_other_cost)             EditText _agroOtherCost;
    @BindView(R.id.agro_total_expanse)          TextView _agroTotalExpanse;
    @BindView(R.id.saveBtn)                     Button _saveBtn;


    private MemberListDM.Data member;
    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_expense_agro);
        ButterKnife.bind(this);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        Log.e(TAG, member.getMEMBER_ID());
        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());

        loadUIIfAvailable();

        initializeListner();
    }

    private void setLoanExpanceAgro(LoanExpenseAgroBox data) {
        data.setMEMBER_ID(member.getMEMBER_ID());
        data.setBRANCH_ID(member.getBRANCH_ID());
        data.setCENTER_ID(member.getCENTER_ID());
        data.setCATTLE_FEED_COST(_agroCattleFeedCost.getText().toString());
        data.setVETERINARY_COST(_agroVeterinaryCost.getText().toString());
        data.setSALARY_PAID(_agroSalaryPaid.getText().toString());
        data.setLIVESTOCK_PURCHASE(_agroLiveStockPurchase.getText().toString());
        data.setDAIRY_PRODUCTION_COST(_agroDairyProductionCost.getText().toString());
        data.setOTHER_COST(_agroOtherCost.getText().toString());

    }

    private void saveToLocalStorage(){
        LoanExpenseAgroBox expenseAgro = _objectBoxManager.GetLoanExpenseAgroBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (expenseAgro == null){
            LoanExpenseAgroBox newData = new LoanExpenseAgroBox();
            setLoanExpanceAgro(newData);
            _objectBoxManager.SaveLoanExpenseAgroBox(newData);
        }else
        {
            setLoanExpanceAgro(expenseAgro);
            _objectBoxManager.SaveLoanExpenseAgroBox(expenseAgro);
        }

        Intent intent = new Intent(LoanExpenseAgroActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails",member);
        startActivity(intent);
        finish();

    }

    private void loadUIIfAvailable(){
        LoanExpenseAgroBox data = _objectBoxManager.GetLoanExpenseAgroBox(member.getBRANCH_ID(), member.getMEMBER_ID());
        if (data!=null){
            _agroCattleFeedCost.setText(data.getCATTLE_FEED_COST());
            _agroVeterinaryCost.setText(data.getVETERINARY_COST());
            _agroSalaryPaid.setText(data.getSALARY_PAID());
            _agroLiveStockPurchase.setText(data.getLIVESTOCK_PURCHASE());
            _agroDairyProductionCost.setText(data.getDAIRY_PRODUCTION_COST());
            _agroOtherCost.setText(data.getOTHER_COST());
            calculate();

        }

    }

    private void initializeListner(){
        _agroCattleFeedCost.setOnFocusChangeListener(this);
        _agroVeterinaryCost.setOnFocusChangeListener(this);
        _agroSalaryPaid.setOnFocusChangeListener(this);
        _agroLiveStockPurchase.setOnFocusChangeListener(this);
        _agroDairyProductionCost.setOnFocusChangeListener(this);
        _agroOtherCost.setOnFocusChangeListener(this);
    }
    private void calculate() {
        int agroCattleFeedCost = getNumberFromEditText(_agroCattleFeedCost);
        int agroVeterinaryCost = getNumberFromEditText(_agroVeterinaryCost);
        int agroSalaryPaid = getNumberFromEditText(_agroSalaryPaid);
        int agroLiveStockPurchase = getNumberFromEditText(_agroLiveStockPurchase);
        int agroDairyProductionCost = getNumberFromEditText(_agroDairyProductionCost);
        int agroOtherCost = getNumberFromEditText(_agroOtherCost);

        long sum = agroCattleFeedCost + agroVeterinaryCost + agroSalaryPaid +
                agroLiveStockPurchase + agroDairyProductionCost + agroOtherCost ;

        _agroTotalExpanse.setText(Utils.formatNumber(sum)+"/-");

    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            calculate();
    }
}