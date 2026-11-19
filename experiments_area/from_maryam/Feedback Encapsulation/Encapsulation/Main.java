
public class Main {

    public static void main(String[] args) {

        // Create a Feedback object
        Feedback f1 = new Feedback(1, "Aisha", "Great service", 5);

        //  here to try to update the rating with an invalid value
        f1.setRating(9);

        // here to try to update the message with an empty value
        f1.setMessage("");

        // Print customer name, message, and rating
        System.out.println(f1.getCustomerName() + " | " + f1.getMessage() + " | " + f1.getRating());
    }
}
