# NOTES – Status codes with ResponseEntity (Part 2, #595)

**Resource:** Employees (same project as #594).

## 201 vs 202
- `201 Created` means the request worked and a new resource was created. This is what POST does here,
  because the employee is added to the list immediately.
- `202 Accepted` means the request was received but will be processed later, which is not our case.
- My choice: **201 Created**.
- Source: TODO (write the page you read, for example RFC 9110 section 15.3 "Successful 2xx", or MDN "HTTP response status codes")

## What `ResponseEntity` does
It lets the controller return the body and the status code together, for example the employee with 201,
or the text "Employee 99 not found" with 404. Without it Spring always answers 200.

## filter and map
- **filter:** keeps only the items that match a condition (for example employees whose role is "Developer").
- **map:** turns every item into something else (for example an employee into its name).

## Design notes
- The service returns `Optional` (get one, update) or `boolean` (delete one) and does not know about HTTP.
  The controller checks `isPresent()` and decides 200 or 404, so a missing id gives a clean 404 and no crash.
- Delete all still needs `?confirm=true` from #549 and answers 400 without it.
- The 404 and delete answers are now plain text messages (not JSON objects).

## Postman Verification (with Status Codes)
1. `POST /employees` (`{"id":"1","name":"Sara","role":"Developer"}`) -> `201 Created`
2. `GET /employees/1` -> `200 OK`
3. `PUT /employees/1` (`{"id":"1","name":"Sara K","role":"Developer"}`) -> `200 OK`
4. `GET /employees/99` -> `404 Not Found` (`"Employee 99 not found"`)
5. `DELETE /employees/1` -> `200 OK` (`"Employee 1 deleted"`)
6. `GET /employees/1` -> `404 Not Found`
7. `DELETE /employees/1` -> `404 Not Found`

## Postman Verification (earlier endpoints, behaviour unchanged)
Re-tested all `/employees` endpoints sequentially after the refactor and confirmed behaviour remained unchanged:
1. `POST /employees` (created employees)
2. `GET /employees` (returned all employees)
3. `GET /employees/{id}` (returned matching employee / handled missing id)
4. `PUT /employees/{id}` (updated matching employee / handled missing id)
5. `DELETE /employees/{id}` (deleted matching employee / handled missing id)
6. `DELETE /employees` and `DELETE /employees?confirm=true` (enforced the confirmation flag and cleared the list when confirmed)

## Section B output (`StreamPractice`)
```
--- Task 1: developers ---
Sara
Ali
--- Task 2: all names ---
[Sara, Ali, Noor]
--- Task 3: developer names ---
[Sara, Ali]
--- Task 4: find by id ---
id 2 -> Ali
id 99 -> not found
```

## Blockers
**Harder than expected:** Moving every endpoint's list lookup, update, and delete logic cleanly out of `EmployeeController` into `EmployeeService` while keeping controller method signatures and behavior identical.
- **Harder than expected:** Ensuring every missing-ID path (`GET /{id}`, `PUT /{id}`, `DELETE /{id}`) safely handles an empty `Optional` and returns a clean `404 Not Found` with a message instead of throwing an unhandled exception.