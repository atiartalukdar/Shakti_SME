package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanEquipmentValueBox {
    @Id
    long id;

    String APPLICATION_ID;

    String EQUIPMENT_NAME;
    String YEARS_IN_SERVICE;
    String LIFE_REMAINING;
    String REPLACEMENT_COST;

    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;

    public LoanEquipmentValueBox() {
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

    public String getEQUIPMENT_NAME() {
        return EQUIPMENT_NAME;
    }

    public void setEQUIPMENT_NAME(String EQUIPMENT_NAME) {
        this.EQUIPMENT_NAME = EQUIPMENT_NAME;
    }

    public String getYEARS_IN_SERVICE() {
        return YEARS_IN_SERVICE;
    }

    public void setYEARS_IN_SERVICE(String YEARS_IN_SERVICE) {
        this.YEARS_IN_SERVICE = YEARS_IN_SERVICE;
    }

    public String getLIFE_REMAINING() {
        return LIFE_REMAINING;
    }

    public void setLIFE_REMAINING(String LIFE_REMAINING) {
        this.LIFE_REMAINING = LIFE_REMAINING;
    }

    public String getREPLACEMENT_COST() {
        return REPLACEMENT_COST;
    }

    public void setREPLACEMENT_COST(String REPLACEMENT_COST) {
        this.REPLACEMENT_COST = REPLACEMENT_COST;
    }
}
