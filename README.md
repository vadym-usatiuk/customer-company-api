Some information to highlight:
It exposes a REST GET endpoint /api/customer/{name} to fetch companies based on a passed customer name parameter.
It creates a service method getCompaniesByCustomerName to fetch companies based on customer name.
It exposes a REST POST endpoint /api/customer to add a customer, ensuring that the customer's name is not null and returning an appropriate message if it is.
It includes unit tests for the controller and service methods, covering both positive and negative scenarios.
