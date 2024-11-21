package com.example.online_bookstore.persistence;

import com.example.online_bookstore.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "refUser", referencedColumnName = "id")
    private UserAccountEntity userAccount;

    @OneToMany(mappedBy = "bookOrder")
    private Set<OrderItemEntity> orderItemEntities;

    private Double totalPrice;

    private Date orderDate;

    private Date orderFinishedDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
