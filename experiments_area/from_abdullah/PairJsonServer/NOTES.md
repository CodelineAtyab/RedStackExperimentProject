# Notes - Pair JSON and Feedback CRUD

## Spring beans

A bean is an object that Spring creates and manages. The application context
keeps track of these objects. Classes marked with @RestController become
beans when Spring finds them while scanning the application's package.

The Part 1 controller bean is named profileController. Startup prints all
bean names and then: Profile controller bean found: true.

## HTTP methods

- GET reads data. Here GET /feedback returns a JSON list with status 200.
- POST sends a JSON body to add feedback. Here it returns the new item with status 201.
- PUT sends a JSON body to change the message for an existing ID. Here it returns the item with status 200.
- DELETE removes an existing ID. Here it returns a JSON object such as {"deleted":1} with status 200.
- QUERY reads data using a request body without changing the data. It is safe and idempotent, unlike a general POST. GET bodies do not have generally defined meaning. QUERY avoids putting large searches in a URL. It is standardized in RFC 10008, but support depends on the server and client.

QUERY was read about, but the optional endpoint was not implemented.

## Feedback decisions

The JSON keys are id, name and message. The server assigns increasing IDs.
PUT changes only the message and keeps the original name.
Unknown IDs return HTTP 404 for PUT and DELETE.
The list and ID counter reset when the server restarts.
The controller methods are synchronized so simultaneous requests do not change the list at the same time.
No database, API key, login or paid service is needed.

## Partner testing

Partner's GitHub name: not provided yet.

Round 1, this client against a partner's server: pending.
Round 2, a partner's client against this server: pending.

A second computer and partner address were not available for this session.
Testing on localhost is a local check and does not count as both partner rounds.

## Setup blocker fixed

The server's pom.xml and Java files existed but were empty on disk.
The client folder had no project files. The projects could not run in that state.
Both Maven projects now have saved source files and build files.

Actual test results are recorded in TEST_RESULTS.md.
The remaining blocker is arranging the two partner tests.

## Sources

Spring beans and the application context:
https://docs.spring.io/spring-framework/reference/core/beans/introduction.html

Spring REST controllers and JSON:
https://spring.io/guides/gs/rest-service/

HTTP methods:
https://www.rfc-editor.org/rfc/rfc9110.html

QUERY:
https://www.rfc-editor.org/rfc/rfc10008.html

Unirest:
https://kong.github.io/unirest-java/requests/

## JSON request blocker found and fixed during testing

POST initially returned HTTP 400. The server logged:
`JSON parse error: Cannot map null into type int` (the full log used backticks around null and int).

The feedback class had an ID constructor parameter even though requests should not need an ID. Keeping only the no-argument constructor and setters let Spring read the JSON body, and the controller assigns the new ID itself.

After the fix, the Unirest sequence passed. The local Postman CLI collection also passed: 12 requests, 19 assertions, no failures. See TEST_RESULTS.md for the actual requests and results.

Full error detail from the failed POST before the fix:

```text
JSON parse error: Cannot map `null` into type `int` (set `DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES` to 'false' to allow)
```

The class was corrected instead of disabling this setting. POST bodies now need only name and message.
