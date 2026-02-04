package com.bookstore.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.bookstore.entities.Books;
import com.bookstore.exception.BookDataAccessException;

@Repository
public class BookDaoJpaImpl implements BookDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addBook(Books book) {
        try {
            em.persist(book);
        } catch (Exception e) {
            throw new BookDataAccessException("Error adding book via JPA", e);
        }
    }

    @Override
    public Books findById(int bookId) {
        try {
            Books book = em.find(Books.class, bookId);
            if (book == null) {
                throw new BookDataAccessException("Book not found via JPA", null);
            }
            return book;
        } catch (Exception e) {
            throw new BookDataAccessException("Error fetching book via JPA", e);
        }
    }
}
