public class Main {
    public static void main(String[] args) {

     FeedbackPortal portal = new FeedbackPortal();
     portal.addFeedback(new FormFeedback(1, "Aisha", "Great service", 5));
     portal.addFeedback(new EmailFeedback(2, "Omar", "slow reply", 3, "omar@gmail.com"));
     portal.addFeedback(new PhoneFeedback(3, "Aisha", "Great service", 4, "99112233",7));

     // Polymorphism: the portal's list holds the parent type Feedback, but each object
// is really a Web, Email or Phone feedback. When printReport() prints each one,
// Java runs that object's own getSummary() at run time, so the output has a
// different format per type without any type checks.

     portal.printReport();
     System.out.println("Average rating: " + String.format("%.1f", portal.getAverageRating()));
    }
}