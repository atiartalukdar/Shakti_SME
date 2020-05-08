package dataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeadListResponseDataModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("data")
    @Expose
    private List<Data> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }


    public class Data {

        @SerializedName("lead_id")
        @Expose
        private Integer leadId;
        @SerializedName("applicant_name")
        @Expose
        private String applicantName;
        @SerializedName("nid_no")
        @Expose
        private String nidNo;
        @SerializedName("mobile_no")
        @Expose
        private String mobileNo;
        @SerializedName("date_of_birth")
        @Expose
        private String dateOfBirth;
        @SerializedName("pre_adress")
        @Expose
        private String preAdress;
        @SerializedName("buis_address")
        @Expose
        private String buisAddress;
        @SerializedName("work_address")
        @Expose
        private String workAddress;
        @SerializedName("lead_option_id")
        @Expose
        private Integer leadOptionId;
        @SerializedName("laon_amount")
        @Expose
        private Integer laonAmount;
        @SerializedName("branch_id")
        @Expose
        private String branchId;
        @SerializedName("center_no")
        @Expose
        private String centerNo;
        @SerializedName("created_by")
        @Expose
        private String createdBy;
        @SerializedName("create_date")
        @Expose
        private String createDate;
        @SerializedName("screening_status")
        @Expose
        private Integer screeningStatus;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("imei_no")
        @Expose
        private String imeiNo;
        @SerializedName("lead_status")
        @Expose
        private String leadStatus;
        @SerializedName("last_update_time")
        @Expose
        private String lastUpdateTime;
        @SerializedName("last_update_by")
        @Expose
        private String lastUpdateBy;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("image_file")
        @Expose
        private String imageFile;
        @SerializedName("lead_gps_address")
        @Expose
        private String leadGpsAddress;
        @SerializedName("dev_phone")
        @Expose
        private String devPhone;

        public Integer getLeadId() {
            return leadId;
        }

        public void setLeadId(Integer leadId) {
            this.leadId = leadId;
        }

        public String getApplicantName() {
            return applicantName;
        }

        public void setApplicantName(String applicantName) {
            this.applicantName = applicantName;
        }

        public String getNidNo() {
            return nidNo;
        }

        public void setNidNo(String nidNo) {
            this.nidNo = nidNo;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getPreAdress() {
            return preAdress;
        }

        public void setPreAdress(String preAdress) {
            this.preAdress = preAdress;
        }

        public String getBuisAddress() {
            return buisAddress;
        }

        public void setBuisAddress(String buisAddress) {
            this.buisAddress = buisAddress;
        }

        public String getWorkAddress() {
            return workAddress;
        }

        public void setWorkAddress(String workAddress) {
            this.workAddress = workAddress;
        }

        public Integer getLeadOptionId() {
            return leadOptionId;
        }

        public void setLeadOptionId(Integer leadOptionId) {
            this.leadOptionId = leadOptionId;
        }

        public Integer getLaonAmount() {
            return laonAmount;
        }

        public void setLaonAmount(Integer laonAmount) {
            this.laonAmount = laonAmount;
        }

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public String getCenterNo() {
            return centerNo;
        }

        public void setCenterNo(String centerNo) {
            this.centerNo = centerNo;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public Integer getScreeningStatus() {
            return screeningStatus;
        }

        public void setScreeningStatus(Integer screeningStatus) {
            this.screeningStatus = screeningStatus;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getImeiNo() {
            return imeiNo;
        }

        public void setImeiNo(String imeiNo) {
            this.imeiNo = imeiNo;
        }

        public String getLeadStatus() {
            return leadStatus;
        }

        public void setLeadStatus(String leadStatus) {
            this.leadStatus = leadStatus;
        }

        public String getLastUpdateTime() {
            return lastUpdateTime;
        }

        public void setLastUpdateTime(String lastUpdateTime) {
            this.lastUpdateTime = lastUpdateTime;
        }

        public String getLastUpdateBy() {
            return lastUpdateBy;
        }

        public void setLastUpdateBy(String lastUpdateBy) {
            this.lastUpdateBy = lastUpdateBy;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getImageFile() {
            return imageFile;
        }

        public void setImageFile(String imageFile) {
            this.imageFile = imageFile;
        }

        public String getLeadGpsAddress() {
            return leadGpsAddress;
        }

        public void setLeadGpsAddress(String leadGpsAddress) {
            this.leadGpsAddress = leadGpsAddress;
        }

        public String getDevPhone() {
            return devPhone;
        }

        public void setDevPhone(String devPhone) {
            this.devPhone = devPhone;
        }

    }

}