# Pair JSON Exchange Notes (#522)

- **Partner:** Spy

## Architecture & Setup
- **Server Project (`profile-server`):** Built with Spring Boot 3.3.5 and Java 17, running on port `8091` (`application.properties`). Uses `@RestController` to expose a `/profile` endpoint returning hardcoded JSON data via Java `record` models (`ProfileResponse` and `Favourite`).
- **Client Project (`profile-client`):** Built with Java 17 and Maven, utilizing Kong Unirest (`v3.14.5`) to send HTTP GET requests, parse JSON nodes, and print out profile items.

## Round 1 (Omar's Client -> Spy's Server)
- Connected to Spy's machine using their local Wi-Fi IP address and port `8091`.
- Successfully parsed the incoming JSON response and printed Spy's profile data to the console.

## Round 2 (Spy's Client -> Omar's Server)
- Hosted the Spring Boot server locally (`http://localhost:8091`).
- Retrieved local IPv4 address via `ipconfig` and provided it to Spy.
- Spy successfully connected across the local network and retrieved Omar's profile data.

## Blockers
- None encountered.