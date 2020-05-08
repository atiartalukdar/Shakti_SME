package dataModelNew;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import objectBox.BankBranchBox;

public class LoadConfigurationDM implements Serializable {

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



    public class Data implements Serializable  {
        @SerializedName("OptionList")
        @Expose
        private List<OptionList> optionList = null;
        @SerializedName("LeadOptionList")
        @Expose
        private List<LeadOptionList> leadOptionList = null;
        @SerializedName("PreScreeningList")
        @Expose
        private List<PreScreeningList> preScreeningList = null;
        @SerializedName("DocumentTypeList")
        @Expose
        private List<DocumentTypeList> documentTypeList = null;
        @SerializedName("CountryList")
        @Expose
        private List<CountryList> countryList  = null;
        @SerializedName("BankList")
        @Expose
        private List<BankList> bankList = null;
        @SerializedName("BankBranchList")
        @Expose
        private List<BankBranchBox> bankBranchList = null;

        public List<OptionList> getOptionList() {
            return optionList;
        }

        public void setOptionList(List<OptionList> optionList) {
            this.optionList = optionList;
        }

        public List<LeadOptionList> getLeadOptionList() {
            return leadOptionList;
        }

        public void setLeadOptionList(List<LeadOptionList> leadOptionList) {
            this.leadOptionList = leadOptionList;
        }

        public List<PreScreeningList> getPreScreeningList() {
            return preScreeningList;
        }

        public void setPreScreeningList(List<PreScreeningList> preScreeningList) {
            this.preScreeningList = preScreeningList;
        }

        public List<DocumentTypeList> getDocumentTypeList() {
            return documentTypeList;
        }

        public void setDocumentTypeList(List<DocumentTypeList> documentTypeList) {
            this.documentTypeList = documentTypeList;
        }

        public List<CountryList> getCountryList() {
            return countryList;
        }

        public void setCountryList(List<CountryList> countryList) {
            this.countryList = countryList;
        }

        public List<BankList> getBankList() {
            return bankList;
        }

        public void setBankList(List<BankList> bankList) {
            this.bankList = bankList;
        }

        public List<BankBranchBox> getBankBranchList() {
            return bankBranchList;
        }

        public void setBankBranchList(List<BankBranchBox> bankBranchList) {
            this.bankBranchList = bankBranchList;
        }

    }

    public class LeadOptionList implements Serializable {

        @SerializedName("LEADOPTIONID")
        @Expose
        private Integer lEADOPTIONID;
        @SerializedName("OPTIONNAMEEN")
        @Expose
        private String oPTIONNAMEEN;
        @SerializedName("OPTIONNAMEBN")
        @Expose
        private String oPTIONNAMEBN;
        @SerializedName("LOANPROPOSALTYPEID")
        @Expose
        private Integer lOANPROPOSALTYPEID;
        @SerializedName("PASS_SCORE")
        @Expose
        private Double pASSSCORE;
        @SerializedName("LOAN_MAX")
        @Expose
        private Double lOANMAX;
        @SerializedName("LOAN_MIN")
        @Expose
        private Double lOANMIN;
        @SerializedName("LOAN_ROUND_AMOUNT")
        @Expose
        private Double lOANROUNDAMOUNT;
        @SerializedName("MAX_DURATION")
        @Expose
        private Integer mAXDURATION;
        @SerializedName("TRAN_ID")
        @Expose
        private Integer tRANID;
        @SerializedName("SET_DATE")
        @Expose
        private String sETDATE;
        @SerializedName("SET_BY")
        @Expose
        private String sETBY;
        @SerializedName("IS_ACTIVE")
        @Expose
        private Integer iSACTIVE;
        @SerializedName("IS_DELETED")
        @Expose
        private Integer iSDELETED;

        public Integer getLEADOPTIONID() {
            return lEADOPTIONID;
        }

        public void setLEADOPTIONID(Integer lEADOPTIONID) {
            this.lEADOPTIONID = lEADOPTIONID;
        }

        public String getOPTIONNAMEEN() {
            return oPTIONNAMEEN;
        }

