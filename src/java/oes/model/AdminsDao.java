
package oes.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oes.db.Admins;
import oes.db.Provider;


public class AdminsDao {
    
    public static boolean doValidate(Admins ad){
        
        boolean status = false;
        
        try{
            Connection con = Provider.getOracleConnection();
            String sql = "select * from admintable where userid=? and password=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ad.getUsername());
            pst.setString(2, ad.getPassword());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                status = true;
            }else{
                status = false;
                System.out.println("ERROR! -> Connection status = false");
            }
        }catch(SQLException e){
            System.out.println("ERROR! -> SQLException");
            System.out.println(e);
        }
        return status;
    }
    
}
