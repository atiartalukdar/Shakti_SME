package objectBox;


import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class PrescreeningAnsBox {
    @Id
    Long id;

    String userID;
    int LEAD_ID;
    int QUESTION_ID;
    String ANSWER;
    String correctAns;
    int isFirstStep;
    int mark;


    public PrescreeningAnsBox() {
    }

    public PrescreeningAnsBox(String userID, int LEAD_ID, int QUESTION_ID, String ANSWER, String correctAns, Integer isFirstStep, Integer mark) {
        this.userID = userID;
        this.LEAD_ID = LEAD_ID;
        this.QUESTION_ID = QUESTION_ID;
        this.ANSWER = ANSWER;
        this.correctAns = correctAns;
        this.isFirstStep = isFirstStep;
        this.mark = mark;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getLEAD_ID() {
        return LEAD_ID;
    }

    public void setLEAD_ID(int LEAD_ID) {
        this.LEAD_ID = LEAD_ID;
    }

    public int getQUESTION_ID() {
        return QUESTION_ID;
    }

    public void setQUESTION_ID(int QUESTION_ID) {
        this.QUESTION_ID = QUESTION_ID;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public Integer getIsFirstStep() {
        return isFirstStep;
    }

    public void setIsFirstStep(Integer isFirstStep) {
        this.isFirstStep = isFirstStep;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "PrescreeningAnsBox{" +
                "userID='" + userID + '\'' +
                ", LEAD_ID=" + LEAD_ID +
                ", QUESTION_ID=" + QUESTION_ID +
                ", ANSWER='" + ANSWER + '\'' +
                ", correctAns='" + correctAns + '\'' +
                ", isFirstStep=" + isFirstStep +
                ", mark=" + mark +
                '}';
    }
}


