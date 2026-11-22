Employee API -- Notes
Purpose
Separate the application into three parts: - Model: represents
employee data. - Controller: receives HTTP requests and calls the
service. - Service: stores the employee list and handles employee
operations.
Important Annotations
- @Service: marks a class as a Spring-managed service.
- @Autowired: injects the service into the controller.
- @RestController: marks a class as a REST controller.
- @RequestMapping: defines the controller's base URL.
- @GetMapping: handles GET requests.
- @PostMapping: handles POST requests.
- @PutMapping: handles PUT requests.
- @DeleteMapping: handles DELETE requests.
- @PathVariable: reads a value from the URL.
- @RequestBody: reads JSON from the request body.
  Important Concepts
- The controller should delegate operations to the service.
- The service contains the logic for getting, adding, updating, and
  deleting employees.
- Optional<Employee> represents an employee that may or may not be
  found.
- Optional.empty() means no matching employee was found.
- @RequestBody is needed to bind incoming JSON to an object.
- @PathVariable is used when the ID is included in the URL.
  Postman Endpoints
  Operation              Method   URL
  Get all employees      GET      /employees
  Get one employee       GET      /employees/{id}
  Add an employee        POST     /employees
  Update an employee     PUT      /employees/{id}
  Delete one employee    DELETE   /employees/{id}
  Delete all employees   DELETE   /employees
  Reminder
  The employees are currently stored in an ArrayList, so the data is
  lost when the application restarts. It is not stored in a database.