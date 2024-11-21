package com.example.online_bookstore.controllers;

import com.example.online_bookstore.persistence.BookOrderEntity;
import com.example.online_bookstore.service.BookOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@CrossOrigin
@RestController
public class BookOrderController {

    private BookOrderService service;

    @GetMapping("/order")
    public List<BookOrderEntity> getAllBooks(){
        return service.getAll();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Long id) {
        Optional<BookOrderEntity> order = service.findById(id);
        if (order.isPresent()) {
            return ResponseEntity.ok(order.get());
        }
        return ResponseEntity.status(404).body("Resource with requested ID: " + id + " does not exist");
    }

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody BookOrderEntity order){
        if (service.existsById(order.getId())){
            return ResponseEntity.status(409).body("Resource already exists!");
        }
        BookOrderEntity savedOrder = service.create(order);
        URI uri = URI.create("order/" + savedOrder.getId());
        return ResponseEntity.created(uri).body(savedOrder);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<?> updateOrder(@RequestBody BookOrderEntity order, @PathVariable int id) {
        Optional<BookOrderEntity> updatedOrder = service.update(order, id);
        if (updatedOrder.isPresent()) {
            return ResponseEntity.ok(updatedOrder.get());
        }
        return ResponseEntity.status(404).body("Resource with requested ID: " + id + " could not be updated!" + " as it does not exist!!");
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable int id) {
        if (service.existsById(id)) {
            service.delete(id);
            return ResponseEntity.ok("Resurce with id: " + id + " successfully deleted!");
        }
        return ResponseEntity.status(404).body("Resurce with id: " + id + " could not be deleted! " + " as it does not exist");
    }
}
