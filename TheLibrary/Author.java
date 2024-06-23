package TheLibrary;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String dob;
    private List<LibraryItem> itemsWritten;

    public Author(String name, String dob) {
        this.name = name;
        this.dob = dob;
        this.itemsWritten = new ArrayList<>();
    }

    public Author(Author other) {
        this.name = other.name;
        this.dob = other.dob;
        this.itemsWritten = new ArrayList<>(other.itemsWritten);
    }
    public void addItem(LibraryItem item) {
        itemsWritten.add(item);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public List<LibraryItem> getItemsWritten() {
        return itemsWritten;
    }

    public void setItemsWritten(List<LibraryItem> itemsWritten) {
        this.itemsWritten = itemsWritten;
    }

    @Override
    public String toString() {
        return "Author[Name=" + name + ", DOB=" + dob + "]";
    }
}
