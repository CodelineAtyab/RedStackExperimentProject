
# Distance Finder Client - Plan

## 1. Client and Server

- Client: My Java application.
- Server: Google Maps Platform Routes API.
- Host: My computer runs the Java application. Google's servers host the API.

## 2. What will I send?

My application will send:
- Source location: Muscat
- Destination location: Sohar
- Travel mode: DRIVE
- Routing preference: TRAFFIC_AWARE
- API key for authentication.

## 3. What do I expect back?

Google will return a JSON response containing:
- Driving distance in metres.
- Estimated travel duration considering traffic.

My Java application will extract the distance and convert it into kilometres.

## 4. Requirements for the API request

| Requirement | Explanation |
|---|---|
| API key | Authenticates my application. |
| Endpoint | The Google Routes API address. |
| HTTP method | POST sends the request. |
| Content-Type | application/json identifies the request body format. |
| Origin | Starting location. |
| Destination | Ending location. |
| Travel mode | DRIVE selects driving directions. |
| Routing preference | TRAFFIC_AWARE considers traffic conditions. |
| Field mask | Selects distance and duration in the response. |
| Unirest | Java library used to send HTTP requests. |

## 5. Google Cloud Setup

- Create a Google Cloud project.
- Enable billing.
- Enable the Routes API.
- Create an API key.
- Store the API key outside the source code.

## 6. Implementation Steps

1. Create a Maven project.
2. Configure Java 17.
3. Add Unirest dependency.
4. Configure the API endpoint.
5. Prepare the JSON request body.
6. Send the POST request using Unirest.
7. Receive the JSON response.
8. Extract distanceMeters.
9. Convert metres to kilometres.
10. Print the result.
11. Handle API errors and missing routes.
12. Test compilation using mvn clean test-compile.

## 7. Expected Output

Distance from Muscat to Sohar: <number> km
