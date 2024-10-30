package com.example.online_bookstore.implementation;

import com.example.online_bookstore.models.BookOrder;
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
    public List<BookOrder> findBookOrderAfterDate(Date date) {
        return repo.findByStartDateAfter(date);
    }

    @Override
    public List<BookOrder> findBookOrderBeforeDate(Date date) {
        return repo.findByStartDateBefore(date);
    }

    @Override
    public List<BookOrder> findBookOrderBetweenDates(Date startDate, Date endDate) {
        return repo.findByStartDateBetween(startDate, endDate);
    }

    @Override
    public List<BookOrder> findCompletedBookOrder(Date date) {
        return repo.findCompletedOrdersBeforeDate(date);
    }

    @Override
    public boolean existsById(long id) {
        return repo.existsById(id);
    }

    @Override
    public Optional<BookOrder> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public BookOrder create(BookOrder t) {
        return repo.save(t);
    }

    @Override
    public Optional<BookOrder> update(BookOrder t, long id) {
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
