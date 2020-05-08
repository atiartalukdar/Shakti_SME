package services;

import java.util.List;

import bp.Utils;
import interfaces.IObjectBoxManager;
import io.objectbox.Box;
import objectBox.BankBranchBox;
import objectBox.BankBranchBox_;
import objectBox.KYCBusinessDetailBox;
import objectBox.KYCBusinessDetailBox_;
import objectBox.KYCBusinessInfoBox;
import objectBox.KYCBusinessInfoBox_;
import objectBox.KYCFamilyMemberBox;
import objectBox.KYCFamilyMemberBox_;
import objectBox.KYCPermanentAddressBox;
import objectBox.KYCPermanentAddressBox_;
import objectBox.KYCPersonalInfoBox;
import objectBox.KYCPersonalInfoBox_;
import objectBox.KYCPresentAddressBox;
import objectBox.KYCPresentAddressBox_;
import objectBox.KYCRelativeBox;
import objectBox.KYCRelativeBox_;
import objectBox.LeadBox;
import objectBox.LeadBox_;
import objectBox.LoanAgroLiveStockBox;
import objectBox.LoanAgroLiveStockBox_;
import objectBox.LoanApplicationBox;
import objectBox.LoanApplicationBox_;
import objectBox.LoanBankAccountBox;
import objectBox.LoanBankAccountBox_;
import objectBox.LoanBusinessSaleBox;
import objectBox.LoanBusinessSaleBox_;
import objectBox.LoanCostOfGoodsBox;
import objectBox.LoanCostOfGoodsBox_;
import objectBox.LoanCurrentLoanBox;
import objectBox.LoanCurrentLoanBox_;
import objectBox.LoanDebtorCreditorBox;
import objectBox.LoanDebtorCreditorBox_;
import objectBox.LoanDocumentBox;
import objectBox.LoanDocumentBox_;
import objectBox.LoanEquipmentValueBox;
import objectBox.LoanEquipmentValueBox_;
import objectBox.LoanExpenseAgroBox;
import objectBox.LoanExpenseAgroBox_;
import objectBox.LoanExpenseBasedIncomeBox;
import objectBox.LoanExpenseBasedIncomeBox_;
import objectBox.LoanFamilyIncomeExpenseAssetBox;
import objectBox.LoanFamilyIncomeExpenseAssetBox_;
import objectBox.LoanFundWithdrawBox;
import objectBox.LoanFundWithdrawBox_;
import objectBox.LoanGuarantorBox;
import objectBox.LoanGuarantorBox_;
import objectBox.LoanIncomeAgroBox;
import objectBox.LoanIncomeAgroBox_;
import objectBox.LoanIncomeBasedIncomeBox;
import objectBox.LoanIncomeBasedIncomeBox_;
import objectBox.LoanOtherExpenseBox;
import objectBox.LoanOtherExpenseBox_;
import objectBox.LoanOtherIncomeBox;
import objectBox.LoanOtherIncomeBox_;
import objectBox.LoanPropertyValueBox;
import objectBox.LoanPropertyValueBox_;
import objectBox.LoanQualitativeAssessmentBox;
import objectBox.LoanQualitativeAssessmentBox_;
import objectBox.LoanRemittanceInfoBox;
import objectBox.LoanRemittanceInfoBox_;
import objectBox.LoanStockOfGoodsBox;
import objectBox.LoanStockOfGoodsBox_;
import objectBox.ObjectBox;
import objectBox.PrescreeningAnsBox;
import objectBox.PrescreeningAnsBox_;

public class ObjectBoxManager implements IObjectBoxManager {
    private final String TAG = getClass().getSimpleName() + " Atiar= ";

