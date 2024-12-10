package classes;

import java.util.Scanner;


public class Admin extends User {
    public Admin(int userid, String username, String password) {
        super(userid, username, password, Role.ADMIN);
    }
    Scanner scanner = new Scanner(System.in);
    @Override
    public void createProduct() {
        System.out.println("Enter the id of the Storage");
        int storageId = scanner.nextInt();
        System.out.println("Enter the row for the new product:");
        int row = scanner.nextInt();
        System.out.println("Enter the column for the new product:");
        int column = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the name for the new product:");
        String name = scanner.nextLine();
        Product createdProduct = Product.createProduct(storageId, row, column, name);
        if (createdProduct != null) {
            System.out.println(this.getUsername()+" has created a product successfully.");
            HistoryLog.history(this, "Product", createdProduct.getProductId(), HistoryLog.Action.CREATED);
        }
//

    }
    @Override
    public void readProduct() {
        System.out.println("Enter the id of the product: ");
        int productId = scanner.nextInt();
        Product.readProduct(productId);
    }

    @Override
    public void readProducts() {
        Product.readProducts();
    }

    @Override
    public void updateProduct() {
        System.out.println("Enter the id of the product to update:");
        int productId = scanner.nextInt();
        System.out.println("Enter the id of the storage where the product is located:");
        int storageId = scanner.nextInt();
        System.out.println("Enter the row of the product to update:");
        int row = scanner.nextInt();
        System.out.println("Enter the column of the product to update:");
        int column = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new name for the product:");
        String newName = scanner.nextLine();
        Product updatedProduct = Product.updateProduct(productId, storageId, row, column, newName);
        if(updatedProduct != null){
            System.out.println(this.getUsername()+" has updated the product successfully.");
            HistoryLog.history(this, "Product", updatedProduct.getProductId(), HistoryLog.Action.UPDATED);

        }
    }
    @Override
    public void deleteProduct() {
        System.out.println("Enter the id of the product to delete:");
        int productId = scanner.nextInt();
        int deletedProduct = Product.deleteProduct(productId);
        if (deletedProduct != 0) {
            System.out.println(this.getUsername()+" has deleted the product successfully.");
            HistoryLog.history(this, "Product", deletedProduct, HistoryLog.Action.DELETED);
        }else{
            System.err.println("Error: Product not found.");
        }

    }
    @Override
    public void createStorage() {
        System.out.println("Enter the number of rows and columns for the new storage unit:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        Storage creaetedStorage = Storage.createStorage(rows, cols);
        if(creaetedStorage != null){
            System.out.println(this.getUsername()+" has created the storage unit successfully.");
            HistoryLog.history(this, "Storage", creaetedStorage.getStorageId(), HistoryLog.Action.CREATED);
        }
    }

    @Override
    public void readStorage() {
        int storageId = scanner.nextInt();
        Storage.readStorage(storageId);
    }

    @Override
    public void updateStorage() {
        System.out.println("Enter storage ID to update:");
        int storageId = scanner.nextInt();
        System.out.println("rows updated: ");
        int rows = scanner.nextInt();
        System.out.println("columns updated :");
        int cols = scanner.nextInt();
        Storage updatedStorage = Storage.updateStorage(storageId,rows,cols);
        if(updatedStorage != null){
            System.out.println(this.getUsername()+" has updated the storage unit successfully.");
            HistoryLog.history(this, "Storage", updatedStorage.getStorageId(), HistoryLog.Action.UPDATED);
        }

    }

    @Override
    public void deleteStorage() {
        System.out.println("Enter storage ID to delete:");
        int storageID=scanner.nextInt();
        int deletedStorage = Storage.deleteStorage(storageID);
        if (deletedStorage != 0){
            System.out.println(this.getUsername()+" has deleted the storage unit successfully.");
            HistoryLog.history(this, "Storage", deletedStorage, HistoryLog.Action.DELETED);
        } else {
            System.err.println("No storage unit found with id: " + storageID);
        }
    }

    @Override
    public void readStorages() {
        Storage.readStorages();
    }

    @Override
    public void readHistory(){
        HistoryLog.printAllHistoryLogs();
    }
    @Override
    public void readUserHistory(){
        System.out.println("Enter User ID to read history:");
        int userId = scanner.nextInt();
        HistoryLog.printAllUserHistoryLogs(userId);
    }

    @Override
    public void showStorage(){
        System.out.println("Enter storage ID to show:");
        int storageId = scanner.nextInt();
        Storage.displayStorageLayout(storageId);
    }
}

