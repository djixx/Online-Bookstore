package com.example.online_bookstore.repository;

import com.example.online_bookstore.persistence.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItemEntity,Long> {

    List<OrderItemEntity> findByBookOrderId(Long orderId);

}
