package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanPropertyValueBox {
    @Id
    long id;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;
    String APPLICATION_ID;
    String CURRENT_VAL;
    String OUTSTANDING_RENT;
    String VAL_OF_FURNITURES;
    String VAL_OF_OTHERS;
    String VAL_OF_MACHINARIES;
    String PROPERTY_DEV_COST;
    String HOUSE_TYPE;
    String NO_OF_STORY;

    public LoanPropertyValueBox() {
    }

    public String getMEMBER_ID() {
        return MEMBER_ID;
    }

    public void setMEMBER_ID(String MEMBER_ID) {
        this.MEMBER_ID = MEMBER_ID;
    }

    public String getCENTER_ID() {
        return CENTER_ID;
    }

    public void setCENTER_ID(String CENTER_ID) {
        this.CENTER_ID = CENTER_ID;
    }

    public String getBRANCH_ID() {
        return BRANCH_ID;
    }

    public void setBRANCH_ID(String BRANCH_ID) {
        this.BRANCH_ID = BRANCH_ID;
    }

    public String getAPPLICATION_ID() {
        return APPLICATION_ID;
    }

    public void setAPPLICATION_ID(String APPLICATION_ID) {
        this.APPLICATION_ID = APPLICATION_ID;
    }

    public String getCURRENT_VAL() {
        return CURRENT_VAL;
    }

    public void setCURRENT_VAL(String CURRENT_VAL) {
        this.CURRENT_VAL = CURRENT_VAL;
    }

    public String getOUTSTANDING_RENT() {
        return OUTSTANDING_RENT;
    }

    public void setOUTSTANDING_RENT(String OUTSTANDING_RENT) {
        this.OUTSTANDING_RENT = OUTSTANDING_RENT;
    }

    public String getVAL_OF_FURNITURES() {
        return VAL_OF_FURNITURES;
    }

    public void setVAL_OF_FURNITURES(String VAL_OF_FURNITURES) {
        this.VAL_OF_FURNITURES = VAL_OF_FURNITURES;
    }

    public String getVAL_OF_OTHERS() {
        return VAL_OF_OTHERS;
    }

    public void setVAL_OF_OTHERS(String VAL_OF_OTHERS) {
        this.VAL_OF_OTHERS = VAL_OF_OTHERS;
    }

    public String getVAL_OF_MACHINARIES() {
        return VAL_OF_MACHINARIES;
    }

    public void setVAL_OF_MACHINARIES(String VAL_OF_MACHINARIES) {
        this.VAL_OF_MACHINARIES = VAL_OF_MACHINARIES;
    }

    public String getPROPERTY_DEV_COST() {
        return PROPERTY_DEV_COST;
    }

    public void setPROPERTY_DEV_COST(String PROPERTY_DEV_COST) {
        this.PROPERTY_DEV_COST = PROPERTY_DEV_COST;
    }

    public String getHOUSE_TYPE() {
        return HOUSE_TYPE;
    }

    public void setHOUSE_TYPE(String HOUSE_TYPE) {
        this.HOUSE_TYPE = HOUSE_TYPE;
    }

    public String getNO_OF_STORY() {
        return NO_OF_STORY;
    }

    public void setNO_OF_STORY(String NO_OF_STORY) {
        this.NO_OF_STORY = NO_OF_STORY;
    }
}
