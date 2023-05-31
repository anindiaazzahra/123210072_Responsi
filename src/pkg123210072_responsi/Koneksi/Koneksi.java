/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123210072_responsi.Koneksi;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class Koneksi {
    
    static Connection con;
    
    public static Connection connection() {
        MysqlDataSource data = new MysqlDataSource();
        
        data.setDatabaseName("movie_db");
        data.setUser("root");
        data.setPassword("");
        
        try {
            con = (Connection)  data.getConnection();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return con;
    }
    
}
