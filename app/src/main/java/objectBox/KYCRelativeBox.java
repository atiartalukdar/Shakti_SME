package objectBox;

import java.io.Serializable;

import dataModelNew.KYCDMNew;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Atiar Talukdar on 7/24/2019.
 */
@Entity
public class KYCRelativeBox implements Serializable {

    @Id
    long id;

    private String name;
    private String spouse_name;
    private String occupation;
    private String relation;
    private String house_no;
    private String roadno;
    private String road_name;
    private String houseo_wner;
    private String moholla;
    private String post_office;
    private String thana;
    private String district;
    private String mobile_no;
    private String fathers_name;
    private String filw_head_of_family;
    private Integer filw_isinlaw;
    private String filw_occupation;
    private String filw_house_no;
    private String filw_house_name;
    private String filw_road_name;
    private String filw_road_no;
    private String filw_house_owner;
    private String filw_moholla;
    private String filw_post_office;
    private String filw_thana;
    private String filw_district;
    private String filw_mobile_no;
    private String member_id;
    private String center_id;
    private String branch_id;

    public KYCRelativeBox() {
    }

    public KYCRelativeBox(KYCDMNew.Relative data) {
        this.name = data.getNAME();
        this.spouse_name = data.getSPOUSE_NAME();
        this.occupation = data.getOCCUPATION();
        this.relation = data.getRELATION();
        this.house_no = data.getHOUSE_NO();
        this.roadno = data.getROADNO();
        this.road_name = data.getROAD_NAME();
        this.houseo_wner = data.getHOUSEO_WNER();
        this.moholla = data.getMOHOLLA();
        this.post_office = data.getPOST_OFFICE();
        this.thana = data.getTHANA();
        this.district = data.getDISTRICT();
        this.mobile_no = data.getMOBILE_NO();
        this.fathers_name = data.getFATHERS_NAME();
        this.filw_head_of_family = data.getFILW_HEAD_OF_FAMILY();
        this.filw_isinlaw = data.getFILW_ISINLAW();
        this.filw_occupation = data.getFILW_OCCUPATION();
        this.filw_house_no = data.getFILW_HOUSE_NO();
        this.filw_house_name = data.getFILW_HOUSE_NAME();
        this.filw_road_name = data.getFILW_ROAD_NAME();
        this.filw_road_no = data.getFILW_ROAD_NO();
        this.filw_house_owner = data.getFILW_HOUSE_OWNER();
        this.filw_moholla = data.getFILW_MOHOLLA();
        this.filw_post_office = data.getFILW_POST_OFFICE();
        this.filw_thana = data.getFILW_THANA();
        this.filw_district = data.getFILW_DISTRICT();
        this.filw_mobile_no = data.getFILW_MOBILE_NO();
        this.member_id = data.getMEMBER_ID();
        this.center_id = data.getCENTER_ID();
        this.branch_id = data.getBRANCH_ID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpouse_name() {
        return spouse_name;
    }

    public void setSpouse_name(String spouse_name) {
        this.spouse_name = spouse_name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getHouse_no() {
        return house_no;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }

    public String getRoadno() {
        return roadno;
    }

    public void setRoadno(String roadno) {
        this.roadno = roadno;
    }

    public String getRoad_name() {
        return road_name;
    }

    public void setRoad_name(String road_name) {
        this.road_name = road_name;
    }

    public String getHouseo_wner() {
        return houseo_wner;
    }

    public void setHouseo_wner(String houseo_wner) {
        this.houseo_wner = houseo_wner;
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

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getFathers_name() {
        return fathers_name;
    }

    public void setFathers_name(String fathers_name) {
        this.fathers_name = fathers_name;
    }

    public String getFilw_head_of_family() {
        return filw_head_of_family;
    }

    public void setFilw_head_of_family(String filw_head_of_family) {
        this.filw_head_of_family = filw_head_of_family;
    }

    public Integer getFilw_isinlaw() {
        return filw_isinlaw;
    }

    public void setFilw_isinlaw(Integer filw_isinlaw) {
        this.filw_isinlaw = filw_isinlaw;
    }

    public String getFilw_occupation() {
        return filw_occupation;
    }

    public void setFilw_occupation(String filw_occupation) {
        this.filw_occupation = filw_occupation;
    }

    public String getFilw_house_no() {
        return filw_house_no;
    }

    public void setFilw_house_no(String filw_house_no) {
        this.filw_house_no = filw_house_no;
    }

    public String getFilw_house_name() {
        return filw_house_name;
    }

    public void setFilw_house_name(String filw_house_name) {
        this.filw_house_name = filw_house_name;
    }

    public String getFilw_road_name() {
        return filw_road_name;
    }

    public void setFilw_road_name(String filw_road_name) {
        this.filw_road_name = filw_road_name;
    }

    public String getFilw_road_no() {
        return filw_road_no;
    }

    public void setFilw_road_no(String filw_road_no) {
        this.filw_road_no = filw_road_no;
    }

    public String getFilw_house_owner() {
        return filw_house_owner;
    }

    public void setFilw_house_owner(String filw_house_owner) {
        this.filw_house_owner = filw_house_owner;
    }

    public String getFilw_moholla() {
        return filw_moholla;
    }

    public void setFilw_moholla(String filw_moholla) {
        this.filw_moholla = filw_moholla;
    }

    public String getFilw_post_office() {
        return filw_post_office;
    }

    public void setFilw_post_office(String filw_post_office) {
        this.filw_post_office = filw_post_office;
    }

    public String getFilw_thana() {
        return filw_thana;
    }

    public void setFilw_thana(String filw_thana) {
        this.filw_thana = filw_thana;
    }

    public String getFilw_district() {
        return filw_district;
    }

    public void setFilw_district(String filw_district) {
        this.filw_district = filw_district;
    }

    public String getFilw_mobile_no() {
        return filw_mobile_no;
    }

    public void setFilw_mobile_no(String filw_mobile_no) {
        this.filw_mobile_no = filw_mobile_no;
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
        return "KYCRelativeBox{" +
                "name='" + name + '\'' +
                ", spouse_name='" + spouse_name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", relation='" + relation + '\'' +
                ", house_no='" + house_no + '\'' +
                ", roadno='" + roadno + '\'' +
                ", road_name='" + road_name + '\'' +
                ", houseo_wner='" + houseo_wner + '\'' +
                ", moholla='" + moholla + '\'' +
                ", post_office='" + post_office + '\'' +
                ", thana='" + thana + '\'' +
                ", district='" + district + '\'' +
                ", mobile_no='" + mobile_no + '\'' +
                ", fathers_name='" + fathers_name + '\'' +
                ", filw_head_of_family='" + filw_head_of_family + '\'' +
                ", filw_isinlaw=" + filw_isinlaw +
                ", filw_occupation='" + filw_occupation + '\'' +
                ", filw_house_no='" + filw_house_no + '\'' +
                ", filw_house_name='" + filw_house_name + '\'' +
                ", filw_road_name='" + filw_road_name + '\'' +
                ", filw_road_no='" + filw_road_no + '\'' +
                ", filw_house_owner='" + filw_house_owner + '\'' +
                ", filw_moholla='" + filw_moholla + '\'' +
                ", filw_post_office='" + filw_post_office + '\'' +
                ", filw_thana='" + filw_thana + '\'' +
                ", filw_district='" + filw_district + '\'' +
                ", filw_mobile_no='" + filw_mobile_no + '\'' +
                ", member_id='" + member_id + '\'' +
                ", center_id='" + center_id + '\'' +
                ", branch_id='" + branch_id + '\'' +
                '}';
    }
}
