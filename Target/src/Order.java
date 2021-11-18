import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Order {
    private int orderID;
    private int confirmation;
    private String delMethod;

    public Order()
    {
        orderID = 0;
        confirmation = 0;
        delMethod = "In-Person";
    }

    public Order(int ID, int confirm, String delMet){
        orderID = ID;
        confirmation = confirm;
        delMethod = delMet;
    }

    public int getOrderID() {
        return orderID;
    }

    public int isConfirmation() {
        return confirmation;
    }

    public String getDelMethod() {
        return delMethod;
    }

    public void setConfirmation(int status){
        //change the status of order confirmation
        this.confirmation = status;
    }

    public void setDelMethod(String delMethod) {
        this.delMethod = delMethod;
    }

    //Retrieves order ID of the latest order made (used for order confirmation screen in the GUI)
    public int dbGetLatestOrderID(){
        int result = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "jpacio123");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT orderID FROM mydb.order WHERE orderID = MAX(orderID)");

            result = resultSet.getInt("orderID");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    //Retrieve the Delivery Method of the desired order ID
    public String dbGetDelMethod(int ID){
        String result = " ";
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "jpacio123");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT deliveryMethod FROM mydb.order WHERE orderID ='" + ID + "';");

            result = resultSet.getString("deliveryMethod");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    //Set Delivery Method when you are choosing it in the GUI (i'm just assuming the delivery method screen will be made lol)
    public void dbSetDelMethod(String method){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "jpacio123");

            Statement statement = connection.createStatement();

            statement.executeUpdate("UPDATE mydb.order SET deliveryMethod ='" + method + "' WHERE orderID = MAX(orderID);");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //Adds new order entry to the database
    public void createOrder() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "jpacio123");

            Statement statement = connection.createStatement();

            int orderAmount = 1; //orderID would start at 1

            //Retrieves orderID x amount of times to see how many order entries exist
            ResultSet retriever = statement.executeQuery("SELECT orderID FROM mydb.order;");

            while (retriever.next()) {
                orderAmount++;
            }

            statement.executeUpdate("INSERT INTO mydb.order (orderID, confirmation, deliveryMethod) VALUES (" + orderAmount + ", 0, 'Delivery')");
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
