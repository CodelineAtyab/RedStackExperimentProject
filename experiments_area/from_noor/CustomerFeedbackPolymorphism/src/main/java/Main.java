
public class Main {

    public static void main(String[] args) {

        FeedbackPortal portal = new FeedbackPortal();

        portal.addFeedback(new WebFormFeedback(
                1, "Noor", "Excellent service", 5));

        portal.addFeedback(new EmailFeedback(
                2, "Ali", "Quick response", 4,
                "ali@example.com"));

        portal.addFeedback(new PhoneFeedback(
                3, "Mariam", "Very helpful support", 5,
                "99112233", 7));

        // Polymorphism allows different feedback types
        // to be handled through the same parent type.
        portal.printReport();

        System.out.printf("Average rating: %.1f%n",
                portal.getAverageRating());
    }
}
