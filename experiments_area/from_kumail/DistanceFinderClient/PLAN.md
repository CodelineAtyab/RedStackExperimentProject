# Distance Finder Client - Plan

1. **Client and Server:** My Java application is the client, and Google Maps Routes API is the server.

2. **Request:** Send Muscat as the source, Sohar as the destination, driving mode, traffic preference, and API key.

3. **Response:** Receive the driving distance and estimated travel time in JSON format.

4. **Requirements:** Java 17, Maven, Unirest, Google Routes API, and an API key.

5. **Setup:** Create a Google Cloud project, enable billing and Routes API, and generate an API key.

6. **Implementation:** Send the request, read the response, extract the distance, and convert metres into kilometres.

7. **Expected Output:**

Distance from Muscat to Sohar: [number] km