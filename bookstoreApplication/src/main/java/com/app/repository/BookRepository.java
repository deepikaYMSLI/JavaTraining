package com.app.repository;

import com.app.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BookRepository {

    private final Map<Integer, Book> store = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger(1);

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(counter.getAndIncrement());
        }
        store.put(book.getId(), book);
        return book;
    }

    public Book findById(Integer id) {
        return store.get(id);
    }

    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        Object[] values = store.values().toArray();
        for (int i = 0; i < values.length; i++) {
            list.add((Book) values[i]);
        }
        return list;
    }

    public void deleteById(Integer id) {
        store.remove(id);
    }
}
