import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection; // Use java.sql.Connection here

    // Database connection details

    private static final String dbName = "library_db";
    private static final String userName = "root";
    private static final String password = "";
    private static final String URL = "jdbc:mysql://localhost:3306/" + dbName;

    // Method to get the database connection

    public static Connection getConnection() {

        // Check if the connection is already created
        if (connection == null) {
            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Create the connection
                connection = DriverManager.getConnection(URL, userName, password);
            } catch (ClassNotFoundException | SQLException exception) {
                // Handle any exceptions that may occur during connection setup
                exception.printStackTrace();
            }
        }

        // Return the connection object
        return connection;
    }

    public void closeConnection() {

        // Check if the connection is not null
        if (connection != null) {
            try {
                // Close the connection
                connection.close();
            } catch (SQLException exception) {
                // Handle any exceptions that may occur while closing the connection
                exception.printStackTrace();
            }
        }
    }
}