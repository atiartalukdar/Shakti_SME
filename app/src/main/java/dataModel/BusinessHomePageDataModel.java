package dataModel;

public class BusinessHomePageDataModel {
    Integer drawableID;
    String itemName;

    public BusinessHomePageDataModel(Integer drawableID, String itemName) {
        this.drawableID = drawableID;
        this.itemName = itemName;
    }

    public Integer getDrawableID() {
        return drawableID;
    }

    public void setDrawableID(Integer drawableID) {
        this.drawableID = drawableID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
