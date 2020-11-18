/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package officesoftware;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mpun0
 */
public class StockController implements Initializable {
    @FXML
    private ComboBox<?> catCombo;

    @FXML
    private ComboBox<?> itemCombo;

    @FXML
    private DatePicker stockDate;

    @FXML
    private TextField qtyTxt;

    @FXML
    private Button addbtn;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
