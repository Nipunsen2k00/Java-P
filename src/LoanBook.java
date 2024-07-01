import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LoanBook {

    // Scanner object to read input from the user
    private static final Scanner scanner = new Scanner(System.in);

    // Method to handle the loaning of a book

    public void loanBook() {

        // Prompt the user for book ID
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();

        // Prompt the user for member ID
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Prompt the user for the loan date
        System.out.print("Enter loan date (YYYY-MM-DD): ");
        String loanDate = scanner.nextLine();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();



        try {

            // SQL query to insert a new loan record
            String sql = "INSERT INTO loans (book_id, member_id, loan_date) VALUES (?, ?, ?)";

            // Create a PreparedStatement to execute the query
             PreparedStatement stmt = connection.prepareStatement(sql);

            // Set the parameters for the PreparedStatement
            stmt.setInt(1, bookId);
            stmt.setInt(2, memberId);
            stmt.setDate(3, Date.valueOf(loanDate));

            // Execute the update

            stmt.executeUpdate();

            // Print a success message
            System.out.println("Book loaned successfully!");
        } catch (SQLException e) {

            // Handle any SQL exceptions that occur
            e.printStackTrace();
        }
    }
}
