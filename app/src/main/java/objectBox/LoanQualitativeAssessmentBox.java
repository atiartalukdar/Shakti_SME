package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class LoanQualitativeAssessmentBox {
    @Id
    long id;
    String MEMBER_ID;
    String CENTER_ID;
    String BRANCH_ID;
    String APPLICATION_ID;
    String REPUTATION;
    String BEHAVIOR;
    String MANAGES_BUSINESS;
    String BUSINESS_EXPERIENCE;
    String JOB_TYPE;
    String IS_PERMANENT_JOB;
    String JOB_EXPERIENCE;
    String HASOTHER_EARNING_MEMBER;
    String EDUCATION;
    String ISIN_POLITICS;
    String HAS_CRIMERECORD;
    String FAMILY_HAS_CRIMERECORD;


    public LoanQualitativeAssessmentBox() {
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

    public String getREPUTATION() {
        return REPUTATION;
    }

    public void setREPUTATION(String REPUTATION) {
        this.REPUTATION = REPUTATION;
    }

    public String getBEHAVIOR() {
        return BEHAVIOR;
    }

    public void setBEHAVIOR(String BEHAVIOR) {
        this.BEHAVIOR = BEHAVIOR;
    }

    public String getMANAGES_BUSINESS() {
        return MANAGES_BUSINESS;
    }

    public void setMANAGES_BUSINESS(String MANAGES_BUSINESS) {
        this.MANAGES_BUSINESS = MANAGES_BUSINESS;
    }

    public String getBUSINESS_EXPERIENCE() {
        return BUSINESS_EXPERIENCE;
    }

    public void setBUSINESS_EXPERIENCE(String BUSINESS_EXPERIENCE) {
        this.BUSINESS_EXPERIENCE = BUSINESS_EXPERIENCE;
    }

    public String getJOB_TYPE() {
        return JOB_TYPE;
    }

    public void setJOB_TYPE(String JOB_TYPE) {
        this.JOB_TYPE = JOB_TYPE;
    }

    public String getIS_PERMANENT_JOB() {
        return IS_PERMANENT_JOB;
    }

    public void setIS_PERMANENT_JOB(String IS_PERMANENT_JOB) {
        this.IS_PERMANENT_JOB = IS_PERMANENT_JOB;
    }

    public String getJOB_EXPERIENCE() {
        return JOB_EXPERIENCE;
    }

    public void setJOB_EXPERIENCE(String JOB_EXPERIENCE) {
        this.JOB_EXPERIENCE = JOB_EXPERIENCE;
    }

    public String getHASOTHER_EARNING_MEMBER() {
        return HASOTHER_EARNING_MEMBER;
    }

    public void setHASOTHER_EARNING_MEMBER(String HASOTHER_EARNING_MEMBER) {
        this.HASOTHER_EARNING_MEMBER = HASOTHER_EARNING_MEMBER;
    }

    public String getEDUCATION() {
        return EDUCATION;
    }

    public void setEDUCATION(String EDUCATION) {
        this.EDUCATION = EDUCATION;
    }

    public String getISIN_POLITICS() {
        return ISIN_POLITICS;
    }

    public void setISIN_POLITICS(String ISIN_POLITICS) {
        this.ISIN_POLITICS = ISIN_POLITICS;
    }

    public String getHAS_CRIMERECORD() {
        return HAS_CRIMERECORD;
    }

    public void setHAS_CRIMERECORD(String HAS_CRIMERECORD) {
        this.HAS_CRIMERECORD = HAS_CRIMERECORD;
    }

    public String getFAMILY_HAS_CRIMERECORD() {
        return FAMILY_HAS_CRIMERECORD;
    }

    public void setFAMILY_HAS_CRIMERECORD(String FAMILY_HAS_CRIMERECORD) {
        this.FAMILY_HAS_CRIMERECORD = FAMILY_HAS_CRIMERECORD;
    }
}
