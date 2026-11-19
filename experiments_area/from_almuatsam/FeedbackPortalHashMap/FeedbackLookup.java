import java.util.HashMap;

public class FeedbackLookup {
    public static void main(String[] args) {
        HashMap<String, String> feedbackByCustomer = new HashMap<>();

        feedbackByCustomer.put("C001", "Great service, very fast delivery.");
        feedbackByCustomer.put("C002", "The app crashed twice during checkout.");

        String feedback = feedbackByCustomer.get("C001");
        System.out.println(feedback);
    }
}
