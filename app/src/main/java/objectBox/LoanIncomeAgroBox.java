package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanIncomeAgroBox {
    @Id
    long id;

    String APPLICATION_ID;
    String MILK_PRODUCTION;
    String AVG_MILK_SALE;
    String DAIRY_PRODUCT_SALE;
    String LIVE_STOCK_SALE;
    String OTHER_INCOME;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;


    public LoanIncomeAgroBox() {
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

    public String getMILK_PRODUCTION() {
        return MILK_PRODUCTION;
    }

    public void setMILK_PRODUCTION(String MILK_PRODUCTION) {
        this.MILK_PRODUCTION = MILK_PRODUCTION;
    }

    public String getAVG_MILK_SALE() {
        return AVG_MILK_SALE;
    }

    public void setAVG_MILK_SALE(String AVG_MILK_SALE) {
        this.AVG_MILK_SALE = AVG_MILK_SALE;
    }

    public String getDAIRY_PRODUCT_SALE() {
        return DAIRY_PRODUCT_SALE;
    }

    public void setDAIRY_PRODUCT_SALE(String DAIRY_PRODUCT_SALE) {
        this.DAIRY_PRODUCT_SALE = DAIRY_PRODUCT_SALE;
    }

    public String getLIVE_STOCK_SALE() {
        return LIVE_STOCK_SALE;
    }

    public void setLIVE_STOCK_SALE(String LIVE_STOCK_SALE) {
        this.LIVE_STOCK_SALE = LIVE_STOCK_SALE;
    }

    public String getOTHER_INCOME() {
        return OTHER_INCOME;
    }

    public void setOTHER_INCOME(String OTHER_INCOME) {
        this.OTHER_INCOME = OTHER_INCOME;
    }
}
