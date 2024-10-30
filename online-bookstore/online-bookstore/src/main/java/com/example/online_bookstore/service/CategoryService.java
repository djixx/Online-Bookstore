package com.example.online_bookstore.service;

import com.example.online_bookstore.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

    List<Category> findByNameContainingIgnoreCase(String name);


    List<Category> getAll();

    boolean existsById(long id);

    Optional<Category> findById(long id);

    Category create(Category t);

    Optional<Category> update(Category t, long id);

    void delete(long id);
}
