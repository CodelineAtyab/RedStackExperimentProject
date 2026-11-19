# Employees API — #549

## HTTP methods

- GET reads employees without changing the list.
- POST adds an employee using the JSON request body.
- PUT replaces the data of an existing employee.
- DELETE removes one employee, or clears the list after confirmation.
- QUERY reads data using search instructions in a request body without
  requesting a change to the stored data. It is not implemented here.

## Decisions

- Employee IDs are text values supplied by the client.
- A missing ID returns 404 Not Found with a message.
- POST returns 201 Created.
- Successful GET, PUT and DELETE requests return 200 OK.
- PUT keeps the ID from the URL and updates the name.
- Deleting all employees requires the exact query value confirm=true.
- Missing or different confirmation values return 400 without deleting.
- Employees are stored in memory and disappear when the server stops.

## Testing

Not run yet. Record actual Postman requests, statuses and responses here
after testing.

## Blockers

Local build and server testing are pending.

## Service Layer — #594

### What I changed

I refactored the Employees resource. I moved the employee list,
searching, adding, updating and deleting into EmployeeService,
inside the service package.

EmployeeController now handles the HTTP requests and calls the
matching service method. The URLs, request bodies and responses
remain the same.

### Service and dependency injection

A service is a class that contains the work the application performs.
Keeping this work in EmployeeService makes the controller smaller
and puts the employee logic in one place.

A Spring bean is an object created and managed by Spring.
@Service makes EmployeeService available as a bean, and @Autowired
asks Spring to supply it to EmployeeController. I do not create
EmployeeService with new.

### Testing

Testing status: pending confirmation.

Check these requests and record their actual results:
- POST /employees
- GET /employees
- GET /employees/{id}
- PUT /employees/{id}
- DELETE /employees/{id}
- DELETE /employees?confirm=true
- DELETE /employees without confirmation: 400, nothing deleted
- DELETE /employees?confirm=false: 400, nothing deleted
- GET, PUT and DELETE with a missing ID: 404

### Blockers

Record any errors here, including the exact error message.
If all checks pass, replace this with "No blockers" and describe
one thing that was harder than expected.