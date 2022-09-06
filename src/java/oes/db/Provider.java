
package oes.db;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Provider {
    
    public static Connection getOracleConnection(){
        Connection con;
        con = null;
        try {
           
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examdb","root","");
                System.out.println("Connection Successful, Yippe!!!");
            } catch (SQLException ex) {
                System.err.println("ERROR -> SQLException");
                Logger.getLogger(Provider.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR -> ClassNotFoundException");
            Logger.getLogger(Provider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
