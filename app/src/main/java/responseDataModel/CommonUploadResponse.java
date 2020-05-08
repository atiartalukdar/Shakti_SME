package responseDataModel;

public class CommonUploadResponse extends BaseResponse{
    private Object Data;

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        this.Data = data;
    }

    @Override
    public String toString() {
        return "CommonUploadResponse{" +
                "Data=" + Data +
                '}';
    }
}
