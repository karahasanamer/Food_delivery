package CustomerPackage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Dish {
    private IntegerProperty idProperty;
    private StringProperty nameProperty;
    private IntegerProperty priceProperty;
    private IntegerProperty ridProperty;

    public Dish(){
        this.idProperty = new SimpleIntegerProperty();
        this.nameProperty = new SimpleStringProperty();
        this.priceProperty = new SimpleIntegerProperty();
        this.ridProperty = new SimpleIntegerProperty();
    }
    int aa,cc,dd;
    String bb;

    public int getAa() {
        return aa;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public Dish(int a, String b, int c, int d){
        this.aa = a;
        this.bb = b;
        this.cc = c;
        this.dd = d;
    }


    //for id
    public int getId(){
        return aa;
    }

    public void setId(int id) {
        this.idProperty.set(id);
    }
    public IntegerProperty getDishId(){
        return idProperty;
    }

    //for name
    public String getName(){
        return bb;
    }

    public void setName(String name) {
        this.nameProperty.set(name);
    }

    public StringProperty getDishName(){
        return nameProperty;
    }

    //for price
    public int getPrice(){
        return cc;
    }

    public void setPrice(int price) {
        this.priceProperty.set(price);
    }

    public IntegerProperty getDishPrice(){
        return priceProperty;
    }

    //for r_id
    public int getRid(){
        return dd;
    }

    public void setRid(int rid) {
        this.ridProperty.set(rid);
    }

    public IntegerProperty getDishRid(){
        return ridProperty;
    }

}
