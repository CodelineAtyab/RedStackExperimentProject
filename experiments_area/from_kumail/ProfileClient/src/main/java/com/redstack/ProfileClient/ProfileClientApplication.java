package com.redstack.ProfileClient;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import kong.unirest.json.JSONArray;

public class ProfileClientApplication {

	private static final String SERVER_URL = "http://192.168.100.33:8080";

	public static void main(String[] args) {

		try {
			HttpResponse<JsonNode> response = Unirest.get(SERVER_URL + "/profile").queryString("name", "Kumail").asJson();

			if (response.getStatus() != 200) {
				System.out.println("Server returned status: " + response.getStatus());
				return;
			}

			JSONObject profile = response.getBody().getObject();

			String name = profile.getString("name");
			System.out.println("Name: " + name);

			JSONArray favourites = profile.getJSONArray("favourites");

			for (int i = 0; i < favourites.length(); i++) {
				JSONObject item = favourites.getJSONObject(i);

				int id = item.getInt("id");
				String title = item.getString("title");

				System.out.println(id + " - " + title);
			}

		} catch (Exception e) {
			System.out.println("Could not connect to the server.");
		} finally {
			Unirest.shutDown();
		}
	}
}