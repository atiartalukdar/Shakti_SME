package dataModelNew;

/**
 * Created by Atiar Talukdar on 7/21/2019.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeadOptionDM {
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

        @SerializedName("LEADOPTIONID")
        @Expose
        private Integer lEADOPTIONID;
        @SerializedName("OPTIONNAMEEN")
        @Expose
        private String oPTIONNAMEEN;
        @SerializedName("OPTIONNAMEBN")
        @Expose
        private String oPTIONNAMEBN;
        @SerializedName("LOANPROPOSALTYPEID")
        @Expose
        private Integer lOANPROPOSALTYPEID;
        @SerializedName("PASS_SCORE")
        @Expose
        private Double pASS_SCORE;
        @SerializedName("LOAN_MAX")
        @Expose
        private Double lOAN_MAX;
        @SerializedName("LOAN_MIN")
        @Expose
        private Double lOAN_MIN;
        @SerializedName("LOAN_ROUND_AMOUNT")
        @Expose
        private Double lOAN_ROUND_AMOUNT;
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

        public Integer getLEADOPTIONID() {
            return lEADOPTIONID;
        }

        public void setLEADOPTIONID(Integer lEADOPTIONID) {
            this.lEADOPTIONID = lEADOPTIONID;
        }

        public String getOPTIONNAMEEN() {
            return oPTIONNAMEEN;
        }

        public void setOPTIONNAMEEN(String oPTIONNAMEEN) {
            this.oPTIONNAMEEN = oPTIONNAMEEN;
        }

        public String getOPTIONNAMEBN() {
            return oPTIONNAMEBN;
        }

        public void setOPTIONNAMEBN(String oPTIONNAMEBN) {
            this.oPTIONNAMEBN = oPTIONNAMEBN;
        }

        public Integer getLOANPROPOSALTYPEID() {
            return lOANPROPOSALTYPEID;
        }

        public void setLOANPROPOSALTYPEID(Integer lOANPROPOSALTYPEID) {
            this.lOANPROPOSALTYPEID = lOANPROPOSALTYPEID;
        }

        public Double getPASS_SCORE() {
            return pASS_SCORE;
        }

        public void setPASS_SCORE(Double pASS_SCORE) {
            this.pASS_SCORE = pASS_SCORE;
        }

        public Double getLOAN_MAX() {
            return lOAN_MAX;
        }

        public void setLOAN_MAX(Double lOAN_MAX) {
            this.lOAN_MAX = lOAN_MAX;
        }

        public Double getLOAN_MIN() {
            return lOAN_MIN;
        }

        public void setLOAN_MIN(Double lOAN_MIN) {
            this.lOAN_MIN = lOAN_MIN;
        }

        public Double getLOAN_ROUND_AMOUNT() {
            return lOAN_ROUND_AMOUNT;
        }

        public void setLOAN_ROUND_AMOUNT(Double lOAN_ROUND_AMOUNT) {
            this.lOAN_ROUND_AMOUNT = lOAN_ROUND_AMOUNT;
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