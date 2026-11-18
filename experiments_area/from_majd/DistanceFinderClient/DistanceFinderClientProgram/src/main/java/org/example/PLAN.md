# Project Plan: Distance Finder Client

## Architecture & Roles
- **Client Role**: A standalone Java 17 application that sends HTTP GET requests to the TomTom Routing API using Unirest and parses the resulting JSON response.
- **Server Role**: The remote TomTom Routing API endpoint, which receives coordinates and route parameters, processes the calculation, and returns a JSON payload containing routing summaries.

## Request & Response Flow
- **What is sent**: An HTTP GET request to the TomTom API endpoint containing origin coordinates, destination coordinates, and the API key as a query parameter.
- **What comes back**: A JSON response object containing a `routes` array with a `summary` object that includes the total `lengthInMeters`.

## Required Items for the Request
- **TomTom API Endpoint URL**: The base URL structure (`https://api.tomtom.com/routing/1/calculateRoute/...`) targeting the routing service.
- **Origin & Destination Coordinates**: Latitude and longitude pairs (e.g., Muscat, Sohar, Ruwi, and Seeb) defining the start and end points.
- **API Key**: A secret authentication token passed via query parameters to authorize access to the TomTom service.
- **HTTP Client Library (Unirest)**: A lightweight Java library used to easily build, send, and parse HTTP requests and JSON responses.

## Implementation Steps
1. **Setup Project**: Initialize the Maven project structure and configure `pom.xml` with the Java 17 target and Unirest dependency.
2. **Implement API Client**: Write the Java class (`Main.java`) to construct the request URL with specific coordinates and handle the network call.
3. **Parse Response**: Extract the `lengthInMeters` field from the JSON body and convert it into kilometers.
4. **Format Output**: Print the results matching the required text format (`Distance from <source> to <destination>: <number> km`).
5. **Security & Documentation**: Leave the API key placeholder blank to prevent exposing secrets, and document the workflow and blockers.