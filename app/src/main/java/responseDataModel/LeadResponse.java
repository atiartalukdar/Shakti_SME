package responseDataModel;

import java.util.List;

import objectBox.LeadBox;

public class LeadResponse extends BaseResponse {
    private List<LeadBox> Data = null;

    public List<LeadBox> getData() {
        return Data;
    }

    public void setData(List<LeadBox> data) {
        this.Data = data;
    }
}
