package carsharing;

import java.sql.*;

public class Main {
    
    // JDBC Driver name and Database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:./src/carsharing/db/carsharing";
    
    // Database credentials <-- don't use it, if you wish to pass tests!
    //static final String DB_USER = "";
    //static final String DB_PASSWORD = "";
    
    public static void main(String[] args) {
        // write your code here
        
        // Five (5) steps to create a JDBC connection:
        // ~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~
        
        try {
            // Step 1--Registering the JDBC database driver
            Class.forName(JDBC_DRIVER);
            System.out.println("H2 JDBC Driver Registered!");
            
            // Step 2--Opening the connection
            Connection connection;
            Statement statement;
            
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(
                    DB_URL); //,
                    //DB_USER,
                    //DB_PASSWORD);
            
            if (connection != null) {
                System.out.println("Connection made to DB!");
                
                // enable the auto-commit mode so that all changes are automatically saved in
                // the database file
                connection.setAutoCommit(true);
            }
            
            // Step 3--Creating a statement
            System.out.println("Creating table in given database...");
            
            // create query for database as string
            String sql = "CREATE TABLE COMPANY" +
                    " (id INT NOT NULL, " +
                    " name VARCHAR, " +
                    " PRIMARY KEY (ID))";
            
            if (connection != null) {
                statement = connection.createStatement();
                
                // Step 4--Executing a statement and receiving ResultSet
                if (statement != null) {
                    statement.executeUpdate(sql);
                    System.out.println("Created table in given database.");
                    
                    // close statement after execution
                    statement.close();
                }
                
                // Step 5--Closing a connection
                connection.close();
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your H2 JDBC Driver?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQL Statement Creation Error Occurred!");
            System.out.println("SQL Statement Execution Error Occurred!");
            System.out.println("Close Connection Error Occurred!");
            e.printStackTrace();
        }
        System.out.println("Goodbye!");
    }
}