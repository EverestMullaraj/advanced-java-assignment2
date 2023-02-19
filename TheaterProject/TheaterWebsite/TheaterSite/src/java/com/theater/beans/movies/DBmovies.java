	 
package com.theater.beans.movies;

import static DataBases.DBService.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBmovies {

    public void createTable() {
        try {
            String query = "create table if not exists movies ( 	MovieId INT AUTO_INCREMENT,	MovieName VARCHAR(30),	Author VARCHAR(30),	PublishedDate DATE,	ManagerName VARCHAR(30), PRIMARY KEY(MovieId) )";
            PreparedStatement st = conn.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBmovies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteObject(Object o) {
        try {
            Movie p = (Movie) o;
            String query = "delete from movies where MovieId = ?";
            PreparedStatement st = conn.prepareStatement(query);

            st.setInt(1, p.getMovieId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBmovies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Movie findindDatabase(Movie p) {
        try {
            String query = "select * from movies where MovieId = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, p.getMovieId());
            ResultSet rs = st.executeQuery(query);
            p.setMovieId(rs.getInt(1));
            p.setMovieName(rs.getString(2));
            p.setAuthor(rs.getString(3));
            p.setPublishedDate(rs.getDate(4));
            p.setManagerName(rs.getString(5));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBmovies.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Movie insertObject(Movie p) {
        try {
            String query = "insert into movies( 	MovieName ,	Author ,	PublishedDate ,	ManagerName  ) VALUES (?,?,?,? )";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, p.getMovieName());
            st.setString(2, p.getAuthor());
            st.setDate(3, p.getPublishedDate());
            st.setString(4, p.getManagerName());
            st.executeUpdate();
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBmovies.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Object rstoObject(ResultSet rs) {
        try {
            Movie p = new Movie();
            p.setMovieId(rs.getInt(1));
            p.setMovieName(rs.getString(2));
            p.setAuthor(rs.getString(3));
        //    p.setPublishedDate(rs.getDate(4));
            p.setManagerName(rs.getString(5));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBmovies.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateObject(Object o) {
        try {
            Movie p = (Movie) o;
            String query = "update  movies set 	MovieName=? ,	Author=? ,	PublishedDate=? ,	ManagerName=? where MovieId = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, p.getMovieName());
            st.setString(2, p.getAuthor());
            st.setDate(3, p.getPublishedDate());
            st.setString(4, p.getManagerName());
            st.setInt(5, p.getMovieId());
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBmovies.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Movie> loadData() {
        ArrayList<Movie> l = new ArrayList();
        try {

            String query = "SELECT  TAB_1.*"
                    + " FROM movies AS TAB_1"
                    + " GROUP BY(TAB_1.MovieId) ";
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Movie obj = (Movie) rstoObject(rs);
                System.out.println("ssss");
                l.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

}
