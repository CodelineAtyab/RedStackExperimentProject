import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class UnirestRequest {
    public static void main(String[] args) {
        // 1. Send GET request to your friend's server
        HttpResponse<JsonNode> response = Unirest.get("http://192.168.100.124:8080/profile?name=alaa").asJson();

        // 2. Read the response as a JSONObject
        JSONObject jsonObject = response.getBody().getObject();

        // 3. Get and print the "name" from the outer JSONObject
        System.out.println("Name: " + jsonObject.getString("name"));

        // 4. Read the "favorites" array
        JSONArray favouritesList = jsonObject.getJSONArray("favourites");

        // 5. Loop through the array and print each item
        for (int index = 0; index < favouritesList.length(); index++) {
            JSONObject currObj = favouritesList.getJSONObject(index);
            System.out.println(currObj.getInt("id") + " - " + currObj.getString("title"));
        }
    }
}
