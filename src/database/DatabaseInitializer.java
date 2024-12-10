package database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initialize() {
        // Check if tables exist
        if (tablesExist()) {
            System.out.println("Tables already exist. Skipping initialization.");
            return;
        }

        // Table creation SQL commands
        String createUsersTable = "CREATE TABLE IF NOT EXISTS Users (" +
                "userId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL UNIQUE," +
                "password TEXT NOT NULL," +
                "role TEXT NOT NULL);";

        String createStoragesTable = "CREATE TABLE IF NOT EXISTS Storages (" +
                "storageId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "rows INTEGER NOT NULL," +
                "columns INTEGER NOT NULL);";

        String createProductsTable = "CREATE TABLE IF NOT EXISTS Products (" +
                "productId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "storageId INTEGER NOT NULL, " +
                "row INTEGER NOT NULL, " +
                "column INTEGER NOT NULL, " +
                "name TEXT NOT NULL, " +
                "FOREIGN KEY (storageId) REFERENCES Storages(storageId), " +
                "UNIQUE (storageId, row, column));";


        String createHistoryLogsTable = "CREATE TABLE IF NOT EXISTS HistoryLogs (" +
                "logId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "log TEXT NOT NULL," +
                "userId INTEGER NOT NULL," +  // Fixed the syntax here (removed the extra 'INTEGER')
                "FOREIGN KEY (userId) REFERENCES Users(userId));";


        try (Connection conn = SQLiteConnection.connect();
             Statement stmt = conn.createStatement()) {

            // Execute table creation SQL
            stmt.execute(createUsersTable);
            stmt.execute(createStoragesTable);
            stmt.execute(createProductsTable);
            stmt.execute(createHistoryLogsTable);

            System.out.println("Database tables created successfully.");
        } catch (Exception e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }

    // Helper method to check if tables exist
    private static boolean tablesExist() {
        String checkTablesSQL = "SELECT name FROM sqlite_master WHERE type='table' AND name IN ('Users', 'Storages', 'Products', 'HistoryLogs');";
        try (Connection conn = SQLiteConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(checkTablesSQL)) {

            // If there are rows in the result set, at least one table exists
            return rs.next();
        } catch (Exception e) {
            System.out.println("Error checking for existing tables: " + e.getMessage());
        }
        return false; // Default to false if an error occurs
    }
}
