package classes;

import services.ProductService;
import services.StorageService;

import java.util.List;

public class Storage{
    private final int storageId;
    private int rows;
    private int columns;

    static StorageService storageService = new StorageService();
    static ProductService productService = new ProductService();

    public Storage(int storageId, int rows, int columns){

        validateInput(rows, columns);
        this.storageId = storageId;
        this.rows = rows;
        this.columns = columns;
    }

    private static void validateInput( int rows, int columns){

        if (rows <= 0){
            throw new IllegalArgumentException("Rows must be a positive integer.");
        }
        if (columns <= 0){
            throw new IllegalArgumentException("Columns must be a positive integer.");
        }
    }


    public int getStorageId(){
        return storageId;
    }


    public int getRows(){
        return rows;
    }

    public void setRows(int rows){
        this.rows = rows;
    }

    public int getColumns(){
        return this.columns;
    }
    public void setColumns(int columns) {
        this.columns = columns;
    }

    public String getStorageDetails(){
        return String.format("Storage ID: %d, Rows: %d, Columns: %d", storageId, rows, columns);
    }

    public static Storage createStorage(int rows, int columns) {
        try {

            validateInput( rows, columns);

            Storage newStorage = storageService.createStorage(rows, columns);


            System.out.println("Storage created: " + newStorage.getStorageDetails());
            return newStorage;

        } catch (IllegalArgumentException e) {
            System.out.println("Error creating storage: " + e.getMessage());
            return null;

        }

    }


    public static void readStorages(){
        var storages = storageService.getAllStorages();
        if (storages.isEmpty()){
            System.out.println("No storages available.");
            return;
        }
        System.out.println("Storages:");
        for (Storage storage : storages){
            System.out.println(storage.getStorageDetails());
        }
    }

    public static void readStorage(int storageId){
        if (storageId <= 0){
            System.out.println("Error: Storage ID must be a positive integer.");
            return;
        }
        try{
            Storage storage = storageService.getStorageById(storageId);

            if (storage != null){
                System.out.println("Storage details: " + storage.getStorageDetails());
            }
            else{
                System.out.println("No storage found with ID: " + storageId);
            }
        } catch (Exception e){
            System.out.println("Error reading storage: " + e.getMessage());
        }
    }



    public static Storage updateStorage(int storageId, int newRows, int newColumns) {
        if (storageId <= 0) {
            System.out.println("Error: Storage ID must be a positive integer.");
            return null;
        }
        try {
            validateInput(newRows, newColumns);

            Storage updatedStorage = storageService.updateStorage(storageId, newRows, newColumns);

            if (updatedStorage != null) {
                System.out.println("Storage updated: " + updatedStorage.getStorageDetails());
                return updatedStorage;
            }
        } catch (Exception e) {
            System.out.println("Error updating storage: " + e.getMessage());
        }
        return null;
    }


    public static int deleteStorage(int storageId){
        if (storageId <= 0){
            System.out.println("Error: Storage ID must be a positive integer.");
            return 0;
        }

        Storage storageToDelete = storageService.getStorageById(storageId);
        if (storageToDelete != null){
            storageService.deleteStorage(storageId);
            System.out.println("Storage deleted: " + storageToDelete.getStorageDetails());
            return storageId;
        }
        else{
            System.out.println("Error: Storage with ID " + storageId + " not found.");
            return 0;
        }
    }

    public static void searchStorage(int storageId){
        if (storageId <= 0){
            System.out.println("Error: Storage ID must be a positive integer.");
            return;
        }

        Storage storage = storageService.getStorageById(storageId);
        if (storage != null){
            System.out.println("Storage found: " + storage.getStorageDetails());
        } else{
            System.out.println("Storage with ID " + storageId + " not found.");
        }
    }

    public static void displayStorageLayout(int storageId) {
        Storage storage = storageService.getStorageById(storageId);
        if(storage == null){
            System.err.println("Storage with ID " + storageId + " not found.");
            return;
        }
        List<Product> products = productService.getAllProductsByStorageId(storageId);

        String[][] grid = new String[storage.getRows()][storage.getColumns()];
        for (int i = 0; i < storage.getRows(); i++) {
            for (int j = 0; j < storage.getColumns(); j++) {
                grid[i][j] = " ";
            }
        }
        System.out.println(storage.getStorageDetails());
        for (Product product : products) {
            int row = product.getRow() - 1;
            int col = product.getColumn() - 1;
            if (row >= 0 && row < storage.getRows() && col >= 0 && col < storage.getColumns()) {
                grid[row][col] = String.valueOf(product.getProductId());
            }
        }

        System.out.println("Storage Layout:");

        printHorizontalBorder(storage.getColumns());

        for (int i = 0; i < storage.getRows(); i++) {
            System.out.print("|");
            for (int j = 0; j < storage.getColumns(); j++) {
                System.out.print(" " + grid[i][j] + " |");
            }
            System.out.println();
            printHorizontalBorder(storage.getColumns());
        }

        System.out.println("\nProducts in this storage:");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("%d] Product with ID: %d at position (row: %d, column: %d)%n",
                    i + 1, product.getProductId(), product.getRow(), product.getColumn());
        }
    }

    private static void printHorizontalBorder(int columns) {
        for (int i = 0; i < columns; i++) {
            System.out.print("----");
        }
        System.out.println("-");
    }
}
