
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class DistanceFinder {
    public static void main(String[] args) {

        //starting location.
        String source = "Muscat";
        //destination location
        String destination = "Sohar";

        // that key used to authenticate our api request(from Atyab).
        String apiKey = System.getenv("API_KEY");  // Replace this by reading from the environment variable

        //the url is the api endpoint. it tells our program where to send the request
        // get the url from this website (https://developers.google.com/maps/documentation/routes/reference/rest/v2/TopLevel/computeRoutes?utm_source)
        //(Google Maps Platform)
        String url = "https://routes.googleapis.com/directions/v2:computeRoutes";

        // use try because sometimes the code might cause an exception , like: Api error and the connection
        try {

            // Send a request to Google API.
            // Unirest.post>>> use post to send the data to google api , i use get and got error
            HttpResponse<JsonNode> response = Unirest.post(url)

                    // to sends the API key to Google for authentication>>> check it in postman and it is work
                    .header("X-Goog-Api-Key", apiKey)

                    // that to tells Google which response we want.( only need the route distance)
                    .header("X-Goog-FieldMask", "routes.distanceMeters")

                    //tells Google that the request body is in JSON format>>> in task we need json format
                    .header("Content-Type", "application/json")

                    // The information we need to send.
                    .body("{\"origin\":{\"address\":\"" + source +
                            "\"},\"destination\":{\"address\":\"" + destination +
                            "\"},\"travelMode\":\"DRIVE\"}")

                    .asJson();



            // gets the response from Google and lets us read its JSON data.
            JSONObject result = response.getBody().getObject();
            // get the route
            JSONObject route = result.getJSONArray("routes").getJSONObject(0);

            double distance = route.getDouble("distanceMeters") / 1000;

            System.out.println("Distance from " + source + " to " + destination + ": " + distance + " km");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        Unirest.shutDown();
    }
}
