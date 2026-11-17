package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        HttpResponse<JsonNode> response = Unirest.get("https://api.nationalize.io?name=Atyab").asJson();
        JSONObject jsonObject = response.getBody().getObject();

        System.out.println(jsonObject.getString("name"));
    }
}