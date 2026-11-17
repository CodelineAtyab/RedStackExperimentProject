package com.allabouttraffic;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class DistanceFinderClient {

    public static void main(String[] args) {

        String source = "Muscat, Oman";
        String destination = "Sohar, Oman";

        // Read TomTom API key
        String apiKey = System.getenv("TOMTOM_API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("Error: TomTom API key not found.");
            return;
        }

        try {
            // 1. Convert source and destination into coordinates
            double[] sourceCoordinates = getCoordinates(source, apiKey);
            double[] destinationCoordinates = getCoordinates(destination, apiKey);

            if (sourceCoordinates == null || destinationCoordinates == null) {
                System.out.println("Could not find the source or destination.");
                return;
            }


            String locations =
                    sourceCoordinates[0] + "," + sourceCoordinates[1]
                            + ":" +
                            destinationCoordinates[0] + "," + destinationCoordinates[1];

            String url =
                    "https://api.tomtom.com/routing/1/calculateRoute/"
                            + locations
                            + "/json?traffic=true&travelMode=car&key="
                            + apiKey;


            HttpResponse<JsonNode> response = Unirest.get(url)
                    .asJson();


            if (response.getStatus() < 200 || response.getStatus() >= 300) {
                System.out.println("TomTom Routing API error: HTTP "
                        + response.getStatus());
                System.out.println(response.getBody());
                return;
            }


            JsonNode responseBody = response.getBody();

            if (!responseBody.getObject().has("routes")
                    || responseBody.getObject()
                    .getJSONArray("routes").isEmpty()) {

                System.out.println("No driving route found.");
                return;
            }


            int distanceMeters = responseBody.getObject()
                    .getJSONArray("routes")
                    .getJSONObject(0)
                    .getJSONObject("summary")
                    .getInt("lengthInMeters");


            double distanceKm = distanceMeters / 1000.0;

            System.out.printf(
                    Locale.US,
                    "Distance from %s to %s: %.1f km%n",
                    source,
                    destination,
                    distanceKm
            );

        } catch (Exception e) {
            System.out.println("Request failed: " + e.getMessage());

        } finally {
            Unirest.shutDown();
        }
    }

    private static double[] getCoordinates(String address, String apiKey)
            throws Exception {

        String encodedAddress = URLEncoder
                .encode(address, StandardCharsets.UTF_8)
                .replace("+", "%20");

        String url =
                "https://api.tomtom.com/search/2/geocode/"
                        + encodedAddress
                        + ".json?key=" + apiKey + "&countrySet=OM";

        HttpResponse<JsonNode> response = Unirest.get(url)
                .asJson();

        if (response.getStatus() < 200 || response.getStatus() >= 300) {
            System.out.println("TomTom Geocoding API error: HTTP "
                    + response.getStatus());
            System.out.println(response.getBody());
            return null;
        }

        JsonNode responseBody = response.getBody();

        if (!responseBody.getObject().has("results")
                || responseBody.getObject()
                .getJSONArray("results").isEmpty()) {
            return null;
        }

        var position = responseBody.getObject()
                .getJSONArray("results")
                .getJSONObject(0)
                .getJSONObject("position");

        double latitude = position.getDouble("lat");
        double longitude = position.getDouble("lon");

        return new double[]{latitude, longitude};
    }
}
