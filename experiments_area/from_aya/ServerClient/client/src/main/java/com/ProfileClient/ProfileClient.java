package com.ProfileClient;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import kong.unirest.json.JSONArray;

public class ProfileClient {

    public static void main(String[] args) {

        String serverUrl = "http://192.168.100.134:8080/profile";

        HttpResponse<JsonNode> response = Unirest.get(serverUrl)
                .queryString("name", "Maryam")
                .asJson();

        JSONObject body = response.getBody().getObject();

        System.out.println("Name: " + body.getString("name"));

        JSONArray favourites = body.getJSONArray("favourites");

        for (int i = 0; i < favourites.length(); i++) {

            JSONObject favourite = favourites.getJSONObject(i);

            System.out.println(favourite.getInt("id") + " - " + favourite.getString("title"));
        }
    }
}
