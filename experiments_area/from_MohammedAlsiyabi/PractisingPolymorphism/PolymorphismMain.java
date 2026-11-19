public class PolymorphismMain {
    public static void main(String[] args) {

        FeedbackPortal portal = new FeedbackPortal();

        portal.addFeedback(new WebFormFeedback(1, "Mohammed", "Great service", 5));
        portal.addFeedback(new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com"));
        portal.addFeedback(new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7));

        portal.printReport();
        System.out.println("Average rating: " + String.format("%.1f", portal.getAverageRating()));


    }
}