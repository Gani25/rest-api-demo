package com.sprk.rest_api_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprk.rest_api_demo.entity.Book;
import com.sprk.rest_api_demo.service.BookService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // This API will be used to store book in db
    @PostMapping("/book")
    public Book insertBook(@RequestBody Book bookObj) {

        Book savedBook = bookService.saveBook(bookObj);

        return savedBook;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getListOfBooks();
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable int bookId) {

        Book dbBook = bookService.findById(bookId);

        if (dbBook != null) {
            return ResponseEntity.ok(dbBook);
        } else {
            String message = "Book with bookId = " + bookId + " not found!!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable int bookId) {
        Book dbBook = bookService.findById(bookId);
        if (dbBook != null) {
            bookService.deleteDbBook(dbBook);
            // return ResponseEntity.ok("Book Deleted Successfully");
            return ResponseEntity.ok(dbBook);
        } else {
            String message = "Book with bookId = " + bookId + " not found!!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @PutMapping("/book/{bookId}")
    public ResponseEntity<?> updateBook(@PathVariable int bookId, @RequestBody Book newBook) {
        Book dbBook = bookService.findById(bookId);
        if (dbBook != null) {

            newBook.setBookId(dbBook.getBookId());

            Book updatedBook = bookService.update(newBook);

            return ResponseEntity.ok(updatedBook);
        } else {
            String message = "Book with bookId = " + bookId + " not found!!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

}
