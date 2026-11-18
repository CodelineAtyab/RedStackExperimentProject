# Employees API Notes

## HTTP methods

- GET reads employee information from the server.
- POST sends employee data to the server to create an employee.
- PUT replaces the data for the employee ID in the URL.
- DELETE removes one employee or, with confirmation, all employees.
- QUERY reads data using a request body and is designed for safe, repeatable queries. This project does not implement QUERY.

## Postman requests and responses

| Request | Result |
|---|---|
| `POST /employees` with `{"id":"1","name":"Sara"}` | `200 OK` — returned `{"id":"1","name":"Sara"}` |
| `POST /employees` with `{"id":"2","name":"Ali"}` | `200 OK` — returned `{"id":"2","name":"Ali"}` |
| `GET /employees` | `200 OK` — returned both employees as a JSON array |
| `GET /employees/2` | `200 OK` — returned `{"id":"2","name":"Ali"}` |
| `PUT /employees/2` with `{"id":"2","name":"Ali Khan"}` | `200 OK` — returned `{"id":"2","name":"Ali Khan"}` |
| `DELETE /employees/1` | `200 OK` — returned `{"message":"Employee 1 deleted"}` |
| `DELETE /employees` | `400 Bad Request` — returned a confirmation message; no employees deleted |
| `DELETE /employees?confirm=true` | `200 OK` — returned `{"message":"All employees deleted"}` |
| `GET /employees` after deleting all | `200 OK` — returned `[]` |