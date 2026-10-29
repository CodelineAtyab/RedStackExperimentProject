import java.util.HashMap;

public class FeedbackPortal {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, String>> portal = new HashMap<>();
        HashMap<String, String> customer1 = new HashMap<>();
        customer1.put("name", "Wafa");
        customer1.put("feedback", "Great service!");
        customer1.put("rating", "3");
        portal.put("cust1", customer1);

        HashMap<String, String> customer2 = new HashMap<>();
        customer2.put("name", "Haitham");
        customer2.put("feedback", "Slow delivery.");
        customer2.put("rating", "4");
        portal.put("cust2", customer2);

        System.out.println(portal.get("cust2").get("name"));
        System.out.println(portal.get("cust1").get("rating"));
        System.out.println(portal.get("cust1").get("feedback"));

        System.out.println(portal.get("cust1").get("email"));

    }
}
