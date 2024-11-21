package com.example.online_bookstore.persistence;

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
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "refBookOrder", referencedColumnName = "id")
    private BookOrderEntity bookOrder;

    @ManyToOne
    @JoinColumn(name = "refBook", referencedColumnName = "id")
    private BookEntity book;

    private int quantity;

    private double price;
}
