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