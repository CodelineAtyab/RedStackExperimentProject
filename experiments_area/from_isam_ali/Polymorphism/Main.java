public class Main {
    public static void main(String[] args) {

     FeedbackPortal portal = new FeedbackPortal();
     portal.addFeedback(new FormFeedback(1, "Aisha", "Great service", 5));
     portal.addFeedback(new EmailFeedback(2, "Omar", "slow reply", 5, "omar@gmail.com"));
     portal.addFeedback(new PhoneFeedback(3, "Aisha", "Great service", 4, "99112233",5));

     portal.printReport();
     System.out.println("Average rating: " + portal.getAverageRating());
    }
}