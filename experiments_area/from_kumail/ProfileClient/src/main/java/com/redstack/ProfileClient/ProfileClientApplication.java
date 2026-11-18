package com.redstack.ProfileClient;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class ProfileClient {

    public static void main(String[] args) {

        String BURL = "http://192.168.100.69:8080";

        try {

            HttpResponse<JsonNode> post1 = Unirest.post(BURL + "/feedback")
                    .header("Content-Type", "application/json")
                    .body("{\"name\":\"Sara\",\"message\":\"Great service\"}")
                    .asJson();

            System.out.println("Created: " + post1.getBody());

            HttpResponse<JsonNode> post2 = Unirest.post(BURL + "/feedback")
                    .header("Content-Type", "application/json")
                    .body("{\"name\":\"Ahmed\",\"message\":\"Good coffee\"}")
                    .asJson();

            System.out.println("Created: " + post2.getBody());

            HttpResponse<JsonNode> get1 = Unirest.get(BURL + "/feedback")
                    .asJson();

            System.out.println("All feedback: " + get1.getBody());

            HttpResponse<JsonNode> put = Unirest.put(BURL + "/feedback/1")
                    .header("Content-Type", "application/json")
                    .body("{\"message\":\"Great service, thank you\"}")
                    .asJson();

            System.out.println("Updated: " + put.getBody());

            HttpResponse<JsonNode> get2 = Unirest.get(BURL + "/feedback")
                    .asJson();

            System.out.println("After update: " + get2.getBody());

            HttpResponse<JsonNode> delete = Unirest.delete(BURL + "/feedback/1")
                    .asJson();

            System.out.println("Deleted: " + delete.getBody());

            HttpResponse<JsonNode> get3 = Unirest.get(BURL + "/feedback")
                    .asJson();

            System.out.println("Remaining: " + get3.getBody());

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        } finally {
            Unirest.shutDown();
        }
    }
}