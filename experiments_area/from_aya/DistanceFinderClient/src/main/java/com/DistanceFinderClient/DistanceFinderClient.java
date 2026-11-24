package com.DistanceFinderClient;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DistanceFinderClient {

    public static void main(String[] args) {

        String source = "Muscat";
        String destination = "Sohar";
        String apiKey =System.getenv("API_KEY");

        // JSON body
        String jsonBody = """
                {
                  "origin": {
                    "address": "Muscat"
                  },
                  "destination": {
                    "address": "Sohar"
                  },
                  "travelMode": "DRIVE",
                  "routingPreference": "TRAFFIC_AWARE"
                }
                """;

        // Send request
        String apiUrl = "https://routes.googleapis.com/directions/v2:computeRoutes";

        HttpResponse<String> response = Unirest.post(apiUrl)
                .header("Content-Type", "application/json")
                .header("X-Goog-Api-Key", apiKey)
                .header("X-Goog-FieldMask", "routes.distanceMeters")
                .body(jsonBody)
                .asString();

        // Read response
        if (response.getStatus() == 200) {

            JsonObject result = JsonParser.parseString(
                    response.getBody()).getAsJsonObject();

            if (result.has("routes") && result.getAsJsonArray("routes").size() > 0) {

                JsonObject route = result.getAsJsonArray("routes")
                        .get(0).getAsJsonObject();

                if (route.has("distanceMeters")) {

                    double distance = route.get("distanceMeters").getAsDouble();
                    double km = distance / 1000;

                    System.out.println("Distance from " + source + " to "
                            + destination + ": " + km + " km");

                } else {
                    System.out.println("Distance not found.");
                }

            } else {
                System.out.println("No route found.");
            }

        } else {
            System.out.println("Request failed: " + response.getStatus());
        }

        Unirest.shutDown();
    }
}
