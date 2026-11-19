# Feedback CRUD and Customer Linking

## Implementation
- Created Customer model and CRUD endpoints.
- Created Feedback model with id, message, and customerId.
- Implemented POST, GET all, GET by ID, PUT, and DELETE for feedback.
- Added GET /customers/{id}/feedback to retrieve feedback by customer.
- Used shared in-memory storage through InMemoryDataStore.

## Validation and Error Handling
- Unknown customerId on feedback creation or update returns 400 Bad Request.
- Missing feedback or customer returns 404 Not Found.
- Customer deletion is refused when feedback exists. The API returns 409 Conflict.
- Feedback deletion returns 200 OK with a confirmation message (changed from 204 No Content when the controllers moved to ResponseEntity).

## Service Layer (#594)
### Why FeedbackService exists
The controller originally held the data list, the loops and the customer validation. That mixed HTTP handling with business logic. FeedbackService now owns the feedback list and the rules (customer must exist, find by ID, update, delete). The controller only translates service results into HTTP responses. CustomerService does the same for customers, including the rule that a customer with feedback cannot be deleted. Benefits: each class has one job, and the logic can be tested without HTTP.

### How @Service and @Autowired work
- @Service marks a class as a Spring-managed bean. At startup Spring scans the package, creates one instance of each @Service class, and keeps it in the application context.
- @Autowired tells Spring to fill a field with a matching bean. In the controllers, `@Autowired private FeedbackService feedbackService;` makes Spring inject the single FeedbackService instance, so the controller never calls `new`.

## ResponseEntity
ResponseEntity represents the whole HTTP response: status code, headers and body. A plain return value always gives 200 OK. With ResponseEntity the controller picks the status per case:
- `ResponseEntity.ok(body)` returns 200.
- `ResponseEntity.status(HttpStatus.CREATED).body(x)` returns 201.
- `ResponseEntity.status(HttpStatus.NOT_FOUND).body(message)` returns 404.
- `ResponseEntity.status(HttpStatus.CONFLICT).body(message)` returns 409.
Every controller method returns ResponseEntity.

## Why POST returns 201 Created, not 202 Accepted
- 201 Created means the request succeeded and the resource now exists. The feedback is added to the list before the response is sent, so 201 is accurate.
- 202 Accepted means the request was received but processing is not finished (for example, queued for later). Nothing here is deferred, so 202 would mislead clients.

## Stream API (Section B)
StreamPractice.java (package `practice`) runs four exercises on a small employee list:
- `filter()` keeps only the elements that match a condition. Example: employees whose role is Developer.
- `map()` transforms each element into another value. Example: Employee to its name.
- `filter()` then `map()` combines both: the names of the Developers only.
- `filter()` then `findFirst()` returns an Optional with the first match. `orElse("not found")` covers the empty case.
Output was checked by running the class: filter returned Alice and Carol, map listed all five names, the combined call returned Alice and Carol, and findFirst returned Alice for Developer and "not found" for Architect.

## Testing
- Tested feedback creation, retrieval, update, and deletion using Postman.
- Tested customer-feedback filtering.
- Tested invalid customer IDs and missing records.
- Tested customer deletion protection.

### Postman results (feedback endpoints, after the service refactor)
| Request | Expected | Result |
|---|---|---|
| POST /feedback (F006, customerId C001) | 201 Created | Pass |
| GET /feedback/F006 | 200 OK | Pass |
| PUT /feedback/F006 | 200 OK | Pass |
| GET /feedback/INVALID | 404 Not Found | Pass |
| PUT /feedback/INVALID | 404 Not Found | Pass |
| DELETE /feedback/F006 | 200 OK | Pass |
| DELETE /feedback/INVALID | 404 Not Found | Pass |
| DELETE /feedback | 200 OK | Pass |

PUT body used: `{"message": "Updated feedback message", "customerId": "C001"}`

### Blockers
- The first POST /feedback returned 400 Bad Request. Cause: customer C001 did not exist, and FeedbackService requires the customer to exist. Fix: create C001 with POST /customers, then repeat the feedback POST, which returned 201. Data is in memory, so after every restart the customer must be created again.

## Copied and Written
- Adapted the trainer's Customer model and GET, POST, and GET-by-ID controller patterns.
- Wrote the Customer PUT and DELETE endpoints.
- Wrote the Feedback model, controller, validation, and customer-feedback relationship.

## Storage
- Data is stored in memory and resets when the application restarts.