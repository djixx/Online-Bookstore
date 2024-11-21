package com.example.online_bookstore.service;

import com.example.online_bookstore.models.Book;
import com.example.online_bookstore.models.Response;
import com.example.online_bookstore.persistence.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {

    Optional<BookEntity> findByTitle(String title) ;
    List<BookEntity> findByYear(int year);
    List<BookEntity> findBooksByOrderYearDesc();
    List<BookEntity> findBooksAuthorLastName(String authorLastname);
    List<BookEntity> getAll();

    boolean existsById(long id);

    Optional<BookEntity> findById(long id);

    Response create(Book book);

    Optional<BookEntity> update(BookEntity t, long id);

    void delete(long id);

}
