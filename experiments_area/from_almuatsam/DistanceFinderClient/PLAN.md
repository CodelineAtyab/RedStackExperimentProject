# Distance Finder Client – Plan

## API Architecture

This project uses the Google Maps Routes API to calculate driving distance between two locations.

### 1. Google Maps Routes API

- Purpose: Calculate driving routes and distances between two places.
- Endpoint: `https://routes.googleapis.com/directions/v2:computeRoutes`
- HTTP method: POST
- Authentication: Google Maps API key.
- API key header: `X-Goog-Api-Key`
- Content type: `application/json`
- Field mask: `routes.distanceMeters,routes.duration`
- Travel mode: `DRIVE`
- Routing preference: `TRAFFIC_AWARE`

### Request Body

The request contains:

- Origin: Muscat, Oman.
- Destination: Sohar, Oman.
- Travel mode: DRIVE.
- Routing preference: TRAFFIC_AWARE.

### Response

The API returns:

- `routes[0].distanceMeters`: Route distance in metres.
- `routes[0].duration`: Estimated route duration.

Distance conversion:

`kilometres = metres / 1000`

The API key is stored in the `GOOGLE_MAPS_API_KEY` environment variable. It is not stored in the Java source code.

## Development Steps

1. Research Google Maps Routes API documentation.
2. Create a Maven project using Java 17.
3. Add Unirest and Gson dependencies.
4. Configure the Google Maps API key as an environment variable.
5. Create a POST request using Unirest.
6. Add the API key and field mask headers.
7. Set the origin and destination in the JSON request body.
8. Set the travel mode to DRIVE.
9. Set the routing preference to TRAFFIC_AWARE.
10. Send the request to Google Maps Routes API.
11. Check the HTTP response status.
12. Parse the JSON response.
13. Extract the route distance in metres.
14. Convert metres into kilometres.
15. Print the distance in the required format.
16. Handle API errors and missing routes.
17. Compile and test the project.

## Documentation

- [Google Routes API – Compute Routes](https://developers.google.com/maps/documentation/routes/compute_route_directions)
- [Google Routes API – REST Reference](https://developers.google.com/maps/documentation/routes/reference/rest/v2/TopLevel/computeRoutes)
- [Google Maps API Security Best Practices](https://developers.google.com/maps/api-security-best-practices)
- [Unirest Java Documentation](https://kong.github.io/unirest-java/)
- [Apache Maven](https://maven.apache.org/)