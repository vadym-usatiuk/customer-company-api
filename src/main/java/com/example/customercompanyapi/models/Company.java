package com.example.customercompanyapi.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Company {
    @Id
    private String id; // Change the type to String
    private String companyName;
    private List<Customer> customers;

    // Constructor to initialize the customers list
    public Company() {
        this.customers = new ArrayList<>();
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}