package assignment2;
import java.util.Scanner;

public class BookStore {

    private static final int MAX_BOOKS = 10;
    private final Book[] inventory;
    private int bookCount;

    public BookStore() {
        inventory = new Book[MAX_BOOKS];
        bookCount = 0;
    }

    public void sell(String title, int count) {
        Book book = findByTitle(title);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.decreaseCopies(count)) {
            System.out.println("Not enough stock.");
        } else {
            System.out.println("Sold " + count + " copies of \"" + title + "\"");
        }
    }

    public void order(String isbn, int count) {
        Book book = findByIsbn(isbn);

        if (book != null) {
            book.increaseCopies(count);
            System.out.println("Stock updated for ISBN: " + isbn);
            return;
        }

        if (bookCount >= MAX_BOOKS) {
            System.out.println("Inventory full. Cannot add new book.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        inventory[bookCount++] = new Book(title, author, isbn, count);
        System.out.println("New book added to inventory.");
    }

    public void display() {
        System.out.println("\n--- Bookstore Inventory ---");
        if (bookCount == 0) {
            System.out.println("No books available.");
            return;
        }

        for (int i = 0; i < bookCount; i++) {
            inventory[i].display();
        }
    }

    public void addBook(Book book) {
        if (bookCount < MAX_BOOKS) {
            inventory[bookCount++] = book;
        }
    }

    private Book findByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (inventory[i].getBookTitle().equalsIgnoreCase(title)) {
                return inventory[i];
            }
        }
        return null;
    }

    private Book findByIsbn(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (inventory[i].getIsbn().equals(isbn)) {
                return inventory[i];
            }
        }
        return null;
    }
}
