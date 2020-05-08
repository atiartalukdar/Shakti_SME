package services;

import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bp.SharedPreferencesCore;
import dataModelNew.LoadConfigurationDM;
import interfaces.IServiceManager;
import objectBox.BankBranchBox;
import objectBox.ObjectBox;

public class ServiceManager implements IServiceManager {
    private final String TAG = getClass().getName() + "Atiar - ";
    ObjectBoxManager _objectBoxManager = new ObjectBoxManager();

    private final String PREFS_NAME = "ServiceManager";
    private final String LeadOptionList = "LeadOptionList";
    private final String OptionList = "OptionList";
    private final String PreScreeningList = "PreScreeningList";
    private final String DocumentTypeList = "DocumentTypeList";
    private final String CountryList = "CountryList";
    private final String BankList = "BankList";
    private final String BankBranchList = "BankBranchList";

    private SharedPreferencesCore sp = new SharedPreferencesCore(PREFS_NAME);
    Gson gson = new Gson();

    List<LoadConfigurationDM.OptionList> educationTypeOptions = new ArrayList<>();
    List<LoadConfigurationDM.OptionList> relationTypeOptions = new ArrayList<>();
    List<LoadConfigurationDM.OptionList> jobTypeOptions = new ArrayList<>();
    List<BankBranchBox> bankBranchLists = new ArrayList<>();

    @Override
    public void setConfigurationData(LoadConfigurationDM configurationData) {
        sp.setPreference(LeadOptionList, gson.toJson(configurationData.getData().getLeadOptionList()));
        sp.setPreference(OptionList, gson.toJson(configurationData.getData().getOptionList()));
        sp.setPreference(PreScreeningList, gson.toJson(configurationData.getData().getPreScreeningList()));
        sp.setPreference(DocumentTypeList, gson.toJson(configurationData.getData().getDocumentTypeList()));
        sp.setPreference(CountryList, gson.toJson(configurationData.getData().getCountryList()));
        sp.setPreference(BankList, gson.toJson(configurationData.getData().getBankList()));
        _objectBoxManager.SaveBankBranchBox(configurationData.getData().getBankBranchList());
    }

    @Override
    public List<LoadConfigurationDM.LeadOptionList> getLeadOptionList() {
        return sp.getList(LeadOptionList, LoadConfigurationDM.LeadOptionList.class);
    }

    @Override
    public List<LoadConfigurationDM.OptionList> getOptionList(String groupID) {
        relationTypeOptions.clear();
        educationTypeOptions.clear();
        jobTypeOptions.clear();

        List<LoadConfigurationDM.OptionList> optionList = sp.getList(OptionList, LoadConfigurationDM.OptionList.class);

        for (LoadConfigurationDM.OptionList optionItem : optionList) {
            Log.e(TAG, optionItem.toString());
            switch (optionItem.getOPTIONGROUP()) {
                case "3":
                    relationTypeOptions.add(optionItem);
                    break;
                case "2":
                    educationTypeOptions.add(optionItem);
                    break;
                case "1":
                    jobTypeOptions.add(optionItem);
                    break;
            }
        }

        switch (groupID) {
            case "all":
                return optionList;
            case "3":
                return relationTypeOptions;
            case "2":
                return educationTypeOptions;
            case "1":
                return jobTypeOptions;
        }

        return optionList;
    }

    @Override
    public List<LoadConfigurationDM.PreScreeningList> getPrescreenigPartOneQuestion(int leadOptionID) {
        List<LoadConfigurationDM.PreScreeningList> allQuestions = sp.getList(PreScreeningList, LoadConfigurationDM.PreScreeningList.class);
        Log.e(TAG, "All question size: " + allQuestions.size());

        List<LoadConfigurationDM.PreScreeningList> step1QuestionList = new ArrayList<>();
        for (LoadConfigurationDM.PreScreeningList question : allQuestions) {
            if (question.getLEADOPTIONID() == leadOptionID) {

                if (question.getISFIRSTSTEP() == 1 ) {
                    step1QuestionList.add(question);
                }
            }
        }

        Log.e(TAG, "Part1 question size for leadOptionID: " + leadOptionID + " - "+ allQuestions.size());
        return step1QuestionList;
    }

