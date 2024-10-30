package com.example.online_bookstore.service;

import com.example.online_bookstore.models.BookOrder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface BookOrderService {

    List<BookOrder> findBookOrderAfterDate(Date date);

    List<BookOrder> findBookOrderBeforeDate(Date date);

    List<BookOrder> findBookOrderBetweenDates(Date startDate, Date endDate);

    List<BookOrder> findCompletedBookOrder(Date date);

    boolean existsById(long id);

    Optional<BookOrder> findById(long id);

    BookOrder create(BookOrder t);

    Optional<BookOrder> update(BookOrder t, long id);

    void delete(long id);
}
