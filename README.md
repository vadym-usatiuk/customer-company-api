Some information to highlight:
It exposes a REST GET endpoint /api/customer/{name} to fetch companies based on a passed customer name parameter.
It creates a service method getCompaniesByCustomerName to fetch companies based on customer name.
It exposes a REST POST endpoint /api/customer to add a customer, ensuring that the customer's name is not null and returning an appropriate message if it is.
It includes unit tests for the controller and service methods, covering both positive and negative scenarios.

Classes overview: 
CompanyController: Handles HTTP requests related to companies, including fetching companies by customer name and adding new customers.

CompanyService: Provides business logic for interacting with company data, such as fetching companies by customer name, fetching customers by name, and adding new customers.

Company: Represents a company entity with attributes like ID, company name, and a list of associated customers.

Customer: Represents a customer entity with attributes like ID and name.

CompanyRepository: Provides CRUD operations for the Company entity, interfacing with MongoDB.

CustomerRepository: Provides CRUD operations for the Customer entity, interfacing with MongoDB.

CompanyControllerTest: Contains unit tests for the CompanyController class, ensuring proper functionality of its endpoints.

CompanyServiceTest: Contains unit tests for the CompanyService class, validating its business logic and interactions with the database.
