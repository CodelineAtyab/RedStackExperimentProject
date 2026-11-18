# NOTES

- **GET:** Reads an employee or the full employee list without changing it.
- **POST:** Sends a JSON body to create a new employee; this API returns HTTP 201 Created.
- **PUT:** Sends a JSON body to replace an existing employee; this API returns HTTP 200 OK.
- **DELETE:** Removes an employee or, with explicit confirmation, all employees; this API returns HTTP 200 OK.
- **QUERY:** A proposed safe HTTP method for retrieving data with a request body, useful when complex search criteria do not fit conveniently in a GET URL; unlike POST it is defined as safe and unlike GET it permits a request body with defined semantics. It is not implemented here.

## Missing ID decision
GET, PUT, and DELETE on a nonexistent employee id return HTTP 404 Not Found and a JSON `message` field.