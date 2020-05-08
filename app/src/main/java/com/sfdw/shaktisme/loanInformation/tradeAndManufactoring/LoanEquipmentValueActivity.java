package com.sfdw.shaktisme.loanInformation.tradeAndManufactoring;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.sfdw.shaktisme.R;

import java.util.ArrayList;
import java.util.List;

import adapters.LoanEquipmentValueAdapter;
import bp.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.MemberListDM;
import io.objectbox.Box;
import objectBox.LoanEquipmentValueBox;
import objectBox.LoanEquipmentValueBox_;
import objectBox.ObjectBox;
import services.ObjectBoxManager;

public class LoanEquipmentValueActivity extends BaseActivity {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)                    TextView _name;
    @BindView(R.id.memberID)                TextView _memberID;
    @BindView(R.id.currentFurnitureList)    ListView _currentFurnutureList;

    // Below edittext and button are all exist in the popup dialog view.
    private View popupInputDialogView = null;

    private EditText _custom_dialog_name = null;
    private EditText _custom_dialog_used_year = null;
    private EditText _custom_dialog_remaining_year = null;
    private EditText _custom_dialog_changing_cost = null;
    private Button _saveFamilyMember = null;
    private Button _cancelInput = null;

    LoanEquipmentValueAdapter adapter;
    private Box<LoanEquipmentValueBox> loanEquipmentValueBoxBox;
    private List<LoanEquipmentValueBox> loanEquipmentValueList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p1_activity_decoration);
        ButterKnife.bind(this);
        loanEquipmentValueBoxBox = ObjectBox.get().boxFor(LoanEquipmentValueBox.class);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        Log.e(TAG, member.getMEMBER_ID());

        _name.setText(member.getMEMBER_NAME() + "");
        _memberID.setText(getResources().getString(R.string.memberID) +member.getMEMBER_ID());



        //loading data from local storage to local list.
        loanEquipmentValueList.clear();
        loanEquipmentValueList.addAll(loanEquipmentValueBoxBox.query().equal(LoanEquipmentValueBox_.MEMBER_ID,member.getMEMBER_ID()).build().find());

        adapter = new LoanEquipmentValueAdapter(this, loanEquipmentValueList);
        _currentFurnutureList.setAdapter(adapter);
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

    /* Initialize popup dialog view and ui controls in the popup dialog. */
    private void initPopupViewControls() {
        // Get layout inflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(LoanEquipmentValueActivity.this);

        // Inflate the popup dialog from a layout xml file.
        popupInputDialogView = layoutInflater.inflate(R.layout.custom_p1_biz_info_decoration_popup, null);

        // Get user input edittext and button ui controls in the popup dialog.
        _custom_dialog_name = popupInputDialogView.findViewById(R.id.custom_dialog_decoration_name);
        _custom_dialog_used_year = popupInputDialogView.findViewById(R.id.custom_dialog_decoration_used_year);
        _custom_dialog_remaining_year = popupInputDialogView.findViewById(R.id.custom_dialog_decoration_remaining_year);
        _custom_dialog_changing_cost = popupInputDialogView.findViewById(R.id.custom_dialog_decoration_changing_cost);

        _saveFamilyMember = popupInputDialogView.findViewById(R.id.button_save_user_data);
        _cancelInput = popupInputDialogView.findViewById(R.id.button_cancel_user_data);


    }

    private void addNewProduct() {
        // Create a AlertDialog Builder.
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoanEquipmentValueActivity.this);
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
        _saveFamilyMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user data from popup dialog editeext.
                String name = _custom_dialog_name.getText().toString();
                String yearsInService = _custom_dialog_used_year.getText().toString();
                String remainingYear = _custom_dialog_remaining_year.getText().toString();
                String changingCost = _custom_dialog_changing_cost.getText().toString();

                //adding new product to local storage.
                LoanEquipmentValueBox p = new LoanEquipmentValueBox();
                p.setMEMBER_ID(member.getMEMBER_ID());
                p.setBRANCH_ID(member.getBRANCH_ID());
                p.setCENTER_ID(member.getCENTER_ID());

                p.setEQUIPMENT_NAME(name);
                p.setYEARS_IN_SERVICE(yearsInService);
                p.setLIFE_REMAINING(remainingYear);
                p.setREPLACEMENT_COST(changingCost);

                loanEquipmentValueBoxBox.put(p);

                //adding product to local list and notify adapter that dataset changed.
                loanEquipmentValueList.add(p);
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
