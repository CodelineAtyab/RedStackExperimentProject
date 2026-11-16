# Project Plan: DistanceFinderClient

## 1. Architecture: Host, Client, and Server Roles
- **Client Host / Local Host:** My local developer machine running the Java 17 application. It initiates the network connection.
- **Server Host / Remote Host:** Google Maps API servers (`maps.googleapis.com`), which listen for incoming HTTP requests and return routing data.
- **Client Application:** My Java program using the Unirest library to build and send HTTP GET requests.
- **Server Application:** Google's Maps Directions API service running on Google's cloud infrastructure.

## 2. Request and Response Data
- **What we send (Request):**
  - An HTTP GET request to the Google Maps Directions API endpoint.
  - Query parameters including origin, destination, travel mode (`driving`), departure time (`now` for live traffic), and authentication credentials.
- **What we expect back (Response):**
  - An HTTP response payload in JSON format containing route details, legs, distance in meters, and duration with traffic.

## 3. Step-by-Step Implementation Plan
1. **Setup:** Create the Maven project structure under `experiments_area/from_<your-name>/DistanceFinderClient/` targeting Java 17.
2. **Dependency Management:** Add the **Unirest** library dependency to `pom.xml` and verify compilation with `mvn clean test-compile`.
3. **Browser Verification:** Construct and test the API URL directly in a browser to inspect the raw JSON response and verify the API key works.
4. **Send Request:** Write Java code using Unirest to send the request with source, destination, live traffic parameter, and API key (read securely from an environment variable).
5. **Parse Response:** Print the raw response string to understand its structure, then extract the distance value from the JSON tree.
6. **Format Output:** Convert the distance into **kilometres** and print it in the exact required format: `Distance from <source> to <destination>: <number> km`.
7. **Error Handling:** Implement graceful failure messages if the API returns an error status or empty results instead of crashing.

## 4. Required Items for Google Maps API Request
*List of items needed to make a request, found in the Google Cloud / Google Maps Platform documentation:*

- **Google Cloud Project & Account:** Required setup to access Google Maps services and manage API credentials.
- **Directions API:** The specific Google Maps service that must be enabled to calculate routes between locations.
- **API Key (`key`):** A unique security credential passed with every request to authenticate and authorize the client.
- **Endpoint URL (`https://maps.googleapis.com/maps/api/directions/json`):** The base web address of the Google Maps server handling direction queries.
- **Origin Parameter (`origin`):** The starting point of the journey (e.g., plain text name like `Muscat`).
- **Destination Parameter (`destination`):** The ending point of the journey (e.g., plain text name like `Sohar`).
- **Travel Mode Parameter (`mode=driving`):** Instructs the server to calculate a route specifically for cars.
- **Departure Time Parameter (`departure_time=now`):** Instructs the server to calculate travel time and distance incorporating real-time traffic conditions.
