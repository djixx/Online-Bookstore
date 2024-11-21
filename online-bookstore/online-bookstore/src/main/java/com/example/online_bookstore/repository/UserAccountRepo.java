package com.example.online_bookstore.repository;

import com.example.online_bookstore.enums.Role;
import com.example.online_bookstore.persistence.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccountEntity,Long> {

     List<UserAccountEntity> findByLastnameOrFirstname(String lastname, String firstname);

     Optional<UserAccountEntity>findByUsername(String username);


    @Query("select u " +
            "from UserAccount u " +
            "where u.role != :ADMIN " +
            "order by u.id asc ")
    List<UserAccountEntity> findAllNonAdmin(Role ADMIN);
}
