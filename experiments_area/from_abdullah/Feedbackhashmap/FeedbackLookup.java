import java.util.HashMap;

public class FeedbackLookup {
    public static void main(String[] args) {
        HashMap<String, String> feedbackByCustomer = new HashMap<>();

        feedbackByCustomer.put("cust_1", "Great service");
        feedbackByCustomer.put("cust_2", "Slow delivery");
        feedbackByCustomer.put("cust_3", "Needs dark mode");

        String secondFeedback = feedbackByCustomer.get("cust_2");
        String thirdFeedback = feedbackByCustomer.get("cust_3");
        String missingFeedback = feedbackByCustomer.get("cust_9");

        System.out.println(secondFeedback);
        System.out.println(thirdFeedback);
        System.out.println(missingFeedback);
    }
}