/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.theater.beans.MovieShow;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Asif Ali
 */
@FacesConverter("timestampConverter")
public class TimestampConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, 
                              UIComponent uIComponent, 
                              String string) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date date = null;
        Calendar calendar = Calendar.getInstance();
        try {
            date = (Date) sdf.parse(string);
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar now = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, now.get(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, now.get(Calendar.SECOND));
        Timestamp result = new Timestamp(calendar.getTime().getTime());
        return result;
    }

    @Override
    public String getAsString(FacesContext facesContext, 
                              UIComponent uIComponent, 
                              Object object) {
        if (object == null) {
            return null;
        }    
        return object.toString();
    }
}