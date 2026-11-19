import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class ProfileClient {
    public static void main(String[] args) {
        String serverAddress = "http://localhost:8080";
        if (args.length > 0) {
            serverAddress = args[0];
        }
        String name = "Sara";
        if (args.length > 1) {
            name = args[1];
        }

        try {
            Unirest.config().connectTimeout(10000).socketTimeout(10000);
            HttpResponse<JsonNode> response = Unirest.get(serverAddress + "/profile")
                    .queryString("name", name).asJson();

            if (response.getStatus() != 200) {
                System.out.println("Request failed. HTTP " + response.getStatus());
                return;
            }

            JSONObject profile = response.getBody().getObject();
            System.out.println("Name: " + profile.getString("name"));
            JSONArray favourites = profile.getJSONArray("favourites");

            for (int i = 0; i < favourites.length(); i++) {
                JSONObject favourite = favourites.getJSONObject(i);
                System.out.println(favourite.getInt("id") + " - "
                        + favourite.getString("title"));
            }
        } catch (UnirestException e) {
            System.out.println("Could not reach the server. Check its address and port.");
        } catch (RuntimeException e) {
            System.out.println("Could not read the profile JSON.");
        } finally {
            Unirest.shutDown();
        }
    }
}
