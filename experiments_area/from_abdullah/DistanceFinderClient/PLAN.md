# Distance Finder Plan

## Client and server

My computer is the client host.
The Java program running on it sends a request.

Google runs the server.
Its API host is routes.googleapis.com.

## What I send and receive

I send the source, destination, driving mode and a request to consider
current traffic. I also send my API key and the response fields I need.

I expect a JSON response containing a route with distanceMeters.
I will divide the distance by 1000.0 to convert metres into kilometres.

## What I need

- Google account and Cloud project: used to access Google Maps Platform.
- Billing enabled: required to use the Routes API.
- Routes API enabled: allows this project to request routes.
- API key: identifies the project making the request.
- Internet connection: needed to reach Google's server.
- HTTPS POST endpoint: https://routes.googleapis.com/directions/v2:computeRoutes
- Content-Type header: application/json, because I send JSON.
- X-Goog-Api-Key header: supplies the key from an environment variable.
- X-Goog-FieldMask header: requests routes.distanceMeters.
- Origin and destination: plain text addresses.
- travelMode DRIVE: requests a driving route.
- routingPreference TRAFFIC_AWARE: considers current traffic.
- Departure time: omitted so Google uses the request time.
- Java 17 and Maven: compile the program and download dependencies.
- Unirest: sends the HTTP request and helps read the response.

## Steps

1. Read the Google Maps and Unirest documentation.
2. Set up my Google Cloud project and API key.
3. Check that Java 17 and Maven are available.
4. Create the Maven project and add Unirest.
5. Build one request from Muscat to Sohar.
6. Inspect the response while developing.
7. Read distanceMeters and convert it to kilometres.
8. Handle server errors, missing routes and connection problems.
9. Record actual blockers and verify the final output.

## Sources

Google account, billing, API enablement and API key:
https://developers.google.com/maps/documentation/routes/get-api-key

Request endpoint, fields, response and departure time:
https://developers.google.com/maps/documentation/routes/reference/rest/v2/TopLevel/computeRoutes

Traffic options:
https://developers.google.com/maps/documentation/routes/config_trade_offs

Unirest installation:
https://kong.github.io/unirest-java/installation/

Unirest requests:
https://kong.github.io/unirest-java/requests/
## Revision on 16 November 2026: no-key alternative

The initial plan above describes the original Google approach. After the program was implemented and the missing-key blocker was confirmed, the user requested a working version without an API key.

Revised approach:
- Keep Java 17, Maven and Unirest.
- Use OSRM's public demo host, router.project-osrm.org.
- Send one HTTPS GET for a driving route between fixed approximate points in Muscat and Sohar.
- Coordinates are longitude,latitude pairs: 58.3829,23.5880 and 56.7468,24.3643.
- Disable route geometry and steps to keep the response small.
- Send an identifying User-Agent for this learning project.
- Read routes[0].distance in metres, divide by 1000.0, and keep the required distance-line format.
- Display OSRM/OpenStreetMap attribution and disclose that live traffic is absent.
- Handle HTTP errors, missing routes and unreadable responses.

No key, Google account or Google billing setup is needed for this alternative. Coordinates are fixed: changing a city label alone does not change the route.

This is an alternative to issue #503 and does not meet its Google Maps/live-traffic/place-name lookup criteria. The original plan is retained as history; this revision does not claim to have been written before the original code.

Sources for the revised request and response:
https://project-osrm.org/docs/v5.24.0/api/
https://github.com/Project-OSRM/osrm-backend/wiki/Api-usage-policy
https://www.openstreetmap.org/copyright
