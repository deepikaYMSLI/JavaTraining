package com.presentation;

import com.entity.Book;
import com.service.BookService;
import com.service.BookServiceImpl;

import java.util.List;
import java.util.Scanner;

public class BookApp {

    public static void main(String[] args) {

        BookService service = new BookServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. View Book By ID");
            System.out.println("3. View All Books");
            System.out.println("4. Update Book Price");
            System.out.println("5. Delete Book");
            System.out.println("0. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.next();

                    System.out.print("Title: ");
                    sc.nextLine();
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    service.addBook(new Book(isbn, title, author, price));
                    System.out.println("Book Added Successfully");
                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    Book book = service.getBookById(sc.nextInt());
                    if (book != null) {
                        System.out.println(book.getTitle() + " | " + book.getAuthor());
                    } else {
                        System.out.println("Book Not Found");
                    }
                    break;

                case 3:
                    List<Book> books = service.getAllBooks();
                    for (Book b : books) {
                        System.out.println(b.getId() + " " + b.getTitle() + " " + b.getPrice());
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    Book b = service.getBookById(id);
                    if (b != null) {
                        System.out.print("Enter New Price: ");
                        b.setPrice(sc.nextDouble());
                        service.updateBook(b);
                        System.out.println("Book Updated");
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    service.deleteBook(sc.nextInt());
                    System.out.println("Book Deleted");
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }
}
