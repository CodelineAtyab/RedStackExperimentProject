package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.JsonNode;

class Main {

    private static final String GOOGLE_API_KEY = ""; // Your Google Maps API Key

    private static void PrintDistance(String source, String originCoord, String destination, String destCoord) {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json";

        try {
            HttpResponse<JsonNode> response = Unirest.get(url)
                    .queryString("origins", originCoord)
                    .queryString("destinations", destCoord)
                    .queryString("key", GOOGLE_API_KEY)
                    .asJson();

            if (response.isSuccess() && response.getBody() != null) {
                var jsonBody = response.getBody().getObject();
                String status = jsonBody.optString("status", "UNKNOWN");

                if ("OK".equals(status)) {
                    int lengthInMeters = jsonBody.getJSONArray("rows")
                            .getJSONObject(0)
                            .getJSONArray("elements")
                            .getJSONObject(0)
                            .getJSONObject("distance")
                            .getInt("value");

                    double distanceKm = lengthInMeters / 1000.0;
                    System.out.printf("Distance from %s to %s: %.1f km%n", source, destination, distanceKm);
                } else {
                    // This will print the exact reason from Google (e.g., REQUEST_DENIED, OVER_QUERY_LIMIT)
                    System.err.println("Google Maps API returned status: " + status);
                    System.err.println("Full response: " + jsonBody.toString());
                }
            } else {
                System.err.println("HTTP Error calling API for " + source + " to " + destination);
            }

        } catch (Exception e) {
            System.err.println("Error parsing Google Maps API response: " + e.getMessage());
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