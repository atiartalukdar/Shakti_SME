package dataModelForUpload;

import objectBox.LoanAgroLiveStockBox;
import objectBox.LoanExpenseAgroBox;
import objectBox.LoanFundWithdrawBox;
import objectBox.LoanIncomeAgroBox;

public class LoanAgroDM {
    private LoanApplicationDM LoanApplication;
    private LoanIncomeAgroBox IncomeAgro;
    private LoanExpenseAgroBox ExpenseAgro;
    private LoanAgroLiveStockBox AgroLiveStock;
    private LoanFundWithdrawBox FundWithdraw;

    public LoanAgroDM() {
    }

    public LoanApplicationDM getLoanApplication() {
        return LoanApplication;
    }

    public void setLoanApplication(LoanApplicationDM loanApplication) {
        LoanApplication = loanApplication;
    }

    public LoanIncomeAgroBox getIncomeAgro() {
        return IncomeAgro;
    }

    public void setIncomeAgro(LoanIncomeAgroBox incomeAgro) {
        IncomeAgro = incomeAgro;
    }

    public LoanExpenseAgroBox getExpenseAgro() {
        return ExpenseAgro;
    }

    public void setExpenseAgro(LoanExpenseAgroBox expenseAgro) {
        ExpenseAgro = expenseAgro;
    }

    public LoanAgroLiveStockBox getAgroLiveStock() {
        return AgroLiveStock;
    }

    public void setAgroLiveStock(LoanAgroLiveStockBox agroLiveStock) {
        AgroLiveStock = agroLiveStock;
    }

    public LoanFundWithdrawBox getFundWithdraw() {
        return FundWithdraw;
    }

    public void setFundWithdraw(LoanFundWithdrawBox fundWithdraw) {
        FundWithdraw = fundWithdraw;
    }
}
