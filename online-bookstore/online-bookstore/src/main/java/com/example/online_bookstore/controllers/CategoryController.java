package com.example.online_bookstore.controllers;

import com.example.online_bookstore.persistence.CategoryEntity;
import com.example.online_bookstore.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@CrossOrigin
@RestController
public class CategoryController {

    private CategoryService service;

    @GetMapping("/cat")
    public List<CategoryEntity> getAllCategory(){
        return service.getAll();
    }

    @GetMapping("/cat/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") Long id) {
        Optional<CategoryEntity> category = service.findById(id);
        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        }
        return ResponseEntity.status(404).body("Resource with requested ID: " + id + " does not exist");
    }

    @PostMapping("/cat")
    public ResponseEntity<?> createBook(@RequestBody CategoryEntity categoryEntity){
        if (service.existsById(categoryEntity.getId())){
            return ResponseEntity.status(409).body("Resource already exists!");
        }
        CategoryEntity savedCategoryEntity = service.create(categoryEntity);
        URI uri = URI.create("cat/" + savedCategoryEntity.getId());
        return ResponseEntity.created(uri).body(savedCategoryEntity);
    }
    @PutMapping("/cat/{id}")
    public ResponseEntity<?> updateBook(@RequestBody CategoryEntity categoryEntity, @PathVariable int id) {
        Optional<CategoryEntity> updatedCategory = service.update(categoryEntity, id);
        if (updatedCategory.isPresent()) {
            return ResponseEntity.ok(updatedCategory.get());
        }
        return ResponseEntity.status(404).body("Resource with requested ID: " + id + " could not be updated!" + " as it does not exist!!");
    }

    @DeleteMapping("/cat/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        if (service.existsById(id)) {
            service.delete(id);
            return ResponseEntity.ok("Resurce with id: " + id + " successfully deleted!");
        }
        return ResponseEntity.status(404).body("Resurce with id: " + id + " could not be deleted! " + " as it does not exist");
    }




}
