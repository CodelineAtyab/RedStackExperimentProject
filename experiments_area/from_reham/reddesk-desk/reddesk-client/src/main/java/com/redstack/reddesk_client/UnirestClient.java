
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


public class UnirestClient {

    public static void main(String[] args) {

        String url = "http://localhost:8080/feedback";

        // 1. POST - Create first feedback
        String feedback1 = """
                {
                    "name": "Sara",
                    "message": "Great service"
                }
                """;

        HttpResponse<JsonNode> postResponse = Unirest.post(url)
                .header("Content-Type", "application/json")
                .body(feedback1)
                .asJson();

        System.out.println("Created:");
        System.out.println(postResponse.getBody());

        // 2. POST - Create second feedback
        String feedback2 = """
                {
                    "name": "Ahmed",
                    "message": "Slow delivery"
                }
                """;

        HttpResponse<JsonNode> postResponse2 = Unirest.post(url)
                .header("Content-Type", "application/json")
                .body(feedback2)
                .asJson();

        System.out.println("Created:");
        System.out.println(postResponse2.getBody());

        // 3. GET - Get all feedback
        HttpResponse<JsonNode> getResponse = Unirest.get(url)
                .asJson();

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

        HttpResponse<JsonNode> putResponse = Unirest.put(url + "/1")
                .header("Content-Type", "application/json")
                .body(updatedMessage)
                .asJson();

        System.out.println("\nUpdated:");
        System.out.println(putResponse.getBody());

        // 5. DELETE - Delete feedback with ID 2
        HttpResponse<String> deleteResponse = Unirest.delete(url + "/2")
                .asString();

        System.out.println("\nDeleted:");
        System.out.println(deleteResponse.getBody());

        // 6. GET - Check remaining feedback
        HttpResponse<JsonNode> finalResponse = Unirest.get(url)
                .asJson();

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

        Unirest.shutDown();
    }
}
