package com.example.online_bookstore.models;

import com.example.online_bookstore.persistence.BookEntity;
import com.example.online_bookstore.persistence.BookOrderEntity;

public class OrderItem extends Model{

    private int quantity;

    private double price;

    private Long bookOrderId;

    private Long bookId;
}

