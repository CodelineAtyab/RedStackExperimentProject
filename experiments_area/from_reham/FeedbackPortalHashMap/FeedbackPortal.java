import java.util.HashMap;
public class FeedbackPortal {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, String>> portal = new HashMap<>();

        HashMap<String, String> Customer = new HashMap<>();
        Customer.put("name","Wafa");
        Customer.put("Rating","3");
        Customer.put("Comment","Great Service");

        HashMap<String, String> Customer2 = new HashMap<>();
        Customer2.put("name","Haitham");
        Customer2.put("Rating","4");
        Customer2.put("Comment","Slow Delivery");

        portal.put("cust_1",Customer);
        portal.put("cust_2",Customer2);
        
        System.out.println(portal.get("cust_2").get("name"));
        System.out.println(portal.get("cust_1").get("Comment"));
        System.out.println(portal.get("cust_1").get("email"));









    }
}
