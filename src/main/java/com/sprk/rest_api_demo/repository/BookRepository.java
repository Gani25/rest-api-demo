package com.sprk.rest_api_demo.repository;

import java.util.List;

import com.sprk.rest_api_demo.entity.Book;

public interface BookRepository {

    Book saveBook(Book book);

    List<Book> findListOfBooks();

    Book findBookById(int id);

    void delete(Book dbBook);

    Book updateBook(Book newBook);
}
