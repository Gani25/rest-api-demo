package com.sprk.rest_api_demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprk.rest_api_demo.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    // Dependency Injection

    private EntityManager entityManager;

    // Constructor injection
    @Autowired
    public BookRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Book saveBook(Book book) {
        Book savedBook = entityManager.merge(book);
        return savedBook;
    }

    @Override
    public List<Book> findListOfBooks() {
        TypedQuery<Book> query = entityManager.createQuery("from Book", Book.class);

        List<Book> books = query.getResultList();

        return books;
    }

    @Override
    public Book findBookById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    @Transactional
    public void delete(Book dbBook) {
        entityManager.remove(dbBook);

    }

    @Override
    public Book updateBook(Book newBook) {
        Book updatedBook = entityManager.merge(newBook);
        return updatedBook;
    }

}
