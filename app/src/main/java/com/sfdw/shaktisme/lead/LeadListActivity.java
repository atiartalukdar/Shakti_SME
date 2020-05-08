package com.sfdw.shaktisme.lead;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.sfdw.shaktisme.MainActivity;
import com.sfdw.shaktisme.R;

import java.util.ArrayList;
import java.util.List;

import adapters.LeadListAdapter;
import bp.Session;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import objectBox.LeadBox;
import responseDataModel.LeadResponse;
import rettrofit.APIManager;
import rettrofit.RequestListener;
import services.ObjectBoxManager;

public class LeadListActivity extends AppCompatActivity {
    private final String TAG = getClass().getName() + " Atiar - ";

    @BindView(R.id.leadList1)
    RecyclerView recyclerView;

    @BindView(R.id.pullToRefresh)
    SwipeRefreshLayout _pullToRefresh;

    @BindView(R.id.shimmer_view_container)
    ShimmerFrameLayout _shimmerViewContainer;

    List<LeadBox> _leadList;
    LeadListAdapter _listAdapter;
    ObjectBoxManager _objectBoxManager;
    APIManager _apiManager;

    String _branchID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_list);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        _leadList = new ArrayList();
        _objectBoxManager = new ObjectBoxManager();
        _apiManager = new APIManager();

        _branchID = Session.getSeassionDataNew().getData().getBRANCHID();

        initializeList();

        _pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initializeList();
                _pullToRefresh.setRefreshing(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lead_list_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<LeadBox> tripResults = new ArrayList<LeadBox>();
                for (LeadBox x : _leadList) {

                    if (x.getAPPLICANT_NAME().toLowerCase().contains(newText.toLowerCase()) || x.getMOBILE_NO().contains(newText.toLowerCase()))
                        tripResults.add(x);
                }

                ((LeadListAdapter) recyclerView.getAdapter()).update(tripResults);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.app_bar_menu_reload:
                initializeList();
                break;
            case R.id.app_bar_new_lead:
                startActivity(new Intent(LeadListActivity.this, LeadActivity.class));
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

    private void initializeList() {

        _listAdapter = new LeadListAdapter(LeadListActivity.this, _leadList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        _listAdapter.setHasStableIds(true);
        recyclerView.setAdapter(_listAdapter);
        KProgressHUD kProgressHUD = Utils.showProgressDialog(this,getResources().getString(R.string.downloading));

        try {
            _leadList.clear();
            List<LeadBox> localLeadList = _objectBoxManager.GetLeadBoxList(_branchID);
            _leadList.addAll(localLeadList);
            _apiManager.getLeadList(new RequestListener<LeadResponse>() {
                @Override
                public void onSuccess(LeadResponse response) {

                    if (response != null) {
                        if (response.getIsSuccessful()) {
                            List<LeadBox> data = response.getData();
                            for (LeadBox item : data) {
                                if (item.getPRESCREENING_STATUS() != null) {
                                    if (!item.getPRESCREENING_STATUS().toLowerCase().equals("p") ||
                                            !item.getPRESCREENING_STATUS().toLowerCase().equals("f")) {
                                        _leadList.add(item);
                                    }
                                }else {
                                    _leadList.add(item);
                                }
                            }
                            _listAdapter.notifyDataSetChanged();
                            getSupportActionBar().setTitle("Total Lead(" + _leadList.size() + ")");
                        }
                    }
                }
                @Override
                public void onError(Throwable t) {
                    getSupportActionBar().setTitle("Total Lead(" + _leadList.size() + ")");
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "error when loading leadlist from server " + e.getMessage());
            Utils.showDialog(this,e.getMessage());
        }finally {
            _listAdapter.notifyDataSetChanged();
            _shimmerViewContainer.stopShimmerAnimation();
            _shimmerViewContainer.setVisibility(View.GONE);
            kProgressHUD.dismiss();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        _shimmerViewContainer.startShimmerAnimation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        _shimmerViewContainer.stopShimmerAnimation();

    }
}
