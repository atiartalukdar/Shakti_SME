package com.sfdw.shaktisme.memberList;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.sfdw.shaktisme.MainActivity;
import com.sfdw.shaktisme.R;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import adapters.MemberListAdapter;
import bp.BaseActivity;
import bp.SP;
import bp.Session;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.MemberListDM;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rettrofit.APIInterface;
import rettrofit.APIManager;
import rettrofit.RequestListener;
import rettrofit.RetrofitClientInstance;
import services.ServiceManager;

public class MemberList extends BaseActivity {
    private final String TAG = getClass().getName() + " Atiar - ";
    APIManager _apiManager = new APIManager();

    @BindView(R.id.memberList)        ListView _memberList;
    @BindView(R.id.expanded_image)    CircleImageView _memberPhoto;
    @BindView(R.id.pullToRefresh)     SwipeRefreshLayout _pullToRefresh;

    Retrofit retrofit;
    APIInterface apiInterface;
    MemberListAdapter adapter;

    List<MemberListDM.Data> memberLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        memberLists = new ArrayList<>();

        retrofit = RetrofitClientInstance.getRetrofitInstanceNew();
        apiInterface = retrofit.create(APIInterface.class);

        adapter = new MemberListAdapter(this, memberLists);
        _memberList.setAdapter(adapter);

        getSupportActionBar().setTitle("Member List (" + memberLists.size() + ")");

        loadMemberListFromServer();


        _pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadMemberListFromServer();
                _pullToRefresh.setRefreshing(false);
            }
        });

    }

    private void loadMemberListFromServer() {

        KProgressHUD kProgressHUD = Utils.showProgressDialog(this, getResources().getString(R.string.downloading));

        _apiManager.getMemberList(new RequestListener<MemberListDM>() {
            @Override
            public void onSuccess(MemberListDM response) {
                if (response.getIsSuccessful()) {
                    memberLists.clear();
                    for (MemberListDM.Data data : response.getData()) {
                        memberLists.add(data);
                        adapter.notifyDataSetChanged();
                    }
                }else {
                    Utils.showDialog(MemberList.this,response.getMessage());
                }
                getSupportActionBar().setTitle("Member List (" + memberLists.size() + ")");
                SP.setTotalMember(memberLists.size() + "");
                kProgressHUD.dismiss();
            }

            @Override
            public void onError(Throwable t) {
                kProgressHUD.dismiss();
                Log.e(TAG, t.toString());
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.member_list_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.app_bar_menu_search);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<MemberListDM.Data> tripResults = new ArrayList<MemberListDM.Data>();
                for (MemberListDM.Data x : memberLists) {
                    if (x.getMEMBER_NAME().toLowerCase().contains(newText.toLowerCase()) || x.getMOBILE_NO().toLowerCase().contains(newText.toLowerCase())|| x.getMEMBER_ID().toLowerCase().contains(newText.toLowerCase()))
                        tripResults.add(x);
                }

                //adapterTransport.update(tripResults);
                ((MemberListAdapter) _memberList.getAdapter()).update(tripResults);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.app_bar_menu_reload:
                loadMemberListFromServer();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
