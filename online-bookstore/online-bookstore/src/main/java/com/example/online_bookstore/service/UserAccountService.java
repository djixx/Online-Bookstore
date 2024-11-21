package com.example.online_bookstore.service;

import com.example.online_bookstore.enums.Role;
import com.example.online_bookstore.persistence.UserAccountEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserAccountService {

    List<UserAccountEntity> findUserByFirstAndLastName(String lastname , String firstname);

    Optional<UserAccountEntity> findUserByUsername(String username);

    List<UserAccountEntity> findAllNonAdmin(Role admin);

    List<UserAccountEntity> getAll();

    boolean existsById(long id);

    Optional<UserAccountEntity> findById(long id);

    UserAccountEntity create(UserAccountEntity t);

    Optional<UserAccountEntity> update(UserAccountEntity t, long id);

    void delete(long id);
}
