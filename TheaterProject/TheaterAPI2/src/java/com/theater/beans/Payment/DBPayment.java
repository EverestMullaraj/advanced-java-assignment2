package com.theater.beans.Payment;


import static DataBases.DBService.conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBPayment {

    public DBPayment() {

    }

    public void createTable() {
        try {
            String query = "create table if not exists payment ( 	PaymentId INT AUTO_INCREMENT,	CustomerId INT,	CustomerName VARCHAR(30),	PaymentDate DATE,	ReservationNumber INT,	TotalAmount DOUBLE, PRIMARY KEY(PaymentId) )";
            PreparedStatement st = conn.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteObject(Object o) {
        try {
            Payment p = (Payment) o;
            String query = "delete from payment where PaymentId = ?";
            PreparedStatement st = conn.prepareStatement(query);

            st.setInt(1, p.getPaymentId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Payment findindDatabase(Payment p) {
        try {
            String query = "select * from payment where PaymentId = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, p.getPaymentId());
            ResultSet rs = st.executeQuery(query);
            p.setPaymentId(rs.getInt(1));
            p.setCustomerId(rs.getInt(2));
            p.setCustomerName(rs.getString(3));
            p.setPaymentDate(rs.getDate(4));
            p.setReservationNumber(rs.getInt(5));
            p.setTotalAmount(rs.getDouble(6));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Payment insertObject(Payment p) {
        try {
            String query = "insert into payment( 	CustomerId ,	CustomerName ,	PaymentDate ,	ReservationNumber ,	TotalAmount ) VALUES (?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, p.getCustomerId());
            st.setString(2, p.getCustomerName());
            st.setDate(3, p.getPaymentDate());
            st.setInt(4, p.getReservationNumber());
            st.setDouble(5, p.getTotalAmount());
            st.executeUpdate();
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Object rstoObject(ResultSet rs) {
        try {
            Payment p = new Payment();
            p.setPaymentId(rs.getInt(1));
            p.setCustomerId(rs.getInt(2));
            p.setCustomerName(rs.getString(3));
            p.setPaymentDate(rs.getDate(4));
            p.setReservationNumber(rs.getInt(5));
            p.setTotalAmount(rs.getDouble(6));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateObject(Object o) {
        try {
            Payment p = (Payment) o;
            String query = "update  payment set 	CustomerId=? ,	CustomerName=? ,	PaymentDate=? ,	ReservationNumber=? ,	TotalAmount=? where PaymentId = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, p.getCustomerId());
            st.setString(2, p.getCustomerName());
            st.setDate(3, p.getPaymentDate());
            st.setInt(4, p.getReservationNumber());
            st.setDouble(5, p.getTotalAmount());
            st.setInt(6, p.getPaymentId());
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Payment> loadData() {
        ArrayList<Payment> l = new ArrayList();
        try {

            String query = "SELECT  TAB_1.*"
                    + " FROM payment AS TAB_1"
                    + " GROUP BY(TAB_1.PaymentId) ";
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Payment obj = (Payment) rstoObject(rs);

                l.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

}
