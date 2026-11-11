public class main {
    public static void main(String[] args) {
        /*Feedback f = new Feedback(1, "Aisha", "Great service", 5);
        f.setRating(9);
        f.setMessage("");
        System.out.println(f.getCustomerName() + " | " + f.getMessage() + " | " + f.getRating());
        WebFormFeedback f = new WebFormFeedback(1, "Aisha", "Great service", 5);
        System.out.println(f.getSummary());
        EmailFeedback e = new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com");
        PhoneFeedback p = new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7);
        System.out.println(e.getSummary());
        System.out.println(p.getSummary());
        p.setRating(9);*/

        FeedbackPortal portal = new FeedbackPortal();
        portal.addFeedback(new WebFormFeedback(1, "Aisha", "Great service", 5));
        portal.addFeedback(new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com"));
        portal.addFeedback(new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7));

        portal.printReport();
        System.out.printf("Average rating: %.1f%n", portal.getAverageRating());
    }
}