package com.sfdw.shaktisme.loanInformation.common;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.LoanAssessmentActivity;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import bp.BaseActivity;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.BankNameDM;
import dataModelNew.BranchNameDM;
import dataModelNew.LoadConfigurationDM;
import dataModelNew.MemberListDM;
import objectBox.BankBranchBox;
import objectBox.LoanBankAccountBox;
import rettrofit.APIManager;
import rettrofit.RequestListener;
import services.ObjectBoxManager;
import services.ServiceManager;

public class LoanBankAccountActivity extends BaseActivity {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    private ObjectBoxManager _objectBoxManager = new ObjectBoxManager();
    private APIManager _apiManager = new APIManager();
    private ServiceManager _serviceManager = new ServiceManager();

    @BindView(R.id.name)
    TextView _name;
    @BindView(R.id.memberID)
    TextView _memberID;
    @BindView(R.id.bank_account_name)
    EditText _bankAccountName;
    @BindView(R.id.bank_name)
    Spinner _bankNameSpinner;
    @BindView(R.id.bank_branch_name)
    Spinner _bankBranchNameSpinner;
    @BindView(R.id.bank_branch_address)
    EditText _bankBranchAddress;
    @BindView(R.id.bank_account_no)
    EditText _bankAccountNo;
    @BindView(R.id.bank_routing_no)
    EditText _bankRoutingNo;
    @BindView(R.id.bank_account_type)
    Spinner _bankAccountTypeSpinner;
    @BindView(R.id.bank_cash_in_hand)
    EditText _bankCashInHand;
    @BindView(R.id.bank_cash_at_bank)
    EditText _bankCashAtBank;
    @BindView(R.id.mobile_account_no)
    EditText _mobileAccountNo;
    @BindView(R.id.bank_account_image)
    ImageView _bankAccountImage;
    @BindView(R.id.saveBtn)
    Button _saveBtn;

    String _bankAccountImageDoc;
    private MemberListDM.Data member;

    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    ArrayList<LoadConfigurationDM.BankList> bankArray = new ArrayList<>();
    ArrayList<BankBranchBox> branchArray = new ArrayList<>();
    ArrayList<String> accountTypeArray = new ArrayList<>();

    ArrayAdapter<LoadConfigurationDM.BankList> bankNameAdapter;
    ArrayAdapter<BankBranchBox> branchAdapter;
    ArrayAdapter<String> accountTypeAdapter;

