# PairJsonClient — issue #522

Plain Java 17 Maven program using Unirest. It sends a GET request with the `name` query parameter, parses the JSON response as a JSON object and array, and prints each favourite in a loop.

## Run

Install JDK 17 and Maven 3.9+; start a compatible server first, then in this directory run:

```bash
mvn compile exec:java
```

By default this sends `GET http://localhost:8080/profile?name=Sara`. Expected output:

```text
Name: Sara
1 - Coffee
2 - Books
3 - Football
```

To contact your partner's server on another computer, **change `SERVER_BASE_URL` once** in `src/main/java/org/redstack/pairjsonclient/ProfileClient.java`, or supply the address and name at runtime:


Replace `192.168.1.25` with the actual LAN IP of the computer running the server. The client handles connection failures with a readable error message.

The `name` and `favourites`/`id`/`title` fields must be the agreed JSON structure; the actual favourite values can be different on each partner's server.
