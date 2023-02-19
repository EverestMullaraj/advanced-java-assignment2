package DataBases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBService {

    public String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public String DB_URL;

    public String USER;

    public String PASS;

    public static Connection conn = null;

    public static Statement stmt = null;

    public String sql = null;

    public DBService() {
    }

    public DBService(int i) {
        /* try {
      hashedpassword p = new hashedpassword();
      this.PASS = "";
      Class.forName("org.h2.Driver");
      System.out.println(this.USER + this.DB_URL + this.PASS);
      conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
      stmt = conn.createStatement();
    } catch (SQLException ex) {
      Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, (String)null, ex);
    } */

         try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/theater", "root", "");
               
            } catch (Exception e) {
                System.out.println(e);
            }
    }

    public Connection getConnection() {
        return conn;
    }
    
     public static void main(String[] args) {
        DBService db = new DBService(1);
        
    }
}
