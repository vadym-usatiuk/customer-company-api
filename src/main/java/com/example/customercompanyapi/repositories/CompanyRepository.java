package com.example.customercompanyapi.repositories;

import com.example.customercompanyapi.models.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, Long> {
}