import java.util.HashMap;

public class FeedbackPortal {

    public static void main(String[] args) {

        HashMap<String, HashMap<String, String>> portal = new HashMap<>();

        HashMap<String, String> customer_1 = new HashMap<>();

        customer_1.put("name", "Wafa");
        customer_1.put("rating", "3");
        customer_1.put("comment", "Great service");

        HashMap<String, String> customer_2 = new HashMap<>();

        customer_2.put("name", "Haitham");
        customer_2.put("rating", "4");
        customer_2.put("comment", "Slow delivey");

        portal.put("cust_1", customer_1);
        portal.put("cust_2", customer_2);

        System.out.println(portal.get("cust_2").get("name"));
        System.out.println(portal.get("cust_1").get("rating"));
        System.out.println(portal.get("cust_1").get("comment"));
        System.out.println(portal.get("cust_1").get("marks"));

    }

}
