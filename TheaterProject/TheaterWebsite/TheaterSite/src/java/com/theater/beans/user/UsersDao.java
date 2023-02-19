package com.theater.beans.user;

/**
 *
 * @author Asif Ali
 */
import static DataBases.DBService.conn;
import static dashboard.dashboard.parentView;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean(name = "UsersDao")
public class UsersDao {

    public UsersDao() {
        currentView = "home";
        if (parentView.equals("/UserHome") == true) { 
            sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            sessionMap.put("user", dashboard.dashboard.currentuser);
        } 
         buttonText = "Save";
    }
    ArrayList usersList;
    public static Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    DBuser dbuser = new DBuser();
    public static String buttonText, title;

    public ArrayList usersList() {
        try {
            usersList = new ArrayList();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPasswrd(rs.getString("passwrd"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                usersList.add(user);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return usersList;
    }
// Used to save user record  

    public String save(User usr) {
        int result = 0;
        if (isEdit == false) {
            dbuser.insertObject(usr);

        } else {
            dbuser.updateObject(usr);
            isEdit = false;
        }

        if (result != 0) {
            return "UserMain.xhtml?faces-redirect=true";
        } else {
            return "create.xhtml?faces-redirect=true";
        }

    }
// Used to fetch record to update  
    public static boolean isEdit = false;

    public String switch_to_Edit(User user, int id) {

        String path = "/UserViews/create";
        currentView = "createUser";
        buttonText = "Update";
        title = "Update Users";
        isEdit = true;
        if (parentView.equals("/UserHome") == true) {
            user.setId(id);
            sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            sessionMap.put("user", dashboard.dashboard.currentuser);
        } else {
            user.setId(id);
            sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            sessionMap.put("user", user);
        }
        return path;
    }
// Used to update user record  

// Used to delete user record  
    public void delete(User user) {
        dbuser.deleteObject(user);
    }
// Used to set user gender  

    public String getGenderName(char gender) {
        if (gender == 'M') {
            return "Male";
        } else {
            return "Female";
        }
    }

    public String goBack() {
        String path = "/home";
        return path;

    }

    public String goBackward() {
        if (parentView.equals("/UserHome")) {
            return "/UserHome";
        } else {
            return "/UserViews/UserMain";
        }

    }

    public String switch_to_Add() {
        String path = "/UserViews/create";
        title = "Add New User";
        currentView = "createUser";
        buttonText = "Save";
        User u = new User();
        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("user", u);
        return path;
    }

    public static String currentView;

    public String getButtonText() {
        return buttonText;
    }

    public String getTittle() {
        return title;
    }
}
