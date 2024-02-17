package com.example.customercompanyapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import com.example.customercompanyapi.models.Company;
import com.example.customercompanyapi.models.Customer;

@Service
public class CompanyService {

    @Autowired
    private MongoTemplate mongoTemplate;

    //to fetch company based on customer name
    public List<Company> getCompaniesByCustomerName(String name) {
        if (name == null) {
            return Collections.emptyList(); // or throw an exception if needed
        }

        Query query = new Query();
        query.addCriteria(Criteria.where("customers.name").is(name));
        return mongoTemplate.find(query, Company.class);
    }

    // fetch all customers with a given name
    public List<Customer> getCustomersByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Customer.class);
    }

    // add a Customer
    public void addCustomer(Customer customer) {
        if (customer.getName() != null) {
            // Insert the customer into the MongoDB database
            mongoTemplate.save(customer);
        } else {
            throw new IllegalArgumentException("Customer name cannot be null");
        }
    }
}