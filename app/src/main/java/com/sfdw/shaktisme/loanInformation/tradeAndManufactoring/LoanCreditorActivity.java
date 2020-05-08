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

public class LoanCreditorActivity extends BaseActivity implements View.OnFocusChangeListener {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)                                        TextView _name;
    @BindView(R.id.memberID)                                    TextView _memberID;
    @BindView(R.id.baki_buy_total_baki)                         EditText _bakiBuyTotalBaki;
    @BindView(R.id.baki_buy_total_baki_percentage_this_year)    EditText _bakiBuyTotalBakiPercentageThisYear;
    @BindView(R.id.baki_buy_paonadarer_kase_paona)              TextView _bakiBuyPaonadarerKasePaona;
    @BindView(R.id.saveBtn)                                     Button _saveBtn;
    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baki_buy);
        ButterKnife.bind(this);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");

        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());

        _bakiBuyTotalBaki.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    int a = Integer.parseInt(_bakiBuyTotalBaki.getText().toString());
                    _bakiBuyPaonadarerKasePaona.setText(a + "");
                }
            }
        });

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadFormIfDataAvailable();
            }
        });

        initializeListner();

    }

    private void setLoanCreditor(LoanDebtorCreditorBox data){
        data.setMEMBER_ID(member.getMEMBER_ID());
        data.setBRANCH_ID(member.getBRANCH_ID());
        data.setCENTER_ID(member.getCENTER_ID());
        data.setOWED_TO_CREDITORS(_bakiBuyTotalBaki.getText().toString());
        data.setOWED_TO_CREDITORS_PRCT(_bakiBuyTotalBakiPercentageThisYear.getText().toString());

    }

    private void saveToLocalStorage(){
        LoanDebtorCreditorBox loanCreditoer=objectBoxManager.GetLoanDebtorCreditorBox(member.getBRANCH_ID(),member.getMEMBER_ID());
        if (loanCreditoer == null){
            LoanDebtorCreditorBox newData = new LoanDebtorCreditorBox();
            setLoanCreditor(newData);
            objectBoxManager.SaveLoanDebtorCreditorBox(newData);
        }else
        {
            setLoanCreditor(loanCreditoer);
            objectBoxManager.SaveLoanDebtorCreditorBox(loanCreditoer);
        }

        Intent intent = new Intent(LoanCreditorActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails",member);
        startActivity(intent);
        finish();

    }

    private void loadFormIfDataAvailable(){
        LoanDebtorCreditorBox data = objectBoxManager.GetLoanDebtorCreditorBox(member.getBRANCH_ID(),member.getMEMBER_ID());
        if (data!=null){
            _bakiBuyTotalBaki.setText(data.getOWED_TO_CREDITORS());
            _bakiBuyTotalBakiPercentageThisYear.setText(data.getOWED_TO_CREDITORS_PRCT());
            calculate();
        }
    }

    private void initializeListner(){
        _bakiBuyTotalBaki.setOnFocusChangeListener(this);
        _bakiBuyTotalBakiPercentageThisYear.setOnFocusChangeListener(this);
    }

    private void calculate() {
        int bakiBuyTotalBaki = getNumberFromEditText(_bakiBuyTotalBaki);
        int bakiBuyTotalBakiPercentageThisYear = getNumberFromEditText(_bakiBuyTotalBakiPercentageThisYear);

        long total = bakiBuyTotalBaki + bakiBuyTotalBakiPercentageThisYear;
        _bakiBuyPaonadarerKasePaona.setText(Utils.formatNumber(total) + "/-");

    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            calculate();
    }

}
