package com.ProfileClient;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class ProfileClient {

    public static void main(String[] args) {

        String serverUrl = "http://localhost:8080/feedback";

        try {

            //post-->add feedback
            JSONObject feedback = new JSONObject();
            feedback.put("name", "Aya");
            feedback.put("message", "Great service!");

            HttpResponse<JsonNode> postResponse = Unirest.post(serverUrl)
                    .header("Content-Type", "application/json")
                    .body(feedback.toString())
                    .asJson();

            System.out.println("Created: " + postResponse.getBody());

            int feedbackId = postResponse.getBody().getObject().getInt("id");


            // get all
            HttpResponse<JsonNode> getResponse = Unirest.get(serverUrl)
                    .asJson();

            JSONArray feedbackList = getResponse.getBody().getArray();

            System.out.println("\nAll feedback:");

            for (int i = 0; i < feedbackList.length(); i++) {
                System.out.println(feedbackList.getJSONObject(i));
            }


            // put
            JSONObject updateData = new JSONObject();
            updateData.put("message", "Excellent service!");

            HttpResponse<JsonNode> putResponse = Unirest.put(serverUrl + "/" + feedbackId)
                    .header("Content-Type", "application/json")
                    .body(updateData.toString())
                    .asJson();

            System.out.println("\nUpdated: " + putResponse.getBody());


            //get feedback
            HttpResponse<JsonNode> getResponse2 = Unirest.get(serverUrl)
                    .asJson();

            System.out.println("\nFeedback after update: "
                    + getResponse2.getBody().getArray());


            // delete
            HttpResponse<JsonNode> deleteResponse = Unirest.delete(serverUrl + "/" + feedbackId)
                    .asJson();

            System.out.println("\nDeleted: " + deleteResponse.getBody());


            // get
            HttpResponse<JsonNode> finalResponse = Unirest.get(serverUrl)
                    .asJson();

            JSONArray remainingFeedback = finalResponse.getBody().getArray();

            System.out.println("\nRemaining feedback: " + remainingFeedback);

        } catch (Exception e) {

            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();

        } finally {

            Unirest.shutDown();
        }
    }
}