    Box<KYCPersonalInfoBox> _kycPersonalInfoRepo = ObjectBox.get().boxFor(KYCPersonalInfoBox.class);
    Box<KYCBusinessInfoBox> _kycBusinessInfoRepo = ObjectBox.get().boxFor(KYCBusinessInfoBox.class);
    Box<KYCBusinessDetailBox> _kycBusinessDetailRepo = ObjectBox.get().boxFor(KYCBusinessDetailBox.class);
    Box<KYCPermanentAddressBox> _kycPermanentAddressRepo = ObjectBox.get().boxFor(KYCPermanentAddressBox.class);
    Box<KYCPresentAddressBox> _kycPresentAddressRepo = ObjectBox.get().boxFor(KYCPresentAddressBox.class);
    Box<KYCFamilyMemberBox> _kycFamilyMemberRepo = ObjectBox.get().boxFor(KYCFamilyMemberBox.class);
    Box<KYCRelativeBox> _kycRelativeRepo = ObjectBox.get().boxFor(KYCRelativeBox.class);

    Box<LoanApplicationBox> _loanApplicationDetailRepo = ObjectBox.get().boxFor(LoanApplicationBox.class);
    Box<LoanCurrentLoanBox> _loanCurrentLoanRepo = ObjectBox.get().boxFor(LoanCurrentLoanBox.class);
    Box<LoanOtherIncomeBox> _loanOtherIncomeRepo = ObjectBox.get().boxFor(LoanOtherIncomeBox.class);
    Box<LoanOtherExpenseBox> _loanOtherExpenseRepo = ObjectBox.get().boxFor(LoanOtherExpenseBox.class);
    Box<LoanPropertyValueBox> _loanPropertyValueRepo = ObjectBox.get().boxFor(LoanPropertyValueBox.class);
    Box<LoanFamilyIncomeExpenseAssetBox> _loanFamilyIncomeExpenseAssetRepo = ObjectBox.get().boxFor(LoanFamilyIncomeExpenseAssetBox.class);
    Box<LoanQualitativeAssessmentBox> _loanQualitativeAssessmentRepo = ObjectBox.get().boxFor(LoanQualitativeAssessmentBox.class);
    Box<LoanGuarantorBox> _loanGuarantorRepo = ObjectBox.get().boxFor(LoanGuarantorBox.class);
    Box<LoanBankAccountBox> _loanBankAccountRepo = ObjectBox.get().boxFor(LoanBankAccountBox.class);
    Box<LoanDocumentBox> _loanDocumentRepo = ObjectBox.get().boxFor(LoanDocumentBox.class);
    Box<LoanBusinessSaleBox> _loanBusinessSaleRepo = ObjectBox.get().boxFor(LoanBusinessSaleBox.class);
    Box<LoanCostOfGoodsBox> _loanCostOfGoodsRepo = ObjectBox.get().boxFor(LoanCostOfGoodsBox.class);
    Box<LoanDebtorCreditorBox> _loanDebtorCreditorRepo = ObjectBox.get().boxFor(LoanDebtorCreditorBox.class);
    Box<LoanEquipmentValueBox> _loanEquipmentValueRepo = ObjectBox.get().boxFor(LoanEquipmentValueBox.class);
    Box<LoanStockOfGoodsBox> _loanStockOfGoodsRepo = ObjectBox.get().boxFor(LoanStockOfGoodsBox.class);
    Box<LoanFundWithdrawBox> _loanFundWithdrawRepo = ObjectBox.get().boxFor(LoanFundWithdrawBox.class);
    Box<LoanIncomeBasedIncomeBox> _loanIncomeBasedIncomeRepo = ObjectBox.get().boxFor(LoanIncomeBasedIncomeBox.class);
    Box<LoanExpenseBasedIncomeBox> _loanExpenseBasedIncomeRepo = ObjectBox.get().boxFor(LoanExpenseBasedIncomeBox.class);
    Box<LoanRemittanceInfoBox> _loanRemittanceInfoRepo = ObjectBox.get().boxFor(LoanRemittanceInfoBox.class);
    Box<LoanIncomeAgroBox> _loanIncomeAgroRepo = ObjectBox.get().boxFor(LoanIncomeAgroBox.class);
    Box<LoanExpenseAgroBox> _loanExpenseAgroRepo = ObjectBox.get().boxFor(LoanExpenseAgroBox.class);
    Box<LoanAgroLiveStockBox> _loanAgroLiveStockRepo = ObjectBox.get().boxFor(LoanAgroLiveStockBox.class);
    Box<LeadBox> _leadRepo=ObjectBox.get().boxFor(LeadBox.class);
    Box<PrescreeningAnsBox> _prescreeningAnsRepo=ObjectBox.get().boxFor(PrescreeningAnsBox.class);

