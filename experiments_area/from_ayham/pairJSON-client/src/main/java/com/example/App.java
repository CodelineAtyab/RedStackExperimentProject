// mvn clean compile
// mvn exec:java "-Dexec.mainClass=com.example.App"

package com.example;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import java.util.List;

public class App {
    private static final String SERVER_URL = "http://192.168.100.125:8081";
    private static final String NAME = "Alice";

    public static void main(String[] args) throws UnirestException {
        try {
            Profile profile = fetchProfile(SERVER_URL, NAME);
            System.out.println("Name: " + profile.name());
            for (Favourite favourite : profile.favourites()) {
                System.out.println("ID: " + favourite.id() + ", Title: " + favourite.title());
            }
        } finally {
            Unirest.shutDown();
        }
    }

    static Profile fetchProfile(String serverUrl, String name) throws UnirestException {
        String profileUrl = serverUrl.replaceAll("/+$", "") + "/profile";
        HttpResponse<Profile> response = Unirest.get(profileUrl).queryString("name", name).asObject(Profile.class);

        if (response.getStatus() < 200 || response.getStatus() >= 300) {
            throw new IllegalStateException("Server returned HTTP " + response.getStatus()
                    + " " + response.getStatusText());
        }

        Profile profile = response.getBody();
        if (profile == null) {
            throw new IllegalStateException("Server returned an empty profile response");
        }
        return profile;
    }

    public record Profile(String name, List<Favourite> favourites) {
    }

    public record Favourite(int id, String title) {
    }
}
