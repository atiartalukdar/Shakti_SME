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
import objectBox.LoanDebtorCreditorBox;
import services.ObjectBoxManager;

import static bp.Utils.getNumberFromEditText;

public class LoanDebtorActivity extends BaseActivity implements View.OnFocusChangeListener {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)                                            TextView _name;
    @BindView(R.id.memberID)                                        TextView _memberID;
    @BindView(R.id.baki_sell_total_baki)                            EditText _bakiSellTotalBaki;
    @BindView(R.id.baki_sell_total_baki_percentage_this_year)       EditText _bakiSellTotalBakiPercentageThisYear;
    @BindView(R.id.baki_sell_kretader_kase_paona)                   TextView _bakiSellKretaderKasePaona;
    @BindView(R.id.saveBtn)                                         Button _saveBtn;

    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baki_sell);
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

    private void setLoanDebtorBox(LoanDebtorCreditorBox data) {
        data.setMEMBER_ID(member.getMEMBER_ID());
        data.setBRANCH_ID(member.getBRANCH_ID());
        data.setCENTER_ID(member.getCENTER_ID());
        data.setOWED_BY_DEBITORS(_bakiSellTotalBaki.getText().toString());
        data.setOWED_BY_DEBITORS_PRCT(_bakiSellTotalBakiPercentageThisYear.getText().toString());

    }

    private void saveToLocalStorage() {
        LoanDebtorCreditorBox loanDebtor = objectBoxManager.GetLoanDebtorCreditorBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (loanDebtor == null) {
            LoanDebtorCreditorBox newData = new LoanDebtorCreditorBox();
            setLoanDebtorBox(newData);
            objectBoxManager.SaveLoanDebtorCreditorBox(newData);
        } else {
            setLoanDebtorBox(loanDebtor);
            objectBoxManager.SaveLoanDebtorCreditorBox(loanDebtor);
        }

        Intent intent = new Intent(LoanDebtorActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails", member);
        startActivity(intent);
        finish();
    }

    private void loadFormIfDataAvailable() {
        LoanDebtorCreditorBox data = objectBoxManager.GetLoanDebtorCreditorBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (data != null) {
            _bakiSellTotalBaki.setText(data.getOWED_BY_DEBITORS());
            _bakiSellTotalBakiPercentageThisYear.setText(data.getOWED_BY_DEBITORS_PRCT());
            calculate();
        }
    }

    private void initializeListner(){
        _bakiSellTotalBaki.setOnFocusChangeListener(this);
        _bakiSellTotalBakiPercentageThisYear.setOnFocusChangeListener(this);
    }

    private void calculate() {
        int bakiSellTotalBaki = getNumberFromEditText(_bakiSellTotalBaki);
        int bakiSellTotalBakiPercentageThisYear = getNumberFromEditText(_bakiSellTotalBakiPercentageThisYear);

        long total = bakiSellTotalBaki + bakiSellTotalBakiPercentageThisYear;
        _bakiSellKretaderKasePaona.setText(Utils.formatNumber(total) + "/-");

    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            calculate();
    }

}
