package dataModel;

public class LoginDataToSend {
    String user_id, access_token, branch_id, latitude, longitude, address, dev_imei, dev_phone, app_version;

    public LoginDataToSend() {
    }

    public LoginDataToSend(String user_id, String access_token, String branch_id, String latitude, String longitude, String address, String dev_imei, String dev_phone, String app_version) {
        this.user_id = user_id;
        this.access_token = access_token;
        this.branch_id = branch_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.dev_imei = dev_imei;
        this.dev_phone = dev_phone;
        this.app_version = app_version;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDev_imei() {
        return dev_imei;
    }

    public void setDev_imei(String dev_imei) {
        this.dev_imei = dev_imei;
    }

    public String getDev_phone() {
        return dev_phone;
    }

    public void setDev_phone(String dev_phone) {
        this.dev_phone = dev_phone;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }


    @Override
    public String toString() {
        return "LoginDataToSend{" +
                "user_id='" + user_id + '\'' +
                ", access_token='" + access_token + '\'' +
                ", branch_id='" + branch_id + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", address='" + address + '\'' +
                ", dev_imei='" + dev_imei + '\'' +
                ", dev_phone='" + dev_phone + '\'' +
                ", app_version='" + app_version + '\'' +
                '}';
    }
}
