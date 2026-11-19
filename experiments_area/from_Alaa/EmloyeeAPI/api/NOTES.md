# NOTES – Employee API (#549)

## 1. Implementation Overview

I implemented the Employee API using Spring Boot. The controller supports the following operations:

- **POST `/employees`** – Add a new employee.
- **GET `/employees`** – Retrieve all employees.
- **GET `/employees/{id}`** – Retrieve an employee by ID.
- **PUT `/employees/{id}`** – Update an employee's name using their ID.
- **DELETE `/employees/{id}`** – Delete an employee using their ID.
- **DELETE `/employees?confirm=true`** – Delete all employees, requiring explicit confirmation.

## 2. Handling Missing Employees

For GET, PUT, and DELETE operations involving a specific employee ID, I used Java Streams with `filter()` and `findFirst()` to search for the employee.

If no matching employee is found, the API returns a **404 Not Found** response with an appropriate error message using Spring's `ResponseStatusException`.

I chose this approach to keep the original method return types (`Employee` and `String`) while still handling HTTP error statuses correctly.

## 3. Delete All Confirmation

The DELETE endpoint for removing all employees requires a confirmation query parameter.

- When `confirm=true` is provided, all employees are removed.
- When the parameter is missing or set to `false`, nothing is deleted and the API returns **400 Bad Request** with a clear message.

I used `@RequestParam` with a default value of `false` to handle this requirement.

## 4. Challenges and Learning

During this task, I struggled a little with Java Streams syntax, particularly understanding how `filter()` and `findFirst()` work together to retrieve a specific employee from the list.

I also needed to understand how Spring Boot handles HTTP response statuses, especially how to return a 404 response when an employee cannot be found.

I researched these concepts using online resources and used AI assistance to help me understand the syntax, explore possible solutions, and resolve implementation issues.

Through this task, I gained a better understanding of:
- Java Streams and filtering collections.
- Using `@PathVariable` and `@RequestParam`.
- Handling missing resources.
- HTTP response status codes, particularly 200, 400, and 404.
- Implementing REST API endpoints in Spring Boot.



