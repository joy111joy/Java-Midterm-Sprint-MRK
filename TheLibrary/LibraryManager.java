package TheLibrary;

import java.util.ArrayList;

public class LibraryManager {
    private ArrayList<LibraryItem> itemsList;
    private ArrayList<Patron> patronList;
    private ArrayList<Author> authorsList;

    public LibraryManager() {
        itemsList = new ArrayList<>();
        patronList = new ArrayList<>();
        authorsList = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        if (item instanceof Book) {
            itemsList.add(new Book((Book) item)); // Use Book copy constructor
        } else if (item instanceof Periodical) {
            itemsList.add(new Periodical((Periodical) item)); // Use Periodical copy constructor
        } else {
            itemsList.add(new LibraryItem(item)); // Default to LibraryItem
        }

        // Add author if not already present
        Author author = item.getAuthor();
        if (!authorsList.contains(author)) {
            authorsList.add(author);
        }

        item.getAuthor().addItem(item); // Add item to author's list
    }

    public void editItem(int id, String title, Author author, String ISBN, String publisher, int numCopies, String type) {
        for (int i = 0; i < itemsList.size(); i++) {
            LibraryItem item = itemsList.get(i);
            if (item.getId() == id) {
                if (item instanceof Book) {
                    Book book = (Book) item;
                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setISBN(ISBN);
                    book.setPublisher(publisher);
                    book.setNumCopies(numCopies);
                    book.setType(type); // Book specific type
                } else if (item instanceof Periodical) {
                    Periodical periodical = (Periodical) item;
                    periodical.setTitle(title);
                    periodical.setAuthor(author);
                    periodical.setISBN(ISBN);
                    periodical.setPublisher(publisher);
                    periodical.setNumCopies(numCopies);
                    periodical.setType(type); // Periodical specific type
                }
                itemsList.set(i, item); // Replace the item in the list
                return;
            }
        }
        System.out.println("Item not found");
    }

    public LibraryItem getItemById(int id) {
        for (LibraryItem item : itemsList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(int id) {
        itemsList.removeIf(item -> item.getId() == id);
    }

    public Author findAuthorByNameAndDob(String name, String dob) {
        for (Author author : authorsList) {
            if (author.getName().equalsIgnoreCase(name) && author.getDob().equals(dob)) {
                return author;
            }
        }
        return null;
    }

    public ArrayList<LibraryItem> getItemsByAuthor(Author author) {
        return new ArrayList<>(author.getItemsWritten());
    }

    public void addAuthor(Author author) {
        authorsList.add(new Author(author)); // Using the copy constructor
    }

    public void editAuthor(String name, String dob) {
        for (Author author : authorsList) {
            if (author.getName().equals(name)) {
                author.setName(name);
                author.setDob(dob);
            }
        }
    }

    public void removeAuthor(String name) {
        authorsList.removeIf(author -> author.getName().equals(name));
    }

    public void addPatron(Patron patron) {
        patronList.add(new Patron(patron)); // Using the copy constructor
    }

    public void editPatron(String patronName, Patron updatedPatron) {
        for (int i = 0; i < patronList.size(); i++) {
            if (patronList.get(i).getName().equals(patronName)) {
                patronList.set(i, updatedPatron);
                return;
            }
        }
    }

    public void deletePatron(String patronName) {
        patronList.removeIf(patron -> patron.getName().equals(patronName));
    }

    public ArrayList<LibraryItem> getItemsList() {
        return itemsList;
    }

    public ArrayList<Patron> getPatronList() {
        return patronList;
    }

    public ArrayList<Author> getAuthorsList() {
        return authorsList;
    }

    public ArrayList<LibraryItem> searchItemsByTitle(String title) {
        ArrayList<LibraryItem> searchResults = new ArrayList<>();
        for (LibraryItem item : itemsList) {
            if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }

    public ArrayList<LibraryItem> searchItemsByAuthor(String authorName) {
        ArrayList<LibraryItem> searchResults = new ArrayList<>();
        for (LibraryItem item : itemsList) {
            if (item.getAuthor().getName().toLowerCase().contains(authorName.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }

    public ArrayList<LibraryItem> searchItemsByPublisher(String publisher) {
        ArrayList<LibraryItem> searchResults = new ArrayList<>();
        for (LibraryItem item : itemsList) {
            if (item.getPublisher().toLowerCase().contains(publisher.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }

    public ArrayList<LibraryItem> searchItemsByISBN(String ISBN) {
        ArrayList<LibraryItem> searchResults = new ArrayList<>();
        for (LibraryItem item : itemsList) {
            if (item.getISBN().equals(ISBN)) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }
}
