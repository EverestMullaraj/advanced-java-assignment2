	//created with
//Class Coder Application
//To get Latest Version Contact eloquencetechs@gmail.com
//Eloquence Technalogies Islamabad, Pakistan
package com.theater.beans.user;

import static DataBases.DBService.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBuser {

    public void createTable() {
        try {
            String query = "create table if not exists user ( 	Id INT AUTO_INCREMENT,	Name VARCHAR(30),	Email VARCHAR(30),	PhoneNumber VARCHAR(30),	Gender VARCHAR(30),	Address VARCHAR(30),	JoinedDate DATE,	UserName VARCHAR(30),	Passwrd VARCHAR(30), PRIMARY KEY(Id) )";
            PreparedStatement st = conn.prepareStatement(query);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteObject(Object o) {
        try {
            User p = (User) o;
            String query = "delete from user where Id = ?";
            PreparedStatement st = conn.prepareStatement(query);

            st.setInt(1, p.getId());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User findindDatabase(User p) {
        try {
            String query = "select * from user where Id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, p.getId());
            ResultSet rs = st.executeQuery(query);
            p.setId(rs.getInt(1));
            p.setName(rs.getString(2));
            p.setEmail(rs.getString(3));
            p.setPhoneNumber(rs.getString(4));
            p.setGender(rs.getString(5));
            p.setAddress(rs.getString(6));
            p.setJoinedDate(rs.getDate(7));
            p.setUserName(rs.getString(8));
            p.setPasswrd(rs.getString(9));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User insertObject(User p) {
        
        try {
            String query = "insert into user( 	Name ,	Email ,	PhoneNumber ,	Gender ,	Address ,	JoinedDate ,	UserName ,	Passwrd  ) VALUES (?,?,?,?,?,?,?,? )";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, p.getName()); 
            st.setString(2, p.getEmail());
            st.setString(3, p.getPhoneNumber());
            st.setString(4, p.getGender());
            st.setString(5, p.getAddress());
            st.setDate(6, p.getJoinedDate());
            st.setString(7, p.getUserName());
            st.setString(8, p.getPasswrd());
            st.executeUpdate(); 
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Object rstoObject(ResultSet rs) {
        try {
            User p = new User();
            p.setId(rs.getInt(1));
            p.setName(rs.getString(2));
            p.setEmail(rs.getString(3));
            p.setPhoneNumber(rs.getString(4));
            p.setGender(rs.getString(5));
            p.setAddress(rs.getString(6));
            p.setJoinedDate(rs.getDate(7));
            p.setUserName(rs.getString(8));
            p.setPasswrd(rs.getString(9));
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(DBuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateObject(Object o) {
        try {
            User p = (User) o;
            String query = "update  user set 	Name=? ,	Email=? ,	PhoneNumber=? ,	Gender=? ,	Address=? ,	JoinedDate=? ,	UserName=? ,	Passwrd=? where Id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, p.getName());
            st.setString(2, p.getEmail());
            st.setString(3, p.getPhoneNumber());
            st.setString(4, p.getGender());
            st.setString(5, p.getAddress());
            st.setDate(6, p.getJoinedDate());
            st.setString(7, p.getUserName());
            st.setString(8, p.getPasswrd());
            st.setInt(9, p.getId());
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBuser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
}
