package com.sprk.rest_api_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprk.rest_api_demo.entity.Book;
import com.sprk.rest_api_demo.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public List<Book> getListOfBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        Optional<Book> dbBook = bookRepository.findById(id);
        if (dbBook.isPresent()) {
            return dbBook.get();
        } else {
            return null;
        }

    }

    @Override
    public void deleteDbBook(Book dbBook) {
        bookRepository.delete(dbBook);
    }

    @Override
    @Transactional
    public Book update(Book newBook) {
        Book updatedBook = bookRepository.save(newBook);
        return updatedBook;
    }
}
