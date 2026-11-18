import java.util.HashMap;

public class FeedbackPortal {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, String>> portal= new HashMap<>();

        HashMap<String,String> cust_1= new HashMap<>();
        cust_1.put("name","Wafa");
        cust_1.put("rating","3");
        cust_1.put("comment","Great service");

        HashMap<String,String> cust_2= new HashMap<>();
        cust_2.put("name","Haitham");
        cust_2.put("rating","4");
        cust_2.put("comment","Slow delivery");

        portal.put("cust_1",cust_1);
        portal.put("cust_2",cust_2);

        System.out.println(portal.get("cust_2").get("name"));
        System.out.println(portal.get("cust_1").get("rating"));
        System.out.println(portal.get("cust_1").get("comment"));
        System.out.println(portal.get("cust_1").get("email"));


    }
}
