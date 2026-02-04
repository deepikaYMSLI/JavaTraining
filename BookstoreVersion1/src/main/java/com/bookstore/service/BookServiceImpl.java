package com.bookstore.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.dao.BookDao;
import com.bookstore.entities.Books;
import com.bookstore.exception.BookDataAccessException;
import com.bookstore.exception.ResourceNotFoundException;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Transactional
    @Override
    public void addBook(Books books) {
        bookDao.addBook(books);
    }

    @Override
    public Books getById(int id) {
        try {
            return bookDao.findById(id);
        } catch (BookDataAccessException e) {
            throw new ResourceNotFoundException("Book not found with id " + id);
        }
    }
}
