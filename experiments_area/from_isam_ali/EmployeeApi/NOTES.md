# NOTES – Part 2 (Feedback CRUD, customers, link feedback to customer)

Part 1 (#549, Employees API) is already merged. The Employees endpoints still work in this same project.

## My choices
- **Missing id** (customer, feedback: get one, update one, delete one): `404 Not Found` with a JSON message,
  for example `{"message": "No feedback with id zzz exists."}`.
- **Unknown `customerId` when creating or updating feedback:** `400 Bad Request` with a message
  (`Refused: no customer with id nope exists.`). I chose 400 and not 404 because the wrong id is in the JSON body,
  not in the URL, so "the page was not found" would be misleading. Nothing is saved.
- **Deleting a customer who has feedback:** TODO (write your choice here: also remove that customer's feedback,
  or refuse the delete with 409 Conflict, and one sentence why)

## What I copied and what I wrote
- **Copied / based on the trainer's example:** TODO (Customer model, customer GET all, GET one, POST)
- **Written by me:** TODO (customer PUT and DELETE, and anything else you wrote yourself)
- **Feedback CRUD, the `customerId` check and `GET /customers/{id}/feedback`:** TODO (say how much was your own work
  and how much came from an AI helper or the trainer)

## Test log (Postman, server on http://localhost:8080)

| # | Request | Body | Result |
|---|---|---|---|
| 1 | `POST /customers` | `{"id":"c1","name":"Sara"}` | 201, customer added |
| 2 | `GET /customers` | – | 200, array with Sara |
| 3 | `GET /customers/1` | – | 200, Sara |
| 4 | `GET /customers/zzz` | – | 404, "No customer with id zzz exists." |
| 5 | `POST /feedback` | `{"id":"f1","message":"Great service","customerId":"c1"}` | 201, feedback added |
| 6 | `POST /feedback` | `{"id":"f2","message":"Hi","customerId":"nope"}` | 400, refused, nothing added |
| 7 | `GET /feedback` | – | 200, only f1 |
| 8 | `GET /feedback/f1` | – | 200, f1 |
| 9 | `GET /customers/1/feedback` | – | 200, only the feedback of c1 |
| 10 | `PUT /feedback/f1` | `{"id":"f1","message":"Great service, thanks","customerId":"c1"}` | 200, message updated |
| 11 | `PUT /feedback/zzz` | `{"id":"zzz","message":"x","customerId":"c1"}` | 404, message |
| 12 | `DELETE /feedback/f1` | – | 200, "Feedback f1 was removed." |
| 13 | `PUT /customers/1` | TODO | TODO |
| 14 | `DELETE /customers/1` | – | TODO (show what happened to the customer's feedback) |
| 15 | `GET /employees` | – | 200, Part 1 still works |

All requests worked as expected. TODO: fix any status code above that was different in your Postman.

## Blockers
- `Customer.java` was incomplete at first (no empty constructor, no getters or setters, and the constructor did not
  store the values), so the project did not compile. I fixed it by adding them.
  TODO: paste the exact error text if you still have it.
- TODO: one thing that was harder than expected, or write `No blockers`.