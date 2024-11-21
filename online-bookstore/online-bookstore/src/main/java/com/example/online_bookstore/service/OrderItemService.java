package com.example.online_bookstore.service;

import com.example.online_bookstore.persistence.OrderItemEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderItemService {
    List<OrderItemEntity> findByBookOrder(Long orderId);

    List<OrderItemEntity> getAll();

    boolean existsById(long id);

    Optional<OrderItemEntity> findById(long id);

    OrderItemEntity create(OrderItemEntity t);

    Optional<OrderItemEntity> update(OrderItemEntity t, long id);

    void delete(long id);
}
