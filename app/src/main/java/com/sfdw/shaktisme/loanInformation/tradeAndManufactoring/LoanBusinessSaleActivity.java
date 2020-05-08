package com.sfdw.shaktisme.loanInformation.tradeAndManufactoring;

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
import objectBox.LoanBusinessSaleBox;
import services.ObjectBoxManager;

import static bp.Utils.getLongFromEditText;

public class LoanBusinessSaleActivity extends BaseActivity {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)                            TextView _name;
    @BindView(R.id.memberID)                        TextView _memberID;
    @BindView(R.id.biz_sell_good_months_sell)       EditText _bizSellGoodMonthsSell;
    @BindView(R.id.biz_sell_good_months_number)     EditText _bizSellGoodMonthsNumber;
    @BindView(R.id.biz_sell_bad_months_sell)        EditText _bizSellBadMonthsSell;
    @BindView(R.id.biz_sell_bad_months_number)      EditText _bizSellBadMonthsNumber;
    @BindView(R.id.biz_sell_other_months_sell)      EditText _bizSellOtherMonthsSell;
    @BindView(R.id.biz_sell_other_months_number)    EditText _bizSellOtherMonthsNumber;
    @BindView(R.id.biz_sell_average_monthly_sales)  TextView _bizSellAverageMonthlySales;
    @BindView(R.id.saveBtn)                         Button   _saveBtn;

    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_sell);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        Log.e(TAG,member.getMEMBER_ID());
        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadFormIfDataAvailable();
            }
        });

        allOnclickListner();
    }

    private void allOnclickListner(){
        _bizSellGoodMonthsNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                try{
                    int b = Integer.parseInt(_bizSellGoodMonthsNumber.getText().toString());
                    int d = Integer.parseInt(_bizSellBadMonthsNumber.getText().toString());

                    if (b>12) {
                        _bizSellGoodMonthsNumber.setError(getResources().getString(R.string.biz_sell_mor_than_12_error));
                    }else {
                        _bizSellGoodMonthsNumber.setError(null);
                    }


                    if(b+d>12){
                        _bizSellBadMonthsNumber.setError(getResources().getString(R.string.biz_sell_mor_than_12_error));
                        _bizSellOtherMonthsNumber.setText("");

                    }else {
                        _bizSellOtherMonthsNumber.setText((12 - (b+d))+"");
                        _bizSellBadMonthsNumber.setError(null);
                    }


                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        _bizSellBadMonthsNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                    int b= Integer.parseInt(_bizSellGoodMonthsNumber.getText().toString());
                    int d=Integer.parseInt(_bizSellBadMonthsNumber.getText().toString());

                    if (b>12) {
                        _bizSellGoodMonthsNumber.setError(getResources().getString(R.string.biz_sell_mor_than_12_error));
                    }else {
                        _bizSellGoodMonthsNumber.setError(null);
                    }
                    if(b+d>12){
                        _bizSellBadMonthsNumber.setError(getResources().getString(R.string.biz_sell_mor_than_12_error));
                        _bizSellOtherMonthsNumber.setText("");
                    }else {
                        _bizSellOtherMonthsNumber.setText((12 - (b+d))+"");
                        _bizSellBadMonthsNumber.setError(null);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        _bizSellOtherMonthsSell.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                calculateAverageSales();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });
        _bizSellGoodMonthsSell.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                calculateAverageSales();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });
        _bizSellBadMonthsSell.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                calculateAverageSales();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });

    }

    private void setLoanBusinessSale(LoanBusinessSaleBox data) {
        data.setMEMBER_ID(member.getMEMBER_ID());
        data.setBRANCH_ID(member.getBRANCH_ID());
        data.setCENTER_ID(member.getCENTER_ID());
        data.setMAX_SALES(_bizSellGoodMonthsSell.getText().toString());
        data.setGOOD_MONTHS(_bizSellGoodMonthsNumber.getText().toString());
        data.setMIN_SALES(_bizSellBadMonthsSell.getText().toString());
        data.setBAD_MONTHS(_bizSellBadMonthsNumber.getText().toString());
        data.setAVERAGE_SALES(_bizSellOtherMonthsSell.getText().toString());
        data.setAVERAGE_MONTHS(_bizSellOtherMonthsNumber.getText().toString());

    }

    private void saveToLocalStorage(){
        LoanBusinessSaleBox loanBusinessSale = objectBoxManager.GetLoanBusinessSaleBox(member.getBRANCH_ID(), member.getMEMBER_ID());
        if (loanBusinessSale == null){
            LoanBusinessSaleBox newData = new LoanBusinessSaleBox();
            setLoanBusinessSale(newData);
            objectBoxManager.SaveLoanBusinessSaleBox(newData);
        }else
        {
            setLoanBusinessSale(loanBusinessSale);
            objectBoxManager.SaveLoanBusinessSaleBox(loanBusinessSale);
        }



        Intent intent = new Intent(LoanBusinessSaleActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails",member);
        startActivity(intent);
        finish();


    }

    private void loadFormIfDataAvailable(){

        LoanBusinessSaleBox data = objectBoxManager.GetLoanBusinessSaleBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (data != null){


                _bizSellGoodMonthsSell.setText(data.getMAX_SALES());
                _bizSellGoodMonthsNumber.setText(data.getGOOD_MONTHS());
                _bizSellBadMonthsSell.setText(data.getMIN_SALES());
                _bizSellBadMonthsNumber.setText(data.getBAD_MONTHS());
                _bizSellOtherMonthsSell.setText(data.getAVERAGE_SALES());
                _bizSellOtherMonthsNumber.setText(data.getAVERAGE_MONTHS());

                calculateAverageSales();

        }

    }

    private void calculateAverageSales(){
        try{
            long goodMonthSell = getLongFromEditText(_bizSellGoodMonthsSell);
            long goodMonths = getLongFromEditText(_bizSellGoodMonthsNumber);

            long badMonthSell = getLongFromEditText(_bizSellBadMonthsSell);
            long badMonths = getLongFromEditText(_bizSellBadMonthsNumber);

            long avgMonthsSell = getLongFromEditText(_bizSellOtherMonthsSell);
            long avgMonths = getLongFromEditText(_bizSellOtherMonthsNumber);

            long sum_sel = (goodMonthSell*goodMonths) + (badMonthSell*badMonths) + (avgMonthsSell*avgMonths);
            long sum_mon = goodMonths+badMonths+avgMonths;

            long sum_avg=sum_sel/sum_mon;

            _bizSellAverageMonthlySales.setText(Utils.formatNumber(sum_avg));


            if(Utils.findDifference(goodMonthSell,badMonthSell) >= Utils.differenceValue){
                Utils.showDialog(this, getString(R.string.warning10LaksDifference));
                return;
            }
            if(Utils.findDifference(goodMonthSell,avgMonthsSell)  >= Utils.differenceValue){
                Utils.showDialog(this, getString(R.string.warning10LaksDifference));
                return;
            }
            if(Utils.findDifference(badMonthSell,avgMonthsSell) >= Utils.differenceValue){
                Utils.showDialog(this, getString(R.string.warning10LaksDifference));
                return;
            }


        }catch (Exception e){
            Log.e(TAG, "getting error while calculating average ");
            e.printStackTrace();
        }
    }



}
