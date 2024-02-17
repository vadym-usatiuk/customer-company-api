package com.example.customercompanyapi.repositories;

import com.example.customercompanyapi.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
}