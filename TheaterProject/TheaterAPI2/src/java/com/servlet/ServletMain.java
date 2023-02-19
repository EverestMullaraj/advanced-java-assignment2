/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

/**
 *
 * @author Asif Ali
 */
// or javax.*
// or javax.*
import DataBases.DBService;
import com.theater.beans.MovieShow.DBMovieShow;
import com.theater.beans.MovieShow.MovieShow;
import com.theater.beans.reservation.DBReservation;
import com.theater.beans.reservation.Reservation;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@WebServlet("/theater") // This is the URL of the servlet.
public class ServletMain extends HttpServlet { // Must be public and extend HttpServlet.

    DBService db = new DBService(1);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String requestUrl = request.getRequestURI();
        String name = "";
        if (requestUrl.length() > 0) {
            name = requestUrl.substring("/theater/".length());
        }

        if (name.contains("MovieShow")) {

            response.getOutputStream().println(forwardToMovieShow(name));

        } else {
            response.getOutputStream().println("Sorry No Such Request Can be answered");//
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String showId = request.getParameter("showId");
        String userId = request.getParameter("userId");
        String RoomNo = request.getParameter("RooomNo");
        String movieName = request.getParameter("movieName");
        String date = request.getParameter("date");
        String totalPrice = request.getParameter("totalPrice");
        String totalSeats = request.getParameter("TotalSeats");

        System.out.println("Show Id:" + showId + "user ID:" + userId + "Room No" + RoomNo);

        Reservation ms = new Reservation();
        ms.setMovieName(movieName);
        ms.setShowId(Integer.parseInt(showId));
        ms.setUserId(Integer.parseInt(userId));
        ms.setTotalSeats(Integer.parseInt(totalSeats));
        ms.setTotalPrice(Double.parseDouble(totalPrice));

        if (ms.getTotalSeats() <= 5) {

            DBReservation dbr = new DBReservation();
             dbr.insertObject(ms);
        }

    }

    public String forwardToMovieShow(String rqt) {
        DBMovieShow dbm = new DBMovieShow();
        String parm = rqt.substring("MovieShow/".length());
        String json = "";
        if (!parm.equals("")) {

            MovieShow p = new MovieShow();
            p.setMovieName(parm);
            MovieShow ms = dbm.findindDatabase(p);

            if (ms != null) {
                json = "{\n";
                json += "\"Show id\": " + JSONObject.quote(ms.getShowId() + "") + ",\n";
                json += "\"Movie Name\": " + JSONObject.quote(ms.getMovieName()) + ",\n";
                json += "\"Date\": " + JSONObject.quote(ms.getDate().toLocaleString()) + ",\n";
                json += "\"Room Number\": " + JSONObject.quote(ms.getRoomId() + "") + ",\n";
                json += "\"Start Time\": " + JSONObject.quote(ms.getStartTime().toLocaleString()) + ",\n";
                json += "\"End Time\": " + JSONObject.quote(ms.getEndTime().toLocaleString()) + ",\n";
                json += "}";
            } else {
                json = "Movie Not found";
            }
        } else {
            ArrayList<MovieShow> l = dbm.loadData();

            for (MovieShow ms : l) {
                json += "{\n";
                json += "\"Show id\": " + JSONObject.quote(ms.getShowId() + "") + ",\n";
                json += "\"Movie Name\": " + JSONObject.quote(ms.getMovieName()) + ",\n";
                json += "\"Date\": " + JSONObject.quote(ms.getDate().toLocaleString()) + ",\n";
                json += "\"Room Number\": " + JSONObject.quote(ms.getRoomId() + "") + ",\n";
                json += "\"Start Time\": " + JSONObject.quote(ms.getStartTime().toLocaleString()) + ",\n";
                json += "\"End Time\": " + JSONObject.quote(ms.getEndTime().toLocaleString()) + ",\n";
                json += "}";
            }

        }

        return json;
    }
}
