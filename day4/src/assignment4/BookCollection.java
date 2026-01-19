package assignment4;
//Ques2 assignment 4
import java.util.Arrays;
import java.util.Comparator;

public class BookCollection {

    private String ownerName;
    private Book[] books;

    public BookCollection(String ownerName, Book[] books) {
        this.ownerName = ownerName;
        this.books = books;
    }

    // Check if a book exists
    public boolean hasBook(Book b) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(b)) {
                return true;
            }
        }
        return false;
    }

    // Sort by title, if same then by author
    public void sort() {

        Arrays.sort(books, new Comparator<Book>() {

            @Override
            public int compare(Book b1, Book b2) {

                int titleCompare = b1.getTitle().compareTo(b2.getTitle());

                if (titleCompare != 0) {
                    return titleCompare;
                }

                return b1.getAuthor().compareTo(b2.getAuthor());
            }
        });
    }

    // Display collection
    @Override
    public String toString() {

        String result = "Owner: " + ownerName + "\nBooks:\n";

        for (int i = 0; i < books.length; i++) {
            result = result + books[i] + "\n";
        }

        return result;
    }
}
