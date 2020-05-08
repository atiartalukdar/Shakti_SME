package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanOtherExpenseBox {
    @Id
    long id;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;
    String APPLICATION_ID;
    String RENT_OF_BUSINESS;
    String SALARY_OF_EMPLOYEES;
    String TRANSPORTATION_COSTS;
    String UTILITY_COSTS;
    String REPAIR_COSTS;
    String PACKAGING_COSTS;
    String TAX_CHARGES;
    String OTHER_EXP;

    public LoanOtherExpenseBox() {
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

    public String getRENT_OF_BUSINESS() {
        return RENT_OF_BUSINESS;
    }

    public void setRENT_OF_BUSINESS(String RENT_OF_BUSINESS) {
        this.RENT_OF_BUSINESS = RENT_OF_BUSINESS;
    }

    public String getSALARY_OF_EMPLOYEES() {
        return SALARY_OF_EMPLOYEES;
    }

    public void setSALARY_OF_EMPLOYEES(String SALARY_OF_EMPLOYEES) {
        this.SALARY_OF_EMPLOYEES = SALARY_OF_EMPLOYEES;
    }

    public String getTRANSPORTATION_COSTS() {
        return TRANSPORTATION_COSTS;
    }

    public void setTRANSPORTATION_COSTS(String TRANSPORTATION_COSTS) {
        this.TRANSPORTATION_COSTS = TRANSPORTATION_COSTS;
    }

    public String getUTILITY_COSTS() {
        return UTILITY_COSTS;
    }

    public void setUTILITY_COSTS(String UTILITY_COSTS) {
        this.UTILITY_COSTS = UTILITY_COSTS;
    }

    public String getREPAIR_COSTS() {
        return REPAIR_COSTS;
    }

    public void setREPAIR_COSTS(String REPAIR_COSTS) {
        this.REPAIR_COSTS = REPAIR_COSTS;
    }

    public String getPACKAGING_COSTS() {
        return PACKAGING_COSTS;
    }

    public void setPACKAGING_COSTS(String PACKAGING_COSTS) {
        this.PACKAGING_COSTS = PACKAGING_COSTS;
    }

    public String getTAX_CHARGES() {
        return TAX_CHARGES;
    }

    public void setTAX_CHARGES(String TAX_CHARGES) {
        this.TAX_CHARGES = TAX_CHARGES;
    }

    public String getOTHER_EXP() {
        return OTHER_EXP;
    }

    public void setOTHER_EXP(String OTHER_EXP) {
        this.OTHER_EXP = OTHER_EXP;
    }
}
