# Feedback CRUD and Customer Linking

## Implementation

- Created the Customer model and CRUD endpoints.
- Created the Feedback model with `id`, `message`, and `customerId`.
- Implemented POST, GET all, GET by ID, PUT, and DELETE operations for feedback.
- Added `GET /customers/{id}/feedback` to retrieve feedback belonging to a customer.
- Used shared in-memory storage through `InMemoryDataStore`.

## Validation and Error Handling

- An unknown `customerId` during feedback creation or update returns 400 Bad Request.
- A missing feedback record or customer returns 404 Not Found.
- Customer deletion is refused when feedback exists. The API returns 409 Conflict.
- Feedback deletion returns 200 OK with a confirmation message. This changed from 204 No Content when the controllers moved to using `ResponseEntity`.

## Service Layer (#594)

### Why FeedbackService Exists

The controller originally handled the data list, loops, and customer validation. This mixed HTTP handling with business logic.

`FeedbackService` now manages the feedback list and business rules, including customer validation, searching by ID, updating, and deleting feedback.

`CustomerService` manages customer operations. It also checks whether a customer has feedback before allowing deletion.

This separation gives each class a specific responsibility. It also allows the business logic to be tested without sending HTTP requests.

### How @Service and @Autowired Work

- `@Service` marks a class as a Spring-managed bean. Spring creates and manages an instance of the class in its application context.
- `@Autowired` allows Spring to inject a matching bean into a field or constructor.

In the controllers, field injection is used:

`@Autowired private FeedbackService feedbackService;`

Spring provides the `FeedbackService` instance, so the controller does not need to create it using `new`.

## ResponseEntity

`ResponseEntity` represents an HTTP response. It contains the status code, headers, and response body.

In these controller methods, returning a plain response body uses 200 OK by default. `ResponseEntity` allows the controller to select the appropriate status code for each operation.

- `ResponseEntity.ok(body)` returns 200 OK.
- `ResponseEntity.status(HttpStatus.CREATED).body(x)` returns 201 Created.
- `ResponseEntity.status(HttpStatus.NOT_FOUND).body(message)` returns 404 Not Found.
- `ResponseEntity.status(HttpStatus.CONFLICT).body(message)` returns 409 Conflict.

Every controller method returns `ResponseEntity`.

## Why POST Returns 201 Created, Not 202 Accepted

- 201 Created means the request succeeded and the resource now exists. The feedback is added to the list before the response is sent, so 201 is the correct status.
- 202 Accepted means the request was received, but processing has not finished. This is used when work is queued for later processing. The application does not defer feedback creation