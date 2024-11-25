package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteConnection {
    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:data/database.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}