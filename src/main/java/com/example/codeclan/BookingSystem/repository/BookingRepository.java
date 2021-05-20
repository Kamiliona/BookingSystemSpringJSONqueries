package com.example.codeclan.BookingSystem.repository;

import com.example.codeclan.BookingSystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

//    Bookings by given date: /bookings?date=21-05-2021
    List<Booking> findBookingByDate(String date);
}
