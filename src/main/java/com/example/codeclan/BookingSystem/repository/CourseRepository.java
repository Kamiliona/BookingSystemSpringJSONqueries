package com.example.codeclan.BookingSystem.repository;

import com.example.codeclan.BookingSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
List<Course> findCourseByRating(Integer rating);
List<Course> findCoursesByCustomersNameIgnoreCase(String name);
//    Courses by given rating: /courses?rating=5

//    Courses by given customer: /courses?customer=Sandy
}
