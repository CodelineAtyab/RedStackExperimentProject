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
- Feedback deletion returns 204 No Content.

## Testing
- Tested feedback creation, retrieval, update, and deletion using Postman.
- Tested customer-feedback filtering.
- Tested invalid customer IDs and missing records.
- Tested customer deletion protection.

## Copied and Written
- Adapted the trainer's Customer model and GET, POST, and GET-by-ID controller patterns.
- Wrote the Customer PUT and DELETE endpoints.
- Wrote the Feedback model, controller, validation, and customer-feedback relationship.

## Storage
- Data is stored in memory and resets when the application restarts.