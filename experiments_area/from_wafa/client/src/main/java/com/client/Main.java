package com.client;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class Main {
    public static void main(String[] args) {

        String url = "http://192.168.100.105:8080/profile?name=Wafa";

        try {
            HttpResponse<JsonNode> response = Unirest.get(url).asJson();

            if (response.getStatus() != 200) {
                System.out.println("Error: " + response.getStatus());
                return;
            }

            JSONObject obj = response.getBody().getObject();
            System.out.println("Name: " + obj.getString("name"));

            JSONArray favs = obj.getJSONArray("favourites");
            for (int i = 0; i < favs.length(); i++) {
                JSONObject item = favs.getJSONObject(i);
                System.out.println(item.getInt("id") + " - " + item.getString("title"));
            }

        } catch (Exception e) {
            System.out.println("Could not reach the server: " + e.getMessage());
        }
    }
}