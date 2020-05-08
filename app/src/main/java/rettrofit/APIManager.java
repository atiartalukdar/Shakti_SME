package rettrofit;

import android.content.Context;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import bp.MyApplication;
import bp.Session;
import bp.Utils;
import dataModelForUpload.KYCDM;
import dataModelForUpload.LoanAgroDM;
import dataModelForUpload.LoanRemittanceDM;
import dataModelForUpload.LoanSalariedRentalBasedIncomeDM;
import dataModelForUpload.LoanTradeManufactoringDM;
import dataModelNew.BankNameDM;
import dataModelNew.BranchNameDM;
import dataModelNew.LoadConfigurationDM;
import dataModelNew.LoginDM;
import dataModelNew.MemberListDM;
import objectBox.LeadBox;
import objectBox.PrescreeningAnsBox;
import okhttp3.OkHttpClient;
import responseDataModel.CommonUploadResponse;
import responseDataModel.LeadResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class APIManager {
    //private static final String BASE_URL_NEW = "http://192.168.0.50:8081/";
    //private static final String BASE_URL_NEW = "http://116.193.221.99:8081/";
    public static final String BASE_URL_NEW = "http://api.sfdw.org:8083/";

    private final APIInterface api;
    private Context _context;
    HashMap<String, String> body = new HashMap<String, String>();

    public APIManager(){

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(5*60, TimeUnit.SECONDS)
                .readTimeout(2*60, TimeUnit.SECONDS)
                .writeTimeout(20*60, TimeUnit.SECONDS)
                .build();

        _context = MyApplication.getContext();
        Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL_NEW)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        api = retrofit.create(APIInterface.class);
    }

    public void login(String userID, String password, RequestListener<LoginDM> listener) {
        api.userSigninNew(userID, password, Utils.getVersionName()).enqueue(new APICallback<>(_context,listener));
    }

    public void loadConfigurationalData(RequestListener<LoadConfigurationDM> listener) {
        api.getConfigurationData(Session.getHeaders()).enqueue(new APICallback<>(_context,listener));
    }

    public void getMemberList(RequestListener<MemberListDM> listener) {
        body.put("BRANCH_ID", Session.getSeassionDataNew().getData().getBRANCHID());
        api.getMemberList(Session.getHeaders(),body).enqueue(new APICallback<>(_context,listener));
    }

    public void getLeadList(RequestListener<LeadResponse> listener) {
        body.put("BRANCH_ID", Session.getSeassionDataNew().getData().getBRANCHID());
        api.getLeadList(Session.getHeaders(),body).enqueue(new APICallback<>(_context,listener));
    }

    public void getFailedLeadList(RequestListener<LeadResponse> listener) {
        body.put("BRANCH_ID", Session.getSeassionDataNew().getData().getBRANCHID());
        api.getFailedLeadList(Session.getHeaders(),body).enqueue(new APICallback<>(_context,listener));
    }

    public void uploadLeadToServer(LeadBox leadBox,  RequestListener<CommonUploadResponse> listener){
        api.createLead(Session.getHeaders(),leadBox).enqueue(new APICallback<>(_context,listener));
    }

    public void uploadPreScreeningQuestion(List<PrescreeningAnsBox> prescreeningAnsBox, RequestListener<CommonUploadResponse> listener){
        api.sendPrescreeningData(Session.getHeaders(),prescreeningAnsBox).enqueue(new APICallback<>(_context,listener));
    }

    public void createMemberKYC(KYCDM kycdm, RequestListener<CommonUploadResponse> listener){
        api.createMemberKYC(Session.getHeaders(),kycdm).enqueue(new APICallback<>(_context,listener));
    }

    //=================== for uploading loan assessment =====================//
    public void createRemittanceLoan(LoanRemittanceDM loanRemittanceDM, RequestListener<CommonUploadResponse> listener){
        api.createRemittanceLoan(Session.getHeaders(),loanRemittanceDM).enqueue(new APICallback<>(_context,listener));
    }

    public void createSalariedAndRentalBasedIncomeLoan(LoanSalariedRentalBasedIncomeDM salariedRentalBasedIncomeDM, RequestListener<CommonUploadResponse> listener){
        api.createSalariedAndRentalBasedIncomeLoan(Session.getHeaders(),salariedRentalBasedIncomeDM).enqueue(new APICallback<>(_context,listener));
    }

    public void createTradeAndManufacturingLoan(LoanTradeManufactoringDM loanTradeManufactoringDM, RequestListener<CommonUploadResponse> listener){
        api.createTradeAndManufacturingLoan(Session.getHeaders(),loanTradeManufactoringDM).enqueue(new APICallback<>(_context,listener));
    }

    public void createAgroLoan(LoanAgroDM loanAgroDM, RequestListener<CommonUploadResponse> listener){
        api.createAgroLoan(Session.getHeaders(),loanAgroDM).enqueue(new APICallback<>(_context,listener));
    }

}
