/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package officesoftware;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author mpun0
 */
public class LoginController implements Initializable {

    @FXML
    private TextField userTxt;

    @FXML
    private PasswordField passTxt;

    @FXML
    private Button loginBtn;

    @FXML
    private Button cancelBtn;

    Database data = new Database();
    Connection conn = data.getConn();

    Statement st = null;
    PreparedStatement pre;
    //ResultSet rs = null;
    ResultSet rs;

    public LoginController() throws SQLException {
        try {
            // TODO
            createtable();
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    void cancelaction(ActionEvent event) {
        userTxt.setText("");
        passTxt.setText("");
    }

    @FXML
    void loginaction(ActionEvent event) throws IOException {

        String username = userTxt.getText();
        String password = passTxt.getText();

        if (username.isEmpty()) {
            System.out.println("empty cha");
            infoBox("There is no user name", "Fail to Login", "No user name");

        } else if (password.isEmpty()) {
            System.out.println("empty cha");
            infoBox("There is no Password", "Fail to Login", "No Password");

        } else {
            System.out.println("there are things to do ");

            try {

                pre = conn.prepareStatement("SELECT * FROM user WHERE username = ? and password = ?");
                pre.setString(1, username);
                pre.setString(2, password);
                rs = pre.executeQuery();
                if (!rs.next()) {

                    infoBox("Enter Correct Email and Password", "fail", null);
                } else {
                    infoBox("Login Successfull", "Pass", null);

                    ((Node) event.getSource()).getScene().getWindow().hide();
                    Stage mgmtStage = new Stage();
                    try {

                        FXMLLoader loader = new FXMLLoader();
                        Parent root = FXMLLoader.load(getClass().getResource("Management.fxml"));
                        Scene scene = new Scene(root);
                        mgmtStage.setScene(scene);

                    } catch (IOException e) {
                        System.out.println(e);

                    }
                    //ManagementController mgmt = new ManagementController();
                    // mgmt.getUser(user);
                    //System.out.println(user);

                   // mgmtStage.getIcons().add(new Image(getClass().getResourceAsStream("images/man-user.png")));
                    mgmtStage.setTitle("Stock Management");

                    mgmtStage.show();
                }

            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    public void createtable() throws SQLException {
        st = data.getConn().createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS User(user_id int NOT NULL AUTO_INCREMENT ,username varchar(255),password varchar(255),PRIMARY KEY (user_id))";
        st.execute(sql);
        st.close();
    }

}
