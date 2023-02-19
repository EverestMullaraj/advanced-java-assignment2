package com.theater.beans.MovieShow;

import static DataBases.DBService.conn;
import com.theater.beans.reservation.Reservation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBMovieShow {

    public void createTable() {
        try {
            String query = "create table if not exists movieshow ( 	ShowId INT AUTO_INCREMENT,	RoomId INT,	MovieId INT,	MovieName VARCHAR(30),	Date DATE,	StartTime DATE,	EndTime DATE,	BookingFee DOUBLE, PRIMARY KEY(ShowId) )";
            PreparedStatement st = conn.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteObject(Object o) {
        try {
            MovieShow p = (MovieShow) o;
            String query = "delete from movieshow where ShowId = ?";
            PreparedStatement st = conn.prepareStatement(query);

            st.setInt(1, p.getShowId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MovieShow findindDatabase(MovieShow p) {
        try {
            String query = "select * from movieshow where MovieName = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, p.getMovieName());
            ResultSet rs = st.executeQuery();
            rs.next();
            p.setShowId(rs.getInt(1));
            p.setRoomId(rs.getInt(2));
            p.setMovieId(rs.getInt(3));
            p.setMovieName(rs.getString(4));
            p.setDate(rs.getDate(5));
            p.setStartTime(rs.getDate(6));
            p.setEndTime(rs.getDate(7));
            p.setBookingFee(rs.getDouble(8));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public MovieShow insertObject(MovieShow p) {
        try {
            String query = "insert into movieshow( 	RoomId ,	MovieId ,	MovieName ,	Date ,	StartTime ,	EndTime ,	BookingFee ) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, p.getRoomId());
            st.setInt(2, p.getMovieId());
            st.setString(3, p.getMovieName());
            st.setDate(4, p.getDate());
            st.setDate(5, p.getStartTime());
            st.setDate(6, p.getEndTime());
            st.setDouble(7, p.getBookingFee());
            st.executeUpdate();
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Object rstoObject(ResultSet rs) {
        try {
            MovieShow p = new MovieShow();
            p.setShowId(rs.getInt(1));
            p.setRoomId(rs.getInt(2));
            p.setMovieId(rs.getInt(3));
            p.setMovieName(rs.getString(4));
            p.setDate(rs.getDate(5));
            p.setStartTime(rs.getDate(6));
            p.setEndTime(rs.getDate(7));
            p.setBookingFee(rs.getDouble(8));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateObject(Object o) {
        try {
            MovieShow p = (MovieShow) o;
            String query = "update  movieshow set 	RoomId=? ,	MovieId=? ,	MovieName=? ,	Date=? ,	StartTime=? ,	EndTime=? ,	BookingFee=? where ShowId = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, p.getRoomId());
            st.setInt(2, p.getMovieId());
            st.setString(3, p.getMovieName());
            st.setDate(4, p.getDate());
            st.setDate(5, p.getStartTime());
            st.setDate(6, p.getEndTime());
            st.setDouble(7, p.getBookingFee());
            st.setInt(8, p.getShowId());
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBMovieShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<MovieShow> loadData() {
        ArrayList<MovieShow> l = new ArrayList();
        try {

            String query = "SELECT  TAB_1.*"
                    + " FROM movieshow AS TAB_1"
                    + " GROUP BY(TAB_1.ShowId) ";
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                MovieShow obj = (MovieShow) rstoObject(rs); 
                 
                l.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

}
