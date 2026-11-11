import java.util.HashMap;

public class FeedbackLookup {     
    public static void main(String[] args) {

        HashMap<String, String> feedbackByCustomer = new HashMap<>();

        feedbackByCustomer.put("cust_1",   "Great service");
        feedbackByCustomer.put("cust_2",     "Slow delivery");
        feedbackByCustomer.put("cust_3",     "Need dark mode");
       
        String customer_2 = feedbackByCustomer.get("cust_2");
        String customer_3 = feedbackByCustomer.get("cust_3");
        String customer_9 = feedbackByCustomer.get("cust_9");

        System.out.println(customer_2);
        System.out.println(customer_3);
        System.out.println(customer_9);

    }
}