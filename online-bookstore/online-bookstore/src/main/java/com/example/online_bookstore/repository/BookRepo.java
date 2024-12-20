package com.example.online_bookstore.repository;

import com.example.online_bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    Optional<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByYear(int year);

    List<Book> findAllByOrderByYearDesc();

    List<Book> findByAuthorLastName(String authorLastname);

}
