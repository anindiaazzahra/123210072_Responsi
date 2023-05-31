/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123210072_responsi.DAO;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pkg123210072_responsi.DAOImplement.Implement_Movie;
import pkg123210072_responsi.Koneksi.Koneksi;
import pkg123210072_responsi.Model.Model_Movie;


public class DAO_Movie implements Implement_Movie{
    
    Connection connection;
    
    final String insert = "INSERT INTO movie (judul, alur, penokohan, akting, nilai) VALUES (?,?,?,?,?);";
    final String update = "UPDATE movie set alur=?, penokohan=?, akting=?, nilai=? where judul=?;";
    final String delete = "DELETE FROM movie where judul=?;";
    final String select = "SELECT * FROM movie;";
    
    public DAO_Movie() {
        connection = (Connection) Koneksi.connection();
    }
    
    @Override
    public void insert(Model_Movie m) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            statement.setDouble(5, m.getNilai());
            
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            
        } catch(SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Judul tidak boleh sama");
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Model_Movie m) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setDouble(1, m.getAlur());
            statement.setDouble(2, m.getPenokohan());
            statement.setDouble(3, m.getAkting());
            statement.setDouble(4, m.getNilai());
            statement.setString(5, m.getJudul());
            
            statement.executeUpdate();
           
            
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            
            statement.executeUpdate();
           
            
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Model_Movie> getAll() {
        java.util.List<Model_Movie> lm = null;
        
        try{
            lm = new ArrayList<Model_Movie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            
            while(rs.next()) {
                Model_Movie m = new Model_Movie();
                m.setJudul(rs.getString("judul"));
                m.setAlur(rs.getDouble("alur"));
                m.setPenokohan(rs.getDouble("penokohan"));
                m.setAkting(rs.getDouble("akting"));
                m.setNilai(rs.getDouble("nilai"));
                
                lm.add(m);
            }
            
        } catch(SQLException ex){
            Logger.getLogger(DAO_Movie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lm;
    }
    
}
