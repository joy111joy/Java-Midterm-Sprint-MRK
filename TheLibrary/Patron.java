package TheLibrary;
import java.util.ArrayList;

public class Patron {
    private String name;
    private String address;
    private String phoneNum;
    private String memType;
    private ArrayList<LibraryItem> borrowList;

    public Patron(String name, String address, String phoneNum, String memType) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.memType = memType;
        borrowList = new ArrayList<>();
    }

    // Copy constructor
    public Patron(Patron other) {
        this.name = other.name;
        this.address = other.address;
        this.phoneNum = other.phoneNum;
        this.memType = other.memType;
        this.borrowList = new ArrayList<>(other.borrowList);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getMemType() {
        return memType;
    }

    public void setMemType(String memType) {
        this.memType = memType;
    }

    public ArrayList<LibraryItem> getBorrowList() {
        return borrowList;
    }

    public void borrowItem(LibraryItem libraryItem) {
        if (libraryItem.getNumCopies() > 0) {
            borrowList.add(libraryItem);
            libraryItem.setNumCopies(libraryItem.getNumCopies() - 1);
        } else {
            System.out.println("No copies available for borrowing.");
        }
    }
    
    public void returnItem(LibraryItem libraryItem) {
        if (borrowList.contains(libraryItem)) {
            borrowList.remove(libraryItem);
            libraryItem.setNumCopies(libraryItem.getNumCopies() + 1);
        } else {
            System.out.println("Item not found in borrow list.");
        }
    }
    

    @Override
    public String toString() {
        return "Member[ Name=" + name + "]";
    }
}