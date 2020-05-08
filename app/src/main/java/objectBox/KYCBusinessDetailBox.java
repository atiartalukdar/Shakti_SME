package objectBox;

import java.io.Serializable;

import dataModelNew.KYCDMNew;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class KYCBusinessDetailBox implements Serializable {

    @Id
    long id;

    private String prod_name;
    private String prod_type;
    private String current_exp;
    private String totalexp;
    private String business_type;
    private String male_ft; // permanentMaleWorker
    private String male_pt;  //tempMaleWorker
    private String femal_eft;  //permanentFeMaleWorker
    private String femal_ept;  //tempFeMaleWorker
    private String plane_dft; //next12YearsPredictionFullTime
    private String plane_dpt; //next12YearsPredictionPartTime
    private String emp_changed;
    private String is_reduced;
    private String member_id;
    private String center_id;
    private String branch_id;

    public KYCBusinessDetailBox() {
    }

    public KYCBusinessDetailBox(KYCDMNew.BusinessDetail d) {
        this.prod_name = d.getPROD_NAME();
        this.prod_type = d.getPROD_TYPE();
        this.current_exp = d.getCURRENT_EXP()+"";
        this.totalexp = d.getTOTALEXP()+"";
        this.business_type = d.getBUSINESS_TYPE();
        this.male_ft = d.getMALE_FT()+"";
        this.male_pt = d.getMALE_PT()+"";
        this.femal_eft = d.getFEMAL_EFT()+"";
        this.femal_ept = d.getFEMAL_EPT()+"";
        this.plane_dft = d.getPLANE_DFT()+"";
        this.plane_dpt = d.getPLANE_DPT()+"";
        this.emp_changed = d.getEMP_CHANGED()+"";
        this.is_reduced = d.getIS_REDUCED()+"";
        this.member_id = d.getMEMBER_ID();
        this.center_id = d.getCENTER_ID();
        this.branch_id = d.getBRANCH_ID();
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_type() {
        return prod_type;
    }

    public void setProd_type(String prod_type) {
        this.prod_type = prod_type;
    }

    public String getCurrent_exp() {
        return current_exp;
    }

    public void setCurrent_exp(String current_exp) {
        this.current_exp = current_exp;
    }

    public String getTotalexp() {
        return totalexp;
    }

    public void setTotalexp(String totalexp) {
        this.totalexp = totalexp;
    }

    public String getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }

    public String getMale_ft() {
        return male_ft;
    }

    public void setMale_ft(String male_ft) {
        this.male_ft = male_ft;
    }

    public String getMale_pt() {
        return male_pt;
    }

    public void setMale_pt(String male_pt) {
        this.male_pt = male_pt;
    }

    public String getFemal_eft() {
        return femal_eft;
    }

    public void setFemal_eft(String femal_eft) {
        this.femal_eft = femal_eft;
    }

    public String getFemal_ept() {
        return femal_ept;
    }

    public void setFemal_ept(String femal_ept) {
        this.femal_ept = femal_ept;
    }

    public String getPlane_dft() {
        return plane_dft;
    }

    public void setPlane_dft(String plane_dft) {
        this.plane_dft = plane_dft;
    }

    public String getPlane_dpt() {
        return plane_dpt;
    }

    public void setPlane_dpt(String plane_dpt) {
        this.plane_dpt = plane_dpt;
    }

    public String getEmp_changed() {
        return emp_changed;
    }

    public void setEmp_changed(String emp_changed) {
        this.emp_changed = emp_changed;
    }

    public String getIs_reduced() {
        return is_reduced;
    }

    public void setIs_reduced(String is_reduced) {
        this.is_reduced = is_reduced;
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
        return "KYCBusinessDetailBox{" +
                "id=" + id +
                ", prod_name='" + prod_name + '\'' +
                ", prod_type='" + prod_type + '\'' +
                ", current_exp='" + current_exp + '\'' +
                ", totalexp='" + totalexp + '\'' +
                ", business_type='" + business_type + '\'' +
                ", male_ft='" + male_ft + '\'' +
                ", male_pt='" + male_pt + '\'' +
                ", femal_eft='" + femal_eft + '\'' +
                ", femal_ept='" + femal_ept + '\'' +
                ", plane_dft='" + plane_dft + '\'' +
                ", plane_dpt='" + plane_dpt + '\'' +
                ", emp_changed='" + emp_changed + '\'' +
                ", is_reduced='" + is_reduced + '\'' +
                ", member_id='" + member_id + '\'' +
                ", center_id='" + center_id + '\'' +
                ", branch_id='" + branch_id + '\'' +
                '}';
    }
}
