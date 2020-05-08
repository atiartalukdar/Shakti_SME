package interfaces;

import dataModelForUpload.LoanAgroDM;
import dataModelForUpload.LoanApplicationDM;
import dataModelForUpload.LoanRemittanceDM;
import dataModelForUpload.LoanSalariedRentalBasedIncomeDM;
import dataModelForUpload.LoanTradeManufactoringDM;

public interface ILoanApplicationManager {
    public LoanApplicationDM GetLoanApplication(String branchId, String memberId);
    public LoanTradeManufactoringDM GetTradeManufactoringLoan(String branchId, String memberId);
    public LoanSalariedRentalBasedIncomeDM GetSalariedRentalBasedIncomeLoan(String branchId, String memberId);
    public LoanRemittanceDM GetRemittanceLoan(String branchId, String memberId);
    public LoanAgroDM GetAgroLoan(String branchId, String memberId);

    public void RemoveLoanApplication(String branchId, String memberId);
    public void RemoveLoanTradeManufactoring(String branchId, String memberId);
    public void RemoveLoanSalariedRentalBasedIncome(String branchId, String memberId);
    public void RemoveLoanRemittance(String branchId, String memberId);
    public void RemoveLoanAgro(String branchId, String memberId);
}
