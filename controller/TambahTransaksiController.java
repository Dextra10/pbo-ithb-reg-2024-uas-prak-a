package controller;

import model.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TambahTransaksiController {
    private DatabaseConnection dbConnection;

    public TambahTransaksiController() {
        dbConnection = new DatabaseConnection();
    }

    public List<String> getPackageTypes() {
        List<String> packageTypes = new ArrayList<>();
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection conn = dbConnection.getConnection();
    
        if (conn == null) {
            System.err.println("Koneksi ke database tidak berhasil!");
            return packageTypes;
        }
    
        String query = "SELECT name FROM category_package";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
    
            while (resultSet.next()) {
                packageTypes.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return packageTypes;
    }
    

    public double calculateCost(double weight, String packageType) {
        double costPerKg;
        switch (packageType) {
            case "Fast":
                costPerKg = 10000;
                break;
            case "Super Fast":
                costPerKg = 15000;
                break;
            default:
                costPerKg = 5000;
        }

        weight = Math.ceil(weight * 2) / 2.0; 
        return weight * costPerKg;
    }

    public boolean saveTransaction(String name, String address, String phone, double weight, String packageType, double cost) {
        String insertQuery = "INSERT INTO transaction (name, address, phone, weight, package_type, cost, created_at) VALUES (?, ?, ?, ?, ?, ?, NOW())";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            preparedStatement.setDouble(4, weight);
            preparedStatement.setString(5, packageType);
            preparedStatement.setDouble(6, cost);

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
