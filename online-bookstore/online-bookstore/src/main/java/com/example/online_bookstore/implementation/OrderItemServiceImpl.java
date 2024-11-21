package com.example.online_bookstore.implementation;

import com.example.online_bookstore.persistence.OrderItemEntity;
import com.example.online_bookstore.repository.OrderItemRepo;
import com.example.online_bookstore.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepo repo;

    @Override
    public List<OrderItemEntity> findByBookOrder(Long orderId) {
        return List.of();
    }
    @Override
    public List<OrderItemEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public boolean existsById(long id) {
        return repo.existsById(id);
    }

    @Override
    public Optional<OrderItemEntity> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public OrderItemEntity create(OrderItemEntity t) {
        return repo.save(t);
    }

    @Override
    public Optional<OrderItemEntity> update(OrderItemEntity t, long id) {
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
