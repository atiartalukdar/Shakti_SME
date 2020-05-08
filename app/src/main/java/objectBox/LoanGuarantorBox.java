package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanGuarantorBox {
    @Id
    long id;

    String APPLICATION_ID;
    String G_NID;
    String G_NAME;
    String OCCUPATION;
    String NAMEOF_BANK;
    String ACCOUNT_NO;
    String MONTHLY_INCOME;
    String HOME_ADDRESS;
    String BUSINESS_ADDRESS;
    String MOBILE_NO;
    String G_TYPE;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;

    public LoanGuarantorBox() {
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

    public String getG_NID() {
        return G_NID;
    }

    public void setG_NID(String g_NID) {
        G_NID = g_NID;
    }

    public String getG_NAME() {
        return G_NAME;
    }

    public void setG_NAME(String g_NAME) {
        G_NAME = g_NAME;
    }

    public String getOCCUPATION() {
        return OCCUPATION;
    }

    public void setOCCUPATION(String OCCUPATION) {
        this.OCCUPATION = OCCUPATION;
    }

    public String getNAMEOF_BANK() {
        return NAMEOF_BANK;
    }

    public void setNAMEOF_BANK(String NAMEOF_BANK) {
        this.NAMEOF_BANK = NAMEOF_BANK;
    }

    public String getACCOUNT_NO() {
        return ACCOUNT_NO;
    }

    public void setACCOUNT_NO(String ACCOUNT_NO) {
        this.ACCOUNT_NO = ACCOUNT_NO;
    }

    public String getMONTHLY_INCOME() {
        return MONTHLY_INCOME;
    }

    public void setMONTHLY_INCOME(String MONTHLY_INCOME) {
        this.MONTHLY_INCOME = MONTHLY_INCOME;
    }

    public String getHOME_ADDRESS() {
        return HOME_ADDRESS;
    }

    public void setHOME_ADDRESS(String HOME_ADDRESS) {
        this.HOME_ADDRESS = HOME_ADDRESS;
    }

    public String getBUSINESS_ADDRESS() {
        return BUSINESS_ADDRESS;
    }

    public void setBUSINESS_ADDRESS(String BUSINESS_ADDRESS) {
        this.BUSINESS_ADDRESS = BUSINESS_ADDRESS;
    }

    public String getMOBILE_NO() {
        return MOBILE_NO;
    }

    public void setMOBILE_NO(String MOBILE_NO) {
        this.MOBILE_NO = MOBILE_NO;
    }

    public String getG_TYPE() {
        return G_TYPE;
    }

    public void setG_TYPE(String g_TYPE) {
        G_TYPE = g_TYPE;
    }
}
