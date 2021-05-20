package com.example.codeclan.BookingSystem.repository;

import com.example.codeclan.BookingSystem.models.Customer;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    Customer by given course: /customers?course=nanobiotechnology
    List<Customer> findCustomersByCoursesNameIgnoreCase(String coursesName);

//    Customer in a given town on a given course
    List<Customer> findCustomersByCoursesNameIgnoreCaseAndTownIgnoreCase(String courseName, String Town);

    List<Customer> findCustomersByCoursesNameIgnoreCaseAndTownIgnoreCaseAndAge(String courseName, String Town, int Age);
}
