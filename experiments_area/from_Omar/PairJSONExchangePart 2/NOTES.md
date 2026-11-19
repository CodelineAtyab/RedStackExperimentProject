# Feedback CRUD API Notes (#522 Part 2)

- **Partner:** ays

## Bean Explanation & Discovery
- **What is a Bean:** A bean is an object that is instantiated, assembled, and managed by the Spring IoC (Inversion of Control) container (the Application Context). Spring handles its complete lifecycle from creation to destruction.
- **Bean Name Found:** `profileController` (and `feedbackController`)

## HTTP Methods Summary
- **GET:** Requests a representation of the specified resource without modifying any server-side state (does not carry a request body).
- **POST:** Submits data to be processed to a specified resource, typically creating a new resource (carries a request body).
- **PUT:** Updates or replaces all current representations of the target resource with the uploaded request body.
- **DELETE:** Removes or deletes the specified resource from the server.
- **QUERY:** A newer proposal/method intended for reading data (like GET) but with the capability to securely carry a request body containing complex search or filter parameters.

## Testing Results
- **Postman Testing:** Tested POST, GET, PUT, and DELETE successfully in sequence, verifying that feedback items are correctly created, retrieved, modified, and removed from the in-memory list.
- **Unirest Client Testing:** Updated the client project to execute all four HTTP methods with proper JSON headers and payloads, parsing responses successfully.
- **Cross-Network Testing:** Verified both directions with Spy (Omar's client against Spy's server, and Spy's client against Omar's server via local network IP).

## Blockers
- No blockers.
- **Harder than expected:** Managing cross-network routing and ensuring the firewall allowed incoming traffic on port 8091 for partner testing required a quick check of local IPv4 bindings.