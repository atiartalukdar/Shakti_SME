package dataModelForUpload;

import objectBox.LoanExpenseBasedIncomeBox;
import objectBox.LoanRemittanceInfoBox;

public class LoanRemittanceDM {
    private LoanApplicationDM LoanApplication;
    private LoanRemittanceInfoBox RemittanceInfo;
    private LoanExpenseBasedIncomeBox ExpenseBasedIncome;

    public LoanRemittanceDM() {
    }

    public LoanApplicationDM getLoanApplication() {
        return LoanApplication;
    }

    public void setLoanApplication(LoanApplicationDM loanApplication) {
        LoanApplication = loanApplication;
    }

    public LoanRemittanceInfoBox getRemittanceInfo() {
        return RemittanceInfo;
    }

    public void setRemittanceInfo(LoanRemittanceInfoBox remittanceInfo) {
        RemittanceInfo = remittanceInfo;
    }

    public LoanExpenseBasedIncomeBox getExpenseBasedIncome() {
        return ExpenseBasedIncome;
    }

    public void setExpenseBasedIncome(LoanExpenseBasedIncomeBox expenseBasedIncome) {
        ExpenseBasedIncome = expenseBasedIncome;
    }
}
