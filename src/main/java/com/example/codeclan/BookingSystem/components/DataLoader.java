package com.example.codeclan.BookingSystem.components;

import com.example.codeclan.BookingSystem.models.Booking;
import com.example.codeclan.BookingSystem.models.Course;
import com.example.codeclan.BookingSystem.models.Customer;
import com.example.codeclan.BookingSystem.repository.BookingRepository;
import com.example.codeclan.BookingSystem.repository.CourseRepository;
import com.example.codeclan.BookingSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

}

    public void run(ApplicationArguments args){

        Customer sandy = new Customer("Sandy", "Chicago", 13);
        customerRepository.save(sandy);
        Course biology = new Course("Nanobiotechnology", "Geneva", 5);
        courseRepository.save(biology);
        Booking sandyBioBooking = new Booking("21-05-2021", sandy, biology);
        bookingRepository.save(sandyBioBooking);

        biology.addCustomer(sandy);
        biology.addBooking(sandyBioBooking);
        customerRepository.save(sandy);
        courseRepository.save(biology);
        bookingRepository.save(sandyBioBooking);
    }
}
