package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class Main {
    public static void main(String[] args) {

        HttpResponse<JsonNode> response = Unirest.get("http://192.168.100.247:8080/profile?name=Haitham")
                .asJson();

        String rawJson = "";
        if (response.getStatus() == 200) {

            rawJson =String.valueOf(response.getBody());
        } else {
            System.out.println("Error: " + response.getStatus() + " - " + response.getBody());
        }
        JsonObject root = JsonParser.parseString(rawJson).getAsJsonObject();
        String name = root.get("name").getAsString();
        JsonArray favs = root.getAsJsonArray("favourites");
        System.out.println("Name: "+name);
        for (int i = 0; i < 3; i++) {
            JsonObject list = favs.get(i).getAsJsonObject();
            int Id = list.get("id").getAsInt();
            String title = list.get("title").getAsString();
            System.out.println(Id+" - "+title);
        }



    }
}