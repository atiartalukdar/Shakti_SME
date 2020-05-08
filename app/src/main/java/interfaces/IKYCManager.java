package interfaces;

import dataModelForUpload.KYCDM;

public interface IKYCManager {
    public KYCDM GetKYCInformation(String branchId, String memberId);

    public void RemoveKYCInformation(String branchId, String memberId);
}
