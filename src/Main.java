<<<<<<< HEAD
import database.DatabaseInitializer;


public class Main {

        public static void main(String[] args) {
            DatabaseInitializer.initialize();
        }
    
=======
import classes.Inventory;
import database.DatabaseInitializer;

public class Main {

    private static final Inventory inventory = new Inventory();

    public static void main(String[] args) {
        try{
            DatabaseInitializer.initialize();
            inventory.start();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
>>>>>>> 387d506a5968bc18bd74a74d83c400925709fc0b
}
