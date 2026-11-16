import kong.unirest.core.HttpResponse;
import kong.unirest.core.JsonNode;
import kong.unirest.core.Unirest;
import kong.unirest.core.json.JSONArray;
import kong.unirest.core.json.JSONObject;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String origin = "Muscat";
        String destination = "Sohar";

        String apiKey = System.getenv("MAPS_API_KEY");
        if (apiKey == null || apiKey.trim().isEmpty()) {
            apiKey = "YOUR_API_KEY_HERE";
        }
    }
}