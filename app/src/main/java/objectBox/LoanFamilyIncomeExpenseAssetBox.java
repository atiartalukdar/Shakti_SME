package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanFamilyIncomeExpenseAssetBox {

    @Id
    long id;

    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;
    String APPLICATION_ID;
    String OWN_LAND;
    String OWN_HOUSE;
    String HOUSE_FURNITURE;
    String OTHER_FAMILY_ASSETS;
    String SAVING_DEPOSIT_ORG;
    String INC_OTHER_INCOME;
    String INC_TAKE_REMITTANCE;
    String COST_SPENT_FAMILY;
    String COST_RENT_HOME;
    String COST_CHILDREN_STUDY;
    String COST_MEDICAL;
    String COST_OTHER_BIL;
    String COST_SUPPORT;
    String COST_OUTSIDE_FAMILY;

    public LoanFamilyIncomeExpenseAssetBox() {
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

    public String getOWN_LAND() {
        return OWN_LAND;
    }

    public void setOWN_LAND(String OWN_LAND) {
        this.OWN_LAND = OWN_LAND;
    }

    public String getOWN_HOUSE() {
        return OWN_HOUSE;
    }

    public void setOWN_HOUSE(String OWN_HOUSE) {
        this.OWN_HOUSE = OWN_HOUSE;
    }

    public String getHOUSE_FURNITURE() {
        return HOUSE_FURNITURE;
    }

    public void setHOUSE_FURNITURE(String HOUSE_FURNITURE) {
        this.HOUSE_FURNITURE = HOUSE_FURNITURE;
    }

    public String getOTHER_FAMILY_ASSETS() {
        return OTHER_FAMILY_ASSETS;
    }

    public void setOTHER_FAMILY_ASSETS(String OTHER_FAMILY_ASSETS) {
        this.OTHER_FAMILY_ASSETS = OTHER_FAMILY_ASSETS;
    }

    public String getSAVING_DEPOSIT_ORG() {
        return SAVING_DEPOSIT_ORG;
    }

    public void setSAVING_DEPOSIT_ORG(String SAVING_DEPOSIT_ORG) {
        this.SAVING_DEPOSIT_ORG = SAVING_DEPOSIT_ORG;
    }

    public String getINC_OTHER_INCOME() {
        return INC_OTHER_INCOME;
    }

    public void setINC_OTHER_INCOME(String INC_OTHER_INCOME) {
        this.INC_OTHER_INCOME = INC_OTHER_INCOME;
    }

    public String getINC_TAKE_REMITTANCE() {
        return INC_TAKE_REMITTANCE;
    }

    public void setINC_TAKE_REMITTANCE(String INC_TAKE_REMITTANCE) {
        this.INC_TAKE_REMITTANCE = INC_TAKE_REMITTANCE;
    }

    public String getCOST_SPENT_FAMILY() {
        return COST_SPENT_FAMILY;
    }

    public void setCOST_SPENT_FAMILY(String COST_SPENT_FAMILY) {
        this.COST_SPENT_FAMILY = COST_SPENT_FAMILY;
    }

    public String getCOST_RENT_HOME() {
        return COST_RENT_HOME;
    }

    public void setCOST_RENT_HOME(String COST_RENT_HOME) {
        this.COST_RENT_HOME = COST_RENT_HOME;
    }

    public String getCOST_CHILDREN_STUDY() {
        return COST_CHILDREN_STUDY;
    }

    public void setCOST_CHILDREN_STUDY(String COST_CHILDREN_STUDY) {
        this.COST_CHILDREN_STUDY = COST_CHILDREN_STUDY;
    }

    public String getCOST_MEDICAL() {
        return COST_MEDICAL;
    }

    public void setCOST_MEDICAL(String COST_MEDICAL) {
        this.COST_MEDICAL = COST_MEDICAL;
    }

    public String getCOST_OTHER_BIL() {
        return COST_OTHER_BIL;
    }

    public void setCOST_OTHER_BIL(String COST_OTHER_BIL) {
        this.COST_OTHER_BIL = COST_OTHER_BIL;
    }

    public String getCOST_SUPPORT() {
        return COST_SUPPORT;
    }

    public void setCOST_SUPPORT(String COST_SUPPORT) {
        this.COST_SUPPORT = COST_SUPPORT;
    }

    public String getCOST_OUTSIDE_FAMILY() {
        return COST_OUTSIDE_FAMILY;
    }

    public void setCOST_OUTSIDE_FAMILY(String COST_OUTSIDE_FAMILY) {
        this.COST_OUTSIDE_FAMILY = COST_OUTSIDE_FAMILY;
    }
}
