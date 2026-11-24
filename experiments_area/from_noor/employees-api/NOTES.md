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