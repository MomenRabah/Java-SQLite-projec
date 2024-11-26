package classes;
public class Storage{
    private String storageId; 
    private int rows;         
    private int columns;      

    public Storage(String storageId, int rows, int columns){
        this.storageId = storageId;
        this.rows = rows;
        this.columns = columns;
    }

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

    public String getStorageDetails(){
        return String.format("Storage ID: %s, Rows: %d, Columns: %d", storageId, rows, columns);
    }
}
