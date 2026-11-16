package org.example;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.JsonNode;
import kong.unirest.core.Unirest;
import kong.unirest.core.json.JSONArray;
import kong.unirest.core.json.JSONObject;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String origin = "Muscat";
        String destination = "Sohar";

        String apiKey = System.getenv("MAPS_API_KEY");
        if (apiKey == null || apiKey.trim().isEmpty()) {
            apiKey = "YOUR_API_KEY_HERE";
        }

        try{
            HttpResponse<JsonNode> response = Unirest.get("https://maps.googleapis.com/maps/api/directions/json")
                    .queryString("origin", origin)
                    .queryString("destination", destination)
                    .queryString("mode", "driving")
                    .queryString("departure_time", "now")
                    .queryString("key", apiKey)
                    .asJson();

            if (response.getStatus() != 200) {
                System.out.println("Error: Received HTTP status " + response.getStatus() + " from Google Maps server.");
                return;
            }

            JSONObject jsonResponse = response.getBody().getObject();
            String status = jsonResponse.optString("status", "UNKNOWN");

            if (!"OK".equals(status)) {
                String errorMessage = jsonResponse.optString("error_message", "No error message provided.");
                System.out.println("Google Maps API Error [Status: " + status + "]: " + errorMessage);
                return;
            }

            JSONArray routes = jsonResponse.getJSONArray("routes");
            if (routes.length() == 0) {
                System.out.println("No driving route found between " + origin + " and " + destination + ".");
                return;
            }

            JSONObject route = routes.getJSONObject(0);
            JSONArray legs = route.getJSONArray("legs");
            if (legs.length() == 0) {
                System.out.println("No route legs available.");
                return;
            }

            JSONObject leg = legs.getJSONObject(0);
            JSONObject distanceObj = leg.getJSONObject("distance");

            double distanceMeters = distanceObj.getDouble("value");
            double distanceKm = distanceMeters / 1000.0;

            System.out.printf("Distance from %s to %s: %.1f km%n", origin, destination, distanceKm);
        }
        catch (Exception e){
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}