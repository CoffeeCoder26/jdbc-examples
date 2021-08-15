/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcdemo;

import java.sql.*;

public class DbMetaData {

    public static void main(String[] args) throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/TestDB";
        String UserName = "root";
        String Pass = "";

        Connection myConnection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            /**
             * Get a Connection
             *
             */
            myConnection = DriverManager.getConnection(URL, UserName, Pass);

            DatabaseMetaData dbMetaData = myConnection.getMetaData();

            /**
             * *
             * Display information about database
             */
            System.out.println("Product Name : " + dbMetaData.getDatabaseProductName());
            System.out.println("Product Version : " + dbMetaData.getDatabaseProductVersion());
            System.out.println();
            /**
             * Display information about JDBC Driver
             */
            System.out.println("Driver Name : " + dbMetaData.getDriverName());
            System.out.println("Driver Version : " + dbMetaData.getDriverVersion());

            myConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
