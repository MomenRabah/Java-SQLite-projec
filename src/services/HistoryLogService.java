package services;

import database.SQLiteConnection;
import java.sql.*;
import java.util.*;


public class HistoryLogService {

    public void createHistoryLog(String log, int userId) {
        String sql = "INSERT INTO HistoryLogs(userId,log) VALUES(?, ?)";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, log);
            pstmt.executeUpdate();
            System.out.println("History log entry created.");
        } catch (Exception e) {
            System.out.println("testeing!!");
            System.err.println(e.getMessage());
        }
    }
    public List<String> getAllHistoryLogs() {
        List<String> logs = new ArrayList<>();
        String sql = "SELECT * FROM HistoryLogs";
        try (Connection conn = SQLiteConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String log = rs.getString("log");
                logs.add(log);
            }
        } catch (Exception e) {
            System.err.println("Error retrieving history logs: " + e.getMessage());
        }
        return logs;
    }
    public List<String> getUserHistory(int userId) {
        List<String> logs = new ArrayList<>();
        String sql = "SELECT * FROM HistoryLogs WHERE userId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId); // Set the userId parameter in the query

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String log = rs.getString("log");
                    logs.add(log);
                }
            }
        } catch (Exception e) {
            System.err.println("Error retrieving history logs: " + e.getMessage());
        }
        return logs;
    }

}
