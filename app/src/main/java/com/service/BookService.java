package com.service;



import com.model.Book;




import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BookService {

    // Explicit generic types (NO diamond operator)
    private Map<Integer, Book> bookStore = new HashMap<Integer, Book>();

    public void addBook(Book book) {

        if (book.getTitle() == null || book.getTitle().length() == 0) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        if (book.getPrice() <= 0) {
            throw new IllegalArgumentException("Invalid price");
        }

        bookStore.put(book.getId(), book);
    }

    public Book getBookById(int id) {

        Book book = bookStore.get(id);

        if (book == null) {
            throw new NoSuchElementException("Book not found");
        }

        return book;
    }

    public void updateBook(int id, Book updatedBook) {

        if (!bookStore.containsKey(id)) {
            throw new NoSuchElementException("Book not found");
        }

        if (updatedBook.getTitle() == null || updatedBook.getTitle().length() == 0) {
            throw new IllegalArgumentException("Invalid title");
        }

        if (updatedBook.getPrice() <= 0) {
            throw new IllegalArgumentException("Invalid price");
        }

        bookStore.put(id, updatedBook);
    }

    public void deleteBook(int id) {

        if (!bookStore.containsKey(id)) {
            throw new NoSuchElementException("Book not found");
        }

        bookStore.remove(id);
    }

    public List<Book> getAllBooks() {

        // Explicit generic type
        return new ArrayList<Book>(bookStore.values());
    }

    public int count() {
        return bookStore.size();
    }

    // Used by tests
    public void clear() {
        bookStore.clear();
    }
}
