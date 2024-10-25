package com.example.online_bookstore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "refBookOrder", referencedColumnName = "id")
    private BookOrder bookOrder;

    @ManyToOne
    @JoinColumn(name = "refBook", referencedColumnName = "id")
    private Book book;

    private int quantity;

    private double price;
}