        public void setOPTIONNAMEEN(String oPTIONNAMEEN) {
            this.oPTIONNAMEEN = oPTIONNAMEEN;
        }

        public String getOPTIONNAMEBN() {
            return oPTIONNAMEBN;
        }

        public void setOPTIONNAMEBN(String oPTIONNAMEBN) {
            this.oPTIONNAMEBN = oPTIONNAMEBN;
        }

        public Integer getLOANPROPOSALTYPEID() {
            return lOANPROPOSALTYPEID;
        }

        public void setLOANPROPOSALTYPEID(Integer lOANPROPOSALTYPEID) {
            this.lOANPROPOSALTYPEID = lOANPROPOSALTYPEID;
        }

        public Double getPASSSCORE() {
            return pASSSCORE;
        }

        public void setPASSSCORE(Double pASSSCORE) {
            this.pASSSCORE = pASSSCORE;
        }

        public Double getLOANMAX() {
            return lOANMAX;
        }

        public void setLOANMAX(Double lOANMAX) {
            this.lOANMAX = lOANMAX;
        }

        public Double getLOANMIN() {
            return lOANMIN;
        }

        public void setLOANMIN(Double lOANMIN) {
            this.lOANMIN = lOANMIN;
        }

        public Double getLOANROUNDAMOUNT() {
            return lOANROUNDAMOUNT;
        }

        public void setLOANROUNDAMOUNT(Double lOANROUNDAMOUNT) {
            this.lOANROUNDAMOUNT = lOANROUNDAMOUNT;
        }

        public Integer getMAXDURATION() {
            return mAXDURATION;
        }

        public void setMAXDURATION(Integer mAXDURATION) {
            this.mAXDURATION = mAXDURATION;
        }

        public Integer getTRANID() {
            return tRANID;
        }

        public void setTRANID(Integer tRANID) {
            this.tRANID = tRANID;
        }

        public String getSETDATE() {
            return sETDATE;
        }

        public void setSETDATE(String sETDATE) {
            this.sETDATE = sETDATE;
        }

        public String getSETBY() {
            return sETBY;
        }

        public void setSETBY(String sETBY) {
            this.sETBY = sETBY;
        }

        public Integer getISACTIVE() {
            return iSACTIVE;
        }

        public void setISACTIVE(Integer iSACTIVE) {
            this.iSACTIVE = iSACTIVE;
        }

        public Integer getISDELETED() {
            return iSDELETED;
        }

        public void setISDELETED(Integer iSDELETED) {
            this.iSDELETED = iSDELETED;
        }

        @Override
        public String toString() {
            return oPTIONNAMEBN;
        }
    }

    public class OptionList implements Serializable  {

        @SerializedName("EDU_NAME")
        @Expose
        private String eDUNAME;
        @SerializedName("QUALITY_SCORE")
        @Expose
        private Double qUALITYSCORE;
        @SerializedName("OPTION_GROUP")
        @Expose
        private String oPTIONGROUP;

        public String getEDUNAME() {
            return eDUNAME;
        }

        public void setEDUNAME(String eDUNAME) {
            this.eDUNAME = eDUNAME;
        }

        public Double getQUALITYSCORE() {
            return qUALITYSCORE;
        }

        public void setQUALITYSCORE(Double qUALITYSCORE) {
            this.qUALITYSCORE = qUALITYSCORE;
        }

        public String getOPTIONGROUP() {
            return oPTIONGROUP;
        }

        public void setOPTIONGROUP(String oPTIONGROUP) {
            this.oPTIONGROUP = oPTIONGROUP;
        }

        @Override
        public String toString() {
            return eDUNAME;
        }
    }

    public class PreScreeningList implements Serializable  {

