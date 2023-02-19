/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main_controller;

/**
 *
 * @author Asif Ali
 */
import DataBases.DBService;
import com.theater.beans.user.DBuser;
import com.theater.beans.user.User;
import static dashboard.dashboard.parentView;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "userLogin", eager = true)
@RequestScoped
public class UserLogin {

    DBService db = new DBService(1);
    private String message = "Enter username and password.";
    private String username;
    private String password;
    private String logInResult;

    public String login() {
        db = new DBService(1);
        if ("admin".equalsIgnoreCase(username) && "12345".equalsIgnoreCase(password)) {
            message = "Successfully logged-in.";
            parentView="/Home";
            return "home";
        } else {
            DBuser dbu = new DBuser();
            User u = new User();
            u.setUserName(username);
            u = dbu.findindDatabase(u);
            if (u.getPasswrd().equalsIgnoreCase(password)) {
                dashboard.dashboard.currentuser=u; 
                parentView="/UserHome";
                return "UserHome";
            } else {
                message = "Wrong credentials.";
            }
        }
        return "index";
    }

    public String moveToPage1() {
        return logInResult;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogInResult(String logInResult) {
        this.logInResult = logInResult;
    }

    public String getLogInResult() {
        return logInResult;
    }

}
