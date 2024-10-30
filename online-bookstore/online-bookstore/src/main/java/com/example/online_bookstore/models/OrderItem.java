package com.example.online_bookstore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "refBookOrder", referencedColumnName = "id")
    private BookOrder bookOrder;

    @ManyToOne
    @JoinColumn(name = "refBook", referencedColumnName = "id")
    private Book book;

    private int quantity;

    private double price;
}
