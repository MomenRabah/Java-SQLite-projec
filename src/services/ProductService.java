package services;

import classes.Product;
import database.SQLiteConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public Product createProduct(int storageId, int row, int column, String name) {
        String sql = "INSERT INTO Products(storageId, row, column, name) VALUES(?, ?, ?, ?)";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, storageId);
            pstmt.setInt(2, row);
            pstmt.setInt(3, column);
            pstmt.setString(4, name);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int productId = rs.getInt(1);

                return new Product(productId, storageId, row, column, name);
            }

            System.out.println("Product added successfully but could not retrieve the ID.");
        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE constraint failed")) {
                System.err.println("Error: A product already exists at the specified row and column in the given storage.");
            } else {
                System.err.println("Error creating product: " + e.getMessage());
            }
        }
        return null;
    }


    public Product getProductById(int productId) {
        String sql = "SELECT * FROM Products WHERE productId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Product(
                        rs.getInt("productId"),
                        rs.getInt("storageId"),
                        rs.getInt("row"),
                        rs.getInt("column"),
                        rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Product updateProduct(int productId, int storageId, int row, int column, String name) {
        String sql = "UPDATE Products SET storageId = ?, row = ?, column = ?, name = ? WHERE productId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters for the update query
            pstmt.setInt(1, storageId);
            pstmt.setInt(2, row);
            pstmt.setInt(3, column);
            pstmt.setString(4, name);
            pstmt.setInt(5, productId);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Product updated successfully.");

                // Retrieve the updated product using the productId
                return getProductById(productId);
            } else {
                System.out.println("No product found with ID: " + productId);
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("UNIQUE constraint failed")) {
                System.err.println("Error: A product already exists at the specified row and column in the given storage.");
            } else {
                System.err.println("Error creating product: " + e.getMessage());
            }
        }
        return null;
    }


    public void deleteProduct(int productId) {
        String sql = "DELETE FROM Products WHERE productId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            pstmt.executeUpdate();
            System.out.println("Product deleted successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products";
        try (Connection conn = SQLiteConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("productId"),
                        rs.getInt("storageId"),
                        rs.getInt("row"),
                        rs.getInt("column"),
                        rs.getString("name")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public boolean isPositionEmpty(int storageId, int row, int column) {
        String sql = "SELECT COUNT(*) AS count FROM Products WHERE storageId = ? AND row = ? AND column = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, storageId);
            pstmt.setInt(2, row);
            pstmt.setInt(3, column);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("count") == 0;
            }
        } catch (Exception e) {
            System.out.println("Error checking position: " + e.getMessage());
        }
        return false;
    }



}
