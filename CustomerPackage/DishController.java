package CustomerPackage;

import com.sun.xml.internal.bind.v2.runtime.output.ForkXmlOutput;
import javafx.beans.property.SimpleStringProperty;
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

import javax.xml.bind.Unmarshaller;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishController {

    @FXML private TextField txtId;
    @FXML private TextField txtName;
    @FXML private TextField txtPrice;
    @FXML private TextField txtRestaurant;
    @FXML private TextField searchId;
    @FXML private TextField searchName;

    @FXML private javafx.scene.control.TextArea resultConsole;
    @FXML private TextField searchDishId;
    @FXML private TextField searchDishName;
    @FXML private TableColumn colDishId;
    @FXML private TableColumn colDishName;
    @FXML private TableColumn colDishPrice;
    @FXML private TableColumn colDishRid;
    @FXML private TableView dishTable;
    @FXML private TableColumn colDishId1;
    @FXML private TableColumn colDishName1;
    @FXML private TableColumn colDishPrice1;
    @FXML private TableColumn colDishRid1;
    @FXML private TableView dishTable1;
    @FXML private Label labKm;
    private List<String>list=new ArrayList<>();

   private ObservableList<Dish>data1=FXCollections.observableArrayList();
    public void insertDish(ActionEvent event)  throws ClassNotFoundException, SQLException {
      if(txtId.getText().isEmpty()){
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Error Dialog");
          alert.setHeaderText(null);
          alert.setContentText("You did not enter item id!");
          alert.showAndWait();
      }else if(Integer.parseInt(txtId.getText())>data.size()||Integer.parseInt(txtId.getText())<1 ){
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Error Dialog");
          alert.setHeaderText(null);
          alert.setContentText("Item not existed!");
          alert.showAndWait();
      }else {
          int a = Integer.parseInt(txtId.getText());
          data1.add(new Dish(a, "item" + a, a, a));

          int b=Integer.parseInt(labKm.getText())+a;

          labKm.setText(b+"");
          dishTable1.setItems(data1);
          dishTable1.setItems(data1);

          dishTable1.refresh();
      }
    }
    private ObservableList<Dish> data= FXCollections.observableArrayList(
            new Dish(1,"item1",1,1),
            new Dish(2,"item2",2,2),
            new Dish(3,"item3",3,3)
    );

    @FXML
    private void updateDish(ActionEvent event) throws ClassNotFoundException, SQLException{
        //try {
         //   AdmDishDAO.updateDish(Integer.parseInt(searchDishId.getText()), searchDishName.getText());
            //resultConsole.setText("Data was updated");
          //  ObservableList<Dish> dishList = AdmDishDAO.getAllRecords();
         //   populateTable(dishList);

       /* }catch (SQLException e){
            System.out.println("Error while updating");
            e.printStackTrace();
            throw e;
        }*/
    }

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
            data1.remove(a-1);

            dishTable1.setItems(data1);
            dishTable1.setItems(data1);

            dishTable1.refresh();
        }
    }
    //List<Dish>lista;


    @FXML
    private void initialize() throws Exception{
    colDishPrice.setCellValueFactory(new PropertyValueFactory<Dish,Integer>("Price"));
    colDishRid.setCellValueFactory(new PropertyValueFactory<Dish,Integer>("Rid"));
    colDishId.setCellValueFactory(new PropertyValueFactory<Dish,Integer>("id"));
    colDishName.setCellValueFactory(new PropertyValueFactory<Dish,String>("Name"));
    colDishPrice1.setCellValueFactory(new PropertyValueFactory<Dish,Integer>("Price"));
    colDishRid1.setCellValueFactory(new PropertyValueFactory<Dish,Integer>("Rid"));
    colDishId1.setCellValueFactory(new PropertyValueFactory<Dish,Integer>("id"));
    colDishName1.setCellValueFactory(new PropertyValueFactory<Dish,String>("Name"));


     dishTable.setItems(data);
        dishTable.setItems(data);
       // dishTable.getItems().addAll(data);
        dishTable.refresh();


    }

    private void populateTable(ObservableList<String> dishList){
        dishTable.setItems(dishList);
        dishTable.getItems().addAll(dishList);
        dishTable.refresh();
    }

    @FXML
    private void searchDish(ActionEvent event) throws ClassNotFoundException, SQLException{
       // ObservableList<Dish> list = AdmDishDAO.searchDish(searchId.getText());

     /*   if (list.size()>0){
            populateTable(list);
            resultConsole.setText("Record has been found");
        }else{
            resultConsole.setText("No such records ");
        }
*/

    }


    @FXML
    private void searchAllDishes(ActionEvent event) throws ClassNotFoundException,SQLException{
       // ObservableList<Dish> dishList = AdmDishDAO.getAllRecords();
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

    public void return_back_customer(ActionEvent event) throws Exception{
        try {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Your order has been sent!");
            alert.showAndWait();
            Parent root = FXMLLoader.load(getClass().getResource("/CustomerPackage/CustomerView.fxml"));
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


    public void return_back_customer1(ActionEvent event) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/CustomerPackage/CustomerView.fxml"));
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
