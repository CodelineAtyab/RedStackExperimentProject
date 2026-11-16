public class Main {

    public static void main(String[] args) {

        Feedback feedback1 = new Feedback(
            1, "Aisha", "Great service", 5
        );

        Feedback feedback2 = new Feedback(
            2, "Sara", "Good experience", 4
        );

        // Test invalid changes
        feedback1.setRating(9);
        feedback1.setMessage("");

        // Test valid changes
        feedback2.setRating(3);
        feedback2.setMessage("The service was helpful");

        // Display feedback 1
        System.out.println("\nFeedback 1");
        System.out.println("ID: " + feedback1.getId());
        System.out.println("Name: " + feedback1.getCustomerName());
        System.out.println("Message: " + feedback1.getMessage());
        System.out.println("Rating: " + feedback1.getRating());

        // Display feedback 2
        System.out.println("\nFeedback 2");
        System.out.println("ID: " + feedback2.getId());
        System.out.println("Name: " + feedback2.getCustomerName());
        System.out.println("Message: " + feedback2.getMessage());
        System.out.println("Rating: " + feedback2.getRating());
    }
}
