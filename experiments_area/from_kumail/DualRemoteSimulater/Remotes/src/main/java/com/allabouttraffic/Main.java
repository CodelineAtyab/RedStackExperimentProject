package com.allabouttraffic;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class Main {

    public static void main(String[] args) {
        // Appended /get to the URL string
        HttpResponse<JsonNode> response = Unirest.get("https://httpbin.org")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer YOUR_TOKEN")
                .queryString("fruit", "apple")
                .queryString("limit", "10")
                .asJson();

        System.out.println("Status: " + response.getStatus());

        // This will now successfully print the JSON object
        if (response.getBody() != null) {
            System.out.println("JSON Output: " + response.getBody().getObject().toString());
        } else {
            System.out.println("Response body was empty or not valid JSON.");
        }
    }
}