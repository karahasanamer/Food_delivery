package AdministratorPackage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Orders {
    private IntegerProperty idProperty;
    private StringProperty nameProperty;
    private IntegerProperty priceProperty;
    private IntegerProperty ridProperty;

    private int id,p,ri;
    private String n;

    public Orders(){
        this.idProperty = new SimpleIntegerProperty();
        this.nameProperty = new SimpleStringProperty();
        this.priceProperty = new SimpleIntegerProperty();
        this.ridProperty = new SimpleIntegerProperty();
    }
    public Orders(int id,String n,int p, int ri){
        this.id = id;
        this.n = n;
        this.p = p;
        this.ri = ri;
    }

    //for id
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.idProperty.set(id);
    }
    public IntegerProperty getDishId(){
        return idProperty;
    }

    //for name
    public String getName(){
        return n;
    }

    public void setName(String name) {
        this.nameProperty.set(name);
    }

    public StringProperty getDishName(){
        return nameProperty;
    }

    //for price
    public int getPrice(){
        return p;
    }

    public void setPrice(int price) {
        p=price;
    }

    public IntegerProperty getDishPrice(){
        return priceProperty;
    }

    //for r_id
    public int getRid(){
        return ri;
    }

    public void setRid(int rid) {
        this.ridProperty.set(rid);
    }

    public IntegerProperty getDishRid(){
        return ridProperty;
    }

}
