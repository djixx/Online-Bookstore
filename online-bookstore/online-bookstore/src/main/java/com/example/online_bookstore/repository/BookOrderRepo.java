package com.example.online_bookstore.repository;

import com.example.online_bookstore.persistence.BookOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookOrderRepo extends JpaRepository<BookOrderEntity,Long> {

    List<BookOrderEntity> findByOrderDateAfter(Date date);

    List<BookOrderEntity> findByOrderDateBefore(Date date);

    List<BookOrderEntity> findByOrderDateBetween(Date startDate, Date endDate);

    /**
     * Finds all completed book orders before a specified date.
     * <p>
     * This method retrieves a list of BookOrder objects that have been completed
     * before the given date and are marked as finished.
     *
     * @param date the cutoff date before which orders must be completed
     * @return a list of completed BookOrder objects
     */

    @Query("SELECT b " +
            "FROM BookOrder b " +
            "WHERE b.orderFinishedDate < :date AND b.orderFinishedDate IS NOT NULL")
    List<BookOrderEntity> findCompletedOrdersBeforeDate(Date date);


}
