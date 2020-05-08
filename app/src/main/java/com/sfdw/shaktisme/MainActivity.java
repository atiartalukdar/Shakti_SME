package com.sfdw.shaktisme;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.UpdateFrom;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.onesignal.OneSignal;
import com.sfdw.shaktisme.lead.LeadActivity;
import com.sfdw.shaktisme.lead.LeadFailListActivity;
import com.sfdw.shaktisme.lead.LeadListActivity;
import com.sfdw.shaktisme.memberList.MemberList;
import com.sfdw.shaktisme.myInfo.MyInfo;

import org.json.JSONObject;

import java.util.List;

import bp.SP;
import bp.Session;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private final String TAG = getClass().getName() + " Atiar - ";

    @BindView(R.id.home_lead_list_imageView)            ImageView _leadList;
    @BindView(R.id.home_member_list_imageView)          ImageView _memberList;
    @BindView(R.id.createNewLead)                       ImageView _createNewLead;
    @BindView(R.id.myInfo)                              ImageView _myInfo;
    @BindView(R.id.toolbar)                             Toolbar _toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        requestForPermission();

        try{
            _toolbar.setTitle(getResources().getString(R.string.app_name)+ " V" + Utils.getVersionName() + " " + Utils.getServerType());
        }catch (Exception e){
            e.printStackTrace();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, _toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        try {
            JSONObject tags = new JSONObject();
            tags.put("IMEI", SP.getDeviceIMEI());
            tags.put("ID", Session.getUserID());
            tags.put("Branch", Session.getSeassionDataNew().getData().getBRANCHID());
            tags.put("Name", Session.getSeassionDataNew().getData().getNAME());
            tags.put("Role", Session.getSeassionDataNew().getData().getROLENAME());
            OneSignal.sendTags(tags);
        }catch (Exception e){
            e.printStackTrace();
        }

        initializeOnClick();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawar_item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_new_lead:
                //do something
                startActivity(new Intent(MainActivity.this, LeadActivity.class));
                break;

            case R.id.nav_lead_list:
                //do something
                startActivity(new Intent(MainActivity.this, LeadListActivity.class));
                break;

            case R.id.nav_lead_failed_list:
                startActivity(new Intent(MainActivity.this, LeadFailListActivity.class));
                break;

            case R.id.nav_member_list:
                startActivity(new Intent(MainActivity.this, MemberList.class));
                break;

            case R.id.nav_collection_schedule:
                Toast.makeText(getApplicationContext(), "Feature is comming soon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_general_info:
                //do something
                Toast.makeText(getApplicationContext(), "Feature is comming soon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_logout:
                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to logout?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                                Session.logout();
                                startActivity(new Intent(MainActivity.this,SplashActivity.class));
                                finish();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        finishAndRemoveTask();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Utils.checkForceUpdate();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_lead_list_imageView:
                startActivity(new Intent(MainActivity.this, LeadListActivity.class));
                finish();
                break;
            case R.id.home_member_list_imageView:
                startActivity(new Intent(MainActivity.this, MemberList.class));
                finish();
                break;
            case R.id.createNewLead:
                startActivity(new Intent(MainActivity.this, LeadActivity.class));
                break;
            case R.id.myInfo:
                startActivity(new Intent(MainActivity.this, MyInfo.class));
                break;

        }
    }

    private void initializeOnClick(){
        _leadList.setOnClickListener(this);
        _memberList.setOnClickListener(this);
        _createNewLead.setOnClickListener(this);
        _myInfo.setOnClickListener(this);
    }

    public void requestForPermission() {
        // Requesting ACCESS_FINE_LOCATION using Dexter library
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {

                        if (report.isAnyPermissionPermanentlyDenied()) {
                            openSettings();
                        }
                        if (!report.areAllPermissionsGranted()) {
                            requestForPermission();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                        //openSettings();

                    }
                })
                .check();
    }

    public void openSettings() {
        Intent intent = new Intent();
        intent.setAction(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package",
                BuildConfig.APPLICATION_ID, null);
        intent.setData(uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
