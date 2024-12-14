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

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String roleStr = rs.getString("role");
                    User.Role role = User.Role.fromString(roleStr);

                    if (role == User.Role.ADMIN) {
                        return new Admin(
                                rs.getInt("userId"),
                                rs.getString("username"),
                                rs.getString("password")
                        );
                    } else if (role == User.Role.EMPLOYEE) {
                        return new Employee(
                                rs.getInt("userId"),
                                rs.getString("username"),
                                rs.getString("password")
                        );
                    } else {
                        throw new IllegalArgumentException("Invalid role: " + roleStr);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving user by username: " + e.getMessage());
        }
        return null;
    }

}
