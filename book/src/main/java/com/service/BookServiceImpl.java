package com.service;

import com.dao.BookDao;
import com.dao.BookDaoImpl;
import com.entity.Book;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    
    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }
}
