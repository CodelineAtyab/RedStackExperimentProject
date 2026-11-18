package com.almuatsam.profileclient;

import kong.unirest.Unirest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;


public class App {
    private static final String SERVER_URL = "http://192.168.100.67:8080";

    public static void main(String[] args) {
        try {
            HttpResponse<JsonNode> response = Unirest.get(SERVER_URL + "/profile")
                    .queryString("name", "Sara")
                    .asJson();

            System.out.println("Name: " + response.getBody().getObject().getString("name"));
            JSONArray favourites = response.getBody().getObject().getJSONArray("favourites");

            for (int i = 0; i < favourites.length(); i++) {
                JSONObject favourite = favourites.getJSONObject(i);
                int id = favourite.getInt("id");
                String title = favourite.getString("title");
                System.out.println(id + " - " + title);
            }
        } catch (UnirestException e) {
            System.out.println("Could not connect to the profile server. Check that the server is running and the address is correct.");
        }
    }
}
