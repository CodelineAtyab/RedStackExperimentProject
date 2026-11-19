import java.util.HashMap;

public class FeedbackPortal {
    public static void main(String[] args){

        HashMap<String, HashMap<String, String>> portal = new HashMap<>();

        HashMap<String,String> firstCustomer = new HashMap<>();
        firstCustomer.put("name","Wafa");
        firstCustomer.put("rating","3");
        firstCustomer.put("comment","Great service");

        portal.put("cust_1",firstCustomer);


        HashMap<String,String> SecondCustomer = new HashMap<>();
        SecondCustomer.put("name","Haitham");
        SecondCustomer.put("rating","4");
        SecondCustomer.put("comment","Slow delivery");

        portal.put("cust_2",SecondCustomer);

        System.out.println(portal.get("cust_2").get("name"));
        System.out.println(portal.get("cust_1").get("rating"));
        System.out.println(portal.get("cust_1").get("comment"));
        System.out.println(portal.get("cust_1").get("email"));


    }
}
