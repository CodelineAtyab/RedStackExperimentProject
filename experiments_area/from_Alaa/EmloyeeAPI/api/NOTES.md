# NOTES: Employee API (#549)

## 1. Implementation Overview

I implemented the Employee API using Spring Boot. The code is split into two layers:

- **Controller (`EmployeeControllers`)**: receives HTTP requests, validates request parameters, and returns responses.
- **Service (`EmployeesServices`)**: stores the employee list and contains the logic for adding, finding, updating, and deleting employees.

The controller supports the following operations:

- **POST `/employees`**: Add a new employee.
- **GET `/employees`**: Retrieve all employees.
- **GET `/employees/{id}`**: Retrieve an employee by ID.
- **PUT `/employees/{id}`**: Update an employee's name using their ID.
- **DELETE `/employees/{id}`**: Delete an employee using their ID.
- **DELETE `/employees?confirm=true`**: Delete all employees, requiring explicit confirmation.

## 2. Service Layer Refactor

At first, the employee list and all the logic lived inside the controller. I moved them into `EmployeesServices`, which is annotated with `@Service`. The controller gets it through `@Autowired` and calls its methods, for example `employeeService.getAllEmployees()`.

After the move, the `employees` list is private to the service. The controller no longer touches it directly. Each endpoint is now one line that calls a service method.

## 3. Handling Missing Employees

The search for a specific employee now lives in one method, `getEmployeeById`, in the service. It uses Java Streams with `filter()` and `findFirst()`.

If no matching employee is found, it throws Spring's `ResponseStatusException` with **404 Not Found** and the message "Employee not found". The update and delete methods call `getEmployeeById` instead of repeating the same stream search, so the 404 logic exists in only one place.

I chose `ResponseStatusException` to keep the original method return types (`Employee` and `String`) while still returning the correct HTTP status.

## 4. Delete All Confirmation

The DELETE endpoint for removing all employees requires a confirmation query parameter.

- When `confirm=true` is provided, all employees are removed.
- When the parameter is missing or set to `false`, nothing is deleted and the API returns **400 Bad Request** with a clear message.

I used `@RequestParam` with a default value of `false`. The confirmation check stays in the controller because it validates the HTTP request. The service only clears the list through `deleteAllEmployees()`.

## 5. Challenges and Learning

During this task, I struggled a little with Java Streams syntax, particularly understanding how `filter()` and `findFirst()` work together to retrieve a specific employee from the list.

I also needed to understand how Spring Boot handles HTTP response statuses, especially how to return a 404 response when an employee cannot be found. Moving the logic into a service also made me work out which code belongs in the controller and which belongs in the service.

I researched these concepts using online resources and used AI assistance to help me understand the syntax, explore possible solutions, and resolve implementation issues.

Through this task, I gained a better understanding of:

- Java Streams and filtering collections.
- Using `@PathVariable` and `@RequestParam`.
- Handling missing resources.
- HTTP response status codes, particularly 200, 400, and 404.
- Implementing REST API endpoints in Spring Boot.
- Separating controller and service responsibilities.
- Using `@Service` and `@Autowired` to inject a service into a controller.

## 6. Git and Troubleshooting

While pushing my changes to the remote repository, I encountered a Git synchronization issue because the remote branch had changes that were not present in my local branch.

I resolved this by using:

```bash
git pull --rebase origin feature/549-alaa-EmloyeeAPI-Part1
```

This fetched the latest changes from the remote branch and rebased my local commits on top of them, allowing me to synchronize my branch before pushing my changes again.

This helped me understand how Git rebase works and how to resolve synchronization issues when working with remote branches.

## 7. Testing Evidence

To be found in /api/Results