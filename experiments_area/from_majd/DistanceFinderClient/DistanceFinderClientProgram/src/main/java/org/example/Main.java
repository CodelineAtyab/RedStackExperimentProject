package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.JsonNode;

class Main {

    private static final String TOMTOM_API_KEY = "qifGKamAMAtuCdimsnGzXKi7fxBUuQZt"; //API KEY

    private static void fetchAndPrintDistance(String source, String originCoord, String destination, String destCoord) {
        String url = "https://api.tomtom.com/routing/1/calculateRoute/" + originCoord + ":" + destCoord + "/json";

        try {
            HttpResponse<JsonNode> response = Unirest.get(url)
                    .queryString("key", TOMTOM_API_KEY)
                    .asJson();

            if (response.isSuccess() && response.getBody() != null) {
                // Extract length in meters from the JSON response and convert to kilometers
                int lengthInMeters = response.getBody().getObject()
                        .getJSONArray("routes")
                        .getJSONObject(0)
                        .getJSONObject("summary")
                        .getInt("lengthInMeters");

                double distanceKm = lengthInMeters / 1000.0;

                // Printf for format printing
                System.out.printf("Distance from %s to %s: %.1f km%n", source, destination, distanceKm);
            } else {
                System.err.println("API Error for " + source + " to " + destination);
            }

        } catch (Exception e) {
            System.err.println("Error calling TomTom API: " + e.getMessage());
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
        fetchAndPrintDistance("Muscat", muscatCoord, "Sohar", soharCoord);

        // 2. Ruwi to Seeb
        fetchAndPrintDistance("Ruwi", ruwiCoord, "Seeb", seebCoord);
    }
}