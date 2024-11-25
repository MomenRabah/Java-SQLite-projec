package services;

import database.SQLiteConnection;
import classes.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    // Create Product
    public void createProduct(int storageId, int row, int column, String name) {
        String sql = "INSERT INTO Products(storageId, row, column, name) VALUES(?, ?, ?, ?)";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, storageId);
            pstmt.setInt(2, row);
            pstmt.setInt(3, column);
            pstmt.setString(4, name);
            pstmt.executeUpdate();
            System.out.println("Product added successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Read Product by ID
    public Product getProductById(int productId) {
        String sql = "SELECT * FROM Products WHERE productId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("productId"), rs.getInt("storageId"),
                        rs.getInt("row"), rs.getInt("column"), rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Update Product
    public void updateProduct(int productId, int storageId, int row, int column, String name) {
        String sql = "UPDATE Products SET storageId = ?, row = ?, column = ?, name = ? WHERE productId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, storageId);
            pstmt.setInt(2, row);
            pstmt.setInt(3, column);
            pstmt.setString(4, name);
            pstmt.setInt(5, productId);
            pstmt.executeUpdate();
            System.out.println("Product updated successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete Product
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

    // Get all Products
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products";
        try (Connection conn = SQLiteConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                products.add(new Product(rs.getInt("productId"), rs.getInt("storageId"),
                        rs.getInt("row"), rs.getInt("column"), rs.getString("name")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
}
