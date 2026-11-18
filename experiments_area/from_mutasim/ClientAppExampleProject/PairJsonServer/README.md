# PairJsonServer — issue #522

Spring Boot Maven server using Java 17. It exposes **only one GET endpoint**:

`GET http://localhost:8080/profile?name=Sara`

Expected JSON:

```json
{
  "name": "Sara",
  "favourites": [
    { "id": 1, "title": "Coffee" },
    { "id": 2, "title": "Books" },
    { "id": 3, "title": "Football" }
  ]
}
```

## Run

Install JDK 17 and Maven 3.9+; in this directory run:

```bash
mvn spring-boot:run
```
localhost should be the IP Address

Then open `http://localhost:8080/profile?name=Sara` in a browser.

For the pair challenge, give your partner your computer's **LAN IP address** and port **8080**. Both computers must be on the same network, and the OS firewall must allow inbound TCP port 8080. The server is configured to listen on all network interfaces.

Change the server's hard-coded favourites in `ProfileController.java`, restart the server, and repeat the two-way test as required in the issue.

See [NOTES.md](NOTES.md) for the two-round test log.
