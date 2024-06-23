import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println();
            System.out.println("Welcome to the Library Management System");
            System.out.println("1. Add Library Item");
            System.out.println("2. Edit Library Item");
            System.out.println("3. Delete Library Item");
            System.out.println("4. Borrow Library Item");
            System.out.println("5. Return Library Item");
            System.out.println("6. Search Item by Title");
            System.out.println("7. Search Item by Author");
            System.out.println("8. Search for Author");
            System.out.println("9. Exit");
            System.out.print("Enter your choice (1-9): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character after nextInt()

            switch (choice) {
                case 1:
                    System.out.println("Adding a new library item...");

                    System.out.print("Is this a Book or a Periodical? (B/P): ");
                    String itemType = scanner.nextLine().trim().toUpperCase();

                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character after nextInt()

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Author's Name: ");
                    String authorName = scanner.nextLine();

                    System.out.print("Enter Author's Date of Birth (YYYY-MM-DD): ");
                    String authorDob = scanner.nextLine();

                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Enter Publisher: ");
                    String publisher = scanner.nextLine();

                    System.out.print("Enter Number of Copies: ");
                    int numCopies = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character after nextInt()

                    // Create Author object
                    // Check if the author already exists
                    Author author = manager.findAuthorByNameAndDob(authorName, authorDob);
                    if (author == null) {
                        author = new Author(authorName, authorDob);
                    }

                    LibraryItem newItem;
                    if (itemType.equals("B")) {
                        System.out.print("Enter Book Type (Printed/Electronic/Audio): ");
                        String bookType = scanner.nextLine().trim();
                        newItem = new Book(id, title, author, isbn, publisher, numCopies, bookType);
                    } else if (itemType.equals("P")) {
                        System.out.print("Enter Periodical Type (Printed/Electronic): ");
                        String periodicalType = scanner.nextLine().trim();
                        newItem = new Periodical(id, title, author, isbn, publisher, numCopies, periodicalType);
                    } else {
                        System.out.println("Invalid item type. Please enter 'B' for Book or 'P' for Periodical.");
                        break;
                    }

                    // Add item to library manager
                    manager.addItem(newItem);

                    System.out.println("Library item added successfully.");
                    break;

                case 2:
                    System.out.println("Editing an existing library item...");
                    System.out.print("Enter ID of the item you want to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character after nextInt()

                    System.out.print("Enter new Title: ");
                    String editTitle = scanner.nextLine();

                    System.out.print("Enter new Author's Name: ");
                    String editAuthorName = scanner.nextLine();

                    System.out.print("Enter new Author's Date of Birth (YYYY-MM-DD): ");
                    String editAuthorDob = scanner.nextLine();

                    System.out.print("Enter new ISBN: ");
                    String editIsbn = scanner.nextLine();

                    System.out.print("Enter new Publisher: ");
                    String editPublisher = scanner.nextLine();

                    System.out.print("Enter new Number of Copies: ");
                    int editNumCopies = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character after nextInt()

                    System.out.print("Enter new Type (Printed/Electronic/Audio): ");
                    String editType = scanner.nextLine();

                    // Create Author object
                    Author editAuthor = new Author(editAuthorName, editAuthorDob);

                    // Edit LibraryItem
                    LibraryItem existingItem = manager.getItemById(editId);
                    if (existingItem instanceof Book) {
                        manager.editItem(editId, editTitle, editAuthor, editIsbn, editPublisher, editNumCopies, editType);
                    } else if (existingItem instanceof Periodical) {
                        manager.editItem(editId, editTitle, editAuthor, editIsbn, editPublisher, editNumCopies, editType);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 3:
                    System.out.println("Deleting a library item...");
                    System.out.print("Enter ID of the item you want to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character after nextInt()

                    manager.removeItem(deleteId);
                    break;

                case 4:
                    System.out.println("Borrowing a library item...");
                    System.out.print("Enter the ID of the item you want to borrow: ");
                    int borrowId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character after nextInt()

                    LibraryItem itemToBorrow = manager.getItemById(borrowId);
                    if (itemToBorrow != null) {
                        System.out.print("Enter the patron's name: ");
                        String patronName = scanner.nextLine();
                        System.out.print("Enter the patron's address: ");
                        String patronAddress = scanner.nextLine();
                        System.out.print("Enter the patron's phone number: ");
                        String patronPhone = scanner.nextLine();
                        System.out.print("Enter the patron's membership type: ");
                        String patronMemType = scanner.nextLine();

                        Patron patron = new Patron(patronName, patronAddress, patronPhone, patronMemType);
                        patron.borrowItem(itemToBorrow);
                        System.out.println("Item borrowed successfully.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 5:
                    System.out.println("Returning a library item...");
                    System.out.print("Enter the ID of the item you want to return: ");
                    int returnId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character after nextInt()

                    LibraryItem itemToReturn = manager.getItemById(returnId);
                    if (itemToReturn != null) {
                        System.out.print("Enter the patron's name: ");
                        String patronName = scanner.nextLine();
                        System.out.print("Enter the patron's address: ");
                        String patronAddress = scanner.nextLine();
                        System.out.print("Enter the patron's phone number: ");
                        String patronPhone = scanner.nextLine();
                        System.out.print("Enter the patron's membership type: ");
                        String patronMemType = scanner.nextLine();

                        Patron patron = new Patron(patronName, patronAddress, patronPhone, patronMemType);
                        patron.returnItem(itemToReturn);
                        System.out.println("Item returned successfully.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 6:
                    System.out.println("Searching for item by its title...");
                    

                    System.out.print("Enter the title to search: ");
                    String searchTitle = scanner.nextLine();

                    
                    List<LibraryItem> foundItems = manager.searchItemsByTitle(searchTitle);
                    if (foundItems.isEmpty()) {
                        System.out.println("No items found with the title: " + searchTitle);
                    } else {
                        System.out.println("Found items:");
                        for (LibraryItem item : foundItems) {
                            System.out.println(item);
                        }
                    }
                    break;

                case 7:
                    System.out.println("Searching for item by its author...");
                    System.out.print("Enter the author to search: ");
                    String searchAuthor = scanner.nextLine();
                    List<LibraryItem> foundAuthor = manager.searchItemsByAuthor(searchAuthor);
                    if (foundAuthor.isEmpty()) {
                        System.out.println("No items found with the Author: " + searchAuthor);
                    } else {
                        System.out.println("Found items:");
                        for (LibraryItem item : foundAuthor) {
                            System.out.println(item);
                        }
                    }
                    break;

                case 8:
                System.out.println("Searching for Author...");
                    System.out.print("Enter the author's name: ");
                    String searchAuthorName = scanner.nextLine();

                    System.out.print("Enter the author's date of birth (YYYY-MM-DD): ");
                    String searchAuthorDob = scanner.nextLine();

                    Author authorFound = manager.findAuthorByNameAndDob(searchAuthorName, searchAuthorDob);
                    if (authorFound != null) {
                        System.out.println("Author found: " + authorFound);
                        System.out.println("Works authored by " + searchAuthorName + ":");
                        List<LibraryItem> itemsByAuthor = authorFound.getItemsWritten();
                        if (itemsByAuthor.isEmpty()) {
                            System.out.println("No works found for this author.");
                        } else {
                            for (LibraryItem item : itemsByAuthor) {
                                System.out.println(item);
                            }
                        }
                    } else {
                        System.out.println("Author not found.");
                    }
                    break;
                case 9:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
