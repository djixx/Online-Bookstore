package com.example.online_bookstore.implementation;

import com.example.online_bookstore.persistence.CategoryEntity;
import com.example.online_bookstore.repository.CategoryRepo;
import com.example.online_bookstore.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class CategoryServiceImpl implements CategoryService {


    private CategoryRepo repo;

    @Override
    public List<CategoryEntity> findByNameContainingIgnoreCase(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<CategoryEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public boolean existsById(long id) {
        return repo.existsById(id);
    }

    @Override
    public Optional<CategoryEntity> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public CategoryEntity create(CategoryEntity t) {
        return repo.save(t);
    }

    @Override
    public Optional<CategoryEntity> update(CategoryEntity t, long id) {
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
