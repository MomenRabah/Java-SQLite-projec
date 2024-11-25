package services;

import database.SQLiteConnection;
import classes.Storage;
import java.sql.*;

public class StorageService {

    // Create Storage
    public void createStorage(int rows, int columns) {
        String sql = "INSERT INTO Storages(rows, columns) VALUES(?, ?)";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rows);
            pstmt.setInt(2, columns);
            pstmt.executeUpdate();
            System.out.println("Storage created successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Read Storage by ID
    public Storage getStorageById(int storageId) {
        String sql = "SELECT * FROM Storages WHERE storageId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, storageId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Storage(rs.getInt("storageId"), rs.getInt("rows"), rs.getInt("columns"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
