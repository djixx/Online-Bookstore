package com.example.online_bookstore.controllers;
import com.example.online_bookstore.persistence.UserAccountEntity;
import com.example.online_bookstore.service.UserAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@CrossOrigin
@RestController
public class UserAccountController {

    private UserAccountService service;

    @GetMapping("/user")
    public List<UserAccountEntity> getAllUserd(){
        return service.getAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        Optional<UserAccountEntity> user = service.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(404).body("Resource with requested ID: " + id + " does not exist");
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserAccountEntity user){
        if (service.existsById(user.getId())){
            return ResponseEntity.status(409).body("Resource already exists!");
        }
        UserAccountEntity savedUser = service.create(user);
        URI uri = URI.create("user/" + savedUser.getId());
        return ResponseEntity.created(uri).body(savedUser);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserAccountEntity user, @PathVariable int id) {
        Optional<UserAccountEntity> updatedUser = service.update(user, id);
        if (updatedUser.isPresent()) {
            return ResponseEntity.ok(updatedUser.get());
        }
        return ResponseEntity.status(404).body("Resource with requested ID: " + id + " could not be updated!" + " as it does not exist!!");
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        if (service.existsById(id)) {
            service.delete(id);
            return ResponseEntity.ok("Resurce with id: " + id + " successfully deleted!");
        }
        return ResponseEntity.status(404).body("Resurce with id: " + id + " could not be deleted! " + " as it does not exist");
    }



}
