package dataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NextLeadID {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("data")
    @Expose
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }






    public class Data {

        @SerializedName("max_id")
        @Expose
        private Integer maxId;

        public Integer getMaxId() {
            return maxId;
        }

        public void setMaxId(Integer maxId) {
            this.maxId = maxId;
        }

    }



}
