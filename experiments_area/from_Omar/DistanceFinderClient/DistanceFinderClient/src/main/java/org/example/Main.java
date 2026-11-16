package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        // Example coordinates or query
        // OSRM Public Demo Server endpoint format: /route/v1/driving/{longitude},{latitude};{longitude},{latitude}
        // Note: OSRM expects {longitude},{latitude} (lon,lat order!)

        String url = "https://router.project-osrm.org/route/v1/driving/58.4059,23.5859;58.5922,23.6143?overview=false";

        System.out.println("Fetching driving distance from routing server...");

        try {
            HttpResponse<JsonNode> response = Unirest.get(url).asJson();

            if (response.getStatus() == 200) {
                JSONObject json = response.getBody().getObject();

                // Check if routes exist
                if (json.getJSONArray("routes").length() > 0) {
                    JSONObject route = json.getJSONArray("routes").getJSONObject(0);

                    // OSRM returns distance in meters, convert to kilometers
                    double distanceMeters = route.getDouble("distance");
                    double distanceKm = distanceMeters / 1000.0;

                    // Print in the required strict format
                    System.out.printf("Distance from Origin to Destination: %.2f km%n", distanceKm);
                } else {
                    System.out.println("No routes found.");
                }
            } else {
                System.out.println("Error: Received HTTP status " + response.getStatus());
            }
        } catch (Exception e) {
            System.err.println("Request failed: " + e.getMessage());
        } finally {
            // Shutdown Unirest connection pool so the program exits cleanly
            Unirest.shutDown();
        }
    }
}