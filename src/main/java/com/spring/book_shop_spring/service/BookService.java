package com.spring.book_shop_spring.service;

import com.spring.book_shop_spring.model.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BookService {
    Book save(Book book);
    List<Book> findAll();

}
