package dataModelForUpload;

import java.util.List;

import objectBox.LoanApplicationBox;
import objectBox.LoanBankAccountBox;
import objectBox.LoanCurrentLoanBox;
import objectBox.LoanDocumentBox;
import objectBox.LoanFamilyIncomeExpenseAssetBox;
import objectBox.LoanGuarantorBox;
import objectBox.LoanOtherExpenseBox;
import objectBox.LoanOtherIncomeBox;
import objectBox.LoanPropertyValueBox;
import objectBox.LoanQualitativeAssessmentBox;

public class LoanApplicationDM {

    String APPLICATION_ID;
    String RO_ID;
    String APPLICATION_DATE;
    String STATUS;
    String SANCTIONED_AMOUNT;
    String DATE_SANCTIONED;
    String DATE_DISBURSED;
    String NEXT_APPROVAL_STAGE;
    int LEAD_OPTION_ID;
    String LOAN_DURATION;
    String INSTALLMENT_TYPE;
    String INTEREST_RATE;
    String REQUEST_AMOUNT;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;

    private List<LoanCurrentLoanBox> CurrentLoanList;
    private List<LoanOtherIncomeBox> OtherIncomeList;
    private LoanOtherExpenseBox OtherExpense;
    private LoanPropertyValueBox PropertyValue;
    private LoanFamilyIncomeExpenseAssetBox FamilyIncomeExpenseAsset;
    private LoanQualitativeAssessmentBox QualitativeAssessment;
    private List<LoanGuarantorBox> GuarantorList;
    private LoanBankAccountBox BankAccount;
    private List<LoanDocumentBox> DocumentList;

    public LoanApplicationDM(){}

    public LoanApplicationDM(LoanApplicationBox detailBox) {
        if (detailBox != null) {
            this.RO_ID = detailBox.getRO_ID();
            this.APPLICATION_DATE = detailBox.getAPPLICATION_DATE();
            this.STATUS = detailBox.getSTATUS();
            this.SANCTIONED_AMOUNT = detailBox.getSANCTIONED_AMOUNT();
            this.DATE_SANCTIONED = detailBox.getDATE_SANCTIONED();
            this.DATE_DISBURSED = detailBox.getDATE_DISBURSED();
            this.NEXT_APPROVAL_STAGE = detailBox.getNEXT_APPROVAL_STAGE();
            this.LEAD_OPTION_ID = detailBox.getLEAD_OPTION_ID();
            this.LOAN_DURATION = detailBox.getLOAN_DURATION();
            this.INSTALLMENT_TYPE = detailBox.getINSTALLMENT_TYPE();
            this.INTEREST_RATE = detailBox.getINTEREST_RATE();
            this.REQUEST_AMOUNT = detailBox.getREQUEST_AMOUNT();
            this.MEMBER_ID = detailBox.getMEMBER_ID();
            this.CENTER_ID = detailBox.getCENTER_ID();
            this.BRANCH_ID = detailBox.getBRANCH_ID();
        }
    }

    public String getAPPLICATION_ID() {
        return APPLICATION_ID;
    }

    public void setAPPLICATION_ID(String APPLICATION_ID) {
        this.APPLICATION_ID = APPLICATION_ID;
    }

    public String getRO_ID() {
        return RO_ID;
    }

    public void setRO_ID(String RO_ID) {
        this.RO_ID = RO_ID;
    }

    public String getAPPLICATION_DATE() {
        return APPLICATION_DATE;
    }

