package com.almuatsam.profileclient;

import kong.unirest.Unirest;
import kong.unirest.Empty;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;


public class App {
    private static final String SERVER_URL = "http://localhost:8081";

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

            JSONObject newFeedback = new JSONObject()
                    .put("id", 0)
                    .put("name", "Sara")
                    .put("message", "Created from Java client");

            HttpResponse<JsonNode> postResponse = Unirest.post(SERVER_URL + "/feedback")
                    .header("Content-Type", "application/json")
                    .body(newFeedback.toString())
                    .asJson();

            int feedbackId = postResponse.getBody().getObject().getInt("id");

            System.out.println("POST /feedback: " + postResponse.getBody());

            HttpResponse<JsonNode> getResponse = Unirest.get(SERVER_URL + "/feedback")
                    .asJson();

            System.out.println("GET /feedback: " + getResponse.getBody());

            JSONObject updatedFeedback = new JSONObject()
                    .put("id", 0)
                    .put("name", "Sara")
                    .put("message", "Updated from Java client");

            HttpResponse<JsonNode> putResponse = Unirest.put(SERVER_URL + "/feedback/" + feedbackId)
                    .header("Content-Type", "application/json")
                    .body(updatedFeedback.toString())
                    .asJson();

            System.out.println("PUT /feedback/" + feedbackId + ": " + putResponse.getBody());

            HttpResponse<Empty> deleteResponse = Unirest.delete(SERVER_URL + "/feedback/" + feedbackId)
                    .asEmpty();

            System.out.println("DELETE /feedback/" + feedbackId + ": " + deleteResponse.getStatus());

            HttpResponse<JsonNode> finalGetResponse = Unirest.get(SERVER_URL + "/feedback")
                    .asJson();

            System.out.println("Final GET /feedback: " + finalGetResponse.getBody());
        } catch (UnirestException e) {
            System.out.println("Could not connect to the profile server. Check that the server is running and the address is correct.");
        }
    }
}
