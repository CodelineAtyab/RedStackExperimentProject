package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String apiKey = System.getenv("GoogleAPI");
        JsonObject origin = new JsonObject();
        origin.addProperty("address","Muscat");
        JsonObject dest = new JsonObject();
        dest.addProperty("address","Sohar");
        JsonObject requestBody = new JsonObject();
        requestBody.add("origin", origin);
        requestBody.add("destination", dest);


        HttpResponse<JsonNode> response = Unirest.post("https://routes.googleapis.com/directions/v2:computeRoutes")
                .header("Content-Type", "application/json")
                .header("X-Goog-Api-Key", apiKey)
                .header("X-Goog-FieldMask", "routes.duration,routes.distanceMeters")
                .body(requestBody.toString())
                .asJson();
        String rawJson ="";
        if (response.getStatus() == 200) {
            rawJson = String.valueOf(response.getBody());
        } else {
            System.out.println("Error: " + response.getStatus() + " - " + response.getBody());
        }
        JsonObject root = JsonParser.parseString(rawJson).getAsJsonObject();
        JsonArray list = root.getAsJsonArray("routes");
        JsonObject firstItem = list.get(0).getAsJsonObject();
        int distance = firstItem.get("distanceMeters").getAsInt();
        double km = distance / 1000.0;
        System.out.printf("Distance from %s to %s: %.1f km%n", origin.get("address"), dest.get("address"), km);



        JsonObject origin2 = new JsonObject();
        origin2.addProperty("address","Ruwi");
        JsonObject dest2 = new JsonObject();
        dest2.addProperty("address","Seeb");
        JsonObject req = new JsonObject();
        req.add("origin", origin2);
        req.add("destination",dest2);
        HttpResponse<JsonNode> response2 = Unirest.post("https://routes.googleapis.com/directions/v2:computeRoutes")
                .header("Content-Type", "application/json")
                .header("X-Goog-Api-Key", apiKey)
                .header("X-Goog-FieldMask", "routes.duration,routes.distanceMeters")
                .body(req.toString())
                .asJson();
        String rawJson2 ="";
        if (response.getStatus() == 200) {
            rawJson2 = String.valueOf(response2.getBody());
        } else {
            System.out.println("Error: " + response.getStatus() + " - " + response.getBody());
        }
        JsonObject root2 = JsonParser.parseString(rawJson2).getAsJsonObject();
        JsonArray list2 = root2.getAsJsonArray("routes");
        JsonObject firstitem2 = list2.get(0).getAsJsonObject();
        int disance2 = firstitem2.get("distanceMeters").getAsInt();
        double km2 = disance2 / 1000.0;
        System.out.printf("Distance from %s to %s: %.1f km%n", origin2.get("address"), dest2.get("address"), km2);


    }
}