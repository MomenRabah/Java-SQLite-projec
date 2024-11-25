package classes;
public class Product{
    private String productId; // Unique identifier for each product
    private String storageId; // Storage unit the product is located in
    private int row;          // Row location of the product
    private int column;       // Column location of the product
    private String name;      // Name of the product

    // Constructor
    public Product(String productId, String storageId, int row, int column, String name){
        this.productId = productId;
        this.storageId = storageId;
        this.row = row;
        this.column = column;
        this.name = name;
    }

    // Getters & Setters
    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public String getStorageId(){
        return storageId;
    }

    public void setStorageId(String storageId){
        this.storageId = storageId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row){
        this.row = row;
    }

    public int getColumn(){
        return column;
    }

    public void setColumn(int column){
        this.column = column;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    // Retrieves details of a product
    public String getProductDetails(){
        return String.format("Product ID: %s, Name: %s, Storage ID: %s, Row: %d, Column: %d",
                productId, name, storageId, row, column);
    }
}
