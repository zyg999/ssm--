package org.zyg.service;

import org.zyg.domain.Book;

import java.util.List;

public interface BookService {
    int saveBook(Book book);
    Book findById(Integer id);
    List<Book> findAll();
    Integer updateBook(Book book);
    Integer deleteBook(Integer id);
    Book findByName(String name);
}
