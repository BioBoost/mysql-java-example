/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mymovies;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sille
 */
public class MovieDatabase {
    private Connection connection;
    private Statement statement;
    private ResultSet resultset;
    
    public MovieDatabase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/mymovies?user=root");        
            statement = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList getTitles(){
        ArrayList result = new ArrayList();
        try {
            resultset = statement.executeQuery("SELECT id, title FROM mymovies");
            while(resultset.next()){
                int id = resultset.getInt("id");
                String title = resultset.getString("title");
                result.add(new MovieTitle(id, title));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

    Movie getMovie(int id) {
        Movie movie = null;
        try {
            resultset = statement.executeQuery(
                    "SELECT * FROM mymovies WHERE id=" + id
            );
            if(resultset.next()){
                id = resultset.getInt("id");
                String title = resultset.getString("title");
                String description = resultset.getString("description");
                int year = resultset.getInt("year");
                int duration = resultset.getInt("duration");
                movie = new Movie(id, title, description, duration, year);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movie;
    }

    void saveMovie(Movie movie) {
        try{
            String query = 
                    "INSERT INTO mymovies (title, description, year, duration)"
                            + " VALUES('"
                            + movie.title + "', '"
                            + movie.description + "', '"
                            + movie.year + "', '"
                            + movie.duration
                            + "')";
            System.out.println(query);
            statement.executeUpdate(query);
        } catch(SQLException ex){
            System.out.println(ex);
        }
    }

    void deleteMovie(int id) {
        try{
            String query = "DELETE FROM mymovies WHERE id=" + id;
            statement.executeUpdate(query);            
        } catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
}
