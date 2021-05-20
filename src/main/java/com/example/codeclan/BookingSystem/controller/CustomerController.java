package com.example.codeclan.BookingSystem.controller;

import com.example.codeclan.BookingSystem.models.Customer;
import com.example.codeclan.BookingSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name = "course", required = false)
                    String coursesName,
            @RequestParam(name= "town", required = false)
                    String town,
            @RequestParam(name="age", required = false)
                    Integer customerAge
    ) {
        if (customerAge != null && coursesName != null && town != null) {
            return new ResponseEntity<>(customerRepository.findCustomersByCoursesNameIgnoreCaseAndTownIgnoreCaseAndAge(coursesName, town, customerAge), HttpStatus.OK);
        }
        if (coursesName != null && town != null) {
            return new ResponseEntity<>(customerRepository.findCustomersByCoursesNameIgnoreCaseAndTownIgnoreCase(coursesName, town), HttpStatus.OK);
        }
        if (coursesName != null) {
            return new ResponseEntity<>(customerRepository.findCustomersByCoursesNameIgnoreCase(coursesName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

}


