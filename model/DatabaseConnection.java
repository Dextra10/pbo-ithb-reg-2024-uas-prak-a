package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    public Connection con;
    
    //private String driver = "com.mysql.cj.jdbc.Driver";    
    private String url = "jdbc:mysql://localhost/db_uas_1122049";
    private String username = "root";
    private String password = "";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi ke database berhasil!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("Database Driver tidak ditemukan!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Koneksi ke database gagal!");
            e.printStackTrace();
        }
        return null;
    }

    public void connect() {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
