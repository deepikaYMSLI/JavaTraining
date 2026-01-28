package com.dao;

import com.entity.Book;
import java.util.List;

public interface BookDao {

    void addBook(Book book);
    Book getBookById(int id);
    List<Book> getAllBooks();
    void updateBook(Book book);
    void deleteBook(int id);
}
