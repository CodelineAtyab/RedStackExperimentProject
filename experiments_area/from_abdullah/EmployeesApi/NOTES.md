# Employees API — #549

## HTTP methods

- GET reads employees without changing the list.
- POST adds an employee using the JSON request body.
- PUT replaces the data of an existing employee.
- DELETE removes one employee, or clears the list after confirmation.
- QUERY reads data using search instructions in a request body without
  requesting a change to the stored data. It is not implemented here.

## Decisions

- Employee IDs are text values supplied by the client.
- A missing ID returns 404 Not Found with a message.
- POST returns 201 Created.
- Successful GET, PUT and DELETE requests return 200 OK.
- PUT keeps the ID from the URL and updates the name.
- Deleting all employees requires the exact query value confirm=true.
- Missing or different confirmation values return 400 without deleting.
- Employees are stored in memory and disappear when the server stops.

## Testing

Not run yet. Record actual Postman requests, statuses and responses here
after testing.

## Blockers

Local build and server testing are pending.