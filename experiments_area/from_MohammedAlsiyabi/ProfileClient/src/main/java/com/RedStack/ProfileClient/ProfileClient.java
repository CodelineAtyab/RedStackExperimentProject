package com.RedStack.ProfileClient;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class ProfileClient {

    // CHANGE THE SERVER ADDRESS HERE (only place). Partner's IP, not localhost.
    private static final String SERVER_URL = "http://192.168.100.12:8080";

    private static final String NAME = "Mohammed";

    public static void main(String[] args) {
        String baseUrl = args.length > 0 ? args[0] : SERVER_URL;

        try {
            HttpResponse<JsonNode> response = Unirest.get(baseUrl + "/profile")
                    .queryString("name", NAME)
                    .asJson();

            if (!response.isSuccess()) {
                System.out.println("Server error: HTTP " + response.getStatus());
                return;
            }

            JSONObject profile = response.getBody().getObject();
            System.out.println("Name: " + profile.getString("name"));

            JSONArray favourites = profile.getJSONArray("favourites");
            for (int i = 0; i < favourites.length(); i++) {
                JSONObject item = favourites.getJSONObject(i);
                System.out.println(item.getInt("id") + " - " + item.getString("title"));
            }
        } catch (UnirestException e) {
            System.out.println("Could not reach the server at " + baseUrl
                    + ". Is it running, and are both computers on the same network?");
        } finally {
            Unirest.shutDown();
        }
    }
}