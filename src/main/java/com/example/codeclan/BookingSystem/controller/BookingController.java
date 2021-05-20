package com.example.codeclan.BookingSystem.controller;

import com.example.codeclan.BookingSystem.models.Booking;
import com.example.codeclan.BookingSystem.models.Course;
import com.example.codeclan.BookingSystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestParam(name="date", required = false)
                    String date

    ) {
        if (date != null) { // check if there's a ?location=something on the URL
            return new ResponseEntity<>(bookingRepository.findBookingByDate(date), HttpStatus.OK);
        }

        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);

    }
}
