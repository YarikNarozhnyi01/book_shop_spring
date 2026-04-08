package bookshopspring.service;

import bookshopspring.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();

}
