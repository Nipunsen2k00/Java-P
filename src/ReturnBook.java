import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ReturnBook {

    // Scanner object to read input from the user
    private static final Scanner scanner = new Scanner(System.in);


    // Method to handle the returning of a book

    public void returnBook() {

        // Prompt the user for the loan ID
        System.out.print("Enter loan ID to return: ");

        // Consume the newline left-over
        int loanId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter return date (YYYY-MM-DD): ");
        String returnDate = scanner.nextLine();

        String sql = "UPDATE loans SET return_date = ? WHERE loan_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the parameters for the PreparedStatement
            stmt.setDate(1, Date.valueOf(returnDate));
            stmt.setInt(2, loanId);

            // Execute the update
            stmt.executeUpdate();

            // Print a success message
            System.out.println("Book returned successfully!");
        } catch (SQLException e) {

            // Handle any SQL exceptions that occur
            e.printStackTrace();
        }
    }
}
