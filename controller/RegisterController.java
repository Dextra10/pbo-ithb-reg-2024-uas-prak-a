package controller;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DatabaseConnection;

public class RegisterController {
    static DatabaseConnection conn = new DatabaseConnection();
    public boolean registerUser(String name, int telp, String alamat, String password) {
        conn.connect();
        String insertQuery = "INSERT INTO customer (name, telp, alamat, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conn.con.prepareStatement(insertQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, telp);
            preparedStatement.setString(3, alamat);
            preparedStatement.setString(4, password);

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
}
