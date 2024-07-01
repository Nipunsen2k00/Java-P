import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddBook {
    // Create a Scanner object to read user input
    private static final Scanner scanner = new Scanner(System.in);

    // Method to add a new book

    public void addNewBook() {

        // Prompt user to enter book details
        System.out.println("Enter book details:");
        System.out.print("Title: ");
        String title = scanner.nextLine();  // Read the title
        System.out.print("Author: ");
        String author = scanner.nextLine();  // Read the author
        System.out.print("Publisher: ");
        String publisher = scanner.nextLine();  // Read the publisher
        System.out.print("Year Published: ");
        int yearPublished = scanner.nextInt();  // Read the year published
        scanner.nextLine(); // Consume newline


        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        try{
            String sql = "INSERT INTO books (title, author, publisher, year_published) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);  // Prepare the SQL statement
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, publisher);
            stmt.setInt(4, yearPublished);
            stmt.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}