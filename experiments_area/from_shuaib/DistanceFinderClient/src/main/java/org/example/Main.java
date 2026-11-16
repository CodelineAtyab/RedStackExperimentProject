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

        //muscat to suhar coordinates
        String coordinates = "58.3829,23.5880;56.7088,24.3468";

        try {
            HttpResponse<JsonNode> response = Unirest.get("http://router.project-osrm.org/route/v1/driving/" + coordinates)
                    .queryString("overview", "false")
                    .asJson();

            if (response.getStatus() != 200) {
                System.out.println("Error: Received HTTP status " + response.getStatus() + " from routing server.");
                return;
            }

            JSONObject jsonResponse = response.getBody().getObject();
            String code = jsonResponse.optString("code", "Error");

            //verify response
            if (!"Ok".equals(code)) {
                System.out.println("Routing API Error: Could not find a route.");
                return;
            }

            //distance in meters
            JSONArray routes = jsonResponse.getJSONArray("routes");
            if (routes.length() == 0) {
                System.out.println("No driving route found.");
                return;
            }

            JSONObject route = routes.getJSONObject(0);
            double distanceMeters = route.getDouble("distance");

            //distance in Km
            double distanceKm = distanceMeters / 1000.0;

            // Print output
            System.out.printf("Distance from Muscat to Sohar: %.1f km%n", distanceKm);

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}