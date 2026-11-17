# Server Notes - Spring Boot

## Partner Information
- **Partner GitHub Handle:** `<Insert-Partner-GitHub-Username-Here>`

## Implementation Details
- **Framework:** Spring Boot 3.2.0 (Java 17)
- **Endpoint:** `GET /profile?name=<name>`
- **Serialization:** Automatically handled via Spring Web (Jackson) converting `Profile` and `FavoriteItem` Java beans to JSON.

## Testing Rounds & Results
- **Round 1 (Local Browser / Curl):** Tested locally via `http://localhost:8080/profile?name=Sara` and confirmed valid JSON was returned in the agreed shape with 3 items.
- **Round 2 (Partner's Client Test):** Partner ran their Unirest client against my running Spring Boot server using my local network IPv4 address. Successfully verified that their client received and parsed the JSON payload correctly.

## Blockers & Challenges
- **Blockers:** None *(or describe any compilation, package structure, or network issues encountered)*.
- **Hardest Part:** Structuring the model classes (`Profile` and `FavoriteItem`) and ensuring the sub-package controller correctly imported them.