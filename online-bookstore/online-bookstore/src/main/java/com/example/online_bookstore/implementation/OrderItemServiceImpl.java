package com.example.online_bookstore.implementation;

import com.example.online_bookstore.models.Category;
import com.example.online_bookstore.models.OrderItem;
import com.example.online_bookstore.repository.OrderItemRepo;
import com.example.online_bookstore.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemRepo repo;

    @Override
    public List<OrderItem> findByBookOrder(Long orderId) {
        return List.of();
    }
    @Override
    public List<OrderItem> getAll() {
        return repo.findAll();
    }

    @Override
    public boolean existsById(long id) {
        return repo.existsById(id);
    }

    @Override
    public Optional<OrderItem> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public OrderItem create(OrderItem t) {
        return repo.save(t);
    }

    @Override
    public Optional<OrderItem> update(OrderItem t, long id) {
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
