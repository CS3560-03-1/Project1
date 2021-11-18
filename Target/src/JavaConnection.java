import java.sql.*;

public class JavaConnection
{
    String driverClassName = "com.mysql.cj.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/mydb";
    String dbUser = "root";
    String dbPwd = "4JForte2006#";

    private static JavaConnection javaConnection = null;

    private JavaConnection()
    {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static JavaConnection getInstance() {
        if (javaConnection == null) {
            javaConnection = new JavaConnection();
        }
        return javaConnection;
    }
}
/*
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
 */