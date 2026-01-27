package com.bookstore.controller;
//import com.bookstore.dao.*;
//import java.util.List;

import java.util.List;
import java.util.Scanner;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoJDBCimple;
import com.bookstore.dto.Book;
import com.bookstore.service.BookService;
public class BookStoreController {
	public static void main(String [] args) {
        BookService service = new BookService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = sc.next();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    Book book = new Book(0, isbn, title, author, price);
                    System.out.println("Added: " + service.addBook(book));
                    break;

                case 2:
                	
                    List <Book> books=service.getAllBooks();
                    if(books.isEmpty()) {
                    	System.out.print("No books found");
                    	
                    }
                    else {
                    	System.out.print("\n --- Book List---");
                    	for(Book b: books) {
                    		System.out.print(b);
                    	}
                    }
                           
                    break;

                case 3:
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    service.deleteBook(id);
                    System.out.println("Book deleted");
                    break;

                case 4:
                    System.exit(0);
            }
        }
        
    }
	
}

	


