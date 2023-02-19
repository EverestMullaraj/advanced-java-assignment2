/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.theater.beans.TheaterRooms;

/**
 *
 * @author Asif Ali
 */
import static com.theater.beans.movies.DAOmovies.buttonText;
import static com.theater.beans.movies.DAOmovies.title;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;



@RequestScoped
@ManagedBean(name = "DAOTheaterRooms")
public class DAOTheaterRooms {

    public static String currentView;

    public DAOTheaterRooms() {
        currentView = "home";
    }

    public String switch_to_Add() {
        String path = "/TheaterRooms/CreateTheaterRooms";
        title = "Add New TheaterRooms";
        currentView = "createTheaterRooms";
        buttonText = "Save";
        TheaterRooms obj = new TheaterRooms();
        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("TheaterRooms", obj);
        return path;
    }

    // Used to fetch record to update  
    public static boolean isEdit = false;

    public String switch_to_Edit(TheaterRooms obj, int id) {
        String path = "/TheaterRooms/CreateTheaterRooms";
        currentView = "createTheaterRooms";
        buttonText = "Update";
        title = "Update TheaterRooms";
        isEdit = true;
        obj.setRoomId(id);
        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("TheaterRooms", obj);
        return path;
    }

    public String goBack() {
        String path = "/home";
        return path;

    }

    public String goBackward() {
        return "/TheaterRooms/TheaterRoomsMain";

    }
    ArrayList TheaterRoomssList;
    public static Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    DBTheaterRooms dbTheaterRooms = new DBTheaterRooms();
    public static String buttonText, title;

    public ArrayList TheaterRoomssList() {
        try {
            TheaterRoomssList = dbTheaterRooms.loadData();

        } catch (Exception e) {
            System.out.println(e);
        }
        return TheaterRoomssList;
    }
// Used to save record  

    public String save(TheaterRooms obj) {
        int result = 0;
        if (isEdit == false) {
            dbTheaterRooms.insertObject(obj);

        } else {
            dbTheaterRooms.updateObject(obj);
            isEdit = false;
        }

        if (result != 0) {
            return "TheaterRoomsMain.xhtml?faces-redirect=true";
        } else {
            return "/TheaterRooms/CreateTheaterRooms";
        }

    }

// Used to delete  record  
    public void delete(TheaterRooms m) {
        dbTheaterRooms.deleteObject(m);
    }
    
    

    public String getButtonText() {
        return buttonText;
    }

    public String getTittle() {
        return title;
    }

}
