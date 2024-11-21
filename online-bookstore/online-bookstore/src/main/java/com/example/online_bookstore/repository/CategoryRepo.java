package com.example.online_bookstore.repository;

import com.example.online_bookstore.persistence.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity,Long> {

    List<CategoryEntity> findByNameContainingIgnoreCase(String name);

}
