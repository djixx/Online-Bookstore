package com.example.online_bookstore.implementation;

import com.example.online_bookstore.models.Category;
import com.example.online_bookstore.repository.CategoryRepo;
import com.example.online_bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo repo;

    @Override
    public List<Category> findByNameContainingIgnoreCase(String name) {
        return repo.findByNameContainingIgnoreCase();
    }

    @Override
    public List<Category> getAll() {
        return repo.findAll();
    }

    @Override
    public boolean existsById(long id) {
        return repo.existsById(id);
    }

    @Override
    public Optional<Category> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public Category create(Category t) {
        return repo.save(t);
    }

    @Override
    public Optional<Category> update(Category t, long id) {
        if(existsById(id)) {
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
