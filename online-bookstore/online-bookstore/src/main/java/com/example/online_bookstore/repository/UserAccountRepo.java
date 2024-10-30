package com.example.online_bookstore.repository;

import com.example.online_bookstore.enums.Role;
import com.example.online_bookstore.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount,Long> {

     List<UserAccount> findByLastnameOrFirstname(String lastname, String firstname);

     Optional<UserAccount>findByUsername(String username);

     List<UserAccount> findAllByOrderByUserIdAsc();

    @Query("select u " +
            "from UserAccount u " +
            "where u.role != :ADMIN " +
            "order by u.Id asc ")
    List<UserAccount> findAllNonAdmin(Role admin);
}
