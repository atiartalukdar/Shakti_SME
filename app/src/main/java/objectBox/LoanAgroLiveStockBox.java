package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanAgroLiveStockBox {

    @Id
            long id;
    String APPLICATION_ID;
    String COW_SHED_COST;
    String NO_OF_COWS;
    String COW_PRICE;
    String NO_OF_CALVES;
    String CALVES_PRICE;
    String NO_OF_CATTLE;
    String CATTLE_PRICE;
    String MEMBER_ID;
    String BRANCH_ID;
    String CENTER_ID;

    public LoanAgroLiveStockBox() {
    }

    public String getMEMBER_ID() {
        return MEMBER_ID;
    }

    public void setMEMBER_ID(String MEMBER_ID) {
        this.MEMBER_ID = MEMBER_ID;
    }

    public String getBRANCH_ID() {
        return BRANCH_ID;
    }

    public void setBRANCH_ID(String BRANCH_ID) {
        this.BRANCH_ID = BRANCH_ID;
    }

    public String getCENTER_ID() {
        return CENTER_ID;
    }

    public void setCENTER_ID(String CENTER_ID) {
        this.CENTER_ID = CENTER_ID;
    }

    public String getAPPLICATION_ID() {
        return APPLICATION_ID;
    }

    public void setAPPLICATION_ID(String APPLICATION_ID) {
        this.APPLICATION_ID = APPLICATION_ID;
    }

    public String getCOW_SHED_COST() {
        return COW_SHED_COST;
    }

    public void setCOW_SHED_COST(String COW_SHED_COST) {
        this.COW_SHED_COST = COW_SHED_COST;
    }

    public String getNO_OF_COWS() {
        return NO_OF_COWS;
    }

    public void setNO_OF_COWS(String NO_OF_COWS) {
        this.NO_OF_COWS = NO_OF_COWS;
    }

    public String getCOW_PRICE() {
        return COW_PRICE;
    }

    public void setCOW_PRICE(String COW_PRICE) {
        this.COW_PRICE = COW_PRICE;
    }

    public String getNO_OF_CALVES() {
        return NO_OF_CALVES;
    }

    public void setNO_OF_CALVES(String NO_OF_CALVES) {
        this.NO_OF_CALVES = NO_OF_CALVES;
    }

    public String getCALVES_PRICE() {
        return CALVES_PRICE;
    }

    public void setCALVES_PRICE(String CALVES_PRICE) {
        this.CALVES_PRICE = CALVES_PRICE;
    }

    public String getNO_OF_CATTLE() {
        return NO_OF_CATTLE;
    }

    public void setNO_OF_CATTLE(String NO_OF_CATTLE) {
        this.NO_OF_CATTLE = NO_OF_CATTLE;
    }

    public String getCATTLE_PRICE() {
        return CATTLE_PRICE;
    }

    public void setCATTLE_PRICE(String CATTLE_PRICE) {
        this.CATTLE_PRICE = CATTLE_PRICE;
    }
}
