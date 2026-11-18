# NOTES – Employees API (Part 1)

## The five methods in my own words
- **GET:** TODO 
- **POST:** TODO
- **PUT:** TODO
- **DELETE:** TODO
- **QUERY:** TODO (reading only: why was it proposed, how is it different from GET and POST?)

## Missing id
Get one, update one and delete one answer with `404 Not Found` and a JSON message
`{"message": "No employee with id X exists."}`.

## Delete all
Without `confirm=true` nothing is deleted and the server answers `400 Bad Request` with a clear message.

## Test log (Postman and browser, server on localhost:8080)

| # | Request | What I did | Result |
|---|---|---|---|
| 1 | `POST /employees` | Added several employees as JSON (ids 1, 2, 3 and more later) | Employees were added |
| 2 | `GET /employees` | Called it in the browser and Postman | Returned a valid JSON array (`[]` when empty, the employees after POST) |
| 3 | `GET /employees/4` | Asked for an existing id | Returned Omar |
| 4 | `GET /employees/5` | Asked for an id that does not exist | Returned the message "No employee with id 5 exists." |
| 5 | `PUT /employees/1` | Updated the role of employee 1 | Role changed |
| 6 | `DELETE /employees/{id}` | Deleted one employee | Only that employee was removed |
| 7 | `PUT /employees/999` | Missing id | Message that the employee does not exist |
| 8 | `DELETE /employees/999` | Missing id | Message that the employee does not exist |
| 9 | `DELETE /employees` | Delete all without `confirm` | Message "Nothing was deleted" |
| 10 | `DELETE /employees?confirm=true` | Delete all with confirm | All employees were deleted |

TODO: add the status code (404, 400, 200) next to rows 4, 7, 8, 9 and 10 from the Postman status bar.

## Things I noticed
- POST does not check for duplicate ids. I added two employees with `"id": "1"` and both were stored.
  No validation was required for this task, so I left it as it is.

## Blockers
TODO: `No blockers` + one thing that was harder than expected, or the exact error text.