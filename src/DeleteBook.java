import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBook {

    // Scanner object to read input from the user
    private static final Scanner scanner = new Scanner(System.in);

    // Method to handle the deletion of a book

    public void deleteBook() {

        // Prompt the user for the book ID to delete
        System.out.print("Enter book ID to delete: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create an instance of DatabaseConnection and get the connection
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();



        try {

            // SQL query to delete a book record by book ID
            String sql = "DELETE FROM books WHERE book_id = ?";

            // Create a PreparedStatement to execute the query
             PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, bookId);


            // Execute the update
            stmt.executeUpdate();


            // Print a success message
            System.out.println("Book deleted successfully!");
        } catch (SQLException e) {

            // Handle any SQL exceptions that occur
            e.printStackTrace();
        }
    }
}

