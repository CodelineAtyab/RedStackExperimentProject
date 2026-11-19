package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class ProfileClientApp {

    // 1. Keep http://localhost:8091 to test against your own server first.
    // 2. During Round 1 with Spy, replace this with Spy's server IP and port (e.g. "http://192.168.100.x:8091").
    private static final String SERVER_BASE_URL = "http://192.168.100.203:8091";
    private static final String QUERY_NAME = "Omar";

    public static void main(String[] args) {
        try {
            // Send the GET request with a name query parameter and parse the response as JSON
            HttpResponse<JsonNode> response = Unirest.get(SERVER_BASE_URL + "/profile")
                    .queryString("name", QUERY_NAME)
                    .asJson();

            // Check if the server answered successfully
            if (response.getStatus() != 200) {
                System.out.println("Server responded with error status: " + response.getStatus());
                return;
            }

            // Deserialization: Extract the root object, name string, and favourites array
            JSONObject root = response.getBody().getObject();
            String name = root.getString("name");
            JSONArray favourites = root.getJSONArray("favourites");

            // Print output in the required format
            System.out.println("Name: " + name);
            for (int i = 0; i < favourites.length(); i++) {
                JSONObject item = favourites.getJSONObject(i);
                int id = item.getInt("id");
                String title = item.getString("title");
                System.out.println(id + " - " + title);
            }

        } catch (UnirestException e) {
            // Clean error message if the server is offline or unreachable
            System.out.println("Could not reach server at " + SERVER_BASE_URL + ": " + e.getMessage());
        } finally {
            Unirest.shutDown();
        }
    }
}