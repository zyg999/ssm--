package org.zyg.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zyg.dao.BookMapper;
import org.zyg.domain.Book;
import org.zyg.service.BookService;

import javax.annotation.Resource;
import java.util.List;

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
    @Resource(name = "bookMapper")
    private BookMapper bookMapper;

    @Override
    public int saveBook(Book book) {
        return bookMapper.saveBook(book);
    }

    @Override
    public Book findById(Integer id) {
        return bookMapper.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    @Override
    public Integer updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public Integer  deleteBook(Integer id) {
        return bookMapper.deleteBook(id);

    }

    @Override
    public Book findByName(String name) {
        return bookMapper.findByName(name);
    }
}
