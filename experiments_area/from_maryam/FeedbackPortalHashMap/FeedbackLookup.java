import java.util.HashMap;

public class FeedbackLookup {


    public static void main (String[] args){


        HashMap<String, HashMap<String, String>> portal= new HashMap<>();

        HashMap<String, String > Customer1 = new HashMap<>();

        Customer1.put("name", "Wafa");
        Customer1.put("rating", "3");
        Customer1.put("comment", "Great service");

        portal.put("cust_1", Customer1);

        HashMap<String, String > Customer2 = new HashMap<>();
        Customer2.put("name", "Haitham");
        Customer2.put("rating", "4");
        Customer2.put("comment", "Slow delivery");

        portal.put("cust_2", Customer2);


        System.out.println(portal.get("cust_2").get("name"));
        System.out.println(portal.get("cust_1").get("rating"));
        System.out.println(portal.get("cust_1").get("comment"));
        System.out.println(portal.get("cust_1").get("email"));


    }

}
