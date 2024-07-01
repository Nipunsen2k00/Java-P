import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateBook {

    // Scanner object to read input from the user
    private static final Scanner scanner = new Scanner(System.in);


    // Method to handle updating book details

    public void updateBookDetails() {

        // Prompt the user for the book ID to update
        System.out.print("Enter book ID to update: ");
        int bookId = scanner.nextInt();

        // Consume the newline left-over
        scanner.nextLine(); // Consume newline
        System.out.println("Enter new details:");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Year Published: ");
        int yearPublished = scanner.nextInt();

        // Consume the newline left-over
        scanner.nextLine(); // Consume newline
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();



        try {

            // SQL query to update a book record
            String sql = "UPDATE books SET title = ?, author = ?, publisher = ?, year_published = ? WHERE book_id = ?";
             PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, publisher);
            stmt.setInt(4, yearPublished);
            stmt.setInt(5, bookId);

            // Execute the update
            stmt.executeUpdate();

            // Print a success message
            System.out.println("Book updated successfully!");
        } catch (SQLException e) {

            // Handle any SQL exceptions that occur
            e.printStackTrace();
        }
    }
}

