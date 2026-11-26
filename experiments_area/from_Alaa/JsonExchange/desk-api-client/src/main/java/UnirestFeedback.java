import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class UnirestFeedback {
    public static void main(String[] args) {
        String baseUrl = "http://localhost:8080";

        //POST feedback "1"
        HttpResponse<JsonNode> response = Unirest.post(baseUrl + "/feedback")
                .header("Content-Type", "application/json")
                .body("{\"name\":\"Alaa\",\"message\":\"Great service\"}")
                .asJson();

        System.out.println("Status: " + response.getStatus());
        System.out.println("Raw: " + response.getBody().toString());

        JSONObject jsonObject = response.getBody().getObject();
        System.out.println("Created: " + jsonObject.getInt("id") + " - "
                + jsonObject.getString("name") + " - " + jsonObject.getString("message"));

        //POST 2nd feedback
        response = Unirest.post(baseUrl + "/feedback")
                .header("Content-Type", "application/json")
                .body("{\"name\":\"Noor\",\"message\":\"not bad\"}")
                .asJson();

        jsonObject = response.getBody().getObject();
        System.out.println("Created: " + jsonObject.getInt("id") + " - "
                + jsonObject.getString("name") + " - " + jsonObject.getString("message"));


        //GET all feedbacks
        response = Unirest.get(baseUrl + "/feedback").asJson();
        JSONArray feedbackList = response.getBody().getArray();
        System.out.println("All feedback: " + feedbackList.length() + " items");
        for (Object item : feedbackList) {
            JSONObject currObj = (JSONObject) item;
            System.out.println(currObj.getInt("id") + " - " + currObj.getString("name")
                    + " - " + currObj.getString("message"));
        }

        //PUT, change the message of feedback 1
        response = Unirest.put(baseUrl + "/feedback/1")
                .header("Content-Type", "application/json")
                .body("{\"message\":\"Great service, thank you\"}")
                .asJson();

        jsonObject = response.getBody().getObject();
        System.out.println("Updated: " + jsonObject.getInt("id") + " - "
                + jsonObject.getString("name") + " - " + jsonObject.getString("message"));

        // GET again to see the change
        response = Unirest.get(baseUrl + "/feedback").asJson();
        feedbackList = response.getBody().getArray();
        System.out.println("All feedback after update: " + feedbackList.length() + " items");
        for (Object item : feedbackList) {
            JSONObject currObj = (JSONObject) item;
            System.out.println(currObj.getInt("id") + " - " + currObj.getString("name")
                    + " - " + currObj.getString("message"));
        }

        // DELETE feedback 2
        response = Unirest.delete(baseUrl + "/feedback/2").asJson();
        jsonObject = response.getBody().getObject();
        System.out.println("Deleted: " + jsonObject.getString("message"));

        //GET one last time, only one item should be left
        response = Unirest.get(baseUrl + "/feedback").asJson();
        feedbackList = response.getBody().getArray();
        System.out.println("All feedback at the end: " + feedbackList.length() + " item");
        for (Object item : feedbackList) {
            JSONObject currObj = (JSONObject) item;
            System.out.println(currObj.getInt("id") + " - " + currObj.getString("name")
                    + " - " + currObj.getString("message"));
        }
    }
}
