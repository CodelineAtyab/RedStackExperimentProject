package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.JsonNode;

class Main {

    private static final String GOOGLE_API_KEY = ""; // Put your Google Maps API Key here

    private static void PrintDistance(String source, String originCoord, String destination, String destCoord) {
        // Updated to use the new Routes API endpoint
        String url = "https://routes.googleapis.com/directions/v2:computeRoutes";

        try {
            // The Routes API requires a JSON body instead of query parameters,
            // and expects coordinates wrapped in location/latLng format.
            String[] originParts = originCoord.split(",");
            String[] destParts = destCoord.split(",");

            String jsonBodyString = String.format(
                    "{" +
                            "  \"origin\": { \"location\": { \"latLng\": { \"latitude\": %s, \"longitude\": %s } } }," +
                            "  \"destination\": { \"location\": { \"latLng\": { \"latitude\": %s, \"longitude\": %s } } }," +
                            "  \"travelMode\": \"DRIVE\"" +
                            "}",
                    originParts[0], originParts[1], destParts[0], destParts[1]
            );

            HttpResponse<JsonNode> response = Unirest.post(url)
                    .header("Content-Type", "application/json") //the type of datas
                    .header("X-Goog-Api-Key", GOOGLE_API_KEY) // the api key
                    .header("X-Goog-FieldMask", "routes.distanceMeters") //the data must be in meters
                    .body(jsonBodyString)
                    .asJson();

            if (response.isSuccess() && response.getBody() != null) {
                var jsonBody = response.getBody().getObject();

                // The Routes API returns a "routes" array containing the distance in meters
                if (jsonBody.has("routes") && !jsonBody.getJSONArray("routes").isEmpty()) {
                    int lengthInMeters = jsonBody.getJSONArray("routes")
                            .getJSONObject(0)
                            .getInt("distanceMeters");

                    double distanceKm = lengthInMeters / 1000.0;
                    System.out.printf("Distance from %s to %s: %.1f km%n", source, destination, distanceKm);
                } else {
                    System.err.println("No routes found between " + source + " and " + destination);
                    System.err.println("Full response: " + jsonBody.toString());
                }
            } else {
                System.err.println("HTTP Error calling Routes API for " + source + " to " + destination);
                System.err.println("Response: " + response.getBody());
            }

        } catch (Exception e) {
            System.err.println("Error calling Routes API: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Coordinates (Latitude, Longitude) for the locations
        String muscatCoord = "23.5880,58.3829";
        String soharCoord = "24.3475,56.7094";
        String ruwiCoord = "23.5933,58.5456";
        String seebCoord = "23.6703,58.1891";

        // 1. Muscat to Sohar
        PrintDistance("Muscat", muscatCoord, "Sohar", soharCoord);

        // 2. Ruwi to Seeb
        PrintDistance("Ruwi", ruwiCoord, "Seeb", seebCoord);
    }
}