package com.example.bookapi.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookapi.model.Books;
import com.example.bookapi.repository.BookRepository;


@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Books> getAllBooks() {
        List<Books> books = new ArrayList<>();
        bookRepository.findAll().forEach(books1 -> books.add(books1));
        return books;
    }

    public Books getBooksById(@Valid int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entered book ID is not available, please search for a valid book ID"));
    }

    public void saveOrUpdate(@Valid Books books) {
        bookRepository.save(books);
    }

    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    public void update(Books books, int bookid) {
        bookRepository.save(books);
    }
}
