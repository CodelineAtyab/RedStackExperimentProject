package com.redstack.ProfileServer;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class ProfileClient {
    private static final String SERVER_ADDRESS = "http://192.168.100.0:8080";

    public static void main(String[] args) {
        String nameToRequest = "Salim";

        try {
            HttpResponse<JsonNode> response = Unirest.get(SERVER_ADDRESS + "/profile")
                    .queryString("name", nameToRequest)
                    .asJson();

            if (response.getStatus() < 200 || response.getStatus() >= 300) {
                System.out.println("Server returned HTTP status " + response.getStatus());
                return;
            }

            JSONObject profile = response.getBody().getObject();
            String name = profile.getString("name");
            JSONArray favourites = profile.getJSONArray("favourites");

            System.out.println("Name: " + name);

            for (int i = 0; i < favourites.length(); i++) {
                JSONObject favourite = favourites.getJSONObject(i);
                int id = favourite.getInt("id");
                String title = favourite.getString("title");
                System.out.println(id + " - " + title);
            }
        } catch (Exception e) {
            System.out.println("Could not reach the profile server at " + SERVER_ADDRESS);
            System.out.println("Details: " + e.getMessage());
        } finally {
            Unirest.shutDown();
        }
    }
}
