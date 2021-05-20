package com.example.codeclan.BookingSystem.controller;

import com.example.codeclan.BookingSystem.models.Course;
import com.example.codeclan.BookingSystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value="/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name="rating", required = false)
            Integer rating,
            @RequestParam(name="customer", required = false)
            String customer
    ) {
        if (rating != null) { // check if there's a ?location=something on the URL
            return new ResponseEntity<>(courseRepository.findCourseByRating(rating), HttpStatus.OK);
        }
        if (customer != null) {
            return new ResponseEntity<>(courseRepository.findCoursesByCustomersNameIgnoreCase(customer), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);

    }
}
