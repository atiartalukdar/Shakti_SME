package objectBox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Atiar Talukdar on 7/4/2019.
 */
@Entity
public class P1_PonnerMojudBox {
    @Id
    long id;

    String name, qty,unitPrice;

    public P1_PonnerMojudBox(String name, String qty, String unitPrice) {
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
}
