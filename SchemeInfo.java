package jdbcdemo; /**
 * Scheme information like tabels name , and columns
 */

import java.sql.*;
import java.sql.SQLException;

public class SchemeInfo {
    public static void main(String[] args) throws SQLException {

        String URL = "jdbc:mysql://localhost:3306/TestDB";
        String UserName = "root";
        String Pass = "";
        String catalog = null;
        String schemePattern = null;
        String tableNamePattern = null;
        String columnNamePattern = null;
        String [] types = null;

        Connection myConnection = null;
        ResultSet myRes = null;


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            /***
             * Get a connection to database
             */
            myConnection = DriverManager.getConnection(URL,UserName,Pass);

            DatabaseMetaData databaseMetaData = myConnection.getMetaData();

            /**
             * Tables in database scheme
             */
            System.out.println("List Of Tables");
            System.out.println("----------------");

            myRes = databaseMetaData.getTables(catalog,schemePattern,tableNamePattern,types);

            while (myRes.next()){
                System.out.println(myRes.getString("TABLE_NAME"));
            }

            /**
             * List of columns
             */
            System.out.println("List Of Columns");
            System.out.println("---------------");

            myRes = databaseMetaData.getColumns(catalog,schemePattern,"Employee",columnNamePattern);


            while (myRes.next()){
                System.out.println(myRes.getString("COLUMN_NAME"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
