package objectBox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeadBoxNew {
    @SerializedName("LEAD_ID")
    @Expose
    private Integer lEAD_ID;
    @SerializedName("APPLICANT_NAME")
    @Expose
    private String aPPLICANT_NAME;
    @SerializedName("NID_NO")
    @Expose
    private String nID_NO;
    @SerializedName("MOBILE_NO")
    @Expose
    private String mOBILE_NO;
    @SerializedName("DATE_OF_BIRTH")
    @Expose
    private Object dATE_OF_BIRTH;
    @SerializedName("PRESENT_ADDRESS")
    @Expose
    private String pRESENT_ADDRESS;
    @SerializedName("BUSINESS_ADDRESS")
    @Expose
    private String bUSINESS_ADDRESS;
    @SerializedName("WORK_ADDRESS")
    @Expose
    private String wORK_ADDRESS;
    @SerializedName("LEADOPTION_ID")
    @Expose
    private Integer lEADOPTION_ID;
    @SerializedName("LOAN_AMOUNT")
    @Expose
    private Double lOAN_AMOUNT;
    @SerializedName("BRANCH_ID")
    @Expose
    private String bRANCH_ID;
    @SerializedName("RO_ID")
    @Expose
    private String rO_ID;
    @SerializedName("GENDER")
    @Expose
    private String gENDER;
    @SerializedName("IMEI")
    @Expose
    private String iMEI;
    @SerializedName("STATUS")
    @Expose
    private String sTATUS;
    @SerializedName("LATITUDE")
    @Expose
    private String lATITUDE;
    @SerializedName("LONGITUDE")
    @Expose
    private String lONGITUDE;
    @SerializedName("LEAD_GPS_ADDRESS")
    @Expose
    private String lEAD_GPS_ADDRESS;
    @SerializedName("DEVICEPHONE_NUMBER")
    @Expose
    private String dEVICEPHONE_NUMBER;
    @SerializedName("ORG_NAME")
    @Expose
    private String oRG_NAME;
    @SerializedName("PRESCREENING_STATUS")
    @Expose
    private String pRESCREENING_STATUS;
    @SerializedName("NID_FRONT_DOC")
    @Expose
    private Object nID_FRONT_DOC;
    @SerializedName("NID_BACK_DOC")
    @Expose
    private Object nID_BACK_DOC;
    @SerializedName("NID_FRONT_URL")
    @Expose
    private String nID_FRONT_URL;
    @SerializedName("NID_BACK_URL")
    @Expose
    private String nID_BACK_URL;
    @SerializedName("TRAN_ID")
    @Expose
    private Integer tRAN_ID;
    @SerializedName("SET_DATE")
    @Expose
    private String sET_DATE;
    @SerializedName("SET_BY")
    @Expose
    private String sET_BY;
    @SerializedName("IS_ACTIVE")
    @Expose
    private Integer iS_ACTIVE;
    @SerializedName("IS_DELETED")
    @Expose
    private Integer iS_DELETED;

    public Integer getLEAD_ID() {
        return lEAD_ID;
    }

    public void setLEAD_ID(Integer lEAD_ID) {
        this.lEAD_ID = lEAD_ID;
    }

    public String getAPPLICANT_NAME() {
        return aPPLICANT_NAME;
    }

    public void setAPPLICANT_NAME(String aPPLICANT_NAME) {
        this.aPPLICANT_NAME = aPPLICANT_NAME;
    }

    public String getNID_NO() {
        return nID_NO;
    }

    public void setNID_NO(String nID_NO) {
        this.nID_NO = nID_NO;
    }

    public String getMOBILE_NO() {
        return mOBILE_NO;
    }

    public void setMOBILE_NO(String mOBILE_NO) {
        this.mOBILE_NO = mOBILE_NO;
    }

    public Object getDATE_OF_BIRTH() {
        return dATE_OF_BIRTH;
    }

    public void setDATE_OF_BIRTH(Object dATE_OF_BIRTH) {
        this.dATE_OF_BIRTH = dATE_OF_BIRTH;
    }

    public String getPRESENT_ADDRESS() {
        return pRESENT_ADDRESS;
    }

    public void setPRESENT_ADDRESS(String pRESENT_ADDRESS) {
        this.pRESENT_ADDRESS = pRESENT_ADDRESS;
    }

    public String getBUSINESS_ADDRESS() {
        return bUSINESS_ADDRESS;
    }

    public void setBUSINESS_ADDRESS(String bUSINESS_ADDRESS) {
        this.bUSINESS_ADDRESS = bUSINESS_ADDRESS;
    }

    public String getWORK_ADDRESS() {
        return wORK_ADDRESS;
    }

    public void setWORK_ADDRESS(String wORK_ADDRESS) {
        this.wORK_ADDRESS = wORK_ADDRESS;
    }

    public Integer getLEADOPTION_ID() {
        return lEADOPTION_ID;
    }

    public void setLEADOPTION_ID(Integer lEADOPTION_ID) {
        this.lEADOPTION_ID = lEADOPTION_ID;
    }

    public Double getLOAN_AMOUNT() {
        return lOAN_AMOUNT;
    }

    public void setLOAN_AMOUNT(Double lOAN_AMOUNT) {
        this.lOAN_AMOUNT = lOAN_AMOUNT;
    }

    public String getBRANCH_ID() {
        return bRANCH_ID;
    }

    public void setBRANCH_ID(String bRANCH_ID) {
        this.bRANCH_ID = bRANCH_ID;
    }

    public String getRO_ID() {
        return rO_ID;
    }

    public void setRO_ID(String rO_ID) {
        this.rO_ID = rO_ID;
    }

    public String getGENDER() {
        return gENDER;
    }

    public void setGENDER(String gENDER) {
        this.gENDER = gENDER;
    }

    public String getIMEI() {
        return iMEI;
    }

    public void setIMEI(String iMEI) {
        this.iMEI = iMEI;
    }

    public String getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }

    public String getLATITUDE() {
        return lATITUDE;
    }

    public void setLATITUDE(String lATITUDE) {
        this.lATITUDE = lATITUDE;
    }

    public String getLONGITUDE() {
        return lONGITUDE;
    }

    public void setLONGITUDE(String lONGITUDE) {
        this.lONGITUDE = lONGITUDE;
    }

    public String getLEAD_GPS_ADDRESS() {
        return lEAD_GPS_ADDRESS;
    }

    public void setLEAD_GPS_ADDRESS(String lEAD_GPS_ADDRESS) {
        this.lEAD_GPS_ADDRESS = lEAD_GPS_ADDRESS;
    }

    public String getDEVICEPHONE_NUMBER() {
        return dEVICEPHONE_NUMBER;
    }

    public void setDEVICEPHONE_NUMBER(String dEVICEPHONE_NUMBER) {
        this.dEVICEPHONE_NUMBER = dEVICEPHONE_NUMBER;
    }

    public String getORG_NAME() {
        return oRG_NAME;
    }

    public void setORG_NAME(String oRG_NAME) {
        this.oRG_NAME = oRG_NAME;
    }

    public String getPRESCREENING_STATUS() {
        return pRESCREENING_STATUS;
    }

    public void setPRESCREENING_STATUS(String pRESCREENING_STATUS) {
        this.pRESCREENING_STATUS = pRESCREENING_STATUS;
    }

    public Object getNID_FRONT_DOC() {
        return nID_FRONT_DOC;
    }

    public void setNID_FRONT_DOC(Object nID_FRONT_DOC) {
        this.nID_FRONT_DOC = nID_FRONT_DOC;
    }

    public Object getNID_BACK_DOC() {
        return nID_BACK_DOC;
    }

    public void setNID_BACK_DOC(Object nID_BACK_DOC) {
        this.nID_BACK_DOC = nID_BACK_DOC;
    }

    public String getNID_FRONT_URL() {
        return nID_FRONT_URL;
    }

    public void setNID_FRONT_URL(String nID_FRONT_URL) {
        this.nID_FRONT_URL = nID_FRONT_URL;
    }

    public String getNID_BACK_URL() {
        return nID_BACK_URL;
    }

    public void setNID_BACK_URL(String nID_BACK_URL) {
        this.nID_BACK_URL = nID_BACK_URL;
    }

    public Integer getTRAN_ID() {
        return tRAN_ID;
    }

    public void setTRAN_ID(Integer tRAN_ID) {
        this.tRAN_ID = tRAN_ID;
    }

    public String getSET_DATE() {
        return sET_DATE;
    }

    public void setSET_DATE(String sET_DATE) {
        this.sET_DATE = sET_DATE;
    }

    public String getSET_BY() {
        return sET_BY;
    }

    public void setSET_BY(String sET_BY) {
        this.sET_BY = sET_BY;
    }

    public Integer getIS_ACTIVE() {
        return iS_ACTIVE;
    }

    public void setIS_ACTIVE(Integer iS_ACTIVE) {
        this.iS_ACTIVE = iS_ACTIVE;
    }

    public Integer getIS_DELETED() {
        return iS_DELETED;
    }

    public void setIS_DELETED(Integer iS_DELETED) {
        this.iS_DELETED = iS_DELETED;
    }
}
