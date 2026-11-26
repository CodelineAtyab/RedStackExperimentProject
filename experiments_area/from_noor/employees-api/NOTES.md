# Service Layer – Task #594

## What is a Service?
A service is a class where we put the logic of our application.
We use it so the controller doesn't have to do everything.


## What does @Autowired do?
@Autowired connects the service to the controller.
Spring creates the service object for us, so we don't need to use new.

## Refactored Resource
I worked on my Employees API from task #549. 
I moved the employee list and CRUD operations from EmployeeController to EmployeeService.

## Testing
- GET all employees – Passed (200 OK)
- POST employee – Tested
- GET employee by ID – Passed (200 OK)
- PUT employee – Tested
- DELETE /employees/1 – 204 No Content
- DELETE /employees – 204 No Content

## Blockers
Maven was not recognized in my terminal (`zsh: command not found: mvn`), so I ran the Spring Boot application using IntelliJ IDEA.

The harder part was understanding how the controller calls the service using @Autowired.
---------------------------------------------------------

## Task #595 - ResponseEntity and Stream Practice

### ResponseEntity

ResponseEntity is used in Spring Boot to return an HTTP status code and a response body.
I updated my EmployeeController methods to use ResponseEntity.

### HTTP Status Codes
200 OK – The request was successful.
201 Created – A new employee was created.
202 Accepted – The request was accepted but may not be completed yet.
404 Not Found – The employee was not found.

The difference between 201 and 202 is that 201 means the resource was created, while 202 means the request was accepted for processing.

### Java Streams
filter() – Selects employees based on a condition.
map() – Gets specific information, like employee names.
findFirst() – Finds the first matching employee.

### Testing
- GET all employees – 200 OK
- GET employee by ID – 200 OK
- GET missing employee – 404 Not Found
- POST employee – 201 Created
- DELETE all employees – 200 OK


### Blockers
The challenging part was understanding when to use different HTTP status codes, especially 201 and 202.
I also needed some time to understand how filter() and map() work together in Java Streams.

### References

https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-methods/responseentity.html?utm_source=chatgpt.com
https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Status