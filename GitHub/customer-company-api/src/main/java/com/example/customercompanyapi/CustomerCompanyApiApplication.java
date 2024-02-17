package com.example.customercompanyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.customercompanyapi")
public class CustomerCompanyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerCompanyApiApplication.class, args);
	}}