    public void setAPPLICATION_DATE(String APPLICATION_DATE) {
        this.APPLICATION_DATE = APPLICATION_DATE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getSANCTIONED_AMOUNT() {
        return SANCTIONED_AMOUNT;
    }

    public void setSANCTIONED_AMOUNT(String SANCTIONED_AMOUNT) {
        this.SANCTIONED_AMOUNT = SANCTIONED_AMOUNT;
    }

    public String getDATE_SANCTIONED() {
        return DATE_SANCTIONED;
    }

    public void setDATE_SANCTIONED(String DATE_SANCTIONED) {
        this.DATE_SANCTIONED = DATE_SANCTIONED;
    }

    public String getDATE_DISBURSED() {
        return DATE_DISBURSED;
    }

    public void setDATE_DISBURSED(String DATE_DISBURSED) {
        this.DATE_DISBURSED = DATE_DISBURSED;
    }

    public String getNEXT_APPROVAL_STAGE() {
        return NEXT_APPROVAL_STAGE;
    }

    public void setNEXT_APPROVAL_STAGE(String NEXT_APPROVAL_STAGE) {
        this.NEXT_APPROVAL_STAGE = NEXT_APPROVAL_STAGE;
    }

    public int getLEAD_OPTION_ID() {
        return LEAD_OPTION_ID;
    }

    public void setLEAD_OPTION_ID(int LEAD_OPTION_ID) {
        this.LEAD_OPTION_ID = LEAD_OPTION_ID;
    }

    public String getLOAN_DURATION() {
        return LOAN_DURATION;
    }

    public void setLOAN_DURATION(String LOAN_DURATION) {
        this.LOAN_DURATION = LOAN_DURATION;
    }

    public String getINSTALLMENT_TYPE() {
        return INSTALLMENT_TYPE;
    }

    public void setINSTALLMENT_TYPE(String INSTALLMENT_TYPE) {
        this.INSTALLMENT_TYPE = INSTALLMENT_TYPE;
    }

    public String getINTEREST_RATE() {
        return INTEREST_RATE;
    }

    public void setINTEREST_RATE(String INTEREST_RATE) {
        this.INTEREST_RATE = INTEREST_RATE;
    }

    public String getREQUEST_AMOUNT() {
        return REQUEST_AMOUNT;
    }

    public void setREQUEST_AMOUNT(String REQUEST_AMOUNT) {
        this.REQUEST_AMOUNT = REQUEST_AMOUNT;
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

    public LoanBankAccountBox getBankAccount() {
        return BankAccount;
    }

    public void setBankAccount(LoanBankAccountBox bankAccount) {
        BankAccount = bankAccount;
    }

    public List<LoanCurrentLoanBox> getCurrentLoanList() {
        return CurrentLoanList;
    }

    public void setCurrentLoanList(List<LoanCurrentLoanBox> currentLoanList) {
        CurrentLoanList = currentLoanList;
    }

    public List<LoanOtherIncomeBox> getOtherIncomeList() {
        return OtherIncomeList;
    }

    public void setOtherIncomeList(List<LoanOtherIncomeBox> otherIncomeList) {
        OtherIncomeList = otherIncomeList;
    }

    public LoanOtherExpenseBox getOtherExpense() {
        return OtherExpense;
    }

    public void setOtherExpense(LoanOtherExpenseBox otherExpense) {
        OtherExpense = otherExpense;
    }

    public LoanPropertyValueBox getPropertyValue() {
        return PropertyValue;
    }

    public void setPropertyValue(LoanPropertyValueBox propertyValue) {
        PropertyValue = propertyValue;
    }

    public LoanFamilyIncomeExpenseAssetBox getFamilyIncomeExpenseAsset() {
        return FamilyIncomeExpenseAsset;
    }

    public void setFamilyIncomeExpenseAsset(LoanFamilyIncomeExpenseAssetBox familyIncomeExpenseAsset) {
        FamilyIncomeExpenseAsset = familyIncomeExpenseAsset;
    }

    public LoanQualitativeAssessmentBox getQualitativeAssessment() {
        return QualitativeAssessment;
    }

    public void setQualitativeAssessment(LoanQualitativeAssessmentBox qualitativeAssessment) {
        QualitativeAssessment = qualitativeAssessment;
    }

    public List<LoanGuarantorBox> getGuarantorList() {
        return GuarantorList;
    }

    public void setGuarantorList(List<LoanGuarantorBox> guarantorList) {
        GuarantorList = guarantorList;
    }

    public List<LoanDocumentBox> getDocumentList() {
        return DocumentList;
    }

    public void setDocumentList(List<LoanDocumentBox> documentList) {
        DocumentList = documentList;
    }


}
