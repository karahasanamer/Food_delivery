package AdministratorPackage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {

    private StringProperty nameProperty;
    private StringProperty surnameProperty;
    private String n,s;

    public Customer(){
        this.nameProperty = new SimpleStringProperty();
        this.surnameProperty = new SimpleStringProperty();
    }
    public Customer(String n,String s){
        this.s=s;
        this.n=n;
    }

    //for name
    public String getName(){
        return n;
    }

    public void setName(String name) {
        this.nameProperty.set(name);
    }

    public StringProperty getCustomerName(){
        return nameProperty;
    }

    //for surname
    public String getSurname(){
        return s;
    }

    public void setSurname(String surname) {
        this.surnameProperty.set(surname);
    }

    public StringProperty getCustomerSurname(){
        return surnameProperty;
    }
}
