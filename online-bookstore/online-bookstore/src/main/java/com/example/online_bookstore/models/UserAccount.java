package com.example.online_bookstore.models;

import com.example.online_bookstore.enums.Gender;
import com.example.online_bookstore.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String imageUrl;

    private String firstname;

    private String lastname;

    private String email;

    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "userAccount")
    private Set<BookOrder> bookOrders;
}
