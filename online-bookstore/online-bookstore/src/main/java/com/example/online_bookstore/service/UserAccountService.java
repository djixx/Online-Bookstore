package com.example.online_bookstore.service;

import com.example.online_bookstore.enums.Role;
import com.example.online_bookstore.models.UserAccount;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserAccountService {

    List<UserAccount> findUserByFirstAndLastName(String lastname , String firstname);
    Optional<UserAccount> findUserByUsername(String username);
    List<UserAccount> findAllNonAdmin(Role admin);

    List<UserAccount> getAll();

    boolean existsById(long id);

    Optional<UserAccount> findById(long id);

    UserAccount create(UserAccount t);

    Optional<UserAccount> update(UserAccount t, long id);

    void delete(long id);
}
