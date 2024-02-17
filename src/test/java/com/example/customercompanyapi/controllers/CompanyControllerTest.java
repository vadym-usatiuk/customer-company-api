package com.example.customercompanyapi.controllers;

import com.example.customercompanyapi.models.Company;
import com.example.customercompanyapi.models.Customer;
import com.example.customercompanyapi.services.CompanyService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;

    @Test
    void testGetCompaniesByCustomerName() throws Exception {
        // Given
        String customerName = "John Doe";
        Company company1 = new Company();
        company1.setCompanyName("Company A");
        Company company2 = new Company();
        company2.setCompanyName("Company B");
        List<Company> companies = Arrays.asList(company1, company2);
        when(companyService.getCompaniesByCustomerName(customerName)).thenReturn(companies);

        // When/Then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/customer/{name}", customerName))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].companyName").value("Company A"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].companyName").value("Company B"));
    }

    @Test
    void testAddCustomer() throws Exception {
        // Given
        Customer customer = new Customer();
        customer.setName("John Doe");

        // When/Then
        mockMvc.perform(MockMvcRequestBuilders.post("/api/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Customer added successfully"));
    }

    @Test
    void testAddCustomerWithNullName() throws Exception {
        // Given
        Customer customer = new Customer();

        // When/Then
        mockMvc.perform(MockMvcRequestBuilders.post("/api/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":null}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Customer name cannot be null"));
    }
}