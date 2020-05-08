package com.sfdw.shaktisme.lead;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.sfdw.shaktisme.MainActivity;
import com.sfdw.shaktisme.R;

import java.util.ArrayList;
import java.util.List;

import adapters.FailedLeadListAdapter;
import bp.Session;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import objectBox.LeadBox;
import rettrofit.APIManager;
import responseDataModel.LeadResponse;
import rettrofit.RequestListener;

public class LeadFailListActivity extends AppCompatActivity {
    @BindView(R.id.leadFailList)
    RecyclerView _recylerView;
    @BindView(R.id.pullToRefresh)
    SwipeRefreshLayout _pullToRefresh;

    List<LeadBox> _leadList;
    FailedLeadListAdapter _leadListAdapter;
    APIManager _apiManager;
    String _branchId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_fail_list);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        _leadList   =   new ArrayList();
        _apiManager = new APIManager();
        _branchId = Session.getSeassionDataNew().getData().getBRANCHID();

        initializeDataList();

        _pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initializeDataList();
                _pullToRefresh.setRefreshing(false);
            }
        });
    }

    private void initializeDataList(){
        try {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(true);
            progressDialog.show();

            _apiManager.getFailedLeadList(new RequestListener<LeadResponse>() {
                @Override
                public void onSuccess(LeadResponse response) {
                    if (response != null) {
                        if (response.getIsSuccessful()) {
                            List<LeadBox> data = response.getData();
                            if(data.size() > 0 ){
                                _leadList.clear();
                                _leadList.addAll(data);
                                _leadListAdapter = new FailedLeadListAdapter(LeadFailListActivity.this, _leadList);
                                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                                _recylerView.setLayoutManager(mLayoutManager);
                                _recylerView.setItemAnimator(new DefaultItemAnimator());
                                _recylerView.setAdapter(_leadListAdapter);
                                _leadListAdapter.notifyDataSetChanged();
                                getSupportActionBar().setTitle("Total Lead(" + _leadList.size() + ")");
                            }
                            else{
                                Utils.showDialog(LeadFailListActivity.this, "No data found.");
                            }
                        }
                    }
                }

                @Override
                public void onError(Throwable t) {
                }
            });

            progressDialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.app_bar_menu_reload:
                initializeDataList();
                break;
            case R.id.app_bar_new_lead:
                startActivity(new Intent(LeadFailListActivity.this, LeadActivity.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
