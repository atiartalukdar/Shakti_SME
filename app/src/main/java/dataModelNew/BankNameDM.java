package dataModelNew;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Atiar Talukdar on 8/3/2019.
 */
public class BankNameDM {

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

        @SerializedName("BANKCODE")
        @Expose
        private String bANKCODE;
        @SerializedName("BANKNAME")
        @Expose
        private String bANKNAME;

        public String getBANKCODE() {
            return bANKCODE;
        }

        public void setBANKCODE(String bANKCODE) {
            this.bANKCODE = bANKCODE;
        }

        public String getBANKNAME() {
            return bANKNAME;
        }

        public void setBANKNAME(String bANKNAME) {
            this.bANKNAME = bANKNAME;
        }

        @Override
        public String toString() {
            return bANKNAME;
        }
    }
}
