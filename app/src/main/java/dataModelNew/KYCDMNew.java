package dataModelNew;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KYCDMNew {
    @SerializedName("IsSuccessful")
    @Expose
    private Boolean isSuccessful;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Data")
    @Expose
    private Data data;

    public Boolean getIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    //=================== Public Classes =====================//

    public class Data {

        @SerializedName("MEMBER_ID")
        @Expose
        private Object mEMBER_ID;
        @SerializedName("BRANCH_ID")
        @Expose
        private Object bRANCH_ID;
        @SerializedName("PersonalInfo")
        @Expose
        private PersonalInfo personalInfo;
        @SerializedName("BusinessInfo")
        @Expose
        private BusinessInfo businessInfo;
        @SerializedName("BusinessDetail")
        @Expose
        private BusinessDetail businessDetail;
        @SerializedName("PermanentAddress")
        @Expose
        private PermanentAddress permanentAddress;
        @SerializedName("KYCPresentAddressActivity")
        @Expose
        private PresentAddress presentAddress;
        @SerializedName("FamilyMemberList")
        @Expose
        private List<FamilyMemberList> familyMemberList = null;
        @SerializedName("Relative")
        @Expose
        private Relative relative;

        public Object getMEMBER_ID() {
            return mEMBER_ID;
        }

        public void setMEMBER_ID(Object mEMBER_ID) {
            this.mEMBER_ID = mEMBER_ID;
        }

        public Object getBRANCH_ID() {
            return bRANCH_ID;
        }

        public void setBRANCH_ID(Object bRANCH_ID) {
            this.bRANCH_ID = bRANCH_ID;
        }

        public PersonalInfo getPersonalInfo() {
            return personalInfo;
        }

        public void setPersonalInfo(PersonalInfo personalInfo) {
            this.personalInfo = personalInfo;
        }

        public BusinessInfo getBusinessInfo() {
            return businessInfo;
        }

        public void setBusinessInfo(BusinessInfo businessInfo) {
            this.businessInfo = businessInfo;
        }

        public BusinessDetail getBusinessDetail() {
            return businessDetail;
        }

        public void setBusinessDetail(BusinessDetail businessDetail) {
            this.businessDetail = businessDetail;
        }

        public PermanentAddress getPermanentAddress() {
            return permanentAddress;
        }

        public void setPermanentAddress(PermanentAddress permanentAddress) {
            this.permanentAddress = permanentAddress;
        }

        public PresentAddress getPresentAddress() {
            return presentAddress;
        }

        public void setPresentAddress(PresentAddress presentAddress) {
            this.presentAddress = presentAddress;
        }

        public List<FamilyMemberList> getFamilyMemberList() {
            return familyMemberList;
        }

        public void setFamilyMemberList(List<FamilyMemberList> familyMemberList) {
            this.familyMemberList = familyMemberList;
        }

        public Relative getRelative() {
            return relative;
        }

        public void setRelative(Relative relative) {
            this.relative = relative;
        }

    }


    public class BusinessDetail {

        @SerializedName("PROD_NAME")
        @Expose
        private String pROD_NAME;
        @SerializedName("PROD_TYPE")
        @Expose
        private String pROD_TYPE;
        @SerializedName("CURRENT_EXP")
        @Expose
        private Integer cURRENT_EXP;
        @SerializedName("TOTALEXP")
        @Expose
        private Integer tOTALEXP;
        @SerializedName("BUSINESS_TYPE")
        @Expose
        private String bUSINESS_TYPE;
        @SerializedName("MALE_FT")
        @Expose
        private Integer mALE_FT;
        @SerializedName("MALE_PT")
        @Expose
        private Integer mALE_PT;
        @SerializedName("FEMAL_EFT")
        @Expose
        private Integer fEMAL_EFT;
        @SerializedName("FEMAL_EPT")
        @Expose
        private Integer fEMAL_EPT;
        @SerializedName("PLANE_DFT")
        @Expose
        private Integer pLANE_DFT;
        @SerializedName("PLANE_DPT")
        @Expose
        private Integer pLANE_DPT;
        @SerializedName("EMP_CHANGED")
        @Expose
        private Integer eMP_CHANGED;
        @SerializedName("IS_REDUCED")
        @Expose
        private Integer iS_REDUCED;
        @SerializedName("MEMBER_ID")
        @Expose
        private String mEMBER_ID;
        @SerializedName("CENTER_ID")
        @Expose
        private String cENTER_ID;
        @SerializedName("BRANCH_ID")
        @Expose
        private String bRANCH_ID;
        @SerializedName("TRAN_ID")
        @Expose
        private Integer tRAN_ID;
        @SerializedName("SET_DATE")
        @Expose
        private String sET_DATE;
        @SerializedName("SET_BY")
        @Expose
        private String sET_BY;
        @SerializedName("IS_ACTIVE")
        @Expose
        private Integer iS_ACTIVE;
        @SerializedName("IS_DELETED")
        @Expose
        private Integer iS_DELETED;

        public String getPROD_NAME() {
            return pROD_NAME;
        }

        public void setPROD_NAME(String pROD_NAME) {
            this.pROD_NAME = pROD_NAME;
        }

        public String getPROD_TYPE() {
            return pROD_TYPE;
        }

        public void setPROD_TYPE(String pROD_TYPE) {
            this.pROD_TYPE = pROD_TYPE;
        }

        public Integer getCURRENT_EXP() {
            return cURRENT_EXP;
        }

        public void setCURRENT_EXP(Integer cURRENT_EXP) {
            this.cURRENT_EXP = cURRENT_EXP;
        }

        public Integer getTOTALEXP() {
            return tOTALEXP;
        }

        public void setTOTALEXP(Integer tOTALEXP) {
            this.tOTALEXP = tOTALEXP;
        }

        public String getBUSINESS_TYPE() {
            return bUSINESS_TYPE;
        }

        public void setBUSINESS_TYPE(String bUSINESS_TYPE) {
            this.bUSINESS_TYPE = bUSINESS_TYPE;
        }

        public Integer getMALE_FT() {
            return mALE_FT;
        }

        public void setMALE_FT(Integer mALE_FT) {
            this.mALE_FT = mALE_FT;
        }

        public Integer getMALE_PT() {
            return mALE_PT;
        }

        public void setMALE_PT(Integer mALE_PT) {
            this.mALE_PT = mALE_PT;
        }

        public Integer getFEMAL_EFT() {
            return fEMAL_EFT;
        }

        public void setFEMAL_EFT(Integer fEMAL_EFT) {
            this.fEMAL_EFT = fEMAL_EFT;
        }

        public Integer getFEMAL_EPT() {
            return fEMAL_EPT;
        }

        public void setFEMAL_EPT(Integer fEMAL_EPT) {
            this.fEMAL_EPT = fEMAL_EPT;
        }

        public Integer getPLANE_DFT() {
            return pLANE_DFT;
        }

        public void setPLANE_DFT(Integer pLANE_DFT) {
            this.pLANE_DFT = pLANE_DFT;
        }

        public Integer getPLANE_DPT() {
            return pLANE_DPT;
        }

        public void setPLANE_DPT(Integer pLANE_DPT) {
            this.pLANE_DPT = pLANE_DPT;
        }

        public Integer getEMP_CHANGED() {
            return eMP_CHANGED;
        }

        public void setEMP_CHANGED(Integer eMP_CHANGED) {
            this.eMP_CHANGED = eMP_CHANGED;
        }

        public Integer getIS_REDUCED() {
            return iS_REDUCED;
        }

        public void setIS_REDUCED(Integer iS_REDUCED) {
            this.iS_REDUCED = iS_REDUCED;
        }

        public String getMEMBER_ID() {
            return mEMBER_ID;
        }

        public void setMEMBER_ID(String mEMBER_ID) {
            this.mEMBER_ID = mEMBER_ID;
        }

        public String getCENTER_ID() {
            return cENTER_ID;
        }

        public void setCENTER_ID(String cENTER_ID) {
            this.cENTER_ID = cENTER_ID;
        }

        public String getBRANCH_ID() {
            return bRANCH_ID;
        }

        public void setBRANCH_ID(String bRANCH_ID) {
            this.bRANCH_ID = bRANCH_ID;
        }

        public Integer getTRAN_ID() {
            return tRAN_ID;
        }

        public void setTRAN_ID(Integer tRAN_ID) {
            this.tRAN_ID = tRAN_ID;
        }

        public String getSET_DATE() {
            return sET_DATE;
        }

        public void setSET_DATE(String sET_DATE) {
            this.sET_DATE = sET_DATE;
        }

        public String getSET_BY() {
            return sET_BY;
        }

        public void setSET_BY(String sET_BY) {
            this.sET_BY = sET_BY;
        }

        public Integer getIS_ACTIVE() {
            return iS_ACTIVE;
        }

        public void setIS_ACTIVE(Integer iS_ACTIVE) {
            this.iS_ACTIVE = iS_ACTIVE;
        }

        public Integer getIS_DELETED() {
            return iS_DELETED;
        }

        public void setIS_DELETED(Integer iS_DELETED) {
            this.iS_DELETED = iS_DELETED;
        }

    }

    public class BusinessInfo {

        @SerializedName("ORG_NAME")
        @Expose
        private String oRG_NAME;
        @SerializedName("HOUSE_NO")
        @Expose
        private String hOUSE_NO;
        @SerializedName("ROAD_NO")
        @Expose
        private String rOAD_NO;
        @SerializedName("ROAD_NAME")
        @Expose
        private String rOAD_NAME;
        @SerializedName("MOHOLLA")
        @Expose
        private String mOHOLLA;
        @SerializedName("POSTO_FFICE")
        @Expose
        private String pOSTO_FFICE;
        @SerializedName("THANA")
        @Expose
        private String tHANA;
        @SerializedName("DISTRICT")
        @Expose
        private String dISTRICT;
        @SerializedName("MOBILE_NO")
        @Expose
        private String mOBILE_NO;
        @SerializedName("XORG_NAME")
        @Expose
        private String xORG_NAME;
        @SerializedName("XHOUSENO")
        @Expose
        private String xHOUSENO;
        @SerializedName("XROADNO")
        @Expose
        private String xROADNO;
        @SerializedName("XROADNAME")
        @Expose
        private String xROADNAME;
        @SerializedName("XMOHOLLA")
        @Expose
        private String xMOHOLLA;
        @SerializedName("XPOSTOFFICE")
        @Expose
        private String xPOSTOFFICE;
        @SerializedName("XTHANA")
        @Expose
        private String xTHANA;
        @SerializedName("XDISTRICT")
        @Expose
        private String xDISTRICT;
        @SerializedName("XMOBILENO")
        @Expose
        private String xMOBILENO;
        @SerializedName("MEMBER_ID")
        @Expose
        private String mEMBER_ID;
        @SerializedName("CENTER_ID")
        @Expose
        private String cENTER_ID;
        @SerializedName("BRANCH_ID")
        @Expose
        private String bRANCH_ID;
        @SerializedName("TRAN_ID")
        @Expose
        private Integer tRAN_ID;
        @SerializedName("SET_DATE")
        @Expose
        private String sET_DATE;
        @SerializedName("SET_BY")
        @Expose
        private String sET_BY;
        @SerializedName("IS_ACTIVE")
        @Expose
        private Integer iS_ACTIVE;
        @SerializedName("IS_DELETED")
        @Expose
        private Integer iS_DELETED;

        public String getORG_NAME() {
            return oRG_NAME;
        }

        public void setORG_NAME(String oRG_NAME) {
            this.oRG_NAME = oRG_NAME;
        }

        public String getHOUSE_NO() {
            return hOUSE_NO;
        }

        public void setHOUSE_NO(String hOUSE_NO) {
            this.hOUSE_NO = hOUSE_NO;
        }

        public String getROAD_NO() {
            return rOAD_NO;
        }

        public void setROAD_NO(String rOAD_NO) {
            this.rOAD_NO = rOAD_NO;
        }

        public String getROAD_NAME() {
            return rOAD_NAME;
        }

        public void setROAD_NAME(String rOAD_NAME) {
            this.rOAD_NAME = rOAD_NAME;
        }

        public String getMOHOLLA() {
            return mOHOLLA;
        }

        public void setMOHOLLA(String mOHOLLA) {
            this.mOHOLLA = mOHOLLA;
        }

        public String getPOSTO_FFICE() {
            return pOSTO_FFICE;
        }

        public void setPOSTO_FFICE(String pOSTO_FFICE) {
            this.pOSTO_FFICE = pOSTO_FFICE;
        }

        public String getTHANA() {
            return tHANA;
        }

        public void setTHANA(String tHANA) {
            this.tHANA = tHANA;
        }

        public String getDISTRICT() {
            return dISTRICT;
        }

        public void setDISTRICT(String dISTRICT) {
            this.dISTRICT = dISTRICT;
        }

        public String getMOBILE_NO() {
            return mOBILE_NO;
        }

        public void setMOBILE_NO(String mOBILE_NO) {
            this.mOBILE_NO = mOBILE_NO;
        }

        public String getXORG_NAME() {
            return xORG_NAME;
        }

        public void setXORG_NAME(String xORG_NAME) {
            this.xORG_NAME = xORG_NAME;
        }

        public String getXHOUSENO() {
            return xHOUSENO;
        }

        public void setXHOUSENO(String xHOUSENO) {
            this.xHOUSENO = xHOUSENO;
        }

        public String getXROADNO() {
            return xROADNO;
        }

        public void setXROADNO(String xROADNO) {
            this.xROADNO = xROADNO;
        }

        public String getXROADNAME() {
            return xROADNAME;
        }

        public void setXROADNAME(String xROADNAME) {
            this.xROADNAME = xROADNAME;
        }

        public String getXMOHOLLA() {
            return xMOHOLLA;
        }

        public void setXMOHOLLA(String xMOHOLLA) {
            this.xMOHOLLA = xMOHOLLA;
        }

        public String getXPOSTOFFICE() {
            return xPOSTOFFICE;
        }

        public void setXPOSTOFFICE(String xPOSTOFFICE) {
            this.xPOSTOFFICE = xPOSTOFFICE;
        }

        public String getXTHANA() {
            return xTHANA;
        }

        public void setXTHANA(String xTHANA) {
            this.xTHANA = xTHANA;
        }

        public String getXDISTRICT() {
            return xDISTRICT;
        }

        public void setXDISTRICT(String xDISTRICT) {
            this.xDISTRICT = xDISTRICT;
        }

        public String getXMOBILENO() {
            return xMOBILENO;
        }

        public void setXMOBILENO(String xMOBILENO) {
            this.xMOBILENO = xMOBILENO;
        }

        public String getMEMBER_ID() {
            return mEMBER_ID;
        }

        public void setMEMBER_ID(String mEMBER_ID) {
            this.mEMBER_ID = mEMBER_ID;
        }

        public String getCENTER_ID() {
            return cENTER_ID;
        }

        public void setCENTER_ID(String cENTER_ID) {
            this.cENTER_ID = cENTER_ID;
        }

        public String getBRANCH_ID() {
            return bRANCH_ID;
        }

        public void setBRANCH_ID(String bRANCH_ID) {
            this.bRANCH_ID = bRANCH_ID;
        }

        public Integer getTRAN_ID() {
            return tRAN_ID;
        }

        public void setTRAN_ID(Integer tRAN_ID) {
            this.tRAN_ID = tRAN_ID;
        }

        public String getSET_DATE() {
            return sET_DATE;
        }

        public void setSET_DATE(String sET_DATE) {
            this.sET_DATE = sET_DATE;
        }

        public String getSET_BY() {
            return sET_BY;
        }

        public void setSET_BY(String sET_BY) {
            this.sET_BY = sET_BY;
        }

        public Integer getIS_ACTIVE() {
            return iS_ACTIVE;
        }

        public void setIS_ACTIVE(Integer iS_ACTIVE) {
            this.iS_ACTIVE = iS_ACTIVE;
        }

        public Integer getIS_DELETED() {
            return iS_DELETED;
        }

        public void setIS_DELETED(Integer iS_DELETED) {
            this.iS_DELETED = iS_DELETED;
        }

    }

    public class FamilyMemberList {

        @SerializedName("FMNAME")
        @Expose
        private String fMNAME;
        @SerializedName("RELATION")
        @Expose
        private String rELATION;
        @SerializedName("AGE")
        @Expose
        private Integer aGE;
        @SerializedName("EDUCATION")
        @Expose
        private String eDUCATION;
        @SerializedName("ISMARRIED")
        @Expose
        private Integer iSMARRIED;
        @SerializedName("OCCUPATION")
        @Expose
        private String oCCUPATION;
        @SerializedName("MEMBER_ID")
        @Expose
        private String mEMBER_ID;
        @SerializedName("CENTER_ID")
        @Expose
        private String cENTER_ID;
        @SerializedName("BRANCH_ID")
        @Expose
        private String bRANCH_ID;
        @SerializedName("TRAN_ID")
        @Expose
        private Integer tRAN_ID;
        @SerializedName("SET_DATE")
        @Expose
        private String sET_DATE;
        @SerializedName("SET_BY")
        @Expose
        private String sET_BY;
        @SerializedName("IS_ACTIVE")
        @Expose
        private Integer iS_ACTIVE;
        @SerializedName("IS_DELETED")
        @Expose
        private Integer iS_DELETED;

        public String getFMNAME() {
            return fMNAME;
        }

        public void setFMNAME(String fMNAME) {
            this.fMNAME = fMNAME;
        }

        public String getRELATION() {
            return rELATION;
        }

        public void setRELATION(String rELATION) {
            this.rELATION = rELATION;
        }

        public Integer getAGE() {
            return aGE;
        }

        public void setAGE(Integer aGE) {
            this.aGE = aGE;
        }

        public String getEDUCATION() {
            return eDUCATION;
        }

        public void setEDUCATION(String eDUCATION) {
            this.eDUCATION = eDUCATION;
        }

        public Integer getISMARRIED() {
            return iSMARRIED;
        }

        public void setISMARRIED(Integer iSMARRIED) {
            this.iSMARRIED = iSMARRIED;
        }

        public String getOCCUPATION() {
            return oCCUPATION;
        }

        public void setOCCUPATION(String oCCUPATION) {
            this.oCCUPATION = oCCUPATION;
        }

        public String getMEMBER_ID() {
            return mEMBER_ID;
        }

        public void setMEMBER_ID(String mEMBER_ID) {
            this.mEMBER_ID = mEMBER_ID;
        }

        public String getCENTER_ID() {
            return cENTER_ID;
        }

        public void setCENTER_ID(String cENTER_ID) {
            this.cENTER_ID = cENTER_ID;
        }

        public String getBRANCH_ID() {
            return bRANCH_ID;
        }

        public void setBRANCH_ID(String bRANCH_ID) {
            this.bRANCH_ID = bRANCH_ID;
        }

        public Integer getTRAN_ID() {
            return tRAN_ID;
        }

        public void setTRAN_ID(Integer tRAN_ID) {
            this.tRAN_ID = tRAN_ID;
        }

        public String getSET_DATE() {
            return sET_DATE;
        }

        public void setSET_DATE(String sET_DATE) {
            this.sET_DATE = sET_DATE;
        }

        public String getSET_BY() {
            return sET_BY;
        }

        public void setSET_BY(String sET_BY) {
            this.sET_BY = sET_BY;
        }

        public Integer getIS_ACTIVE() {
            return iS_ACTIVE;
        }

        public void setIS_ACTIVE(Integer iS_ACTIVE) {
            this.iS_ACTIVE = iS_ACTIVE;
        }

        public Integer getIS_DELETED() {
            return iS_DELETED;
        }

        public void setIS_DELETED(Integer iS_DELETED) {
            this.iS_DELETED = iS_DELETED;
        }

    }

    public class PermanentAddress {

        @SerializedName("HOUSE_NO")
        @Expose
        private String hOUSE_NO;
        @SerializedName("ROAD_NO")
        @Expose
        private String rOAD_NO;
        @SerializedName("ROAD_NAME")
        @Expose
        private String rOAD_NAME;
        @SerializedName("HOUSE_OWNER")
        @Expose
        private String hOUSE_OWNER;
        @SerializedName("MOHOLLA")
        @Expose
        private String mOHOLLA;
        @SerializedName("POST_OFFICE")
        @Expose
        private String pOST_OFFICE;
        @SerializedName("THANA")
        @Expose
        private String tHANA;
        @SerializedName("DISTRICT")
        @Expose
        private String dISTRICT;
        @SerializedName("MEMBER_ID")
        @Expose
        private String mEMBER_ID;
        @SerializedName("CENTER_ID")
        @Expose
        private String cENTER_ID;
        @SerializedName("BRANCH_ID")
        @Expose
        private String bRANCH_ID;
        @SerializedName("TRAN_ID")
        @Expose
        private Integer tRAN_ID;
        @SerializedName("SET_DATE")
        @Expose
        private String sET_DATE;
        @SerializedName("SET_BY")
        @Expose
        private String sET_BY;
        @SerializedName("IS_ACTIVE")
        @Expose
        private Integer iS_ACTIVE;
        @SerializedName("IS_DELETED")
        @Expose
        private Integer iS_DELETED;

        public String getHOUSE_NO() {
            return hOUSE_NO;
        }

        public void setHOUSE_NO(String hOUSE_NO) {
            this.hOUSE_NO = hOUSE_NO;
        }

        public String getROAD_NO() {
            return rOAD_NO;
        }

        public void setROAD_NO(String rOAD_NO) {
            this.rOAD_NO = rOAD_NO;
        }

        public String getROAD_NAME() {
            return rOAD_NAME;
        }

        public void setROAD_NAME(String rOAD_NAME) {
            this.rOAD_NAME = rOAD_NAME;
        }

        public String getHOUSE_OWNER() {
            return hOUSE_OWNER;
        }

        public void setHOUSE_OWNER(String hOUSE_OWNER) {
            this.hOUSE_OWNER = hOUSE_OWNER;
        }

        public String getMOHOLLA() {
            return mOHOLLA;
        }

        public void setMOHOLLA(String mOHOLLA) {
            this.mOHOLLA = mOHOLLA;
        }

        public String getPOST_OFFICE() {
            return pOST_OFFICE;
        }

        public void setPOST_OFFICE(String pOST_OFFICE) {
            this.pOST_OFFICE = pOST_OFFICE;
        }

        public String getTHANA() {
            return tHANA;
        }

        public void setTHANA(String tHANA) {
            this.tHANA = tHANA;
        }

        public String getDISTRICT() {
            return dISTRICT;
        }

        public void setDISTRICT(String dISTRICT) {
            this.dISTRICT = dISTRICT;
        }

        public String getMEMBER_ID() {
            return mEMBER_ID;
        }

        public void setMEMBER_ID(String mEMBER_ID) {
            this.mEMBER_ID = mEMBER_ID;
        }

        public String getCENTER_ID() {
            return cENTER_ID;
        }

        public void setCENTER_ID(String cENTER_ID) {
            this.cENTER_ID = cENTER_ID;
        }

        public String getBRANCH_ID() {
            return bRANCH_ID;
        }

        public void setBRANCH_ID(String bRANCH_ID) {
            this.bRANCH_ID = bRANCH_ID;
        }

        public Integer getTRAN_ID() {
            return tRAN_ID;
        }

        public void setTRAN_ID(Integer tRAN_ID) {
            this.tRAN_ID = tRAN_ID;
        }

        public String getSET_DATE() {
            return sET_DATE;
        }

        public void setSET_DATE(String sET_DATE) {
            this.sET_DATE = sET_DATE;
        }

        public String getSET_BY() {
            return sET_BY;
        }

        public void setSET_BY(String sET_BY) {
            this.sET_BY = sET_BY;
        }

        public Integer getIS_ACTIVE() {
            return iS_ACTIVE;
        }

        public void setIS_ACTIVE(Integer iS_ACTIVE) {
            this.iS_ACTIVE = iS_ACTIVE;
        }

        public Integer getIS_DELETED() {
            return iS_DELETED;
        }

        public void setIS_DELETED(Integer iS_DELETED) {
            this.iS_DELETED = iS_DELETED;
        }

    }

    public class PersonalInfo {

        @SerializedName("MEMBER_NAME")
        @Expose
        private String mEMBER_NAME;
        @SerializedName("DATE_OF_BIRTH")
        @Expose
        private String dATE_OF_BIRTH;
        @SerializedName("EXPERIENCE")
        @Expose
        private Integer eXPERIENCE;
        @SerializedName("EDUCATION")
        @Expose
        private String eDUCATION;
        @SerializedName("SPOUSE_NAME")
        @Expose
        private String sPOUSE_NAME;
        @SerializedName("FATHERS_NAME")
        @Expose
        private String fATHERS_NAME;
        @SerializedName("MOTHERS_NAME")
        @Expose
        private String mOTHERS_NAME;
        @SerializedName("NATIONALITY")
        @Expose
        private String nATIONALITY;
        @SerializedName("NATIONAL_ID")
        @Expose
        private String nATIONAL_ID;
        @SerializedName("MOBILE_NO")
        @Expose
        private String mOBILE_NO;
        @SerializedName("BREADWINNER")
        @Expose
        private String bREADWINNER;
        @SerializedName("RELATION")
        @Expose
        private String rELATION;
        @SerializedName("OCCUPATION")
        @Expose
        private String oCCUPATION;
        @SerializedName("DRIVINGLICENSE")
        @Expose
        private String dRIVINGLICENSE;
        @SerializedName("PASSPORT_NO")
        @Expose
        private String pASSPORT_NO;
        @SerializedName("MOBILENO2")
        @Expose
        private String mOBILENO2;
        @SerializedName("MEMBER_ID")
        @Expose
        private String mEMBER_ID;
        @SerializedName("CENTER_ID")
        @Expose
        private String cENTER_ID;
        @SerializedName("BRANCH_ID")
        @Expose
        private String bRANCH_ID;
        @SerializedName("TRAN_ID")
        @Expose
        private Integer tRAN_ID;
        @SerializedName("SET_DATE")
        @Expose
        private String sET_DATE;
        @SerializedName("SET_BY")
        @Expose
        private String sET_BY;
        @SerializedName("IS_ACTIVE")
        @Expose
        private Integer iS_ACTIVE;
        @SerializedName("IS_DELETED")
        @Expose
        private Integer iS_DELETED;

        public String getMEMBER_NAME() {
            return mEMBER_NAME;
        }

        public void setMEMBER_NAME(String mEMBER_NAME) {
            this.mEMBER_NAME = mEMBER_NAME;
        }

        public String getDATE_OF_BIRTH() {
            return dATE_OF_BIRTH;
        }

        public void setDATE_OF_BIRTH(String dATE_OF_BIRTH) {
            this.dATE_OF_BIRTH = dATE_OF_BIRTH;
        }

        public Integer getEXPERIENCE() {
            return eXPERIENCE;
        }

        public void setEXPERIENCE(Integer eXPERIENCE) {
            this.eXPERIENCE = eXPERIENCE;
        }

        public String getEDUCATION() {
            return eDUCATION;
        }

        public void setEDUCATION(String eDUCATION) {
            this.eDUCATION = eDUCATION;
        }

        public String getSPOUSE_NAME() {
            return sPOUSE_NAME;
        }

        public void setSPOUSE_NAME(String sPOUSE_NAME) {
            this.sPOUSE_NAME = sPOUSE_NAME;
        }

        public String getFATHERS_NAME() {
            return fATHERS_NAME;
        }

        public void setFATHERS_NAME(String fATHERS_NAME) {
            this.fATHERS_NAME = fATHERS_NAME;
        }

        public String getMOTHERS_NAME() {
            return mOTHERS_NAME;
        }

        public void setMOTHERS_NAME(String mOTHERS_NAME) {
            this.mOTHERS_NAME = mOTHERS_NAME;
        }

        public String getNATIONALITY() {
            return nATIONALITY;
        }

        public void setNATIONALITY(String nATIONALITY) {
            this.nATIONALITY = nATIONALITY;
        }

        public String getNATIONAL_ID() {
            return nATIONAL_ID;
        }

        public void setNATIONAL_ID(String nATIONAL_ID) {
            this.nATIONAL_ID = nATIONAL_ID;
        }

        public String getMOBILE_NO() {
            return mOBILE_NO;
        }

        public void setMOBILE_NO(String mOBILE_NO) {
            this.mOBILE_NO = mOBILE_NO;
        }

        public String getBREADWINNER() {
            return bREADWINNER;
        }

        public void setBREADWINNER(String bREADWINNER) {
            this.bREADWINNER = bREADWINNER;
        }

        public String getRELATION() {
            return rELATION;
        }

        public void setRELATION(String rELATION) {
            this.rELATION = rELATION;
        }

        public String getOCCUPATION() {
            return oCCUPATION;
        }

        public void setOCCUPATION(String oCCUPATION) {
            this.oCCUPATION = oCCUPATION;
        }

        public String getDRIVINGLICENSE() {
            return dRIVINGLICENSE;
        }

        public void setDRIVINGLICENSE(String dRIVINGLICENSE) {
            this.dRIVINGLICENSE = dRIVINGLICENSE;
        }

        public String getPASSPORT_NO() {
            return pASSPORT_NO;
        }

        public void setPASSPORT_NO(String pASSPORT_NO) {
            this.pASSPORT_NO = pASSPORT_NO;
        }

        public String getMOBILENO2() {
            return mOBILENO2;
        }

        public void setMOBILENO2(String mOBILENO2) {
            this.mOBILENO2 = mOBILENO2;
        }

        public String getMEMBER_ID() {
            return mEMBER_ID;
        }

        public void setMEMBER_ID(String mEMBER_ID) {
            this.mEMBER_ID = mEMBER_ID;
        }

        public String getCENTER_ID() {
            return cENTER_ID;
        }

        public void setCENTER_ID(String cENTER_ID) {
            this.cENTER_ID = cENTER_ID;
        }

        public String getBRANCH_ID() {
            return bRANCH_ID;
        }

        public void setBRANCH_ID(String bRANCH_ID) {
            this.bRANCH_ID = bRANCH_ID;
        }

        public Integer getTRAN_ID() {
            return tRAN_ID;
        }

        public void setTRAN_ID(Integer tRAN_ID) {
            this.tRAN_ID = tRAN_ID;
        }

        public String getSET_DATE() {
            return sET_DATE;
        }

        public void setSET_DATE(String sET_DATE) {
            this.sET_DATE = sET_DATE;
        }

        public String getSET_BY() {
            return sET_BY;
        }

        public void setSET_BY(String sET_BY) {
            this.sET_BY = sET_BY;
        }

        public Integer getIS_ACTIVE() {
            return iS_ACTIVE;
        }

        public void setIS_ACTIVE(Integer iS_ACTIVE) {
            this.iS_ACTIVE = iS_ACTIVE;
        }

        public Integer getIS_DELETED() {
            return iS_DELETED;
        }

        public void setIS_DELETED(Integer iS_DELETED) {
            this.iS_DELETED = iS_DELETED;
        }

    }

    public class PresentAddress {

        @SerializedName("HOUSE_NO")
        @Expose
        private String hOUSE_NO;
        @SerializedName("ROAD_NO")
        @Expose
        private String rOAD_NO;
        @SerializedName("ROAD_NAME")
        @Expose
        private String rOAD_NAME;
        @SerializedName("HOUSE_OWNER")
        @Expose
        private String hOUSE_OWNER;
        @SerializedName("MOHOLLA")
        @Expose
        private String mOHOLLA;
        @SerializedName("POST_OFFICE")
        @Expose
        private String pOST_OFFICE;
        @SerializedName("THANA")
        @Expose
        private String tHANA;
        @SerializedName("DISTRICT")
        @Expose
        private String dISTRICT;
        @SerializedName("IS_OWNER")
        @Expose
        private Integer iS_OWNER;
        @SerializedName("DURATION_LIVESHERE")
        @Expose
        private Integer dURATION_LIVESHERE;
        @SerializedName("MEMBER_ID")
        @Expose
        private String mEMBER_ID;
        @SerializedName("CENTER_ID")
        @Expose
        private String cENTER_ID;
        @SerializedName("BRANCH_ID")
        @Expose
        private String bRANCH_ID;
        @SerializedName("TRAN_ID")
        @Expose
        private Integer tRAN_ID;
        @SerializedName("SET_DATE")
        @Expose
        private String sET_DATE;
        @SerializedName("SET_BY")
        @Expose
        private String sET_BY;
        @SerializedName("IS_ACTIVE")
        @Expose
        private Integer iS_ACTIVE;
        @SerializedName("IS_DELETED")
        @Expose
        private Integer iS_DELETED;

        public String getHOUSE_NO() {
            return hOUSE_NO;
        }

        public void setHOUSE_NO(String hOUSE_NO) {
            this.hOUSE_NO = hOUSE_NO;
        }

        public String getROAD_NO() {
            return rOAD_NO;
        }

        public void setROAD_NO(String rOAD_NO) {
            this.rOAD_NO = rOAD_NO;
        }

        public String getROAD_NAME() {
            return rOAD_NAME;
        }

        public void setROAD_NAME(String rOAD_NAME) {
            this.rOAD_NAME = rOAD_NAME;
        }

        public String getHOUSE_OWNER() {
            return hOUSE_OWNER;
        }

        public void setHOUSE_OWNER(String hOUSE_OWNER) {
            this.hOUSE_OWNER = hOUSE_OWNER;
        }

        public String getMOHOLLA() {
            return mOHOLLA;
        }

        public void setMOHOLLA(String mOHOLLA) {
            this.mOHOLLA = mOHOLLA;
        }

        public String getPOST_OFFICE() {
            return pOST_OFFICE;
        }

        public void setPOST_OFFICE(String pOST_OFFICE) {
            this.pOST_OFFICE = pOST_OFFICE;
        }

        public String getTHANA() {
            return tHANA;
        }

        public void setTHANA(String tHANA) {
            this.tHANA = tHANA;
        }

        public String getDISTRICT() {
            return dISTRICT;
        }

        public void setDISTRICT(String dISTRICT) {
            this.dISTRICT = dISTRICT;
        }

        public Integer getIS_OWNER() {
            return iS_OWNER;
        }

        public void setIS_OWNER(Integer iS_OWNER) {
            this.iS_OWNER = iS_OWNER;
        }

        public Integer getDURATION_LIVESHERE() {
            return dURATION_LIVESHERE;
        }

        public void setDURATION_LIVESHERE(Integer dURATION_LIVESHERE) {
            this.dURATION_LIVESHERE = dURATION_LIVESHERE;
        }

        public String getMEMBER_ID() {
            return mEMBER_ID;
        }

        public void setMEMBER_ID(String mEMBER_ID) {
            this.mEMBER_ID = mEMBER_ID;
        }

        public String getCENTER_ID() {
            return cENTER_ID;
        }

        public void setCENTER_ID(String cENTER_ID) {
            this.cENTER_ID = cENTER_ID;
        }

        public String getBRANCH_ID() {
            return bRANCH_ID;
        }

        public void setBRANCH_ID(String bRANCH_ID) {
            this.bRANCH_ID = bRANCH_ID;
        }

        public Integer getTRAN_ID() {
            return tRAN_ID;
        }

        public void setTRAN_ID(Integer tRAN_ID) {
            this.tRAN_ID = tRAN_ID;
        }

        public String getSET_DATE() {
            return sET_DATE;
        }

        public void setSET_DATE(String sET_DATE) {
            this.sET_DATE = sET_DATE;
        }

        public String getSET_BY() {
            return sET_BY;
        }

        public void setSET_BY(String sET_BY) {
            this.sET_BY = sET_BY;
        }

        public Integer getIS_ACTIVE() {
            return iS_ACTIVE;
        }

        public void setIS_ACTIVE(Integer iS_ACTIVE) {
            this.iS_ACTIVE = iS_ACTIVE;
        }

        public Integer getIS_DELETED() {
            return iS_DELETED;
        }

        public void setIS_DELETED(Integer iS_DELETED) {
            this.iS_DELETED = iS_DELETED;
        }

    }

    public class Relative {

        @SerializedName("NAME")
        @Expose
        private String nAME;
        @SerializedName("SPOUSE_NAME")
        @Expose
        private String sPOUSE_NAME;
        @SerializedName("OCCUPATION")
        @Expose
        private String oCCUPATION;
        @SerializedName("RELATION")
        @Expose
        private String rELATION;
        @SerializedName("HOUSE_NO")
        @Expose
        private String hOUSE_NO;
        @SerializedName("ROADNO")
        @Expose
        private String rOADNO;
        @SerializedName("ROAD_NAME")
        @Expose
        private String rOAD_NAME;
        @SerializedName("HOUSEO_WNER")
        @Expose
        private String hOUSEO_WNER;
        @SerializedName("MOHOLLA")
        @Expose
        private String mOHOLLA;
        @SerializedName("POST_OFFICE")
        @Expose
        private String pOST_OFFICE;
        @SerializedName("THANA")
        @Expose
        private String tHANA;
        @SerializedName("DISTRICT")
        @Expose
        private String dISTRICT;
        @SerializedName("MOBILE_NO")
        @Expose
        private String mOBILE_NO;
        @SerializedName("FATHERS_NAME")
        @Expose
        private String fATHERS_NAME;
        @SerializedName("FILW_HEAD_OF_FAMILY")
        @Expose
        private String fILW_HEAD_OF_FAMILY;
        @SerializedName("FILW_ISINLAW")
        @Expose
        private Integer fILW_ISINLAW;
        @SerializedName("FILW_OCCUPATION")
        @Expose
        private String fILW_OCCUPATION;
        @SerializedName("FILW_HOUSE_NO")
        @Expose
        private String fILW_HOUSE_NO;
        @SerializedName("FILW_HOUSE_NAME")
        @Expose
        private String fILW_HOUSE_NAME;
        @SerializedName("FILW_ROAD_NAME")
        @Expose
        private String fILW_ROAD_NAME;
        @SerializedName("FILW_ROAD_NO")
        @Expose
        private String fILW_ROAD_NO;
        @SerializedName("FILW_HOUSE_OWNER")
        @Expose
        private String fILW_HOUSE_OWNER;
        @SerializedName("FILW_MOHOLLA")
        @Expose
        private String fILW_MOHOLLA;
        @SerializedName("FILW_POST_OFFICE")
        @Expose
        private String fILW_POST_OFFICE;
        @SerializedName("FILW_THANA")
        @Expose
        private String fILW_THANA;
        @SerializedName("FILW_DISTRICT")
        @Expose
        private String fILW_DISTRICT;
        @SerializedName("FILW_MOBILE_NO")
        @Expose
        private String fILW_MOBILE_NO;
        @SerializedName("MEMBER_ID")
        @Expose
        private String mEMBER_ID;
        @SerializedName("CENTER_ID")
        @Expose
        private String cENTER_ID;
        @SerializedName("BRANCH_ID")
        @Expose
        private String bRANCH_ID;
        @SerializedName("TRAN_ID")
        @Expose
        private Integer tRAN_ID;
        @SerializedName("SET_DATE")
        @Expose
        private String sET_DATE;
        @SerializedName("SET_BY")
        @Expose
        private String sET_BY;
        @SerializedName("IS_ACTIVE")
        @Expose
        private Integer iS_ACTIVE;
        @SerializedName("IS_DELETED")
        @Expose
        private Integer iS_DELETED;

        public String getNAME() {
            return nAME;
        }

        public void setNAME(String nAME) {
            this.nAME = nAME;
        }

        public String getSPOUSE_NAME() {
            return sPOUSE_NAME;
        }

        public void setSPOUSE_NAME(String sPOUSE_NAME) {
            this.sPOUSE_NAME = sPOUSE_NAME;
        }

        public String getOCCUPATION() {
            return oCCUPATION;
        }

        public void setOCCUPATION(String oCCUPATION) {
            this.oCCUPATION = oCCUPATION;
        }

        public String getRELATION() {
            return rELATION;
        }

        public void setRELATION(String rELATION) {
            this.rELATION = rELATION;
        }

        public String getHOUSE_NO() {
            return hOUSE_NO;
        }

        public void setHOUSE_NO(String hOUSE_NO) {
            this.hOUSE_NO = hOUSE_NO;
        }

        public String getROADNO() {
            return rOADNO;
        }

        public void setROADNO(String rOADNO) {
            this.rOADNO = rOADNO;
        }

        public String getROAD_NAME() {
            return rOAD_NAME;
        }

        public void setROAD_NAME(String rOAD_NAME) {
            this.rOAD_NAME = rOAD_NAME;
        }

        public String getHOUSEO_WNER() {
            return hOUSEO_WNER;
        }

        public void setHOUSEO_WNER(String hOUSEO_WNER) {
            this.hOUSEO_WNER = hOUSEO_WNER;
        }

        public String getMOHOLLA() {
            return mOHOLLA;
        }

        public void setMOHOLLA(String mOHOLLA) {
            this.mOHOLLA = mOHOLLA;
        }

        public String getPOST_OFFICE() {
            return pOST_OFFICE;
        }

        public void setPOST_OFFICE(String pOST_OFFICE) {
            this.pOST_OFFICE = pOST_OFFICE;
        }

        public String getTHANA() {
            return tHANA;
        }

        public void setTHANA(String tHANA) {
            this.tHANA = tHANA;
        }

        public String getDISTRICT() {
            return dISTRICT;
        }

        public void setDISTRICT(String dISTRICT) {
            this.dISTRICT = dISTRICT;
        }

        public String getMOBILE_NO() {
            return mOBILE_NO;
        }

        public void setMOBILE_NO(String mOBILE_NO) {
            this.mOBILE_NO = mOBILE_NO;
        }

        public String getFATHERS_NAME() {
            return fATHERS_NAME;
        }

        public void setFATHERS_NAME(String fATHERS_NAME) {
            this.fATHERS_NAME = fATHERS_NAME;
        }

        public String getFILW_HEAD_OF_FAMILY() {
            return fILW_HEAD_OF_FAMILY;
        }

        public void setFILW_HEAD_OF_FAMILY(String fILW_HEAD_OF_FAMILY) {
            this.fILW_HEAD_OF_FAMILY = fILW_HEAD_OF_FAMILY;
        }

        public Integer getFILW_ISINLAW() {
            return fILW_ISINLAW;
        }

        public void setFILW_ISINLAW(Integer fILW_ISINLAW) {
            this.fILW_ISINLAW = fILW_ISINLAW;
        }

        public String getFILW_OCCUPATION() {
            return fILW_OCCUPATION;
        }

        public void setFILW_OCCUPATION(String fILW_OCCUPATION) {
            this.fILW_OCCUPATION = fILW_OCCUPATION;
        }

        public String getFILW_HOUSE_NO() {
            return fILW_HOUSE_NO;
        }

        public void setFILW_HOUSE_NO(String fILW_HOUSE_NO) {
            this.fILW_HOUSE_NO = fILW_HOUSE_NO;
        }

        public String getFILW_HOUSE_NAME() {
            return fILW_HOUSE_NAME;
        }

        public void setFILW_HOUSE_NAME(String fILW_HOUSE_NAME) {
            this.fILW_HOUSE_NAME = fILW_HOUSE_NAME;
        }

        public String getFILW_ROAD_NAME() {
            return fILW_ROAD_NAME;
        }

        public void setFILW_ROAD_NAME(String fILW_ROAD_NAME) {
            this.fILW_ROAD_NAME = fILW_ROAD_NAME;
        }

        public String getFILW_ROAD_NO() {
            return fILW_ROAD_NO;
        }

        public void setFILW_ROAD_NO(String fILW_ROAD_NO) {
            this.fILW_ROAD_NO = fILW_ROAD_NO;
        }

        public String getFILW_HOUSE_OWNER() {
            return fILW_HOUSE_OWNER;
        }

        public void setFILW_HOUSE_OWNER(String fILW_HOUSE_OWNER) {
            this.fILW_HOUSE_OWNER = fILW_HOUSE_OWNER;
        }

        public String getFILW_MOHOLLA() {
            return fILW_MOHOLLA;
        }

        public void setFILW_MOHOLLA(String fILW_MOHOLLA) {
            this.fILW_MOHOLLA = fILW_MOHOLLA;
        }

        public String getFILW_POST_OFFICE() {
            return fILW_POST_OFFICE;
        }

        public void setFILW_POST_OFFICE(String fILW_POST_OFFICE) {
            this.fILW_POST_OFFICE = fILW_POST_OFFICE;
        }

        public String getFILW_THANA() {
            return fILW_THANA;
        }

        public void setFILW_THANA(String fILW_THANA) {
            this.fILW_THANA = fILW_THANA;
        }

        public String getFILW_DISTRICT() {
            return fILW_DISTRICT;
        }

        public void setFILW_DISTRICT(String fILW_DISTRICT) {
            this.fILW_DISTRICT = fILW_DISTRICT;
        }

        public String getFILW_MOBILE_NO() {
            return fILW_MOBILE_NO;
        }

        public void setFILW_MOBILE_NO(String fILW_MOBILE_NO) {
            this.fILW_MOBILE_NO = fILW_MOBILE_NO;
        }

        public String getMEMBER_ID() {
            return mEMBER_ID;
        }

        public void setMEMBER_ID(String mEMBER_ID) {
            this.mEMBER_ID = mEMBER_ID;
        }

        public String getCENTER_ID() {
            return cENTER_ID;
        }

        public void setCENTER_ID(String cENTER_ID) {
            this.cENTER_ID = cENTER_ID;
        }

        public String getBRANCH_ID() {
            return bRANCH_ID;
        }

        public void setBRANCH_ID(String bRANCH_ID) {
            this.bRANCH_ID = bRANCH_ID;
        }

        public Integer getTRAN_ID() {
            return tRAN_ID;
        }

        public void setTRAN_ID(Integer tRAN_ID) {
            this.tRAN_ID = tRAN_ID;
        }

        public String getSET_DATE() {
            return sET_DATE;
        }

        public void setSET_DATE(String sET_DATE) {
            this.sET_DATE = sET_DATE;
        }

        public String getSET_BY() {
            return sET_BY;
        }

        public void setSET_BY(String sET_BY) {
            this.sET_BY = sET_BY;
        }

        public Integer getIS_ACTIVE() {
            return iS_ACTIVE;
        }

        public void setIS_ACTIVE(Integer iS_ACTIVE) {
            this.iS_ACTIVE = iS_ACTIVE;
        }

        public Integer getIS_DELETED() {
            return iS_DELETED;
        }

        public void setIS_DELETED(Integer iS_DELETED) {
            this.iS_DELETED = iS_DELETED;
        }

    }
}