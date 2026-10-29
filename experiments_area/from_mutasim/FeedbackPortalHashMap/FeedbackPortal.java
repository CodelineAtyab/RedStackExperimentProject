import java.util.HashMap;

public class FeedbackPortal {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, String>> portal = new HashMap<>();

        HashMap<String, String> cust1Details = new HashMap<>();
        cust1Details.put("name", "Wafa");
        cust1Details.put("rating", "3");
        cust1Details.put("comment", "Great service");

        HashMap<String, String> cust2Details = new HashMap<>();
        cust2Details.put("name", "Haitham");
        cust2Details.put("rating", "4");
        cust2Details.put("comment", "Slow delivery");

        portal.put("cust_1", cust1Details);
        portal.put("cust_2", cust2Details);

        System.out.println(portal.get("cust_2").get("name"));
        System.out.println(portal.get("cust_1").get("rating"));
        System.out.println(portal.get("cust_1").get("comment"));
        System.out.println(portal.get("cust_1").get("email"));
    }
}