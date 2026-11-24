# NOTES

## 1. HTTP Status Codes: 201 vs 202

- **201 Created:** This status means a new resource was successfully created.
- **202 Accepted:** This status means the request was accepted, but the processing may not be completed yet.

I used **201 Created** when adding an employee because the employee is added to the list immediately.

**Source:** https://www.rfc-editor.org/rfc/rfc9110.html

## 2. What is ResponseEntity?

ResponseEntity allows us to return a response body together with an HTTP status code.

In this task, I used it to return the correct status for each request:
- `200 OK` when the request is successful.
- `201 Created` when a new employee is added.
- `404 Not Found` when the employee does not exist.

## 3. Stream Filter and Map

- **filter():** Checks a condition and keeps only the items that match it. I used it to find employees with the Developer role.
- **map():** Changes each item into another value. I used it to get employee names from the employee list.

I also combined `filter()` and `map()` to get the names of employees who have the Developer role.

## 4. Blockers

No blockers.

The stream operations were a little challenging at first, especially combining `filter()` and `map()`, but practising them helped me understand how they work.