package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class Main {
    public static void main(String[] args) {

//        HttpResponse<JsonNode> response = Unirest.get("http://192.168.100.247:8080/profile?name=Haitham")
//                .asJson();
//
//        String rawJson = "";
//        if (response.getStatus() == 200) {
//
//            rawJson =String.valueOf(response.getBody());
//        } else {
//            System.out.println("Error: " + response.getStatus() + " - " + response.getBody());
//        }
//        JsonObject root = JsonParser.parseString(rawJson).getAsJsonObject();
//        String name = root.get("name").getAsString();
//        JsonArray favs = root.getAsJsonArray("favourites");
//        System.out.println("Name: "+name);
//        for (int i = 0; i < 3; i++) {
//            JsonObject list = favs.get(i).getAsJsonObject();
//            int Id = list.get("id").getAsInt();
//            String title = list.get("title").getAsString();
//            System.out.println(Id+" - "+title);
//        }

        HttpResponse<String> post= Unirest.post("http://192.168.100.69:8080/feedback")
                .header("Content-Type", "application/json")
                .body("{\r\n  \"name\": \"Haitssham\",\r\n  \"message\": \"hellfdo\"\r\n}")
                .asString();
        System.out.println(post.getBody());


        HttpResponse<String> get = Unirest.get("http://192.168.100.69:8080/feedback")
                .asString();
        System.out.println(get.getBody());


        HttpResponse<String> Put = Unirest.put("http://192.168.100.69:8080/feedback/6")
                .header("Content-Type", "application/json")
                .body("{\r\n  \"name\": \"Haithsssam\",\r\n  \"message\": \"helggglo\"\r\n}")
                .asString();
        System.out.println(Put.getBody());

        HttpResponse<String> delete = Unirest.delete("http://192.168.100.69:8080/feedback/8")
                .asString();
        System.out.println(delete.getBody());

    }
}