        @SerializedName("PRESCREENINGID")
        @Expose
        private Integer pRESCREENINGID;
        @SerializedName("QUESTION")
        @Expose
        private String qUESTION;
        @SerializedName("ORDER_SL")
        @Expose
        private Object oRDERSL;
        @SerializedName("ISFIRSTSTEP")
        @Expose
        private Integer iSFIRSTSTEP;
        @SerializedName("MARK")
        @Expose
        private Integer mARK;
        @SerializedName("LOANPROPOSALTYPEID")
        @Expose
        private Integer lOANPROPOSALTYPEID;
        @SerializedName("OPTION1")
        @Expose
        private String oPTION1;
        @SerializedName("OPTION2")
        @Expose
        private String oPTION2;
        @SerializedName("QURRECT_OPTION")
        @Expose
        private String qURRECTOPTION;
        @SerializedName("LEAD_OPTION_ID")
        @Expose
        private Integer lEADOPTIONID;
        @SerializedName("TRAN_ID")
        @Expose
        private Integer tRANID;
        @SerializedName("SET_DATE")
        @Expose
        private String sETDATE;
        @SerializedName("SET_BY")
        @Expose
        private String sETBY;
        @SerializedName("IS_ACTIVE")
        @Expose
        private Integer iSACTIVE;
        @SerializedName("IS_DELETED")
        @Expose
        private Integer iSDELETED;

        public Integer getPRESCREENINGID() {
            return pRESCREENINGID;
        }

        public void setPRESCREENINGID(Integer pRESCREENINGID) {
            this.pRESCREENINGID = pRESCREENINGID;
        }

        public String getQUESTION() {
            return qUESTION;
        }

        public void setQUESTION(String qUESTION) {
            this.qUESTION = qUESTION;
        }

        public Object getORDERSL() {
            return oRDERSL;
        }

        public void setORDERSL(Object oRDERSL) {
            this.oRDERSL = oRDERSL;
        }

        public Integer getISFIRSTSTEP() {
            return iSFIRSTSTEP;
        }

        public void setISFIRSTSTEP(Integer iSFIRSTSTEP) {
            this.iSFIRSTSTEP = iSFIRSTSTEP;
        }

        public Integer getMARK() {
            return mARK;
        }

        public void setMARK(Integer mARK) {
            this.mARK = mARK;
        }

        public Integer getLOANPROPOSALTYPEID() {
            return lOANPROPOSALTYPEID;
        }

        public void setLOANPROPOSALTYPEID(Integer lOANPROPOSALTYPEID) {
            this.lOANPROPOSALTYPEID = lOANPROPOSALTYPEID;
        }

        public String getOPTION1() {
            return oPTION1;
        }

        public void setOPTION1(String oPTION1) {
            this.oPTION1 = oPTION1;
        }

        public String getOPTION2() {
            return oPTION2;
        }

        public void setOPTION2(String oPTION2) {
            this.oPTION2 = oPTION2;
        }

        public String getQURRECTOPTION() {
            return qURRECTOPTION;
        }

        public void setQURRECTOPTION(String qURRECTOPTION) {
            this.qURRECTOPTION = qURRECTOPTION;
        }

        public Integer getLEADOPTIONID() {
            return lEADOPTIONID;
        }

        public void setLEADOPTIONID(Integer lEADOPTIONID) {
            this.lEADOPTIONID = lEADOPTIONID;
        }

        public Integer getTRANID() {
            return tRANID;
        }

        public void setTRANID(Integer tRANID) {
            this.tRANID = tRANID;
        }

        public String getSETDATE() {
            return sETDATE;
        }

        public void setSETDATE(String sETDATE) {
            this.sETDATE = sETDATE;
        }

        public String getSETBY() {
            return sETBY;
        }

        public void setSETBY(String sETBY) {
            this.sETBY = sETBY;
        }

        public Integer getISACTIVE() {
            return iSACTIVE;
        }

        public void setISACTIVE(Integer iSACTIVE) {
            this.iSACTIVE = iSACTIVE;
        }

        public Integer getISDELETED() {
            return iSDELETED;
        }

        public void setISDELETED(Integer iSDELETED) {
            this.iSDELETED = iSDELETED;
        }

