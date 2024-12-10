package classes;

import services.ProductService;
import services.StorageService;

public class Product {
    private final int productId;
    private int storageId;
    private int row;
    private int column;
    private String name;

    static ProductService productService = new ProductService();
    static StorageService storageService = new StorageService();

    public Product(int productId, int storageId, int row, int column, String name){
        validateInput( storageId, row, column, name);
        this.productId = productId;
        this.storageId = storageId;
        this.row = row;
        this.column = column;
        this.name = name;
    }

    private static void validateInput( int storageId, int row, int column, String name){

        if (storageId <= 0){
            throw new IllegalArgumentException("Storage ID must be a positive integer.");
        }
        if (row < 1 || column < 1){
            throw new IllegalArgumentException("Row and column values must be non-negative.");
        }
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
    }


    public int getProductId(){
        return productId;
    }

    public int getStorageId(){
        return storageId;
    }

    public void setStorageId(int storageId){
        this.storageId = storageId;
    }

    public int getRow(){
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getName() {
        return name;
    }



    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductDetails(){
        Product product = productService.getProductById(productId);
        if (product == null){
            return "Product not found.";
        }
        return String.format("Product ID: %d, Name: %s, Storage ID: %d, Row: %d, Column: %d",
                product.getProductId(), product.getName(), product.getStorageId(),
                product.getRow(), product.getColumn());
    }

    public static Product createProduct(int storageId, int row, int column, String name) {
        try {
            validateInput(storageId, row, column, name);
            Storage storage = storageService.getStorageById(storageId);
            if (storage == null){
                System.err.println("There is no storage with ID: " + storageId);
                return null;
            }
            Product createdProduct = productService.createProduct(storageId, row, column, name);

            return createdProduct;

        } catch (IllegalArgumentException e) {
            System.out.println("Error creating product: " + e.getMessage());
            return null;
        }
    }

    public static void readProducts(){
        var products = productService.getAllProducts();
        if (products.isEmpty()){
            System.out.println("No products available.");
            return;
        }
        System.out.println("Products:");
        for (Product product : products){
            System.out.println(product.getProductDetails());
        }
    }

    public static void readProduct(int productId){
        if (productId <= 0){
            System.out.println("Error: Product ID must be a positive integer.");
            return;
        }
        Product product = productService.getProductById(productId);
        if (product != null) {
            System.out.println("Product found: " + product.getProductDetails());
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }


    public static Product updateProduct(int productId, int storageId, int newRow, int newColumn, String newName) {
        if (productId <= 0) {
            System.out.println("Error: Product ID must be a positive integer.");
            return null;
        }

        try {
            validateInput(storageId, newRow, newColumn, newName);

            if (!productService.isPositionEmpty(storageId, newRow, newColumn)) {
                System.out.println("Error: The specified position (Storage: " + storageId + ", Row: " + newRow + ", Column: " + newColumn + ") is already occupied.");
                return null;
            }

            Product updatedProduct = productService.updateProduct(productId, storageId, newRow, newColumn, newName);
            if (updatedProduct != null) {
                System.out.println("Product updated successfully: " + updatedProduct.getProductDetails());
            } else {
                System.out.println("Product update failed.");
            }
            return updatedProduct;
        } catch (IllegalArgumentException e) {
            System.out.println("Error updating product: " + e.getMessage());
            return null;
        }
    }



    public static int deleteProduct(int productId){
        if (productId <= 0){
            System.out.println("Error: Product ID must be a positive integer.");
            return 0;
        }

        Product productToDelete = productService.getProductById(productId);
        if (productToDelete != null){
            productService.deleteProduct(productId);
            System.out.println("Product deleted: " + productToDelete.getProductDetails());
            return productId;
        }
        else {
            return 0;
        }

    }

    public static void searchProduct(int productId){
        if (productId <= 0){
            System.out.println("Error: Product ID must be a positive integer.");
            return;
        }

        Product product = productService.getProductById(productId);
        if (product != null){
            System.out.println("Product found: " + product.getProductDetails());
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }
}
