My Name: Noor
Partner GitHub Username: buthaina111

Local Testing

Spring Boot Server: Working successfully on port 8081.

Unirest Client: Working successfully.

JSON serialization and deserialization: Successful.

The client successfully received JSON data from the server.

The client displayed the name and three favourites correctly.

Round 1 – My Client → Partner's Server

Status: Successful.

My client connected to Buthaina's server.

JSON data was received and displayed correctly.

Round 2 – Partner's Client → My Server

Status: Successful.

Buthaina's client connected to my server.

JSON data was received and displayed correctly.

Blockers

Port 8080 was already in use. Resolved it by changing the server port to 8081.

Faced an issue with unresolved JSON imports (JSONObject and JSONArray). Resolved it by correcting the imports.

IntelliJ initially could not recognize the Unirest library. Resolved it by reloading the Maven dependencies.

Challenge

Understanding how to deserialize a JSON response using JSONObject and JSONArray.

Learning how to access objects inside a JSON array and print their values.

Understanding the difference between the Spring Boot server and the Unirest client, and how they communicate using HTTP GET requests.