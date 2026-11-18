# NOTES - Pair JSON Exchange (#522)

**Partner:** Salim Albalushi 

## What I built
- `ProfileServer`: Spring Boot server, `GET /profile?name=<name>` returns JSON with `name` and `favourites` (3 items).
- `ProfileClient`: Unirest client, sends a GET with `name`, reads the JSON and prints:
  ```
  Name: Mohammed
  1 - Coffee
  2 - Books
  3 - Football
  ```
- JSON shape: the agreed one (`name`, `favourites`, `id`, `title`).

## Round 1: my client -> Salim's server
- Salim's address and port: `<ip>:8080`
- Result: `<worked / did not work>`
- I changed the name and the data on his server and the client printed the new values: `<yes / no>`

## Round 2: Salim's client -> my server
- My address and port: `<ip>:8080`
- Result: `<worked / did not work>`
- I changed the name and the data on my server and his client printed the new values: `<yes / no>`

