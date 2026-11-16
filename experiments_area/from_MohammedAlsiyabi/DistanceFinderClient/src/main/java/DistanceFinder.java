package com.teamredstack.distancefinder;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class DistanceFinder {

    private static final String GEOCODE_URL = "https://nominatim.openstreetmap.org/search";
    private static final String ROUTE_URL = "https://router.project-osrm.org/route/v1/driving/";

    public static void main(String[] args) {
        String source = "Muscat";
        String destination = "Sohar";

        try {
            double[] from = findCoordinates(source);
            if (from == null) {
                System.out.println("Could not find a place called " + source);
                return;
            }
            // Nominatim asks for max one request per second
            Thread.sleep(1100);
            double[] to = findCoordinates(destination);
            if (to == null) {
                System.out.println("Could not find a place called " + destination);
                return;
            }

            // OSRM wants longitude first, then latitude
            String coordinates = from[1] + "," + from[0] + ";" + to[1] + "," + to[0];
            HttpResponse<JsonNode> response = Unirest.get(ROUTE_URL + coordinates)
                    .queryString("overview", "false")
                    .asJson();

            if (response.getStatus() != 200) {
                System.out.println("Server answered with HTTP status " + response.getStatus());
                return;
            }

            JSONObject body = response.getBody().getObject();
            String code = body.optString("code");
            if (!code.equals("Ok")) {
                System.out.println("OSRM returned code " + code);
                return;
            }

            double meters = body.getJSONArray("routes").getJSONObject(0).getDouble("distance");
            System.out.println("Distance from " + source + " to " + destination + ": "
                    + String.format("%.1f", meters / 1000.0) + " km");
        } catch (UnirestException e) {
            System.out.println("Could not reach the server: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Could not read the response: " + e.getMessage());
        } finally {
            Unirest.shutDown();
        }
    }

    // Turns a place name into {latitude, longitude}, or null if nothing was found
    private static double[] findCoordinates(String place) {
        HttpResponse<JsonNode> response = Unirest.get(GEOCODE_URL)
                .header("User-Agent", "DistanceFinderClient-learning-project")
                .queryString("q", place)
                .queryString("format", "json")
                .queryString("limit", "1")
                .queryString("countrycodes", "om")
                .asJson();

        if (response.getStatus() != 200) {
            return null;
        }
        JSONArray results = response.getBody().getArray();
        if (results.length() == 0) {
            return null;
        }
        JSONObject first = results.getJSONObject(0);
        return new double[] {first.getDouble("lat"), first.getDouble("lon")};
    }
}