package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import kong.unirest.json.JSONArray;

public class Main {

    static String printInformationFromServerRequest(String link) {

        HttpResponse<JsonNode> response = Unirest.get(link)
                .queryString("name", "Sara")
                .asJson();

        JSONObject profile = response.getBody().getObject();

        String result = "Name: " + profile.getString("name") + "\n";

        JSONArray favourites = profile.getJSONArray("favourites");

        // Loop through each favourite
        for (int i = 0; i < favourites.length(); i++) {

            JSONObject favourite = favourites.getJSONObject(i);

            int id = favourite.getInt("id");
            String title = favourite.getString("title");

            result += id + " - " + title + "\n";
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(
                printInformationFromServerRequest(
                        "http://localhost:8080/profile"
                )
        );
    }
}