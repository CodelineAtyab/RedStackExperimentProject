

GET: Retrieves employee information from the server.
POST: Creates a new employee. 
PUT: Updates an existing employee.
DELETE: Removes one or more employees.
QUERY:Sends search conditions to find matching information.


If an employee ID does not exist, the server returns 404 Not Found with an error message.

The server only deletes all employees when `confirm=true` is provided. Otherwise, it returns 400 Bad Request and keeps the employees unchanged.

Employees are stored in an ArrayList in memory. No database is used.

No blockers.

Harder than expected: Handling DELETE requests with confirmation and different HTTP status codes.