package com.bookstore.service;

import java.util.List;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoJDBCimple;
import com.bookstore.dto.Book;
import com.bookstore.exceptions.DaoException;

public class BookService {

    private BookDao bookDao = new BookDaoJDBCimple();

    public Book addBook(Book book) {
        if (book.getPrice() <= 0)
            throw new IllegalArgumentException("Price must be greater than zero");

        if (book.getTitle() == null || book.getTitle().isEmpty())
            throw new IllegalArgumentException("Title cannot be empty");

        try {
            return bookDao.addBook(book);
        } catch (DaoException e) {
            throw new RuntimeException("Unable to add book right now");
        }
    }

    public List<Book> getAllBooks() {
        try {
            return bookDao.getAllBooks();
        } catch (DaoException e) {
            throw new RuntimeException("Unable to fetch books");
        }
    }

    public void deleteBook(int id) {
        try {
            bookDao.deleteBook(id);
        } catch (DaoException e) {
            throw new RuntimeException("Unable to delete book");
        }
    }
}

