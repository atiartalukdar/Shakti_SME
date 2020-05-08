package objectBox;

import java.io.Serializable;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LeadBox implements Serializable {
    @Id
    long id;
    private boolean IS_OFFLINE = false;
    private int LEAD_ID;
    private String APPLICANT_NAME;
    private String NID_NO;
    private String MOBILE_NO;
    private String DATE_OF_BIRTH;
    private String PRESENT_ADDRESS;
    private String BUSINESS_ADDRESS;
    private String WORK_ADDRESS;
    private int LEADOPTION_ID;
    private Double LOAN_AMOUNT;
    private String BRANCH_ID;
    private String RO_ID;
    private String GENDER;
    private String IMEI;
    private String STATUS;
    private String LATITUDE;
    private String LONGITUDE;
    private String LEAD_GPS_ADDRESS;
    private String DEVICEPHONE_NUMBER;
    private String ORG_NAME;
    private String PRESCREENING_STATUS;
    private String NID_FRONT_DOC;
    private String NID_BACK_DOC;
    private String NID_FRONT_URL;
    private String NID_BACK_URL;

    public LeadBox() {
    }

    public boolean isIS_OFFLINE() {
        return IS_OFFLINE;
    }

    public void setIS_OFFLINE(boolean IS_OFFLINE) {
        this.IS_OFFLINE = IS_OFFLINE;
    }

    public int getLEAD_ID() {
        return LEAD_ID;
    }

    public void setLEAD_ID(int LEAD_ID) {
        this.LEAD_ID = LEAD_ID;
    }

    public String getAPPLICANT_NAME() {
        return APPLICANT_NAME;
    }

    public void setAPPLICANT_NAME(String APPLICANT_NAME) {
        this.APPLICANT_NAME = APPLICANT_NAME;
    }

    public String getNID_NO() {
        return NID_NO;
    }

    public void setNID_NO(String NID_NO) {
        this.NID_NO = NID_NO;
    }

    public String getMOBILE_NO() {
        return MOBILE_NO;
    }

    public void setMOBILE_NO(String MOBILE_NO) {
        this.MOBILE_NO = MOBILE_NO;
    }

    public String getDATE_OF_BIRTH() {
        return DATE_OF_BIRTH;
    }

    public void setDATE_OF_BIRTH(String DATE_OF_BIRTH) {
        this.DATE_OF_BIRTH = DATE_OF_BIRTH;
    }

    public String getPRESENT_ADDRESS() {
        return PRESENT_ADDRESS;
    }

    public void setPRESENT_ADDRESS(String PRESENT_ADDRESS) {
        this.PRESENT_ADDRESS = PRESENT_ADDRESS;
    }

    public String getBUSINESS_ADDRESS() {
        return BUSINESS_ADDRESS;
    }

    public void setBUSINESS_ADDRESS(String BUSINESS_ADDRESS) {
        this.BUSINESS_ADDRESS = BUSINESS_ADDRESS;
    }

    public String getWORK_ADDRESS() {
        return WORK_ADDRESS;
    }

    public void setWORK_ADDRESS(String WORK_ADDRESS) {
        this.WORK_ADDRESS = WORK_ADDRESS;
    }

    public int getLEADOPTION_ID() {
        return LEADOPTION_ID;
    }

    public void setLEADOPTION_ID(int LEADOPTION_ID) {
        this.LEADOPTION_ID = LEADOPTION_ID;
    }

    public Double getLOAN_AMOUNT() {
        return LOAN_AMOUNT;
    }

    public void setLOAN_AMOUNT(Double LOAN_AMOUNT) {
        this.LOAN_AMOUNT = LOAN_AMOUNT;
    }

    public String getBRANCH_ID() {
        return BRANCH_ID;
    }

    public void setBRANCH_ID(String BRANCH_ID) {
        this.BRANCH_ID = BRANCH_ID;
    }

    public String getRO_ID() {
        return RO_ID;
    }

    public void setRO_ID(String RO_ID) {
        this.RO_ID = RO_ID;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(String LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public String getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(String LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public String getLEAD_GPS_ADDRESS() {
        return LEAD_GPS_ADDRESS;
    }

    public void setLEAD_GPS_ADDRESS(String LEAD_GPS_ADDRESS) {
        this.LEAD_GPS_ADDRESS = LEAD_GPS_ADDRESS;
    }

    public String getDEVICEPHONE_NUMBER() {
        return DEVICEPHONE_NUMBER;
    }

    public void setDEVICEPHONE_NUMBER(String DEVICEPHONE_NUMBER) {
        this.DEVICEPHONE_NUMBER = DEVICEPHONE_NUMBER;
    }

    public String getORG_NAME() {
        return ORG_NAME;
    }

    public void setORG_NAME(String ORG_NAME) {
        this.ORG_NAME = ORG_NAME;
    }

    public String getPRESCREENING_STATUS() {
        return PRESCREENING_STATUS;
    }

    public void setPRESCREENING_STATUS(String PRESCREENING_STATUS) {
        this.PRESCREENING_STATUS = PRESCREENING_STATUS;
    }

    public String getNID_FRONT_DOC() {
        return NID_FRONT_DOC;
    }

    public void setNID_FRONT_DOC(String NID_FRONT_DOC) {
        this.NID_FRONT_DOC = NID_FRONT_DOC;
    }

    public String getNID_BACK_DOC() {
        return NID_BACK_DOC;
    }

    public void setNID_BACK_DOC(String NID_BACK_DOC) {
        this.NID_BACK_DOC = NID_BACK_DOC;
    }

    public String getNID_FRONT_URL() {
        return NID_FRONT_URL;
    }

    public void setNID_FRONT_URL(String NID_FRONT_URL) {
        this.NID_FRONT_URL = NID_FRONT_URL;
    }

    public String getNID_BACK_URL() {
        return NID_BACK_URL;
    }

    public void setNID_BACK_URL(String NID_BACK_URL) {
        this.NID_BACK_URL = NID_BACK_URL;
    }
}
