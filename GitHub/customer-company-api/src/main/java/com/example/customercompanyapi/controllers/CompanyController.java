package com.example.customercompanyapi.controllers;

import com.example.customercompanyapi.models.Company;
import com.example.customercompanyapi.models.Customer;
import com.example.customercompanyapi.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // GET endpoint to fetch Company based on customer name
    @GetMapping("/customer/{name}")
    public ResponseEntity<List<Company>> getCompaniesByCustomerName(@PathVariable String name) {
        List<Company> companies = companyService.getCompaniesByCustomerName(name);
        return ResponseEntity.ok(companies);
    }

    // POST endpoint to add a customer
    @PostMapping("/customer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        try {
            if (customer.getName() == null) {
                return ResponseEntity.badRequest().body("Customer name cannot be null");
            }
            companyService.addCustomer(customer);
            return ResponseEntity.ok("Customer added successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}