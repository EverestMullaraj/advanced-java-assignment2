package com.theater.beans.movies;

/**
 *
 * @author Asif Ali
 */
import static DataBases.DBService.conn;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean(name = "DAOMovies")
public class DAOmovies {

    public DAOmovies() {
        currentView = "home";
    }
    ArrayList moviessList;
    public static Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    DBmovies dbmovies = new DBmovies();
    public static String buttonText, title;

    public ArrayList moviessList() {
        try {
            moviessList = dbmovies.loadData();

        } catch (Exception e) {
            System.out.println(e);
        }
        return moviessList;
    }
// Used to save movies record  

    public String save(Movie usr) {
        int result = 0;
        if (isEdit == false) {
            dbmovies.insertObject(usr);

        } else {
            dbmovies.updateObject(usr);
            isEdit = false;
        }

        if (result != 0) {
            return "moviesMain.xhtml?faces-redirect=true";
        } else {
            return "create.xhtml?faces-redirect=true";
        }

    }
// Used to fetch record to update  
    public static boolean isEdit = false;

    public String switch_to_Edit(Movie movies, int id) {
        String path = "/Movies/CreateMovies";
        currentView = "createmovies";
        buttonText = "Update";
        title = "Update movies";
        isEdit = true;
        movies.setMovieId(id);
        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("movies", movies);
        return path;
    }
// Used to update movies record  

// Used to delete movies record  
    public void delete(Movie m) {
        dbmovies.deleteObject(m);
    }
// Used to set movies gender  

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
        return "/Movies/MoviesMain";

    }

    public String switch_to_Add() {
        String path = "/Movies/CreateMovies";
        title = "Add New Movies";
        currentView = "createmovies";
        buttonText = "Save";
        Movie u = new Movie();
        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("movies", u);
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
