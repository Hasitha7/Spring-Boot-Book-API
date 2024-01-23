package com.example.bookapi.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.bookapi.model.Books;
import com.example.bookapi.service.BookService;

import jakarta.validation.Valid;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/book")
    private List<Books> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{bookid}")
    private Books getBooks(@Valid @PathVariable("bookid") int bookid) {
        return bookService.getBooksById(bookid);
    }


    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@Valid @PathVariable("bookid") int bookid) {
        bookService.delete(bookid);
    }

    @PostMapping("/book")
    private int saveBook(@Valid @RequestBody Books books) {
        bookService.saveOrUpdate(books);
        return books.getBookid();
    }

    @PutMapping("/book/{bookid}")
    private ResponseEntity<Books> update(@Valid @PathVariable("bookid") int bookid, @Valid @RequestBody Books updatedBook) {
        Books existingBook = bookService.getBooksById(bookid);

        if (existingBook != null) {
            // Set the ID from path variable to the updatedBook
            updatedBook.setBookid(bookid);

            // Perform the update
            bookService.saveOrUpdate(updatedBook);

            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
