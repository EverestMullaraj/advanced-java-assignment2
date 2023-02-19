package com.theater.beans.reservation;

import com.theater.beans.MovieShow.MovieShow;
import static com.theater.beans.MovieShow.MovieShow.idOptions;
import static com.theater.beans.MovieShow.MovieShow.movieOptions;
import java.sql.Date;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map; 
 
public class Reservation implements Comparable {

    private int id = 0;

    private int showId = 0;

    private int userId = 0;

    private String movieName = null;

    private java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());

    private double totalPrice = 0.0;
    
    private int totalSeats=0;

    public Reservation() {
        idOptions = Arrays.asList(1, 2, 3);
        movieOptions = Arrays.asList(1, 2, 3);
    }

    public Reservation(int argid, int argshowId, int arguserId, String argmovieName, java.sql.Date argdate, double argtotalPrice) {
        id = argid;
        showId = argshowId;
        userId = arguserId;
        movieName = argmovieName;
        date = argdate;
        totalPrice = argtotalPrice;

    }

    
    

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
    public void setId(int argid) {
        id = argid;
    }

    public void setShowId(int argshowId) {
        showId = argshowId;
    }

    public void setUserId(int arguserId) {
        userId = arguserId;
    }

    public void setMovieName(String argmovieName) {
        movieName = argmovieName;
    }

    public void setDate(java.sql.Date argdate) {
        date = argdate;
    }

    public void setTotalPrice(double argtotalPrice) {
        totalPrice = argtotalPrice;
    }

    public int getId() {
        return id;
    }

    public int getShowId() {
        return showId;
    }

    public int getUserId() {
        return userId;
    }

    public String getMovieName() {
        return movieName;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return this.id + "" + this.showId + "" + this.userId + "" + this.movieName + "" + this.date + "" + this.totalPrice;
    }

    @Override
    public int compareTo(Object o) {
        int mod = 0;
        Reservation a = (Reservation) o;
        Reservation b = this;
        if (mod == 0) {
            if (a.id > b.id) {
                return -1;
            } else if (a.id < b.id) {
                return 1;
            } else {
                return 0;
            }
        } else if (mod == 1) {
            if (a.showId > b.showId) {
                return -1;
            } else if (a.showId < b.showId) {
                return 1;
            } else {
                return 0;
            }
        } else if (mod == 2) {
            if (a.userId > b.userId) {
                return -1;
            } else if (a.userId < b.userId) {
                return 1;
            } else {
                return 0;
            }
        } else if (mod == 3) {
            return a.movieName.compareTo(b.movieName);
        } else if (mod == 5) {
            if (a.totalPrice > b.totalPrice) {
                return -1;
            } else if (a.totalPrice < b.totalPrice) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;

    }

    
    
  public static Map<String, Object> showIdOptions = new LinkedHashMap<String, Object>();

    public static Map<String, Object> getShowIdOptions() {
        return showIdOptions;
    }

    public static void setShowIdOptions(Map<String, Object> showIdOptions) {
        Reservation.showIdOptions = showIdOptions;
    }


}
