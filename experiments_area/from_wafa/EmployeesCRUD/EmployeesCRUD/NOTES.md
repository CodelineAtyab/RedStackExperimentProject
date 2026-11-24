
- Missing ID:Returns `404 Not Found` with a clear message (`Customer not found`, `Feedback not found`, or `Employee not found`).
- Unknown `customerId` Refuses `POST` and `PUT` on `/feedback` with `404 Not Found` (`Customer not found`).
- Deleting a customer with feedback: Removes the customer and automatically deletes all their linked feedback.

    - `CustomerController`: `PUT`, `DELETE` (with feedback cleanup), and `GET /customers/{id}/feedback`.
    - `Feedback` model and full `FeedbackController` CRUD with `customerId` validation.
    - `Employee` model and `EmployeeController` CRUD from Part 1 (`#549`).

#Blockers & Lessons Learned
- No blockers.
- Sharing the in-memory lists between `CustomerController` and `FeedbackController` without a database.