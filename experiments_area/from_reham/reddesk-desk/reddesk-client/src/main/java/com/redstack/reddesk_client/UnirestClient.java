package com.redstack.reddesk_client;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;


public class UnirestClient {
    public static void main(String[] args) {

        String url = "http://192.168.100.22:8080/profile";

        // Send request
        HttpResponse<JsonNode> response = Unirest.get(url)
                .queryString("name", "Sara")
                .asJson();

        // Get JSON object
        JSONObject profile = response.getBody().getObject();

        // Get name
        System.out.println("Name: " + profile.getString("name"));

        // Get array
        JSONArray favourites = profile.getJSONArray("favourites");

        // Print each item
        for (int i = 0; i < favourites.length(); i++) {

            JSONObject item = favourites.getJSONObject(i);

            System.out.println(item.getInt("id") + " - " + item.getString("title"));
        }

        Unirest.shutDown();


    }
}
