package com.example.online_bookstore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String description;

    private double price;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "book")
    private Set<OrderItem> orderItems;
}
