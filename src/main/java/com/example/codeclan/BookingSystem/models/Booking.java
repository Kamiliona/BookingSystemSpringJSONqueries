package com.example.codeclan.BookingSystem.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name ="booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="date")
    private String date;


    @ManyToOne
    @JoinColumn(name ="customer_id", nullable = false)
    private Customer customer;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name ="course_id", nullable = false)
    private Course course;

    public Booking(String date, Customer customer, Course course) {
        this.date = date;
        this.customer = customer;
        this.course = course;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void addBooking(Customer customer) {this.customer = customer; }
}


