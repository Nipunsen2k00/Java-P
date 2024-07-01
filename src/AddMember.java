import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddMember {

    // Scanner object to read input from the user
    private static final Scanner scanner = new Scanner(System.in);

    // Method to handle the addition of a new member

    public void addNewMember() {

        // Prompt the user for member details


        System.out.println("Enter member details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();


        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        try {

            // SQL query to insert a new member record
            String sql = "INSERT INTO members (name, email, phone) VALUES (?, ?, ?)";
             PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);

            // Execute the update
            stmt.executeUpdate();

            // Print a success message
            System.out.println("Member added successfully!");
        } catch (SQLException e) {

            // Handle any SQL exceptions that occur
            e.printStackTrace();
        }

    }
}

