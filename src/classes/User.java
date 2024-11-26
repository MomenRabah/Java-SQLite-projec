package classes; 

//
public class User {
    public enum Role {
        ADMIN, EMPLOYEE;
    }

    private String userid;
    private String username;
    private String password;
    private Role role;

    public User(String userid, String username, String password, Role role) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
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