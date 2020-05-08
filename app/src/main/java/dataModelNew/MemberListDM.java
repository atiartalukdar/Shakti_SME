package dataModelNew;

import java.io.Serializable;
import java.util.List;

import responseDataModel.BaseResponse;

public class MemberListDM extends BaseResponse implements Serializable {

    private List<Data> Data = null;

    public List<Data> getData() {
        return Data;
    }

    public void setData(List<Data> data) {
        this.Data = data;
    }

    public class Data  implements Serializable {

        private Double TRAN_ID;
        private String MEMBER_NAME;
        private Double LOAN_QUALITY;
        private Double SAVINGS_STATUS;
        private Double MEMBERSHIP_LENGTH;
        private String MEMBER_ID;
        private String ADDRESS;
        private String ENROLL_DATE;
        private String GENDER;
        private String MOBILE_NO;
        private String SPOUSE_NAME;
        private String CENTER_ID;
        private String BRANCH_ID;
        private Double LOAN_OUTSTANDING;
        private Double TOTAL_SAVINGS;
        private String DATE_OF_BIRTH;
        private String MEMBER_PHOTO_URL;
        private String CO_ID;
        private int LEAD_OPTION_ID;
        private String LOAN_CODE;
        private String NID;
        private String KYC_STATUS;
        private String LOAN_APPLICATION_STATUS;

        public Double getTRAN_ID() {
            return TRAN_ID;
        }

        public void setTRAN_ID(Double tRAN_ID) {
            this.TRAN_ID = tRAN_ID;
        }

        public String getMEMBER_NAME() {
            return MEMBER_NAME;
        }

        public void setMEMBER_NAME(String mEMBER_NAME) {
            this.MEMBER_NAME = mEMBER_NAME;
        }

        public Double getLOAN_QUALITY() {
            return LOAN_QUALITY;
        }

        public void setLOAN_QUALITY(Double lOAN_QUALITY) {
            this.LOAN_QUALITY = lOAN_QUALITY;
        }

        public Double getSAVINGS_STATUS() {
            return SAVINGS_STATUS;
        }

        public void setSAVINGS_STATUS(Double sAVINGS_STATUS) {
            this.SAVINGS_STATUS = sAVINGS_STATUS;
        }

        public Double getMEMBERSHIP_LENGTH() {
            return MEMBERSHIP_LENGTH;
        }

        public void setMEMBERSHIP_LENGTH(Double mEMBERSHIP_LENGTH) {
            this.MEMBERSHIP_LENGTH = mEMBERSHIP_LENGTH;
        }

        public String getMEMBER_ID() {
            return MEMBER_ID;
        }

        public void setMEMBER_ID(String MEMBER_ID) {
            this.MEMBER_ID = MEMBER_ID;
        }

        public String getADDRESS() {
            return ADDRESS;
        }

        public void setADDRESS(String ADDRESS) {
            this.ADDRESS = ADDRESS;
        }

        public String getENROLL_DATE() {
            return ENROLL_DATE;
        }

        public void setENROLL_DATE(String ENROLL_DATE) {
            this.ENROLL_DATE = ENROLL_DATE;
        }

        public String getGENDER() {
            return GENDER;
        }

        public void setGENDER(String GENDER) {
            this.GENDER = GENDER;
        }

        public String getMOBILE_NO() {
            return MOBILE_NO;
        }

        public void setMOBILE_NO(String MOBILE_NO) {
            this.MOBILE_NO = MOBILE_NO;
        }

        public String getSPOUSE_NAME() {
            return SPOUSE_NAME;
        }

        public void setSPOUSE_NAME(String SPOUSE_NAME) {
            this.SPOUSE_NAME = SPOUSE_NAME;
        }

        public String getCENTER_ID() {
            return CENTER_ID;
        }

        public void setCENTER_ID(String CENTER_ID) {
            this.CENTER_ID = CENTER_ID;
        }

        public String getBRANCH_ID() {
            return BRANCH_ID;
        }

        public void setBRANCH_ID(String BRANCH_ID) {
            this.BRANCH_ID = BRANCH_ID;
        }

        public Double getLOAN_OUTSTANDING() {
            return LOAN_OUTSTANDING;
        }

        public void setLOAN_OUTSTANDING(Double LOAN_OUTSTANDING) {
            this.LOAN_OUTSTANDING = LOAN_OUTSTANDING;
        }

        public Double getTOTAL_SAVINGS() {
            return TOTAL_SAVINGS;
        }

        public void setTOTAL_SAVINGS(Double TOTAL_SAVINGS) {
            this.TOTAL_SAVINGS = TOTAL_SAVINGS;
        }

        public String getDATE_OF_BIRTH() {
            return DATE_OF_BIRTH;
        }

        public void setDATE_OF_BIRTH(String DATE_OF_BIRTH) {
            this.DATE_OF_BIRTH = DATE_OF_BIRTH;
        }

        public String getMEMBER_PHOTO_URL() {
            return MEMBER_PHOTO_URL;
        }

        public void setMEMBER_PHOTO_URL(String MEMBER_PHOTO_URL) {
            this.MEMBER_PHOTO_URL = MEMBER_PHOTO_URL;
        }

        public String getCO_ID() {
            return CO_ID;
        }

        public void setCO_ID(String CO_ID) {
            this.CO_ID = CO_ID;
        }

        public int getLEAD_OPTION_ID() {
            return LEAD_OPTION_ID;
        }

        public void setLEAD_OPTION_ID(int LEAD_OPTION_ID) {
            this.LEAD_OPTION_ID = LEAD_OPTION_ID;
        }

        public String getLOAN_CODE() {
            return LOAN_CODE;
        }

        public void setLOAN_CODE(String LOAN_CODE) {
            this.LOAN_CODE = LOAN_CODE;
        }

        public String getNID() {
            return NID;
        }

        public void setNID(String NID) {
            this.NID = NID;
        }

        public String getKYC_STATUS() {
            return KYC_STATUS;
        }

        public void setKYC_STATUS(String KYC_STATUS) {
            this.KYC_STATUS = KYC_STATUS;
        }

        public String getLOAN_APPLICATION_STATUS() {
            return LOAN_APPLICATION_STATUS;
        }

        public void setLOAN_APPLICATION_STATUS(String LOAN_APPLICATION_STATUS) {
            this.LOAN_APPLICATION_STATUS = LOAN_APPLICATION_STATUS;
        }
    }
}