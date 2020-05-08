package com.sfdw.shaktisme.loanInformation.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.LoanAssessmentActivity;

import bp.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.MemberListDM;
import interfaces.IObjectBoxManager;
import io.objectbox.Box;
import objectBox.LoanGuarantorBox;
import objectBox.LoanGuarantorBox_;
import objectBox.ObjectBox;
import services.ObjectBoxManager;

public class LoanGuarantorInfoActivity extends BaseActivity {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)                                TextView _name;
    @BindView(R.id.memberID)                            TextView _memberID;
    @BindView(R.id.topText1)                            TextView _topText1;
    @BindView(R.id.name_tv)                             TextView _nameTv;
    @BindView(R.id.ed_guarantor1_name)                  EditText _edGuarantor1Name;
    @BindView(R.id.father_name_tv)                      TextView _fatherNameTv;
    @BindView(R.id.ed_guarantor1_nid)                   EditText _edGuarantor1Nid;
    @BindView(R.id.occupation_tv)                       TextView _occupationTv;
    @BindView(R.id.ed_guarantor1_occupation)            EditText _edGuarantor1Occupation;
    @BindView(R.id.relation_tv)                         TextView _relationTv;
    @BindView(R.id.ed_guarantor1_parmanent_address)     EditText _edGuarantor1ParmanentAddress;
    @BindView(R.id.ed_guarantor1_business_address)      EditText _edGuarantor1BusinessAddress;
    @BindView(R.id.ed_guarantor1_bank_name)             EditText _edGuarantor1BankName;
    @BindView(R.id.ed_guarantor1_bank_account_number)   EditText _edGuarantor1BankAccountNumber;
    @BindView(R.id.ed_guarantor1_monthly_income)        EditText _edGuarantor1MonthlyIncome;
    @BindView(R.id.ed_guarantor1_mobile_number)         EditText _edGuarantor1MobileNumber;
    @BindView(R.id.topText2)                            TextView _topText2;
    @BindView(R.id.ed_guarantor2_name)                  EditText _edGuarantor2Name;
    @BindView(R.id.ed_guarantor2_nid)                   EditText _edGuarantor2Nid;
    @BindView(R.id.ed_guarantor2_occupation)            EditText _edGuarantor2Occupation;
    @BindView(R.id.ed_guarantor2_parmanent_address)     EditText _edGuarantor2ParmanentAddress;
    @BindView(R.id.ed_guarantor2_business_address)      EditText _edGuarantor2BusinessAddress;
    @BindView(R.id.ed_guarantor2_bank_name)             EditText _edGuarantor2BankName;
    @BindView(R.id.ed_guarantor2_bank_account_number)   EditText _edGuarantor2BankAccountNumber;
    @BindView(R.id.ed_guarantor2_monthly_income)        EditText _edGuarantor2MonthlyIncome;
    @BindView(R.id.ed_guarantor2_mobile_number)         EditText _edGuarantor2MobileNumber;
    @BindView(R.id.saveBtn)                             Button _saveBtn;


    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    Box<LoanGuarantorBox> loanGuarantorBoxBox;
    private IObjectBoxManager _objectBoxManager = new ObjectBoxManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guarantor_information2);
        ButterKnife.bind(this);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        Log.e(TAG,member.getMEMBER_ID());
        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());

        loanGuarantorBoxBox= ObjectBox.get().boxFor(LoanGuarantorBox.class);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadFormIfDataAvailable();
            }
        });


    }

    private void setGuarantorInfo1(LoanGuarantorBox loanGuarantorBox){
        loanGuarantorBox.setBRANCH_ID(member.getBRANCH_ID());
        loanGuarantorBox.setCENTER_ID(member.getCENTER_ID());
        loanGuarantorBox.setMEMBER_ID(member.getMEMBER_ID());
        loanGuarantorBox.setG_TYPE("F");
        loanGuarantorBox.setG_NAME(_edGuarantor1Name.getText().toString());
        loanGuarantorBox.setG_NID(_edGuarantor1Nid.getText().toString());
        loanGuarantorBox.setOCCUPATION(_edGuarantor1Occupation.getText().toString());
        loanGuarantorBox.setHOME_ADDRESS(_edGuarantor1ParmanentAddress.getText().toString());
        loanGuarantorBox.setBUSINESS_ADDRESS(_edGuarantor1BusinessAddress.getText().toString());
        loanGuarantorBox.setNAMEOF_BANK(_edGuarantor1BankName.getText().toString());
        loanGuarantorBox.setACCOUNT_NO(_edGuarantor1BankAccountNumber.getText().toString());
        loanGuarantorBox.setMONTHLY_INCOME(_edGuarantor1MonthlyIncome.getText().toString());
        loanGuarantorBox.setMOBILE_NO(_edGuarantor1MobileNumber.getText().toString());
    }

    private void setGuarantorInfo2(LoanGuarantorBox loanGuarantorBox){
        loanGuarantorBox.setBRANCH_ID(member.getBRANCH_ID());
        loanGuarantorBox.setCENTER_ID(member.getCENTER_ID());
        loanGuarantorBox.setMEMBER_ID(member.getMEMBER_ID());
        loanGuarantorBox.setG_TYPE("O");
        loanGuarantorBox.setG_NAME(_edGuarantor2Name.getText().toString());
        loanGuarantorBox.setG_NID(_edGuarantor2Nid.getText().toString());
        loanGuarantorBox.setOCCUPATION(_edGuarantor2Occupation.getText().toString());
        loanGuarantorBox.setHOME_ADDRESS(_edGuarantor2ParmanentAddress.getText().toString());
        loanGuarantorBox.setBUSINESS_ADDRESS(_edGuarantor2BusinessAddress.getText().toString());
        loanGuarantorBox.setNAMEOF_BANK(_edGuarantor2BankName.getText().toString());
        loanGuarantorBox.setACCOUNT_NO(_edGuarantor2BankAccountNumber.getText().toString());
        loanGuarantorBox.setMONTHLY_INCOME(_edGuarantor2MonthlyIncome.getText().toString());
        loanGuarantorBox.setMOBILE_NO(_edGuarantor2MobileNumber.getText().toString());
    }

    private void saveToLocalStorage(){

        // Guarantor 1
        LoanGuarantorBox loanGuarantor1 = new LoanGuarantorBox();
        setGuarantorInfo1(loanGuarantor1);

        LoanGuarantorBox guarantorDB1 = loanGuarantorBoxBox.query().equal(LoanGuarantorBox_.MEMBER_ID,member.getMEMBER_ID())
                .and().equal(LoanGuarantorBox_.G_TYPE,loanGuarantor1.getG_TYPE()).build().findFirst();
        if (guarantorDB1 != null){
            setGuarantorInfo1(guarantorDB1);
            loanGuarantorBoxBox.put(guarantorDB1);
        }else {
            loanGuarantorBoxBox.put(loanGuarantor1);
        }

        // Guarantor 2
        LoanGuarantorBox loanGuarantor2 = new LoanGuarantorBox();
        setGuarantorInfo2(loanGuarantor2);

        LoanGuarantorBox guarantorDB2 = loanGuarantorBoxBox.query().equal(LoanGuarantorBox_.MEMBER_ID,member.getMEMBER_ID())
                .equal(LoanGuarantorBox_.G_TYPE, loanGuarantor2.getG_TYPE()).build().findFirst();
        if (guarantorDB2 != null){
            setGuarantorInfo2(guarantorDB2);
            loanGuarantorBoxBox.put(guarantorDB2);
        }else {
            loanGuarantorBoxBox.put(loanGuarantor2);
        }

        Intent intent = new Intent(LoanGuarantorInfoActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails",member);
        startActivity(intent);
        finish();
    }

    private void loadFormIfDataAvailable(){

        LoanGuarantorBox guarantorDB1 = loanGuarantorBoxBox.query().equal(LoanGuarantorBox_.MEMBER_ID,member.getMEMBER_ID()).and().equal(LoanGuarantorBox_.G_TYPE,"F").build().findFirst();
        if (guarantorDB1 != null){
            _edGuarantor1Name.setText(guarantorDB1.getG_NAME());
            _edGuarantor1Nid.setText(guarantorDB1.getG_NID());
            _edGuarantor1ParmanentAddress.setText(guarantorDB1.getHOME_ADDRESS());
            _edGuarantor1BusinessAddress.setText(guarantorDB1.getBUSINESS_ADDRESS());
            _edGuarantor1BankName.setText(guarantorDB1.getNAMEOF_BANK());
            _edGuarantor1Occupation.setText(guarantorDB1.getOCCUPATION());
            _edGuarantor1BankAccountNumber.setText(guarantorDB1.getACCOUNT_NO());
            _edGuarantor1MonthlyIncome.setText(guarantorDB1.getMONTHLY_INCOME());
            _edGuarantor1MobileNumber.setText(guarantorDB1.getMOBILE_NO());
        }

        LoanGuarantorBox guarantorDB2 = loanGuarantorBoxBox.query().equal(LoanGuarantorBox_.MEMBER_ID,member.getMEMBER_ID()).and().equal(LoanGuarantorBox_.G_TYPE,"O").build().findFirst();
        if (guarantorDB2 != null){
            _edGuarantor2Name.setText(guarantorDB2.getG_NAME());
            _edGuarantor2Nid.setText(guarantorDB2.getG_NID());
            _edGuarantor2ParmanentAddress.setText(guarantorDB2.getHOME_ADDRESS());
            _edGuarantor2BusinessAddress.setText(guarantorDB2.getBUSINESS_ADDRESS());
            _edGuarantor2BankName.setText(guarantorDB2.getNAMEOF_BANK());
            _edGuarantor2Occupation.setText(guarantorDB2.getOCCUPATION());
            _edGuarantor2BankAccountNumber.setText(guarantorDB2.getACCOUNT_NO());
            _edGuarantor2MonthlyIncome.setText(guarantorDB2.getMONTHLY_INCOME());
            _edGuarantor2MobileNumber.setText(guarantorDB2.getMOBILE_NO());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
