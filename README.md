This project is a RESTful API that manages relationships between customers and companies. 
It allows users to fetch companies based on a customer's name, retrieve customers with a specific name, and add new customers to the system. 
The API is built using Spring Boot framework with MongoDB as the database. It utilizes technologies like Java, Spring Boot, MongoDB, and JUnit for testing. 
The project follows a microservice architecture and employs best practices in software development and testing.

Some information to highlight:
It exposes a REST GET endpoint /api/customer/{name} to fetch companies based on a passed customer name parameter.
It creates a service method getCompaniesByCustomerName to fetch companies based on customer name.
It exposes a REST POST endpoint /api/customer to add a customer, ensuring that the customer's name is not null and returning an appropriate message if it is.
It includes unit tests for the controller and service methods, covering both positive and negative scenarios.
