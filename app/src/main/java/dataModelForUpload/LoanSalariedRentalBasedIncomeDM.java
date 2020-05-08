package dataModelForUpload;

import objectBox.LoanExpenseBasedIncomeBox;
import objectBox.LoanIncomeBasedIncomeBox;

public class LoanSalariedRentalBasedIncomeDM {
    private LoanApplicationDM LoanApplication;
    private LoanIncomeBasedIncomeBox IncomeBasedIncome;
    private LoanExpenseBasedIncomeBox ExpenseBasedIncome;

    public LoanSalariedRentalBasedIncomeDM() {
    }

    public LoanApplicationDM getLoanApplication() {
        return LoanApplication;
    }

    public void setLoanApplication(LoanApplicationDM loanApplication) {
        LoanApplication = loanApplication;
    }

    public LoanIncomeBasedIncomeBox getIncomeBasedIncome() {
        return IncomeBasedIncome;
    }

    public void setIncomeBasedIncome(LoanIncomeBasedIncomeBox incomeBasedIncome) {
        IncomeBasedIncome = incomeBasedIncome;
    }

    public LoanExpenseBasedIncomeBox getExpenseBasedIncome() {
        return ExpenseBasedIncome;
    }

    public void setExpenseBasedIncome(LoanExpenseBasedIncomeBox expenseBasedIncome) {
        ExpenseBasedIncome = expenseBasedIncome;
    }
}
