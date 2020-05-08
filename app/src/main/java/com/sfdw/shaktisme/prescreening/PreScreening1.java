package com.sfdw.shaktisme.prescreening;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sfdw.shaktisme.R;
import com.sfdw.shaktisme.lead.LeadFailListActivity;
import com.sfdw.shaktisme.lead.LeadListActivity;
import com.sfdw.shaktisme.memberList.MemberList;

import java.util.HashMap;
import java.util.List;

import adapters.PrescreeningAdapterBox;
import bp.Session;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.LoadConfigurationDM;
import io.objectbox.Box;
import io.objectbox.query.QueryBuilder;
import objectBox.LeadBox;
import objectBox.ObjectBox;
import objectBox.PrescreeningAnsBox;
import objectBox.PrescreeningAnsBox_;
import responseDataModel.CommonUploadResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rettrofit.APIInterface;
import rettrofit.APIManager;
import rettrofit.RequestListener;
import rettrofit.RetrofitClientInstance;
import services.ObjectBoxManager;
import services.ServiceManager;

public class PreScreening1 extends AppCompatActivity {
    private final String TAG = getClass().getName() + "Atiar - ";
    ServiceManager _serviceManager = new ServiceManager();
    ObjectBoxManager _objectBoxManager = new ObjectBoxManager();
    APIManager _apiManager = new APIManager();

    @BindView(R.id.recycler_view)
    RecyclerView _recyclerView;
    @BindView(R.id.prescreeningNextOrSubmit)
    Button _prescreeningNextOrSubmit;

    List<LoadConfigurationDM.PreScreeningList> _questionList1;
    List<LoadConfigurationDM.PreScreeningList> _questionList2;

    Retrofit retrofit;
    APIInterface apiInterface;

    private LeadBox lead;
    private Box<LeadBox> leadBox;

    PrescreeningAdapterBox adapter;
    private Box<PrescreeningAnsBox> ansBox;

    private Parcelable recyclerViewState;

