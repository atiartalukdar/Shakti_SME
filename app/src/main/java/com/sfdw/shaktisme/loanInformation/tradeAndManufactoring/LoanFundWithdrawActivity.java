package com.sfdw.shaktisme.loanInformation.tradeAndManufactoring;

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
import objectBox.LoanFundWithdrawBox;
import services.ObjectBoxManager;

import static bp.Utils.getNumberFromEditText;

public class LoanFundWithdrawActivity extends BaseActivity implements View.OnFocusChangeListener {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)                                TextView _name;
    @BindView(R.id.memberID)                            TextView _memberID;
    @BindView(R.id.fund_uttolon_for_owner)              EditText _fundUttolonForOwner;
    @BindView(R.id.fund_uttolon_for_savings)            EditText _fundUttolonForSavings;
    @BindView(R.id.fund_uttolon_for_personal_reason)    TextView _fundUttolonForPersonalReason;
    @BindView(R.id.saveBtn)                             Button _saveBtn;

    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p1_activity_fund_uttolon);
        ButterKnife.bind(this);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadFormIfDataAvailable();
            }
        });

        initializeListner();
    }

    private void setLoanFundWithdraw(LoanFundWithdrawBox loanFundWithdrawBox) {
        loanFundWithdrawBox.setBRANCH_ID(member.getBRANCH_ID());
        loanFundWithdrawBox.setCENTER_ID(member.getCENTER_ID());
        loanFundWithdrawBox.setMEMBER_ID(member.getMEMBER_ID());
        loanFundWithdrawBox.setEXPENSE(_fundUttolonForOwner.getText().toString());
        loanFundWithdrawBox.setSAVINGS(_fundUttolonForSavings.getText().toString());

    }

    private void saveToLocalStorage() {

        LoanFundWithdrawBox loanFundWithdraw = objectBoxManager.GetLoanFundWithdrawBox(member.getBRANCH_ID(), member.getMEMBER_ID());
        if (loanFundWithdraw == null) {
            LoanFundWithdrawBox newData = new LoanFundWithdrawBox();
            setLoanFundWithdraw(newData);
            objectBoxManager.SaveLoanFundWithdrawBox(newData);
        } else {
            setLoanFundWithdraw(loanFundWithdraw);
            objectBoxManager.SaveLoanFundWithdrawBox(loanFundWithdraw);
        }

        Intent intent = new Intent(LoanFundWithdrawActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails", member);
        startActivity(intent);
        finish();
    }

    private void loadFormIfDataAvailable() {

        LoanFundWithdrawBox loanOtherExpenseDB = objectBoxManager.GetLoanFundWithdrawBox(member.getBRANCH_ID(), member.getMEMBER_ID());
        if (loanOtherExpenseDB != null) {
            _fundUttolonForOwner.setText(loanOtherExpenseDB.getEXPENSE());
            _fundUttolonForSavings.setText(loanOtherExpenseDB.getSAVINGS());
            calculate();
        }
    }

    private void initializeListner(){
        _fundUttolonForOwner.setOnFocusChangeListener(this);
        _fundUttolonForSavings.setOnFocusChangeListener(this);
    }

    private void calculate() {
        int fundUttolonForOwner = getNumberFromEditText(_fundUttolonForOwner);
        int fundUttolonForSavings = getNumberFromEditText(_fundUttolonForSavings);

        long total = fundUttolonForOwner + fundUttolonForSavings;
        _fundUttolonForPersonalReason.setText(Utils.formatNumber(total) + "/-");

    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            calculate();
    }
}
