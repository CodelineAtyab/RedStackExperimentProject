package com.RedStack.ProfileClient;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class FeedbackClient {


    private static final String SERVER_URL = "http://localhost:8080";

    public static void main(String[] args) {
        String baseUrl = args.length > 0 ? args[0] : SERVER_URL;

        try {

            JSONObject first = create(baseUrl, "Mohammed", "Great service");
            System.out.println("Created: " + format(first));
            JSONObject second = create(baseUrl, "Salim", "Fast delivery");
            System.out.println("Created: " + format(second));

            printAll(baseUrl);


            int id = first.getInt("id");
            JSONObject updated = update(baseUrl, id, "Great service, thank you");
            System.out.println("Updated: " + format(updated));
            printAll(baseUrl);


            HttpResponse<JsonNode> deleted = Unirest.delete(baseUrl + "/feedback/" + id).asJson();
            System.out.println("Deleted: " + deleted.getBody().getObject().getInt("deleted"));
            printAll(baseUrl);


            HttpResponse<JsonNode> missing = Unirest.delete(baseUrl + "/feedback/999").asJson();
            System.out.println("Delete 999 -> HTTP " + missing.getStatus() + " "
                    + missing.getBody().getObject().getString("error"));

        } catch (UnirestException e) {
            System.out.println("Could not reach the server at " + baseUrl
                    + ". Is it running, and are both computers on the same network?");
        } catch (Exception e) {
            System.out.println("Unexpected response from the server: " + e.getMessage());
        } finally {
            Unirest.shutDown();
        }
    }

    private static JSONObject create(String baseUrl, String name, String message) {
        JSONObject body = new JSONObject().put("name", name).put("message", message);
        HttpResponse<JsonNode> response = Unirest.post(baseUrl + "/feedback")
                .header("Content-Type", "application/json")
                .body(body.toString())
                .asJson();
        return response.getBody().getObject();
    }

    private static JSONObject update(String baseUrl, int id, String message) {
        JSONObject body = new JSONObject().put("message", message);
        HttpResponse<JsonNode> response = Unirest.put(baseUrl + "/feedback/" + id)
                .header("Content-Type", "application/json")
                .body(body.toString())
                .asJson();
        return response.getBody().getObject();
    }

    private static void printAll(String baseUrl) {
        HttpResponse<JsonNode> response = Unirest.get(baseUrl + "/feedback").asJson();
        JSONArray all = response.getBody().getArray(); // the top level is an array
        System.out.println("All feedback: " + all.length() + " item(s)");
        for (int i = 0; i < all.length(); i++) {
            System.out.println("  " + format(all.getJSONObject(i)));
        }
    }

    private static String format(JSONObject item) {
        return item.getInt("id") + " - " + item.getString("name") + " - " + item.getString("message");
    }
}