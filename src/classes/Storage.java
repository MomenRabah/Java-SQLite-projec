package classes;
public class Storage{
    private String storageId; // Unique identifier for each storage unit
    private int rows;         // Number of rows in the storage unit
    private int columns;      // Number of columns in the storage unit

    // Constructor
    public Storage(String storageId, int rows, int columns){
        this.storageId = storageId;
        this.rows = rows;
        this.columns = columns;
    }

    // Getters & Setters
    public String getStorageId(){
        return storageId;
    }

    public void setStorageId(String storageId){
        this.storageId = storageId;
    }

    public int getRows(){
        return rows;
    }

    public void setRows(int rows){
        this.rows = rows;
    }

    public int getColumns(){
        return columns;
    }

    public void setColumns(int columns){
        this.columns = columns;
    }

    // Retrieves details of a storage unit
    public String getStorageDetails(){
        return String.format("Storage ID: %s, Rows: %d, Columns: %d", storageId, rows, columns);
    }
}
