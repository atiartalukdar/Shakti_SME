package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Atiar Talukdar on 7/4/2019.
 */
@Entity
public class P1_DecorationBox {
    @Id
    long id;

    String name, userdYear,remainingYear,changingCost;

    public P1_DecorationBox(String name, String userdYear, String remainingYear, String changingCost) {
        this.name = name;
        this.userdYear = userdYear;
        this.remainingYear = remainingYear;
        this.changingCost = changingCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserdYear() {
        return userdYear;
    }

    public void setUserdYear(String userdYear) {
        this.userdYear = userdYear;
    }

    public String getRemainingYear() {
        return remainingYear;
    }

    public void setRemainingYear(String remainingYear) {
        this.remainingYear = remainingYear;
    }

    public String getChangingCost() {
        return changingCost;
    }

    public void setChangingCost(String changingCost) {
        this.changingCost = changingCost;
    }
}
