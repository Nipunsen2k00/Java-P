import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchBook {
    // Scanner object to read input from the user
    private static final Scanner scanner = new Scanner(System.in);


    // Method to handle searching for a book

    public void searchForBook() {

        // Prompt the user for search criteria


        System.out.print("Enter search criteria (title/author/year): ");
        String criteria = scanner.nextLine();


        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        try{
            String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ? OR year_published = ?";
             PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + criteria + "%");
            stmt.setString(2, "%" + criteria + "%");
            try {

                int year = Integer.parseInt(criteria);
                stmt.setInt(3, year);
            } catch (NumberFormatException e) {
                stmt.setInt(3, -1); // Invalid year to ignore
            }
            // Execute the query and process the ResultSet
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    // Print the details of each matching book
                    System.out.printf("ID: %d, Title: %s, Author: %s, Publisher: %s, Year: %d%n",
                            rs.getInt("book_id"), rs.getString("title"), rs.getString("author"),
                            rs.getString("publisher"), rs.getInt("year_published"));
                }
            }
        } catch (SQLException e) {

            // Handle any SQL exceptions that occur
            e.printStackTrace();
        }
    }
}
