package com.example.online_bookstore.service;

import com.example.online_bookstore.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {

    Optional<Book> findByTitle(String title) ;
    List<Book> findByYear(int year);
    List<Book> findBooksByOrderYearDesc();
    List<Book> findBooksAuthorLastName(String authorLastname);
    List<Book> getAll();

    boolean existsById(long id);

    Optional<Book> findById(long id);

    Book create(Book t);

    Optional<Book> update(Book t, long id);

    void delete(long id);

}
