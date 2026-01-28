package com.dao;

import com.entity.Book;
import com.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BookDaoImpl implements BookDao {

    
    public void addBook(Book book) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(book);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    
    public Book getBookById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Book.class, id);
        } finally {
            em.close();
        }
    }

    
    public List<Book> getAllBooks() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("from Book", Book.class).getResultList();
        } finally {
            em.close();
        }
    }

    
    public void updateBook(Book book) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(book);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    
    public void deleteBook(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Book book = em.find(Book.class, id);
            if (book != null) {
                em.remove(book);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
