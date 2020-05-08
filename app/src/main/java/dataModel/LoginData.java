package dataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {

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

        @SerializedName("user_status")
        @Expose
        private String userStatus;
        @SerializedName("user_name")
        @Expose
        private String userName;
        @SerializedName("post_name")
        @Expose
        private String postName;
        @SerializedName("branch_id")
        @Expose
        private String branchId;
        @SerializedName("user_branch_name")
        @Expose
        private String userBranchName;
        @SerializedName("user_role_id")
        @Expose
        private String userRoleId;
        @SerializedName("role_name")
        @Expose
        private String roleName;

        public String getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(String userStatus) {
            this.userStatus = userStatus;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPostName() {
            return postName;
        }

        public void setPostName(String postName) {
            this.postName = postName;
        }

        public String getBranchId() {
            return branchId;
        }

        public void setBranchId(String branchId) {
            this.branchId = branchId;
        }

        public String getUserBranchName() {
            return userBranchName;
        }

        public void setUserBranchName(String userBranchName) {
            this.userBranchName = userBranchName;
        }

        public String getUserRoleId() {
            return userRoleId;
        }

        public void setUserRoleId(String userRoleId) {
            this.userRoleId = userRoleId;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "userStatus='" + userStatus + '\'' +
                    ", userName='" + userName + '\'' +
                    ", postName='" + postName + '\'' +
                    ", branchId='" + branchId + '\'' +
                    ", userBranchName='" + userBranchName + '\'' +
                    ", userRoleId='" + userRoleId + '\'' +
                    ", roleName='" + roleName + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "success=" + success +
                ", accessToken='" + accessToken + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}