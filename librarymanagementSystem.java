package javaapplication20;
import java.util.Scanner;
public class librarymanagementSystem{
public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // number of books
        System.out.print("Enter the  number of books : ");
        int maxBooks = input.nextInt();
        input.nextLine(); 

        // arrays
        String[] bookTitles = new String[maxBooks];
        String[] bookDescriptions = new String[maxBooks];
        boolean[] bookIssued = new boolean[maxBooks];
        int bookCount = 0;

        int choice;

        do {
            // user interface
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. Search for a Book");
            System.out.println("3. Issue a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Delete a Book");
            System.out.println("6. Edit Book Details");
            System.out.println("7. View All Books");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: // إضافة كتاadd book
                    if (bookCount < maxBooks) {
                        System.out.print("Enter book title: ");
                        String title = input.nextLine();
                        System.out.print("Enter book description: ");
                        String description = input.nextLine();

                        if (!title.equals("")) {
                            bookTitles[bookCount] = title;
                            bookDescriptions[bookCount] = description;
                            bookIssued[bookCount] = false; 
                            bookCount++;
                            System.out.println("Book added successfully.");
                        } else {
                            System.out.println("Error: Title cannot be empty.");
                        }
                    } else {
                        System.out.println("Library is full!");
                    }
                    break;

                case 2: // find book
                    System.out.print("Enter book title to search: ");
                    String searchTitle = input.nextLine();
                    boolean found = false;

                    for (int i = 0; i < bookCount; i++) {
                        if (bookTitles[i].equalsIgnoreCase(searchTitle)) {
                            System.out.println("Book ID: " + (i + 1));
                            System.out.println("Title: " + bookTitles[i]);
                            System.out.println("Description: " + bookDescriptions[i]);
                            if ( bookIssued[i] == true )
                                System.out.println("Available");
                            else
                                System.out.println("not Avilable");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3: // issue book
                    System.out.print("Enter book ID to issue: ");
                    int issueId = input.nextInt();
                    input.nextLine(); 
                    if (issueId > 0 && issueId <= bookCount) {
                        if (!bookIssued[issueId - 1]) {
                            bookIssued[issueId - 1] = false;
                            System.out.println("Book issued successfully.");
                        } else {
                            System.out.println("Book is already issued.");
                        }
                    } else {
                        System.out.println("Invalid book ID.");
                    }
                    break;

                case 4: // return book
                    System.out.print("Enter book ID to return: ");
                    int returnId = input.nextInt();
                    input.nextLine(); 
                    if (returnId > 0 && returnId <= bookCount) {
                        if (bookIssued[returnId - 1]) {
                            bookIssued[returnId - 1] = true;
                            System.out.println("Book returned successfully.");
                        } else {
                            System.out.println("Book was not issued.");
                        }
                    } else {
                        System.out.println("Invalid book ID.");
                    }
                    break;

                case 5: // delete book
                    System.out.print("Enter book ID to delete: ");
                    int deleteId = input.nextInt();
                    input.nextLine(); 
                    if (deleteId > 0 && deleteId <= bookCount) {
                        for (int i = deleteId - 1; i < bookCount - 1; i++) {
                            bookTitles[i] = bookTitles[i + 1];
                            bookDescriptions[i] = bookDescriptions[i + 1];
                            bookIssued[i] = bookIssued[i + 1];
                        }
                        bookCount--;
                        System.out.println("Book deleted successfully.");
                    } else {
                        System.out.println("Invalid book ID.");
                    }
                    break;

                case 6: //edit book
                    System.out.print("Enter book ID to edit: ");
                    int editId = input.nextInt();
                    input.nextLine(); 
                    if (editId > 0 && editId <= bookCount) {
                        System.out.print("Enter new title (leave blank to keep current): ");
                        String newTitle = input.nextLine();
                        System.out.print("Enter new description (leave blank to keep current): ");
                        String newDescription = input.nextLine();

                        if (!newTitle.isEmpty()) {
                            bookTitles[editId - 1] = newTitle;
                        }
                        if (!newDescription.isEmpty()) {
                            bookDescriptions[editId - 1] = newDescription;
                        }
                        System.out.println("Book details updated successfully.");
                    } else {
                        System.out.println("Invalid book ID.");
                    }
                    break;

                case 7: // show all books
                    if (bookCount == 0) {
                        System.out.println("No books in the library.");
                    } else {
                        for (int i = 0; i < bookCount; i++) {
                            System.out.println("Book ID: " + (i + 1));
                            System.out.println("Title: " + bookTitles[i]);
                            System.out.println("Description: " + bookDescriptions[i]);
                           if ( bookIssued[i] == true )
                                System.out.println("Available");
                            else
                                System.out.println("not Avilable");
                            System.out.println("");
                        }
                    }
                    break;

                case 8: // exit
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        input.close();
    }
}
