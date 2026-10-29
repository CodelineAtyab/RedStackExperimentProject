import java.util.HashMap;

public class FeedbackLookup {
    public static void main(String[] args) {
        HashMap<String, String> feedbackByCustomer = new HashMap<>();

        feedbackByCustomer.put("cust_1", "Great service");
        feedbackByCustomer.put("cust_2", "Slow delivery");
        feedbackByCustomer.put("cust_3", "Needs dark mode");

        System.out.println(feedbackByCustomer.get("cust_2"));
        System.out.println(feedbackByCustomer.get("cust_3"));
        System.out.println(feedbackByCustomer.get("cust_9"));
    }
}
