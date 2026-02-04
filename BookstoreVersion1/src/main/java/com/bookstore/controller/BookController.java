package com.bookstore.controller;

import org.springframework.web.bind.annotation.*;

import com.bookstore.entities.Books;
import com.bookstore.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Books addBook(@RequestBody Books books) {
        bookService.addBook(books);
        return books;
    }

    @GetMapping("/{id}")
    public Books getBook(@PathVariable int id) {
        return bookService.getById(id);
    }
}
