package com.sprk.rest_api_demo.service;

import java.util.List;

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
    // @Transactional
    public Book saveBook(Book book) {

        return bookRepository.saveBook(book);
    }

    @Override
    public List<Book> getListOfBooks() {
        return bookRepository.findListOfBooks();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findBookById(id);
    }

    @Override
    @Transactional
    public void deleteDbBook(Book dbBook) {
        bookRepository.delete(dbBook);
    }

    @Override
    @Transactional
    public Book update(Book newBook) {
        Book updatedBook = bookRepository.updateBook(newBook);
        return updatedBook;
    }
}
