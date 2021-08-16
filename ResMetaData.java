/**
 *
 * If you have to get metadata of a table like total number of column, column name, column type etc. ,
 * ResultSetMetaData interface is useful because it provides methods to get metadata from the ResultSet object.
 *
 */

import java.sql.*;

public class ResMetaData {
    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/TestDB";
        String UserName = "root";
        String Pass = "";

        Connection myConnection = null;
        Statement myStatement = null;
        ResultSet myRes = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get a connection
            myConnection = DriverManager.getConnection(URL,UserName,Pass);
            // Create statement
            myStatement = myConnection.createStatement();

            myRes = myStatement.executeQuery("select EmpId , EmpName,EmpSalary from Employee");

            ResultSetMetaData resultSetMetaData = myRes.getMetaData();

            int columnCount = resultSetMetaData.getColumnCount();

            System.out.println("Column Count : " + columnCount +"\n");

            for (int column = 1; column <= columnCount; column++) {

                System.out.println("Column Name : " +resultSetMetaData.getColumnName(column));
                System.out.println("Column Type Name : " +resultSetMetaData.getColumnTypeName(column));
                System.out.println("Is Nullable : " +resultSetMetaData.isNullable(column));
                System.out.println("Is AutoIncrement  : " +resultSetMetaData.isAutoIncrement(column));

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
