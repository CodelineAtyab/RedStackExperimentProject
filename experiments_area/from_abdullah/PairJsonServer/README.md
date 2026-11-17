# Feedback CRUD API - #523

Java 17. Part 2 continues the profile server and client from #522 (PR #531). This branch adds feedback CRUD and bean listing. While #531 is open, use its branch as the PR base; after it merges, retarget this PR to main.
Partner tests still need two computers.

## Start the server

Open a terminal inside PairJsonServer:

```powershell
mvn clean test-compile
mvn spring-boot:run
```

Keep the server running. It uses port 8080. Open this address in a browser:
http://localhost:8080/profile?name=Sara

The console lists bean names and confirms profileController was found.

## Run the clients

Open a second terminal inside PairJsonClient:

```powershell
mvn clean test-compile
mvn -q exec:java
mvn -q exec:java "-Dmain.class=FeedbackClient"
```

The first command runs ProfileClient; the second runs FeedbackClient.
FeedbackClient performs POST twice, GET, PUT, GET, DELETE and GET.
It prints the parsed JSON and HTTP status after each request.
It adds real in-memory feedback each time it runs.

## Connect to a partner

Replace the example address with the partner's actual network address:

```powershell
mvn -q exec:java "-Dexec.args=http://192.168.1.20:8080 Abdullah"
mvn -q exec:java "-Dmain.class=FeedbackClient" "-Dexec.args=http://192.168.1.20:8080"
```

Each client also has its default serverAddress in one place in the code.
localhost means this computer, not the partner's computer.
Both computers must be able to reach the server's port.

## Postman

Import Feedback.postman_collection.json from PairJsonServer.
It uses the collection variable baseUrl, initially http://localhost:8080.
Start with an empty server list (restart the server if needed).
Run the collection in order. It captures created IDs automatically.
The final extra requests check unknown IDs and clean up the test data.

A local CLI run can also execute the same collection; see TEST_RESULTS.md.

## Notes

NOTES.md records design choices, sources, blockers and partner-test status.
TEST_RESULTS.md records actual local results.
No external API, API key or paid account is used.
