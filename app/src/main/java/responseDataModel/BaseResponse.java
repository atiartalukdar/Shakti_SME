package responseDataModel;

public class BaseResponse {
    private Boolean IsSuccessful;
    private String Message;

    public Boolean getIsSuccessful() {
        return IsSuccessful;
    }

    public void setIsSuccessful(Boolean isSuccessful) {
        this.IsSuccessful = isSuccessful;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        this.Message = message;
    }
}
