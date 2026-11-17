# Feedback CRUD API - #523 local results

Date: 17 November 2026.

Both projects passed mvn clean test-compile with Java 17.
The server printed all bean names and confirmed:
Profile controller bean found: true.

## Postman

Feedback.postman_collection.json was run with the official local Postman CLI,
version 1.90.0. No API key, login or paid service was used.

| Step | Request | JSON body | Result |
| --- | --- | --- | --- |
| 1 | GET /profile?name=Sara | none | 200; name Sara and three favourites |
| 2 | POST /feedback | {"name":"Sara","message":"Great service"} | 201; assigned id 1 |
| 3 | POST /feedback | {"name":"Omar","message":"Helpful staff"} | 201; assigned id 2 |
| 4 | GET /feedback | none | 200; both items |
| 5 | PUT /feedback/1 | {"message":"Great service, thank you"} | 200; changed Sara's message, kept her name |
| 6 | GET /feedback | none | 200; changed message present |
| 7 | DELETE /feedback/1 | none | 200; {"deleted":1} |
| 8 | GET /feedback | none | 200; only Omar left |
| 9 | PUT /feedback/999999 | {"message":"Missing"} | 404 |
| 10 | DELETE /feedback/999999 | none | 404 |
| 11 | DELETE /feedback/2 | none | 200; test cleanup |
| 12 | GET /feedback | none | 200; [] |

12 requests, 19 assertions, 0 failures, exit code 0.
The detailed reports are in target/postman, which is ignored by Git.
The collection can also be imported into the Postman desktop app.

## Unirest

Command inside PairJsonClient:

```powershell
mvn -q exec:java "-Dmain.class=FeedbackClient"
```

Actual output after the Postman run:

```text
Created first (HTTP 201): {"id":3,"message":"Great service","name":"Sara"}
Created second (HTTP 201): {"id":4,"message":"Helpful staff","name":"Omar"}
All feedback (HTTP 200): [{"id":3,"message":"Great service","name":"Sara"},{"id":4,"message":"Helpful staff","name":"Omar"}]
Updated (HTTP 200): {"id":3,"message":"Great service, thank you","name":"Sara"}
After update (HTTP 200): [{"id":3,"message":"Great service, thank you","name":"Sara"},{"id":4,"message":"Helpful staff","name":"Omar"}]
Deleted (HTTP 200): {"deleted":3}
After delete (HTTP 200): [{"id":4,"message":"Helpful staff","name":"Omar"}]
```

The client sends JSON text and reads replies as JSON using Unirest.

## Partner rounds

Partner GitHub name and address have not been provided.
Both directions on two computers remain pending. The tests above were local;
they do not claim to be partner tests. This blocker is also recorded in NOTES.md.
