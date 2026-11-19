package com.DistanceFinderClient;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class Main {

    public static void main(String[] args) {

        String apiKey = System.getenv("GOOGLE_MAPS_API_KEY");

        printDistance(apiKey, "Muscat", "Sohar");
        printDistance(apiKey, "Ruwi", "Seeb");
    }

    public static void printDistance(String apiKey, String source, String destination) {
        String url = "https://routes.googleapis.com/directions/v2:computeRoutes";

        String jsonBody = """
                {
                   "origin": {
                     "address": "%s"
                   },
                   "destination": {
                     "address": "%s"
                   },
                   "travelMode": "DRIVE",
                   "routingPreference": "TRAFFIC_AWARE"
                 }
                """.formatted(source, destination);

        try {
            HttpResponse<JsonNode> result = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .header("X-Goog-Api-Key", apiKey)
                    .header("X-Goog-FieldMask", "routes.distanceMeters")
                    .body(jsonBody)
                    .asJson();

            if (result.getStatus() != 200) {
                System.out.println("Error from server: " + result.getStatus());
                System.out.println(result.getBody());
                return;
            }

            JSONObject body = result.getBody().getObject();
            JSONArray routes = body.getJSONArray("routes");
            int meters = routes.getJSONObject(0).getInt("distanceMeters");
            double km = meters / 1000.0;

            System.out.println("Distance from " + source + " to " + destination + ": " + km + " km");

        } catch (Exception e) {
            System.out.println("Request failed: " + e.getMessage());
        }
    }
}