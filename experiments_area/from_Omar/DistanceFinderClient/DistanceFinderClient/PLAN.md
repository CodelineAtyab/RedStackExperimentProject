# Project Plan: DistanceFinderClient

## Objective
Build a lightweight, Maven-managed Java 17 console client using Unirest to query the Google Maps API with live traffic considerations, parsing the response and printing the driving distance in kilometers in the strict required format.

## Directory Structure
* `experiments_area/from_omar/DistanceFinderClient/`
  * `pom.xml` (Maven configuration with Unirest & Jackson dependencies)
  * `PLAN.md`
  * `BLOCKERS.md`
  * `src/main/java/com/example/Main.java`

## Prerequisites & Requirements
* **Language & Build:** Java 17, Maven (`mvn clean test-compile`)
* **Dependencies:** Unirest (HTTP requests), Jackson (JSON parsing)
* **API Key Security:** Loaded via external environment variable (`GEMINI_GCP_API_KEY` or `GOOGLE_MAPS_API_KEY`) to prevent GitHub credential leaks.

## Plan Steps & Explanation of Items Needed
1. **API Selection & Endpoint Design**: Use Google Maps Distance Matrix API / Routes API to support live traffic parameters (`traffic_model=best_guess` / `departure_time=now`).
2. **Dependency Setup (`pom.xml`)**: Configure Kong Unirest and Jackson libraries for HTTP communication and JSON parsing.
3. **Core Client Logic (`Main.java`)**: 
   * Read the API key securely from environment variables.
   * Construct the HTTP GET request with hardcoded source and destination plain text names.
   * Pass parameters for driving mode and live traffic.
4. **Parsing & Error Handling**: 
   * Extract distance values from the JSON response and convert meters to kilometers.
   * Print in exact format: `Distance from <source> to <destination>: <number> km`.
   * Implement graceful error handling/fallback messages if the API returns an error or empty result instead of crashing.