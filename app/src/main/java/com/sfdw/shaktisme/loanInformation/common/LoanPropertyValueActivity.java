package com.sfdw.shaktisme.loanInformation.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.LoanAssessmentActivity;

import bp.BaseActivity;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.MemberListDM;
import objectBox.LoanPropertyValueBox;
import services.ObjectBoxManager;

import static bp.Utils.getNumberFromEditText;

public class LoanPropertyValueActivity extends BaseActivity implements View.OnFocusChangeListener {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)                                        TextView _name;
    @BindView(R.id.memberID)                                    TextView _memberID;
    @BindView(R.id.land_price_own_land)                         EditText _currentValue;
    @BindView(R.id.land_price_rented_land)                      EditText _outStandingRent;
    @BindView(R.id.land_price_furniture_price)                  EditText _valueOfFurniture;
    @BindView(R.id.land_price_machineries_price)                EditText  _valueOfMachineries;
    @BindView(R.id.land_price_others)                           EditText _valueOfOthers;
    @BindView(R.id.land_price_asset_improvement_cost)           EditText _propertyDevelopmentCost;
    @BindView(R.id.radioBtn_paka_house)                         RadioButton _houseTypeRadioBtnPakaBari;
    @BindView(R.id.radioBtn_adha_paka_bari)                     RadioButton _houseTypeRadioBtnAdhaPakaBari;
    @BindView(R.id.radioBtn_tin_shed)                           RadioButton _houseTypeRadioBtnTinShed;
    @BindView(R.id.radioGunogoto_reputation)                    RadioGroup _houseTypeRadioGroup;
    @BindView(R.id.land_price_asset_price_related_to_business)  TextView _landPriceAssetPriceRelatedToBusiness;
    @BindView(R.id.saveBtn)                                     Button _saveBtn;

    public void saveBtn(View view) {
        saveToLocalStorage();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_price);
        ButterKnife.bind(this);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) +member.getMEMBER_ID());

        loadUIIfAvailable();

        initializeListner();
    }

    private void setLoanPropertyValueBox(LoanPropertyValueBox data){
        data.setMEMBER_ID(member.getMEMBER_ID());
        data.setBRANCH_ID(member.getBRANCH_ID());
        data.setCENTER_ID(member.getCENTER_ID());
        data.setCURRENT_VAL(_currentValue.getText().toString());
        data.setOUTSTANDING_RENT(_outStandingRent.getText().toString());
        data.setVAL_OF_FURNITURES(_valueOfFurniture.getText().toString());
        data.setVAL_OF_MACHINARIES(_valueOfMachineries.getText().toString());
        data.setVAL_OF_OTHERS(_valueOfOthers.getText().toString());
        data.setPROPERTY_DEV_COST(_propertyDevelopmentCost.getText().toString());
        String houseType = "";

        switch (_houseTypeRadioGroup.getCheckedRadioButtonId()){
            case R.id.radioBtn_paka_house:
                houseType = "1";
                break;
            case R.id.radioBtn_adha_paka_bari:
                houseType = "2";
                break;
            case R.id.radioBtn_tin_shed:
                houseType = "3";
                break;
        }

        data.setHOUSE_TYPE(houseType);
    }

    private void saveToLocalStorage(){
        LoanPropertyValueBox loanPropertyValue = objectBoxManager.GetLoanPropertyValueBox(member.getBRANCH_ID(),member.getMEMBER_ID());

        if (loanPropertyValue == null){
            LoanPropertyValueBox newData = new LoanPropertyValueBox();
            setLoanPropertyValueBox(newData);
            objectBoxManager.SaveLoanPropertyValueBox(newData);
        }else
        {
            setLoanPropertyValueBox(loanPropertyValue);
            objectBoxManager.SaveLoanPropertyValueBox(loanPropertyValue);
        }

        Intent intent = new Intent(LoanPropertyValueActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails",member);
        startActivity(intent);
        finish();

    }

    private void loadUIIfAvailable(){
        LoanPropertyValueBox data = objectBoxManager.GetLoanPropertyValueBox(member.getBRANCH_ID(),member.getMEMBER_ID());

        if (data!=null){

            _currentValue.setText(data.getCURRENT_VAL());
            _outStandingRent.setText(data.getOUTSTANDING_RENT());
            _valueOfFurniture.setText(data.getOUTSTANDING_RENT());
            _valueOfMachineries.setText(data.getVAL_OF_MACHINARIES());
            _valueOfOthers.setText(data.getVAL_OF_OTHERS());
            _propertyDevelopmentCost.setText(data.getPROPERTY_DEV_COST());

            switch (data.getHOUSE_TYPE()){

                case "1":
                    _houseTypeRadioGroup.check(R.id.radioBtn_paka_house);
                    break;
                case "2":
                    _houseTypeRadioGroup.check(R.id.radioBtn_adha_paka_bari);
                    break;
                case "3":
                    _houseTypeRadioGroup.check(R.id.radioBtn_tin_shed);
                    break;
            }
        }

    }

    private void initializeListner(){
        _currentValue.setOnFocusChangeListener(this);
        _outStandingRent.setOnFocusChangeListener(this);
        _valueOfFurniture.setOnFocusChangeListener(this);
         _valueOfMachineries.setOnFocusChangeListener(this);
        _valueOfOthers.setOnFocusChangeListener(this);
        _propertyDevelopmentCost.setOnFocusChangeListener(this);
    }

    private void calculate() {
        int currentValue = getNumberFromEditText(_currentValue);
        int outStandingRent = getNumberFromEditText(_outStandingRent);
        int valueOfFurniture = getNumberFromEditText(_valueOfFurniture);
        int valueOfMachineries = getNumberFromEditText(_valueOfMachineries);
        int valueOfOthers = getNumberFromEditText(_valueOfOthers);
        int propertyDevelopmentCost = getNumberFromEditText(_propertyDevelopmentCost);

        long total = currentValue + outStandingRent + valueOfFurniture + valueOfMachineries +
                valueOfOthers + propertyDevelopmentCost ;
        _landPriceAssetPriceRelatedToBusiness.setText(Utils.formatNumber(total) + "/-");

    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus)
            calculate();
    }
}
