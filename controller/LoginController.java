package controller;

import model.DatabaseConnection;
import model.Customer;
import java.sql.*;

public class LoginController {
    static DatabaseConnection conn = new DatabaseConnection();
    
    public void validateLogin(int telp, String password){
        conn.connect();

        
    }
}
