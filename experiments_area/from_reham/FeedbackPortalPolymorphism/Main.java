public class Main {
    public static void main(String[] args) {
        FeedbackPortal portal = new FeedbackPortal();
        WebFormFeedback feedback = new WebFormFeedback(1,"Aisha","Greate service",5);
        EmailFeedback e = new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com");
        PhoneFeedback p = new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7);
        
        portal.addFeedback(feedback);
        portal.addFeedback(e);
        portal.addFeedback(p);
        portal.printReport();
        System.out.println("Average rating: " + String.format("%.1f", portal.getAverageRating()));      }
}
