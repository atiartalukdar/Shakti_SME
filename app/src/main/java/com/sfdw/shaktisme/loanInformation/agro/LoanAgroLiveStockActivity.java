package com.sfdw.shaktisme.loanInformation.agro;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
import objectBox.LoanAgroLiveStockBox;
import services.ObjectBoxManager;

import static bp.Utils.getNumberFromEditText;

public class LoanAgroLiveStockActivity extends BaseActivity implements View.OnFocusChangeListener {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    private ObjectBoxManager _objectBoxManager = new ObjectBoxManager();

    @BindView(R.id.name)                    TextView _name;
    @BindView(R.id.memberID)                TextView _memberID;
    @BindView(R.id.agro_cow_shed_cost)      EditText _agroCowShedCost;
    @BindView(R.id.agro_no_of_cow)          EditText _agroNoOfCow;
    @BindView(R.id.agro_cow_price)          EditText _agroCowPrice;
    @BindView(R.id.agro_no_of_calves)       EditText _agroNoOfCalves;
    @BindView(R.id.agro_calves_price)       EditText _agroCalvesPrice;
    @BindView(R.id.agro_no_of_cattle)       EditText _agroNoOfCattle;
    @BindView(R.id.agro_cattle_price)       EditText _agroCattlePrice;
    @BindView(R.id.total_price_agro)        TextView _totalpriceAgro;
    @BindView(R.id.saveBtn)                 Button _saveBtn;

    private MemberListDM.Data member;

    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_agro_live_stock);
        ButterKnife.bind(this);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        Log.e(TAG, member.getMEMBER_ID());
        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());

        loadUIIfAvailable();
        initializeListner();
    }

    private void setLoanAgroLiveStoc(LoanAgroLiveStockBox data) {
        data.setMEMBER_ID(member.getMEMBER_ID());
        data.setBRANCH_ID(member.getBRANCH_ID());
        data.setCENTER_ID(member.getCENTER_ID());
        data.setCOW_SHED_COST(_agroCowShedCost.getText().toString());
        data.setNO_OF_COWS(_agroNoOfCow.getText().toString());
        data.setCOW_PRICE(_agroCowPrice.getText().toString());
        data.setNO_OF_CALVES(_agroNoOfCalves.getText().toString());
        data.setCALVES_PRICE(_agroCalvesPrice.getText().toString());
        data.setNO_OF_CATTLE(_agroNoOfCattle.getText().toString());
        data.setCATTLE_PRICE(_agroCattlePrice.getText().toString());

    }

    private void saveToLocalStorage() {
        LoanAgroLiveStockBox agroLiveStock = _objectBoxManager.GetLoanAgroLiveStockBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (agroLiveStock == null) {
            LoanAgroLiveStockBox newData = new LoanAgroLiveStockBox();
            setLoanAgroLiveStoc(newData);
            _objectBoxManager.SaveLoanAgroLiveStockBox(newData);
        } else {
            setLoanAgroLiveStoc(agroLiveStock);
            _objectBoxManager.SaveLoanAgroLiveStockBox(agroLiveStock);
        }

        Intent intent = new Intent(LoanAgroLiveStockActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails", member);
        startActivity(intent);
        finish();

    }

    private void loadUIIfAvailable() {
        LoanAgroLiveStockBox data = _objectBoxManager.GetLoanAgroLiveStockBox(member.getBRANCH_ID(), member.getMEMBER_ID());
        if (data != null) {
            _agroCowShedCost.setText(data.getCOW_SHED_COST());
            _agroNoOfCow.setText(data.getNO_OF_COWS());
            _agroCowPrice.setText(data.getCOW_PRICE());
            _agroNoOfCalves.setText(data.getNO_OF_CALVES());
            _agroCalvesPrice.setText(data.getCALVES_PRICE());
            _agroNoOfCattle.setText(data.getNO_OF_CATTLE());
            _agroCattlePrice.setText(data.getCATTLE_PRICE());
            calculate();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private void initializeListner(){
        _agroCowShedCost.setOnFocusChangeListener(this);
        _agroNoOfCow.setOnFocusChangeListener(this);
        _agroCowPrice.setOnFocusChangeListener(this);
        _agroNoOfCalves.setOnFocusChangeListener(this);
        _agroCalvesPrice.setOnFocusChangeListener(this);
        _agroNoOfCattle.setOnFocusChangeListener(this);
        _agroCattlePrice.setOnFocusChangeListener(this);
    }
    private void calculate() {
        int agroCowShedCost = getNumberFromEditText(_agroCowShedCost);
        int agroNoOfCow = getNumberFromEditText(_agroNoOfCow);
        int agroCowPrice = getNumberFromEditText(_agroCowPrice);
        int agroNoOfCalves = getNumberFromEditText(_agroNoOfCalves);
        int agroCalvesPrice = getNumberFromEditText(_agroCalvesPrice);
        int agroNoOfCattle = getNumberFromEditText(_agroNoOfCattle);
        int agroCattlePrice = getNumberFromEditText(_agroCattlePrice);

        long sum = agroCowShedCost+ (agroNoOfCow*agroCowPrice) + (agroNoOfCalves*agroCalvesPrice) +
                (agroNoOfCattle*agroCattlePrice);

        _totalpriceAgro.setText(Utils.formatNumber(sum)+"/-");

    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            calculate();
    }

}
