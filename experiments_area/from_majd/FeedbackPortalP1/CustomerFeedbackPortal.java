public class CustomerFeedbackPortal {

    

public static void main(String [] args)
{

Feedback f=new Feedback(1, "Aisha", "Great service", 5);

f.setRating(5);
f.setMessage("Message");
System.out.println(f.getCustomerName() + " | " + f.getMessage() + " | " + f.getRating());

}



}
