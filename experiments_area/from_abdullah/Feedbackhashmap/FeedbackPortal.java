import java.util.HashMap;

public class FeedbackPortal {
    public static void main(String[] args) {
        HashMap<String, String> cust1 = new HashMap<>();
        cust1.put("name", "Wafa");
        cust1.put("rating", "3");
        cust1.put("comment", "Great service");

        HashMap<String, String> cust2 = new HashMap<>();
        cust2.put("name", "Haitham");
        cust2.put("rating", "4");
        cust2.put("comment", "Slow delivery");

        HashMap<String, HashMap<String, String>> portal = new HashMap<>();
        portal.put("cust_1", cust1);
        portal.put("cust_2", cust2);

        String customerName = portal.get("cust_2").get("name");
        String customerRating = portal.get("cust_1").get("rating");
        String customerComment = portal.get("cust_1").get("comment");
        String missingEmail = portal.get("cust_1").get("email");

        System.out.println(customerName);
        System.out.println(customerRating);
        System.out.println(customerComment);
        System.out.println(missingEmail);
    }
}