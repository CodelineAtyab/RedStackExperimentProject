# Pair JSON Exchange - #522

The server handles GET /profile?name=Sara. Spring turns the Profile object
and its favourites list into JSON. ProfileClient reads that JSON using
Unirest and prints the name and each favourite.

## Local results

Both Maven projects compile with Java 17.
The client printed Sara, Coffee, Books and Football.
Changing the name printed Abdullah.
A temporary server copy with Coffee changed to Tea returned Tea to the same client.
An unavailable server printed: Could not reach the server. Check its address and port.

These were same-computer checks. See TEST_RESULTS.md.

## Partner

Partner GitHub name: not provided.
Round 1, this client against the partner's server: pending.
Round 2, the partner's client against this server: pending.

A second computer and partner address were unavailable for local testing.
This is the remaining blocker; local testing does not count as partner testing.

## Setup issue fixed

The server source files and pom.xml were empty on disk and the client
folder had no project files. Saving the projects fixed the setup.

Reading the JSON array and printing each object was the main part to understand.

## References

https://spring.io/guides/gs/rest-service/
https://kong.github.io/unirest-java/requests/
