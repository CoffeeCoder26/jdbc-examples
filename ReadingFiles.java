/***
 * Reading any documnets from db
 * 
 */



package jdbcdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

/**
 *
 * @author Abo Agiza
 */
public class ReadingFiles {

    public static void main(String[] args) {
        InputStream input = null;
        String URL = "jdbc:mysql://localhost:3306/TestDB";
        String UserName = "root";
        String Pass = "";
        try {

            //you can add cj or not
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a Connection
            Connection myConnection = DriverManager.getConnection(URL, UserName, Pass);
            //Execute Query

            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "select ResumeEmp from Employee where EmpEmail ='mero@gmail.com'";

            ResultSet myRes = myStatement.executeQuery(sqlQuery);

            //Handle The File
            File theFile = new File("ResumeEmp_From_DB.txt");
            FileOutputStream outputStream = new FileOutputStream(theFile);

            if (myRes.next()) {
                input = myRes.getBinaryStream("ResumeEmp");
                System.out.println("Reading Resume From Database ...");
                System.out.println(sqlQuery);

                byte[] readFromDB = new byte[1024];

                while (input.read(readFromDB) > 0) {
                    outputStream.write(readFromDB);
                }
                System.out.println("\nSaved To The Local File ..." + theFile.getAbsolutePath());
                System.out.println("Done ya Rays.....");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
