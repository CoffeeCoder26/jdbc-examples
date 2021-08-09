/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcdemo;

import java.sql.*;

public class UpadatingData {

    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/TestDB";
        String UserName = "root";
        String Pass = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // get Connection
            Connection myConnection = DriverManager.getConnection(URL, UserName, Pass);

            //Create Statement
            Statement myStatement = myConnection.createStatement();

            String SqlQuery = "update student "
                    + "set StudentEmail ='mero@yahoo.com'"
                    + "where StudentId = 4";
            
            myStatement.executeUpdate(SqlQuery);
            
            System.out.println("Data Is Updated ...");

        } catch (Exception e) {
            
            System.out.println(e.toString());
        }

    }
}
