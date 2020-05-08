package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanStockOfGoodsBox {
    @Id
    long id;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;
    String APPLICATION_ID;
    String ITEM_NAME;
    String UNIT;
    String PRICE_PER_UNIT;


    public LoanStockOfGoodsBox() {
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

    public String getITEM_NAME() {
        return ITEM_NAME;
    }

    public void setITEM_NAME(String ITEM_NAME) {
        this.ITEM_NAME = ITEM_NAME;
    }

    public String getUNIT() {
        return UNIT;
    }

    public void setUNIT(String UNIT) {
        this.UNIT = UNIT;
    }

    public String getPRICE_PER_UNIT() {
        return PRICE_PER_UNIT;
    }

    public void setPRICE_PER_UNIT(String PRICE_PER_UNIT) {
        this.PRICE_PER_UNIT = PRICE_PER_UNIT;
    }
}
