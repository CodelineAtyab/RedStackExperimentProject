package com.unirestGetClient;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class Main {
    public static void main(String[] args) {

        HttpResponse<JsonNode> response = Unirest.get("http://192.168.100.70:8080/profile?name=Latifa").asJson();

        String jsonData  = "";
        if (response.getStatus() == 200) {

            jsonData  =String.valueOf(response.getBody());
        } else {
            System.out.println("Error: " + response.getStatus() + " - " + response.getBody());
        }
        JsonObject root = JsonParser.parseString(jsonData).getAsJsonObject();
        String name = root.get("name").getAsString();

        JsonArray favourit = root.getAsJsonArray("favourites");
        System.out.println("Name: "+name);
        for (int i = 0; i < 3; i++) {
            JsonObject list = favourit.get(i).getAsJsonObject();
            int Id = list.get("id").getAsInt();
            String title = list.get("title").getAsString();
            System.out.println(Id+" - "+title);
        }



    }
}