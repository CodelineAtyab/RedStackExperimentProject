# Service Layer Refactor Notes (#594)

## What a Service Is & Why We Use It
A service class (`EmployeeService`) annotated with `@Service` holds the in-memory data list and the business/CRUD logic for a resource. Separating it from the controller keeps the HTTP routing layer (`EmployeeController`) thin and focused only on receiving requests and returning responses. Putting the logic in one dedicated class also makes the code easier to read, maintain, and extend in later tasks.

## What `@Autowired` Does
`@Autowired` tells Spring to automatically inject the single `@Service`-managed `EmployeeService` bean into `EmployeeController` instead of me manually creating an instance with `new EmployeeService()`. That way Spring manages the object lifecycle and wires the dependency for me.

## Refactored Resource
- **Resource:** `Employees` (from #549)
- **Service Class:** `org.example.service.EmployeeService`
- **Controller Class:** `org.example.EmployeeController` (thin methods delegating in one line to `employeeService`)

## Postman Verification
Re-tested all `/employees` endpoints sequentially after the refactor and confirmed behavior remained unchanged:
1. `POST /employees` (Created employees)
2. `GET /employees` (Returned all employees)
3. `GET /employees/{id}` (Returned matching employee / handled missing ID)
4. `PUT /employees/{id}` (Updated matching employee / handled missing ID)
5. `DELETE /employees/{id}` (Deleted matching employee / handled missing ID)
6. `DELETE /employees` & `DELETE /employees?confirm=true` (Enforced confirmation flag and cleared list when confirmed)

## Blockers
- No blockers.
- **Harder than expected:** Moving every endpoint's list lookup, update, and delete logic cleanly out of `EmployeeController` into `EmployeeService` while keeping controller method signatures and behavior identical.