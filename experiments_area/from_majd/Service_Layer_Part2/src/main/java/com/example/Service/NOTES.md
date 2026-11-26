# Notes — Service Layer (Part 2): ResponseEntity, Status Codes, and Streams (#595)

## 201 Created vs. 202 Accepted
- **201 Created** means the server finished creating the new item right away and tells you where to find it. That fits our `POST` endpoint because the item is added to memory immediately.
- **202 Accepted** means the server got the request and will deal with it later in the background, which does not match our instant create behavior.
- **Where I read this:** MDN Web Docs (HTTP response status codes `201 Created` and `202 Accepted`) and the official Spring `HttpStatus` documentation.

## What `ResponseEntity` Does (In My Own Words)
`ResponseEntity` lets a controller method send back both the response data (like an employee, a list, or a short message) and the exact HTTP status code (like `200`, `201`, or `404`), instead of letting Spring always send `200 OK`.

## Stream `filter` and `map`
- **`filter`:** Keeps only the items from a stream that pass a yes-or-no check.
- **`map`:** Turns each item in a stream into something else, such as pulling one field (like a name) out of every object.

## Blockers / What Was Harder Than Expected
- **Blockers:** No blockers. *(If you hit any error while working, paste the exact error message here instead.)*
- **Harder than expected:** Checking safely when an item is missing (like during `GET` by id or `DELETE` by id) so a missing id returns a clean `404` message instead of crashing with an error.