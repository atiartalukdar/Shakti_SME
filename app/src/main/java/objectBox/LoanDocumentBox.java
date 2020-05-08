package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanDocumentBox {
    @Id
    long id;

    String APPLICATION_ID;
    String DOC_URL;
    int DOC_TYPE_ID;
    String DOC_NAME;
    String DOC;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;

    public LoanDocumentBox() {
    }

    public String getAPPLICATION_ID() {
        return APPLICATION_ID;
    }

    public void setAPPLICATION_ID(String APPLICATION_ID) {
        this.APPLICATION_ID = APPLICATION_ID;
    }

    public String getDOC_URL() {
        return DOC_URL;
    }

    public void setDOC_URL(String DOC_URL) {
        this.DOC_URL = DOC_URL;
    }

    public int getDOC_TYPE_ID() {
        return DOC_TYPE_ID;
    }

    public void setDOC_TYPE_ID(int DOC_TYPE_ID) {
        this.DOC_TYPE_ID = DOC_TYPE_ID;
    }

    public String getDOC_NAME() {
        return DOC_NAME;
    }

    public void setDOC_NAME(String DOC_NAME) {
        this.DOC_NAME = DOC_NAME;
    }

    public String getDOC() {
        return DOC;
    }

    public void setDOC(String DOC) {
        this.DOC = DOC;
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
}
