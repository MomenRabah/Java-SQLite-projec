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
    private String username;
    private String password;
    private Role role;

    public User(int userid, String username, String password, Role role) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
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

    public void readStorages() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to read storages");
    }

    public void updateStorage() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to update storage");
    }

    public void deleteStorage() throws UnauthorizedException {
        throw new UnauthorizedException("Unauthorized to delete storage");
    }
}
