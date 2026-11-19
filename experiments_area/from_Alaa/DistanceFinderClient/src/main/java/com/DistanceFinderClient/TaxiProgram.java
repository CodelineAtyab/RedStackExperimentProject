package com.DistanceFinderClient;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class TaxiProgram {

    public static void main(String[] args) {

        // The server address (Google Routes API)
        String url = "https://routes.googleapis.com/directions/v2:computeRoutes";

        // Read the API key from an environment variable, never from the code
        String key = System.getenv("Key");

        // The two places, typed as plain text
        String source = "Muscat";
        String destination = "Sohar";

        // Stop early if the key is missing
        if (key == null) {
            System.out.println("API key not found.");
            return;
        }

        // Send the request to the server (this is a POST with a JSON body)
        HttpResponse<JsonNode> response = Unirest.post(url)
                .header("X-Goog-Api-Key", key)      // who you are
                .header("X-Goog-FieldMask", "routes.distanceMeters,routes.duration") // what you want back
                .header("Content-Type", "application/json") // the body is JSON
                .body("""
                        {
                            "origin": {"address": "%s, Oman"},
                            "destination": {"address": "%s, Oman"},
                            "travelMode": "DRIVE",
                            "routingPreference": "TRAFFIC_AWARE"
                        }
                        """.formatted(source, destination))
                .asJson();

        // Anything other than 200 means the server returned an error
        if (response.getStatus() != 200) {
            System.out.println("Request failed. Status " + response.getStatus() + ": " + response.getBody());
            Unirest.shutDown();
            return;
        }

        // Take the "routes" list out of the JSON answer
        JSONObject json = response.getBody().getObject();
        if (!json.has("routes") || json.getJSONArray("routes").length() == 0) {
            System.out.println("No route found from " + source + " to " + destination);
            Unirest.shutDown();
            return;
        }
        JSONArray routes = json.getJSONArray("routes");

        // Read the first route
        JSONObject route = routes.getJSONObject(0);

        // Distance comes in metres, convert to kilometres
        double km = route.getDouble("distanceMeters") / 1000;

        // Duration comes as text like "7260s", so remove the "s" and convert to a number
        String durationText = route.getString("duration");
        int seconds = Integer.parseInt(durationText.replace("s", ""));

        // Split the seconds into hours and minutes
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;

        // Print in the format the ticket asks for
        System.out.printf("Distance from %s to %s: %.1f km%n", source, destination, km);
        System.out.println("Duration: " + hours + " h " + minutes + " min");

        // Close Unirest so the program exits cleanly
        Unirest.shutDown();
    }
}