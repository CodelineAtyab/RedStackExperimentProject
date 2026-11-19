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

## Part 2 — #550

### Decisions

- Missing customers and feedback return 404 with a message.
- Unknown customerId values return 400 on feedback POST and PUT.
- A customer with feedback cannot be deleted: the server returns 409.
- Their feedback must be deleted before deleting the customer.
- PUT keeps the ID from the URL.
- GET /customers/{id}/feedback returns only that customer's feedback.
- Existing customers with no feedback receive an empty array.

### Implementation reference

The Customer model and basic GET/POST structure follow the trainer's
desk-api example. Customer lookup was adapted to return 404.
Customer PUT/DELETE and feedback endpoints were added for Part 2
with AI assistance and should be reviewed and understood before submission.

### Testing

Pending. Replace this section with actual requests, status codes and
responses after running Postman.

### Blockers

Build and endpoint testing are pending.


## ResponseEntity and Streams — #595

### ResponseEntity

ResponseEntity lets the controller return a response body and an
HTTP status together. The service finds or changes employees,
and the controller chooses the response based on the result.

### 201 compared with 202

201 Created means the request succeeded and created a resource.
202 Accepted means the request was accepted, but processing has
not finished yet.

My POST adds the employee immediately, so I use 201 Created.

Source:
https://www.rfc-editor.org/rfc/rfc9110.html#section-15.3.2
https://www.rfc-editor.org/rfc/rfc9110.html#section-15.3.3

### Stream practice

filter keeps the employees that match a condition, such as names
starting with S.

map changes each employee into another value, such as their name.

findFirst returns the first match inside an Optional. I check
whether it contains an employee before using get().

### Existing safeguard

Delete all still requires the exact query value confirm=true.
Without it, the API returns 400 and keeps the employees.

### Testing

Pending: record actual Postman statuses and response bodies here.
Also include the actual output from StreamPractice.

### Blockers

Testing is pending. Record any exact errors here.
After successful testing, replace this with No blockers and one
thing that was harder than expected.