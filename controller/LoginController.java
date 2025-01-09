package controller;

import model.Customer;
import model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    private DatabaseConnection dbConnection;

    public LoginController() {
        dbConnection = new DatabaseConnection();
    }

    public boolean validateLogin(String telp, String password) {
        String query = "SELECT * FROM customer WHERE phone = ? AND password = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {

            preparedStatement.setString(1, telp);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Jika login berhasil, buat objek Customer
                Customer customer = new Customer(
                    resultSet.getInt("id"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("phone")
                );
                return true;
            } else {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
