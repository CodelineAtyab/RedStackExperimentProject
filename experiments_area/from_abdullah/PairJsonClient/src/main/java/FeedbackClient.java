import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class FeedbackClient {
    public static void main(String[] args) {
        String serverAddress = "http://localhost:8080";
        if (args.length > 0) {
            serverAddress = args[0];
        }

        try {
            Unirest.config().connectTimeout(10000).socketTimeout(10000);

            HttpResponse<JsonNode> first = Unirest.post(serverAddress + "/feedback")
                    .header("Content-Type", "application/json")
                    .body("{\"name\":\"Sara\",\"message\":\"Great service\"}")
                    .asJson();
            show("Created first", first);
            int firstId = first.getBody().getObject().getInt("id");

            HttpResponse<JsonNode> second = Unirest.post(serverAddress + "/feedback")
                    .header("Content-Type", "application/json")
                    .body("{\"name\":\"Omar\",\"message\":\"Helpful staff\"}")
                    .asJson();
            show("Created second", second);

            show("All feedback", Unirest.get(serverAddress + "/feedback").asJson());

            show("Updated", Unirest.put(serverAddress + "/feedback/" + firstId)
                    .header("Content-Type", "application/json")
                    .body("{\"message\":\"Great service, thank you\"}").asJson());

            show("After update", Unirest.get(serverAddress + "/feedback").asJson());
            show("Deleted", Unirest.delete(serverAddress + "/feedback/" + firstId).asJson());
            show("After delete", Unirest.get(serverAddress + "/feedback").asJson());

        } catch (RuntimeException e) {
            System.out.println("Client stopped: " + e.getMessage());
        } finally {
            Unirest.shutDown();
        }
    }

    private static void show(String action, HttpResponse<JsonNode> response) {
        System.out.println(action + " (HTTP " + response.getStatus() + "): "
                + response.getBody());
        if (response.getStatus() < 200 || response.getStatus() >= 300) {
            throw new IllegalStateException("Server returned HTTP " + response.getStatus());
        }
    }
}
