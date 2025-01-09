package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DatabaseConnection;

public class RegisterController {
    private DatabaseConnection dbConnection;

    public RegisterController() {
        dbConnection = new DatabaseConnection();
    }

    public boolean registerUser(String name, String telp, String alamat, String password) {
        String insertQuery = "INSERT INTO customer (name, telp, alamat, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, telp);
            preparedStatement.setString(3, alamat);
            preparedStatement.setString(4, password);

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

    public boolean isUserExists(String name, String telp) {
        String query = "SELECT COUNT(*) FROM customer WHERE name = ? OR telp = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, telp);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }
}
