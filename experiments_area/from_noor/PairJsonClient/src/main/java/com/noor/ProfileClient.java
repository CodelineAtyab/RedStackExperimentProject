
package com.noor;
import kong.unirest.Unirest;
import kong.unirest.HttpResponse;
import kong.unirest.json.JSONObject;
import kong.unirest.json.JSONArray;

public class ProfileClient {

    public static void main(String[] args) {


        HttpResponse<String> response = Unirest.get("http://192.168.100.134:8080/profile")
                .queryString("name", "buthaina")
                .asString();


        JSONObject json = new JSONObject(response.getBody());
        String name = json.getString("name");
        System.out.println("Name: " + name);
        JSONArray favourites = json.getJSONArray("favourites");
        for (int i = 0; i < favourites.length(); i++) {

            JSONObject item = favourites.getJSONObject(i);

            int id = item.getInt("id");
            String title = item.getString("title");

            System.out.println(id + " - " + title);
        }
    }
}
