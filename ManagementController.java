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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mpun0
 */
public class ManagementController implements Initializable {

    Database data = new Database();
    Connection conn = data.getConn();
    Statement st = null;
    PreparedStatement pre;
    //ResultSet rs = null;
    ResultSet rs;

    public ManagementController() throws SQLException {
        createCatTable();
        createItemsTable();
        createBorrowTable();
        createStockTable();
        createPurchaseTable();

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //createPurchaseTable();
    }

    @FXML
    void displayBorrow(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Borrow.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void displayCat(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("category.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void displayItems(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Items.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void displayPurchase(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Purchase.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void displayStock(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Stock.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void createPurchaseTable() throws SQLException {
        st = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS`purchase` (\n"
                + "  `purchase_id` INT NOT NULL AUTO_INCREMENT,\n"
                + "  `item_id` INT NOT NULL,\n"
                + "  `purchase_date` DATE NULL,\n"
                + "  `purchse_qty` INT NULL,\n"
                + "  `price` FLOAT NULL,\n"
                + "  `purchase_shop` VARCHAR(45) NULL,\n"
                + "  PRIMARY KEY (`purchase_id`),\n"
                + "  INDEX `purchase_idx` (`item_id` ASC) VISIBLE,\n"
                + "  CONSTRAINT `purchase`\n"
                + "    FOREIGN KEY (`item_id`)\n"
                + "    REFERENCES `officesoftware`.`items` (`items_id`)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION)";
        st.executeUpdate(sql);
        st.close();
        System.out.println("Created Purchase Table");
    }

    public void createStockTable() throws SQLException {
        st = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS`stock` (\n"
                + "  `stock_id` INT NOT NULL AUTO_INCREMENT,\n"
                + "  `item_id` INT NOT NULL,\n"
                + "  `check_date` DATE NULL,\n"
                + "  `stock` INT NULL,\n"
                + "  PRIMARY KEY (`stock_id`),\n"
                + "  INDEX `stock_idx` (`item_id` ASC) VISIBLE,\n"
                + "  CONSTRAINT `stock`\n"
                + "    FOREIGN KEY (`item_id`)\n"
                + "    REFERENCES `officesoftware`.`items` (`items_id`)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION);";

        st.executeUpdate(sql);
        st.close();
        System.out.println("Created Stock Table");
    }

    public void createBorrowTable() throws SQLException {
        st = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS`borrow` (\n"
                + "  `borrow_id` INT NOT NULL AUTO_INCREMENT,\n"
                + "  `item_id` INT NOT NULL,\n"
                + "  `borrow_from` VARCHAR(45) NULL,\n"
                + "  `borrow_date` DATE NULL,\n"
                + "  `return_date` DATE NULL,\n"
                + "  PRIMARY KEY (`borrow_id`),\n"
                + "  INDEX `item_idx` (`item_id` ASC) VISIBLE,\n"
                + "  CONSTRAINT `item`\n"
                + "    FOREIGN KEY (`item_id`)\n"
                + "    REFERENCES `officesoftware`.`items` (`items_id`)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION);";
        st.executeUpdate(sql);
        st.close();
        System.out.println("Created Borrow Table");

    }

    public void createItemsTable() throws SQLException {
        st = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS `items` (\n"
                + "  `items_id` INT NOT NULL AUTO_INCREMENT,\n"
                + "  `itemName` VARCHAR(45) NULL,\n"
                + "  `catId` INT NULL,\n"
                + "  PRIMARY KEY (`items_id`),\n"
                + "  INDEX `catName_idx` (`catId` ASC) VISIBLE,\n"
                + "  CONSTRAINT `catName`\n"
                + "    FOREIGN KEY (`catId`)\n"
                + "    REFERENCES `officesoftware`.`category` (`cat_id`)\n"
                + "    ON DELETE NO ACTION\n"
                + "    ON UPDATE NO ACTION);";
        st.executeUpdate(sql);
        st.close();
        System.out.println("Created Item Table");

    }

    public void createCatTable() throws SQLException {
        st = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS `category` (\n"
                + "  `cat_id` INT NOT NULL AUTO_INCREMENT,\n"
                + "  `catName` VARCHAR(45) NOT NULL,\n"
                + "  PRIMARY KEY (`cat_id`));";
        st.executeUpdate(sql);
        st.close();
        System.out.println("Created Category Table");
    }

}
