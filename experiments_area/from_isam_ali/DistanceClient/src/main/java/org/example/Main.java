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

    private static final String GEOCODE_URL = "https://api.tomtom.com/search/2/geocode/{query}.json";
    private static final String ROUTE_URL = "https://api.tomtom.com/routing/1/calculateRoute/{locations}/json";

    public static void main(String[] args) {
        printDistance("Muscat", "Sohar");
        printDistance("Ruwi", "Seeb");
        Unirest.shutDown();
    }

    // Reads the key from the environment, or from a .env file in the project root
    static String loadApiKey() {
        String fromEnv = System.getenv("TOMTOM_API_KEY");
        if (fromEnv != null && !fromEnv.isBlank()) {
            return fromEnv;
        }
        Path file = Path.of(".env");
        if (Files.exists(file)) {
            try {
                for (String line : Files.readAllLines(file)) {
                    line = line.trim();
                    if (line.startsWith("TOMTOM_API_KEY=")) {
                        return line.substring("TOMTOM_API_KEY=".length()).trim().replace("\"", "");
                    }
                }
            } catch (IOException e) {
                System.out.println("Could not read .env: " + e.getMessage());
            }
        }
        return null;
    }

    // Turns a place name into "lat,lon". Returns null (after printing a message) on failure.
    static String geocode(String place, String apiKey) {
        HttpResponse<JsonNode> response = Unirest.get(GEOCODE_URL)
                .routeParam("query", place)
                .queryString("key", apiKey)
                .queryString("countrySet", "OM")
                .queryString("limit", 1)
                .asJson();

        if (!response.isSuccess()) {
            System.out.println("Could not find '" + place + "' (HTTP " + response.getStatus() + "): "
                    + response.getBody());
            return null;
        }

        JSONArray results = response.getBody().getObject().optJSONArray("results");
        if (results == null || results.length() == 0) {
            System.out.println("No location found for '" + place + "'");
            return null;
        }

        JSONObject position = results.getJSONObject(0).getJSONObject("position");
        return position.getDouble("lat") + "," + position.getDouble("lon");
    }

    static void printDistance(String source, String destination) {
        String apiKey = loadApiKey();
        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("Error: set TOMTOM_API_KEY in the environment or in a .env file in the project root.");
            return;
        }

        try {
            String from = geocode(source, apiKey);
            String to = geocode(destination, apiKey);
            if (from == null || to == null) {
                return;
            }

            HttpResponse<JsonNode> response = Unirest.get(ROUTE_URL)
                    .routeParam("locations", from + ":" + to)
                    .queryString("key", apiKey)
                    .queryString("traffic", true)       // live traffic
                    .queryString("travelMode", "car")
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

            long meters = routes.getJSONObject(0).getJSONObject("summary").getLong("lengthInMeters");
            System.out.println(String.format(Locale.US,
                    "Distance from %s to %s: %.1f km", source, destination, meters / 1000.0));

        } catch (Exception e) {
            System.out.println("Could not get a distance: " + e.getMessage());
        }
    }
}