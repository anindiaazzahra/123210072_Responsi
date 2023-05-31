/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123210072_responsi.Controller;

import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import pkg123210072_responsi.DAO.DAO_Movie;
import pkg123210072_responsi.DAOImplement.Implement_Movie;
import pkg123210072_responsi.Model.Model_Movie;
import pkg123210072_responsi.Model.Tabel_Model_Movie;
import pkg123210072_responsi.View.View_Movie;

public class Controller_Movie {
   
    View_Movie frame_movie;
    Implement_Movie implement_movie;
    java.util.List<Model_Movie> list_movie;
    
    
    public Controller_Movie(View_Movie frame_movie) {
        this.frame_movie = frame_movie;
        implement_movie = new DAO_Movie();
        list_movie = implement_movie.getAll();
    }
    
    // Tombol Reset
    public void reset(){
        frame_movie.getTxtJudul().setText("");
        frame_movie.getTxtAlur().setText("");
        frame_movie.getTxtPenokohan().setText("");
        frame_movie.getTxtAkting().setText("");
    }
    
    // Menampilkan Data ke Tabel
    public void isiTabel(){
        list_movie = implement_movie.getAll();
        Tabel_Model_Movie tabel = new Tabel_Model_Movie(list_movie);
        
        frame_movie.getTabelMovie().setModel(tabel);
    }
    
    // Menampilkan Data ke Form Ketika Data di Klik
    public void isiField(int row) {
        frame_movie.getTxtJudul().setText(list_movie.get(row).getJudul());
        frame_movie.getTxtAlur().setText(list_movie.get(row).getAlur().toString());
        frame_movie.getTxtPenokohan().setText(list_movie.get(row).getPenokohan().toString());
        frame_movie.getTxtAkting().setText(list_movie.get(row).getAkting().toString());
    }
    
    // Insert data dari form ke database
    public void insert(){
        try {
            if(!frame_movie.getTxtJudul().getText().trim().isEmpty() &&
                !frame_movie.getTxtAlur().getText().trim().isEmpty() &&
                !frame_movie.getTxtPenokohan().getText().trim().isEmpty() &&
                !frame_movie.getTxtAkting().getText().trim().isEmpty()) {
                Model_Movie m = new Model_Movie();
                m.setJudul(frame_movie.getTxtJudul().getText());
                m.setAlur(Double.parseDouble(frame_movie.getTxtAlur().getText()));
                m.setPenokohan(Double.parseDouble(frame_movie.getTxtPenokohan().getText()));
                m.setAkting(Double.parseDouble(frame_movie.getTxtAkting().getText()));
                // m.setNilai(Double.parseDouble(frame_movie.getTxtNilai().getText()));

                implement_movie.insert(m);
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            } else {
                JOptionPane.showMessageDialog(frame_movie, "Data tidak boleh kosong");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame_movie, "Masukkan input yang valid");
        }
        return;
    }
    
    // update data dari tabel ke database
    public void update(){
        try {
            if(!frame_movie.getTxtJudul().getText().trim().isEmpty()) {
                Model_Movie m = new Model_Movie();
                m.setJudul(frame_movie.getTxtJudul().getText());
                m.setAlur(Double.parseDouble(frame_movie.getTxtAlur().getText()));
                m.setPenokohan(Double.parseDouble(frame_movie.getTxtPenokohan().getText()));
                m.setAkting(Double.parseDouble(frame_movie.getTxtAkting().getText()));


                implement_movie.update(m);
                JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
            } else {
                JOptionPane.showMessageDialog(frame_movie, "Silakan Pilih Data");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame_movie, "Masukkan input yang valid");
        }  
        return;
    }
    
    // delete data
    public void delete(){
        if(!frame_movie.getTxtJudul().getText().trim().isEmpty()) {
            String judul = frame_movie.getTxtJudul().getText();
            implement_movie.delete(judul);


            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } else {
            JOptionPane.showMessageDialog(frame_movie, "Silakan Pilih Data");
        }
    }
    
}
