package com.example.customercompanyapi.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.customercompanyapi.models.Company;
import com.example.customercompanyapi.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CompanyServiceTest {

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private CompanyService companyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetCompaniesByCustomerName() {
        // Given
        String customerName = "John Doe";
        Query query = new Query();
        query.addCriteria(Criteria.where("customers.name").is(customerName));
        List<Company> expectedCompanies = Arrays.asList(new Company(), new Company());
        when(mongoTemplate.find(query, Company.class)).thenReturn(expectedCompanies);

        // When
        List<Company> actualCompanies = companyService.getCompaniesByCustomerName(customerName);

        // Then
        assertEquals(expectedCompanies.size(), actualCompanies.size());
        assertEquals(expectedCompanies, actualCompanies);
    }

    @Test
    void testGetCustomersByName() {
        // Given
        String customerName = "John Doe";
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(customerName));
        List<Customer> expectedCustomers = Arrays.asList(new Customer(), new Customer());
        when(mongoTemplate.find(query, Customer.class)).thenReturn(expectedCustomers);

        // When
        List<Customer> actualCustomers = companyService.getCustomersByName(customerName);

        // Then
        assertEquals(expectedCustomers.size(), actualCustomers.size());
        assertEquals(expectedCustomers, actualCustomers);
    }

    @Test
    void testAddCustomer() {
        // Given
        Customer customer = new Customer();
        customer.setName("John Doe");

        // When
        assertDoesNotThrow(() -> companyService.addCustomer(customer));

        // Then
        verify(mongoTemplate, times(1)).save(customer);
    }

    @Test
    void testAddCustomerWithNullName() {
        // Given
        Customer customer = new Customer();

        // When/Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> companyService.addCustomer(customer));
        assertEquals("Customer name cannot be null", exception.getMessage());
        verify(mongoTemplate, never()).save(customer);
    }
}