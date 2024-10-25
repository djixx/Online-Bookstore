package com.example.online_bookstore.models;

import com.example.online_bookstore.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class BookOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "refUser", referencedColumnName = "id")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "bookOrder")
    private Set<OrderItem> orderItems;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
