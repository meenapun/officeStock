/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package officesoftware;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mpun0
 */
public class BorrowController implements Initializable {

    Database data = new Database();
    Connection conn = data.getConn();

    @FXML
    private ComboBox<?> catCombo;

    @FXML
    private ComboBox<?> itemCombo;

    @FXML
    private DatePicker borrowDate;

    @FXML
    private TextField borrowFrmText;

    @FXML
    private TextField qtyTxt;

    @FXML
    private DatePicker returnDate;

    @FXML
    private TextField returned;

    @FXML
    private Button addBtn;

    /**
     * Initializes the controller class.
     *
     * @throws java.sql.SQLException
     */
    public BorrowController() throws SQLException {
        //// The header
        //The content text
        // The confirmation buttons

        Alert borrowyesnobox = new Alert(Alert.AlertType.WARNING);
        borrowyesnobox.setContentText("This is to remind you ");
        ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
        borrowyesnobox.getButtonTypes().setAll(okButton, noButton);
        borrowyesnobox.showAndWait();
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("No information.");
        alert.showAndWait();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
