package com.bookstore.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookstore.entities.Books;
import com.bookstore.exception.BookDataAccessException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoJdbcImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addBook(Books book) {
        try {
            String sql = "INSERT INTO books_jdbc(title, author, price, isbn, category) VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(),
                    book.getPrice(), book.getIsbn(), book.getCategory());
        } catch (Exception e) {
            throw new BookDataAccessException("Error adding book via JDBC", e);
        }
    }

    @Override
    public Books findById(int bookId) {
        try {
            String sql = "SELECT * FROM books_jdbc WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{bookId}, new RowMapper<Books>() {
                @Override
                public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new Books(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getDouble("price"),
                            rs.getString("isbn"),
                            rs.getString("category")
                    );
                }
            });
        } catch (Exception e) {
            throw new BookDataAccessException("Book not found via JDBC", e);
        }
    }

    // Optional: implement findAll, update, delete later
}
