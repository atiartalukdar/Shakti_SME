package com.sfdw.shaktisme.loanInformation.common;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.sfdw.shaktisme.R;

import java.util.ArrayList;
import java.util.List;

import adapters.LoanOtherIncomeAdapter;
import bp.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.MemberListDM;
import io.objectbox.Box;
import objectBox.LoanOtherIncomeBox;
import objectBox.LoanOtherIncomeBox_;
import objectBox.ObjectBox;
import services.ObjectBoxManager;

public class LoanOtherIncomeActivity extends BaseActivity {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)    TextView _name;
    @BindView(R.id.memberID)    TextView _memberID;
    @BindView(R.id.otherincomelist)    ListView _otherincomelist;
    @BindView(R.id.total_other_income)    TextView _totalOtherIncome;

    ArrayList<String> duration = new ArrayList<>();
    ArrayAdapter<String> durationAdapter;

    View popupInputDialogView = null;
    private EditText _income_source = null;
    private EditText _monthly_income = null;

    private Button _saveotherIncome = null;
    private Button _cancelInput = null;

    LoanOtherIncomeAdapter adapter;
    private List<LoanOtherIncomeBox> loanOtherIncomeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_other_income);
        ButterKnife.bind(this);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        Log.e(TAG, member.getMEMBER_ID());

        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) +member.getMEMBER_ID());

        loanOtherIncomeList.clear();
        loanOtherIncomeList.addAll(objectBoxManager.GetLoanOtherIncomeListBox(member.getBRANCH_ID(),member.getMEMBER_ID()));

        adapter = new LoanOtherIncomeAdapter(this, loanOtherIncomeList);
        _otherincomelist.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.menu_add:
                addNewProduct();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private void initPopupViewControls() {
        // Get layout inflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(LoanOtherIncomeActivity.this);

        // Inflate the popup dialog from a layout xml file.
        popupInputDialogView = layoutInflater.inflate(R.layout.custom_loan_other_income_popup, null);

        // Get user input edittext and button ui controls in the popup dialog.
        _income_source = popupInputDialogView.findViewById(R.id.other_income_source);
        _monthly_income = popupInputDialogView.findViewById(R.id.other_monthly_income);
        _saveotherIncome = popupInputDialogView.findViewById(R.id.button_save_user_data);
        _cancelInput = popupInputDialogView.findViewById(R.id.button_cancel_user_data);


    }

    private void addNewProduct() {

        // Create a AlertDialog Builder.
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoanOtherIncomeActivity.this);
        // Set title, icon, can not cancel properties.
        alertDialogBuilder.setTitle("যোগ করুন...");
        alertDialogBuilder.setIcon(R.drawable.ic_add_circle_outline_black_24dp);
        alertDialogBuilder.setCancelable(false);

        // Init popup dialog view and it's ui controls.
        initPopupViewControls();

        // Set the inflated layout view object to the AlertDialog builder.
        alertDialogBuilder.setView(popupInputDialogView);

        // Create AlertDialog and show.
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


        // When user click the save user data button in the popup dialog.
        _saveotherIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get user data from popup dialog editeext.
                String income_source = _income_source.getText().toString();
                String monthly_income = _monthly_income.getText() + "";


                LoanOtherIncomeBox loanOtherIncome = new LoanOtherIncomeBox();
                loanOtherIncome.setMEMBER_ID(member.getMEMBER_ID());
                loanOtherIncome.setBRANCH_ID(member.getBRANCH_ID());
                loanOtherIncome.setCENTER_ID(member.getCENTER_ID());
                loanOtherIncome.setSOURCE(income_source);
                loanOtherIncome.setMONTHLYINCOME(monthly_income);
                objectBoxManager.SaveLoanOtherIncomeBox(loanOtherIncome);

                //adding product to local list and notify adapter that dataset changed.
                loanOtherIncomeList.add(loanOtherIncome);
                adapter.notifyDataSetChanged();


                alertDialog.cancel();
            }
        });

        _cancelInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.cancel();
            }
        });


    }

}
