package com.example.online_bookstore.implementation;

import com.example.online_bookstore.models.Book;
import com.example.online_bookstore.models.Response;
import com.example.online_bookstore.persistence.BookEntity;
import com.example.online_bookstore.persistence.CategoryEntity;
import com.example.online_bookstore.repository.BookRepo;
import com.example.online_bookstore.service.BookService;
import com.example.online_bookstore.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

@AllArgsConstructor
@Component
public class BookServiceImpl implements BookService {

    private BookRepo repo;
    private CategoryService categoryService;


    @Override
    public Optional<BookEntity> findByTitle(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<BookEntity> findByYear(int year) {
        return repo.findByYear(year);
    }

    @Override
    public List<BookEntity> findBooksByOrderYearDesc() {
        return repo.findAllByOrderByYearDesc();
    }

    @Override
    public List<BookEntity> findBooksAuthorLastName(String authorLastname) {
        return repo.findByAuthorLastname(authorLastname);
    }

    @Override
    public List<BookEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public boolean existsById(long id) {
        return repo.existsById(id);
    }

    @Override
    public Optional<BookEntity> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public Response create(Book book) {
        Response response = new Response();
        response.setModel(book);

        if (alreadyExists(book)) {
            response.setStatus(HttpStatus.CONFLICT);
        }
        BookEntity bookEntity = new BookEntity();
        bookEntity.setPrice(bookEntity.getPrice());
        bookEntity.setDescription(bookEntity.getDescription());
        bookEntity.setYear(bookEntity.getYear());
        bookEntity.setTitle(bookEntity.getTitle());
        bookEntity.setAuthorFirstname(book.getAuthorFirstname());
        bookEntity.setAuthorLastname(book.getAuthorLastname());
        bookEntity.setImageUrl(book.getImageUrl());

        if (nonNull(book.getCategoryId())) {
            Optional<CategoryEntity> cat = categoryService.findById(book.getCategoryId());
            bookEntity.setCategory(cat.orElse(null));
        }

        repo.save(bookEntity);
        response.setStatus(HttpStatus.CREATED);
        return response;
    }

    /**
     * Method checks if there already exists book with the same title.
     *
     * @param book for which check is done
     * @return boolean value if book is present
     */
    private boolean alreadyExists(Book book) {
        Optional<BookEntity> optionalBook = repo.findByTitleContainingIgnoreCase(book.getTitle());
        return optionalBook.isPresent();
    }

    @Override
    public Optional<BookEntity> update(BookEntity t, long id) {
        if (existsById(id)) {
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
