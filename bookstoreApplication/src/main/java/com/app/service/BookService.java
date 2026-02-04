package com.app.service;

import com.app.dto.BookDto;
import com.app.entity.Book;
import com.app.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book addBook(BookDto dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        return repo.save(book);
    }

    public Book updateBook(Integer id, BookDto dto) {
        Book book = repo.findById(id);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        return repo.save(book);
    }

    public Book getBook(Integer id) {
        Book book = repo.findById(id);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        return book;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public void deleteBook(Integer id) {
        Book book = repo.findById(id);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        repo.deleteById(id);
    }
}
