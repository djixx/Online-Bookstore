package com.example.online_bookstore.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class Response {
    HttpStatus status;
    Model model;
}
