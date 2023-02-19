	 
package com.theater.beans.reservation;

import static DataBases.DBService.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBReservation {

    public void createTable() {
        try {
            String query = "create table if not exists Reservation ( 	Id INT AUTO_INCREMENT,	ShowId INT,	UserId INT,	MovieName VARCHAR(30),	Date DATE,	TotalPrice DOUBLE,TotalSeats INT, PRIMARY KEY(Id) )";
            PreparedStatement st = conn.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteObject(Object o) {
        try {
            Reservation p = (Reservation) o;
            String query = "delete from Reservation where Id = ?";
            PreparedStatement st = conn.prepareStatement(query);

            st.setInt(1, p.getId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Reservation findindDatabase(Reservation p) {
        try {
            String query = "select * from Reservation where Id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, p.getId());
            ResultSet rs = st.executeQuery(query);
            p.setId(rs.getInt(1));
            p.setShowId(rs.getInt(2));
            p.setUserId(rs.getInt(3));
            p.setMovieName(rs.getString(4));
            p.setDate(rs.getDate(5));
            p.setTotalPrice(rs.getDouble(6));
            p.setTotalSeats(rs.getInt(7));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Reservation insertObject(Reservation p) {
        try {
            String query = "insert into Reservation( 	ShowId ,	UserId ,	MovieName ,	Date ,	TotalPrice ,TotalSeats) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, p.getShowId());
            st.setInt(2, p.getUserId());
            st.setString(3, p.getMovieName());
            st.setDate(4, p.getDate());
            st.setDouble(5, p.getTotalPrice());
            st.setInt(6, p.getTotalSeats());
            st.executeUpdate();
            try {
                st = conn.prepareStatement("SELECT max(Id) FROM Reservation");
                ResultSet rs = st.executeQuery();
                rs.next();
                p.setId(rs.getInt(1));

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Object rstoObject(ResultSet rs) {
        try {
            Reservation p = new Reservation();
            p.setId(rs.getInt(1));
            p.setShowId(rs.getInt(2));
            p.setUserId(rs.getInt(3));
            p.setMovieName(rs.getString(4));
            p.setDate(rs.getDate(5));
            p.setTotalPrice(rs.getDouble(6));
            p.setTotalSeats(rs.getInt(7));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateObject(Object o) {
        try {
            Reservation p = (Reservation) o;
            String query = "update  Reservation set 	ShowId=? ,	UserId=? ,	MovieName=? ,	Date=? ,	TotalPrice=? ,TotalSeats=? where Id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, p.getShowId());
            st.setInt(2, p.getUserId());
            st.setString(3, p.getMovieName());
            st.setDate(4, p.getDate());
            st.setDouble(5, p.getTotalPrice());
            st.setInt(6, p.getTotalSeats());
            st.setInt(7, p.getId());
            
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList loadData() {
        ArrayList l = new ArrayList();
        try {

            String query = "SELECT  TAB_1.*"
                    + " FROM Reservation AS TAB_1 "
                     +dashboard.dashboard.WhereQuery ;
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Reservation obj = (Reservation) rstoObject(rs);
                System.out.println("sss");
                l.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

}
