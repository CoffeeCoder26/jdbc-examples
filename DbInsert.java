// Insert Data to PHPMYADMIN

package jdbcdemo;

import java.sql.*;

public class DbInsert {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/TestDB";
        String UserName = "root";
        String Pass = "";
        try {
            //you can add cj or not
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a Connection
            Connection mConnection = DriverManager.getConnection(URL, UserName, Pass);

            // Create a Statment
            Statement myStatement = mConnection.createStatement();

            //Execute Sql Query
            String sql = "insert into student "
                    + "(StudentFirstName , StudentLastName , StudentId , StudentEmail)"
                    + " values ('Sherif','Muhammed',3,'sheko@gmail.com')";

            myStatement.executeUpdate(sql);

            System.out.println("Data Is Inserted .....");

        } catch (Exception e) {
            
            System.out.println(e.toString());
        }
    }

}
