package com.bookstore.dao;

import com.bookstore.entities.Books;

public interface BookDao {
    void addBook(Books book);
    Books findById(int bookId);
}
