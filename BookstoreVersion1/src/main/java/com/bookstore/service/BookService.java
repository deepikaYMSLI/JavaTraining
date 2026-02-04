package com.bookstore.service;

import com.bookstore.entities.Books;

public interface BookService{
	void addBook(Books books);
	Books getById(int id);
}
