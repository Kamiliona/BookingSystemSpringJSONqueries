package com.example.codeclan.BookingSystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="town")
    private String town;

    @Column(name ="rating")
    private int rating;

    @JsonBackReference
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name="customers_courses",
            joinColumns = {@JoinColumn(name= "course_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "customer_id", nullable = false, updatable = false)}
    )
    private List<Customer> customers;

    @OneToMany(mappedBy ="course", fetch = FetchType.LAZY)
    private List<Booking> bookings;


    public Course(String name, String town, int rating) {
        this.name = name;
        this.town = town;
        this.rating = rating;
        this.customers = new ArrayList<Customer>();
        this.bookings = new ArrayList<Booking>();
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
