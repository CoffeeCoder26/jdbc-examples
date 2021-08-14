/***
 * Prepared Statement Benefits:
 * Improve Performance
 * Prevent aganist sql dependency injection attack
 * make it easier to set sql parameter values
 * Can reuse it
 */



package jdbcdemo;

import java.sql.*;

public class PreparedStatment {

    public static void displayResult(ResultSet myRes) throws SQLException {

        while (myRes.next()) {
            System.out.println(myRes.getString("EmpName") + " " + myRes.getInt("EmpSalary") + " " + myRes.getString("EmpDepartment"));

        }

    }

    public static void main(String[] args) throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/TestDB";
        String UserName = "root";
        String Pass = "";
        PreparedStatement myStatement = null;
        ResultSet myRes = null;
        Connection myConnection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get Connection
            myConnection = DriverManager.getConnection(URL, UserName, Pass);

            //Prepare Statment
            myStatement = myConnection.prepareStatement("Select * from Employee where EmpSalary > ? and EmpDepartment = ?");

            //Set The Parameter
            myStatement.setInt(1, 3000);
            myStatement.setString(2, "HR");

            //Execute Query
            myRes = myStatement.executeQuery();

            displayResult(myRes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (myRes != null) {
                myRes.close();
            }

            if (myStatement != null) {
                myStatement.close();
            }

            if (myConnection != null) {
                myConnection.close();
            }

        }
    }
}
