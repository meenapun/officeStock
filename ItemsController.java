/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package officesoftware;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mpun0
 */
public class ItemsController implements Initializable {

    Database data = new Database();
    Connection conn = data.getConn();
    Statement stmt = conn.createStatement();
    ResultSet rs;

    @FXML
    private ComboBox<String> catCombo;

    @FXML
    private TextField itemtxt;

    @FXML
    private Button addBtn;

    @FXML
    private TableView<Stock> table;

    @FXML
    private TableColumn<Stock, Integer> serialNumber;

    @FXML
    private TableColumn<Stock, Integer> catName;

    @FXML
    private TableColumn<Stock, String> itemName;

    ObservableList<String> itemlists = FXCollections.observableArrayList();

    public ItemsController() throws SQLException {

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        catCombo.setItems(itemlists);
        System.out.println(itemlists);
    }

    public void itemNames() {

    }

    public void comboNames() throws SQLException {
        stmt = conn.createStatement();
        String SQLQuery = ("SELECT  * FROM categroy");
        rs = stmt.executeQuery(SQLQuery);
        while (rs.next()) {
            itemlists.add(rs.getString("catName"));
            //itemlists.add(rs.getString("catId"));

        }

    }

}
