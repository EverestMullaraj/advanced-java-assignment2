/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dashboard;

import DataBases.LoadOptions;
import com.theater.beans.user.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Asif Ali
 */
@RequestScoped
@ManagedBean(name = "DashBoard")
public class dashboard {
    
    public static String parentView;
    
    public static User currentuser;
    
    public static String WhereQuery = "";
    
    public String EditProfile() {
        parentView = "/UserHome";
        return "/UserViews/create";
    }    

    public dashboard() {
        LoadOptions.main(null);
    }
}
