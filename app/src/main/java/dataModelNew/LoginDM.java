package dataModelNew;

/**
 * Created by Atiar Talukdar on 7/16/2019.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginDM {

    @SerializedName("IsSuccessful")
    @Expose
    private Boolean isSuccessful;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Data {

        @SerializedName("SESSION_ID")
        @Expose
        private String sESSIONID;
        @SerializedName("SESSION_TOKEN")
        @Expose
        private String sESSIONTOKEN;
        @SerializedName("USER_MST_ID")
        @Expose
        private Integer uSERMSTID;
        @SerializedName("USER_ID")
        @Expose
        private String uSERID;
        @SerializedName("NAME")
        @Expose
        private String nAME;
        @SerializedName("POST_NAME")
        @Expose
        private String pOSTNAME;
        @SerializedName("BRANCH_ID")
        @Expose
        private String bRANCHID;
        @SerializedName("USER_ROLE_ID")
        @Expose
        private Integer uSERROLEID;
        @SerializedName("ROLE_NAME")
        @Expose
        private String rOLENAME;
        @SerializedName("ROLE_SHORT_NAME")
        @Expose
        private String rOLESHORTNAME;

        public String getSESSIONID() {
            return sESSIONID;
        }

        public void setSESSIONID(String sESSIONID) {
            this.sESSIONID = sESSIONID;
        }

        public String getSESSIONTOKEN() {
            return sESSIONTOKEN;
        }

        public void setSESSIONTOKEN(String sESSIONTOKEN) {
            this.sESSIONTOKEN = sESSIONTOKEN;
        }

        public Integer getUSERMSTID() {
            return uSERMSTID;
        }

        public void setUSERMSTID(Integer uSERMSTID) {
            this.uSERMSTID = uSERMSTID;
        }

        public String getUSERID() {
            return uSERID;
        }

        public void setUSERID(String uSERID) {
            this.uSERID = uSERID;
        }

        public String getNAME() {
            return nAME;
        }

        public void setNAME(String nAME) {
            this.nAME = nAME;
        }

        public String getPOSTNAME() {
            return pOSTNAME;
        }

        public void setPOSTNAME(String pOSTNAME) {
            this.pOSTNAME = pOSTNAME;
        }

        public String getBRANCHID() {
            return bRANCHID;
        }

        public void setBRANCHID(String bRANCHID) {
            this.bRANCHID = bRANCHID;
        }

        public Integer getUSERROLEID() {
            return uSERROLEID;
        }

        public void setUSERROLEID(Integer uSERROLEID) {
            this.uSERROLEID = uSERROLEID;
        }

        public String getROLENAME() {
            return rOLENAME;
        }

        public void setROLENAME(String rOLENAME) {
            this.rOLENAME = rOLENAME;
        }

        public String getROLESHORTNAME() {
            return rOLESHORTNAME;
        }

        public void setROLESHORTNAME(String rOLESHORTNAME) {
            this.rOLESHORTNAME = rOLESHORTNAME;
        }


        @Override
        public String toString() {
            return "Data{" +
                    "sESSIONID='" + sESSIONID + '\'' +
                    ", sESSIONTOKEN='" + sESSIONTOKEN + '\'' +
                    ", uSERMSTID=" + uSERMSTID +
                    ", uSERID='" + uSERID + '\'' +
                    ", nAME='" + nAME + '\'' +
                    ", pOSTNAME='" + pOSTNAME + '\'' +
                    ", bRANCHID='" + bRANCHID + '\'' +
                    ", uSERROLEID=" + uSERROLEID +
                    ", rOLENAME='" + rOLENAME + '\'' +
                    ", rOLESHORTNAME='" + rOLESHORTNAME + '\'' +
                    '}';
        }
    }

}