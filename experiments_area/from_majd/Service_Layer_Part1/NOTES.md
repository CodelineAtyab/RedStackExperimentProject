# Service Layer Refactor Notes (#594)

## What a Service Is and Why We Use It
A service is a separate class (annotated with `@Service`) that holds the data and business logic of the application, such as storing the list and searching, adding, updating, or deleting items. We use it so the controller stays thin and only handles incoming web requests and outgoing responses—like a waiter taking orders while the kitchen does the work. Keeping them separate makes the code cleaner, easier to read, and easier to maintain.

## What `@Autowired` Does
`@Autowired` tells Spring to automatically create the service object and inject it into the controller for us. Instead of writing `new ...Service()` manually, Spring manages one shared instance of the service and connects it to the controller automatically.

## Resource Refactored
- **Resource:** `[e.g., Employees / Feedback]`
- **Changes Made:** Moved the in-memory `ArrayList` and all CRUD logic (get all, get by ID, create, update, delete) from `[e.g., EmployeeController.java]` into `[e.g., EmployeeService.java]`, leaving the controller with only endpoint mappings and single-line calls to the service.

## Blockers
- `[Option A — if you hit an error, paste the exact message, e.g.:]`
  - Hit a Git branch case-sensitivity lock error (`error: cannot lock ref`) and accidentally included an unrelated project (`FeedbackCrud`) in an earlier PR, which I fixed by creating a clean branch from `main` with only the `ServiceLayer` project.
- `[Option B — if you had no blockers, keep this instead:]`
  - No blockers. One thing that was harder than expected was keeping every method signature and return value identical to the old controller so all existing Postman requests worked without changes.

## Postman Evidence
*(Postman screenshots are also attached in the Pull Request description/comments.)*

- `POST /[resource]` — Created a new item and returned the saved object (same as before refactor).
- `GET /[resource]` — Returned the full list of items stored in memory.
- `GET /[resource]/{id}` — Returned the matching item by ID.
- `PUT /[resource]/{id}` — Updated the existing item and returned the updated object.
- `DELETE /[resource]/{id}` — Removed the item from the list.