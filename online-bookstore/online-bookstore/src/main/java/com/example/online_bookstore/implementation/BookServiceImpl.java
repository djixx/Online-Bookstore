package com.example.online_bookstore.implementation;

import com.example.online_bookstore.models.Book;
import com.example.online_bookstore.repository.BookRepo;
import com.example.online_bookstore.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class BookServiceImpl implements BookService {

    private BookRepo repo;


    @Override
    public Optional<Book> findByTitle(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Book> findByYear(int year) {
        return repo.findByYear(year);
    }

    @Override
    public List<Book> findBooksByOrderYearDesc() {
        return repo.findAllByOrderByYearDesc();
    }

    @Override
    public List<Book> findBooksAuthorLastName(String authorLastname) {
        return repo.findByAuthorLastName(authorLastname);
    }

    @Override
    public List<Book> getAll() {
        return repo.findAll();
    }

    @Override
    public boolean existsById(long id) {
        return repo.existsById(id);
    }

    @Override
    public Optional<Book> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public Book create(Book t) {
        return repo.save(t);
    }

    @Override
    public Optional<Book> update(Book t, long id) {
        if(existsById(id)){
            t.setId(id);
            return Optional.of(repo.save(t));
        }
        return Optional.empty();
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }
}
