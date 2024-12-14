package services;

<<<<<<< HEAD
import database.SQLiteConnection;
import classes.Product;
=======
import classes.Product;
import database.SQLiteConnection;
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

<<<<<<< HEAD
    // Create Product
    public void createProduct(int storageId, int row, int column, String name) {
        String sql = "INSERT INTO Products(storageId, row, column, name) VALUES(?, ?, ?, ?)";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
=======
    public Product createProduct(int storageId, int row, int column, String name) {
        String sql = "INSERT INTO Products(storageId, row, column, name) VALUES(?, ?, ?, ?)";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
            pstmt.setInt(1, storageId);
            pstmt.setInt(2, row);
            pstmt.setInt(3, column);
            pstmt.setString(4, name);
            pstmt.executeUpdate();
<<<<<<< HEAD
            System.out.println("Product added successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Read Product by ID
=======

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


>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
    public Product getProductById(int productId) {
        String sql = "SELECT * FROM Products WHERE productId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
<<<<<<< HEAD
                return new Product(rs.getInt("productId"), rs.getInt("storageId"),
                        rs.getInt("row"), rs.getInt("column"), rs.getString("name"));
=======
                return new Product(
                        rs.getInt("productId"),
                        rs.getInt("storageId"),
                        rs.getInt("row"),
                        rs.getInt("column"),
                        rs.getString("name"));
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

<<<<<<< HEAD
    // Update Product
    public void updateProduct(int productId, int storageId, int row, int column, String name) {
        String sql = "UPDATE Products SET storageId = ?, row = ?, column = ?, name = ? WHERE productId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
=======
    public Product updateProduct(int productId, int storageId, int row, int column, String name) {
        String sql = "UPDATE Products SET storageId = ?, row = ?, column = ?, name = ? WHERE productId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters for the update query
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
            pstmt.setInt(1, storageId);
            pstmt.setInt(2, row);
            pstmt.setInt(3, column);
            pstmt.setString(4, name);
            pstmt.setInt(5, productId);
<<<<<<< HEAD
            pstmt.executeUpdate();
            System.out.println("Product updated successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete Product
=======
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


>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
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

<<<<<<< HEAD
    // Get all Products
=======
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products";
        try (Connection conn = SQLiteConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
<<<<<<< HEAD
                products.add(new Product(rs.getInt("productId"), rs.getInt("storageId"),
                        rs.getInt("row"), rs.getInt("column"), rs.getString("name")));
=======
                products.add(new Product(
                        rs.getInt("productId"),
                        rs.getInt("storageId"),
                        rs.getInt("row"),
                        rs.getInt("column"),
                        rs.getString("name")));
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
<<<<<<< HEAD
=======

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

    public List<Product> getAllProductsByStorageId(int storageId) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE storageId = ?";
        try (Connection conn = SQLiteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, storageId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int productId = rs.getInt("productId");
                    int row = rs.getInt("row");
                    int column = rs.getInt("column");
                    String name = rs.getString("name");

                    products.add(new Product(productId, storageId, row, column, name));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving products: " + e.getMessage());
        }
        return products;
    }



>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
}