    Box<BankBranchBox> _bankBranch = ObjectBox.get().boxFor(BankBranchBox.class);


    @Override
    public KYCPersonalInfoBox GetKYCPersonalInfoBox(String branchId, String memberId) {
        KYCPersonalInfoBox result = _kycPersonalInfoRepo.query().equal(KYCPersonalInfoBox_.branch_id, branchId).equal(KYCPersonalInfoBox_.member_id, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveKYCPersonalInfoBox(String branchId, String memberId) {
        KYCPersonalInfoBox kycPersonalInfoBox = GetKYCPersonalInfoBox(branchId, memberId);
        if (kycPersonalInfoBox != null) {
            _kycPersonalInfoRepo.remove(kycPersonalInfoBox);
        }
    }

    @Override
    public void SaveKYCBusinessInfoBox(KYCBusinessInfoBox kycBusinessInfoBox) {
        _kycBusinessInfoRepo.put(kycBusinessInfoBox);
    }

    @Override
    public KYCBusinessInfoBox GetKYCBusinessInfoBoxBox(String branchId, String memberId) {
        KYCBusinessInfoBox result = _kycBusinessInfoRepo.query().equal(KYCBusinessInfoBox_.branch_id, branchId).equal(KYCBusinessInfoBox_.member_id, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveKYCBusinessInfoBox(String branchId, String memberId) {
        KYCBusinessInfoBox kycBusinessInfoBox = GetKYCBusinessInfoBoxBox(branchId, memberId);
        if (kycBusinessInfoBox != null) {
            _kycBusinessInfoRepo.remove(kycBusinessInfoBox);
        }
    }

    @Override
    public void SaveKYCBusinessDetailBox(KYCBusinessDetailBox kycBusinessDetailBox) {
        _kycBusinessDetailRepo.put(kycBusinessDetailBox);
    }

    @Override
    public KYCBusinessDetailBox GetKYCBusinessDetailBox(String branchId, String memberId) {
        KYCBusinessDetailBox result = _kycBusinessDetailRepo.query().equal(KYCBusinessDetailBox_.branch_id, branchId).equal(KYCBusinessDetailBox_.member_id, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveKYCBusinessDetailBox(String branchId, String memberId) {
        KYCBusinessDetailBox kycBusinessDetailBox = GetKYCBusinessDetailBox(branchId, memberId);
        if (kycBusinessDetailBox != null) {
            _kycBusinessDetailRepo.remove(kycBusinessDetailBox);
        }
    }

    @Override
    public void SaveKYCPermanentAddressBox(KYCPermanentAddressBox kycPermanentAddressBox) {
        _kycPermanentAddressRepo.put(kycPermanentAddressBox);
    }

    @Override
    public KYCPermanentAddressBox GetKYCPermanentAddressBox(String branchId, String memberId) {
        KYCPermanentAddressBox result = _kycPermanentAddressRepo.query().equal(KYCPermanentAddressBox_.branch_id, branchId).equal(KYCPermanentAddressBox_.member_id, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveKYCPermanentAddressBox(String branchId, String memberId) {
        KYCPermanentAddressBox kycPermanentAddressBox = GetKYCPermanentAddressBox(branchId, memberId);
        if (kycPermanentAddressBox != null) {
            _kycPermanentAddressRepo.remove(kycPermanentAddressBox);
        }
    }

    @Override
    public void SaveKYCPresentAddressBox(KYCPresentAddressBox kycPresentAddressBox) {
        _kycPresentAddressRepo.put(kycPresentAddressBox);
    }

    @Override
    public KYCPresentAddressBox GetKYCPresentAddressBox(String branchId, String memberId) {
        KYCPresentAddressBox result = _kycPresentAddressRepo.query().equal(KYCPresentAddressBox_.branch_id, branchId).equal(KYCPresentAddressBox_.member_id, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveKYCPresentAddressBox(String branchId, String memberId) {
        KYCPresentAddressBox kycPresentAddressBox = GetKYCPresentAddressBox(branchId, memberId);
        if (kycPresentAddressBox != null) {
            _kycPresentAddressRepo.remove(kycPresentAddressBox);
        }
    }

    @Override
    public void SaveKYCFamilyMemberBox(KYCFamilyMemberBox kycFamilyMemberBox) {
        _kycFamilyMemberRepo.put(kycFamilyMemberBox);
    }

    @Override
    public List<KYCFamilyMemberBox> GetKYCFamilyMemberBoxList(String branchId, String memberId) {
        List<KYCFamilyMemberBox>  result = _kycFamilyMemberRepo.query().equal(KYCFamilyMemberBox_.branch_id, branchId).equal(KYCFamilyMemberBox_.member_id, memberId).build().find();
        return result;
    }

    @Override
    public void RemoveKYCFamilyMemberBoxList(String branchId, String memberId) {
        List<KYCFamilyMemberBox> kycFamilyMemberBoxList = GetKYCFamilyMemberBoxList(branchId, memberId);
        if (kycFamilyMemberBoxList != null) {
            _kycFamilyMemberRepo.remove(kycFamilyMemberBoxList);
        }
    }

    @Override
    public void SaveKYCRelativeBox(KYCRelativeBox kycRelativeBox) {
        _kycRelativeRepo.put(kycRelativeBox);
    }

    @Override
    public KYCRelativeBox GetKYCRelativeBox(String branchId, String memberId) {
        KYCRelativeBox result = _kycRelativeRepo.query().equal(KYCRelativeBox_.branch_id, branchId).equal(KYCRelativeBox_.member_id, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveKYCRelativeBox(String branchId, String memberId) {
        KYCRelativeBox kycRelativeBox = GetKYCRelativeBox(branchId, memberId);
        if (kycRelativeBox != null) {
            _kycRelativeRepo.remove(kycRelativeBox);
        }
    }

    @Override
    public LoanApplicationBox GetLoanApplicationDetailBox(String branchId, String memberId) {
        LoanApplicationBox result = _loanApplicationDetailRepo.query().equal(LoanApplicationBox_.BRANCH_ID, branchId).equal(LoanApplicationBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanApplicationDetailBox(String branchId, String memberId) {
        LoanApplicationBox result = GetLoanApplicationDetailBox(branchId, memberId);
        _loanApplicationDetailRepo.remove(result);
    }

    @Override
    public void SaveLoanCurrentLoanBox(LoanCurrentLoanBox loanCurrentLoanBox) {
        _loanCurrentLoanRepo.put(loanCurrentLoanBox);
    }

    @Override
    public List<LoanCurrentLoanBox> GetLoanCurrentLoanListBox(String branchId, String memberId) {
        List<LoanCurrentLoanBox> result = _loanCurrentLoanRepo.query().equal(LoanCurrentLoanBox_.BRANCH_ID, branchId).equal(LoanCurrentLoanBox_.MEMBER_ID, memberId).build().find();
        return result;
    }

    @Override
    public void RemoveLoanCurrentLoanBox(String branchId, String memberId) {
        List<LoanCurrentLoanBox> result = GetLoanCurrentLoanListBox(branchId, memberId);
        _loanCurrentLoanRepo.remove(result);
    }

    @Override
    public void SaveLoanOtherIncomeBox(LoanOtherIncomeBox loanOtherIncomeBox) {
        _loanOtherIncomeRepo.put(loanOtherIncomeBox);
    }

    @Override
    public List<LoanOtherIncomeBox> GetLoanOtherIncomeListBox(String branchId, String memberId) {
        return _loanOtherIncomeRepo.query().equal(LoanOtherIncomeBox_.BRANCH_ID, branchId).equal(LoanOtherIncomeBox_.MEMBER_ID, memberId).build().find();
    }

    @Override
    public void RemoveLoanOtherIncomeBox(String branchId, String memberId) {
        List<LoanOtherIncomeBox> result = GetLoanOtherIncomeListBox(branchId, memberId);
        _loanOtherIncomeRepo.remove(result);
    }

    @Override
    public void SaveLoanOtherExpenseBox(LoanOtherExpenseBox loanOtherExpenseBox) {
        _loanOtherExpenseRepo.put(loanOtherExpenseBox);
    }

    @Override
    public LoanOtherExpenseBox GetLoanOtherExpenseBox(String branchId, String memberId) {
        LoanOtherExpenseBox result = _loanOtherExpenseRepo.query().equal(LoanOtherExpenseBox_.BRANCH_ID, branchId).equal(LoanOtherExpenseBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanOtherExpenseBox(String branchId, String memberId) {
        LoanOtherExpenseBox result = GetLoanOtherExpenseBox(branchId, memberId);
        _loanOtherExpenseRepo.remove(result);
    }

    @Override
    public void SaveLoanPropertyValueBox(LoanPropertyValueBox loanPropertyValueBox) {
        _loanPropertyValueRepo.put(loanPropertyValueBox);
    }

    @Override
    public LoanPropertyValueBox GetLoanPropertyValueBox(String branchId, String memberId) {
        LoanPropertyValueBox result = _loanPropertyValueRepo.query().equal(LoanPropertyValueBox_.BRANCH_ID, branchId).equal(LoanPropertyValueBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanPropertyValueBox(String branchId, String memberId) {
        LoanPropertyValueBox result = GetLoanPropertyValueBox(branchId, memberId);
        _loanPropertyValueRepo.remove(result);
    }

    @Override
    public void SaveLoanFamilyIncomeExpenseAssetBox(LoanFamilyIncomeExpenseAssetBox loanFamilyIncomeExpenseAssetBox) {
        _loanFamilyIncomeExpenseAssetRepo.put(loanFamilyIncomeExpenseAssetBox);
    }

    @Override
    public LoanFamilyIncomeExpenseAssetBox GetLoanFamilyIncomeExpenseAssetBox(String branchId, String memberId) {
        LoanFamilyIncomeExpenseAssetBox result = _loanFamilyIncomeExpenseAssetRepo.query().equal(LoanFamilyIncomeExpenseAssetBox_.BRANCH_ID, branchId).equal(LoanFamilyIncomeExpenseAssetBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanFamilyIncomeExpenseAssetBox(String branchId, String memberId) {
        LoanFamilyIncomeExpenseAssetBox result = GetLoanFamilyIncomeExpenseAssetBox(branchId, memberId);
        _loanFamilyIncomeExpenseAssetRepo.remove(result);
    }

    @Override
    public void SaveLoanGuarantorBox(LoanGuarantorBox loanGuarantorBox) {
        _loanGuarantorRepo.put(loanGuarantorBox);
    }

    @Override
    public List<LoanGuarantorBox> GetLoanGuarantorListBox(String branchId, String memberId) {
        List<LoanGuarantorBox> result = _loanGuarantorRepo.query().equal(LoanGuarantorBox_.BRANCH_ID, branchId).equal(LoanGuarantorBox_.MEMBER_ID, memberId).build().find();
        return result;
    }

    @Override
    public void RemoveLoanGuarantorBox(String branchId, String memberId) {
        List<LoanGuarantorBox> result = GetLoanGuarantorListBox(branchId, memberId);
        _loanGuarantorRepo.remove(result);
    }

    @Override
    public void SaveLoanBankAccountBox(LoanBankAccountBox loanBankAccountBox) {
        _loanBankAccountRepo.put(loanBankAccountBox);
    }

    @Override
    public LoanBankAccountBox GetLoanBankAccountBox(String branchId, String memberId) {
        LoanBankAccountBox result = _loanBankAccountRepo.query().equal(LoanBankAccountBox_.BRANCH_ID, branchId).equal(LoanBankAccountBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanBankAccountBox(String branchId, String memberId) {
        LoanBankAccountBox result = GetLoanBankAccountBox(branchId, memberId);
        _loanBankAccountRepo.remove(result);
    }

    @Override
    public void SaveLoanDocumentBoxList(List<LoanDocumentBox> loanDocumentBoxList) {
        _loanDocumentRepo.put(loanDocumentBoxList);
    }

    @Override
    public void SaveLoanDocumentBox(LoanDocumentBox loanDocumentBox) {
        _loanDocumentRepo.put(loanDocumentBox);
    }

    @Override
    public List<LoanDocumentBox> GetLoanDocumentBoxList(String branchId, String memberId) {
        List<LoanDocumentBox> result = _loanDocumentRepo.query().equal(LoanDocumentBox_.BRANCH_ID, branchId).equal(LoanDocumentBox_.MEMBER_ID, memberId).build().find();
        return result;
    }

    @Override
    public void RemoveLoanDocumentBoxList(String branchId, String memberId) {
        List<LoanDocumentBox> result = GetLoanDocumentBoxList(branchId, memberId);
        _loanDocumentRepo.remove(result);
    }

    @Override
    public void RemoveLoanDocumentBox(LoanDocumentBox loanDocumentBox) {
        _loanDocumentRepo.remove(loanDocumentBox);
    }

    @Override
    public void SaveLoanCostOfGoodsBox(LoanCostOfGoodsBox loanCostOfGoodsBox) {
        _loanCostOfGoodsRepo.put(loanCostOfGoodsBox);
    }

    @Override
    public void SaveKYCPersonalInfoBox(KYCPersonalInfoBox kycPersonalInfoBox) {
        _kycPersonalInfoRepo.put(kycPersonalInfoBox);
    }

    @Override
    public void SaveLoanBusinessSaleBox(LoanBusinessSaleBox loanBusinessSaleBox) {
        _loanBusinessSaleRepo.put(loanBusinessSaleBox);
    }

    @Override
    public LoanBusinessSaleBox GetLoanBusinessSaleBox(String branchId, String memberId) {
        LoanBusinessSaleBox result = _loanBusinessSaleRepo.query().equal(LoanBusinessSaleBox_.BRANCH_ID, branchId).equal(LoanBusinessSaleBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanBusinessSaleBox(String branchId, String memberId) {
        _loanBusinessSaleRepo.remove(GetLoanBusinessSaleBox(branchId, memberId));
    }

    @Override
    public LoanCostOfGoodsBox GetLoanCostOfGoodsBox(String branchId, String memberId) {
        LoanCostOfGoodsBox result = _loanCostOfGoodsRepo.query().equal(LoanCostOfGoodsBox_.BRANCH_ID, branchId).equal(LoanCostOfGoodsBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanCostOfGoodsBox(String branchId, String memberId) {
        _loanCostOfGoodsRepo.remove(GetLoanCostOfGoodsBox(branchId, memberId));
    }

    @Override
    public void SaveLoanDebtorCreditorBox(LoanDebtorCreditorBox loanDebtorCreditorBox) {
        _loanDebtorCreditorRepo.put(loanDebtorCreditorBox);
    }

    @Override
    public LoanDebtorCreditorBox GetLoanDebtorCreditorBox(String branchId, String memberId) {
        LoanDebtorCreditorBox result = _loanDebtorCreditorRepo.query().equal(LoanDebtorCreditorBox_.BRANCH_ID, branchId).equal(LoanDebtorCreditorBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanDebtorCreditorBox(String branchId, String memberId) {
        _loanDebtorCreditorRepo.remove(GetLoanDebtorCreditorBox(branchId, memberId));
    }

    @Override
    public void SaveLoanEquipmentValueBox(LoanEquipmentValueBox loanEquipmentValueBox) {
        _loanEquipmentValueRepo.put(loanEquipmentValueBox);
    }

    @Override
    public LoanEquipmentValueBox GetLoanEquipmentValueBox(String branchId, String memberId) {
        LoanEquipmentValueBox result = _loanEquipmentValueRepo.query().equal(LoanEquipmentValueBox_.BRANCH_ID, branchId).equal(LoanEquipmentValueBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanEquipmentValueBox(String branchId, String memberId) {
        _loanEquipmentValueRepo.remove(GetLoanEquipmentValueBox(branchId, memberId));
    }

    @Override
    public void SaveLoanStockOfGoodsBox(LoanStockOfGoodsBox loanStockOfGoodsBox) {
        _loanStockOfGoodsRepo.put(loanStockOfGoodsBox);
    }

    @Override
    public List<LoanStockOfGoodsBox> GetLoanStockOfGoodsBoxList(String branchId, String memberId) {
        List<LoanStockOfGoodsBox> result = _loanStockOfGoodsRepo.query().equal(LoanStockOfGoodsBox_.BRANCH_ID, branchId).equal(LoanStockOfGoodsBox_.MEMBER_ID, memberId).build().find();
        return result;
    }

    @Override
    public void RemoveLoanStockOfGoodsBox(String branchId, String memberId) {
        _loanStockOfGoodsRepo.remove(GetLoanStockOfGoodsBoxList(branchId, memberId));
    }

    @Override
    public void SaveLoanFundWithdrawBox(LoanFundWithdrawBox loanFundWithdrawBox) {
        _loanFundWithdrawRepo.put(loanFundWithdrawBox);
    }

    @Override
    public LoanFundWithdrawBox GetLoanFundWithdrawBox(String branchId, String memberId) {
        LoanFundWithdrawBox result = _loanFundWithdrawRepo.query().equal(LoanFundWithdrawBox_.BRANCH_ID, branchId).equal(LoanFundWithdrawBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanFundWithdrawBox(String branchId, String memberId) {
        _loanFundWithdrawRepo.remove(GetLoanFundWithdrawBox(branchId, memberId));
    }

    @Override
    public void SaveBankBranchBox(List<BankBranchBox> bankBranchBox) {
        _bankBranch.put(bankBranchBox);

    }

    @Override
    public List<BankBranchBox> GetBankBranchBox(String bankCode) {
        List<BankBranchBox> result = _bankBranch.query().equal(BankBranchBox_.BANKCODE, bankCode).build().find();
        return result;
    }

    @Override
    public LoanIncomeBasedIncomeBox GetLoanIncomeBasedIncomeBox(String branchId, String memberId) {
        LoanIncomeBasedIncomeBox result = _loanIncomeBasedIncomeRepo.query().equal(LoanIncomeBasedIncomeBox_.BRANCH_ID, branchId).equal(LoanIncomeBasedIncomeBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanIncomeBasedIncomeBox(String branchId, String memberId) {
        _loanIncomeBasedIncomeRepo.remove(GetLoanIncomeBasedIncomeBox(branchId, memberId));
    }

    @Override
    public LoanExpenseBasedIncomeBox GetLoanExpenseBasedIncomeBox(String branchId, String memberId) {
        LoanExpenseBasedIncomeBox result = _loanExpenseBasedIncomeRepo.query().equal(LoanExpenseBasedIncomeBox_.BRANCH_ID, branchId).equal(LoanExpenseBasedIncomeBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanExpenseBasedIncomeBox(String branchId, String memberId) {
        _loanExpenseBasedIncomeRepo.remove(GetLoanExpenseBasedIncomeBox(branchId, memberId));
    }

    @Override
    public LoanRemittanceInfoBox GetLoanRemittanceInfoBox(String branchId, String memberId) {
        LoanRemittanceInfoBox result = _loanRemittanceInfoRepo.query().equal(LoanRemittanceInfoBox_.BRANCH_ID, branchId).equal(LoanRemittanceInfoBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanRemittanceInfoBox(String branchId, String memberId) {
        _loanRemittanceInfoRepo.remove(GetLoanRemittanceInfoBox(branchId, memberId));
    }

    @Override
    public LoanIncomeAgroBox GetLoanIncomeAgroBox(String branchId, String memberId) {
        LoanIncomeAgroBox result = _loanIncomeAgroRepo.query().equal(LoanIncomeAgroBox_.BRANCH_ID, branchId).equal(LoanIncomeAgroBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanIncomeAgroBox(String branchId, String memberId) {
        _loanIncomeAgroRepo.remove( GetLoanIncomeAgroBox(branchId, memberId));
    }

    @Override
    public LoanExpenseAgroBox GetLoanExpenseAgroBox(String branchId, String memberId) {
        LoanExpenseAgroBox result = _loanExpenseAgroRepo.query().equal(LoanExpenseAgroBox_.BRANCH_ID, branchId).equal(LoanExpenseAgroBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanExpenseAgroBox(String branchId, String memberId) {
        _loanExpenseAgroRepo.remove(GetLoanExpenseAgroBox(branchId, memberId));
    }

    @Override
    public LoanAgroLiveStockBox GetLoanAgroLiveStockBox(String branchId, String memberId) {
        LoanAgroLiveStockBox result = _loanAgroLiveStockRepo.query().equal(LoanAgroLiveStockBox_.BRANCH_ID, branchId).equal(LoanAgroLiveStockBox_.MEMBER_ID, memberId).build().findFirst();
        return result;
    }

    @Override
    public void RemoveLoanAgroLiveStockBox(String branchId, String memberId) {
        _loanAgroLiveStockRepo.remove(GetLoanAgroLiveStockBox(branchId, memberId));
    }

    @Override
    public void SaveLoanApplicationDetailBox(LoanApplicationBox loanApplicationDetailBox) {
        _loanApplicationDetailRepo.put(loanApplicationDetailBox);
    }

    @Override
    public void SaveLoanIncomeBasedIncomeBox(LoanIncomeBasedIncomeBox loanIncomeBasedIncomeBox) {
        _loanIncomeBasedIncomeRepo.put(loanIncomeBasedIncomeBox);
    }

    @Override
    public void SaveLoanExpenseBasedIncomeBox(LoanExpenseBasedIncomeBox loanExpenseBasedIncomeBox) {
        _loanExpenseBasedIncomeRepo.put(loanExpenseBasedIncomeBox);
    }

    @Override
    public void SaveLoanRemittanceInfoBox(LoanRemittanceInfoBox loanRemittanceInfoBox) {
        _loanRemittanceInfoRepo.put(loanRemittanceInfoBox);
    }

    @Override
    public void SaveLoanIncomeAgroBox(LoanIncomeAgroBox loanIncomeAgroBox) {
        _loanIncomeAgroRepo.put(loanIncomeAgroBox);
    }

    @Override
    public void SaveLoanExpenseAgroBox(LoanExpenseAgroBox loanExpenseAgroBox) {
        _loanExpenseAgroRepo.put(loanExpenseAgroBox);
    }

    @Override
    public void SaveLoanAgroLiveStockBox(LoanAgroLiveStockBox loanAgroLiveStockBox) {
        _loanAgroLiveStockRepo.put(loanAgroLiveStockBox);
    }

    @Override
    public void SaveLeadBox(LeadBox leadBox) {
        _leadRepo.put(leadBox);
    }

    @Override
    public List<LeadBox> GetLeadBoxList(String branchId) {
        List<LeadBox> result = _leadRepo.query().equal(LeadBox_.BRANCH_ID, branchId).build().find();
        return result;
    }

    @Override
    public LeadBox GetLeadBox(String branchId, int leadId) {
        LeadBox result = _leadRepo.query().equal(LeadBox_.BRANCH_ID, branchId).equal(LeadBox_.LEAD_ID, leadId).build().findFirst();
        return result;
    }

    @Override
    public void SyncLeadListWithServer() {
        if (Utils.isNetworkAvailable()){

        }
    }

    @Override
    public void RemoveLeadBox(String branchId, int leadId) {
        _leadRepo.remove(GetLeadBox(branchId, leadId));
    }

    @Override
    public void SavePrescreeningAnsBox(PrescreeningAnsBox prescreeningAnsBox) {
        _prescreeningAnsRepo.put(prescreeningAnsBox);
    }

    @Override
    public List<PrescreeningAnsBox> GetPrescreeningAnsBox(int leadId) {
        return  _prescreeningAnsRepo.query().equal(PrescreeningAnsBox_.LEAD_ID, leadId).build().find();
    }

    @Override
    public void RemovePrescreeningAnsBox(int leadId) {
        _prescreeningAnsRepo.remove(GetPrescreeningAnsBox(leadId));
    }
}
