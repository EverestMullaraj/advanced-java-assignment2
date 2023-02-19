package com.theater.beans.reservation;

import DataBases.LoadOptions;
import static com.theater.beans.MovieShow.DAOMovieShow.buttonText;
import static com.theater.beans.MovieShow.DAOMovieShow.currentView;
import static com.theater.beans.MovieShow.DAOMovieShow.isEdit;
import static com.theater.beans.MovieShow.DAOMovieShow.sessionMap;
import static com.theater.beans.MovieShow.DAOMovieShow.title;
import com.theater.beans.MovieShow.MovieShow;
import static com.theater.beans.Payment.DAOPayment.buttonText;
import static com.theater.beans.Payment.DAOPayment.currentReservation;
import static com.theater.beans.Payment.DAOPayment.currentView;
import static com.theater.beans.Payment.DAOPayment.sessionMap;
import static com.theater.beans.Payment.DAOPayment.title;
import com.theater.beans.Payment.Payment;
import static com.theater.beans.TheaterRooms.DAOTheaterRooms.buttonText;
import static com.theater.beans.TheaterRooms.DAOTheaterRooms.title;
import static dashboard.dashboard.parentView;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean(name = "DAOReservation")
public class DAOReservation {

    public static String currentView;

    public DAOReservation() {
        this.dbReservation = new DBReservation();
        currentView = "home";
        String path = "/MovieShow/CreateMovieShow";

        if (parentView.equals("/UserHome")) {
            dashboard.dashboard.WhereQuery = " where TAB_1.UserId=" + dashboard.dashboard.currentuser.getId();
        } else {
            dashboard.dashboard.WhereQuery = "";
        }
        LoadOptions.main(null);
    }

    public String switch_to_Add() {
        String path = "/Rservation/CreateReservation";
        title = "Add New Reservation";
        currentView = "createReservation";
        buttonText = "Save";

        Reservation obj = new Reservation();
        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("Reservation", obj);
        return path;
    }

    // Used to fetch record to update  
    public static boolean isEditReservation = false;

    public String switch_to_Edit(Reservation obj, int id) {
        String path = "/Rservation/CreateReservation";
        currentView = "createReservation";
        buttonText = "Update";
        title = "Update Reservation";
        isEdit = true;
        obj.setId(id);
        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("Reservation", obj);
        return path;
    }

    public String goBack() {
        String path = "/home";
        if (parentView != null) {
            if (parentView.equals("/UserHome")) {
                path = "/UserHome";
            } else {
                path = "/home";
            }
        }
        return path;

    }

    public String goBackward() {

        if (parentView.equals("/UserHome")) {
            return "/MovieShowAnoms/MovieShowMain";
        } else if (parentView.equals("/Home")) {
            return "/MovieShow/MovieShowMain";
        } else {
            return "/Rservation/ReservationMain";
        }

    }
    ArrayList ReservationsList;
    public static Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    DBReservation dbReservation;
    public static String buttonText, title;

    public ArrayList ReservationsList() {
        try {
            ReservationsList = dbReservation.loadData();

        } catch (Exception e) {
            System.out.println(e);
        }
        return ReservationsList;
    }
// Used to save record  

    public String save(Reservation obj) {
        int result = 0;
        String path = "/Payment/CreatePayment";
        if (obj.getTotalSeats() <= 5) {

            title = "Add New Payment";
            currentView = "createPayment";
            buttonText = "Save";
            Payment objp = new Payment();
            objp.setTotalAmount(obj.getTotalPrice());
            objp.setReservationNumber(obj.getId());
            currentReservation = obj;
            if (!parentView.equals("/Home")) {
                objp.setCustomerId(dashboard.dashboard.currentuser.getId());
                objp.setCustomerName(dashboard.dashboard.currentuser.getName());
            }

            sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            sessionMap.put("Payment", objp);
            return path;
        } else {
            message = "You can reserve upto five seats only";
        }
        return "";
    }

    public String message = "";

    public String getMessage() {
        return message;
    }

// Used to delete  record  
    public void delete(Reservation m) {
        dbReservation.deleteObject(m);
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getTittle() {
        return title;
    }

    public String switch_to_Add_Annon(MovieShow m) {
        String path = "/Rservation/CreateReservation";
        title = "Add New Reservation";
        currentView = "createReservation";
        buttonText = "Save";
        Reservation obj = new Reservation();
        if (!parentView.equals("/Home")) {
            obj.setUserId(dashboard.dashboard.currentuser.getId());
        }
        obj.setShowId(m.getShowId());
        obj.setMovieName(m.getMovieName());
        obj.setTotalPrice(m.getBookingFee());
        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("Reservation", obj);
        return path;
    }
}
