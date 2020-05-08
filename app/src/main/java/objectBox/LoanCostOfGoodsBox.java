package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanCostOfGoodsBox {
    @Id
    long id;

    String APPLICATION_ID;
    String MAX_COST;
    String GOOD_MONTHS;
    String MIN_COST;
    String BAD_MONTHS;
    String AVERAGE_COST;
    String AVERAGE_MONTHS;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;

    public LoanCostOfGoodsBox() {
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

    public String getMAX_COST() {
        return MAX_COST;
    }

    public void setMAX_COST(String MAX_COST) {
        this.MAX_COST = MAX_COST;
    }

    public String getGOOD_MONTHS() {
        return GOOD_MONTHS;
    }

    public void setGOOD_MONTHS(String GOOD_MONTHS) {
        this.GOOD_MONTHS = GOOD_MONTHS;
    }

    public String getMIN_COST() {
        return MIN_COST;
    }

    public void setMIN_COST(String MIN_COST) {
        this.MIN_COST = MIN_COST;
    }

    public String getBAD_MONTHS() {
        return BAD_MONTHS;
    }

    public void setBAD_MONTHS(String BAD_MONTHS) {
        this.BAD_MONTHS = BAD_MONTHS;
    }

    public String getAVERAGE_COST() {
        return AVERAGE_COST;
    }

    public void setAVERAGE_COST(String AVERAGE_COST) {
        this.AVERAGE_COST = AVERAGE_COST;
    }

    public String getAVERAGE_MONTHS() {
        return AVERAGE_MONTHS;
    }

    public void setAVERAGE_MONTHS(String AVERAGE_MONTHS) {
        this.AVERAGE_MONTHS = AVERAGE_MONTHS;
    }
}
