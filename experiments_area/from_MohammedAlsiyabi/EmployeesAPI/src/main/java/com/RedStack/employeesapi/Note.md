# NOTES – Ticket #595 (Status codes with ResponseEntity, Part 2)

Part 1 (#594) is the base: the logic is in `EmployeeService` (`@Service`) and injected with `@Autowired`.

## 201 vs 202
I checked this myself. **202 Accepted** means "I received the request and will process it later".
That is not our case, because the employee is added to the list immediately. **201 Created** means
"the request worked and a new resource was created", so create returns **201**.
Source: RFC 9110 (HTTP Semantics), section 15.3.2 (201 Created) and 15.3.3 (202 Accepted), and the
MDN page "HTTP response status codes" (developer.mozilla.org).

## What ResponseEntity does
`ResponseEntity<T>` lets me return the body and the HTTP status code together, for example
`ResponseEntity.ok(employee)` for 200 or `ResponseEntity.status(HttpStatus.CREATED).body(employee)` for 201.

## filter and map
- `filter` keeps only the items that match a condition.
- `map` turns every item into something else, for example an employee into its name.

## Design
The service returns `Optional<Employee>` (empty = not found) and `boolean` for delete. The controller
turns that into 200 or 404. Delete checks first, so a missing id gives a clean 404 and no crash.


## Postman / terminal results (status of every response)
| # | Request | Expected status |
|---|---|---|
| 0 | GET /employees (empty) | 200, [] |
| 1 | POST /employees {"id":"1","name":"Mohammed","role":"Developer"} | 201 |
| 2 | GET /employees/1 | 200 |
| 3 | PUT /employees/1 {"name":"Mohammed K","role":"Lead"} | 200 |
| 4 | GET /employees/99 | 404 "Employee 99 not found" |
| 5 | PUT /employees/99 | 404 |
| 6 | DELETE /employees/1 | 200 "Employee 1 deleted" |
| 7 | GET /employees/1 | 404 |
| 8 | DELETE /employees/1 | 404 |
| 9 | POST /employees {"id":"2","name":"Ali","role":"Tester"} | 201 |
| 10 | DELETE /employees | 200 "All employees deleted (1 removed)" |
| 11 | GET /employees | 200, [] |

## Section B output (StreamPractice)
```
--- Task 1: developers ---
Mohammed (Developer)
Ali (Developer)
--- Task 2: all names ---
[Mohammed, Ali, Omar]
--- Task 3: developer names ---
[Mohammed, Ali]
--- Task 4: find by id ---
id 2 -> Ali
id 99 -> not found
```

## Submission details
- Folder: `experiments_area/from_mohammed/EmployeesAPI`
- Branch: `feature/595-mohammed-status-codes`
- PR: `Closes #595` and mention #594 as Part 1