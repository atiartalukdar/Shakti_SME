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
import objectBox.LoanCostOfGoodsBox;
import services.ObjectBoxManager;

import static bp.Utils.getNumberFromEditText;

public class LoanCostOfGoodsActivity extends BaseActivity {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)
    TextView _name;
    @BindView(R.id.memberID)
    TextView _memberID;
    @BindView(R.id.raw_meterials_most_expense_to_buy)
    EditText _rawMeterialsMostExpenseToBuy;
    @BindView(R.id.raw_meterials_most_expense_months)
    EditText _rawMeterialsMostExpenseMonths;
    @BindView(R.id.raw_meterials_less_expense_to_buy)
    EditText _rawMeterialsLessExpenseToBuy;
    @BindView(R.id.raw_meterials_less_expense_months)
    EditText _rawMeterialsLessExpenseMonths;
    @BindView(R.id.raw_meterials_other_months_expense_to_buy)
    EditText _rawMeterialsOtherMonthsExpenseToBuy;
    @BindView(R.id.raw_meterials_other_months_number)
    EditText _rawMeterialsOtherMonthsNumber;
    @BindView(R.id.raw_meterials_average_monthly_sales)
    TextView _rawMeterialsAverageMonthlySales;
    @BindView(R.id.saveBtn)
    Button _saveBtn;

    public void saveBtn(View view) {
        saveToLocalStorage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raw_meterials_price);
        ButterKnife.bind(this);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");

        _name.setText(member.getMEMBER_NAME() + "");

        _memberID.setText(getResources().getString(R.string.memberID) + member.getMEMBER_ID());

        loadUIIfAvailable();

        allOnclickListner();

    }

    private void allOnclickListner() {
        _rawMeterialsMostExpenseMonths.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calculaterOtherMonths();

                }
            }
        });
        _rawMeterialsLessExpenseMonths.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calculaterOtherMonths();

                }
            }
        });

        _rawMeterialsMostExpenseToBuy.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calculateAverageSales();
                }
            }
        });
        _rawMeterialsLessExpenseToBuy.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calculateAverageSales();
                }
            }
        });
        _rawMeterialsOtherMonthsExpenseToBuy.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    calculateAverageSales();
                }
            }
        });

    }

    private void setLoanCostOfGoodsBox(LoanCostOfGoodsBox data) {
        data.setMEMBER_ID(member.getMEMBER_ID());
        data.setBRANCH_ID(member.getBRANCH_ID());
        data.setCENTER_ID(member.getCENTER_ID());
        data.setMAX_COST(_rawMeterialsMostExpenseToBuy.getText().toString());
        data.setGOOD_MONTHS(_rawMeterialsMostExpenseMonths.getText().toString());
        data.setMIN_COST(_rawMeterialsLessExpenseToBuy.getText().toString());
        data.setBAD_MONTHS(_rawMeterialsLessExpenseMonths.getText().toString());
        data.setAVERAGE_COST(_rawMeterialsOtherMonthsExpenseToBuy.getText().toString());
        data.setAVERAGE_MONTHS(_rawMeterialsOtherMonthsNumber.getText().toString());
    }

    private void saveToLocalStorage() {
        LoanCostOfGoodsBox loanCostOfGoods = objectBoxManager.GetLoanCostOfGoodsBox(member.getBRANCH_ID(), member.getMEMBER_ID());
        if (loanCostOfGoods == null) {
            LoanCostOfGoodsBox newData = new LoanCostOfGoodsBox();
            setLoanCostOfGoodsBox(newData);
            objectBoxManager.SaveLoanCostOfGoodsBox(newData);
        } else {
            setLoanCostOfGoodsBox(loanCostOfGoods);
            objectBoxManager.SaveLoanCostOfGoodsBox(loanCostOfGoods);
        }

        Intent intent = new Intent(LoanCostOfGoodsActivity.this, LoanAssessmentActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("memberDetails", member);
        startActivity(intent);
        finish();

    }

    private void loadUIIfAvailable() {
        LoanCostOfGoodsBox costOfGoodsData = objectBoxManager.GetLoanCostOfGoodsBox(member.getBRANCH_ID(), member.getMEMBER_ID());

        if (costOfGoodsData != null) {

            _rawMeterialsMostExpenseToBuy.setText(costOfGoodsData.getMAX_COST());
            _rawMeterialsMostExpenseMonths.setText(costOfGoodsData.getGOOD_MONTHS());
            _rawMeterialsLessExpenseToBuy.setText(costOfGoodsData.getMIN_COST());
            _rawMeterialsLessExpenseMonths.setText(costOfGoodsData.getBAD_MONTHS());
            _rawMeterialsOtherMonthsExpenseToBuy.setText(costOfGoodsData.getAVERAGE_COST());
            _rawMeterialsOtherMonthsNumber.setText(costOfGoodsData.getAVERAGE_COST());

            calculateAverageSales();
            calculaterOtherMonths();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void calculateAverageSales() {
        try {
            long a = Utils.getLongFromEditText(_rawMeterialsMostExpenseToBuy);
            long b = Utils.getLongFromEditText(_rawMeterialsMostExpenseMonths);
            long c = Utils.getLongFromEditText(_rawMeterialsLessExpenseToBuy);
            long d = Utils.getLongFromEditText(_rawMeterialsLessExpenseMonths);
            long e = Utils.getLongFromEditText(_rawMeterialsOtherMonthsExpenseToBuy);
            long f = Utils.getLongFromEditText(_rawMeterialsOtherMonthsNumber);

            long sum_sel = (a * b) + (c * d) + (e * f);
            long sum_mon = b + d + f;

            long sum_avg = sum_sel / sum_mon;

            _rawMeterialsAverageMonthlySales.setText(Utils.formatNumber(sum_avg));


            if (Utils.findDifference(a, c) >= Utils.differenceValue) {
                Utils.showDialog(this, getString(R.string.warning10LaksDifference));
                return;
            }

            if (Utils.findDifference(a, e) >= Utils.differenceValue) {
                Utils.showDialog(this, getString(R.string.warning10LaksDifference));
                return;
            }

            if (Utils.findDifference(c, e) >= Utils.differenceValue) {
                Utils.showDialog(this, getString(R.string.warning10LaksDifference));
                return;
            }

        } catch (Exception e) {
            Log.e(TAG, "getting error while calculating average ");
            e.printStackTrace();
        }
    }

    private void calculaterOtherMonths() {
        try {
            int b = getNumberFromEditText(_rawMeterialsMostExpenseMonths);
            int d = getNumberFromEditText(_rawMeterialsLessExpenseMonths);

            if (b > 12) {
                _rawMeterialsMostExpenseMonths.setError(getResources().getString(R.string.biz_sell_mor_than_12_error));
                return;
            } else {
                _rawMeterialsMostExpenseMonths.setError(null);
            }

            if (b + d > 12) {
                _rawMeterialsLessExpenseMonths.setError(getResources().getString(R.string.biz_sell_mor_than_12_error));
                _rawMeterialsOtherMonthsNumber.setText("");
                return;

            } else {
                _rawMeterialsOtherMonthsNumber.setText((12 - (b + d)) + "");
                _rawMeterialsLessExpenseMonths.setError(null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
