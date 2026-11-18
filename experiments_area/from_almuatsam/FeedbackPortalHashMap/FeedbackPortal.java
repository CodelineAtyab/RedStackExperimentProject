import java.util.HashMap;

public class FeedbackPortal {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, String>> feedbackByCustomer = new HashMap<>();

        HashMap<String, String> firstCustomer = new HashMap<>();
        firstCustomer.put("name", "Aisha");
        firstCustomer.put("feedback", "Great service, very fast delivery.");
        feedbackByCustomer.put("C001", firstCustomer);

        HashMap<String, String> secondCustomer = new HashMap<>();
        secondCustomer.put("name", "Omar");
        secondCustomer.put("feedback", "The app crashed twice during checkout.");
        feedbackByCustomer.put("C002", secondCustomer);

        HashMap<String, String> customerDetails = feedbackByCustomer.get("C001");
        String feedback = customerDetails.get("feedback");
        System.out.println(feedback);
    }
}
