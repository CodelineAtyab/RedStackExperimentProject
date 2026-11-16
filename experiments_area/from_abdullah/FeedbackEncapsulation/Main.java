public class Main {

    public static void main(String[] args) {

        Feedback review1 = new Feedback(
            1, "Aisha", "Great service", 5
        );

        Feedback review2 = new Feedback(
            2, "Sara", "Good experience", 4
        );

        // Attempting invalid updates
        review1.setRating(9);
        review1.setMessage("");

        // Applying valid updates
        review2.setRating(3);
        review2.setMessage("The service was helpful");

        // Output Feedback 1
        System.out.println("\nFeedback 1");
        System.out.println("ID: " + review1.getId());
        System.out.println("Name: " + review1.getCustomerName());
        System.out.println("Message: " + review1.getMessage());
        System.out.println("Rating: " + review1.getRating());

        // Output Feedback 2
        System.out.println("\nFeedback 2");
        System.out.println("ID: " + review2.getId());
        System.out.println("Name: " + review2.getCustomerName());
        System.out.println("Message: " + review2.getMessage());
        System.out.println("Rating: " + review2.getRating());
    }
}