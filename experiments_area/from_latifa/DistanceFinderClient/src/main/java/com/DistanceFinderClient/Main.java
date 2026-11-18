package com.DistanceFinderClient;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {

        String source = "Muscat";
        String destination = "Sohar";
        String apiKey = System.getenv("GOOGLE_MAPS_API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            System.out.println("Error: Google Maps API key is missing.");
            return;
        }
        String url = "https://routes.googleapis.com/directions/v2:computeRoutes";

        //create json request body that contains Google Maps info
        String requestBody = """
                {
                    "origin": {
                        "address": "%s"
                    },
                    "destination": {
                        "address": "%s"
                    },
                    "travelMode": "DRIVE",
                    "routingPreference": "TRAFFIC_AWARE",
                    "departureTime": "%s"
                }
                """.formatted(
                source,
                destination,
                Instant.now().plusSeconds(5)
        );

        try {
            HttpResponse<JsonNode> response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("X-Goog-Api-Key", apiKey)
                    .header("X-Goog-FieldMask",
                            "routes.distanceMeters,routes.duration")
                    .body(requestBody)
                    .asJson();

            if (response.getStatus() == 200) {
                JsonNode json = response.getBody();

                if (json.getObject().has("routes")
                        && json.getObject().getJSONArray("routes").length() > 0) {

                    double distanceMeters = json.getObject()
                            .getJSONArray("routes")
                            .getJSONObject(0)
                            .getDouble("distanceMeters");

                    double distanceKm = distanceMeters / 1000.0;
                    System.out.println("Distance from " + source + " to " + destination + ": " + distanceKm + " km");

                } else {
                    System.out.println("no route found between the locations.");
                }
            } else {

                System.out.println("Request failed with status: "+ response.getStatus());
                System.out.println(response.getBody());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
}
