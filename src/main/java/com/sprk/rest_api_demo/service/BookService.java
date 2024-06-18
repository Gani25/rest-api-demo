package com.sprk.rest_api_demo.service;

import java.util.List;

import com.sprk.rest_api_demo.entity.Book;

public interface BookService {

    Book saveBook(Book book);

    List<Book> getListOfBooks();

    Book findById(int id);

    void deleteDbBook(Book dbBook);

    Book update(Book newBook);
}
