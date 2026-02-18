package com.traineemgmt.dao;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Primary;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.traineemgmt.entities.Trainee;
import com.traineemgmt.exception.TraineeDataAccessException;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@ConditionalOnProperty(
	    name = "trainee.dao.type",
	    havingValue = "jdbc"
	)
public class TraineeJdbcDao implements TraineeDao {

    private final JdbcTemplate jdbcTemplate;

    // Constructor-based dependency injection
    public TraineeJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addTrainee(Trainee trainee) {
        try {
            String sql = "INSERT INTO trainee_table(name, age, marks) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, trainee.getName(), trainee.getAge(), trainee.getMarks());
        } catch (Exception e) {
            throw new TraineeDataAccessException("Error adding trainee via JDBC", e);
        }
    }

    @SuppressWarnings({ "deprecation" })
	@Override
    public Trainee findById(int traineeId) {
    	try {
    	    String sql = "SELECT * FROM trainee_table WHERE id = ?";
    	    return jdbcTemplate.queryForObject(
    	        sql,
    	        new Object[]{traineeId},
    	        new RowMapper<Trainee>() {
    	            @Override
    	            public Trainee mapRow(ResultSet rs, int rowNum) throws SQLException {
    	                return new Trainee(
    	                    rs.getInt("id"),
    	                    rs.getInt("age"),
    	                    rs.getInt("marks"),
    	                    rs.getString("name")
    	                );
    	            }
    	        }
    	    );
    	} catch (Exception e) {
    	    throw new TraineeDataAccessException("Trainee not found via JDBC", e);
    	}

    }
}





//public class BookJdbcDao implements BookDao{
//	
//	private final JdbcTemplate jdbcTemplate;
//	// Constructor-based dependency injection
//    public BookJdbcDao(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//    
//    
//    @Override
//    public void addBook(Books books) {
//        try {
//            String sql = "INSERT INTO Book_table(bookName, authorName, price) VALUES (?, ?, ?)";
//            jdbcTemplate.update(sql, books.getBookName(), books.getAuthorName(), books.getPrice());
//        } catch (Exception e) {
//            throw new BookDataAccessException("Error adding Book via JDBC", e);
//        }
//    }
//	
//	
//}
