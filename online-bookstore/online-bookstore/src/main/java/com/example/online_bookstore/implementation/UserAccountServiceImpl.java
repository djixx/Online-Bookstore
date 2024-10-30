package com.example.online_bookstore.implementation;

import com.example.online_bookstore.enums.Role;
import com.example.online_bookstore.models.UserAccount;
import com.example.online_bookstore.repository.UserAccountRepo;
import com.example.online_bookstore.service.UserAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountRepo repo;


    @Override
    public List<UserAccount> findUserByFirstAndLastName(String lastname, String firstname) {
        return repo.findByLastnameOrFirstname(lastname, firstname);
    }

    @Override
    public Optional<UserAccount> findUserByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public List<UserAccount> findAllNonAdmin(Role admin) {
        return findAllNonAdmin(admin);
    }

    @Override
    public List<UserAccount> getAll() {
        return repo.findAll();
    }

    @Override
    public boolean existsById(long id) {
        return repo.existsById(id);
    }

    @Override
    public Optional<UserAccount> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public UserAccount create(UserAccount t) {
        return repo.save(t);
    }

    @Override
    public Optional<UserAccount> update(UserAccount t, long id) {
        if(existsById(id)) {
            t.setId(id);
            return Optional.of(repo.save(t));
        }
        return Optional.empty();
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }
}
