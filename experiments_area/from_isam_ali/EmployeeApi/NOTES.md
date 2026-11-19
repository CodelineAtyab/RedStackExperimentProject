# NOTES – Service layer refactor (Part 1, #594)

**Resource refactored:** Employees.

## What a service is and why we use it
A service is a class marked with `@Service` that holds the data and the real logic (find, add, update, delete).
The controller only receives the web request and passes it on, like a waiter handing the order to the kitchen.
We split them so each class has one job, and the logic is in one clear place.

## What `@Autowired` does
It tells Spring: "give me the service object". Spring creates one `EmployeeService` (a bean) and puts it into the
controller field, so I never write `new EmployeeService()`.

## Test log (Postman)
I tested every endpoint in Postman after the refactor. All answers are the same as before the refactor.

| Request | Result |
|---|---|
| `POST /employees` `{"id":"1","name":"Sara"}` | 201, Sara added (same as before) |
| `GET /employees` | 200, JSON array (same as before) |
| `GET /employees/1` and `/employees/999` | 200 Sara; 404 with message (same as before) |
| `PUT /employees/1` `{"id":"1","name":"Sara K"}` | 200, Sara K (same as before) |
| `DELETE /employees/1` and `/employees/999` | 200 removed; 404 with message (same as before) |
| `DELETE /employees` (no confirm) | 400, nothing deleted (same as before) |
| `DELETE /employees?confirm=true` | 200, all removed (same as before) |

## Blockers
TODO: `No blockers` + one thing that was harder than expected, or the exact error text.