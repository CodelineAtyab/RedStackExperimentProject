import java.util.Locale;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class DistanceFinder {

    public static void main(String[] args) {

        String source = "Muscat";
        String destination = "Sohar";

        // Approximate points in the two cities, in longitude,latitude order.
        // Change both the name and coordinates when choosing a different place.
        String sourceCoordinates = "58.3829,23.5880";
        String destinationCoordinates = "56.7468,24.3643";

        String url = "https://router.project-osrm.org/route/v1/driving/"
                + sourceCoordinates + ";" + destinationCoordinates;

        try {
            Unirest.config()
                    .connectTimeout(10000)
                    .socketTimeout(30000);

            HttpResponse<String> response = Unirest.get(url)
                    .header("User-Agent", "AbdullahDistanceFinder/1.0 (Java learning project)")
                    .queryString("overview", "false")
                    .queryString("steps", "false")
                    .asString();

            if (response.getStatus() != 200) {
                System.out.println("Routing request failed. HTTP "
                        + response.getStatus());
                System.out.println(response.getBody());
                return;
            }

            JSONObject result = new JSONObject(response.getBody());

            if (!"Ok".equals(result.optString("code"))) {
                System.out.println("No route returned: "
                        + result.optString("message", "Routing service error"));
                return;
            }

            JSONArray routes = result.optJSONArray("routes");

            if (routes == null || routes.length() == 0) {
                System.out.println("No driving route found from "
                        + source + " to " + destination + ".");
                return;
            }

            JSONObject route = routes.getJSONObject(0);

            if (!route.has("distance")) {
                System.out.println("The route did not include a distance.");
                return;
            }

            double metres = route.getDouble("distance");
            double kilometres = metres / 1000.0;

            System.out.printf(Locale.US,
                    "Distance from %s to %s: %.2f km%n",
                    source, destination, kilometres);

            System.out.println("Route: OSRM | Map data: OpenStreetMap contributors (ODbL)");
            System.out.println("https://www.openstreetmap.org/copyright");
            System.out.println("Driving distance between selected points; live traffic is not included.");

        } catch (UnirestException e) {
            System.out.println("Could not contact the routing service. "
                    + "Check your connection or try again later.");

        } catch (RuntimeException e) {
            System.out.println("Could not read the routing service response.");

        } finally {
            Unirest.shutDown();
        }
    }
}
