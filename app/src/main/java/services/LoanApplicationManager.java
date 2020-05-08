package services;

import dataModelForUpload.LoanAgroDM;
import dataModelForUpload.LoanApplicationDM;
import dataModelForUpload.LoanRemittanceDM;
import dataModelForUpload.LoanSalariedRentalBasedIncomeDM;
import dataModelForUpload.LoanTradeManufactoringDM;
import interfaces.ILoanApplicationManager;
import interfaces.IObjectBoxManager;
import objectBox.LoanApplicationBox;

public class LoanApplicationManager implements ILoanApplicationManager {

    IObjectBoxManager _objectBoxManager = new ObjectBoxManager();

    @Override
    public LoanApplicationDM GetLoanApplication(String branchId, String memberId) {

        LoanApplicationBox loanApplicationDetailBox = _objectBoxManager.GetLoanApplicationDetailBox(branchId, memberId);
        LoanApplicationDM loanApplicationDM = new LoanApplicationDM(loanApplicationDetailBox);

        loanApplicationDM.setCurrentLoanList(_objectBoxManager.GetLoanCurrentLoanListBox(branchId, memberId));
        loanApplicationDM.setOtherIncomeList(_objectBoxManager.GetLoanOtherIncomeListBox(branchId, memberId));
        loanApplicationDM.setOtherExpense(_objectBoxManager.GetLoanOtherExpenseBox(branchId, memberId));
        loanApplicationDM.setPropertyValue(_objectBoxManager.GetLoanPropertyValueBox(branchId, memberId));
        loanApplicationDM.setFamilyIncomeExpenseAsset(_objectBoxManager.GetLoanFamilyIncomeExpenseAssetBox(branchId, memberId));
        loanApplicationDM.setGuarantorList(_objectBoxManager.GetLoanGuarantorListBox(branchId, memberId));
        loanApplicationDM.setBankAccount(_objectBoxManager.GetLoanBankAccountBox(branchId, memberId));
        loanApplicationDM.setDocumentList(_objectBoxManager.GetLoanDocumentBoxList(branchId, memberId));

        return loanApplicationDM;
    }

    @Override
    public LoanTradeManufactoringDM GetTradeManufactoringLoan(String branchId, String memberId) {
        LoanTradeManufactoringDM loanTradeManufactoring = new LoanTradeManufactoringDM();

        loanTradeManufactoring.setLoanApplication(GetLoanApplication(branchId, memberId));
        loanTradeManufactoring.setCostOfGoods(_objectBoxManager.GetLoanCostOfGoodsBox(branchId, memberId));
        loanTradeManufactoring.setDebtorCreditor(_objectBoxManager.GetLoanDebtorCreditorBox(branchId, memberId));
        loanTradeManufactoring.setEquipmentValue(_objectBoxManager.GetLoanEquipmentValueBox(branchId, memberId));
        loanTradeManufactoring.setStockOfGoodsList(_objectBoxManager.GetLoanStockOfGoodsBoxList(branchId, memberId));
        loanTradeManufactoring.setFundWithdraw(_objectBoxManager.GetLoanFundWithdrawBox(branchId, memberId));
        loanTradeManufactoring.setBusinessSale(_objectBoxManager.GetLoanBusinessSaleBox(branchId, memberId));

        return loanTradeManufactoring;
    }

    @Override
    public LoanSalariedRentalBasedIncomeDM GetSalariedRentalBasedIncomeLoan(String branchId, String memberId) {
        LoanSalariedRentalBasedIncomeDM loanSalariedRentalBasedIncome = new LoanSalariedRentalBasedIncomeDM();

        loanSalariedRentalBasedIncome.setLoanApplication(GetLoanApplication(branchId, memberId));
        loanSalariedRentalBasedIncome.setIncomeBasedIncome(_objectBoxManager.GetLoanIncomeBasedIncomeBox(branchId, memberId));
        loanSalariedRentalBasedIncome.setExpenseBasedIncome(_objectBoxManager.GetLoanExpenseBasedIncomeBox(branchId, memberId));

        return loanSalariedRentalBasedIncome;
    }

