package com.sfdw.shaktisme.myInfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sfdw.shaktisme.R;

import bp.Session;

public class MyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        getSupportActionBar().setTitle(Session.getSeassionDataNew().getData().getNAME().trim() + " " +
                Session.getSeassionDataNew().getData().getUSERID() + " (" +
                Session.getSeassionDataNew().getData().getROLESHORTNAME() + " of " +
                Session.getSeassionDataNew().getData().getBRANCHID() + ")");
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
