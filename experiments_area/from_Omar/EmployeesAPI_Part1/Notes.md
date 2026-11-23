# HTTP Status Codes & Stream Practice Notes (#595)

## 201 Created vs. 202 Accepted
- **Choice:** Use `201 Created` for `POST /employees`.
- **Why:** `201 Created` indicates that the request succeeded and a new resource was created immediately as a result. `202 Accepted` means the request was accepted for processing, but processing has not been completed yet (such as asynchronous or queued work).
- **Source:** MDN Web Docs — HTTP response status codes (`201 Created` and `202 Accepted`).

## What `ResponseEntity` Does
`ResponseEntity` wraps both the HTTP status code and the response body (and optional headers) returned by a controller method. Instead of letting Spring always default to `200 OK`, it lets the controller explicitly return statuses like `201 Created` or `404 Not Found` along with clear data or error messages.

## Stream `filter` and `map`
- **`filter`:** Evaluates a predicate on each element in a stream and keeps only the elements that match the condition without modifying the original collection.
- **`map`:** Transforms each element in a stream into a new value or type (such as extracting a single field) while producing a stream of the transformed results.

## Postman Verification (with Status Codes)
1. `POST /employees` (`{"id":"1","name":"Sara","role":"Developer"}`) -> `201 Created`
2. `GET /employees/1` -> `200 OK`
3. `PUT /employees/1` (`{"id":"1","name":"Sara K","role":"Developer"}`) -> `200 OK`
4. `GET /employees/99` -> `404 Not Found` (`"Employee 99 not found"`)
5. `DELETE /employees/1` -> `200 OK` (`"Employee 1 deleted"`)
6. `GET /employees/1` -> `404 Not Found`
7. `DELETE /employees/1` -> `404 Not Found`

## Blockers
- No blockers.
- **Harder than expected:** Ensuring every missing-ID path (`GET /{id}`, `PUT /{id}`, `DELETE /{id}`) safely handles an empty `Optional` and returns a clean `404 Not Found` with a message instead of throwing an unhandled exception.