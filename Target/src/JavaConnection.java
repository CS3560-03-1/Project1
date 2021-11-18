import java.sql.*;

public class JavaConnection {
    public static void main(String[] args){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "jpacio123");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM mydb.order;");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("deliveryMethod"));
                System.out.println(resultSet.getString("confirmation"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
