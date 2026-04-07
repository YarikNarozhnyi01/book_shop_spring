package com.spring.book_shop_spring.dao;

import com.spring.book_shop_spring.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements  BookRepository {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public BookRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }



    @Override
    public Book save(Book book) {
        EntityManager manager = null;
        EntityTransaction transaction = null;
        try {
            manager = entityManagerFactory.createEntityManager();
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(book);
            transaction.commit();
        } catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can not save book",e);
        }
        finally {
            if (manager != null) {
                manager.close();
            }
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        try (EntityManager manager = entityManagerFactory.createEntityManager()) {
            return manager.createQuery("select b from Book b", Book.class).getResultList();
        }
    }
}
