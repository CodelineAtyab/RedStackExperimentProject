package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class Main {
    public static void main(String[] args) {

        String baseUrl = "http://192.168.100.247:8080/feedback";

        System.out.println("--- POST Request ---");
        String postBody1 = "{\"name\": \"Sara\", \"message\": \"Great service\"}";
        HttpResponse<JsonNode> postResponse1 = Unirest.post(baseUrl)
                .header("Content-Type", "application/json")
                .body(postBody1)
                .asJson();
        System.out.println("Created 1: " + postResponse1.getBody().toPrettyString());


        String postBody2 = "{\"name\": \"Ahmed\", \"message\": \"Very helpful support!\"}";
        HttpResponse<JsonNode> postResponse2 = Unirest.post(baseUrl)
                .header("Content-Type", "application/json")
                .body(postBody2)
                .asJson();
        System.out.println("Created 2: " + postResponse2.getBody().toPrettyString());


        System.out.println("\n--- GET Request ---");
        HttpResponse<JsonNode> getResponse = Unirest.get(baseUrl)
                .asJson();
        System.out.println("All Feedback:\n" + getResponse.getBody().toPrettyString());


        System.out.println("\n--- PUT Request ---");
        String putBody = "{\"message\": \"Great service, thank you so much!\"}";
        HttpResponse<JsonNode> putResponse = Unirest.put(baseUrl + "/1")
                .header("Content-Type", "application/json")
                .body(putBody)
                .asJson();
        System.out.println("Updated ID 1: " + putResponse.getBody().toPrettyString());


        System.out.println("\n--- DELETE Request ---");
        HttpResponse<String> deleteResponse = Unirest.delete(baseUrl + "/1")
                .asString();
        System.out.println("Deleted Result: " + deleteResponse.getBody());


        System.out.println("\n--- Verify Deletion ---");
        HttpResponse<JsonNode> finalGetResponse = Unirest.get(baseUrl)
                .asJson();
        System.out.println("Remaining Feedback:\n" + finalGetResponse.getBody().toPrettyString());

        Unirest.shutDown();
    }
}