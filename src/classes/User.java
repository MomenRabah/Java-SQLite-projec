<<<<<<< HEAD
package classes; 

//
public class User {
    public enum Role {
        ADMIN, EMPLOYEE;
    }

    private String userid;
=======
package classes;

public class User {
    public enum Role {
        ADMIN, EMPLOYEE;

        public static Role fromString(String roleString) {
            try {
                return Role.valueOf(roleString.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid role: " + roleString);
            }
        }
    }

    private int userid;
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
    private String username;
    private String password;
    private Role role;

<<<<<<< HEAD
    public User(String userid, String username, String password, Role role) {
=======
    public User(int userid, String username, String password, Role role) {
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.role = role;
    }

<<<<<<< HEAD
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
=======
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

<<<<<<< HEAD
    // Product-related methods
    public void createProduct() {
        if (role == Role.ADMIN || role == Role.EMPLOYEE) {
            System.out.println("Product created by " + username);
        } else {
            throw new UnauthorizedException("Unauthorized to create product");
        }
    }

    public void readProduct() {
        if (role == Role.ADMIN || role == Role.EMPLOYEE) {
            System.out.println("Product read by " + username);
        } else {
            throw new UnauthorizedException("Unauthorized to read product");
        }
    }

    public void updateProduct() {
        if (role == Role.ADMIN || role == Role.EMPLOYEE) {
            System.out.println("Product updated by " + username);
        } else {
            throw new UnauthorizedException("Unauthorized to update product");
        }
    }

    public void deleteProduct() {
        if (role == Role.ADMIN || role == Role.EMPLOYEE) {
            System.out.println("Product deleted by " + username);
        } else {
            throw new UnauthorizedException("Unauthorized to delete product");
        }
    }

    // Storage-related methods
    public void createStorage() {
        if (role == Role.ADMIN) {
            System.out.println("Storage created by " + username);
        } else {
            throw new UnauthorizedException("Unauthorized to create storage");
        }
    }

    public void readStorage() {
        if (role == Role.ADMIN) {
            System.out.println("Storage read by " + username);
        } else {
            throw new UnauthorizedException("Unauthorized to read storage");
        }
    }

    public void updateStorage() {
        if (role == Role.ADMIN) {
            System.out.println("Storage updated by " + username);
        } else {
            throw new UnauthorizedException("Unauthorized to update storage");
        }
    }

    public void deleteStorage() {
        if (role == Role.ADMIN) {
            System.out.println("Storage deleted by " + username);
        } else {
            throw new UnauthorizedException("Unauthorized to delete storage");
        }
    }
}
=======
    public void createProduct() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to create product");
    }

    public void readProduct() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to read product");
    }

    public void readProducts() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to read products");
    }

    public void updateProduct() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to update product");
    }

    public void deleteProduct() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to delete product");
    }

    public void createStorage() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to create storage");
    }

    public void readStorage() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to read storage");
    }

    public void showStorage() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to show storage");
    }

    public void readStorages() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to read storages");
    }

    public void updateStorage() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to update storage");
    }

    public void deleteStorage() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to delete storage");
    }

    public void readHistory() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to read history");
    }
    public void readUserHistory() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to read history");
    }
}
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