    String selectedBankCode = "";
    String selectedBranchCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_bank_account);
        ButterKnife.bind(this);
        branchAdapter = new ArrayAdapter<>(LoanBankAccountActivity.this, android.R.layout.simple_spinner_dropdown_item, branchArray);
        _bankBranchNameSpinner.setAdapter(branchAdapter);

        bankNameAdapter = new ArrayAdapter<>(LoanBankAccountActivity.this, android.R.layout.simple_spinner_dropdown_item, bankArray);
        _bankNameSpinner.setAdapter(bankNameAdapter);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());

        getBankLinkFromServer();

        _bankNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                KProgressHUD kProgressHUD = Utils.showProgressDialog(LoanBankAccountActivity.this, "Loading Branch ...");
                selectedBankCode = bankArray.get(position).getBANKCODE();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        branchArray.clear();
                        branchArray.addAll(_serviceManager.getBankBranchList(selectedBankCode));
                        branchAdapter.notifyDataSetChanged();
                    }
                });

                kProgressHUD.dismiss();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        _bankBranchNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedBranchCode = branchArray.get(position).getBBID() + "";
                _bankRoutingNo.setText(branchArray.get(position).getROUTINGNUMBER());
                _bankRoutingNo.setEnabled(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        accountTypeArray.add("চলতি হিসাব");
        accountTypeArray.add("সঞ্চয়ী হিসাব");
        accountTypeAdapter = new ArrayAdapter<>(LoanBankAccountActivity.this, android.R.layout.simple_spinner_dropdown_item, accountTypeArray);
        _bankAccountTypeSpinner.setAdapter(accountTypeAdapter);
        _bankAccountImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureImage();
            }
        });
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadFormIfDataAvailable();
            }
        });
    }

    private void setLoanBankAccount(LoanBankAccountBox loanBankAccountBox) {
        loanBankAccountBox.setMEMBER_ID(member.getMEMBER_ID());
        loanBankAccountBox.setBRANCH_ID(member.getBRANCH_ID());
        loanBankAccountBox.setCENTER_ID(member.getCENTER_ID());

        loanBankAccountBox.setACCOUNT_NAME(_bankAccountName.getText().toString());
        loanBankAccountBox.setBANK_CODE(selectedBankCode);
        loanBankAccountBox.setBANK_BRANCH_ID(selectedBranchCode);
        loanBankAccountBox.setBRANCH_ADDRESS(_bankBranchAddress.getText().toString());
        loanBankAccountBox.setACCOUNT_NO(_bankAccountNo.getText().toString());
        loanBankAccountBox.setROUTING_NO(_bankRoutingNo.getText().toString());
        loanBankAccountBox.setCASH_IN_HAND(_bankCashInHand.getText().toString());
        loanBankAccountBox.setCASH_AT_BANK(_bankCashAtBank.getText().toString());
        loanBankAccountBox.setACCOUNT_TYPE(_bankAccountTypeSpinner.getSelectedItemId() + 1 + "");
        loanBankAccountBox.setMOBILE_ACC_NO(_mobileAccountNo.getText().toString());
        loanBankAccountBox.setCHEQUE_BOOK_LEAF_DOC(_bankAccountImageDoc);

        //TODO Set Bank Releted Image
        //loanBankAccountBox.setCHEQUE_BOOK_LEAF_DOC(_bankAccountImage.getText().toString());


    }

    private void saveToLocalStorage() {
        LoanBankAccountBox dbData = _objectBoxManager.GetLoanBankAccountBox(member.getBRANCH_ID(), member.getMEMBER_ID());
        if (dbData == null) {
            LoanBankAccountBox newData = new LoanBankAccountBox();
            setLoanBankAccount(newData);
            _objectBoxManager.SaveLoanBankAccountBox(newData);
        } else {
            setLoanBankAccount(dbData);
            _objectBoxManager.SaveLoanBankAccountBox(dbData);
        }
        Intent intent = new Intent(LoanBankAccountActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails", member);
        startActivity(intent);
        finish();
    }

    private void loadFormIfDataAvailable() {

        LoanBankAccountBox loanBankAccountObjDB = _objectBoxManager.GetLoanBankAccountBox(member.getBRANCH_ID(), member.getMEMBER_ID());
        if (loanBankAccountObjDB != null) {
            try{

                branchArray.clear();
                branchArray.addAll(_serviceManager.getBankBranchList(loanBankAccountObjDB.getBANK_CODE()));
                branchAdapter.notifyDataSetChanged();

                _bankAccountName.setText(loanBankAccountObjDB.getACCOUNT_NAME());
                _bankBranchAddress.setText(loanBankAccountObjDB.getBRANCH_ADDRESS());
                _bankAccountNo.setText(loanBankAccountObjDB.getACCOUNT_NO());
                _bankRoutingNo.setText(loanBankAccountObjDB.getROUTING_NO());

                _bankAccountTypeSpinner.setSelection(Integer.parseInt(loanBankAccountObjDB.getACCOUNT_TYPE()) - 1);
                _bankCashInHand.setText(loanBankAccountObjDB.getCASH_IN_HAND());
                _bankCashAtBank.setText(loanBankAccountObjDB.getCASH_AT_BANK());
                _mobileAccountNo.setText(loanBankAccountObjDB.getMOBILE_ACC_NO());



                if (loanBankAccountObjDB.getCHEQUE_BOOK_LEAF_DOC() != null){
                    _bankAccountImageDoc = loanBankAccountObjDB.getCHEQUE_BOOK_LEAF_DOC();
                    byte[] decodedString = Base64.decode(loanBankAccountObjDB.getCHEQUE_BOOK_LEAF_DOC(), Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    _bankAccountImage.setImageBitmap(decodedByte);
                }

                try {
                    _bankNameSpinner.post(()->{
                        _bankNameSpinner.setSelection(getBankPosition(loanBankAccountObjDB.getBANK_CODE()));
                    });

                }catch (Exception e){
                    e.printStackTrace();
                }

                try{
                    _bankBranchNameSpinner.post(()->{
                        _bankBranchNameSpinner.setSelection(getBranchPosition(loanBankAccountObjDB.getBANK_BRANCH_ID()));
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
                //TODO SET Spinner Position
                // _bankAccountImage.setImageResource();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    private void getBankLinkFromServer() {
        KProgressHUD kProgressHUD = Utils.showProgressDialog(this, "Loading Bank ...");
        bankArray.addAll(_serviceManager.getBankList());
        kProgressHUD.dismiss();
        bankNameAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    static final int REQUEST_IMAGE = 1000;
    static final int REQUEST_IMAGE_CROP = 1001;

    private void captureImage() {
        Utils.captureImage(this,REQUEST_IMAGE);
    }

    public int getBankPosition(String BankCode) {
        for (int i=0; i< bankArray.size(); i++) {
            if (bankArray.get(i).getBANKCODE().toLowerCase().trim().equals(BankCode.toLowerCase().trim())) {
                return i;
            }
        }
        return 0;
    }

    public int getBranchPosition(String bankBranchID) {
        for (int i=0; i< branchArray.size(); i++) {
            if (branchArray.get(i).getBBID() == Integer.parseInt(bankBranchID)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // Check for the integer request code originally supplied to startResolutionForResult().

            case REQUEST_IMAGE:
                Intent i2 = CropImage.activity(Utils.photoURI)
                        .getIntent(this);
                startActivityForResult(i2,REQUEST_IMAGE_CROP );
                break;
            case REQUEST_IMAGE_CROP:
                Bitmap image = Utils.getBitMapImageFromIntent(this,requestCode,resultCode,data);
                if (image != null){
                    _bankAccountImage.setImageBitmap(image);
                    _bankAccountImageDoc  = Utils.convertToBase64(image);
                }
                break;


        }
    }


}
