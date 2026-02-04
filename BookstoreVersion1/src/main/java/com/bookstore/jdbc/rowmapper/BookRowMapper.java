package com.bookstore.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bookstore.entities.Books;

public class BookRowMapper implements RowMapper<Books> {

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
}
