import java.util.HashMap;

public class FeedbackLookup {
    public static void main(String[] args) {
        
//      Initialize and declare 
        HashMap <String,String> feedbackByCustomer = new HashMap<>();

        feedbackByCustomer.put("cust_1","Great Survice");       
        feedbackByCustomer.put("cust_2","Slow delivery");
        feedbackByCustomer.put("cust_3","Needs dark mode");
        
        System.out.println(feedbackByCustomer.get("cust_1"));
        System.out.println(feedbackByCustomer.get("cust_1"));
        System.out.println(feedbackByCustomer.get("cust_9"));








        
    }
    
}
