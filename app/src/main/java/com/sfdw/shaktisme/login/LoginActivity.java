package com.sfdw.shaktisme.login;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.sfdw.shaktisme.MainActivity;
import com.sfdw.shaktisme.R;

import bp.Session;
import bp.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import dataModelNew.LoadConfigurationDM;
import dataModelNew.LoginDM;
import rettrofit.APIManager;
import rettrofit.RequestListener;
import services.ServiceManager;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName()+"Atiar - ";
    APIManager _apiManager = new APIManager();
    ServiceManager _serviceManager = new ServiceManager();

    @BindView(R.id.input_userID)            EditText _inputUserID;
    @BindView(R.id.input_password)          EditText _passwordText;
    @BindView(R.id.btn_login)               Button _loginButton;
    @BindView(R.id.imgBtnLogo)              ImageButton _imageBtnLogo;
    @BindView(R.id.loginLayout)             RelativeLayout _loginLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new);
        ButterKnife.bind(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginNew();
            }
        });

    }

    public void loginNew() {
        if (!Utils.isNetworkConnected()){
            Utils.showDialog(this,"Internet is not available. Please connect with internet.");
            return;
        }

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        _apiManager.login(_inputUserID.getText().toString(), _passwordText.getText().toString(), new RequestListener<LoginDM>() {
            @Override
            public void onSuccess(LoginDM response) {
                if (response != null) {
                    progressDialog.dismiss();
                    if (response.getIsSuccessful()) {
                        Session.createSeassionNew(_passwordText.getText().toString(),response);
                        onLoginSuccess();
                    } else {
                        popupAuth(response.getMessage());
                        _loginButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void onError(Throwable t) {

                progressDialog.dismiss();
                onLoginFailed();
            }
        });
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

    public void onLoginSuccess() {
        loadConfigurationData();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Server problem", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String userID = _inputUserID.getText().toString();
        String password = _passwordText.getText().toString();

        if (userID.isEmpty()) {
            _inputUserID.setError("enter a valid email address");
            valid = false;
        } else {
            _inputUserID.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    private void popupAuth(String message){

        new AlertDialog.Builder(this)
                .setTitle("Incorrect password")
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void loadConfigurationData() {
        KProgressHUD kProgressHUD = Utils.showProgressDialog(this,"Loading Configuration Data ... ");

        Log.e(TAG, "Configuration Data Retrieving");

        _apiManager.loadConfigurationalData(new RequestListener<LoadConfigurationDM>() {
            @Override
            public void onSuccess(LoadConfigurationDM response) {

                if (response.getIsSuccessful()) {
                    _serviceManager.setConfigurationData(response);
                    Log.e(TAG, "Configuration Data Successfully Retrieved");

                    _loginButton.setEnabled(true);
                    kProgressHUD.dismiss();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();

                }else {
                    Log.e(TAG, "Configuration Data Retrieved UnSuccessfull");

                }
                kProgressHUD.dismiss();
            }

            @Override
            public void onError(Throwable t) {
                Log.e(TAG, t.getMessage());
                Log.e(TAG, "Getting error when loading configuration data.");
                kProgressHUD.dismiss();
            }
        });
    }

}
