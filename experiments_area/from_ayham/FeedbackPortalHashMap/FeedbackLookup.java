import java.util.HashMap;
import java.util.Map;

public class FeedbackLookup {

    public static void main(String[] args) {
        HashMap<String, String> feedbackByCustomer = new HashMap<>();
        feedbackByCustomer.put("cust1", "Great service!");
        feedbackByCustomer.put("cust2", "Slow delivery.");
        feedbackByCustomer.put("cust3", "Needs dark mode.");
 
        System.out.println(feedbackByCustomer.get("cust2")); 
        System.out.println(feedbackByCustomer.get("cust3")); 
        System.out.println(feedbackByCustomer.get("cust9"));
    }
}