package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanExpenseAgroBox {
    @Id
    long id;

    String APPLICATION_ID;
    String CATTLE_FEED_COST;
    String VETERINARY_COST;
    String SALARY_PAID;
    String LIVESTOCK_PURCHASE;
    String DAIRY_PRODUCTION_COST;
    String OTHER_COST;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;
    public LoanExpenseAgroBox() {
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

    public String getCATTLE_FEED_COST() {
        return CATTLE_FEED_COST;
    }

    public void setCATTLE_FEED_COST(String CATTLE_FEED_COST) {
        this.CATTLE_FEED_COST = CATTLE_FEED_COST;
    }

    public String getVETERINARY_COST() {
        return VETERINARY_COST;
    }

    public void setVETERINARY_COST(String VETERINARY_COST) {
        this.VETERINARY_COST = VETERINARY_COST;
    }

    public String getSALARY_PAID() {
        return SALARY_PAID;
    }

    public void setSALARY_PAID(String SALARY_PAID) {
        this.SALARY_PAID = SALARY_PAID;
    }

    public String getLIVESTOCK_PURCHASE() {
        return LIVESTOCK_PURCHASE;
    }

    public void setLIVESTOCK_PURCHASE(String LIVESTOCK_PURCHASE) {
        this.LIVESTOCK_PURCHASE = LIVESTOCK_PURCHASE;
    }

    public String getDAIRY_PRODUCTION_COST() {
        return DAIRY_PRODUCTION_COST;
    }

    public void setDAIRY_PRODUCTION_COST(String DAIRY_PRODUCTION_COST) {
        this.DAIRY_PRODUCTION_COST = DAIRY_PRODUCTION_COST;
    }

    public String getOTHER_COST() {
        return OTHER_COST;
    }

    public void setOTHER_COST(String OTHER_COST) {
        this.OTHER_COST = OTHER_COST;
    }
}
