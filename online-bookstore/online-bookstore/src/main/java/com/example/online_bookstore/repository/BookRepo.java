package com.example.online_bookstore.repository;

import com.example.online_bookstore.persistence.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findByTitleContainingIgnoreCase(String title);

    List<BookEntity> findByYear(int year);

    List<BookEntity> findAllByOrderByYearDesc();

    List<BookEntity> findByAuthorLastname(String authorLastname);

    @Query("select b from Book b where b.title = :title")
    Optional<BookEntity> findByTitle(String title);

}
