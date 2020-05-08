package dataModelForUpload;

import java.util.List;

import objectBox.KYCBusinessDetailBox;
import objectBox.KYCBusinessInfoBox;
import objectBox.KYCFamilyMemberBox;
import objectBox.KYCPermanentAddressBox;
import objectBox.KYCPersonalInfoBox;
import objectBox.KYCPresentAddressBox;
import objectBox.KYCRelativeBox;

public class KYCDM {

    private String MEMBER_ID;
    private String BRANCH_ID;
    private String CENTER_ID;

    private KYCPersonalInfoBox PersonalInfo;
    private KYCBusinessInfoBox BusinessInfo;
    private KYCBusinessDetailBox BusinessDetail;
    private KYCPermanentAddressBox PermanentAddress;
    private KYCPresentAddressBox PresentAddress;
    private List<KYCFamilyMemberBox> FamilyMemberList;
    private KYCRelativeBox Relative;

    private String errorMessage;
    private boolean hasError;

    public KYCDM() {
    }

    public String getMEMBER_ID() {
        return MEMBER_ID;
    }

    public void setMEMBER_ID(String MEMBER_ID) {
        this.MEMBER_ID = MEMBER_ID;
    }

    public String getBRANCH_ID() {
        return BRANCH_ID;
    }

    public void setBRANCH_ID(String BRANCH_ID) {
        this.BRANCH_ID = BRANCH_ID;
    }

    public String getCENTER_ID() {
        return CENTER_ID;
    }

    public void setCENTER_ID(String CENTER_ID) {
        this.CENTER_ID = CENTER_ID;
    }

    public KYCPersonalInfoBox getPersonalInfo() {
        return PersonalInfo;
    }

    public void setPersonalInfo(KYCPersonalInfoBox personalInfo) {
        PersonalInfo = personalInfo;
    }

    public KYCBusinessInfoBox getBusinessInfo() {
        return BusinessInfo;
    }

    public void setBusinessInfo(KYCBusinessInfoBox businessInfo) {
        BusinessInfo = businessInfo;
    }

    public KYCBusinessDetailBox getBusinessDetail() {
        return BusinessDetail;
    }

    public void setBusinessDetail(KYCBusinessDetailBox businessDetail) {
        BusinessDetail = businessDetail;
    }

    public KYCPermanentAddressBox getPermanentAddress() {
        return PermanentAddress;
    }

    public void setPermanentAddress(KYCPermanentAddressBox permanentAddress) {
        PermanentAddress = permanentAddress;
    }

    public KYCPresentAddressBox getPresentAddress() {
        return PresentAddress;
    }

    public void setPresentAddress(KYCPresentAddressBox presentAddress) {
        PresentAddress = presentAddress;
    }

    public List<KYCFamilyMemberBox> getFamilyMemberList() {
        return FamilyMemberList;
    }

    public void setFamilyMemberList(List<KYCFamilyMemberBox> familyMemberList) {
        FamilyMemberList = familyMemberList;
    }

    public KYCRelativeBox getRelative() {
        return Relative;
    }

    public void setRelative(KYCRelativeBox relative) {
        Relative = relative;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }
}