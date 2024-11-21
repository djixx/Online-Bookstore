package com.example.online_bookstore.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book extends Model {
    private String title;

    private String authorFirstname;

    private String authorLastname;

    private String description;

    private double price;

    private String imageUrl;

    private int year;

    private Long categoryId;
}
