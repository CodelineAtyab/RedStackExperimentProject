package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String apiKey = System.getenv("TOMTOM_API_KEY");
        String muscarstartCoords = "23.586363,58.381665";
        String soharendCoords = "24.351129,56.714873";


        String endpointUrl = "https://api.tomtom.com/maps/orbis/routing/calculateRoute/"
                + muscarstartCoords + ":" + soharendCoords + "/json";

        HttpResponse<String> response = Unirest.get(endpointUrl)
                .queryString("apiVersion", "2")
                .queryString("traffic", "live")
                .queryString("key", apiKey)
                .asString();
        String rawJson ="";
        if (response.getStatus() == 200) {
            rawJson = response.getBody();
        } else {
            System.out.println("Error: " + response.getStatus() + " - " + response.getBody());
        }

        String origin = "Muscat";
        String destination = "Sohar";

        JsonObject root = JsonParser.parseString(rawJson).getAsJsonObject();
        JsonArray list = root.getAsJsonArray("routes");
        JsonObject firstItem = list.get(0).getAsJsonObject();
        JsonObject details = firstItem.getAsJsonObject("summary");
        double meters = details.get("lengthInMeters").getAsDouble();
        double km = meters / 1000.0;
        System.out.printf("Distance from %s to %s: %.1f km%n", origin, destination, km);
        // ///////////////////////////////////////////////////////////////////////////////////////

        // ruwi to seeb
        String ruwiStart = "23.597618,58.539083";
        String ruwiend = "23.647354,58.146360";
        String endpointUrl2 = "https://api.tomtom.com/maps/orbis/routing/calculateRoute/"
                + ruwiStart + ":" + ruwiend + "/json";

        HttpResponse<String> response2 = Unirest.get(endpointUrl2)
                .queryString("apiVersion", "2")
                .queryString("traffic", "live")
                .queryString("key", apiKey)
                .asString();
        String rawJson2 ="";
        if (response.getStatus() == 200) {
            rawJson2 = response2.getBody();
        } else {
            System.out.println("Error: " + response.getStatus() + " - " + response.getBody());
        }
        String origin2 = "Ruwi";
        String destination2 = "Seeb";
        JsonObject text = JsonParser.parseString(rawJson2).getAsJsonObject();
        JsonArray insideText = text.getAsJsonArray("routes");
        JsonObject firstitem2 = insideText.get(0).getAsJsonObject();
        JsonObject details2 = firstitem2.getAsJsonObject("summary");
        double meters2 = details2.get("lengthInMeters").getAsDouble();
        double km2 = meters2 / 1000.0;
        System.out.printf("Distance from %s to %s: %.1f km%n", origin2, destination2, km2);


    }
}