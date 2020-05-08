package com.sfdw.shaktisme.loanInformation.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.sfdw.shaktisme.R;

import java.util.ArrayList;
import java.util.HashMap;

import bp.BaseActivity;
import bp.Session;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModel.OptionList;
import dataModelNew.LoadConfigurationDM;
import dataModelNew.MemberListDM;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rettrofit.APIInterface;
import rettrofit.APIManager;
import rettrofit.RetrofitClientInstance;
import services.ObjectBoxManager;
import services.ServiceManager;

public class LoanQualitativeAssessmentActivity extends BaseActivity {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";
    ObjectBoxManager objectBoxManager = new ObjectBoxManager();
    ServiceManager _serviceManager = new ServiceManager();
    private MemberListDM.Data member;

    @BindView(R.id.name)                               TextView _name;
    @BindView(R.id.memberID)                           TextView _memberID;
    @BindView(R.id.education_qualification_spinner)    Spinner _educationalQualificationSpinner;

    Retrofit retrofit;
    APIInterface apiInterface;

    ArrayList<LoadConfigurationDM.OptionList> eduArray = new ArrayList<>();
    ArrayAdapter<LoadConfigurationDM.OptionList> edcationalQualificationAdapter;
    int counter;

    public void saveBtn(View view) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunonoto_mullayon);
        ButterKnife.bind(this);

        member = (MemberListDM.Data) getIntent().getSerializableExtra("member");
        counter = 0;

        retrofit = RetrofitClientInstance.getRetrofitInstanceNew();
        apiInterface = retrofit.create(APIInterface.class);

        loadEducationalQualificationData();

        initializeSpinner();

    }

    private void initializeSpinner(){
       edcationalQualificationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, eduArray);
       _educationalQualificationSpinner.setAdapter(edcationalQualificationAdapter);
    }

    private void loadEducationalQualificationData() {
        eduArray.addAll(_serviceManager.getOptionList("2"));
        edcationalQualificationAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
