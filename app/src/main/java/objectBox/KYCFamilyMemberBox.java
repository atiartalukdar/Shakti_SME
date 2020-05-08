package objectBox;

import java.io.Serializable;

import dataModelNew.KYCDMNew;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Atiar Talukdar on 7/24/2019.
 */

@Entity
public class KYCFamilyMemberBox implements Serializable {

    @Id
    long id;
    private String fmname;
    private String relation;
    private Integer age;
    private String  education;
    private Integer ismarried;
    private String occupation;
    private String member_id;
    private String center_id;
    private String branch_id;

    public KYCFamilyMemberBox() {
    }


    public KYCFamilyMemberBox(KYCDMNew.FamilyMemberList data) {
        this.fmname = data.getFMNAME();
        this.relation = data.getRELATION();
        this.age = data.getAGE();
        this.education = data.getEDUCATION();
        this.ismarried = data.getISMARRIED();
        this.occupation = data.getOCCUPATION();
        this.member_id = data.getMEMBER_ID();
        this.center_id = data.getCENTER_ID();
        this.branch_id = data.getBRANCH_ID();
    }

    public KYCFamilyMemberBox(String fmname, String relation, Integer age, String education, Integer ismarried, String occupation, String member_id, String center_id, String branch_id) {
        this.fmname = fmname;
        this.relation = relation;
        this.age = age;
        this.education = education;
        this.ismarried = ismarried;
        this.occupation = occupation;
        this.member_id = member_id;
        this.center_id = center_id;
        this.branch_id = branch_id;
    }

    public String getFmname() {
        return fmname;
    }

    public void setFmname(String fmname) {
        this.fmname = fmname;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getIsmarried() {
        return ismarried;
    }

    public void setIsmarried(Integer ismarried) {
        this.ismarried = ismarried;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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
        return "KYCFamilyMemberBox{" +
                "id=" + id +
                ", fmname='" + fmname + '\'' +
                ", relation='" + relation + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", ismarried=" + ismarried +
                ", occupation='" + occupation + '\'' +
                ", member_id='" + member_id + '\'' +
                ", center_id='" + center_id + '\'' +
                ", branch_id='" + branch_id + '\'' +
                '}';
    }
}
