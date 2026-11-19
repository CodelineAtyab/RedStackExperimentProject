# NOTES – Part 2 (Feedback CRUD, customers, link feedback to customer)

Part 1 (#549, Employees API) is already merged. The Employees endpoints still work in this same project.

## My choices
- **Missing id** (customer, feedback: get one, update one, delete one): `404 Not Found` with a JSON message,
  for example `{"message": "No feedback with id zzz exists."}`.
- **Unknown `customerId` when creating or updating feedback:** `400 Bad Request` with a message
  (`Refused: no customer with id nope exists.`). I chose 400 and not 404 because the wrong id is in the JSON body,
  not in the URL, so "the page was not found" would be misleading. Nothing is saved.
- **Deleting a customer who has feedback:** TODO (one line: cascade or refuse with 409, and why)

## What I copied and what I wrote
- **Copied / based on the trainer's example:** the `Customer` model and customer GET all, GET one and POST.
- **Written by me:** customer `PUT /customers/{id}` and `DELETE /customers/{id}`, including the handling of the
  customer's feedback on delete. I used my `EmployeeController` from Part 1 as the template.
- **AI help:** I used an AI assistant (Claude) for the feedback CRUD, the `customerId` check and
  `GET /customers/{id}/feedback`, and to explain the code file by file. I tested everything myself in Postman.

## Test log (Postman, server on http://localhost:8080)

| # | Request | Body | Result |
|---|---|---|---|
| 1 | `POST /customers` | `{"id":"c1","name":"Sara"}` | 201, Sara added |
| 2 | `GET /customers` | – | 200, array with Sara |
| 3 | `GET /customers/c1` | – | 200, Sara |
| 4 | `GET /customers/zzz` | – | 404, "No customer with id zzz exists." |
| 5 | `POST /feedback` | `{"id":"f1","message":"Great service","customerId":"c1"}` | 201, f1 added |
| 6 | `POST /feedback` | `{"id":"f2","message":"Hi","customerId":"nope"}` | 400, refused (no such customer), nothing added |
| 7 | `GET /feedback` | – | 200, only f1 |
| 8 | `GET /feedback/f1` | – | 200, f1 |
| 9 | `GET /customers/c1/feedback` | – | 200, `[f1]` |
| 10 | `PUT /feedback/f1` | `{"id":"f1","message":"Great service, thanks","customerId":"c1"}` | 200, message updated |
| 11 | `PUT /feedback/zzz` | `{"id":"zzz","message":"x","customerId":"c1"}` | 404, message |
| 12 | `DELETE /feedback/f1` | – | 200, f1 removed |
| 13 | `PUT /customers/c1` | `{"id":"c1","name":"Sara Ali"}` | 200, customer updated to Sara Ali |
| 14 | `DELETE /customers/c1` | – | 200, customer removed (f1 was already deleted in row 12) |
| 15 | `PUT /customers/zzz` and `DELETE /customers/zzz` | – | 404, message |
| 16 | `DELETE /customers/{id}` for a customer that still has feedback | – | TODO (result, and what `GET /feedback` showed after) |
| 17 | `GET /employees` | – | 200, Part 1 still works |

## Blockers
- `Customer.java` was incomplete at first (no empty constructor, no getters or setters, and the constructor did not
  store the values), so the project did not compile.
  Error: `cannot find symbol: method getId()` (location: variable c of type org.example.Customer).
  Fix: I added the empty constructor, the getters and setters, and stored the values in the constructor.
- Harder than expected: understanding that Spring needs an empty constructor and getters/setters on a model class
  to turn the JSON body into an object.