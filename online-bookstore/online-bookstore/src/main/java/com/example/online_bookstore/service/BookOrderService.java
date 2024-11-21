package com.example.online_bookstore.service;

import com.example.online_bookstore.persistence.BookOrderEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface BookOrderService {

    List<BookOrderEntity> findBookOrderAfterDate(Date date);

    List<BookOrderEntity> findBookOrderBeforeDate(Date date);

    List<BookOrderEntity> findBookOrderBetweenDates(Date startDate, Date endDate);

    List<BookOrderEntity> findCompletedBookOrder(Date date);

    List<BookOrderEntity> getAll();

    boolean existsById(long id);

    Optional<BookOrderEntity> findById(long id);

    BookOrderEntity create(BookOrderEntity t);

    Optional<BookOrderEntity> update(BookOrderEntity t, long id);

    void delete(long id);
}
