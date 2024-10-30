package com.example.online_bookstore.repository;

import com.example.online_bookstore.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem,Long> {

    List<OrderItem> findByBookOrderId(Long orderId);

}
