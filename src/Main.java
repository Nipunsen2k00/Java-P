import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    // Create a Scanner object to read user input
    private static final Scanner scanner = new Scanner(System.in);

    // Create instances of different classes responsible for various operations
    private static final AddBook addBook = new AddBook();
    private static final UpdateBook updateBook = new UpdateBook();
    private static final DeleteBook deleteBook = new DeleteBook();
    private static final SearchBook searchBook = new SearchBook();
    private static final AddMember addMember = new AddMember();
    private static final LoanBook loanBook = new LoanBook();
    private static final ReturnBook returnBook = new ReturnBook();

    public static void main(String[] args) throws SQLException {
        for (;;) {

            // Display the menu options

            System.out.println(" Welcome to Library Management System");
            System.out.println("1. Add a New Book");
            System.out.println("2. Update Book Details");
            System.out.println("3. Delete a Book");
            System.out.println("4. Search for a Book");
            System.out.println("5. Add a New Member");
            System.out.println("6. Loan a Book");
            System.out.println("7. Return a Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            // Read user input for the menu choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1){
                // If the user chooses option 1, call the method to add a new book
                addBook.addNewBook();
            }
            else if (choice == 2){
                // If the user chooses option 2, call the method to update book details
                updateBook.updateBookDetails();
            }
            else if (choice == 3){
                // If the user chooses option 3, call the method to delete a book
                deleteBook.deleteBook();
            }
            else if(choice == 4){
                // If the user chooses option 4, call the method to search for a book
                searchBook.searchForBook();
            }
            else if (choice == 5){
                // If the user chooses option 5, call the method to add a new member
                addMember.addNewMember();
            }
            else if (choice == 6){
                // If the user chooses option 6, call the method to loan a book
                loanBook.loanBook();
            }
            else if (choice == 7){
                // If the user chooses option 7, call the method to return a book
                returnBook.returnBook();
            }
            else if (choice == 8){
                // If the user chooses option 8, exit the program
                System.out.println("Exiting...");
                break;
            }
            else {
                // If the user enters an invalid choice, display an error message
                System.out.println("Sorry..Invalid choice! Please try again.");
            }
            // Print a blank line for better readability of the menu
            System.out.println(" ");
        }

    }
}