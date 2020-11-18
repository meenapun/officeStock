/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package officesoftware;

import com.mysql.cj.protocol.Resultset;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author mpun0
 */
public class CategoryController implements Initializable {

    Database data = new Database();
    Connection conn = data.getConn();

    @FXML
    private TextField catNameTxt;

    @FXML
    private Button addbtn;

    ObservableList<Stock> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Stock, Integer> serialNo;

    @FXML
    private TableColumn<Stock, String> catNmaes;

    @FXML
    private TableView<Stock> table;

    public CategoryController() throws SQLException {

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            // TODO
            catagories();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //serialNo.setCellValueFactory(new PropertyValueFactory<meena   meena>("serial"));
        serialNo.setCellValueFactory(new PropertyValueFactory<>("serial"));
        catNmaes.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        table.setItems(list);
        System.out.println(list);
       

    }

    public void addcat(ActionEvent event) throws SQLException {
        String catName;
        catName = catNameTxt.getText();
        System.out.println(catName);
        //databse ma addd garnee
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Do you want to Save");
        alert.setContentText("Do you want to Save?     " + "Catgory Name :- " + catName + "");
        ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
        ButtonType cancelButton = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(okButton, noButton, cancelButton);

        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO category(catName)  VALUES ( '" + catName + " ')";
        //System.out.println(sql);
        alert.showAndWait().ifPresent((ButtonType type) -> {
            if (type == okButton) {
                System.out.println(sql);
                try {
                    stmt.executeUpdate(sql);
                    //here insert is done ///

                } catch (SQLException ex) {
                    Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (type == noButton) {
                System.out.println("this is no button");

            }
            if (type == cancelButton) {
                System.out.println("this is exit");
                //Platform.exit();
                ((Node) event.getSource()).getScene().getWindow().hide();

            }
        });

        //add garda are you sure bhanne
        // screen clear garne
        catNameTxt.setText("");

    }

    public void catagories() throws SQLException {
        list.clear();
        Statement stmt = conn.createStatement();
        String sql = "SELECT *FROM category";
        System.out.println(sql);
        ResultSet rs;
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            // see the database to put the columns from it
            //list.add(new Stock(rs.getInt("cat_id"), rs.getString("catName")));
            list.add(new Stock(rs.getInt(1),rs.getString(2)));

        }
    }

}
