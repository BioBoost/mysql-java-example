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
public class Movie extends MovieTitle{
    public String description;
    public int year;
    public int duration;

    public Movie(int id, String title) {
        super(id, title);
    }
    
    public Movie(int id, String title, String description, int duration, int year){
        super(id, title);
        this.description = description;
        this.year = year;
        this.duration = duration;
    }
    
}
