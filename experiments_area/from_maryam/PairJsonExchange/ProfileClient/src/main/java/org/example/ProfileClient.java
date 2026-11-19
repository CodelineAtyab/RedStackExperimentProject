package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import kong.unirest.json.JSONArray;

public class ProfileClient {

    public static void main(String[] args) {

        // send name Maryam to the server
        String name = "Aya";

        // send a get request to the server by using its IP address and port.
        HttpResponse<JsonNode> response = Unirest.get("http://192.168.100.21:8080/profile")// my computer ip
                //her to send the name as a query parameter
                .queryString("name", name)
                // this for receive the response in JSON format.
                .asJson();



        // her to get the response body and convert it to JSON object.
        JSONObject profile = response.getBody().getObject();


        System.out.println("Name: " + profile.getString("name"));

        // her to get the favourites array from the JSON object.
        JSONArray favourites = profile.getJSONArray("favourites");

        // use loop for all the elements in the favourites array.
        for (int i = 0; i < favourites.length(); i++) {

            JSONObject favourite = favourites.getJSONObject(i);

            // her to get the id and title from the current favourite.
            int id = favourite.getInt("id");
            String title = favourite.getString("title");

            // her to print the id and title
            System.out.println(id + " - " + title);
        }

        Unirest.shutDown();
    }
}