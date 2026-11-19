

package org.example;
import kong.unirest.Unirest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

public class Main {

    public static void main(String[] args) {

        String url = "http://localhost:8080/feedback";

        // 1. POST - Create feedback
        HttpResponse<JsonNode> postResponse = Unirest.post(url)
                .header("Content-Type", "application/json")
                .body("{\"id\":\"1\",\"name\":\"Sara\",\"message\":\"Great service\"}")
                .asJson();

        JsonNode created = postResponse.getBody();

        System.out.println("Created: "
                + created.getObject().getString("id") + " - "
                + created.getObject().getString("name") + " - "
                + created.getObject().getString("message"));


        // 2. GET - Retrieve all feedback
        HttpResponse<JsonNode> getResponse = Unirest.get(url)
                .asJson();

        JsonNode allFeedback = getResponse.getBody();

        System.out.println("All feedback: "
                + allFeedback.getArray().length() + " item");


        // 3. PUT - Update feedback
        HttpResponse<JsonNode> putResponse = Unirest.put(url + "/1")
                .header("Content-Type", "application/json")
                .body("{\"message\":\"Great service, thank you!\"}")
                .asJson();

        JsonNode updated = putResponse.getBody();

        System.out.println("Updated: "
                + updated.getObject().getString("id") + " - "
                + updated.getObject().getString("name") + " - "
                + updated.getObject().getString("message"));


        // 4. DELETE - Delete feedback
        HttpResponse<String> deleteResponse = Unirest.delete(url + "/1")
                .asString();

        System.out.println("Deleted: 1");

    }
}