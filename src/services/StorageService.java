package services;

import classes.Storage;
import database.SQLiteConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StorageService {

    public Storage createStorage(int rows, int columns) {
        String sql = "INSERT INTO Storages(rows, columns) VALUES(?, ?)";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, rows);
            pstmt.setInt(2, columns);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                System.out.println("Storage created successfully with ID: " + generatedId);
                return new Storage(generatedId, rows, columns);
            }
        } catch (Exception e) {
            System.out.println("Error creating storage: " + e.getMessage());
        }
        return null;
    }


    public Storage getStorageById(int storageId) {
        String sql = "SELECT * FROM Storages WHERE storageId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, storageId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("storageId");
                int rows = rs.getInt("rows");
                int columns = rs.getInt("columns");


                return new Storage(id, rows, columns);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving storage: " + e.getMessage());
        }
        return null;
    }

    public List<Storage> getAllStorages() {
        List<Storage> storages = new ArrayList<>();
        String sql = "SELECT * FROM Storages";
        try (Connection conn = SQLiteConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                storages.add(new Storage(
                        rs.getInt("storageId"),
                        rs.getInt("rows"),
                        rs.getInt("columns")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return storages;

    }


    public Storage updateStorage(int storageId, int rows, int columns) {


        String sql = "UPDATE Storages SET rows = ?, columns = ? WHERE storageId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, rows);
            pstmt.setInt(2, columns);
            pstmt.setInt(3, storageId);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Storage updated successfully.");
                return getStorageById(storageId);
            } else {
                System.out.println("No storage found with ID: " + storageId);
            }
        } catch (Exception e) {
            System.out.println("Error updating storage: " + e.getMessage());
        }
        return null;
    }




    public void deleteStorage(int storageId) {
        String sql = "DELETE FROM Storages WHERE storageId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, storageId);
            pstmt.executeUpdate();
            System.out.println("Storage entry deleted.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
