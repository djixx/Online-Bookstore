package com.example.online_bookstore.implementation;

import com.example.online_bookstore.persistence.BookOrderEntity;
import com.example.online_bookstore.repository.BookOrderRepo;
import com.example.online_bookstore.service.BookOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Component
public class BookOrderServiceImpl implements BookOrderService {

    private BookOrderRepo repo;

    @Override
    public List<BookOrderEntity> findBookOrderAfterDate(Date date) {
        return repo.findByOrderDateAfter(date);
    }

    @Override
    public List<BookOrderEntity> findBookOrderBeforeDate(Date date) {
        return repo.findByOrderDateBefore(date);
    }

    @Override
    public List<BookOrderEntity> findBookOrderBetweenDates(Date startDate, Date endDate) {
        return repo.findByOrderDateBetween(startDate, endDate);
    }

    @Override
    public List<BookOrderEntity> findCompletedBookOrder(Date date) {
        return repo.findCompletedOrdersBeforeDate(date);
    }

    @Override
    public List<BookOrderEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public boolean existsById(long id) {
        return repo.existsById(id);
    }

    @Override
    public Optional<BookOrderEntity> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public BookOrderEntity create(BookOrderEntity t) {
        return repo.save(t);
    }

    @Override
    public Optional<BookOrderEntity> update(BookOrderEntity t, long id) {
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
