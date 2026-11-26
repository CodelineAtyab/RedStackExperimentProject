
#HTTP Methods
- GET:Get all employees or one employee by id without changing data only read.
- POST: Add new employee.
- PUT:Update an existing employee by id.
- DELETE: Delete an employee by id or delete all employees when `confirm=true`.


#Missing ID & Delete Confirmation
- If the employee id does not exist the API returns `404 Not Found` with the message `Employee not found` for GET, PUT and DELETE.
- For DELETE /employees, nothing deleted and the API returns `400 Bad Request` unless `?confirm=true` is sent.

#Blockers & Lessons Learned
- No blockers.
- Handling employee ids that do not exist cleanly across GET, PUT and DELETE.
- Tested all actions using Postman and they worked.