        @Override
        public String toString() {
            return "PreScreeningList{" +
                    "pRESCREENINGID=" + pRESCREENINGID +
                    ", qUESTION='" + qUESTION + '\'' +
                    ", oRDERSL=" + oRDERSL +
                    ", iSFIRSTSTEP=" + iSFIRSTSTEP +
                    ", mARK=" + mARK +
                    ", lOANPROPOSALTYPEID=" + lOANPROPOSALTYPEID +
                    ", oPTION1='" + oPTION1 + '\'' +
                    ", oPTION2='" + oPTION2 + '\'' +
                    ", qURRECTOPTION='" + qURRECTOPTION + '\'' +
                    ", lEADOPTIONID=" + lEADOPTIONID +
                    ", tRANID=" + tRANID +
                    ", sETDATE='" + sETDATE + '\'' +
                    ", sETBY='" + sETBY + '\'' +
                    ", iSACTIVE=" + iSACTIVE +
                    ", iSDELETED=" + iSDELETED +
                    '}';
        }
    }

    public class DocumentTypeList implements Serializable  {

        @SerializedName("DOC_TYPE_ID")
        @Expose
        private int dOCTYPEID;
        @SerializedName("DOC_TYPE_NAME")
        @Expose
        private String dOCTYPENAME;
        @SerializedName("SL_NO")
        @Expose
        private Integer sLNO;
        @SerializedName("IS_ACTIVE")
        @Expose
        private Integer iSACTIVE;
        @SerializedName("IS_DELETED")
        @Expose
        private Integer iSDELETED;
        private final static long serialVersionUID = 6923363381162231006L;

        public int getDOCTYPEID() {
            return dOCTYPEID;
        }

        public void setDOCTYPEID(int dOCTYPEID) {
            this.dOCTYPEID = dOCTYPEID;
        }

        public String getDOCTYPENAME() {
            return dOCTYPENAME;
        }

        public void setDOCTYPENAME(String dOCTYPENAME) {
            this.dOCTYPENAME = dOCTYPENAME;
        }

        public Integer getSLNO() {
            return sLNO;
        }

        public void setSLNO(Integer sLNO) {
            this.sLNO = sLNO;
        }

        public Integer getISACTIVE() {
            return iSACTIVE;
        }

        public void setISACTIVE(Integer iSACTIVE) {
            this.iSACTIVE = iSACTIVE;
        }

        public Integer getISDELETED() {
            return iSDELETED;
        }

        public void setISDELETED(Integer iSDELETED) {
            this.iSDELETED = iSDELETED;
        }

        @Override
        public String toString() {
            return dOCTYPENAME;
        }
    }

    public class CountryList implements  Serializable {

        @SerializedName("COUNTRY_NAME")
        @Expose
        private String cOUNTRY_NAME;
        @SerializedName("COUNTRY_CODE")
        @Expose
        private String cOUNTRY_CODE;
        @SerializedName("ISO_CODES")
        @Expose
        private Object iSO_CODES;
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

        public String getCOUNTRY_NAME() {
            return cOUNTRY_NAME;
        }

        public void setCOUNTRY_NAME(String cOUNTRY_NAME) {
            this.cOUNTRY_NAME = cOUNTRY_NAME;
        }

        public String getCOUNTRY_CODE() {
            return cOUNTRY_CODE;
        }

        public void setCOUNTRY_CODE(String cOUNTRY_CODE) {
            this.cOUNTRY_CODE = cOUNTRY_CODE;
        }

        public Object getISO_CODES() {
            return iSO_CODES;
        }

        public void setISO_CODES(Object iSO_CODES) {
            this.iSO_CODES = iSO_CODES;
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

        @Override
        public String toString() {
            return cOUNTRY_NAME;
        }
    }

    public class BankList implements Serializable {

        @SerializedName("BANKCODE")
        @Expose
        private String bANKCODE;
        @SerializedName("BANKNAME")
        @Expose
        private String bANKNAME;

        public String getBANKCODE() {
            return bANKCODE;
        }

        public void setBANKCODE(String bANKCODE) {
            this.bANKCODE = bANKCODE;
        }

        public String getBANKNAME() {
            return bANKNAME;
        }

        public void setBANKNAME(String bANKNAME) {
            this.bANKNAME = bANKNAME;
        }

        @Override
        public String toString() {
            return bANKNAME;
        }
    }
}
