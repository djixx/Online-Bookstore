package com.example.online_bookstore.controllers;

import com.example.online_bookstore.models.Book;
import com.example.online_bookstore.models.Response;
import com.example.online_bookstore.persistence.BookEntity;
import com.example.online_bookstore.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@CrossOrigin
@RestController
public class BookController {

    private BookService service;

    @GetMapping("/book")
    public List<BookEntity> getAllBooks() {
        return service.getAll();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Long id) {
        Optional<BookEntity> book = service.findById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.status(404).body("Resource with requested ID: " + id + " does not exist");
    }

    @PostMapping("/book")
    public Response createBook(@RequestBody Book book) {
        return service.create(book);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<?> updateBook(@RequestBody BookEntity bookEntity, @PathVariable int id) {
        Optional<BookEntity> updatedBook = service.update(bookEntity, id);
        if (updatedBook.isPresent()) {
            return ResponseEntity.ok(updatedBook.get());
        }
        return ResponseEntity.status(404).body("Resource with requested ID: " + id + " could not be updated!" + " as it does not exist!!");
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        if (service.existsById(id)) {
            service.delete(id);
            return ResponseEntity.ok("Resurce with id: " + id + " successfully deleted!");
        }
        return ResponseEntity.status(404).body("Resurce with id: " + id + " could not be deleted! " + " as it does not exist");
    }


}
