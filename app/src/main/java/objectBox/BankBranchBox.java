package objectBox;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Atiar Talukdar on 9/7/2019.
 */
@Entity
public class BankBranchBox {
    @Id long id;
    private int BBID;
    private String BANKBRANCHNAME;
    private String ROUTINGNUMBER;
    private String BANKCODE;

    public BankBranchBox() {
    }

    public BankBranchBox(Integer BBID, String BANKBRANCHNAME, String ROUTINGNUMBER, String BANKCODE) {
        this.BBID = BBID;
        this.BANKBRANCHNAME = BANKBRANCHNAME;
        this.ROUTINGNUMBER = ROUTINGNUMBER;
        this.BANKCODE = BANKCODE;
    }

    public int getBBID() {
        return BBID;
    }

    public void setBBID(int BBID) {
        this.BBID = BBID;
    }

    public String getBANKBRANCHNAME() {
        return BANKBRANCHNAME;
    }

    public void setBANKBRANCHNAME(String BANKBRANCHNAME) {
        this.BANKBRANCHNAME = BANKBRANCHNAME;
    }

    public String getROUTINGNUMBER() {
        return ROUTINGNUMBER;
    }

    public void setROUTINGNUMBER(String ROUTINGNUMBER) {
        this.ROUTINGNUMBER = ROUTINGNUMBER;
    }

    public String getBANKCODE() {
        return BANKCODE;
    }

    public void setBANKCODE(String BANKCODE) {
        this.BANKCODE = BANKCODE;
    }

    @Override
    public String toString() {
        return BANKBRANCHNAME;
    }
}
