package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanBankAccountBox {
    @Id
    long id;
    String APPLICATION_ID;
    String ACCOUNT_NO;
    String ACCOUNT_NAME;
    String BANK_CODE;
    String BANK_BRANCH_ID;
    String ROUTING_NO;
    String ACCOUNT_TYPE;
    String MOBILE_ACC_NO;
    String BRANCH_ADDRESS;
    String CHEQUE_BOOK_LEAF_DOC;
    String CHEQUE_BOOK_LEAF_URL;
    String CASH_IN_HAND;
    String CASH_AT_BANK;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;

    public LoanBankAccountBox() {
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

    public String getACCOUNT_NO() {
        return ACCOUNT_NO;
    }

    public void setACCOUNT_NO(String ACCOUNT_NO) {
        this.ACCOUNT_NO = ACCOUNT_NO;
    }

    public String getACCOUNT_NAME() {
        return ACCOUNT_NAME;
    }

    public void setACCOUNT_NAME(String ACCOUNT_NAME) {
        this.ACCOUNT_NAME = ACCOUNT_NAME;
    }

    public String getBANK_CODE() {
        return BANK_CODE;
    }

    public void setBANK_CODE(String BANK_CODE) {
        this.BANK_CODE = BANK_CODE;
    }

    public String getBANK_BRANCH_ID() {
        return BANK_BRANCH_ID;
    }

    public void setBANK_BRANCH_ID(String BANK_BRANCH_ID) {
        this.BANK_BRANCH_ID = BANK_BRANCH_ID;
    }

    public String getROUTING_NO() {
        return ROUTING_NO;
    }

    public void setROUTING_NO(String ROUTING_NO) {
        this.ROUTING_NO = ROUTING_NO;
    }

    public String getACCOUNT_TYPE() {
        return ACCOUNT_TYPE;
    }

    public void setACCOUNT_TYPE(String ACCOUNT_TYPE) {
        this.ACCOUNT_TYPE = ACCOUNT_TYPE;
    }

    public String getMOBILE_ACC_NO() {
        return MOBILE_ACC_NO;
    }

    public void setMOBILE_ACC_NO(String MOBILE_ACC_NO) {
        this.MOBILE_ACC_NO = MOBILE_ACC_NO;
    }

    public String getBRANCH_ADDRESS() {
        return BRANCH_ADDRESS;
    }

    public void setBRANCH_ADDRESS(String BRANCH_ADDRESS) {
        this.BRANCH_ADDRESS = BRANCH_ADDRESS;
    }

    public String getCHEQUE_BOOK_LEAF_DOC() {
        return CHEQUE_BOOK_LEAF_DOC;
    }

    public void setCHEQUE_BOOK_LEAF_DOC(String CHEQUE_BOOK_LEAF_DOC) {
        this.CHEQUE_BOOK_LEAF_DOC = CHEQUE_BOOK_LEAF_DOC;
    }

    public String getCASH_IN_HAND() {
        return CASH_IN_HAND;
    }

    public void setCASH_IN_HAND(String CASH_IN_HAND) {
        this.CASH_IN_HAND = CASH_IN_HAND;
    }

    public String getCASH_AT_BANK() {
        return CASH_AT_BANK;
    }

    public void setCASH_AT_BANK(String CASH_AT_BANK) {
        this.CASH_AT_BANK = CASH_AT_BANK;
    }

    public String getCHEQUE_BOOK_LEAF_URL() {
        return CHEQUE_BOOK_LEAF_URL;
    }

    public void setCHEQUE_BOOK_LEAF_URL(String CHEQUE_BOOK_LEAF_URL) {
        this.CHEQUE_BOOK_LEAF_URL = CHEQUE_BOOK_LEAF_URL;
    }
}
