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

public class DishController {

    @FXML private TextField txtId;
    @FXML private TextField txtId1;
    @FXML private TextField txtName;
    @FXML private TextField txtPrice;
    @FXML private TextField txtRestaurant;
    @FXML private TextField searchId;
    @FXML private TextField searchName;

    @FXML private javafx.scene.control.TextArea resultConsole;
    @FXML private javafx.scene.control.TextField searchDishId;
    @FXML private javafx.scene.control.TextField searchDishName;
    @FXML private TableColumn<Dish,Integer> colDishId;
    @FXML private TableColumn<Dish,String> colDishName;
    @FXML private TableColumn<Dish,Integer> colDishPrice;
    @FXML private TableColumn<Dish,Integer> colDishRid;
    @FXML private TableView dishTable;
    private ObservableList<Dish> data= FXCollections.observableArrayList(
            new Dish(1,"item1",1,1),
            new Dish(2,"item2",2,2),
            new Dish(3,"item3",3,3)
    );
    public void insertDish(javafx.event.ActionEvent event)  throws ClassNotFoundException, SQLException {

       if(txtId.getText().isEmpty()|| txtName.getText().isEmpty()||txtPrice.getText().isEmpty()||txtRestaurant.getText().isEmpty()){

           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error Dialog");
           alert.setHeaderText(null);
           alert.setContentText("You did not enter needed information!");
           alert.showAndWait();

       }else{


        data.add(new Dish(Integer.parseInt(txtId.getText()),txtName.getText(),Integer.parseInt(txtPrice.getText()),Integer.parseInt(txtRestaurant.getText())));


        dishTable.setItems(data);
        dishTable.setItems(data);

        dishTable.refresh();
       }
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

    @FXML
    private void deleteDish(ActionEvent event) throws ClassNotFoundException,SQLException{
        if(txtId1.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("You did not enter number from the list!");
            alert.showAndWait();
        }else if(Integer.parseInt(txtId1.getText())>data.size()||Integer.parseInt(txtId1.getText())<1 ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Item not existed!");
            alert.showAndWait();
        }else {
            int a=Integer.parseInt(txtId1.getText());
            data.remove(a-1);

            dishTable.setItems(data);
            dishTable.setItems(data);

            dishTable.refresh();
        }
    }

    @FXML
    private void initialize() throws Exception{
        colDishPrice.setCellValueFactory(new PropertyValueFactory<Dish,Integer>("Price"));
        colDishRid.setCellValueFactory(new PropertyValueFactory<Dish,Integer>("Rid"));
        colDishId.setCellValueFactory(new PropertyValueFactory<Dish,Integer>("id"));
        colDishName.setCellValueFactory(new PropertyValueFactory<Dish,String>("Name"));

        dishTable.setItems(data);
        // dishTable.getItems().addAll(data);
        dishTable.refresh();

    }

    private void populateTable(ObservableList<Dish> dishList){
        //dishTable.setItems(dishList);
    }

    @FXML
    private void searchDish(ActionEvent event) throws ClassNotFoundException, SQLException{
       /* ObservableList<Dish> list = AdmDishDAO.searchDish(searchId.getText());

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
      //  ObservableList<Dish> dishList = AdmDishDAO.getAllRecords();
       // populateTable(dishList);
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
