package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanExpenseBasedIncomeBox {
    @Id
    long id;

    String APPLICATION_ID;
    String HOUSE_MAINTENANCE_COST;
    String AVG_DEV_COST;
    String AVG_UTILITY_COST;
    String AVG_TAX;
    String OTHER;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;

    public LoanExpenseBasedIncomeBox() {
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

    public String getHOUSE_MAINTENANCE_COST() {
        return HOUSE_MAINTENANCE_COST;
    }

    public void setHOUSE_MAINTENANCE_COST(String HOUSE_MAINTENANCE_COST) {
        this.HOUSE_MAINTENANCE_COST = HOUSE_MAINTENANCE_COST;
    }

    public String getAVG_DEV_COST() {
        return AVG_DEV_COST;
    }

    public void setAVG_DEV_COST(String AVG_DEV_COST) {
        this.AVG_DEV_COST = AVG_DEV_COST;
    }

    public String getAVG_UTILITY_COST() {
        return AVG_UTILITY_COST;
    }

    public void setAVG_UTILITY_COST(String AVG_UTILITY_COST) {
        this.AVG_UTILITY_COST = AVG_UTILITY_COST;
    }

    public String getAVG_TAX() {
        return AVG_TAX;
    }

    public void setAVG_TAX(String AVG_TAX) {
        this.AVG_TAX = AVG_TAX;
    }

    public String getOTHER() {
        return OTHER;
    }

    public void setOTHER(String OTHER) {
        this.OTHER = OTHER;
    }
}
