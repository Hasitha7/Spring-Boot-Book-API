package com.example.bookapi.repository;

import com.example.bookapi.model.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books, Integer> {
}
