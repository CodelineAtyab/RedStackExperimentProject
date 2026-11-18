# PLAN.md

## 1. Client and Server

My Java application (`TaxiProgram.java`) will act as the **client**. It will send an HTTP request to the Google Maps Routes API, which acts as the **server**.

The Google Maps API will receive the request, process the provided locations, calculate the route, and return a response containing information about the distance and estimated travel duration.

## 2. Request and Response

The application will send the following information to the Google Maps API:

- **Origin:** The starting location.
- **Destination:** The ending location.
- **Travel mode:** Driving.
- **Routing preference:** Traffic-aware routing to consider live traffic conditions.

I will use the Unirest library to send an HTTP POST request to Google's Compute Routes endpoint.

The expected response will contain the estimated travel duration and distance between the two locations. The distance will be returned in metres and will need to be converted into kilometres before displaying it.

## 3. Requirements for Making the API Request

The following components and information are required to communicate with the Google Maps Routes API:

1. **Google Maps Routes API:** The Google service responsible for calculating routes, distances, and travel durations.

   Documentation: https://developers.google.com/maps/documentation/routes

2. **API Endpoint:** The Compute Routes endpoint, which receives the HTTP request and processes the route calculation.

3. **API Key:** A key generated through Google Cloud Console to authenticate requests to the Google Maps Platform.

4. **Origin and Destination:** The two locations between which the driving distance needs to be calculated.

5. **HTTP Method:** POST, used to send the request containing the route information.

6. **Request Headers:** Headers containing the API key, content type, and field mask required by Google.

7. **JSON Request Body:** Contains the origin, destination, travel mode, and routing preference.

8. **Field Mask:** Specifies which information should be returned in the API response, including the route distance and duration.

9. **Unirest Dependency:** A Java HTTP client library used to send HTTP requests and receive responses.

   Documentation: https://kong.github.io/unirest-java/

10. **Maven:** Used to manage the project dependencies and configure the Java 17 project.

11. **Google Cloud Setup:** A Google Cloud project with the Routes API enabled and billing configured.

## 4. Implementation Plan

1. Read the assignment and identify the requirements and expected output.
2. Create a new Git branch following the required naming convention.
3. Create a Maven project in the specified location: `experiments_area/from_alaa/DistanceFinderClient/`.
4. Configure the project to use Java 17.
5. Add the required Unirest dependency to `pom.xml`.
6. Create the main Java file (`TaxiProgram.java`) to implement the application.
7. Define the source and destination locations.
8. Retrieve the Google Maps API key from an environment variable rather than hardcoding it in the source code.
9. Prepare the HTTP POST request by specifying the endpoint, request headers, and JSON body.
10. Use Unirest to send the request to the Google Maps Routes API.
11. Receive and inspect the HTTP response, including its status code and JSON body.
12. Extract the distance from the response.
13. Convert the distance from metres into kilometres.
14. Print the result using the required output format:

`Distance from <source> to <destination>: <number> km`

15. Handle unsuccessful requests or missing route results by displaying a clear error message instead of allowing the application to crash.
16. Test the application and verify that it considers live traffic conditions.
17. Complete `BLOCKERS.md` with any issues encountered or, if there were no blockers, document that and mention one thing that was harder than expected.
18. Review the project structure and ensure that the API key is not included in any committed files before submitting the pull request.