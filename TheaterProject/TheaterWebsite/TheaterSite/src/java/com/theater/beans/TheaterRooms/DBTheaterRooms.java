	//created with
//Class Coder Application
//To get Latest Version Contact eloquencetechs@gmail.com
//Eloquence Technalogies Islamabad, Pakistan
package com.theater.beans.TheaterRooms;

import static DataBases.DBService.conn;
import com.theater.beans.MovieShow.MovieShow;
import static com.theater.beans.MovieShow.MovieShow.idOptions;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBTheaterRooms {

    public void createTable() {
        try {
            String query = "create table if not exists theaterrooms ( 	RoomId INT AUTO_INCREMENT,	MovieID INT,	MovieName INT,	OpeningTime DATE,	ClosingTime DATE,	Manager DATE,	TotalMovies INT,	TotalEarn DOUBLE, PRIMARY KEY(RoomId) )";
            PreparedStatement st = conn.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBTheaterRooms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteObject(Object o) {
        try {
            TheaterRooms p = (TheaterRooms) o;
            String query = "delete from theaterrooms where RoomId = ?";
            PreparedStatement st = conn.prepareStatement(query);

            st.setInt(1, p.getRoomId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBTheaterRooms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TheaterRooms findindDatabase(TheaterRooms p) {
        try {
            String query = "select * from theaterrooms where RoomId = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, p.getRoomId());
            ResultSet rs = st.executeQuery(query);
            p.setRoomId(rs.getInt(1));
            p.setMovieID(rs.getInt(2));
            p.setMovieName(rs.getInt(3));
            p.setOpeningTime(rs.getDate(4));
            p.setClosingTime(rs.getDate(5));
            p.setManager(rs.getDate(6));
            p.setTotalMovies(rs.getInt(7));
            p.setTotalEarn(rs.getDouble(8));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBTheaterRooms.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public TheaterRooms insertObject(TheaterRooms p) {
        try {
            String query = "insert into theaterrooms( 	MovieID ,	MovieName ,	OpeningTime ,	ClosingTime ,	Manager ,	TotalMovies ,	TotalEarn ) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, p.getMovieID());
            st.setInt(2, p.getMovieName());
            st.setDate(3, p.getOpeningTime());
            st.setDate(4, p.getClosingTime());
            st.setDate(5, p.getManager());
            st.setInt(6, p.getTotalMovies());
            st.setDouble(7, p.getTotalEarn());
            st.executeUpdate();
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBTheaterRooms.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Object rstoObject(ResultSet rs) {
        try {
            TheaterRooms p = new TheaterRooms();
            p.setRoomId(rs.getInt(1));
            p.setMovieID(rs.getInt(2));
            p.setMovieName(rs.getInt(3));
            p.setOpeningTime(rs.getDate(4));
            p.setClosingTime(rs.getDate(5));
            p.setManager(rs.getDate(6));
            p.setTotalMovies(rs.getInt(7));
            p.setTotalEarn(rs.getDouble(8));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBTheaterRooms.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateObject(Object o) {
        try {
            TheaterRooms p = (TheaterRooms) o;
            String query = "update  theaterrooms set 	MovieID=? ,	MovieName=? ,	OpeningTime=? ,	ClosingTime=? ,	Manager=? ,	TotalMovies=? ,	TotalEarn=? where RoomId = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, p.getMovieID());
            st.setInt(2, p.getMovieName());
            st.setDate(3, p.getOpeningTime());
            st.setDate(4, p.getClosingTime());
            st.setDate(5, p.getManager());
            st.setInt(6, p.getTotalMovies());
            st.setDouble(7, p.getTotalEarn());
            st.setInt(8, p.getRoomId());
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBTheaterRooms.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ArrayList<TheaterRooms> loadData() { 
        ArrayList<TheaterRooms> l = new ArrayList();
        try {

            String query = "SELECT  TAB_1.*"
                    + " FROM theaterrooms AS TAB_1"
                    + " GROUP BY(TAB_1.RoomId) ";
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                
                TheaterRooms obj = (TheaterRooms) new DBTheaterRooms().rstoObject(rs); 
                
                l.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheaterRooms.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

}
