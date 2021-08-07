// Database Connection In Java
package jdbcdemo;

import java.sql.*;

public class DatabaseConnection {

    public static Connection getConnection(String URL, String UserName, String Pass) throws SQLException {
        
        Connection myConnection = DriverManager.getConnection(URL, UserName, Pass);
        myConnection.setAutoCommit(true);
        return myConnection;

    }

    public static void main(String[] args) throws SQLException {
        Connection myConnection = null;
        String URL = "jdbc:mysql://localhost:3306/TestDB";
        String UserName = "root";
        String Pass = "";
        
        try {
            
            myConnection = DatabaseConnection.getConnection(URL, UserName, Pass);
            System.out.println("Database Is Connected ....");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            myConnection.close();
        }
    }

}
