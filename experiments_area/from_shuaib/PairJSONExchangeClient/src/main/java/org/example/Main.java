package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        String serverUrl = "http://192.168.100.38:8080/profile?name=Sara";

        try {
            HttpResponse<JsonNode> response = Unirest.get(serverUrl).asJson();

            if (response.getStatus() == 200) {
                JSONObject body = response.getBody().getObject();

                String name = body.getString("name");
                System.out.println("Name: " + name);

                JSONArray favourites = body.getJSONArray("favourites");
                for (int i = 0; i < favourites.length(); i++) {
                    JSONObject item = favourites.getJSONObject(i);
                    int id = item.getInt("id");
                    String title = item.getString("title");
                    System.out.println(id + " - " + title);
                }
            } else {
                System.out.println("Server responded with status code: " + response.getStatus());
            }

        } catch (Exception e) {
            System.out.println("Error: Could not connect to the server at " + serverUrl + ". Check your network connection or server status.");
        } finally {
            Unirest.shutDown();
        }
    }
}