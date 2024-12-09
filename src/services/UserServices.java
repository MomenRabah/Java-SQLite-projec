package services;

import classes.Admin;
import classes.Employee;
import classes.User;
import database.SQLiteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserServices {

    public User createUser(String username, String password, String role) {
        String sql = "INSERT INTO Users(username, password, role) VALUES(?, ?, ?)";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {


            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);


            int affectedRows = pstmt.executeUpdate();


            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);

                        if ("admin".equalsIgnoreCase(role)) {
                            return new Admin(id, username, role);
                        } else if ("employee".equalsIgnoreCase(role)) {
                            return new Employee(id, username, role);
                        } else {
                            throw new IllegalArgumentException("Invalid role: " + role);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error creating user: " + e.getMessage());
        }
        return null;
    }
}
