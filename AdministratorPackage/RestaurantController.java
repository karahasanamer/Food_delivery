package AdministratorPackage;

import CustomerPackage.Dish;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;

public class RestaurantController {


    @FXML private TextField txtName;
    @FXML private TextField txtAddress;
    @FXML private TextArea resultConsole;
    @FXML private TextField searchName;
    @FXML private TextField txtId;
    @FXML private TableColumn colRestName;
    @FXML private TableColumn colRestAddress;
    @FXML private TableView restTable;

    public void insertRestaurant(javafx.event.ActionEvent event)  throws ClassNotFoundException, SQLException {
        data.add(new Restaurant(txtName.getText(),txtAddress.getText()));
        restTable.setItems(data);

        restTable.refresh();

    }
    private ObservableList<Restaurant> data= FXCollections.observableArrayList(
        new Restaurant("Name1","Adress1"),
        new Restaurant("Name2","Adress2"),
        new Restaurant("Name3","Adress3")
    );
    @FXML
    private void deleteDish(ActionEvent event) throws ClassNotFoundException,SQLException{


        if(txtId.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("You did not enter number from the list!");
            alert.showAndWait();
        }else if(Integer.parseInt(txtId.getText())>data.size()||Integer.parseInt(txtId.getText())<1 ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Item not existed!");
            alert.showAndWait();
        }else {
            int a=Integer.parseInt(txtId.getText());
            data.remove(a-1);

            restTable.setItems(data);

            restTable.refresh();
        }
    }
    private void populateTable(ObservableList<Restaurant> restList){
       // restTable.setItems(restList);
    }

    @FXML
    private void initialize() throws Exception{
        colRestAddress.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("Address"));
        colRestName.setCellValueFactory(new PropertyValueFactory<Restaurant,String>("Name"));

        restTable.setItems(data);
        // dishTable.getItems().addAll(data);
        restTable.refresh();


    }

    @FXML
    private void searchRestaurant(ActionEvent event) throws ClassNotFoundException, SQLException{
       /* ObservableList<Restaurant> list = RestaurantDAO.searchRest(searchName.getText());

        if (list.size()>0){
            populateTable(list);
            resultConsole.setText("Record has been found");
        }else{
            resultConsole.setText("No such records ");
        }*/
    }

    @FXML
    private void searchAllRestaurants(ActionEvent event) throws ClassNotFoundException,SQLException{
       // ObservableList<Restaurant> restList = RestaurantDAO.getAllRecords();
      //  populateTable(restList);
    }

    public void return_back(ActionEvent event) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/AdministratorPackage/AdministratorView.fxml"));
            Scene admDish = new Scene(root);

            //gets stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(admDish);
            window.show();

        }catch (Exception e){
            System.out.println("Error occured while opening Admin page");
            e.printStackTrace();
            throw e;
        }
    }

}
