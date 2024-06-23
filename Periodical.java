public class Periodical extends LibraryItem {
    //instance variables
    private String type;


    //Constructor
    public Periodical (int id, String title, Author author, String ISBN, String publisher, int numCopies, String type) {
        super(id, title, author, ISBN, publisher, numCopies);
        this.type = type;
    }

    // Copy constructor
    public Periodical(Periodical other) {
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

    //toString
    @Override
    public String toString() {
        return "Periodical: " + type + super.toString();
    }
}
