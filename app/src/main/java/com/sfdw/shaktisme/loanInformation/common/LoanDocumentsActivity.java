package com.sfdw.shaktisme.loanInformation.common;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.sfdw.shaktisme.R;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import adapters.LoanDocumentAdapter;
import adapters.PrescreeningAdapterBox;
import bp.BaseActivity;
import bp.Session;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dataModelNew.LoadConfigurationDM;
import dataModelNew.MemberListDM;
import objectBox.KYCFamilyMemberBox;
import objectBox.LoanDocumentBox;
import services.ObjectBoxManager;
import services.ServiceManager;

public class LoanDocumentsActivity extends BaseActivity {
    ServiceManager _serviceManager = new ServiceManager();
    ObjectBoxManager _objectBoxManager = new ObjectBoxManager();
    private MemberListDM.Data member;
    String documentBase64String = "";

    @BindView(R.id.documentsList)
    RecyclerView _recyclerView;
    @BindView(R.id.addDocument)
    FloatingActionButton _addDocument;

    LoanDocumentAdapter _documentAdapter;
    List<LoanDocumentBox> _documentList;
    List<LoadConfigurationDM.DocumentTypeList> _documentTypeList =  new ArrayList<>();
    ArrayAdapter<LoadConfigurationDM.DocumentTypeList> _docTypeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_documents);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        _documentTypeList = _serviceManager.getDocumentTypeList();

        _documentList = _objectBoxManager.GetLoanDocumentBoxList(member.getBRANCH_ID(),member.getMEMBER_ID());
        _documentAdapter = new LoanDocumentAdapter(_documentList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        _recyclerView.setLayoutManager(mLayoutManager);
        _recyclerView.setItemAnimator(new DefaultItemAnimator());
        _recyclerView.setAdapter(_documentAdapter);
    }

    @OnClick(R.id.addDocument)
    public void onViewClicked() {
        if (_objectBoxManager.GetLoanDocumentBoxList(member.getBRANCH_ID(),member.getMEMBER_ID()).size() > 50){
            Utils.showDialog(this,"আপনি ৫০ টার বেশী ছবি আপলোড করতে পারবেন না। ");
            return;
        }
        addNewDocument();
    }

    //============== Below edittext and button are all exist in the popup dialog view.====================//
    private View popupInputDialogView = null;
    private Spinner _docTypeSpinner = null;
    private EditText _docTypename = null;
    private ImageView _doc = null;

    private Button _addToList = null;
    private Button _cancelInput = null;

    private void initPopupViewControls(){
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        popupInputDialogView = layoutInflater.inflate(R.layout.custom_popup_add_new_document, null);

        _docTypeSpinner =  popupInputDialogView.findViewById(R.id.docTypeSpinner);
        _docTypename =  popupInputDialogView.findViewById(R.id.docCommentsEd);
        _doc =  popupInputDialogView.findViewById(R.id.document);
        _addToList = popupInputDialogView.findViewById(R.id.add_to_list);
        _cancelInput = popupInputDialogView.findViewById(R.id.cancel_action);
    }

    private void addNewDocument(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Add new Document.");
        alertDialogBuilder.setIcon(R.drawable.ic_launcher_background);
        alertDialogBuilder.setCancelable(false);

        // Init popup dialog view and it's ui controls.
        initPopupViewControls();

        _docTypeListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, _documentTypeList);
        _docTypeSpinner.setAdapter(_docTypeListAdapter);
        _docTypeListAdapter.notifyDataSetChanged();

        // Set the inflated layout view object to the AlertDialog builder.
        alertDialogBuilder.setView(popupInputDialogView);

        // Create AlertDialog and show.
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        // When user click the save user data button in the popup dialog.
        _doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureProfilePicture();
            }
        });

        _addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // Get user data from popup dialog editeext.
                            String docType = _docTypeSpinner.getSelectedItem().toString();
                            String docTypeName = _docTypename.getText().toString();
                            String doc = documentBase64String;

                            LoanDocumentBox loanDocumentBox = new LoanDocumentBox();
                            loanDocumentBox.setDOC_TYPE_ID(_serviceManager.getDocumentTypeID(docType));
                            loanDocumentBox.setDOC_NAME(docTypeName);
                            loanDocumentBox.setDOC(doc);
                            loanDocumentBox.setMEMBER_ID(member.getMEMBER_ID());
                            loanDocumentBox.setBRANCH_ID(member.getBRANCH_ID());
                            loanDocumentBox.setCENTER_ID(member.getCENTER_ID());

                            _documentList.add(loanDocumentBox);
                            _objectBoxManager.SaveLoanDocumentBox(loanDocumentBox);
                            _documentAdapter.notifyDataSetChanged();
                            alertDialog.cancel();

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });


            }
        });

        _cancelInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.cancel();
            }
        });

        captureProfilePicture();

    }

    // =================== Below code are responsible for capturing image and get the base64 string ======================//
    static final int REQUEST_IMAGE = 1000;
    static final int REQUEST_IMAGE_CROP = 1001;

    private void captureProfilePicture() {
        documentBase64String = null;
        Utils.captureImage(this,REQUEST_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {

            case REQUEST_IMAGE:
                Intent i1 = CropImage.activity(Utils.photoURI)
                        .getIntent(this);
                startActivityForResult(i1, REQUEST_IMAGE_CROP);
                break;
            case REQUEST_IMAGE_CROP:
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Bitmap image1 = Utils.getBitMapImageFromIntent(LoanDocumentsActivity.this,requestCode,resultCode,data);
                        if (image1 != null){
                            try {
                                _doc.setImageBitmap(image1);
                                documentBase64String = Utils.convertToBase64(image1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                });

                break;

        }
    }

}
