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
    private long id;

    private String title;

    private String authorFirstname;

    private String authorLastname;

    private String description;

    private double price;

    private String imageUrl;

    private int year;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "book")
    private Set<OrderItem> orderItems;
}
