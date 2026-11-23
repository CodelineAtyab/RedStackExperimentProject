# Implementation Plan

## Overview

The **DistanceFinderClient** is a Java-based client application designed to calculate the driving distance between two locations using a routing API.

The original plan was to use the **Google Maps Routes API** as the server to retrieve driving routes with real-time traffic information.

The client sends a request containing the source, destination, travel mode, and traffic preferences. The API processes the request and returns the route distance in metres. The Java application then converts the distance into kilometres and displays the result in the console.

## Implementation Steps

1. **Project Setup:** Create a Java 17 Maven project named `DistanceFinderClient`.
2. **Dependency Configuration:** Add Unirest for handling HTTP requests and a JSON library for parsing API responses.
3. **Request Preparation:** Construct an API request containing the source, destination, driving mode, and traffic preferences.
4. **API Communication:** Send the request to the routing service using Unirest.
5. **Response Processing:** Parse the JSON response and extract the route distance in metres.
6. **Distance Conversion:** Convert the distance from metres to kilometres by dividing by 1,000.
7. **Output:** Display the calculated distance in the console.

## API Requirements

| Requirement | Description | Reference |
|---|---|---|
| API Endpoint | Google Routes API `computeRoutes` endpoint using the POST method | [Compute Routes](https://developers.google.com/maps/documentation/routes/reference/rest/v2/TopLevel/computeRoutes) |
| Origin and Destination | Specify the starting and ending locations | [Routes API Documentation](https://developers.google.com/maps/documentation/routes/reference/rest/v2/TopLevel/computeRoutes) |
| Travel Mode | Configure the route for driving | [Routing Configuration](https://developers.google.com/maps/documentation/routes/config_trade_offs) |
| Traffic Preferences | Enable traffic-aware routing for travel time estimates | [Traffic Routing](https://developers.google.com/maps/documentation/routes/config_trade_offs) |
| API Key | Authenticate requests using a valid Google Maps Platform API key | [API Key Setup](https://developers.google.com/maps/documentation/routes/get-api-key) |

## Blockers and Alternative Implementation

### Google Routes API Limitations

The Google Maps Routes API requires a Google Cloud project with billing enabled and a valid API key. Since these requirements were not available, the original implementation could not proceed.

### Alternative Solution: OSRM

To overcome this limitation, I used the **Open Source Routing Machine (OSRM)** as an alternative routing service.

OSRM supports driving route calculations and returns route distances in metres, allowing the application to retain its core functionality without relying on Google Maps Platform billing.

The implemented solution:

1. Sends a routing request to OSRM using Unirest.
2. Receives a JSON response containing route information.
3. Extracts the driving distance in metres.
4. Converts the distance into kilometres.
5. Prints the calculated distance in the console.

### Current Limitation

Unlike the planned Google Routes API integration, the OSRM implementation does not provide live traffic information.

Therefore, the application successfully calculates driving distances but cannot account for real-time congestion, accidents, or traffic-related delays.

## Result

The Java application was successfully compiled and executed using Maven.

**Example Output:**

```text
Distance from Muscat to Sohar: 206.4 km
```
