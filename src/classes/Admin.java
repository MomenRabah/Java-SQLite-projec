package classes;
public class Admin extends User {

    public Admin(String userid, String username, String password) {
        super(userid, username, password, Role.ADMIN);
    }
    @Override
    public void createProduct() {
        System.out.println("Admin has created a product successfully.");
    }
    @Override
    public void readProduct() {
        System.out.println("Admin has accessed product details.");
    }
    @Override
    public void updateProduct() {
        System.out.println("Admin has updated the product successfully.");
    }
    @Override
    public void deleteProduct() {
        System.out.println("Admin has deleted the product successfully.");
    }
    @Override
    public void createStorage() {
        System.out.println("Admin has created a storage unit successfully.");
    }

    @Override
    public void readStorage() {
        System.out.println("Admin has accessed storage unit details.");
    }

    @Override
    public void updateStorage() {
        System.out.println("Admin has updated the storage unit successfully.");
    }

    @Override
    public void deleteStorage() {
        System.out.println("Admin has deleted the storage unit successfully.");
    }
}

