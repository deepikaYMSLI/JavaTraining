package com.bookstore.dao;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import com.bookstore.dto.Book;
import com.bookstore.exceptions.DaoException;
import com.bookstore.util.ConnectionFactory;

public class BookDaoJDBCimple implements BookDao {
	private Connection connection;
	
	public BookDaoJDBCimple() {
		try {
			connection = ConnectionFactory.getConnection();
		} catch(SQLException e) {
			throw new RuntimeException("database connection failed", e);
		}
	}
	
	public List<Book> getAllBooks() throws DaoException {
		List<Book> books= new ArrayList<Book>();
		String sql = "Select * FROM books";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				books.add(new Book(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getDouble(5)));
			}
			
		} catch(SQLException e) {
			throw new DaoException("Failed to fetch books", e);
		}
		return books;
	}
	public Book addBook(Book book) {
		try {
			PreparedStatement psmt=connection
					.prepareStatement("insert into books(isbn,title,author, price) values(?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, book.getIsbn());
			psmt.setString(2, book.getTitle());
			psmt.setString(3, book.getAuthor());
			psmt.setDouble(4, book.getPrice());
			
			psmt.executeUpdate();
			
			ResultSet rs=psmt.getGeneratedKeys();
			
			if(rs.next()) {
				book.setId(rs.getInt(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return book;
	
	}

	public void updateBook(int id, Book book) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	public void deleteBook(int id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	public Book getBookId(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
