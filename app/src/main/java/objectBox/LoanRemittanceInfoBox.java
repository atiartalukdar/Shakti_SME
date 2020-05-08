package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanRemittanceInfoBox {
    @Id
    long id;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;
    String APPLICATION_ID;
    String NRB_NAME;
    String RELATION_WITH_APPLICANT;
    String REMITTANCE_AMOUNT;
    String REMITTANCE_RECEIVER_NAME;
    String COUNTRY_CODE;
    String DAYS_IN_NRB;
    String IS_VALID_VISA_PERMIT;
    String VISA_WORK_PERMIT_DOC;
    String VISA_WORK_PERMIT_URL;
    String VISA_EXPIRY_DATE;
    String WORK_PERMIT_EXPIRY_DATE;
    String ORG_NAME_IN_NRB;
    String NRB_PASSPORT;
    String REMITTANCE_SLIP_DOC;
    String REMITTANCE_SLIP_URL;

    public LoanRemittanceInfoBox() {
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

    public String getNRB_NAME() {
        return NRB_NAME;
    }

    public void setNRB_NAME(String NRB_NAME) {
        this.NRB_NAME = NRB_NAME;
    }

    public String getRELATION_WITH_APPLICANT() {
        return RELATION_WITH_APPLICANT;
    }

    public void setRELATION_WITH_APPLICANT(String RELATION_WITH_APPLICANT) {
        this.RELATION_WITH_APPLICANT = RELATION_WITH_APPLICANT;
    }

    public String getREMITTANCE_AMOUNT() {
        return REMITTANCE_AMOUNT;
    }

    public void setREMITTANCE_AMOUNT(String REMITTANCE_AMOUNT) {
        this.REMITTANCE_AMOUNT = REMITTANCE_AMOUNT;
    }

    public String getREMITTANCE_RECEIVER_NAME() {
        return REMITTANCE_RECEIVER_NAME;
    }

    public void setREMITTANCE_RECEIVER_NAME(String REMITTANCE_RECEIVER_NAME) {
        this.REMITTANCE_RECEIVER_NAME = REMITTANCE_RECEIVER_NAME;
    }

    public String getCOUNTRY_CODE() {
        return COUNTRY_CODE;
    }

    public void setCOUNTRY_CODE(String COUNTRY_CODE) {
        this.COUNTRY_CODE = COUNTRY_CODE;
    }

    public String getDAYS_IN_NRB() {
        return DAYS_IN_NRB;
    }

    public void setDAYS_IN_NRB(String DAYS_IN_NRB) {
        this.DAYS_IN_NRB = DAYS_IN_NRB;
    }

    public String getIS_VALID_VISA_PERMIT() {
        return IS_VALID_VISA_PERMIT;
    }

    public void setIS_VALID_VISA_PERMIT(String IS_VALID_VISA_PERMIT) {
        this.IS_VALID_VISA_PERMIT = IS_VALID_VISA_PERMIT;
    }

    public String getVISA_WORK_PERMIT_DOC() {
        return VISA_WORK_PERMIT_DOC;
    }

    public void setVISA_WORK_PERMIT_DOC(String VISA_WORK_PERMIT_DOC) {
        this.VISA_WORK_PERMIT_DOC = VISA_WORK_PERMIT_DOC;
    }

    public String getVISA_EXPIRY_DATE() {
        return VISA_EXPIRY_DATE;
    }

    public void setVISA_EXPIRY_DATE(String VISA_EXPIRY_DATE) {
        this.VISA_EXPIRY_DATE = VISA_EXPIRY_DATE;
    }

    public String getWORK_PERMIT_EXPIRY_DATE() {
        return WORK_PERMIT_EXPIRY_DATE;
    }

    public void setWORK_PERMIT_EXPIRY_DATE(String WORK_PERMIT_EXPIRY_DATE) {
        this.WORK_PERMIT_EXPIRY_DATE = WORK_PERMIT_EXPIRY_DATE;
    }

    public String getORG_NAME_IN_NRB() {
        return ORG_NAME_IN_NRB;
    }

    public void setORG_NAME_IN_NRB(String ORG_NAME_IN_NRB) {
        this.ORG_NAME_IN_NRB = ORG_NAME_IN_NRB;
    }

    public String getNRB_PASSPORT() {
        return NRB_PASSPORT;
    }

    public void setNRB_PASSPORT(String NRB_PASSPORT) {
        this.NRB_PASSPORT = NRB_PASSPORT;
    }

    public String getREMITTANCE_SLIP_DOC() {
        return REMITTANCE_SLIP_DOC;
    }

    public void setREMITTANCE_SLIP_DOC(String REMITTANCE_SLIP_DOC) {
        this.REMITTANCE_SLIP_DOC = REMITTANCE_SLIP_DOC;
    }

    public String getVISA_WORK_PERMIT_URL() {
        return VISA_WORK_PERMIT_URL;
    }

    public void setVISA_WORK_PERMIT_URL(String VISA_WORK_PERMIT_URL) {
        this.VISA_WORK_PERMIT_URL = VISA_WORK_PERMIT_URL;
    }

    public String getREMITTANCE_SLIP_URL() {
        return REMITTANCE_SLIP_URL;
    }

    public void setREMITTANCE_SLIP_URL(String REMITTANCE_SLIP_URL) {
        this.REMITTANCE_SLIP_URL = REMITTANCE_SLIP_URL;
    }
}
