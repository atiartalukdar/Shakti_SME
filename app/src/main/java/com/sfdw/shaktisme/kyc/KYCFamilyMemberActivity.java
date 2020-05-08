package com.sfdw.shaktisme.kyc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.memberList.KYCActivity;

import java.util.ArrayList;
import java.util.List;

import adapters.FamilyMembersAdapterBox;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.LoadConfigurationDM;
import dataModelNew.MemberListDM;
import objectBox.KYCFamilyMemberBox;
import retrofit2.Retrofit;
import rettrofit.APIInterface;
import rettrofit.RetrofitClientInstance;
import services.ObjectBoxManager;
import services.ServiceManager;

public class KYCFamilyMemberActivity extends Fragment {
    private final String TAG = getClass().getName() + " Atiar - ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    ServiceManager serviceManager = new ServiceManager();

    public KYCFamilyMemberActivity() {
    }

    @BindView(R.id.familyMembersList)    ListView _familyMemberList;
    @BindView(R.id.addFamilyMember)    FloatingActionButton _addFamilyMember;
    FamilyMembersAdapterBox adapter;
    private List<KYCFamilyMemberBox> familyMembersList;

    ArrayList<LoadConfigurationDM.OptionList> relationArray = new ArrayList<>();
    ArrayList<LoadConfigurationDM.OptionList> eduArray = new ArrayList<>();
    ArrayList<String> marritalArray = new ArrayList<>();

    ArrayAdapter<LoadConfigurationDM.OptionList> relationTypeAdapter;
    ArrayAdapter<LoadConfigurationDM.OptionList> edcationalQualificationAdapter;
    ArrayAdapter<String> marritalAdapter;


    // Below edittext and button are all exist in the popup dialog view.
    private View popupInputDialogView = null;
    private EditText _familyMembersNme = null;
    private Spinner _relationSpinner = null;
    private EditText _age = null;
    private Spinner _educationnalQualificationSpinner = null;
    private EditText _occupation = null;
    private Spinner _marritalStatusSpinner = null;
    private Button _saveFamilyMember = null;
    private Button _cancelInput = null;

    private MemberListDM.Data member;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.activity_family_members, container, false);
        ButterKnife.bind(this,view);
        member = ((KYCActivity) getActivity()).getMember();

        //must have to maintain the serial
        initPopupViewControls();
        initializeSpinner();
        loadOptionList();

        loadFamilyMemberList();
        adapter = new FamilyMembersAdapterBox(getActivity(), familyMembersList);
        _familyMemberList.setAdapter(adapter);

        _addFamilyMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewFamilyMemberDialog();
            }
        });
        return view;
    }


    private void loadFamilyMemberList(){
        familyMembersList = new ArrayList<>();
        //familyMembersList = familyBox.query().equal(KYCFamilyMemberBox_.member_id,member.getMEMBER_ID()).order(KYCFamilyMemberBox_.age).build().find();
        familyMembersList = objectBoxManager.GetKYCFamilyMemberBoxList(member.getBRANCH_ID(),member.getMEMBER_ID());
    }

    /* Initialize popup dialog view and ui controls in the popup dialog. */
    private void initPopupViewControls()
    {
        // Get layout inflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

        // Inflate the popup dialog from a layout xml file.
        popupInputDialogView = layoutInflater.inflate(R.layout.custom_family_members_add_popup, null);

        // Get user input edittext and button ui controls in the popup dialog.
        _familyMembersNme =  popupInputDialogView.findViewById(R.id.custom_dialog_name);
        _relationSpinner =  popupInputDialogView.findViewById(R.id.custom_dialog_relation_spinner);
        _age =  popupInputDialogView.findViewById(R.id.custom_dialog_age);
        _educationnalQualificationSpinner =  popupInputDialogView.findViewById(R.id.custom_dialog_education_spinner);
        _occupation =  popupInputDialogView.findViewById(R.id.custom_dialog_occupation);
        _marritalStatusSpinner =  popupInputDialogView.findViewById(R.id.custom_dialog_marital_status);

        _saveFamilyMember = popupInputDialogView.findViewById(R.id.button_save_user_data);
        _cancelInput = popupInputDialogView.findViewById(R.id.button_cancel_user_data);


    }

    private void addNewFamilyMemberDialog(){
        marritalAdapter.notifyDataSetChanged();
        edcationalQualificationAdapter.notifyDataSetChanged();
        relationTypeAdapter.notifyDataSetChanged();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setTitle("Add new family members.");
        alertDialogBuilder.setIcon(R.drawable.ic_launcher_background);
        alertDialogBuilder.setCancelable(false);

        // Init popup dialog view and it's ui controls.
        initPopupViewControls();

        //loading spinner with data
        initializeSpinner();

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
                String name = _familyMembersNme.getText().toString();
                String relation = _relationSpinner.getSelectedItem() + "";
                String age = _age.getText().toString();
                String educationalQualification = _educationnalQualificationSpinner.getSelectedItem() + "";
                String occupation = _occupation.getText().toString();
                Integer isMarried ;

                if ((_marritalStatusSpinner.getSelectedItem() + "" ).equals(getResources().getString(R.string.marriad))){
                    isMarried = 1;
                }else {
                    isMarried = 0;
                }

                KYCFamilyMemberBox f = new KYCFamilyMemberBox(name,relation,Integer.parseInt(age),educationalQualification,isMarried,occupation,member.getMEMBER_ID(),member.getCENTER_ID(),member.getBRANCH_ID());
                objectBoxManager.SaveKYCFamilyMemberBox(f);
                familyMembersList.add(f);
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
    /*
     * Relation 3
     * education 2
     * job 1
     */
    private void loadOptionList(){
        relationArray.addAll(serviceManager.getOptionList("3"));
        relationTypeAdapter.notifyDataSetChanged();

        eduArray.addAll(serviceManager.getOptionList("2"));
        edcationalQualificationAdapter.notifyDataSetChanged();

        marritalArray.clear();
        marritalArray.add(getResources().getString(R.string.marriad));
        marritalArray.add(getResources().getString(R.string.unmarriad));    }

    private void initializeSpinner(){
        relationTypeAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, relationArray);
        _relationSpinner.setAdapter(relationTypeAdapter);

        edcationalQualificationAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, eduArray);
        _educationnalQualificationSpinner.setAdapter(edcationalQualificationAdapter);

        marritalAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, marritalArray);
        _marritalStatusSpinner.setAdapter(marritalAdapter);

    }

}
