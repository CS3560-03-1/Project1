import java.sql.*;

public class mainConnection {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "jpacio123");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("custName"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
