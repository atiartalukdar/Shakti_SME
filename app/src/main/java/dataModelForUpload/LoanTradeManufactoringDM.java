package dataModelForUpload;

import java.util.List;

import objectBox.LoanBusinessSaleBox;
import objectBox.LoanCostOfGoodsBox;
import objectBox.LoanDebtorCreditorBox;
import objectBox.LoanEquipmentValueBox;
import objectBox.LoanFundWithdrawBox;
import objectBox.LoanStockOfGoodsBox;

public class LoanTradeManufactoringDM {

    private LoanApplicationDM LoanApplication;
    private LoanBusinessSaleBox BusinessSale;
    private LoanCostOfGoodsBox CostOfGoods;
    private LoanDebtorCreditorBox DebtorCreditor;
    private LoanEquipmentValueBox EquipmentValue;
    private List<LoanStockOfGoodsBox> StockOfGoodsList;
    private LoanFundWithdrawBox FundWithdraw;  //TODO: not implemented yet

    public LoanTradeManufactoringDM() {
    }

    public LoanApplicationDM getLoanApplication() {
        return LoanApplication;
    }

    public void setLoanApplication(LoanApplicationDM loanApplication) {
        LoanApplication = loanApplication;
    }

    public LoanBusinessSaleBox getBusinessSale() {
        return BusinessSale;
    }

    public void setBusinessSale(LoanBusinessSaleBox businessSale) {
        BusinessSale = businessSale;
    }

    public LoanCostOfGoodsBox getCostOfGoods() {
        return CostOfGoods;
    }

    public void setCostOfGoods(LoanCostOfGoodsBox costOfGoods) {
        CostOfGoods = costOfGoods;
    }

    public LoanDebtorCreditorBox getDebtorCreditor() {
        return DebtorCreditor;
    }

    public void setDebtorCreditor(LoanDebtorCreditorBox debtorCreditor) {
        DebtorCreditor = debtorCreditor;
    }

    public LoanEquipmentValueBox getEquipmentValue() {
        return EquipmentValue;
    }

    public void setEquipmentValue(LoanEquipmentValueBox equipmentValue) {
        EquipmentValue = equipmentValue;
    }

    public List<LoanStockOfGoodsBox> getStockOfGoodsList() {
        return StockOfGoodsList;
    }

    public void setStockOfGoodsList(List<LoanStockOfGoodsBox> stockOfGoodsList) {
        StockOfGoodsList = stockOfGoodsList;
    }

    public LoanFundWithdrawBox getFundWithdraw() {
        return FundWithdraw;
    }

    public void setFundWithdraw(LoanFundWithdrawBox fundWithdraw) {
        FundWithdraw = fundWithdraw;
    }
}
