package objectBox;

import java.io.Serializable;

import dataModelNew.KYCDMNew;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class KYCPersonalInfoBox implements Serializable {
    @Id
    long id;

    private String member_name;
    private String date_of_birth;
    private Integer experience;
    private String education;
    private String spouse_name;
    private String fathers_name;
    private String mothers_name;
    private String nationality;
    private String national_id;
    private String mobile_no;
    private String breadwinner;
    private String relation;
    private String occupation;
    private String drivinglicense;
    private String passport_no;
    private String mobileno2;
    private String PHOTO_DOC;
    private String member_id;
    private String center_id;
    private String branch_id;

    public KYCPersonalInfoBox() {
    }

    public KYCPersonalInfoBox(KYCDMNew.PersonalInfo data) {
        this.member_name = data.getMEMBER_NAME();
        this.date_of_birth = data.getDATE_OF_BIRTH();
        this.experience = data.getEXPERIENCE();
        this.education = data.getEDUCATION();
        this.spouse_name = data.getSPOUSE_NAME();
        this.fathers_name = data.getFATHERS_NAME();
        this.mothers_name = data.getMOTHERS_NAME();
        this.nationality = data.getNATIONALITY();
        this.national_id = data.getNATIONAL_ID();
        this.mobile_no = data.getMOBILE_NO();
        this.breadwinner = data.getBREADWINNER();
        this.relation = data.getRELATION();
        this.occupation = data.getOCCUPATION();
        this.drivinglicense = data.getDRIVINGLICENSE();
        this.passport_no = data.getPASSPORT_NO();
        this.mobileno2 = data.getMOBILENO2();
        this.member_id = data.getMEMBER_ID();
        this.center_id = data.getCENTER_ID();
        this.branch_id = data.getBRANCH_ID();
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSpouse_name() {
        return spouse_name;
    }

    public void setSpouse_name(String spouse_name) {
        this.spouse_name = spouse_name;
    }

    public String getFathers_name() {
        return fathers_name;
    }

    public void setFathers_name(String fathers_name) {
        this.fathers_name = fathers_name;
    }

    public String getMothers_name() {
        return mothers_name;
    }

    public void setMothers_name(String mothers_name) {
        this.mothers_name = mothers_name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNational_id() {
        return national_id;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getBreadwinner() {
        return breadwinner;
    }

    public void setBreadwinner(String breadwinner) {
        this.breadwinner = breadwinner;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDrivinglicense() {
        return drivinglicense;
    }

    public void setDrivinglicense(String drivinglicense) {
        this.drivinglicense = drivinglicense;
    }

    public String getPassport_no() {
        return passport_no;
    }

    public void setPassport_no(String passport_no) {
        this.passport_no = passport_no;
    }

    public String getMobileno2() {
        return mobileno2;
    }

    public void setMobileno2(String mobileno2) {
        this.mobileno2 = mobileno2;
    }

    public String getPHOTO_DOC() {
        return PHOTO_DOC;
    }

    public void setPHOTO_DOC(String PHOTO_DOC) {
        this.PHOTO_DOC = PHOTO_DOC;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getCenter_id() {
        return center_id;
    }

    public void setCenter_id(String center_id) {
        this.center_id = center_id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    @Override
    public String toString() {
        return "KYCPersonalInfoBox{" +
                "id=" + id +
                ", member_name='" + member_name + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", experience=" + experience +
                ", education='" + education + '\'' +
                ", spouse_name='" + spouse_name + '\'' +
                ", fathers_name='" + fathers_name + '\'' +
                ", mothers_name='" + mothers_name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", national_id='" + national_id + '\'' +
                ", mobile_no='" + mobile_no + '\'' +
                ", breadwinner='" + breadwinner + '\'' +
                ", relation='" + relation + '\'' +
                ", occupation='" + occupation + '\'' +
                ", drivinglicense='" + drivinglicense + '\'' +
                ", passport_no='" + passport_no + '\'' +
                ", mobileno2='" + mobileno2 + '\'' +
                ", member_id='" + member_id + '\'' +
                ", center_id='" + center_id + '\'' +
                ", branch_id='" + branch_id + '\'' +
                '}';
    }
}
