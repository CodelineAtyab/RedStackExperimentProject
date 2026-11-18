## Postman testing (server on http://localhost:8080)

### 1. Create one: POST /employees
- Sent JSON bodies like `{"id":"1","name":"Essam","role":"Developer"}`
- Result: the employee was added. I added several (ids 1, 2, 3 and more).

### 2. Get all: GET /employees
- Result: returned a valid JSON array.
- Empty list returned `[]`. After POST it returned all the employees.

### 3. Get one: GET /employees/1
- `GET /employees/4` returned Omar.
- `GET /employees/5` (does not exist) returned the message "No employee with id 5 exists."

### 4. Update one: PUT /employees/1
- `PUT /employees/1` with a new role: the role of employee 1 changed.
- `PUT /employees/999` (does not exist): message that the employee does not exist.

### 5. Delete one: DELETE /employees/{id}
- Deleted one employee: only that employee was removed.
- `DELETE /employees/999` (does not exist): message that the employee does not exist.

### 6. Delete all: DELETE /employees?confirm=true
- `DELETE /employees` (no confirm): message "Nothing was deleted".
- `DELETE /employees?confirm=true`: all employees were deleted.

### Notes
- Missing id gives a clear JSON message and 404 instead of a server crash.
- POST does not check for duplicate ids (I stored two employees with id "1").