package dataModelNew;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Atiar Talukdar on 8/3/2019.
 */
public class BranchNameDM {
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

        @SerializedName("BBID")
        @Expose
        private Integer bBID;
        @SerializedName("BANKBRANCHNAME")
        @Expose
        private String bANKBRANCHNAME;
        @SerializedName("ROUTINGNUMBER")
        @Expose
        private String rOUTINGNUMBER;
        @SerializedName("BANKCODE")
        @Expose
        private String bANKCODE;

        public Integer getBBID() {
            return bBID;
        }

        public void setBBID(Integer bBID) {
            this.bBID = bBID;
        }

        public String getBANKBRANCHNAME() {
            return bANKBRANCHNAME;
        }

        public void setBANKBRANCHNAME(String bANKBRANCHNAME) {
            this.bANKBRANCHNAME = bANKBRANCHNAME;
        }

        public String getROUTINGNUMBER() {
            return rOUTINGNUMBER;
        }

        public void setROUTINGNUMBER(String rOUTINGNUMBER) {
            this.rOUTINGNUMBER = rOUTINGNUMBER;
        }

        public String getBANKCODE() {
            return bANKCODE;
        }

        public void setBANKCODE(String bANKCODE) {
            this.bANKCODE = bANKCODE;
        }

        @Override
        public String toString() {
            return bANKBRANCHNAME;
        }
    }

}
