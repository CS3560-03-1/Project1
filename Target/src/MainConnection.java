package sample;

import java.sql.*;

public class MainConnection {

     public Connection databaseLink;

     public Connection getConnection(){
         String databaseName = "";
         String databaseUser = "root";
         String databasePassword = "jpacio123";
         String url = "jdbc:mysql://localhost/" + databaseName;

         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
         }

         catch(Exception e){
             e.printStackTrace();
         }
         return databaseLink;
     }

}
