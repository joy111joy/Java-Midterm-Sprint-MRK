public class TestMyLibrary {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();

        // Adding Authors
        Author author1 = new Author("J.K. Rowling", "1965-07-31");
        Author author2 = new Author("George Orwell", "1903-06-25");
        Author author3 = new Author("J.R.R. Tolkien", "1892-01-03");
        Author author4 = new Author("Various", "Various");


        // Adding Authors to the library
        libraryManager.addAuthor(author1);
        libraryManager.addAuthor(author2);
        libraryManager.addAuthor(author3);
        libraryManager.addAuthor(author4);

        // Adding Books
        Book book1 = new Book(1, "Harry Potter and the Philosopher's Stone", author1, "9780747532699", "Bloomsbury", 10, "Printed");
        Book book2 = new Book(2, "1984", author2, "9780451524935", "Secker & Warburg", 5, "Printed");
        Book book3 = new Book(3, "The Hobbit", author3, "9780261102217", "George Allen & Unwin", 7, "Printed");
        Book book4 = new Book(4, "Harry Potter and the Chamber of Secrets", author1, "9780747538493", "Bloomsbury", 8, "Printed");
        Book book5 = new Book(5, "Animal Farm", author2, "9780451526342", "Secker & Warburg", 6, "Printed");

        // Adding Books to the library
        libraryManager.addItem(book1);
        libraryManager.addItem(book2);
        libraryManager.addItem(book3);
        libraryManager.addItem(book4);
        libraryManager.addItem(book5);

        // Adding Periodicals
        Periodical periodical1 = new Periodical(6, "Nature", author1, "0028-0836", "Nature Publishing Group", 12, "Printed");
        Periodical periodical2 = new Periodical(7, "The Economist", author3, "0013-0613", "The Economist Group", 20, "Printed");
        Periodical periodical3 = new Periodical(8, "Time", author4, "0040-781X", "Time Inc.", 15, "Printed");
        Periodical periodical4 = new Periodical(9, "National Geographic", author3, "0027-9358", "National Geographic Society", 10, "Printed");
        Periodical periodical5 = new Periodical(10, "Scientific American", author2, "0036-8733", "Springer Nature", 8, "Printed");

        // Adding Periodicals to the library
        libraryManager.addItem(periodical1);
        libraryManager.addItem(periodical2);
        libraryManager.addItem(periodical3);
        libraryManager.addItem(periodical4);
        libraryManager.addItem(periodical5);

        // Adding a Patron
        Patron patron1 = new Patron("John Doe", "123 Elm St", "555-1234", "Student");
        libraryManager.addPatron(patron1);

        // Patron borrows and returns a book
        patron1.borrowItem(book1);
        patron1.returnItem(book1);

        // Searching items

        System.out.println();
        System.out.println("Search by Title: " + libraryManager.searchItemsByTitle("Harry Potter"));
        System.out.println();
        System.out.println();

        System.out.println("Search by Author: " + libraryManager.searchItemsByAuthor("Rowling"));
        System.out.println();
        System.out.println();


        System.out.println("Search by Title (Periodical): " + libraryManager.searchItemsByTitle("Nature"));
    }
}
