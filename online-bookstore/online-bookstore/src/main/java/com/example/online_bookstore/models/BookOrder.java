package com.example.online_bookstore.models;


import com.example.online_bookstore.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BookOrder extends Model{
    private Long userAccountId;

    private List<Long> orderItemsId;

    private Double totalPrice;

    private Date orderDate;

    private Date orderFinishedDate;

    private OrderStatus status;

}
