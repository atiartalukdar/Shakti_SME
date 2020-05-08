package objectBox;

import java.io.Serializable;

import dataModelNew.KYCDMNew;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Atiar Talukdar on 7/24/2019.
 */

@Entity
public class KYCPermanentAddressBox implements Serializable {


    @Id
    long id;


    private String house_no;
    private String road_no;
    private String road_name;
    private String house_owner;
    private String moholla;
    private String post_office;
    private String thana;
    private String district;
    private String member_id;
    private String center_id;
    private String branch_id;

    public KYCPermanentAddressBox() {
    }

    public KYCPermanentAddressBox(KYCDMNew.PermanentAddress data) {
        this.house_no = data.getHOUSE_NO();
        this.road_no = data.getROAD_NO();
        this.road_name = data.getROAD_NAME();
        this.house_owner = data.getHOUSE_OWNER();
        this.moholla = data.getMOHOLLA();
        this.post_office = data.getPOST_OFFICE();
        this.thana = data.getTHANA();
        this.district = data.getDISTRICT();
        this.member_id = data.getMEMBER_ID();
        this.center_id = data.getCENTER_ID();
        this.branch_id = data.getBRANCH_ID();
    }

    public String getHouse_no() {
        return house_no;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }

    public String getRoad_no() {
        return road_no;
    }

    public void setRoad_no(String road_no) {
        this.road_no = road_no;
    }

    public String getRoad_name() {
        return road_name;
    }

    public void setRoad_name(String road_name) {
        this.road_name = road_name;
    }

    public String getHouse_owner() {
        return house_owner;
    }

    public void setHouse_owner(String house_owner) {
        this.house_owner = house_owner;
    }

    public String getMoholla() {
        return moholla;
    }

    public void setMoholla(String moholla) {
        this.moholla = moholla;
    }

    public String getPost_office() {
        return post_office;
    }

    public void setPost_office(String post_office) {
        this.post_office = post_office;
    }

    public String getThana() {
        return thana;
    }

    public void setThana(String thana) {
        this.thana = thana;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
        return "KYCPermanentAddressBox{" +
                "house_no='" + house_no + '\'' +
                ", road_no='" + road_no + '\'' +
                ", road_name='" + road_name + '\'' +
                ", house_owner='" + house_owner + '\'' +
                ", moholla='" + moholla + '\'' +
                ", post_office='" + post_office + '\'' +
                ", thana='" + thana + '\'' +
                ", district='" + district + '\'' +
                ", member_id='" + member_id + '\'' +
                ", center_id='" + center_id + '\'' +
                ", branch_id='" + branch_id + '\'' +
                '}';
    }
}
