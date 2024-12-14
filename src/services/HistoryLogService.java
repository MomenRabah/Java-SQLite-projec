package services;

import database.SQLiteConnection;
<<<<<<< HEAD
import classes.HistoryLog;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryLogService {

    // Create History Log Entry
    public void createHistoryLog(String action, String itemType, int itemId, int userId, String date) {
        String sql = "INSERT INTO HistoryLogs(action, itemType, itemId, userId, date) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, action);
            pstmt.setString(2, itemType);
            pstmt.setInt(3, itemId);
            pstmt.setInt(4, userId);
            pstmt.setString(5, date);
            pstmt.executeUpdate();
            System.out.println("History log entry created.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Read History Log by Log ID
    public HistoryLog getHistoryLogById(int logId) {
        String sql = "SELECT * FROM HistoryLogs WHERE logId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, logId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new HistoryLog(rs.getInt("logId"), rs.getString("action"), rs.getString("itemType"),
                        rs.getInt("itemId"), rs.getInt("userId"), rs.getString("date"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Get all History Logs
    public List<HistoryLog> getAllHistoryLogs() {
        List<HistoryLog> logs = new ArrayList<>();
=======
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
            System.err.println(e.getMessage());
        }
    }
    public List<String> getAllHistoryLogs() {
        List<String> logs = new ArrayList<>();
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
        String sql = "SELECT * FROM HistoryLogs";
        try (Connection conn = SQLiteConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
<<<<<<< HEAD
                logs.add(new HistoryLog(rs.getInt("logId"), rs.getString("action"), rs.getString("itemType"),
                        rs.getInt("itemId"), rs.getInt("userId"), rs.getString("date")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
=======
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
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
        }
        return logs;
    }

<<<<<<< HEAD
    // Delete History Log Entry
    public void deleteHistoryLog(int logId) {
        String sql = "DELETE FROM HistoryLogs WHERE logId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, logId);
            pstmt.executeUpdate();
            System.out.println("History log entry deleted.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
=======
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
}
