package services;

import java.util.List;

import dataModelForUpload.KYCDM;
import interfaces.IKYCManager;
import interfaces.IObjectBoxManager;
import objectBox.KYCBusinessDetailBox;
import objectBox.KYCBusinessInfoBox;
import objectBox.KYCFamilyMemberBox;
import objectBox.KYCPermanentAddressBox;
import objectBox.KYCPersonalInfoBox;
import objectBox.KYCPresentAddressBox;
import objectBox.KYCRelativeBox;
import rettrofit.APIManager;

public class KYCManager implements IKYCManager {
    IObjectBoxManager _objectBoxManager = new ObjectBoxManager();

    @Override
    public KYCDM GetKYCInformation(String branchId, String memberId) {
        KYCDM kycInformation = new KYCDM();
        kycInformation.setBRANCH_ID(branchId);
        kycInformation.setMEMBER_ID(memberId);
        kycInformation.setPersonalInfo(_objectBoxManager.GetKYCPersonalInfoBox(branchId, memberId));
        kycInformation.setBusinessInfo(_objectBoxManager.GetKYCBusinessInfoBoxBox(branchId, memberId));
        kycInformation.setBusinessDetail(_objectBoxManager.GetKYCBusinessDetailBox(branchId, memberId));
        kycInformation.setPermanentAddress(_objectBoxManager.GetKYCPermanentAddressBox(branchId, memberId));
        kycInformation.setPresentAddress(_objectBoxManager.GetKYCPresentAddressBox(branchId, memberId));
        kycInformation.setFamilyMemberList(_objectBoxManager.GetKYCFamilyMemberBoxList(branchId, memberId));
        kycInformation.setRelative(_objectBoxManager.GetKYCRelativeBox(branchId, memberId));

        return kycInformation;
    }

    @Override
    public void RemoveKYCInformation(String branchId, String memberId) {
        _objectBoxManager.RemoveKYCPersonalInfoBox(branchId, memberId);
        _objectBoxManager.RemoveKYCBusinessInfoBox(branchId, memberId);
        _objectBoxManager.RemoveKYCBusinessDetailBox(branchId, memberId);
        _objectBoxManager.RemoveKYCPermanentAddressBox(branchId, memberId);
        _objectBoxManager.RemoveKYCPresentAddressBox(branchId, memberId);
        _objectBoxManager.RemoveKYCFamilyMemberBoxList(branchId, memberId);
        _objectBoxManager.RemoveKYCRelativeBox(branchId, memberId);
    }
}
