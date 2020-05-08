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

import adapters.LoanStockOfGoodsAdapter;
import bp.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.MemberListDM;
import io.objectbox.Box;
import objectBox.LoanStockOfGoodsBox;
import objectBox.LoanStockOfGoodsBox_;
import objectBox.ObjectBox;
import services.ObjectBoxManager;

public class LoanStockOfGoodsActivity extends BaseActivity {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)                                TextView _name;
    @BindView(R.id.memberID)                            TextView _memberID;
    @BindView(R.id.baki_buy_paonadarer_kase_paona)      TextView _bakiBuyPaonadarerKasePaona;
    @BindView(R.id.ponner_mojud_list)                   ListView _ponner_mojud_list;

    // Below edittext and button are all exist in the popup dialog view.
    private View popupInputDialogView = null;
    private EditText _custom_dialog_product_name = null;
    private EditText _custom_dialog_product_quantity = null;
    private EditText _custom_dialog_product_unit_price = null;
    private Button _saveFamilyMember = null;
    private Button _cancelInput = null;

    LoanStockOfGoodsAdapter adapter;
    private List<LoanStockOfGoodsBox> loanStockOfGoodsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ponner_mojud);
        ButterKnife.bind(this);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        Log.e(TAG, member.getMEMBER_ID());
        _memberID.setText(member.getMEMBER_ID());
        _name.setText(member.getMEMBER_NAME());

        //loading data from local storage to local list.
        loanStockOfGoodsList.clear();
        loanStockOfGoodsList.addAll(objectBoxManager.GetLoanStockOfGoodsBoxList(member.getBRANCH_ID(),member.getMEMBER_ID()));

        adapter = new LoanStockOfGoodsAdapter(this, loanStockOfGoodsList);
        _ponner_mojud_list.setAdapter(adapter);
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
        LayoutInflater layoutInflater = LayoutInflater.from(LoanStockOfGoodsActivity.this);

        // Inflate the popup dialog from a layout xml file.
        popupInputDialogView = layoutInflater.inflate(R.layout.custom_p1_biz_info_ponner_mozud_popup, null);

        // Get user input edittext and button ui controls in the popup dialog.
        _custom_dialog_product_name = popupInputDialogView.findViewById(R.id.custom_dialog_product_name);
        _custom_dialog_product_quantity = popupInputDialogView.findViewById(R.id.custom_dialog_product_quantity);
        _custom_dialog_product_unit_price = popupInputDialogView.findViewById(R.id.custom_dialog_product_unit_price);

        _saveFamilyMember = popupInputDialogView.findViewById(R.id.button_save_user_data);
        _cancelInput = popupInputDialogView.findViewById(R.id.button_cancel_user_data);

    }

    private void addNewProduct() {
        // Create a AlertDialog Builder.
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoanStockOfGoodsActivity.this);
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
                String name = _custom_dialog_product_name.getText().toString();
                String quantity = _custom_dialog_product_quantity.getText().toString();
                String unitPrice = _custom_dialog_product_unit_price.getText().toString();

                //adding new product to local storage.
                LoanStockOfGoodsBox p = new LoanStockOfGoodsBox();
                p.setMEMBER_ID(member.getMEMBER_ID());
                p.setBRANCH_ID(member.getBRANCH_ID());
                p.setCENTER_ID(member.getCENTER_ID());
                p.setITEM_NAME(name);
                p.setUNIT(quantity);
                p.setPRICE_PER_UNIT(unitPrice);
                objectBoxManager.SaveLoanStockOfGoodsBox(p);

                //adding product to local list and notify adapter that dataset changed.
                loanStockOfGoodsList.add(p);
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
