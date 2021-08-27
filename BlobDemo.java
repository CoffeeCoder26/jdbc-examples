/*
 * Blob : Binary Large Object
 * It is a Collection of Binary Data stored in single entity
 */
package jdbcdemo;

import java.io.*;
import java.io.FileInputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlobDemo {

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        String URL = "jdbc:mysql://localhost:3306/TestDB";
        String UserName = "root";
        String Pass = "";

        try {
            //you can add cj or not
             Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a Connection
            Connection myConnection = DriverManager.getConnection(URL, UserName, Pass);

            //Sql Query
            String sqlQuery = "update Employee set ResumeEmp = ? where EmpId = 3 ";

            PreparedStatement myPreparedStatement = myConnection.prepareStatement(sqlQuery);

            // Set The Parameter for resume 
            File theFile = new File("Demo.txt");
            FileInputStream fileInputStream = new FileInputStream(theFile);
            myPreparedStatement.setBinaryStream(1, fileInputStream);

            System.out.println("Reading The File " + theFile.getAbsolutePath());
            System.out.println("Storing Resume in DB " + theFile);
            System.out.println(sqlQuery);
            myPreparedStatement.executeUpdate();
            System.out.println("Completed Successfully.....");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }
}
