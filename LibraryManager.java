import java.util.ArrayList;

public class LibraryManager {
    //Instance variables
    private ArrayList<LibraryItem> itemsList;
    private ArrayList<Patron> patronList;
    private ArrayList<Author> authorsList;

    //Constructor
    public LibraryManager() {
        itemsList = new ArrayList<>();
        patronList = new ArrayList<>();
        authorsList = new ArrayList<>();
    }

    //Methods
    // Add a new item to the library
    public void addItem(LibraryItem item) {
        //Checks if the item entered is a Book, Periodical, or just a LibraryItem
        if (item instanceof Book) {
            itemsList.add(new Book((Book) item)); // Using Book copy constructor
        } else if (item instanceof Periodical) {
            itemsList.add(new Periodical((Periodical) item)); // Using Periodical copy constructor
        } else {
            itemsList.add(new LibraryItem(item)); // Default to LibraryItem
        }

        // Add a new author if not found in system
        Author author = item.getAuthor();
        if (!authorsList.contains(author)) {
            authorsList.add(author);
        }

        item.getAuthor().addItem(item); // Add item to author's list of items written
    }

    // Edit an existing item in the library
    public void editItem(int id, String title, Author author, String ISBN, String publisher, int numCopies, String type) {
        //loop to find item in list
        for (int i = 0; i < itemsList.size(); i++) {
            LibraryItem item = itemsList.get(i);
            //if item is found by its id, update the item based on if its a Book or Periodical
            if (item.getId() == id) {
                if (item instanceof Book) {
                    Book book = (Book) item;
                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setISBN(ISBN);
                    book.setPublisher(publisher);
                    book.setNumCopies(numCopies);
                    book.setType(type);
                } else if (item instanceof Periodical) {
                    Periodical periodical = (Periodical) item;
                    periodical.setTitle(title);
                    periodical.setAuthor(author);
                    periodical.setISBN(ISBN);
                    periodical.setPublisher(publisher);
                    periodical.setNumCopies(numCopies);
                    periodical.setType(type);
                }
                itemsList.set(i, item);
                return;
            }
        }
        //if item is not found in the list
        System.out.println("Item not found");
    }

    //getter for item by id
    public LibraryItem getItemById(int id) {
        //loop to find item in list
        for (LibraryItem item : itemsList) {
            if (item.getId() == id) {
                return item;
            }
        }
        //if item is not found in the list returns null to handle erros in the menu class
        return null;
    }

    // Remove an item from the library
    public void removeItem(int id) {
        itemsList.removeIf(item -> item.getId() == id);
    }

    // method to search for an author
    public Author findAuthorByNameAndDob(String name, String dob) {
        for (Author author : authorsList) {
            if (author.getName().equalsIgnoreCase(name) && author.getDob().equals(dob)) {
                return author;
            }
        }
        return null;
    }

    //get the lsit of items by author
    public ArrayList<LibraryItem> getItemsByAuthor(Author author) {
        return new ArrayList<>(author.getItemsWritten());
    }

    //add an author
    public void addAuthor(Author author) {
        authorsList.add(new Author(author)); // Using the copy constructor
    }

    //edit an author
    public void editAuthor(String name, String dob) {
        for (Author author : authorsList) {
            if (author.getName().equals(name)) {
                author.setName(name);
                author.setDob(dob);
            }
        }
    }

    //remove an author
    public void removeAuthor(String name) {
        authorsList.removeIf(author -> author.getName().equals(name));
    }

    //add a patron
    public void addPatron(Patron patron) {
        patronList.add(new Patron(patron)); // Using the copy constructor
    }

    //edit a patron
    public void editPatron(String patronName, Patron updatedPatron) {
        for (int i = 0; i < patronList.size(); i++) {
            if (patronList.get(i).getName().equals(patronName)) {
                patronList.set(i, updatedPatron);
                return;
            }
        }
    }

    //remove a patron
    public void deletePatron(String patronName) {
        patronList.removeIf(patron -> patron.getName().equals(patronName));
    }

    //getters
    public ArrayList<LibraryItem> getItemsList() {
        return itemsList;
    }

    public ArrayList<Patron> getPatronList() {
        return patronList;
    }

    public ArrayList<Author> getAuthorsList() {
        return authorsList;
    }

    //Search methods
    //Search for items by title
    public ArrayList<LibraryItem> searchItemsByTitle(String title) {
        ArrayList<LibraryItem> searchResults = new ArrayList<>();
        for (LibraryItem item : itemsList) {
            if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }

    //Search for items by author
    public ArrayList<LibraryItem> searchItemsByAuthor(String authorName) {
        ArrayList<LibraryItem> searchResults = new ArrayList<>();
        for (LibraryItem item : itemsList) {
            if (item.getAuthor().getName().toLowerCase().contains(authorName.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }
        //Search for items by ISBN
        public ArrayList<LibraryItem> searchItemsByISBN(String ISBN) {
            ArrayList<LibraryItem> searchResults = new ArrayList<>();
            for (LibraryItem item : itemsList) {
                if (item.getISBN().toLowerCase().contains(ISBN.toLowerCase())) {
                    searchResults.add(item);
                }
            }
            return searchResults;
        }
}

