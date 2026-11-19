import java.util.HashMap;

public class FeedbackPortal {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, String>> portal = new HashMap<>();
        
        HashMap<String, String> customer1 = new HashMap<>();
        customer1.put("name", "Wafa");
        customer1.put("rating", "3");
        customer1.put("comment", "Great service");

        HashMap<String, String> customer2 = new HashMap<>();
        customer2.put("name", "Haitham");
        customer2.put("rating", "4");
        customer2.put("comment", "Slow delivery");

        portal.put("cust_1", customer1);
        portal.put("cust_2", customer2);

        System.out.println(portal.get("cust_2").get("name"));
        System.out.println(portal.get("cust_1").get("rating"));
        System.out.println(portal.get("cust_1").get("comment"));
        System.out.println(portal.get("cust_1").get("email"));
                
    }
    
}
