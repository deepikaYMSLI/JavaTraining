package assignment2;
public class Book {

    private final String bookTitle;
    private final String author;
    private final String isbn;
    private int numOfCopies;

    public Book(String bookTitle, String author, String isbn, int numOfCopies) {
        if (numOfCopies < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.bookTitle = bookTitle;
        this.author = author;
        this.isbn = isbn;
        this.numOfCopies = numOfCopies;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumOfCopies() {
        return numOfCopies;
    }

    public void increaseCopies(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count must be positive.");
        }
        numOfCopies += count;
    }

    public boolean decreaseCopies(int count) {
        if (count <= numOfCopies) {
            numOfCopies -= count;
            return true;
        }
        return false;
    }

    public void display() {
        System.out.println(bookTitle + " – " + author + " – " + isbn + " – Quantity: " + numOfCopies);
    }
}
