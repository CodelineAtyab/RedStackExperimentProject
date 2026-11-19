import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        FeedbackPortal portal = new FeedbackPortal();

        WebFormFeedback web = new WebFormFeedback(
                1, "Aisha", "Great service", 5);

        EmailFeedback email = new EmailFeedback(
                2, "Omar", "Slow reply", 3, "omar@mail.com");

        PhoneFeedback phone = new PhoneFeedback(
                3, "Salma", "Helpful agent", 4, "99112233", 7);

        portal.addFeedback(web);
        portal.addFeedback(email);
        portal.addFeedback(phone);

        // The same report loop uses each object's own getSummary() method.
        portal.printReport();

        System.out.printf(Locale.US, "Average rating: %.1f%n",
                portal.getAverageRating());
    }
}