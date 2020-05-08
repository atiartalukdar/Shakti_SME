package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanCurrentLoanBox {
@Id
    long id;

    String APPLICATION_ID;
    String MONTHLY_INSTALLMENT;
    String IS_DUE_WITHNEW;
    String LOAN_NAME;

    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;

    public LoanCurrentLoanBox() {
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

    public String getMONTHLY_INSTALLMENT() {
        return MONTHLY_INSTALLMENT;
    }

    public void setMONTHLY_INSTALLMENT(String MONTHLY_INSTALLMENT) {
        this.MONTHLY_INSTALLMENT = MONTHLY_INSTALLMENT;
    }

    public String getIS_DUE_WITHNEW() {
        return IS_DUE_WITHNEW;
    }

    public void setIS_DUE_WITHNEW(String IS_DUE_WITHNEW) {
        this.IS_DUE_WITHNEW = IS_DUE_WITHNEW;
    }

    public String getLOAN_NAME() {
        return LOAN_NAME;
    }

    public void setLOAN_NAME(String LOAN_NAME) {
        this.LOAN_NAME = LOAN_NAME;
    }
}

