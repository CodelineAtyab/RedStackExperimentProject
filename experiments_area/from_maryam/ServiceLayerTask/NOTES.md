About the Task:

Use Controller and Service.
The purpose of Service Layer Refactoring is to separate request handling from business logic. 
The Controller receives and forwards request  while the Service performs the required operations

Created EmployeeService to handle employee operations.
Moved employee logic from EmployeeController to EmployeeService.
Used @Service and @Autowired for dependency injection.
Kept the Controller responsible for handling HTTP requests.

....................... 

Postman Testing
I tested all six Employee API endpoints after the refactoring:

Created a new employee using POST.
Retrieved all employees using GET.
Retrieved one employee by ID.
Updated an employee using PUT.
Deleted one employee using DELETE. 
Deleted all employees using DELETE with confirm=true.
All endpoints were tested in Postman, and the results were as expected.