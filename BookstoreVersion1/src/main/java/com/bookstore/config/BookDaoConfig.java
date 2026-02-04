package com.bookstore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoJdbcImpl;
import com.bookstore.dao.BookDaoJpaImpl;

@Configuration
public class BookDaoConfig {

    @Value("${books.dao.type}")
    private String daoType;

    @Bean
    public BookDao bookDao(BookDaoJdbcImpl jdbcDao, BookDaoJpaImpl jpaDao) {
        if ("jdbc".equalsIgnoreCase(daoType)) {
            return jdbcDao;
        } else {
            return jpaDao;
        }
    }
}
