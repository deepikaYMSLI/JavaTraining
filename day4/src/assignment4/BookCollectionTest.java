package assignment4;

public class BookCollectionTest {
//Ques2 assignment 4
    public static void main(String[] args) {

        Book[] books = {
            new Book("Java Basics", "Raj", 450),
            new Book("Spring Boot", "Sharma", 650),
            new Book("Java in Depth", "Mehta", 550)
        };

        BookCollection collection =
                new BookCollection("Rajeev Gupta", books);

        Book searchBook =
                new Book("Java in Depth", "Mehta", 0);

        if (collection.hasBook(searchBook)) {
            System.out.println("Book exists in collection");
        } else {
            System.out.println("Book not found");
        }

        collection.sort();

        System.out.println();
        System.out.println(collection);
    }
}
