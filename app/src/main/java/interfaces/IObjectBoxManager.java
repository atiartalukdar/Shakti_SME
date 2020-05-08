package interfaces;

import java.util.List;

import objectBox.BankBranchBox;
import objectBox.KYCBusinessDetailBox;
import objectBox.KYCBusinessInfoBox;
import objectBox.KYCFamilyMemberBox;
import objectBox.KYCPermanentAddressBox;
import objectBox.KYCPersonalInfoBox;
import objectBox.KYCPresentAddressBox;
import objectBox.KYCRelativeBox;
import objectBox.LeadBox;
import objectBox.LoanAgroLiveStockBox;
import objectBox.LoanApplicationBox;
import objectBox.LoanBankAccountBox;
import objectBox.LoanBusinessSaleBox;
import objectBox.LoanCostOfGoodsBox;
import objectBox.LoanCurrentLoanBox;
import objectBox.LoanDebtorCreditorBox;
import objectBox.LoanDocumentBox;
import objectBox.LoanEquipmentValueBox;
import objectBox.LoanExpenseAgroBox;
import objectBox.LoanExpenseBasedIncomeBox;
import objectBox.LoanFamilyIncomeExpenseAssetBox;
import objectBox.LoanFundWithdrawBox;
import objectBox.LoanGuarantorBox;
import objectBox.LoanIncomeAgroBox;
import objectBox.LoanIncomeBasedIncomeBox;
import objectBox.LoanOtherExpenseBox;
import objectBox.LoanOtherIncomeBox;
import objectBox.LoanPropertyValueBox;
import objectBox.LoanQualitativeAssessmentBox;
import objectBox.LoanRemittanceInfoBox;
import objectBox.LoanStockOfGoodsBox;
import objectBox.PrescreeningAnsBox;

public interface IObjectBoxManager
{

    /*----------------------   KYC   ----------------------*/
    public void SaveKYCPersonalInfoBox(KYCPersonalInfoBox kycPersonalInfoBox);
    public KYCPersonalInfoBox GetKYCPersonalInfoBox(String branchId, String memberId);
    public void RemoveKYCPersonalInfoBox(String branchId, String memberId);

    public void SaveKYCBusinessInfoBox(KYCBusinessInfoBox kycBusinessInfoBox);
    public KYCBusinessInfoBox GetKYCBusinessInfoBoxBox(String branchId, String memberId);
    public void RemoveKYCBusinessInfoBox(String branchId, String memberId);

    public void SaveKYCBusinessDetailBox(KYCBusinessDetailBox kycBusinessDetailBox);
    public KYCBusinessDetailBox GetKYCBusinessDetailBox(String branchId, String memberId);
    public void RemoveKYCBusinessDetailBox(String branchId, String memberId);

    public void SaveKYCPermanentAddressBox(KYCPermanentAddressBox kycPermanentAddressBox);
    public KYCPermanentAddressBox GetKYCPermanentAddressBox(String branchId, String memberId);
    public void RemoveKYCPermanentAddressBox(String branchId, String memberId);

    public void SaveKYCPresentAddressBox(KYCPresentAddressBox kycPresentAddressBox);
    public KYCPresentAddressBox GetKYCPresentAddressBox(String branchId, String memberId);
    public void RemoveKYCPresentAddressBox(String branchId, String memberId);

    public void SaveKYCFamilyMemberBox(KYCFamilyMemberBox kycFamilyMemberBox);
    public List<KYCFamilyMemberBox> GetKYCFamilyMemberBoxList(String branchId, String memberId);
    public void RemoveKYCFamilyMemberBoxList(String branchId, String memberId);

    public void SaveKYCRelativeBox(KYCRelativeBox kycRelativeBox);
    public KYCRelativeBox GetKYCRelativeBox(String branchId, String memberId);
    public void RemoveKYCRelativeBox(String branchId, String memberId);

    /*----------------------   LEAD   ----------------------*/
    public void SaveLeadBox(LeadBox leadBox);
    public List<LeadBox> GetLeadBoxList(String branchId);
    public LeadBox GetLeadBox(String branchId, int leadId);
    public void RemoveLeadBox(String branchId, int leadId);

    public void SavePrescreeningAnsBox(PrescreeningAnsBox prescreeningAnsBox);
    public List<PrescreeningAnsBox> GetPrescreeningAnsBox(int leadId);
    public void RemovePrescreeningAnsBox(int leadId);

    public void SyncLeadListWithServer();

    /*----------------------   LOAN   ----------------------*/
    public void SaveLoanBusinessSaleBox(LoanBusinessSaleBox loanBusinessSaleBox);
    public LoanBusinessSaleBox GetLoanBusinessSaleBox(String branchId, String memberId);
    public void RemoveLoanBusinessSaleBox(String branchId, String memberId);

    public void SaveLoanIncomeBasedIncomeBox(LoanIncomeBasedIncomeBox loanIncomeBasedIncomeBox);
    public LoanIncomeBasedIncomeBox GetLoanIncomeBasedIncomeBox(String branchId, String memberId);
    public void RemoveLoanIncomeBasedIncomeBox(String branchId, String memberId);

    public void SaveLoanExpenseBasedIncomeBox(LoanExpenseBasedIncomeBox loanExpenseBasedIncomeBox);
    public LoanExpenseBasedIncomeBox GetLoanExpenseBasedIncomeBox(String branchId, String memberId);
    public void RemoveLoanExpenseBasedIncomeBox(String branchId, String memberId);

