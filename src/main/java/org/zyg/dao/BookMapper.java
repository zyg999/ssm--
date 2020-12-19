package org.zyg.dao;

import org.apache.ibatis.annotations.Mapper;
import org.zyg.domain.Book;

import java.util.List;

public interface BookMapper {
    int saveBook(Book book);
    Book findById(Integer id);
    List<Book> findAll();
    Integer updateBook(Book book);
    Integer  deleteBook(Integer id);
    Book findByName(String name);

}
