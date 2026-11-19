# NOTES – Employees API (Part 1, Closes #549)

## HTTP methods in my own words
- **GET**: asks the server to send me data; it only reads and changes nothing, and has no body.
- **POST**: sends a new thing (JSON body) to the server so it creates it; usually returns `201 Created` (or `200`) with the new item.
- **PUT**: sends a full JSON body to replace an existing item at a known address (`/employees/2`); returns `200 OK` with the updated item.
- **DELETE**: removes the item at that address (or, with my confirmation rule, all items); usually has no body and returns `200`/`204`.
- **QUERY** (reading only): a newer proposed method (IETF HTTP working group) that, like GET, only reads data and changes nothing, but can carry a body. It was proposed because long or complex searches do not fit well in a GET URL, and people misused POST for them, but POST is not "safe/repeatable" so caches and clients cannot treat it as a read. Please double-check the current status of the proposal (draft vs. finished standard) before the review.

## Choice for a missing `id`
GET one, PUT and DELETE one answer with `404 Not Found` and a JSON message, e.g. `{"message":"Employee with id 99 not found"}`, instead of crashing.

## Other choices
- POST returns `201 Created` with the employee.
- PUT keeps the `id` from the URL, even if the body has a different `id`.
- DELETE all without `confirm=true` (missing or any other value) deletes nothing and returns `400 Bad Request` with a message.
- POST does not check for duplicate ids (no validation required in this task).


