package classes;
<<<<<<< HEAD
=======

import services.UserServices;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class Authorization {

    private static final String FIXED_SALT = "ThisIsAFixedSaltString123";
    UserServices userServices = new UserServices();

    private String hashPassword(String password) {
        try {
            int iterations = 10000;
            int keyLength = 256;

            PBEKeySpec spec = new PBEKeySpec(
                    password.toCharArray(),
                    FIXED_SALT.getBytes(),
                    iterations,
                    keyLength);

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = keyFactory.generateSecret(spec).getEncoded();

            return Base64.getEncoder().encodeToString(hash);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Error: Unable to hash password", e);
        }
    }

    public User register(String username, String password, String role) {
        String hashedPassword = hashPassword(password);
        return userServices.createUser(username, hashedPassword, role);
    }

    public User login(String username, String password) {
        User user = userServices.getUserByUsername(username);
        if (user == null) {
            return null;
        }

        String hashedPassword = hashPassword(password);
        if (hashedPassword.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
