/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package restclient;

/**
 *
 * @author Asif Ali
 */
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class RestApiClient {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Theater API.");
        System.out.println("User Name?");
        String name = scanner.nextLine();

        System.out.println("Password?");
        String about = scanner.nextLine();
        System.out.println("Do you want to get or set or find a Plays in our Theater?");
        System.out.println("(Type 'get' or 'set' or 'find' now.)");
        String getOrSet = scanner.nextLine();
        if ("get".equalsIgnoreCase(getOrSet)) {

            String jsonString = getMovieShowData();
            System.out.println(jsonString);

        } else if ("set".equalsIgnoreCase(getOrSet)) {

            String param = "";
            System.out.println("Enter Show Id:");
            param += "&showId=" + URLEncoder.encode(scanner.nextLine());
            System.out.println("Enter User Id:");
            param += "&userId=" + URLEncoder.encode(scanner.nextLine());
            System.out.println("Enter Room No:");
            param += "&RooomNo=" + URLEncoder.encode(scanner.nextLine());
            System.out.println("Enter Movie Name:");
            param += "&movieName=" + URLEncoder.encode(scanner.nextLine());
          
            System.out.println("Enter total Price:");
            param += "&totalPrice=" + URLEncoder.encode(scanner.nextLine());
            System.out.println("Total Total Seats:");
            param += "&TotalSeats=" + scanner.nextLine();
              System.out.println("Enter Date:");
            param += "&date=" + URLEncoder.encode(scanner.nextLine());

            reservePlaySeat(param);
        } else if ("find".equalsIgnoreCase(getOrSet)) {

            System.out.println("Play Name?");
            String playName = scanner.nextLine();

            String jsonString = getPlayData(playName);
            System.out.println(jsonString);
        }

        scanner.close();

        System.out.println("Thanks for using Theater Api.");

    }

    public static String getMovieShowData() throws IOException {

        HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/theater/MovieShow/").openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            String response = "";
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                response += scanner.nextLine();
                response += "\n";
            }
            scanner.close();

            return response;
        }

        // an error happened
        return null;
    }

    public static String getPlayData(String name) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/theater/MovieShow/" + name).openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            String response = "";
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                response += scanner.nextLine();
                response += "\n";
            }
            scanner.close();

            return response;
        }

        // an error happened
        return null;
    }

    public static void reservePlaySeat(String param) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/theater").openConnection();

        connection.setRequestMethod("POST");
        /*
        String postData = "ShowID=" + URLEncoder.encode(name);
        postData += "&MovieName=" + URLEncoder.encode(about);
        postData += "&RoomNumber=" + birthYear;
         */
        connection.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(param);
        wr.flush();

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            System.out.println("POST was successful.");
        } else if (responseCode == 401) {
            System.out.println("Wrong password.");
        }
    }
}