    @Override
    public List<LoadConfigurationDM.PreScreeningList> getPrescreenigPartTwoQuestion(int leadOptionID) {
        List<LoadConfigurationDM.PreScreeningList> allQuestions = sp.getList(PreScreeningList, LoadConfigurationDM.PreScreeningList.class);
        Log.e(TAG, "All question size: " + allQuestions.size());

        List<LoadConfigurationDM.PreScreeningList> step2QuestionList = new ArrayList<>();
        for (LoadConfigurationDM.PreScreeningList question : allQuestions) {
            if (question.getLEADOPTIONID() == leadOptionID) {
                if (question.getISFIRSTSTEP() == 0 ) {
                    step2QuestionList.add(question);
                }
            }
        }

        Log.e(TAG, "Part2 question size for leadOptionID: " + leadOptionID + " - "+ allQuestions.size());
        return step2QuestionList;
    }

    @Override
    public List<LoadConfigurationDM.BankList> getBankList() {
        return sp.getList(BankList, LoadConfigurationDM.BankList.class);
    }

    @Override
    public List<BankBranchBox> getBankBranchList(String bankCode) {
        bankBranchLists.clear();
        bankBranchLists.addAll(_objectBoxManager.GetBankBranchBox(bankCode));
        return bankBranchLists;
    }

    @Override
    public List<BankBranchBox> getAllBankBranch() {
        return  sp.getList(BankList, BankBranchBox.class);
    }


    @Override
    public LoadConfigurationDM.LeadOptionList getLeadOptionObject(int optionID) {
        for (LoadConfigurationDM.LeadOptionList optionItem : getLeadOptionList()) {
            if (optionID == (optionItem.getLEADOPTIONID())) {
                return optionItem;
            }
        }
        return null;
    }

    @Override
    public List<LoadConfigurationDM.DocumentTypeList> getDocumentTypeList() {

        List<LoadConfigurationDM.DocumentTypeList> documentTypeList = sp.getList(DocumentTypeList, LoadConfigurationDM.DocumentTypeList.class);
        return documentTypeList;
    }

    @Override
    public List<LoadConfigurationDM.CountryList> getCountryList() {
        List<LoadConfigurationDM.CountryList> countryLists = sp.getList(CountryList, LoadConfigurationDM.CountryList.class);
        return countryLists;
    }

    @Override
    public int getLeadOptionID(String leadOptionName) {
        for (LoadConfigurationDM.LeadOptionList optionItem : getLeadOptionList()) {
            if (leadOptionName.equals(optionItem.getOPTIONNAMEBN()) || leadOptionName.equals(optionItem.getOPTIONNAMEEN())) {
                return optionItem.getLEADOPTIONID();
            }
        }

        return 0;
    }

    @Override
    public int getPosition(List<LoadConfigurationDM.LeadOptionList> leadOptionLists, int leadOptionId) {
        for (LoadConfigurationDM.LeadOptionList item : leadOptionLists) {
            if (item.getLEADOPTIONID() == leadOptionId) {
                return leadOptionLists.indexOf(item);
            }
        }
        return 0;
    }

    @Override
    public int getDocumentTypeID(String documentType){
        int documentTypeID = -1;
        for (LoadConfigurationDM.DocumentTypeList doc : getDocumentTypeList()){
            if (doc.getDOCTYPENAME().equals(documentType)){
                return doc.getDOCTYPEID();
            }
        }

        return documentTypeID;
    }

    @Override
    public String getDocumentTypeName(int documentTypeID){
        String documentType = "";
        for (LoadConfigurationDM.DocumentTypeList doc : getDocumentTypeList()){
            if (doc.getDOCTYPEID() == documentTypeID){
                return doc.getDOCTYPENAME();
            }
        }
        return documentType;
    }

    @Override
    public String getCountryCode(String countryName) {
        for (LoadConfigurationDM.CountryList c: getCountryList()){
            if (c.equals(countryName)){
                return c.getCOUNTRY_CODE();
            }
        }
        return null;
    }

    @Override
    public void clearServiceManager() {
        sp.clear();
    }
}
