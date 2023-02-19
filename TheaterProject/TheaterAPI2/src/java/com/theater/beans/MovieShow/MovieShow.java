package com.theater.beans.MovieShow;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MovieShow implements Comparable {

    private int showId = 0;

    private int roomId = 0;

    private int movieId = 0;

    private String movieName = null;

    private java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());

    private java.sql.Date startTime = new java.sql.Date(new java.util.Date().getTime());

    private java.sql.Date endTime = new java.sql.Date(new java.util.Date().getTime());

    private double bookingFee = 0.0;

    public MovieShow() {

        idOptions = Arrays.asList(1, 2, 3);
        movieOptions = Arrays.asList(1, 2, 3);
    }

    public MovieShow(int argshowId, int argroomId, int argmovieId, String argmovieName, java.sql.Date argdate, java.sql.Date argstartTime, java.sql.Date argendTime, double argbookingFee) {
        showId = argshowId;
        roomId = argroomId;
        movieId = argmovieId;
        movieName = argmovieName;
        date = argdate;
        startTime = argstartTime;
        endTime = argendTime;
        bookingFee = argbookingFee;

    }

    public void setShowId(int argshowId) {
        showId = argshowId;
    }

    public void setRoomId(int argroomId) {
        roomId = argroomId;
    }

    public void setMovieId(int argmovieId) {
        movieId = argmovieId;
    }

    public void setMovieName(String argmovieName) {
        movieName = argmovieName;
    }

    public void setDate(java.sql.Date argdate) {
        date = argdate;
    }

    public void setStartTime(java.sql.Date argstartTime) {
        startTime = argstartTime;
    }

    public void setEndTime(java.sql.Date argendTime) {
        endTime = argendTime;
    }

    public void setBookingFee(double argbookingFee) {
        bookingFee = argbookingFee;
    }

    public int getShowId() {
        return showId;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public java.sql.Date getStartTime() {
        return startTime;
    }

    public java.sql.Date getEndTime() {
        return endTime;
    }

    public double getBookingFee() {
        return bookingFee;
    }

    @Override
    public String toString() {
        return this.showId + "" + this.roomId + "" + this.movieId + "" + this.movieName + "" + this.date + "" + this.startTime + "" + this.endTime + "" + this.bookingFee;
    }

    @Override
    public int compareTo(Object o) {
        int mod = 0;
        MovieShow a = (MovieShow) o;
        MovieShow b = this;
        switch (mod) {
            case 0:
                if (a.showId > b.showId) {
                    return -1;
                } else if (a.showId < b.showId) {
                    return 1;
                } else {
                    return 0;
                }
            case 1:
                if (a.roomId > b.roomId) {
                    return -1;
                } else if (a.roomId < b.roomId) {
                    return 1;
                } else {
                    return 0;
                }
            case 2:
                if (a.movieId > b.movieId) {
                    return -1;
                } else if (a.movieId < b.movieId) {
                    return 1;
                } else {
                    return 0;
                }
            case 3:
                return a.movieName.compareTo(b.movieName);
            case 7:
                if (a.bookingFee > b.bookingFee) {
                    return -1;
                } else if (a.bookingFee < b.bookingFee) {
                    return 1;
                } else {
                    return 0;
                }
            default:
                break;
        }
        return 0;

    }

    public static List<Integer> idOptions = Arrays.asList();

    public List<Integer> getIdOptions() {
        return idOptions;
    }

    public void setIdOptions(List<Integer> idOptions) {
        idOptions = idOptions;
    }

    public static List<Integer> movieOptions = Arrays.asList();

    ;

    public List<Integer> getMovieOptions() {
        return movieOptions;
    }

    public void setMovieOptions(List<Integer> movieOptions) {
        movieOptions = movieOptions;
    }

    public static Map<String, Object> roomIdOptions = new LinkedHashMap<String, Object>();

    public Map<String, Object> getCourseMap() {

        return roomIdOptions;
    }

    public static Map<String, Object> movieIdOptions = new LinkedHashMap<String, Object>();

    public static Map<String, Object> getMovieIdOptions() {
        return movieIdOptions;
    }

    public static void setMovieIdOptions(Map<String, Object> movieIdOptions) {
        MovieShow.movieIdOptions = movieIdOptions;
    }

    public static Map<String, Object> getRoomIdOptions() {
        return roomIdOptions;
    }

    public static void setRoomIdOptions(Map<String, Object> roomIdOptions) {
        MovieShow.roomIdOptions = roomIdOptions;
    }
    
    public String testAction="";
    public String testAction() {
SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YY HH:mm:ss");
testAction = sdf.format(this.date);
 System.out.println("Selected date with timestamp: " + testAction);
return testAction;
       
    }
}
