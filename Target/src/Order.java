import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Order {
    private int orderID;
    private boolean confirmation;
    private String delMethod;

    public Order()
    {
        orderID = 0;
        confirmation = false;
        delMethod = "in-person";
    }

    public Order(int ID, boolean confirm, String delMet){
        orderID = ID;
        confirmation = confirm;
        delMethod = delMet;
    }

    public int getOrderID() {
        return orderID;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public String getDelMethod() {
        return delMethod;
    }

    public void setConfirmation(boolean status){
        //change the status of order confirmation
        this.confirmation = status;
    }

    public void setDelMethod(String delMethod) {
        this.delMethod = delMethod;
    }





    public static void printOrderInfo(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "4JForte2006#");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM mydb.order;");

            while (resultSet.next()) {
                System.out.println("Delivery Method: " + resultSet.getString("deliveryMethod"));
                System.out.print("Confirmation: ");

                if(resultSet.getInt("confirmation") == 1){
                    System.out.print("Order Confirmed.\n");
                }
                else {
                    System.out.println("Order Not Yet Confirmed.\n");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        printOrderInfo();
    }
}
