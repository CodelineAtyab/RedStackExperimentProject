# Client Notes - Unirest

## Partner Information
- **Partner GitHub Handle:** `<Insert-Partner-GitHub-Username-Here>`

## Implementation Details
- **Library:** Unirest Java 3.14.5 (Java 17)
- **Request Type:** `GET` request passing a `name` query parameter.
- **Deserialization:** Responses read as a JSON `JsonNode`, extracting the top-level object, reading the `favourites` JSON array, and looping through items to print in the format `<id> - <title>`.

## Testing Rounds & Results
- **Round 1 (My Client against Partner's Server):** Partner spun up their Spring Boot server and shared their local IP and port. I ran my client against it and verified the printed output:
  ```text
  Name: Sara
  1 - Coffee
  2 - Books
  3 - Football