# Plan

The Java program DistanceFinderClient is the client. 
Google Maps Routes API is the server.

I will send Google a source, a destination, and a request for a driving route with live traffic. Google will return the distance in metres. My program will convert it to kilometres and print it.

## Steps

1. Create a Java 17 Maven project.
2. Add Unirest and a JSON library.
3. Build the request with the source, destination, driving mode, and traffic preference.
4. Send the request to Google using Unirest.
5. Read the distance, convert it to kilometres, and print it.

## Request requirements

- **Routes API endpoint and POST method:** [Compute Routes documentation](https://developers.google.com/maps/documentation/routes/reference/rest/v2/TopLevel/computeRoutes)
- **Source and destination:** Places to calculate the route between; same documentation.
- **Driving mode and live traffic preference:** [Traffic routing documentation](https://developers.google.com/maps/documentation/routes/config_trade_offs)
- **API key:** Identifies the request; [Routes API setup](https://developers.google.com/maps/documentation/routes/get-api-key)

## Note

I used OSRM because we do not have a Google API key or an approved Google project with billing enabled but it does not provide live traffic.

OSRM documentation: https://project-osrm.org/docs/v26.6.1/http
