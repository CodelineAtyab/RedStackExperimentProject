public class Main {

    public static void main(String[] args) {

        FeedbackPortal portal = new FeedbackPortal();

       // add the information for web , email . phone feedback
        portal.addFeedback(new WebFormFeedback(1, "Aisha", "Great service", 5));

        portal.addFeedback(new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com"));

        portal.addFeedback(new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7));

        portal.printReport();

        // to print the average rate
        System.out.printf("Average rating: %.1f%n", portal.getAverageRating());

    }
}