    String leadOptionType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_screening1);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        leadBox = ObjectBox.get().boxFor(LeadBox.class);
        ansBox = ObjectBox.get().boxFor(PrescreeningAnsBox.class);

        retrofit = RetrofitClientInstance.getRetrofitInstanceNew();
        apiInterface = retrofit.create(APIInterface.class);

        lead = (LeadBox) getIntent().getSerializableExtra("LeadDataModelObjectBox");
        leadOptionType = _serviceManager.getLeadOptionObject(lead.getLEADOPTION_ID()).getOPTIONNAMEBN();

        loadPreScreening1();
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerViewState = _recyclerView.getLayoutManager().onSaveInstanceState();

        if (recyclerViewState != null) {
            _recyclerView.getLayoutManager().onRestoreInstanceState(recyclerViewState);
        }
    }

    private void loadPreScreening1() {
        _recyclerView.setTag("1");
        _prescreeningNextOrSubmit.setText("Next");

        _questionList1 = _serviceManager.getPrescreenigPartOneQuestion(lead.getLEADOPTION_ID());

        adapter = new PrescreeningAdapterBox(_questionList1, lead.getLEAD_ID());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        _recyclerView.setLayoutManager(mLayoutManager);
        _recyclerView.setItemAnimator(new DefaultItemAnimator());
        _recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    private void loadPrescreening2() {
        _recyclerView.setTag("2");
        _prescreeningNextOrSubmit.setText("Upload");

        _questionList2 = _serviceManager.getPrescreenigPartTwoQuestion(lead.getLEADOPTION_ID());

        adapter = new PrescreeningAdapterBox(_questionList2, lead.getLEAD_ID());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        _recyclerView.setLayoutManager(mLayoutManager);
        _recyclerView.setItemAnimator(new DefaultItemAnimator());
        _recyclerView.setAdapter(adapter);
    }

    public void completePrescreening1(View view) {

        if (_recyclerView.getTag().equals("1")) {
            if (isPassedOnPreeScreening1()) {
                loadPrescreening2();
                Log.e(TAG, "prescreening passed");

            } else {
                Log.e(TAG, "prescreening failed");
                Toast.makeText(PreScreening1.this, getResources().getString(R.string.warning_user_not_passed_on_prescreening_1), Toast.LENGTH_LONG).show();
            }
        } else {
            try {
                //submitResult();

                if (!Utils.isNetworkConnected()){
                    Utils.showDialog(this,"Internet is not available. Please connect with internet.");
                    return;
                }
                uploadPrescreeningResultToServer(lead);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG, "data not submitted");
            }
        }
    }

    private void submitResult() {

        if (isPassedOnPreeScreening1()) {

            ansBox = ObjectBox.get().boxFor(PrescreeningAnsBox.class);

            int totalMark = 0;
            int passMark = (int) Math.round(_serviceManager.getLeadOptionObject(lead.getLEADOPTION_ID()).getPASSSCORE());


            QueryBuilder<PrescreeningAnsBox> builder = ansBox.query();
            builder.equal(PrescreeningAnsBox_.isFirstStep, 0)  //0 is for 2nd part questions
                    .and()
                    .equal(PrescreeningAnsBox_.LEAD_ID, lead.getLEAD_ID());
            List<PrescreeningAnsBox> a = builder.build().find();

            int numberOfQuestionGiven = _serviceManager.getPrescreenigPartTwoQuestion(lead.getLEADOPTION_ID()).size();

            if (a.size() == 0) {
                Log.e(TAG, "no data found for 2nd phase screenig");

            } else {
                if (a.size() == numberOfQuestionGiven) {
                    for (PrescreeningAnsBox record : a) {
                        Log.e(TAG, "record is: " + record.toString());
                        if (record.getANSWER().equals(record.getCorrectAns())) {
                            totalMark += record.getMark();
                        }
                    }

                    if (totalMark >= passMark) {
                        Log.e(TAG, "user passed, total: " + totalMark + " required: " + passMark);
                        uploadLeadUpdate("P");
                    } else {
                        Log.e(TAG, "user failed, total: " + totalMark + " required: " + passMark);
                        uploadLeadUpdate("F");
                    }


                } else {
                    Log.e(TAG, "You have answer all of the question: " + totalMark + " required: " + passMark);
                    Toast.makeText(PreScreening1.this, "You have answer all of the question: ", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private void uploadLeadUpdate(String isPass) {

        HashMap<String, String> body = new HashMap<String, String>();
        body.put("LEAD_ID", lead.getLEAD_ID() + "");
        body.put("NID_NO", lead.getNID_NO());
        body.put("DATE_OF_BIRTH", lead.getDATE_OF_BIRTH());

        Call call = apiInterface.updateLead(Session.getHeaders(), body);

        call.enqueue(new Callback<CommonUploadResponse>() {
            @Override
            public void onResponse(Call<CommonUploadResponse> call, Response<CommonUploadResponse> response) {
                if (response.body() != null & response.isSuccessful()) {
                    if (response.body().getIsSuccessful()) {
                    } else {
                        Utils.showError(TAG, response.body().getMessage());
                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
            }

        });

    }

    private boolean isPassedOnPreeScreening1() {
        ansBox = ObjectBox.get().boxFor(PrescreeningAnsBox.class);

        boolean isPassed = false;
        QueryBuilder<PrescreeningAnsBox> builder = ansBox.query();
        builder.equal(PrescreeningAnsBox_.isFirstStep, 1) //1 is for 1st part questions
                .and()
                .equal(PrescreeningAnsBox_.LEAD_ID, lead.getLEAD_ID());
        List<PrescreeningAnsBox> a = builder.build().find();

        int numberOfQuestionGiven = _serviceManager.getPrescreenigPartOneQuestion(lead.getLEADOPTION_ID()).size();
        int numberOfQuestionAnswerd = a.size();

        if (numberOfQuestionGiven == numberOfQuestionAnswerd) {
            Log.e(TAG, "1=1 and data size is: " + a.size());


            for (int i = 0; i < a.size(); i++) {
                if (a.get(i).getANSWER().equals(a.get(i).getCorrectAns())) {
                    isPassed = true;
                } else {
                    return false;
                }
            }

        } else {
            return false;
        }

        return isPassed;
    }

    @Override
    public void onBackPressed() {
        if (_recyclerView.getTag().equals("1")) {
            super.onBackPressed();
            startActivity(new Intent(this, LeadListActivity.class));
            finish();
        } else {
            loadPreScreening1();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }


    private void uploadPrescreeningResultToServer(LeadBox lead) {
        List<PrescreeningAnsBox> existingPrescreeningAnsBoxList = _objectBoxManager.GetPrescreeningAnsBox(lead.getLEAD_ID());

        if (existingPrescreeningAnsBoxList == null || existingPrescreeningAnsBoxList.size() == 0) {
            Utils.showDialog(PreScreening1.this,"Please Give Answers Prescreening Question...");
            return;
        }

        int totalQuestionList = _questionList1.size() + _questionList2.size();
        int answeredList = existingPrescreeningAnsBoxList.size();

        if (answeredList < totalQuestionList) {
            Utils.showDialog(PreScreening1.this,"Answer pending for " + (totalQuestionList - answeredList) + " of " + totalQuestionList + ". Please answer all.");
            return;
        }

        final ProgressDialog progressDialog = new ProgressDialog(PreScreening1.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Submitting answers...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        _apiManager.uploadPreScreeningQuestion(existingPrescreeningAnsBoxList, new RequestListener<CommonUploadResponse>() {
            @Override
            public void onSuccess(CommonUploadResponse response) {
                progressDialog.dismiss();
                if (response.getIsSuccessful()) {
                    _objectBoxManager.RemovePrescreeningAnsBox(lead.getLEAD_ID());

                    String data = (String) response.getData();
                    Log.e(TAG, data);
                    Utils.showDialog(PreScreening1.this, response.getMessage());

                    if (data.toLowerCase().equals("p")) {
                        Utils.showDialog(PreScreening1.this, "Prescreenig Result - Pass").getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(PreScreening1.this, MemberList.class));
                                finish();
                            }
                        });

                    } else if (data.toLowerCase().equals("f")) {
                        Utils.showDialog(PreScreening1.this, "Prescreenig Result - Fail").getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(PreScreening1.this, LeadFailListActivity.class));
                                finish();
                            }
                        });
                    }

                } else {
                    Utils.showDialog(PreScreening1.this, response.getMessage());
                }
            }

            @Override
            public void onError(Throwable t) {
                progressDialog.dismiss();
                Utils.showError(TAG, t.getMessage());
            }
        });
    }
}