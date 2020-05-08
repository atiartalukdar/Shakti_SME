package rettrofit;

import java.util.List;
import java.util.Map;

import dataModel.OptionList;
import dataModel.SendLoginDataResponse;
import dataModelForUpload.KYCDM;
import dataModelForUpload.LoanAgroDM;
import dataModelForUpload.LoanRemittanceDM;
import dataModelForUpload.LoanSalariedRentalBasedIncomeDM;
import dataModelForUpload.LoanTradeManufactoringDM;
import dataModelNew.BankNameDM;
import dataModelNew.BranchNameDM;
import dataModelNew.KYCDMNew;
import dataModelNew.LeadOptionDM;
import dataModelNew.LoadConfigurationDM;
import dataModelNew.LoginDM;
import dataModelNew.MemberListDM;
import dataModelNew.PrescreeningQuestionDM;
import objectBox.LeadBox;
import objectBox.PrescreeningAnsBox;
import responseDataModel.CommonUploadResponse;
import responseDataModel.LeadResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Streaming;


public interface APIInterface {

    //================== New Api =========================//
    @POST("api/apiLogin/Login")
    @FormUrlEncoded
    Call<LoginDM> userSigninNew(@Field("USER_ID") String userid,
                                @Field("Password") String password,
                                @Field("REQUEST_FROM") String appVersion);

    @POST("api/apisme/GetAppConfigInfo")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @Streaming
    Call<LoadConfigurationDM> getConfigurationData(@HeaderMap Map<String, String> headers);

    @POST("api/apisme/GetLeadList")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<LeadResponse> getLeadList(@HeaderMap Map<String, String> headers, @Body Map<String,String> parameters);

    @POST("api/apisme/GetFailedLeadList")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<LeadResponse> getFailedLeadList(@HeaderMap Map<String, String> headers, @Body Map<String,String> parameters);

    @POST("api/apisme/GetLeadOptionList")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<LeadOptionDM> getLeadOptions(@HeaderMap Map<String, String> headers);

    @POST("api/apisme/VerifyMobileNumber")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<CommonUploadResponse> checkMobileNo(@HeaderMap Map<String, String> headers, @Body Map<String,String> parameters);

    @POST("api/apisme/CreateLead")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<CommonUploadResponse> createLead(@HeaderMap Map<String, String> headers, @Body LeadBox leadBox);

    @POST("api/apisme/VerifyNationalID")
    @Headers({ "Content-Type: application/json"})
    Call<CommonUploadResponse> checkNID(@HeaderMap Map<String, String> headers,@Body Map<String,String> parameters );

    @POST("api/apisme/UpdateLeadInfo")
    @Headers({ "Content-Type: application/json"})
    Call<CommonUploadResponse> updateLead(@HeaderMap Map<String, String> headers,@Body Map<String,String> parameters);

    @POST("api/apisme/GetPreScreeningList")
    @Headers({ "Content-Type: application/json"})
    Call<PrescreeningQuestionDM> getPrescreening(@HeaderMap Map<String, String> headers,@Body Map<String,String> parameters);

    @Headers("Content-Type: application/json")
    @POST("api/apisme/SubmitPreScreening")
    Call<CommonUploadResponse> sendPrescreeningData(@HeaderMap Map<String, String> headers, @Body List<PrescreeningAnsBox> PrescreeningAnsBox);

    @POST("api/apisme/GetMemberList")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<MemberListDM> getMemberList(@HeaderMap Map<String, String> headers, @Body Map<String,String> parameters);

    @POST("api/apisme/GetMemberKYC")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<KYCDMNew> getMemberKYC(@HeaderMap Map<String, String> headers, @Body Map<String,String> parameters);

    @POST("api/apisme/CreateMemberKYC")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<CommonUploadResponse> createMemberKYC(@HeaderMap Map<String, String> headers, @Body Object kycDM);

    @POST("api/apisme/CreateTradeAndManufacturingLoan")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<CommonUploadResponse> createTradeAndManufacturingLoan(@HeaderMap Map<String, String> headers, @Body LoanTradeManufactoringDM tradeManufactoringDM);

    @POST("api/apisme/CreateAgroLoan")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<CommonUploadResponse> createAgroLoan(@HeaderMap Map<String, String> headers, @Body LoanAgroDM loanAgroDM);

    @POST("api/apisme/CreateRemittanceLoan")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<CommonUploadResponse> createRemittanceLoan(@HeaderMap Map<String, String> headers, @Body LoanRemittanceDM loanRemittanceDM);

    @POST("api/apisme/CreateSalariedAndRentalBasedIncomeLoan")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<CommonUploadResponse> createSalariedAndRentalBasedIncomeLoan(@HeaderMap Map<String, String> headers, @Body LoanSalariedRentalBasedIncomeDM loanSalariedRentalBasedIncomeDM);

    @POST("api/apisme/GetOptionList")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<OptionList> getOptionList(@HeaderMap Map<String, String> headers, @Body Map<String,String> parameters);

    @POST("api/apisme/GetBankList")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<BankNameDM> getBankList(@HeaderMap Map<String, String> headers);

    @POST("api/apisme/GetBankBranchList")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<BranchNameDM> getBranchList(@HeaderMap Map<String, String> headers, @Body Map<String,String> parameters);
}
