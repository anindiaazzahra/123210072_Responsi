/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123210072_responsi.Model;

import javax.swing.table.AbstractTableModel;

public class Tabel_Model_Movie  extends AbstractTableModel{
    
    java.util.List<Model_Movie> list_movie;
    
    public Tabel_Model_Movie(java.util.List<Model_Movie> list_movie) {
        this.list_movie = list_movie;
    }

    @Override
    public int getRowCount() {
        return list_movie.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Judul";
            case 1:
                return "Alur";            
            case 2:
                return "Penokohan"; 
            case 3:
                return "Akting"; 
            case 4:
                return "Niali"; 
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0:
                return list_movie.get(row).getJudul();
            case 1:
                return list_movie.get(row).getAlur();            
            case 2:
                return list_movie.get(row).getPenokohan(); 
            case 3:
                return list_movie.get(row).getAkting(); 
            case 4:
                return list_movie.get(row).getNilai(); 
            default:
                return null;
        }
    }
    
    
}
