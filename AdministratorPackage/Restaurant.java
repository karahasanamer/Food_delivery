package AdministratorPackage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Restaurant {

    private StringProperty nameProperty;
    private StringProperty addressProperty;

    private String n,a;
    public Restaurant(){
        this.nameProperty = new SimpleStringProperty();
        this.addressProperty = new SimpleStringProperty();
    }
    public Restaurant(String n, String a){
        this.n=n;
        this.a=a;
    }

    //for name
    public String getName(){
        return n;
    }

    public void setName(String name) {
        this.n=n;
    }

    public StringProperty getRestaurantName(){
        return nameProperty;
    }

    //for address
    public String getAddress(){
        return a;
    }

    public void setAddress(String address) {
        this.a=a;
    }

    public StringProperty getRestaurantAddress(){
        return addressProperty;
    }
}
