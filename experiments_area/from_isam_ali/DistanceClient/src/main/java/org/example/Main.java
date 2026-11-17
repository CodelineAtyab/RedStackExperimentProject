package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;


public class Main {
    private static final String ROUTES_URL = "https://routes.googleapis.com/directions/v2:computeRoutes";

    public static void main(String[] args) {
        printDistance("Muscat", "Sohar");
        printDistance("Ruwi", "Seeb");
        Unirest.shutDown();
    }
    static String loadApiKey() {
        String fromEnv = System.getenv("GOOGLE_API_KEY");
        if (fromEnv != null && !fromEnv.isBlank()) {
            return fromEnv;
        }
        Path file = Path.of(".env");
        if (Files.exists(file)) {
            try {
                for (String line : Files.readAllLines(file)) {
                    line = line.trim();
                    if (line.startsWith("GOOGLE_API_KEY=")) {
                        return line.substring("GOOGLE_API_KEY=".length()).trim().replace("\"", "");
                    }
                }
            } catch (IOException e) {
                System.out.println("Could not read .env: " + e.getMessage());
            }
        }
        return null;
    }

    static JSONObject waypoint(String place) {
        return new JSONObject().put("address", place + ", Oman");
    }

    static void printDistance(String source, String destination) {
        String apiKey = loadApiKey();
        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("Error: set GOOGLE_API_KEY in the environment or in a .env file in the project root.");
            return;
        }

        try {
            JSONObject body = new JSONObject()
                    .put("origin", waypoint(source))
                    .put("destination", waypoint(destination))
                    .put("travelMode", "DRIVE")
                    .put("routingPreference", "TRAFFIC_AWARE")   
                    .put("regionCode", "om");

            HttpResponse<JsonNode> response = Unirest.post(ROUTES_URL)
                    .header("Content-Type", "application/json")
                    .header("X-Goog-Api-Key", apiKey)
                    .header("X-Goog-FieldMask", "routes.distanceMeters")
                    .body(body.toString())
                    .asJson();

            if (!response.isSuccess()) {
                System.out.println("Routing error (HTTP " + response.getStatus() + "): "
                        + response.getBody());
                return;
            }

            JSONArray routes = response.getBody().getObject().optJSONArray("routes");
            if (routes == null || routes.length() == 0) {
                System.out.println("No route found from " + source + " to " + destination);
                return;
            }

            long meters = routes.getJSONObject(0).getLong("distanceMeters");
            System.out.println(String.format(Locale.US,
                    "Distance from %s to %s: %.1f km", source, destination, meters / 1000.0));

        } catch (Exception e) {
            System.out.println("Could not get a distance: " + e.getMessage());
        }
    }
}
