package com.theater.beans.Payment;

import com.theater.beans.reservation.DAOReservation; 
import com.theater.beans.reservation.DBReservation;
import com.theater.beans.reservation.Reservation;
import static dashboard.dashboard.parentView;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean(name = "DAOPayment")
public class DAOPayment {

    public static String currentView;

    public DAOPayment() {
        this.dbPayment = new DBPayment();
        currentView = "home";
        title = "Payment";
        buttonText = "Submit";
        if (parentView.equals("/UserHome")) {
            dashboard.dashboard.WhereQuery = " where  TAB_1.CustomerId=" + dashboard.dashboard.currentuser.getId();
        }else{
              dashboard.dashboard.WhereQuery = "";
        }
    }

    

    public String switch_to_Add() {
        String path = "/Payment/CreatePayment";
        title = "Add New Payment";
        currentView = "createPayment";
        buttonText = "Save";
        Payment obj = new Payment();

        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("Payment", obj);
        return path;
    }

    // Used to fetch record to update  
    public static boolean isEdit = false;

    public String switch_to_Edit(Payment obj, int id) {
        String path = "/Payment/CreatePayment";
        currentView = "createPayment";
        buttonText = "Update";
        title = "Update Payment";
        isEdit = true;
        obj.setPaymentId(id);
        sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("Payment", obj);
        return path;
    }

    public String goBack() {
        String path = "/home";
         if (parentView.equals("/UserHome")) {
            path = "/UserHome";
        } else {
             path = "/home";
        }
        return path;

    }

    public String goBackward() {
        
        return "/Rservation/CreateReservation";

    }

    public String getButtonText() {
        return buttonText;
    }

    public String getTittle() {
        return title;
    }
    ArrayList PaymentsList;
    public static Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    DBPayment dbPayment;
    public static String buttonText, title;

    public ArrayList PaymentsList() {
        try {
            PaymentsList = dbPayment.loadData();

        } catch (Exception e) {
            System.out.println(e);
        }
        return PaymentsList;
    }
// Used to save record  
    public static Reservation currentReservation;
    public String save(Payment obj) {
        int result = 0;
        if (DAOReservation.isEditReservation  == false) {
            dbPayment.insertObject(obj);

        } else {
            dbPayment.updateObject(obj);
            isEdit = false;
        }
        
        if (DAOReservation.isEditReservation  == false) {
            
            new DBReservation().insertObject(currentReservation);

        } else {
            new DBReservation().updateObject(currentReservation);
            isEdit = false;
        }

        if (result != 0) {
            return "PaymentMain.xhtml?faces-redirect=true";
        } else {
            return "/Payment/CreatePayment";
        }

    }

// Used to delete  record  
    public void delete(Payment m) {
        dbPayment.deleteObject(m);
    }
}
