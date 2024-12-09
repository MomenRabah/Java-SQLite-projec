import classes.Inventory;
import database.DatabaseInitializer;

public class Main {

    private static final Inventory inventory = new Inventory();

    public static void main(String[] args) {
        DatabaseInitializer.initialize();
        inventory.start();
    }
}
