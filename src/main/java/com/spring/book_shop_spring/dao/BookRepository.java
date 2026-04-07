package com.spring.book_shop_spring.dao;

import com.spring.book_shop_spring.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
    Book save(Book book);
    List<Book> findAll();
}
