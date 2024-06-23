package TheLibrary;

public class Book extends LibraryItem {
    private String type; // Printed, Electronic, or Audio

    public Book(int id, String title, Author author, String ISBN, String publisher, int numCopies, String type) {
        super(id, title, author, ISBN, publisher, numCopies);
        this.type = type;
        
    }
    // Copy constructor
    public Book(Book other) {
        super(other);
        this.type = other.type;
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book: " + type + " " + super.toString();
    }
}
