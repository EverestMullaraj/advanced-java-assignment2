/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBases;

import static DataBases.DBService.conn;
import com.theater.beans.MovieShow.MovieShow;
import static com.theater.beans.MovieShow.MovieShow.idOptions;
import com.theater.beans.TheaterRooms.DBTheaterRooms;
import com.theater.beans.TheaterRooms.TheaterRooms;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.theater.beans.MovieShow.MovieShow.roomIdOptions;
import com.theater.beans.reservation.Reservation;

/**
 *
 * @author Asif Ali
 */
public class LoadOptions {

    public static void main(String[] args) {
        try {
            idOptions = Arrays.asList(1, 2, 3, 6);
            String query = "SELECT  TAB_1.RoomId"
                    + " FROM theaterrooms AS TAB_1"
                    + " GROUP BY(TAB_1.RoomId) ";
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            roomIdOptions = new LinkedHashMap<String, Object>();
            while (rs.next()) {
                roomIdOptions.put(rs.getString(1), rs.getString(1));

            }
              query = "SELECT  TAB_1.MovieId"
                    + " FROM movies AS TAB_1"
                    + " GROUP BY(TAB_1.MovieId) ";
              st = conn.createStatement();
            rs = st.executeQuery(query);
            MovieShow.movieIdOptions = new LinkedHashMap<String, Object>();
            while (rs.next()) {
               MovieShow.movieIdOptions.put(rs.getString(1), rs.getString(1));

            }
            
              query = "SELECT  TAB_1.ShowId"
                    + " FROM movieshow AS TAB_1"
                    + " GROUP BY(TAB_1.ShowId) ";
              st = conn.createStatement();
            rs = st.executeQuery(query);
            Reservation.showIdOptions = new LinkedHashMap<String, Object>();
            while (rs.next()) {
               Reservation.showIdOptions.put(rs.getString(1), rs.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(TheaterRooms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
