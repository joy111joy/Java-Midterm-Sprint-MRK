public class LibraryItem {
    //instance variables
    private int id;
    private String title;
    private Author author;
    private boolean isBorrowed;
    private String ISBN;
    private String publisher;
    private int numCopies;

    //Constructor
    public LibraryItem(int id, String title, Author author, String ISBN, String publisher, int numCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numCopies = numCopies;
    }

    // Copy constructor
    public LibraryItem(LibraryItem other) {
        this.id = other.id;
        this.title = other.title;
        this.author = new Author(other.author); // Use Author copy constructor
        this.isBorrowed = other.isBorrowed;
        this.ISBN = other.ISBN;
        this.publisher = other.publisher;
        this.numCopies = other.numCopies;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    //toString
    @Override
    public String toString() {
        return "LibraryItem[ID=" + id + ", Title=" + title + ", Author=" + author.getName() + ", Borrowed=" + isBorrowed + ", ISBN=" + ISBN + ", Publisher=" + publisher + ", Number of Copies=" + numCopies + "]";
    }
}
