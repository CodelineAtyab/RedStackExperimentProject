package org.example;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.JSONObject;
import org.json.JSONArray;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String source = "Muscat";
        String destination = "Sohar";

        // OSRM coordinates use longitude,latitude order.
        String sourceCoordinates = "58.381665,23.586363";
        String destinationCoordinates = "56.714873,24.351129";

        String url = "https://router.project-osrm.org/route/v1/driving/" + sourceCoordinates + ";" + destinationCoordinates + "?overview=false";

        try {
            HttpResponse<String> response = Unirest.get(url).asString();

            if (response.getStatus() < 200 || response.getStatus() >= 300) {
                System.out.println("OSRM request failed: HTTP " + response.getStatus());
                return;
            }

            JSONObject result = new JSONObject(response.getBody());

            if (!"Ok".equals(result.optString("code"))) {
                System.out.println("OSRM could not calculate the route.");
                return;
            }

            JSONArray routes = result.optJSONArray("routes");

            if (routes == null || routes.length() == 0) {
                System.out.println("No driving route was found.");
                return;
            }

            double distanceMeters = routes.getJSONObject(0).getDouble("distance");

            double kilometres = distanceMeters / 1000.0;

            System.out.printf("Distance from %s to %s: %.1f km%n", source, destination, kilometres);

        } catch (Exception e) {
            System.out.println("Could not get the route: " + e.getMessage());
        } finally {
            Unirest.shutDown();
        }
    }
}