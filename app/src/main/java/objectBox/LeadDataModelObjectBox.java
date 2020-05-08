package objectBox;

import java.io.Serializable;

import bp.Session;
import dataModel.LeadListResponseDataModel;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LeadDataModelObjectBox implements Serializable {
    @Id
    long id;
/*

    String lead_id;
    String applicant_name;
    String nid_no ;
    String mobile_no;
    String date_of_birth ;
    String pre_adress;
    String buis_address;
    String work_address;
    String lead_option_id ;
    String loan_amount ;
    String branch_id;
    String screening_status ;
    String gender ;
    String imei_no;
    String latitude ;
    String longitude;
    String image_file ;
    String dev_phone;
    String user_id;
    String access_token;
    String prescreeningStatus ;
*/
    private String userID;
    private String accessToken;
    private Integer leadId;
    private String applicantName;
    private String nidNo;
    private String mobileNo;
    private String dateOfBirth;
    private String preAdress;
    private String buisAddress;
    private String workAddress;
    private Integer leadOptionId;
    private Integer laonAmount;
    private String branchId;

    private String centerNo;
    private String createdBy;
    private String createDate;

    private Integer screeningStatus;
    private String gender;
    private String imeiNo;
    private String leadStatus;

    private String lastUpdateTime;
    private String lastUpdateBy;

    private String latitude;
    private String longitude;
    private String imageFile;
    private String leadGpsAddress;
    private String devPhone;

    public LeadDataModelObjectBox() {
    }

    public LeadDataModelObjectBox(LeadListResponseDataModel.Data data){
        this.userID = Session.getUserID();
        this.accessToken = Session.getSeassionData().getAccessToken();
        this.leadId = data.getLeadId();
        this.applicantName = data.getApplicantName();
        this.nidNo = data.getNidNo();
        this.mobileNo = data.getMobileNo();
        this.dateOfBirth = data.getDateOfBirth();
        this.preAdress = data.getPreAdress();
        this.buisAddress = data.getBuisAddress();
        this.workAddress = data.getWorkAddress();
        this.leadOptionId = data.getLeadOptionId();
        this.laonAmount = data.getLaonAmount();
        this.branchId = data.getBranchId();
        this.centerNo = data.getCenterNo();
        this.createdBy = data.getCreatedBy();
        this.createDate = data.getCreateDate();
        this.screeningStatus = data.getScreeningStatus();
        this.gender = data.getGender();
        this.imeiNo = data.getImeiNo();
        this.leadStatus = data.getLeadStatus();
        this.lastUpdateTime = data.getLastUpdateTime();
        this.lastUpdateBy = data.getLastUpdateBy();
        this.latitude = data.getLatitude();
        this.longitude = data.getLongitude();
        this.imageFile = data.getImageFile();
        this.leadGpsAddress = data.getLeadGpsAddress();
        this.devPhone = data.getDevPhone();
    }


    public LeadDataModelObjectBox(String userID, String accessToken, Integer leadId, String applicantName, String nidNo, String mobileNo, String dateOfBirth, String preAdress, String buisAddress, String workAddress, Integer leadOptionId, Integer laonAmount, String branchId, String centerNo, String createdBy, String createDate, Integer screeningStatus, String gender, String imeiNo, String leadStatus, String lastUpdateTime, String lastUpdateBy, String latitude, String longitude, String imageFile, String leadGpsAddress, String devPhone) {
        this.userID = userID;
        this.accessToken = accessToken;
        this.leadId = leadId;
        this.applicantName = applicantName;
        this.nidNo = nidNo;
        this.mobileNo = mobileNo;
        this.dateOfBirth = dateOfBirth;
        this.preAdress = preAdress;
        this.buisAddress = buisAddress;
        this.workAddress = workAddress;
        this.leadOptionId = leadOptionId;
        this.laonAmount = laonAmount;
        this.branchId = branchId;
        this.centerNo = centerNo;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.screeningStatus = screeningStatus;
        this.gender = gender;
        this.imeiNo = imeiNo;
        this.leadStatus = leadStatus;
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateBy = lastUpdateBy;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageFile = imageFile;
        this.leadGpsAddress = leadGpsAddress;
        this.devPhone = devPhone;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

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


    @Override
    public String toString() {
        return "LeadDataModelObjectBox{" +
                "id=" + id +
                ", userID='" + userID + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", leadId=" + leadId +
                ", applicantName='" + applicantName + '\'' +
                ", nidNo='" + nidNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", preAdress='" + preAdress + '\'' +
                ", buisAddress=" + buisAddress +
                ", workAddress='" + workAddress + '\'' +
                ", leadOptionId=" + leadOptionId +
                ", laonAmount=" + laonAmount +
                ", branchId='" + branchId + '\'' +
                ", centerNo='" + centerNo + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createDate='" + createDate + '\'' +
                ", screeningStatus=" + screeningStatus +
                ", gender='" + gender + '\'' +
                ", imeiNo='" + imeiNo + '\'' +
                ", leadStatus='" + leadStatus + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                ", lastUpdateBy=" + lastUpdateBy +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", imageFile=" + imageFile +
                ", leadGpsAddress='" + leadGpsAddress + '\'' +
                ", devPhone='" + devPhone + '\'' +
                '}';
    }
}