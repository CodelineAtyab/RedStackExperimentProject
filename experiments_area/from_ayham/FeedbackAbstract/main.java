public class main {
    public static void main(String[] args) {
        FeedbackPortal feedbackPortal = new FeedbackPortal();

        feedbackPortal.addFeedback(new WebFormFeedback(1, "Aisha", "Great service", 5));
        feedbackPortal.addFeedback(new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com"));
        feedbackPortal.addFeedback(new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7));

        feedbackPortal.printReport();
        System.out.println("Average Rating: " + feedbackPortal.getAverageRating());
    }
}
