package dataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OptionList {

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

        @SerializedName("EDU_NAME")
        @Expose
        private String eDU_NAME;
        @SerializedName("QUALITY_SCORE")
        @Expose
        private Double qUALITY_SCORE;
        @SerializedName("OPTION_GROUP")
        @Expose
        private String oPTION_GROUP;

        public String getEDU_NAME() {
            return eDU_NAME;
        }

        public void setEDU_NAME(String eDU_NAME) {
            this.eDU_NAME = eDU_NAME;
        }

        public Double getQUALITY_SCORE() {
            return qUALITY_SCORE;
        }

        public void setQUALITY_SCORE(Double qUALITY_SCORE) {
            this.qUALITY_SCORE = qUALITY_SCORE;
        }

        public String getOPTION_GROUP() {
            return oPTION_GROUP;
        }

        public void setOPTION_GROUP(String oPTION_GROUP) {
            this.oPTION_GROUP = oPTION_GROUP;
        }
    }

}