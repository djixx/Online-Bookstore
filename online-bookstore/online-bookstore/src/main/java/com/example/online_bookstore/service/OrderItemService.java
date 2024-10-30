package com.example.online_bookstore.service;

import com.example.online_bookstore.models.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderItemService {
    List<OrderItem> findByBookOrder(Long orderId);

    List<OrderItem> getAll();

    boolean existsById(long id);

    Optional<OrderItem> findById(long id);

    OrderItem create(OrderItem t);

    Optional<OrderItem> update(OrderItem t, long id);

    void delete(long id);
}
