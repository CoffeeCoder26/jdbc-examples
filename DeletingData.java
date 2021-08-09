/*
 * Deleting Data
 */
package jdbcdemo;

import java.sql.*;

public class DeletingData {
    
    public static void main(String[] args) {
        
        String URL ="jdbc:mysql://localhost:3306/TestDB";
        String UserName = "root";
        String Pass = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Get A Connection
            
            Connection myConnection = DriverManager.getConnection(URL,UserName,Pass);
            
            // Create Statment
            
            Statement myStatement = myConnection.createStatement();
            
            // Query
            
            String SqlQuery = "delete from Student where StudentLastName = 'Abo Agiza'";
            
            int rowAffected = myStatement.executeUpdate(SqlQuery);
            
            System.out.println("Row Affected .. "+ rowAffected);
            System.out.println("Data Is Deleted ....");
            
        } catch (Exception e) {
        
            System.out.println(e.toString());
        }
        
    }
    
}
