package TheLibrary;

public class Periodical extends LibraryItem {
    private String type;


    public Periodical (int id, String title, Author author, String ISBN, String publisher, int numCopies, String type) {
        super(id, title, author, ISBN, publisher, numCopies);
        this.type = type;
    }

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

    @Override
    public String toString() {
        return "Periodical: " + type + super.toString();
    }
}
