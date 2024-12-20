package com.example.online_bookstore.repository;

import com.example.online_bookstore.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
    List<Category> findByNameContainingIgnoreCase(String name);
}
