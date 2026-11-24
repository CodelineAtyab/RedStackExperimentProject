# Feedback CRUD & Customer Link Notes (#550)

## Design Decisions
- **Missing ID Behavior:** For any GET one, PUT, or DELETE request on customers or feedback, a missing ID results in a `404 Not Found` response status.
- **Unknown Customer ID Validation:** When creating feedback (`POST /feedback`), the server verifies if the `customerId` exists in the `DataStore`. If it does not exist, the request is rejected with `400 Bad Request`.
- **Customer Deletion Behavior:** When a customer is deleted (`DELETE /customers/{id}`), the server automatically performs a cascade delete, removing all feedback items tied to that customer to prevent orphaned records.
- **Copied vs. Written:** Copied the trainer's base `Customer` model and initial GET/POST controller methods. Wrote customer PUT, customer DELETE, all feedback CRUD endpoints, customer existence checks, and the nested `/customers/{id}/feedback` endpoint by hand.

## Testing Sequence (Postman)
1. `POST /customers` (Created customer `c1` - Sara)
2. `POST /feedback` (Created feedback `f1` linked to `c1`)
3. `POST /feedback` (Attempted creation with unknown `nope` customer ID -> verified `400 Bad Request`)
4. `GET /customers/c1/feedback` (Retrieved feedback list for `c1`)
5. `PUT /feedback/f1` (Updated feedback message)
6. `PUT /customers/c1` (Updated customer name)
7. `DELETE /feedback/f1` (Removed specific feedback)
8. `DELETE /customers/c1` (Removed customer and cascaded removal of their feedback)

## Blockers
- No blockers.
- **Harder than expected:** Managing cross-controller data sharing using an in-memory `@Service` (`DataStore`) so that feedback validation could correctly inspect the customer list without a database.