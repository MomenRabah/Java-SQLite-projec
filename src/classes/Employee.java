package classes;


import java.util.Scanner;



public class Employee extends User {

    private Scanner scanner = new Scanner(System.in);

    public Employee(int userid, String username, String password) {
        super(userid, username, password, Role.EMPLOYEE);
    }

//    @Override
//    public void createProduct() {
//        System.out.println("Enter the id of the Storage:");
//        int storageId = scanner.nextInt();
//        System.out.println("Enter the row and column for the new product:");
//        int row = scanner.nextInt();
//        int column = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//        System.out.println("Enter the name for the new product:");
//        String name = scanner.nextLine();
//
//        Product createdProduct = Product.createProduct(storageId, row, column, name);
//        System.out.println(this.getUsername() + " has created a product successfully.");
//        HistoryLog.history(this, "Product", createdProduct.getProductId(), HistoryLog.Action.CREATE);
//    }
//
//    @Override
//    public void readProduct() {
//        // System.out.println("Enter the id of the product to read:");
//        // int productId = scanner.nextInt();
//
//        Product.readProducts();
//        System.out.println(this.getUsername() + " has accessed product details.");
//    }
//
//    @Override
//    public void updateProduct() {
//        System.out.println("Enter the id of the product to update:");
//        int productId = scanner.nextInt();
//        System.out.println("Enter the id of the storage where the product is located:");
//        int storageId = scanner.nextInt();
//        System.out.println("Enter the row and column of the product to update:");
//        int row = scanner.nextInt();
//        int column = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Enter the new name for the product:");
//        String newName = scanner.nextLine();
//        Product updatedProduct = Product.updateProduct(productId, storageId, row, column, newName);
//        System.out.println(this.getUsername() + " has updated the product successfully.");
//        HistoryLog.history(this, "Product", updatedProduct.getProductId(), HistoryLog.Action.UPDATE);
//    }
//
//    @Override
//    public void deleteProduct() {
//        System.out.println("Enter the id of the product to delete:");
//        int productId = scanner.nextInt();
//
//        Product.deleteProduct(productId); //
//        System.out.println(this.getUsername() + " has attempted to delete the product.");
//    }
}