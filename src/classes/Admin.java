package classes;

import java.util.Scanner;


public class Admin extends User {
    public Admin(int userid, String username, String password) {
        super(userid, username, password, Role.ADMIN);
    }
    Scanner scanner = new Scanner(System.in);
//    @Override
//    public void createProduct() {
//        System.out.println("Enter the id of the Storage");
//        int storageId = scanner.nextInt();
//        System.out.println("Enter the row and column for the new product:");
//        int row = scanner.nextInt();
//        int column = scanner.nextInt();
//        System.out.println("Enter the name for the new product:");
//        String name = scanner.nextLine();
//        Product createdProduct = Product.createProduct(storageId, row, column, name);
//        System.out.println(this.getUsername()+" has created a product successfully.");
//        HistoryLog.history(this, "Product", createdProduct.getProductId(), HistoryLog.Action.CREATE);
//
//    }
//    @Override
//    public void readProduct() {
//        // System.out.println("Enter the id of the product to read:");
//        // int productId = scanner.nextInt();
//        Product.readProducts();
//        System.out.println(this.getUsername()+" has accessed product details.");
//    }
//    @Override
//    public void updateProduct() {
//        System.out.println("Enter the id of the product to update:");
//        int productId = scanner.nextInt();
//        System.out.println("Enter the id of the storage where the product is located:");
//        int storageId = scanner.nextInt();
//        System.out.println("Enter the row and column of the product to update:");
//        int row = scanner.nextInt();
//        int column = scanner.nextInt();
//        System.out.println("Enter the new name for the product:");
//        String newName = scanner.nextLine();
//        Product updatedProduct = Product.updateProduct(productId, storageId, row, column, newName);
//        System.out.println(this.getUsername()+" has updated the product successfully.");
//        HistoryLog.history(this, "Product", updatedProduct.getProductId(), HistoryLog.Action.UPDATE);
//    }
//    @Override
//    public void deleteProduct() {
//        System.out.println("Enter the id of the product to delete:");
//        int productId = scanner.nextInt();
//        int deletedProduct = Product.deleteProduct(productId);
//        if (deletedProduct != 0) {
//            System.out.println(this.getUsername()+" has deleted the product successfully.");
//            HistoryLog.history(this, "Product", deletedProduct, HistoryLog.Action.DELETE);
//        }else{
//            System.out.println("Error: Product not found.");
//        }
//
//    }
    @Override
    public void createStorage() {
        System.out.println("Enter the number of rows and columns for the new storage unit:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        Storage creaetedStorage = Storage.createStorage(rows, cols);
        System.out.println(this.getUsername()+" has created a storage unit successfully.");
//        HistoryLog.history(this, "Storage", creaetedStorage.getStorageId(), HistoryLog.Action.CREATE);
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

        System.out.println(this.getUsername()+" has updated the storage unit successfully.");
//        HistoryLog.history(this, "Storage", updatedStorage.getStorageId(), HistoryLog.Action.UPDATE);
    }

    @Override
    public void deleteStorage() {
        System.out.println("Enter storage ID to delete:");
        int storageID=scanner.nextInt();
        int deletedStorage = Storage.deleteStorage(storageID);
        if (deletedStorage != 0){
            System.out.println(this.getUsername()+" has deleted the storage unit successfully.");
//            HistoryLog.history(this, "Storage", deletedStorage, HistoryLog.Action.DELETE);
        } else {
            System.out.println("No storage unit found with id: " + storageID);
        }
    }

    @Override
    public void readStorages() {
        Storage.readStorages();
    }
}

