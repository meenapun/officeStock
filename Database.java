
package officesoftware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;



public class Database {

    public Connection conn;
    
    
    public Database() throws SQLException{
        String Urldatabase = "jdbc:mysql://localhost:3306/officeSoftware?zeroDateTimeBehavior=convertToNull";
        String Username = "root";
        String Password = "pokhara061";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rssbbook?useSSL=false","root","Pokhara061");
            conn = DriverManager.getConnection(Urldatabase, Username, Password);
            System.out.println("diver has been installed");

        } catch (ClassNotFoundException | SQLException e) {
        System.out.println(e);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Information about Database");
        alert.setContentText("Please On Your Database!!!");
        alert.showAndWait();
        }
   
    }
    /**
     * @return the conn // database on
     */
    public Connection getConn() {
        return conn;
    }
    // closing database
    public void dataclose() throws SQLException{
        getConn().close();
    }
    
    }

    
