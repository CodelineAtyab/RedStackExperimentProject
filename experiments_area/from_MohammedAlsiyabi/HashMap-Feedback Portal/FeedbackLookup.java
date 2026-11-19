import java.util.HashMap;


public class FeedbackLookup {
    public static void main(String[] args){
        HashMap<String, HashMap<String,String>> portal = new HashMap<>();

        HashMap<String, String> cust1_details = new HashMap<>();
        HashMap<String, String> cust2_details = new HashMap<>();

        cust1_details.put("name","wafa");
        cust1_details.put("rating","3");
        cust1_details.put("comment","Great Service");

        cust2_details.put("name","Haitham");
        cust2_details.put("rating","4");
        cust2_details.put("coment","Slow delivery");

        portal.put("cust_1",cust1_details);
        portal.put("cust_2",cust2_details);

        System.out.println(portal.get("cust_2").get("name"));
        System.out.println(portal.get("cust_1").get("rating"));
        System.out.println(portal.get("cust_1").get("comment"));
        System.out.println(portal.get("cust_1").get("email"));
    }
}