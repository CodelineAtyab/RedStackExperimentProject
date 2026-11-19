# Employees REST API Notes (#549)

## HTTP Methods & Query Theory
- **GET:** Requests a representation of a resource from the server without modifying its state and does not carry a request body.
- **POST:** Submits new data to the server to create a new resource, typically carrying a request body.
- **PUT:** Updates or replaces an existing target resource entirely using data provided in the request body.
- **DELETE:** Removes a specified resource or collection from the server.
- **QUERY:** A proposed HTTP method intended for reading data like GET, but designed to safely carry a request body containing complex search filters.

## Design Decisions
- **Missing ID Behavior:** For GET one (`/employees/{id}`), PUT (`/employees/{id}`), and DELETE one (`/employees/{id}`), if the employee ID does not exist in the in-memory list, the server responds with status `404 Not Found` and a clear message rather than crashing.
- **Delete All Protection:** The bulk delete endpoint (`/employees`) requires the query parameter `?confirm=true`. If missing or false, it halts execution and returns `400 Bad Request` to prevent accidental data wipes.

## Testing Results (Postman)
- Tested all six actions sequentially:
  1. `POST /employees` (Created employee 1 and 2)
  2. `GET /employees` (Retrieved all)
  3. `GET /employees/2` (Retrieved single employee)
  4. `PUT /employees/2` (Updated single employee data)
  5. `DELETE /employees/1` (Removed single employee)
  6. `DELETE /employees` (Blocked with 400 when missing confirm parameter)
  7. `DELETE /employees?confirm=true` (Successfully wiped remaining list)

## Blockers
- No blockers.
- **Harder than expected:** Properly handling validation logic for the query parameter (`confirm=true`) and ensuring HTTP status codes like `400 Bad Request` and `404 Not Found` returned cleanly through `ResponseEntity`.