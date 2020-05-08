package dataModelNew;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PrescreeningQuestionDM {

    @SerializedName("IsSuccessful")
    @Expose
    private Boolean isSuccessful;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private List<Data> data = null;

    public Boolean getIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }


    public class Data {
        @SerializedName("PRESCREENINGID")
        @Expose
        private Integer pRESCREENINGID;
        @SerializedName("QUESTION")
        @Expose
        private String qUESTION;
        @SerializedName("ORDER_SL")
        @Expose
        private Integer oRDER_SL;
        @SerializedName("ISFIRSTSTEP")
        @Expose
        private Integer iSFIRSTSTEP;
        @SerializedName("MARK")
        @Expose
        private Integer mARK;
        @SerializedName("LOANPROPOSALTYPEID")
        @Expose
        private Integer lOANPROPOSALTYPEID;
        @SerializedName("OPTION1")
        @Expose
        private String oPTION1;
        @SerializedName("OPTION2")
        @Expose
        private String oPTION2;
        @SerializedName("QURRECT_OPTION")
        @Expose
        private String qURRECT_OPTION;
        @SerializedName("LEAD_OPTION_ID")
        @Expose
        private Integer lEAD_OPTION_ID;
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

        public Integer getPRESCREENINGID() {
            return pRESCREENINGID;
        }

        public void setPRESCREENINGID(Integer pRESCREENINGID) {
            this.pRESCREENINGID = pRESCREENINGID;
        }

        public String getQUESTION() {
            return qUESTION;
        }

        public void setQUESTION(String qUESTION) {
            this.qUESTION = qUESTION;
        }

        public Integer getORDER_SL() {
            return oRDER_SL;
        }

        public void setORDER_SL(Integer oRDER_SL) {
            this.oRDER_SL = oRDER_SL;
        }

        public Integer getISFIRSTSTEP() {
            return iSFIRSTSTEP;
        }

        public void setISFIRSTSTEP(Integer iSFIRSTSTEP) {
            this.iSFIRSTSTEP = iSFIRSTSTEP;
        }

        public Integer getMARK() {
            return mARK;
        }

        public void setMARK(Integer mARK) {
            this.mARK = mARK;
        }

        public Integer getLOANPROPOSALTYPEID() {
            return lOANPROPOSALTYPEID;
        }

        public void setLOANPROPOSALTYPEID(Integer lOANPROPOSALTYPEID) {
            this.lOANPROPOSALTYPEID = lOANPROPOSALTYPEID;
        }

        public String getOPTION1() {
            return oPTION1;
        }

        public void setOPTION1(String oPTION1) {
            this.oPTION1 = oPTION1;
        }

        public String getOPTION2() {
            return oPTION2;
        }

        public void setOPTION2(String oPTION2) {
            this.oPTION2 = oPTION2;
        }

        public String getQURRECT_OPTION() {
            return qURRECT_OPTION;
        }

        public void setQURRECT_OPTION(String qURRECT_OPTION) {
            this.qURRECT_OPTION = qURRECT_OPTION;
        }

        public Integer getLEAD_OPTION_ID() {
            return lEAD_OPTION_ID;
        }

        public void setLEAD_OPTION_ID(Integer lEAD_OPTION_ID) {
            this.lEAD_OPTION_ID = lEAD_OPTION_ID;
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
}