package com.example.online_bookstore.service;

import com.example.online_bookstore.persistence.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

    List<CategoryEntity> findByNameContainingIgnoreCase(String name);

    List<CategoryEntity> getAll();

    boolean existsById(long id);

    Optional<CategoryEntity> findById(long id);

    CategoryEntity create(CategoryEntity t);

    Optional<CategoryEntity> update(CategoryEntity t, long id);

    void delete(long id);

}