    @Override
    public LoanRemittanceDM GetRemittanceLoan(String branchId, String memberId) {
        LoanRemittanceDM loanRemittance = new LoanRemittanceDM();

        loanRemittance.setLoanApplication(GetLoanApplication(branchId, memberId));
        loanRemittance.setRemittanceInfo(_objectBoxManager.GetLoanRemittanceInfoBox(branchId, memberId));
        loanRemittance.setExpenseBasedIncome(_objectBoxManager.GetLoanExpenseBasedIncomeBox(branchId, memberId));

        return loanRemittance;
    }

    @Override
    public LoanAgroDM GetAgroLoan(String branchId, String memberId) {
        LoanAgroDM loanAgro = new LoanAgroDM();

        loanAgro.setLoanApplication(GetLoanApplication(branchId, memberId));
        loanAgro.setIncomeAgro(_objectBoxManager.GetLoanIncomeAgroBox(branchId, memberId));
        loanAgro.setExpenseAgro(_objectBoxManager.GetLoanExpenseAgroBox(branchId, memberId));
        loanAgro.setAgroLiveStock(_objectBoxManager.GetLoanAgroLiveStockBox(branchId, memberId));
        loanAgro.setFundWithdraw(_objectBoxManager.GetLoanFundWithdrawBox(branchId, memberId));

        return loanAgro;
    }

    @Override
    public void RemoveLoanApplication(String branchId, String memberId) {
        _objectBoxManager.RemoveLoanApplicationDetailBox(branchId, memberId);
        _objectBoxManager.RemoveLoanCurrentLoanBox(branchId, memberId);
        _objectBoxManager.RemoveLoanOtherIncomeBox(branchId, memberId);
        _objectBoxManager.RemoveLoanOtherExpenseBox(branchId, memberId);
        _objectBoxManager.RemoveLoanPropertyValueBox(branchId, memberId);
        _objectBoxManager.RemoveLoanFamilyIncomeExpenseAssetBox(branchId, memberId);
        _objectBoxManager.RemoveLoanGuarantorBox(branchId, memberId);
        _objectBoxManager.RemoveLoanBankAccountBox(branchId, memberId);
        _objectBoxManager.RemoveLoanDocumentBoxList(branchId, memberId);
    }

    @Override
    public void RemoveLoanTradeManufactoring(String branchId, String memberId) {
        RemoveLoanApplication(branchId, memberId);
        _objectBoxManager.RemoveLoanCostOfGoodsBox(branchId, memberId);
        _objectBoxManager.RemoveLoanDebtorCreditorBox(branchId, memberId);
        _objectBoxManager.RemoveLoanEquipmentValueBox(branchId, memberId);
        _objectBoxManager.RemoveLoanStockOfGoodsBox(branchId, memberId);
        _objectBoxManager.RemoveLoanFundWithdrawBox(branchId, memberId);
        _objectBoxManager.RemoveLoanBusinessSaleBox(branchId, memberId);
    }

    @Override
    public void RemoveLoanSalariedRentalBasedIncome(String branchId, String memberId) {
        RemoveLoanApplication(branchId, memberId);
        _objectBoxManager.RemoveLoanIncomeBasedIncomeBox(branchId, memberId);
        _objectBoxManager.RemoveLoanExpenseBasedIncomeBox(branchId, memberId);
    }

    @Override
    public void RemoveLoanRemittance(String branchId, String memberId) {
        RemoveLoanApplication(branchId, memberId);
        _objectBoxManager.RemoveLoanRemittanceInfoBox(branchId, memberId);
        _objectBoxManager.RemoveLoanExpenseBasedIncomeBox(branchId, memberId);
    }

    @Override
    public void RemoveLoanAgro(String branchId, String memberId) {
        RemoveLoanApplication(branchId, memberId);
        _objectBoxManager.RemoveLoanIncomeAgroBox(branchId, memberId);
        _objectBoxManager.RemoveLoanExpenseAgroBox(branchId, memberId);
        _objectBoxManager.RemoveLoanAgroLiveStockBox(branchId, memberId);
        _objectBoxManager.RemoveLoanFundWithdrawBox(branchId, memberId);
    }
}
