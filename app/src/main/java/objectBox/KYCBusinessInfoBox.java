package objectBox;

import java.io.Serializable;

import dataModelNew.KYCDMNew;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Atiar Talukdar on 7/24/2019.
 */

@Entity
public class KYCBusinessInfoBox implements Serializable {

    @Id
    long id;
    private String org_name;
    private String house_no;
    private String road_no;
    private String road_name;
    private String moholla;
    private String posto_ffice;
    private String thana;
    private String district;
    private String mobile_no;

    private String xorg_name;
    private String xhouseno;
    private String xroadno;
    private String xroadname;
    private String xmoholla;
    private String xpostoffice;
    private String xthana;
    private String xdistrict;
    private String xmobileno;

    private String member_id;
    private String center_id;
    private String branch_id;


    public KYCBusinessInfoBox() {
    }

    public KYCBusinessInfoBox(KYCDMNew.BusinessInfo data) {
        this.org_name = data.getORG_NAME();
        this.house_no = data.getHOUSE_NO();
        this.road_no = data.getROAD_NO();
        this.road_name = data.getROAD_NAME();
        this.moholla = data.getMOHOLLA();
        this.posto_ffice = data.getPOSTO_FFICE();
        this.thana = data.getTHANA();
        this.district = data.getDISTRICT();
        this.mobile_no = data.getMOBILE_NO();
        this.xorg_name = data.getXORG_NAME();
        this.xhouseno = data.getXHOUSENO();
        this.xroadno = data.getXROADNO();
        this.xroadname = data.getXROADNAME();
        this.xmoholla = data.getXMOHOLLA();
        this.xpostoffice = data.getXPOSTOFFICE();
        this.xthana = data.getXTHANA();
        this.xdistrict = data.getXDISTRICT();
        this.xmobileno = data.getXMOBILENO();
        this.member_id = data.getMEMBER_ID();
        this.center_id = data.getCENTER_ID();
        this.branch_id = data.getBRANCH_ID();
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
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

    public String getMoholla() {
        return moholla;
    }

    public void setMoholla(String moholla) {
        this.moholla = moholla;
    }

    public String getPosto_ffice() {
        return posto_ffice;
    }

    public void setPosto_ffice(String posto_ffice) {
        this.posto_ffice = posto_ffice;
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

    public String getXorg_name() {
        return xorg_name;
    }

    public void setXorg_name(String xorg_name) {
        this.xorg_name = xorg_name;
    }

    public String getXhouseno() {
        return xhouseno;
    }

    public void setXhouseno(String xhouseno) {
        this.xhouseno = xhouseno;
    }

    public String getXroadno() {
        return xroadno;
    }

    public void setXroadno(String xroadno) {
        this.xroadno = xroadno;
    }

    public String getXroadname() {
        return xroadname;
    }

    public void setXroadname(String xroadname) {
        this.xroadname = xroadname;
    }

    public String getXmoholla() {
        return xmoholla;
    }

    public void setXmoholla(String xmoholla) {
        this.xmoholla = xmoholla;
    }

    public String getXpostoffice() {
        return xpostoffice;
    }

    public void setXpostoffice(String xpostoffice) {
        this.xpostoffice = xpostoffice;
    }

    public String getXthana() {
        return xthana;
    }

    public void setXthana(String xthana) {
        this.xthana = xthana;
    }

    public String getXdistrict() {
        return xdistrict;
    }

    public void setXdistrict(String xdistrict) {
        this.xdistrict = xdistrict;
    }

    public String getXmobileno() {
        return xmobileno;
    }

    public void setXmobileno(String xmobileno) {
        this.xmobileno = xmobileno;
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
        return "KYCBusinessInfoBox{" +
                "org_name='" + org_name + '\'' +
                ", house_no='" + house_no + '\'' +
                ", road_no='" + road_no + '\'' +
                ", road_name='" + road_name + '\'' +
                ", moholla='" + moholla + '\'' +
                ", posto_ffice='" + posto_ffice + '\'' +
                ", thana='" + thana + '\'' +
                ", district='" + district + '\'' +
                ", mobile_no='" + mobile_no + '\'' +
                ", xorg_name='" + xorg_name + '\'' +
                ", xhouseno='" + xhouseno + '\'' +
                ", xroadno='" + xroadno + '\'' +
                ", xroadname='" + xroadname + '\'' +
                ", xmoholla='" + xmoholla + '\'' +
                ", xpostoffice='" + xpostoffice + '\'' +
                ", xthana='" + xthana + '\'' +
                ", xdistrict='" + xdistrict + '\'' +
                ", xmobileno='" + xmobileno + '\'' +
                ", member_id='" + member_id + '\'' +
                ", center_id='" + center_id + '\'' +
                ", branch_id='" + branch_id + '\'' +
                '}';
    }
}
