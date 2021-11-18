import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InventoryItem
{
    private int inventoryID;
    private String itemName;
    private int quantity;
    private float cost;
    private String color;
    private float weight;
    private String size;
    private String description;

    public InventoryItem(String itemName)
    {
        this.itemName = itemName;
        inventoryID = 0;
        quantity = 0;
        cost = 0.0F;
        color = "";
        weight = 0.0F;
        size = "";
        description = "";
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public int getQuantity(){
        return quantity;
    }

    public float getCost()
    {
        return cost;
    }

    public String getColor()
    {
        return color;
    }

    public float getWeight()
    {
        return weight;
    }

    public String getSize()
    {
        return size;
    }

    public String getDescription()
    {
        return description;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void getInventoryItems(){

    }

    //Retrieves Item Description of the desired item ID (any int from 1-16) (used for product screen in the GUI)
    public String dbGetDesc(int ID){
        String result = " ";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "jpacio123");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT description FROM mydb.inventoryitem WHERE inventoryItemID = '" + ID + "'");

            result = resultSet.getString("description");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public String dbGetItemName(int ID){
        String result = " ";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "jpacio123");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT item name FROM mydb.inventoryitem WHERE inventoryItemID = '" + ID + "'");

            result = resultSet.getString("item name");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    //Retrieve the Cost of the desired item (Use ID's 1-16)
    public double dbGetCost(int ID){
        double result = 0.0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "jpacio123");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT cost FROM mydb.inventoryitem WHERE inventoryItemID = '" + ID + "'");

            result = resultSet.getDouble("cost");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    //Sets the quantity of the items ordered (will be used in product screen when buying)
    public void dbSetQuantity(int quantity, int ID) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "jpacio123");

            Statement statement = connection.createStatement();

            statement.executeUpdate("UPDATE mydb.inventoryitem SET quantity =" + quantity + " WHERE inventoryItemID =" + ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Retrieve the Quantity of the item ordered (Use ID's 1-16) (will be used in the shopping cart screen)
    public int dbGetQuantity(int ID) {
        int result = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "jpacio123");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT quantity FROM mydb.inventoryitem WHERE inventoryItemID = '" + ID + "'");

            result = resultSet.getInt("quantity");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
