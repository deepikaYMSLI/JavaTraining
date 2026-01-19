package assignment2;
public class BookStoreApp {

    public static void main(String[] args) {

        BookStore store = new BookStore();

        // Add sample books
        store.addBook(new Book("Clean Code", "Robert C. Martin", "9780132350884", 5));
        store.addBook(new Book("Effective Java", "Joshua Bloch", "9780134685991", 3));

        store.display();

        // Order existing book
        store.order("9780132350884", 2);
        store.display();

        // Sell books
        store.sell("Clean Code", 4);
        store.display();

        // Attempt to sell more than available
        store.sell("Effective Java", 10);

        // Order a new book
        store.order("9780201633610", 4);
        store.display();
    }
}
