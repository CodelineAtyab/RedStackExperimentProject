import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;
import kong.unirest.core.json.JSONArray;
import kong.unirest.core.json.JSONObject;

public class DistanceFinder {

    public static void main(String[] args) {

        String apiKey = System.getenv("GOOGLE_MAPS_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("Google Maps API key is missing.");
            return;
        }

        String requestBody = """
                {
                    "origin": {
                        "address": "Muscat, Oman"
                    },
                    "destination": {
                        "address": "Sohar, Oman"
                    },
                    "travelMode": "DRIVE",
                    "routingPreference": "TRAFFIC_AWARE"
                }
                """;

        HttpResponse<String> response = Unirest.post(
                "https://routes.googleapis.com/directions/v2:computeRoutes")
                .header("X-Goog-Api-Key", apiKey)
                .header("X-Goog-FieldMask", "routes.distanceMeters,routes.duration")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .asString();

        if (response.getStatus() != 200) {
            System.out.println("Google Maps request failed: " + response.getBody());
            return;
        }

        JSONObject responseData = new JSONObject(response.getBody());
        JSONArray routes = responseData.getJSONArray("routes");

        if (routes.length() == 0) {
            System.out.println("No route found.");
            return;
        }

        JSONObject route = routes.getJSONObject(0);

        double distanceInMetres = route.getDouble("distanceMeters");
        double distanceInKm = distanceInMetres / 1000;

        System.out.printf(
                "Distance from Muscat to Sohar: %.2f km%n",
                distanceInKm
        );
    }
}
