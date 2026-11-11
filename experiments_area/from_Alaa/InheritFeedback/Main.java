public class Main {

    public static void main(String[] args) {

        // Create WebFormFeedback object
        WebFormFeedback feedback = new WebFormFeedback(1, "Aisha", "Great service", 5);

        // Create EmailFeedback object
        EmailFeedback e = new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com");

        // Create PhoneFeedback object
        PhoneFeedback p = new PhoneFeedback( 3, "Salma", "Helpful agent", 4, "99112233", 7);

        // Print summaries
        System.out.println(feedback.getSummary());
        System.out.println(e.getSummary());
        System.out.println(p.getSummary());

        // Test inherited setRating method
        p.setRating(9);
    }
}