    public void SaveLoanRemittanceInfoBox(LoanRemittanceInfoBox loanRemittanceInfoBox);
    public LoanRemittanceInfoBox GetLoanRemittanceInfoBox(String branchId, String memberId);
    public void RemoveLoanRemittanceInfoBox(String branchId, String memberId);

    public void SaveLoanIncomeAgroBox(LoanIncomeAgroBox loanIncomeAgroBox);
    public LoanIncomeAgroBox GetLoanIncomeAgroBox(String branchId, String memberId);
    public void RemoveLoanIncomeAgroBox(String branchId, String memberId);

    public void SaveLoanExpenseAgroBox(LoanExpenseAgroBox loanExpenseAgroBox);
    public LoanExpenseAgroBox GetLoanExpenseAgroBox(String branchId, String memberId);
    public void RemoveLoanExpenseAgroBox(String branchId, String memberId);

    public void SaveLoanAgroLiveStockBox(LoanAgroLiveStockBox loanAgroLiveStockBox);
    public LoanAgroLiveStockBox GetLoanAgroLiveStockBox(String branchId, String memberId);
    public void RemoveLoanAgroLiveStockBox(String branchId, String memberId);

    public void SaveLoanApplicationDetailBox(LoanApplicationBox loanApplicationDetailBox);
    public LoanApplicationBox GetLoanApplicationDetailBox(String branchId, String memberId);
    public void RemoveLoanApplicationDetailBox(String branchId, String memberId);

    public void SaveLoanCurrentLoanBox(LoanCurrentLoanBox loanCurrentLoanBox);
    public List<LoanCurrentLoanBox> GetLoanCurrentLoanListBox(String branchId, String memberId);
    public void RemoveLoanCurrentLoanBox(String branchId, String memberId);

    public void SaveLoanOtherIncomeBox(LoanOtherIncomeBox loanOtherIncomeBox);
    public List<LoanOtherIncomeBox> GetLoanOtherIncomeListBox(String branchId, String memberId);
    public void RemoveLoanOtherIncomeBox(String branchId, String memberId);

    public void SaveLoanOtherExpenseBox(LoanOtherExpenseBox loanOtherExpenseBox);
    public LoanOtherExpenseBox GetLoanOtherExpenseBox(String branchId, String memberId);
    public void RemoveLoanOtherExpenseBox(String branchId, String memberId);

    public void SaveLoanPropertyValueBox(LoanPropertyValueBox loanPropertyValueBox);
    public LoanPropertyValueBox GetLoanPropertyValueBox(String branchId, String memberId);
    public void RemoveLoanPropertyValueBox(String branchId, String memberId);

    public void SaveLoanFamilyIncomeExpenseAssetBox(LoanFamilyIncomeExpenseAssetBox loanFamilyIncomeExpenseAssetBox);
    public LoanFamilyIncomeExpenseAssetBox GetLoanFamilyIncomeExpenseAssetBox(String branchId, String memberId);
    public void RemoveLoanFamilyIncomeExpenseAssetBox(String branchId, String memberId);

    public void SaveLoanGuarantorBox(LoanGuarantorBox loanGuarantorBox);
    public List<LoanGuarantorBox> GetLoanGuarantorListBox(String branchId, String memberId);
    public void RemoveLoanGuarantorBox(String branchId, String memberId);

    public void SaveLoanBankAccountBox(LoanBankAccountBox loanBankAccountBox);
    public LoanBankAccountBox GetLoanBankAccountBox(String branchId, String memberId);
    public void RemoveLoanBankAccountBox(String branchId, String memberId);

    public void SaveLoanDocumentBoxList(List<LoanDocumentBox> loanDocumentBoxList);
    public void SaveLoanDocumentBox(LoanDocumentBox loanDocumentBox);
    public List<LoanDocumentBox> GetLoanDocumentBoxList(String branchId, String memberId);
    public void RemoveLoanDocumentBoxList(String branchId, String memberId);
    public void RemoveLoanDocumentBox(LoanDocumentBox loanDocumentBox);

    public void SaveLoanCostOfGoodsBox(LoanCostOfGoodsBox loanCostOfGoodsBox);
    public LoanCostOfGoodsBox GetLoanCostOfGoodsBox(String branchId, String memberId);
    public void RemoveLoanCostOfGoodsBox(String branchId, String memberId);

    public void SaveLoanDebtorCreditorBox(LoanDebtorCreditorBox loanDebtorCreditorBox);
    public LoanDebtorCreditorBox GetLoanDebtorCreditorBox(String branchId, String memberId);
    public void RemoveLoanDebtorCreditorBox(String branchId, String memberId);

    public void SaveLoanEquipmentValueBox(LoanEquipmentValueBox loanEquipmentValueBox);
    public LoanEquipmentValueBox GetLoanEquipmentValueBox(String branchId, String memberId);
    public void RemoveLoanEquipmentValueBox(String branchId, String memberId);

    public void SaveLoanStockOfGoodsBox(LoanStockOfGoodsBox loanStockOfGoodsBox);
    public List<LoanStockOfGoodsBox> GetLoanStockOfGoodsBoxList(String branchId, String memberId);
    public void RemoveLoanStockOfGoodsBox(String branchId, String memberId);

    public void SaveLoanFundWithdrawBox(LoanFundWithdrawBox loanFundWithdrawBox);
    public LoanFundWithdrawBox GetLoanFundWithdrawBox(String branchId, String memberId);
    public void RemoveLoanFundWithdrawBox(String branchId, String memberId);

    public void SaveBankBranchBox(List<BankBranchBox> bankBranchBox);
    public List<BankBranchBox> GetBankBranchBox(String bankCode);

}



