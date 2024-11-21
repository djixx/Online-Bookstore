package com.example.online_bookstore.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class BookEntity {
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
    private CategoryEntity category;

    @OneToMany(mappedBy = "book")
    private Set<OrderItemEntity> orderItemEntities;
}
