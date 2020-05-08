package com.sfdw.shaktisme.loanInformation.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
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
import interfaces.IObjectBoxManager;
import objectBox.LoanOtherExpenseBox;
import services.ObjectBoxManager;

import static bp.Utils.getNumberFromEditText;

public class LoanOtherExpenseActivity extends BaseActivity implements View.OnFocusChangeListener {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)                                    TextView _name;
    @BindView(R.id.memberID)                                TextView _memberID;
    @BindView(R.id.others_cost_business_place_rent)         EditText _othersCostBusinessPlaceRent;
    @BindView(R.id.others_cost_employee_salary)             EditText _othersCostEmployeeSalary;
    @BindView(R.id.others_cost_traveling_cost)              EditText _othersCostTravelingCost;
    @BindView(R.id.others_cost_utility_bills)               EditText _othersCostUtilityBills;
    @BindView(R.id.others_cost_repearing_cost)              EditText _othersCostRepearingCost;
    @BindView(R.id.others_cost_packaging_cost)              EditText _othersCostPackagingCost;
    @BindView(R.id.others_cost_vat_tax)                     EditText _othersCostVatTax;
    @BindView(R.id.others_cost)                             EditText _othersCost;
    @BindView(R.id.others_cost_monthly_average)             TextView _othersCostMonthlyAverage;
    @BindView(R.id.saveBtn)                                 Button _saveBtn;

    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    private IObjectBoxManager _objectBoxManager = new ObjectBoxManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others_cost);
        ButterKnife.bind(this);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) +member.getMEMBER_ID());

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadFormIfDataAvailable();
            }
        });

        initializeListner();
    }

    private void setLoanOtherExpense(LoanOtherExpenseBox data){
        data.setMEMBER_ID(member.getMEMBER_ID());
        data.setBRANCH_ID(member.getBRANCH_ID());
        data.setCENTER_ID(member.getCENTER_ID());
        data.setRENT_OF_BUSINESS(_othersCostBusinessPlaceRent.getText().toString());
        data.setSALARY_OF_EMPLOYEES(_othersCostEmployeeSalary.getText().toString());
        data.setTRANSPORTATION_COSTS(_othersCostTravelingCost.getText().toString());
        data.setUTILITY_COSTS(_othersCostUtilityBills.getText().toString());
        data.setREPAIR_COSTS(_othersCostRepearingCost.getText().toString());
        data.setPACKAGING_COSTS(_othersCostPackagingCost.getText().toString());
        data.setTAX_CHARGES(_othersCostVatTax.getText().toString());
        data.setOTHER_EXP(_othersCost.getText().toString());

    }

    private void saveToLocalStorage(){
        LoanOtherExpenseBox loanOtherExpense = _objectBoxManager.GetLoanOtherExpenseBox(member.getBRANCH_ID(),member.getMEMBER_ID());

        if (loanOtherExpense == null){
            LoanOtherExpenseBox newData = new LoanOtherExpenseBox();
            setLoanOtherExpense(newData);
            _objectBoxManager.SaveLoanOtherExpenseBox(newData);
        }else
        {
             setLoanOtherExpense(loanOtherExpense);
             _objectBoxManager.SaveLoanOtherExpenseBox(loanOtherExpense);

        }

        Intent intent = new Intent(LoanOtherExpenseActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails",member);
        startActivity(intent);
        finish();

    }

    private void loadFormIfDataAvailable(){

        LoanOtherExpenseBox loanOtherExpenseObjDB = _objectBoxManager.GetLoanOtherExpenseBox(member.getBRANCH_ID(),member.getMEMBER_ID());
        if (loanOtherExpenseObjDB != null){
            _othersCostBusinessPlaceRent.setText(loanOtherExpenseObjDB.getRENT_OF_BUSINESS());
            _othersCostEmployeeSalary.setText(loanOtherExpenseObjDB.getSALARY_OF_EMPLOYEES());
            _othersCostTravelingCost.setText(loanOtherExpenseObjDB.getTRANSPORTATION_COSTS());
            _othersCostUtilityBills.setText(loanOtherExpenseObjDB.getUTILITY_COSTS());;
            _othersCostRepearingCost.setText(loanOtherExpenseObjDB.getREPAIR_COSTS());
            _othersCostPackagingCost.setText(loanOtherExpenseObjDB.getPACKAGING_COSTS());
            _othersCostVatTax.setText(loanOtherExpenseObjDB.getTAX_CHARGES());
            _othersCost.setText(loanOtherExpenseObjDB.getOTHER_EXP());
            calculate();
        }
    }

    private void initializeListner(){
       _othersCostBusinessPlaceRent.setOnFocusChangeListener(this);
       _othersCostEmployeeSalary.setOnFocusChangeListener(this);
       _othersCostTravelingCost.setOnFocusChangeListener(this);
       _othersCostUtilityBills.setOnFocusChangeListener(this);
       _othersCostRepearingCost.setOnFocusChangeListener(this);
       _othersCostPackagingCost.setOnFocusChangeListener(this);
       _othersCostVatTax.setOnFocusChangeListener(this);
       _othersCost.setOnFocusChangeListener(this);
    }

    private void calculate() {
        int othersCostBusinessPlaceRent = getNumberFromEditText(_othersCostBusinessPlaceRent);
        int othersCostEmployeeSalary = getNumberFromEditText(_othersCostEmployeeSalary);
        int othersCostTravelingCost = getNumberFromEditText(_othersCostTravelingCost);
        int othersCostUtilityBills = getNumberFromEditText(_othersCostUtilityBills);
        int othersCostRepearingCost = getNumberFromEditText(_othersCostRepearingCost);
        int othersCostPackagingCost = getNumberFromEditText(_othersCostPackagingCost);
        int othersCostVatTax = getNumberFromEditText(_othersCostVatTax);
        int othersCost = getNumberFromEditText(_othersCost);

        long total = othersCostBusinessPlaceRent + othersCostEmployeeSalary + othersCostTravelingCost +
                othersCostUtilityBills + othersCostRepearingCost + othersCostPackagingCost + othersCostVatTax + othersCost;
        _othersCostMonthlyAverage.setText(Utils.formatNumber(total) + "/-");

    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            calculate();
    }
}
