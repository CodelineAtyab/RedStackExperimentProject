
public class Main {

    public static void main(String[] args) {

        // Create FeedbackPortal object
        FeedbackPortal portal = new FeedbackPortal();

        // Create WebFormFeedback object
        WebFormFeedback feedback = new WebFormFeedback(1, "Aisha", "Great service", 5);

        // Create EmailFeedback object
        EmailFeedback e = new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com");

        // Create PhoneFeedback object
        PhoneFeedback p = new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7);

        // Add all feedback objects to the same portal
        portal.addFeedback(feedback);
        portal.addFeedback(e);
        portal.addFeedback(p);

        // Polymorphism happens because the Feedback list accepts different child objects
        // and calls each child's overridden getSummary() through toString().

        // Print feedback report
        portal.printReport();

        // Print average rating with one decimal place
        System.out.println("Average rating: " + String.format("%.1f", portal.getAverageRating()));
    }
}
