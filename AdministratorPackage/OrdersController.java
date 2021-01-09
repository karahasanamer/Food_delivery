package AdministratorPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;

public class OrdersController {

    @FXML private TextField txtId;
    @FXML private TextField txtName;
    @FXML private TextField txtPrice;
    @FXML private TextField txtRestaurant;
    @FXML private TextField searchId;
    @FXML private TextField searchName;

    @FXML private javafx.scene.control.TextArea resultConsole;
    @FXML private TextField searchDishId;
    @FXML private TextField searchDishName;
    @FXML private TableColumn colDishId1;
    @FXML private TableColumn colDishName1;
    @FXML private TableColumn colDishPrice1;
    @FXML private TableColumn colDishRid1;
    @FXML private TableView dishTable1;

    public void insertDish(ActionEvent event)  throws ClassNotFoundException, SQLException {
      //  try {
         //   AdmDishDAO.insertDish(Integer.parseInt(txtId.getText()), txtName.getText(), Integer.parseInt(txtPrice.getText()), Integer.parseInt(txtRestaurant.getText()));
            resultConsole.setText("Success! Values has been added to DB");
         //   ObservableList<Dish> dishList = AdmDishDAO.getAllRecords();
         //   populateTable(dishList);

       /* }catch (SQLException e){
            System.out.println("Exception occurs in Insertion " +e);
            e.printStackTrace();
            throw e;
        }*/
    }


   @FXML
    private void updateDish(ActionEvent event) throws ClassNotFoundException, SQLException{
      /*  try {
            AdmDishDAO.updateDish(Integer.parseInt(searchDishId.getText()), searchDishName.getText());
            resultConsole.setText("Data was updated");
            ObservableList<Dish> dishList = AdmDishDAO.getAllRecords();
            populateTable(dishList);

        }catch (SQLException e){
            System.out.println("Error while updating");
            e.printStackTrace();
            throw e;
        }*/
    }
    private ObservableList<Orders> data= FXCollections.observableArrayList(
            new Orders(1,"order1",1,1),
            new Orders(2,"order2",2,2)

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

            dishTable1.setItems(data);
            dishTable1.setItems(data);

            dishTable1.refresh();
        }


    }



    @FXML
    private void initialize() throws Exception{

        colDishPrice1.setCellValueFactory(new PropertyValueFactory<Orders,Integer>("Price"));
        colDishRid1.setCellValueFactory(new PropertyValueFactory<Orders,Integer>("Rid"));
        colDishId1.setCellValueFactory(new PropertyValueFactory<Orders,Integer>("id"));
        colDishName1.setCellValueFactory(new PropertyValueFactory<Orders,String>("Name"));


        dishTable1.setItems(data);
        dishTable1.setItems(data);
        // dishTable.getItems().addAll(data);
        dishTable1.refresh();
    }

    private void populateTable(ObservableList<Dish> dishList){
       /* dishTable.setItems(dishList);
    }

    @FXML
    private void searchDish(ActionEvent event) throws ClassNotFoundException, SQLException{
        /*ObservableList<Dish> list = AdmDishDAO.searchDish(searchId.getText());

        if (list.size()>0){
            populateTable(list);
            resultConsole.setText("Record has been found");
        }else{
            resultConsole.setText("No such records ");
        }
*/

    }


    @FXML
    private void searchAllDishes(ActionEvent event) throws ClassNotFoundException,SQLException{
        /*ObservableList<Dish> dishList = AdmDishDAO.getAllRecords();
        populateTable(dishList);*/
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
