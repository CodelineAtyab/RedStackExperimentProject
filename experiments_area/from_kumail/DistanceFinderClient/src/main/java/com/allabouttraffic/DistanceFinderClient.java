package com.allabouttraffic;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class DistanceFinderClient {

    public static void main(String[] args) {

        String apiKey = System.getenv("Google_Map_API");


        try {
            calculateDistance("Muscat", "Sohar", apiKey);

            calculateDistance("Ruwi", "Seeb", apiKey);

        } finally {
            Unirest.shutDown();
        }
    }

    public static void calculateDistance(String source, String destination, String apiKey) {

        JsonObject origin = new JsonObject();
        origin.addProperty("address", source + ", Oman");

        JsonObject dest = new JsonObject();
        dest.addProperty("address", destination + ", Oman");

        JsonObject requestBody = new JsonObject();
        requestBody.add("origin", origin);
        requestBody.add("destination", dest);
        requestBody.addProperty("travelMode", "DRIVE");

        HttpResponse<JsonNode> response = Unirest.post("https://routes.googleapis.com/directions/v2:computeRoutes")
                .header("Content-Type", "application/json")
                .header("X-Goog-Api-Key", apiKey)
                .header("X-Goog-FieldMask",
                        "routes.duration,routes.distanceMeters")
                .body(requestBody.toString())
                .asJson();

        if (response.getStatus() != 200) {
            System.out.println("Error: " + response.getStatus() + " - " + response.getBody());
            return;
        }

        JsonObject root = JsonParser.parseString(response.getBody().toString()).getAsJsonObject();

        if (!root.has("routes") || root.getAsJsonArray("routes").isEmpty()) {

            System.out.println("No route found.");
            return;
        }

        JsonArray routes = root.getAsJsonArray("routes");

        JsonObject firstRoute = routes.get(0).getAsJsonObject();

        int distance = firstRoute.get("distanceMeters").getAsInt();

        double km = distance / 1000.0;

        System.out.printf("Distance from %s to %s: %.1f km%n", source, destination, km);
    }
}
