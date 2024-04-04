package simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. Import --> Java.sql
 * 2. Load and register the driver --> com.mysql.cj.jdbc.driver
 * 3. Create a connection
 * 4. Crate a statement
 * 5. Execute the query
 * 6. Process the result
 * 7. Close the connection
 * */

public class AbrDeleteQuery {
    static final String DB_URL = "jdbc:mysql://localhost:3306/aliens";
    static final String USER_NAME = "root";
    static final String PASSWORD = "Paulsam@264";
    public static void main(String[] args){
        try(Connection conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD); 
        		Statement stmt = conn.createStatement();
        		) {
        	System.out.println("Updating records into the table student started..");
            String sql = "DELETE FROM students WHERE (`id` = '5');";
            stmt.executeUpdate(sql);
            System.out.println("Updation records into the table student is completed..");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
