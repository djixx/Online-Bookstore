package com.example.online_bookstore.controllers;


import com.example.online_bookstore.persistence.OrderItemEntity;
import com.example.online_bookstore.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@CrossOrigin
@RestController
public class OrderItemController {

    private OrderItemService service;

    @GetMapping("/item")
    public List<OrderItemEntity> getAllBooks(){
        return service.getAll();
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<?> getOrderItemById(@PathVariable("id") Long id) {
        Optional<OrderItemEntity> item = service.findById(id);
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        }
        return ResponseEntity.status(404).body("Resource with requested ID: " + id + " does not exist");
    }

    @PostMapping("/item")
    public ResponseEntity<?> createOrderItem(@RequestBody OrderItemEntity item){
        if (service.existsById(item.getId())){
            return ResponseEntity.status(409).body("Resource already exists!");
        }
        OrderItemEntity savedOrderItemEntity = service.create(item);
        URI uri = URI.create("item/" + savedOrderItemEntity.getId());
        return ResponseEntity.created(uri).body(savedOrderItemEntity);
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<?> updateOrderItem(@RequestBody OrderItemEntity item, @PathVariable int id) {
        Optional<OrderItemEntity> updatedOrderItem = service.update(item, id);
        if (updatedOrderItem.isPresent()) {
            return ResponseEntity.ok(updatedOrderItem.get());
        }
        return ResponseEntity.status(404).body("Resource with requested ID: " + id + " could not be updated!" + " as it does not exist!!");
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<?> deleteOrderItem(@PathVariable int id) {
        if (service.existsById(id)) {
            service.delete(id);
            return ResponseEntity.ok("Resurce with id: " + id + " successfully deleted!");
        }
        return ResponseEntity.status(404).body("Resurce with id: " + id + " could not be deleted! " + " as it does not exist");
    }


}
