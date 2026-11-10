// this file is where objects are created and class testing

public class Main {

    public static void main (String [] args ){
        Feedback F1 = new Feedback (1, "Alaa", "very nice", 4); //creat an object of the Feedback class
        
        //try to set the rating and message to different values
        
        F1.setRating(9); //should return error message
        F1.setMessage("");

        F1.setRating(5);
        F1.setMessage("GOOD");

        //test
        System.out.println(F1.getId());
        System.out.println(F1.getCustomerName());
        System.out.println(F1.getMessage());
        System.out.println(F1.getRating());
    
    }
}