# NOTES – Ticket #594 (Service layer, Part 1)

**Resource refactored:** Employees

**What a service is and why we use it:** A service is a class marked with `@Service` that holds the
real logic and the data (here the in-memory list of employees). We use it so the controller only
handles web requests and the logic lives in one clear place. Like a restaurant: the controller is
the waiter (takes the request, brings the answer) and the service is the kitchen (does the work).

**What `@Autowired` does:** It tells Spring "give me the service object". Spring creates one
`EmployeeService` (a bean) at startup and injects it into the controller (dependency injection),
so I never write `new EmployeeService()`.


## Postman checks (must be the same as before the refactor)
| Request | Body | Expected response |
|---|---|---|
| POST /employees | {"id":"1","name":"Mohammed","role":"Dev"} | 201, the employee |
| GET /employees | – | 200, [Mohammed] |
| GET /employees/1 | – | 200, Mohammed |
| GET /employees/99 | – | 404, "Employee with id 99 not found" |
| PUT /employees/1 | {"name":"Mohammed K","role":"Lead"} | 200, updated employee |
| PUT /employees/99 | {"name":"X","role":"Y"} | 404 |
| DELETE /employees/1 | – | 200, "Employee with id 1 was deleted" |
| DELETE /employees/99 | – | 404 |
| DELETE /employees | – | 400, "Nothing deleted..." |
| DELETE /employees?confirm=true | – | 200, "All employees deleted (N removed)" |

## Submission details
- Author: Mohammed
- Folder: `experiments_area/from_mohammed/<project-name>/`
- Branch: `feature/594-mohammed-service-layer`
- PR: `Closes #594`