package com.bookstore.dao;
import java.util.List;
import com.bookstore.dto.Book;
import com.bookstore.exceptions.DaoException;
import com.bookstore.dto.Book;
public interface BookDao {
	public List<Book> getAllBooks()throws DaoException;
	public Book addBook(Book book)throws DaoException;
	public void updateBook(int id, Book book)throws DaoException;
	public void deleteBook(int id)throws DaoException;
	public Book getBookId(int id)throws DaoException;
	

}
