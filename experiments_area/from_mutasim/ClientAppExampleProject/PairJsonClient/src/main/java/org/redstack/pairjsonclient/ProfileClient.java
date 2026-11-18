
package org.redstack.pairjsonclient;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class ProfileClient {

    // Change this to your partner's server IP address.
    private static final String SERVER_BASE_URL = "http://192.168.100.245:8080";
    private static final String NAME = "Mutasim";

    public static void main(String[] args) {

             String serverUrl = args.length > 0 ? args[0] : SERVER_BASE_URL;
        String name = args.length > 1 ? args[1] : NAME;

        try {
            Unirest.config()
                    .connectTimeout(5000)
                    .socketTimeout(5000);

            HttpResponse<JsonNode> response = Unirest.get(serverUrl + "/profile")
                    .queryString("name", name)
                    .asJson();

            if (response.getStatus() != 200) {
                System.err.println("Server returned HTTP " + response.getStatus());
                return;
            }

            JSONObject profile = response.getBody().getObject();
            JSONArray Favorite = profile.getJSONArray("Favorite");

            System.out.println("Name: " + profile.getString("name"));

            for (int i = 0; i < Favorite.length(); i++) {
                JSONObject favourite = Favorite.getJSONObject(i);

                System.out.println(
                        favourite.getInt("id") + " - " +
                                favourite.getString("title")
                );
            }

        } catch (UnirestException ex) {
            System.err.println("Cannot reach server at " + serverUrl
                    + ". Check the IP address, port and network. Details: "
                    + ex.getMessage());

        } catch (RuntimeException ex) {
            System.err.println("Could not read JSON response: " + ex.getMessage());

        } finally {
            Unirest.shutDown();
        }
    }
}

