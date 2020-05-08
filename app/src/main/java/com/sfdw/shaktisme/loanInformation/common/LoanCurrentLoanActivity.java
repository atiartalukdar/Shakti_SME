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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.sfdw.shaktisme.R;

import java.util.ArrayList;
import java.util.List;

import adapters.LoanCurrentLoanAdapter;
import bp.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.MemberListDM;
import interfaces.IObjectBoxManager;
import io.objectbox.Box;
import objectBox.LoanCurrentLoanBox;
import objectBox.LoanCurrentLoanBox_;
import objectBox.ObjectBox;
import services.ObjectBoxManager;

public class LoanCurrentLoanActivity extends BaseActivity {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;
    @BindView(R.id.name)                    TextView _name;
    @BindView(R.id.memberID)                TextView _memberID;
    @BindView(R.id.currentLoanList)         ListView _currentLoanList;


    View popupInputDialogView = null;
    private EditText _loan_source = null;
    private EditText _monthly_intallment = null;
    private CheckBox _is_running=null;

    private Button _saveCurrentLoan = null;
    private Button _cancelInput = null;

    LoanCurrentLoanAdapter adapter;
    private List<LoanCurrentLoanBox> loanCurrentLoanList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p1_activity_others_loan);
        ButterKnife.bind(this);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");

        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) +member.getMEMBER_ID());

        loanCurrentLoanList.clear();
        //loanCurrentLoanList.addAll(loanCurrentLoanBoxBox.query().equal(LoanCurrentLoanBox_.MEMBER_ID,member.getMEMBER_ID()).build().find());
        loanCurrentLoanList.addAll(objectBoxManager.GetLoanCurrentLoanListBox(member.getBRANCH_ID(),member.getMEMBER_ID()));

        adapter = new LoanCurrentLoanAdapter(this, loanCurrentLoanList);
        _currentLoanList.setAdapter(adapter);
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


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    private void initPopupViewControls() {
        // Get layout inflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(LoanCurrentLoanActivity.this);

        // Inflate the popup dialog from a layout xml file.
        popupInputDialogView = layoutInflater.inflate(R.layout.custom_loan_current_loan_popup, null);

        // Get user input edittext and button ui controls in the popup dialog.
        _loan_source = popupInputDialogView.findViewById(R.id.running_loan_source);
        _monthly_intallment = popupInputDialogView.findViewById(R.id.running_loan_installment);
        _is_running=popupInputDialogView.findViewById(R.id.running_loan_is_running);


        _saveCurrentLoan = popupInputDialogView.findViewById(R.id.button_save_user_data);
        _cancelInput = popupInputDialogView.findViewById(R.id.button_cancel_user_data);


    }


    private void addNewProduct() {

        // Create a AlertDialog Builder.
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoanCurrentLoanActivity.this);
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
        _saveCurrentLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get user data from popup dialog editeext.
                String loan_source = _loan_source.getText().toString();
                String monthly_install = _monthly_intallment.getText() + "";

                StringBuffer cheakbox = new StringBuffer();
                String is_running= _is_running.isChecked() ? "1" : "0";


                LoanCurrentLoanBox loanCurrentLoan = new LoanCurrentLoanBox();
                loanCurrentLoan.setMEMBER_ID(member.getMEMBER_ID());
                loanCurrentLoan.setBRANCH_ID(member.getBRANCH_ID());
                loanCurrentLoan.setCENTER_ID(member.getCENTER_ID());
                loanCurrentLoan.setLOAN_NAME(loan_source);
                loanCurrentLoan.setMONTHLY_INSTALLMENT(monthly_install);
                loanCurrentLoan.setIS_DUE_WITHNEW(is_running);
                objectBoxManager.SaveLoanCurrentLoanBox(loanCurrentLoan);

                //adding product to local list and notify adapter that dataset changed.
                loanCurrentLoanList.add(loanCurrentLoan);
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