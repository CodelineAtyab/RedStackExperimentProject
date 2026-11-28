package com.redstack.reddesk_client;

import kong.unirest.UnirestException;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;


public class UnirestClient {

    private static final String BASE_URL = "http://192.168.100.22:8080";

    public static void main(String[] args) {
        try {
            String profileurl = BASE_URL + "/profile";

            // Send request
            HttpResponse<JsonNode> response = Unirest.get(profileurl)
                    .queryString("name", "Sara")
                    .asJson();

            if (!response.isSuccess()) {
                System.out.println("Profile request failed: " + response.getStatus());
            } else {
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
            }


            String feedbackurl = BASE_URL + "/feedback";

            // 1. POST - Create first feedback
            String feedback1 = """
            {
                "name": "Sara",
                "message": "Great service"
            }
            """;

            HttpResponse<JsonNode> postResponse = Unirest.post(feedbackurl)
                    .header("Content-Type", "application/json")
                    .body(feedback1)
                    .asJson();

            if (!postResponse.isSuccess()) {
                System.out.println("First POST failed: " + postResponse.getStatus());
                return;
            }

            System.out.println("Created:");
            System.out.println(postResponse.getBody());

            // 2. POST - Create second feedback
            String feedback2 = """
            {
                "name": "Ahmed",
                "message": "Slow delivery"
            }
            """;

            HttpResponse<JsonNode> postResponse2 = Unirest.post(feedbackurl)
                    .header("Content-Type", "application/json")
                    .body(feedback2)
                    .asJson();

            if (!postResponse2.isSuccess()) {
                System.out.println("Second POST failed: " + postResponse2.getStatus());
                return;
            }

            System.out.println("Created:");
            System.out.println(postResponse2.getBody());

            int id1 = postResponse.getBody().getObject().getInt("id");
            int id2 = postResponse2.getBody().getObject().getInt("id");

            // 3. GET - Get all feedback
            HttpResponse<JsonNode> getResponse = Unirest.get(feedbackurl)
                    .asJson();

            if (!getResponse.isSuccess()) {
                System.out.println("GET feedback failed: " + getResponse.getStatus());
                return;
            }

            JSONArray feedbackList = getResponse.getBody().getArray();

            System.out.println("\nAll feedback:");

            for (int i = 0; i < feedbackList.length(); i++) {

                JSONObject feedback = feedbackList.getJSONObject(i);

                System.out.println(
                        feedback.getInt("id") + " - " +
                                feedback.getString("name") + " - " +
                                feedback.getString("message")
                );
            }

            // 4. PUT - Update feedback with ID 1
            String updatedMessage = """
            {
                "message": "Excellent service"
            }
            """;

            HttpResponse<JsonNode> putResponse = Unirest.put(feedbackurl + "/" + id1)
                    .header("Content-Type", "application/json")
                    .body(updatedMessage)
                    .asJson();

            if (!putResponse.isSuccess()) {
                System.out.println("PUT failed: " + putResponse.getStatus());
                return;
            }

            System.out.println("\nUpdated:");
            System.out.println(putResponse.getBody());

            // 5. DELETE - Delete feedback with ID 2
            HttpResponse<String> deleteResponse = Unirest.delete(feedbackurl + "/" + id2)
                    .asString();

            System.out.println("\nDeleted:");
            System.out.println(deleteResponse.getBody());
            System.out.println("Delete status: " + deleteResponse.getStatus());

            // 6. GET - Check remaining feedback
            HttpResponse<JsonNode> finalResponse = Unirest.get(feedbackurl)
                    .asJson();

            if (!finalResponse.isSuccess()) {
                System.out.println("Final GET failed: " + finalResponse.getStatus());
                return;
            }

            System.out.println("\nRemaining feedback:");

            JSONArray remainingFeedback = finalResponse.getBody().getArray();

            for (int i = 0; i < remainingFeedback.length(); i++) {

                JSONObject feedback = remainingFeedback.getJSONObject(i);

                System.out.println(
                        feedback.getInt("id") + " - " +
                                feedback.getString("name") + " - " +
                                feedback.getString("message")
                );
            }
        }catch (UnirestException e){
            System.out.println("Could not connect to the server.");
            System.out.println("Please make sure the server is running.");

        }catch (Exception e){
            System.out.println("Unexpected error: " + e.getMessage());

        }finally {
            Unirest.shutDown();

        }
    }
}
