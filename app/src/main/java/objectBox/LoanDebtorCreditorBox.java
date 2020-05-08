package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanDebtorCreditorBox {
    @Id
    long id;

    String APPLICATION_ID;
    String OWED_BY_DEBITORS;
    String OWED_BY_DEBITORS_PRCT;
    String OWED_TO_CREDITORS;
    String OWED_TO_CREDITORS_PRCT;

    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;

    public LoanDebtorCreditorBox() {
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

    public String getOWED_BY_DEBITORS() {
        return OWED_BY_DEBITORS;
    }

    public void setOWED_BY_DEBITORS(String OWED_BY_DEBITORS) {
        this.OWED_BY_DEBITORS = OWED_BY_DEBITORS;
    }

    public String getOWED_BY_DEBITORS_PRCT() {
        return OWED_BY_DEBITORS_PRCT;
    }

    public void setOWED_BY_DEBITORS_PRCT(String OWED_BY_DEBITORS_PRCT) {
        this.OWED_BY_DEBITORS_PRCT = OWED_BY_DEBITORS_PRCT;
    }

    public String getOWED_TO_CREDITORS() {
        return OWED_TO_CREDITORS;
    }

    public void setOWED_TO_CREDITORS(String OWED_TO_CREDITORS) {
        this.OWED_TO_CREDITORS = OWED_TO_CREDITORS;
    }

    public String getOWED_TO_CREDITORS_PRCT() {
        return OWED_TO_CREDITORS_PRCT;
    }

    public void setOWED_TO_CREDITORS_PRCT(String OWED_TO_CREDITORS_PRCT) {
        this.OWED_TO_CREDITORS_PRCT = OWED_TO_CREDITORS_PRCT;
    }
}
