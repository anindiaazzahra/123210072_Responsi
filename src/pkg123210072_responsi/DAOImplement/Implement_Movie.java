/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123210072_responsi.DAOImplement;

import pkg123210072_responsi.Model.Model_Movie;

public interface Implement_Movie {
    
    public void insert(Model_Movie m);
    
    public void update(Model_Movie m);
    
    public void delete(String judul);
    
    java.util.List<Model_Movie> getAll();
}
