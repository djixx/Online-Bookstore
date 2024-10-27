package com.example.online_bookstore.repository;

import com.example.online_bookstore.models.Book;
import com.example.online_bookstore.models.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;

@Repository
public interface BookOrderRepo extends JpaRepository<BookOrder,Long> {

    List<BookOrder> findByStartDateAfter(Date date);

    List<BookOrder> findByStartDateBefore(Date date);

    List<BookOrder> findByStartDateBetween(Date startDate, Date endDate);

    List<BookOrder> findByOrderFinishedDateBeforeAndOrderFinishedDateIsNotNull(Date date);


}
