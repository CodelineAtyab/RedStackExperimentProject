# NOTES.md

## HTTP Methods Summary
- **GET**: Retrieves a resource from the server without modifying its state. It is safe and idempotent, and does not carry a request body.
- **POST**: Submits data to create a new resource on the server. It is not idempotent and carries a request body.
- **PUT**: Replaces an existing resource entirely or creates it if it does not exist. It is idempotent and carries a request body.
- **DELETE**: Removes a specific resource from the server. It is idempotent and typically does not require a request body.
- **QUERY**: A newly proposed HTTP method that, like GET, is used for safe, read-only data retrieval, but unlike GET, it can carry a request body (useful for complex search payloads).

## Missing ID Behavior
- For `GET /employees/{id}`, `PUT /employees/{id}`, and `DELETE /employees/{id}`, if the requested `id` does not exist in the in-memory list, the server returns a `404 Not Found` status code along with a clear error message in the response body.

## Blockers
- No blockers.