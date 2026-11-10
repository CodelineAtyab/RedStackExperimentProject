public class main {

    public static void main(String[] args){

        FeedbackPortal portal = new FeedbackPortal();

        portal.addFeedback(new WebFormFeedback(1, "Aisha", "Great service", 5));
        portal.addFeedback(new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com"));
        portal.addFeedback(new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7));

        portal.printReport();

        double avg = portal.getAverageRating();
        System.out.println("Average rating: " + String.format("%.1f", avg));
    }
}