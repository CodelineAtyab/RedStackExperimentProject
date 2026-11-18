import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class DistanceFinder {

    private static final String URL = "https://routes.googleapis.com/distanceMatrix/v2:computeRouteMatrix";
    private static final String KEY_VARIABLE = "API_key";

    public static void main(String[] args) {
        String source = "Muscat, Oman";
        String destination = "Sohar, Oman";

        String apiKey = System.getenv(KEY_VARIABLE);
        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("No API key found. Set the environment variable " + KEY_VARIABLE + " first.");
            return;
        }

        String requestBody = """
                {
                  "origins": [ { "waypoint": { "address": "%s" } } ],
                  "destinations": [ { "waypoint": { "address": "%s" } } ],
                  "travelMode": "DRIVE",
                  "routingPreference": "TRAFFIC_AWARE"
                }
                """.formatted(source, destination);

        try {
            HttpResponse<JsonNode> response = Unirest.post(URL)
                    .header("Content-Type", "application/json")
                    .header("X-Goog-Api-Key", apiKey)
                    .header("X-Goog-FieldMask", "originIndex,destinationIndex,distanceMeters,duration,condition")
                    .body(requestBody)
                    .asJson();

            if (response.getStatus() != 200) {
                System.out.println("Server answered with HTTP status " + response.getStatus());
                System.out.println(response.getBody());
                return;
            }

            JSONArray results = response.getBody().getArray();
            if (results.length() == 0) {
                System.out.println("No result returned.");
                return;
            }

            JSONObject element = results.getJSONObject(0);
            String condition = element.optString("condition");
            if (!condition.equals("ROUTE_EXISTS")) {
                System.out.println("No route found between " + source + " and " + destination
                        + " (condition " + condition + ")");
                return;
            }

            int meters = element.getInt("distanceMeters");
            double km = meters / 1000.0;

            // duration comes back like "9876s"
            String durationText = element.optString("duration", "0s").replace("s", "");
            long minutes = Math.round(Double.parseDouble(durationText) / 60.0);

            System.out.println("Distance from " + source + " to " + destination + ": "
                    + String.format("%.1f", km) + " km (about " + minutes + " min with traffic)");
        } catch (UnirestException e) {
            System.out.println("Could not reach the server: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Could not read the response: " + e.getMessage());
        } finally {
            Unirest.shutDown();
        }
    }
}