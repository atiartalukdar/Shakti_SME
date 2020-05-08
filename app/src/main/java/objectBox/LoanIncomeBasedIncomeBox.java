package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanIncomeBasedIncomeBox {
    @Id
    long id;

    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;
    String APPLICATION_ID;
    String INCOME_SECTOR;
    String BASE_SALARY;
    String GROSS_SALARY;
    String NEAT_SALARY;
    String IS_BANK_PAID;
    String AVG_HOUSE_RENT;
    String JOB_SECTOR;
    String JOB_TYPE;
    String HOUSE_AGE;


    public LoanIncomeBasedIncomeBox() {
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

    public String getINCOME_SECTOR() {
        return INCOME_SECTOR;
    }

    public void setINCOME_SECTOR(String INCOME_SECTOR) {
        this.INCOME_SECTOR = INCOME_SECTOR;
    }

    public String getBASE_SALARY() {
        return BASE_SALARY;
    }

    public void setBASE_SALARY(String BASE_SALARY) {
        this.BASE_SALARY = BASE_SALARY;
    }

    public String getGROSS_SALARY() {
        return GROSS_SALARY;
    }

    public void setGROSS_SALARY(String GROSS_SALARY) {
        this.GROSS_SALARY = GROSS_SALARY;
    }

    public String getNEAT_SALARY() {
        return NEAT_SALARY;
    }

    public void setNEAT_SALARY(String NEAT_SALARY) {
        this.NEAT_SALARY = NEAT_SALARY;
    }

    public String getIS_BANK_PAID() {
        return IS_BANK_PAID;
    }

    public void setIS_BANK_PAID(String IS_BANK_PAID) {
        this.IS_BANK_PAID = IS_BANK_PAID;
    }

    public String getAVG_HOUSE_RENT() {
        return AVG_HOUSE_RENT;
    }

    public void setAVG_HOUSE_RENT(String AVG_HOUSE_RENT) {
        this.AVG_HOUSE_RENT = AVG_HOUSE_RENT;
    }

    public String getJOB_SECTOR() {
        return JOB_SECTOR;
    }

    public void setJOB_SECTOR(String JOB_SECTOR) {
        this.JOB_SECTOR = JOB_SECTOR;
    }

    public String getJOB_TYPE() {
        return JOB_TYPE;
    }

    public void setJOB_TYPE(String JOB_TYPE) {
        this.JOB_TYPE = JOB_TYPE;
    }

    public String getHOUSE_AGE() {
        return HOUSE_AGE;
    }

    public void setHOUSE_AGE(String HOUSE_AGE) {
        this.HOUSE_AGE = HOUSE_AGE;
    }
}
