package interfaces;

import java.util.List;

import dataModelNew.LoadConfigurationDM;
import objectBox.BankBranchBox;

public interface IServiceManager {

    public void setConfigurationData(LoadConfigurationDM configurationData);

    public List<LoadConfigurationDM.LeadOptionList> getLeadOptionList();

    public List<LoadConfigurationDM.OptionList> getOptionList(String groupID);

    public List<LoadConfigurationDM.DocumentTypeList> getDocumentTypeList();

    public List<LoadConfigurationDM.CountryList> getCountryList();

    public List<LoadConfigurationDM.PreScreeningList> getPrescreenigPartOneQuestion(int leadOptionID);

    public List<LoadConfigurationDM.PreScreeningList> getPrescreenigPartTwoQuestion(int leadOptionID);

    public List<LoadConfigurationDM.BankList> getBankList();

    public List<BankBranchBox> getBankBranchList(String bankCode);

    public List<BankBranchBox> getAllBankBranch();

    public LoadConfigurationDM.LeadOptionList getLeadOptionObject(int optionID);

    public int getLeadOptionID(String leadOptionName);

    public int getPosition(List<LoadConfigurationDM.LeadOptionList> leadOptionLists, int leadOptionId);

    public int getDocumentTypeID(String documentType);

    public String getDocumentTypeName(int documentTypeID);

    public String getCountryCode(String countryName);


    //================ Remove all data from Service Manager =================//
    public void clearServiceManager();

}
