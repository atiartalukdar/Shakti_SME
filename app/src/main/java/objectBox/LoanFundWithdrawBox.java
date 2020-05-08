package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanFundWithdrawBox {
    @Id
    long id;

    String APPLICATION_ID;
    String EXPENSE;
    String SAVINGS;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;

    public LoanFundWithdrawBox() {
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

    public String getEXPENSE() {
        return EXPENSE;
    }

    public void setEXPENSE(String EXPENSE) {
        this.EXPENSE = EXPENSE;
    }

    public String getSAVINGS() {
        return SAVINGS;
    }

    public void setSAVINGS(String SAVINGS) {
        this.SAVINGS = SAVINGS;
    }
}
