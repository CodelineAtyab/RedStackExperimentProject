# Local test results - 17 November 2026

## Build

PairJsonServer: mvn clean test-compile passed with Java 17.
PairJsonClient: mvn clean test-compile passed with Java 17.

## Spring beans

ServerApplication printed the bean names from the running context.
Observed final line: Profile controller bean found: true.

## Profile client

With localhost:8080 and name Sara:

```text
Name: Sara
1 - Coffee
2 - Books
3 - Football
```

Changing the name argument to Abdullah printed Name: Abdullah.
Connecting to localhost:65534 printed:
Could not reach the server. Check its address and port.

## Feedback client (Unirest)

Actual run after the server fix:

```text
Created first (HTTP 201): {"id":2,"message":"Great service","name":"Sara"}
Created second (HTTP 201): {"id":3,"message":"Helpful staff","name":"Omar"}
All feedback (HTTP 200): [{"id":2,"message":"Great service","name":"Sara"},{"id":3,"message":"Helpful staff","name":"Omar"}]
Updated (HTTP 200): {"id":2,"message":"Great service, thank you","name":"Sara"}
After update (HTTP 200): [{"id":2,"message":"Great service, thank you","name":"Sara"},{"id":3,"message":"Helpful staff","name":"Omar"}]
Deleted (HTTP 200): {"deleted":2}
After delete (HTTP 200): [{"id":3,"message":"Helpful staff","name":"Omar"}]
```

The remaining test entry was removed before running the Postman collection.

## Postman collection

Executed Feedback.postman_collection.json using Postman's official local CLI
(version 1.90.0), not the desktop GUI. No Postman API key or account was used.

| Order | Request | Body or check | Observed result |
| --- | --- | --- | --- |
| 1 | GET /profile?name=Sara | Profile and three favourites | 200; passed |
| 2 | POST /feedback | {"name":"Sara","message":"Great service"} | 201; saved ID 4 |
| 3 | POST /feedback | {"name":"Omar","message":"Helpful staff"} | 201; saved ID 5 |
| 4 | GET /feedback | Two entries | 200; count 2 |
| 5 | PUT /feedback/4 | {"message":"Great service, thank you"} | 200; changed message, kept Sara |
| 6 | GET /feedback | Changed entry exists | 200; passed |
| 7 | DELETE /feedback/4 | Deleted ID | 200; deleted 4 |
| 8 | GET /feedback | One entry left | 200; count 1 |
| 9 | PUT /feedback/999999 | {"message":"Missing"} | 404 |
| 10 | DELETE /feedback/999999 | Missing ID | 404 |
| 11 | DELETE /feedback/5 | Cleanup | 200 |
| 12 | GET /feedback | Empty list | 200; count 0 |

Result: 12 requests, 19 assertions, 0 failures, exit code 0.
Detailed local reports are under target/postman and are ignored by Git.
This table can be copied into the PR as the written request/response list.

## Partner rounds

Not tested on a second computer. Partner's GitHub name and server address
have not been provided. These local checks do not claim to be partner tests.

## Changed server data check

A temporary copy of the server was run on localhost:8081 with Coffee changed to Tea. The same ProfileClient, with server address localhost:8081 and name Abdullah, printed:

```text
Name: Abdullah
1 - Tea
2 - Books
3 - Football
```

This verifies the client reads the server's values. The saved project keeps Coffee and the normal server stays on port 8080. This was still a same-computer check, not a partner round.
