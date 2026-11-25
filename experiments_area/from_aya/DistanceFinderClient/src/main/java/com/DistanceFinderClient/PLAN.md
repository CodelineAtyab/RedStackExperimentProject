## Client and Server
- Client: My Java program.
- Server: Google Maps API.

## What I Need to Send
- Source location.
- Destination location.
- Driving mode.
- API key.
- Departure time for live traffic.

## What I Expect
Get the distance and travel time from Google Maps.

## Steps
1. Read Google Maps API documentation.
2. Create an API key and enable the API.
3. Create a Maven project using Java 17.
4. Add Unirest dependency.
5. Send a request with source and destination.
6. Get the response from Google Maps.
7. Read the distance from the JSON response.
8. Convert it to kilometres and print the result.

## Requirements
- API: Google Maps Distance Matrix API – gets distance between places.
- API Key:Allows my program to access Google Maps.
- Source and Destination: The two places for the route.
- Driving Mode: Calculates the driving distance.
- Departure Time:Used for traffic information.
- Unirest: Sends HTTP requests.
- JSON:Contains the response data.
- Maven: Manages the project and libraries.