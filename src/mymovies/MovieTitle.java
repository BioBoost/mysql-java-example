/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mymovies;

/**
 *
 * @author Sille
 */
public class MovieTitle {
    public int id;
    public String title;
    
    public MovieTitle(int id, String title){
        this.id = id;
        this.title = title;
    }
    
    @Override
    public String toString(){
        return title;
    }            
}
