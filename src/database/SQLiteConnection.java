package database;
<<<<<<< HEAD

import java.sql.Connection;
import java.sql.DriverManager;
=======
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b

public class SQLiteConnection {
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:data/database.db";
            conn = DriverManager.getConnection(url);
<<<<<<< HEAD
            System.out.println("Connection to SQLite has been established.");
        } catch (Exception e) {
=======
        } catch (SQLException e) {
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
            System.out.println(e.getMessage());
        }
        return conn;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
