# Project Plan: DistanceFinderClient

## 1. Architecture: Host, Client, and Server Roles
- **Client Host / Local Host:** My local developer machine running the Java 17 application. It initiates the network connection.
- **Server Host / Remote Host:** OSRM public routing server (`router.project-osrm.org`), which listens for incoming HTTP requests and returns routing data.
- **Client Application:** Our Java program using the Unirest library to build and send HTTP GET requests.
- **Server Application:** Open Source Routing Machine (OSRM) driving route service.

## 2. Request and Response Data
- **What we send (Request):**
  - An HTTP GET request to the OSRM driving endpoint (`http://router.project-osrm.org/route/v1/driving/{coordinates}`).
  - Geographic coordinates formatted as `longitude,latitude;longitude,latitude` for Muscat (`58.3829,23.5880`) and Sohar (`56.7088,24.3468`), along with `overview=false` to keep the payload lightweight.
- **What we expect back (Response):**
  - An HTTP response payload in JSON format containing status codes (`code: "Ok"`), route arrays, and driving distance in meters.

## 3. Step-by-Step Implementation Plan
1. **Setup:** Create the Maven project structure under `experiments_area/from_<your-name>/DistanceFinderClient/` targeting Java 17.
2. **Dependency Management:** Add the **Unirest** (`unirest-java-core` and `unirest-modules-jackson`) dependencies to `pom.xml` and verify compilation with `mvn clean test-compile`.
3. **Endpoint & Coordinate Verification:** Verify the geographic coordinates for Muscat and Sohar in `longitude,latitude` order and test the OSRM endpoint response structure.
4. **Send Request:** Write Java code using Unirest to send the GET request with the formatted coordinate string.
5. **Parse Response:** Extract the `routes` array from the JSON object and retrieve the `distance` value in meters.
6. **Format Output:** Convert the distance into **kilometres** and print it in the required format: `Distance from Muscat to Sohar: <number> km`.
7. **Error Handling:** Implement graceful failure messages if the server returns a non-200 HTTP status, an error code, or empty route results.

## 4. Required Items for OSRM API Request
- **Endpoint URL (`http://router.project-osrm.org/route/v1/driving/`):** The base web address of the OSRM server handling driving direction queries.
- **Coordinates String (`58.3829,23.5880;56.7088,24.3468`):** Origin and destination coordinates separated by a semicolon, strictly ordered as `longitude,latitude`.
- **Overview Query Parameter (`overview=false`):** Optional parameter passed to omit detailed route geometry and return a clean, lightweight JSON response.