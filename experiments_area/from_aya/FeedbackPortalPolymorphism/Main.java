package com.FeedbackPortalPolymorphism;

public class Main {

    public static void main(String[] args) {

        FeedbackPortal portal = new FeedbackPortal();
        Feedback f1 = new WebFormFeedback(1, "Aisha", "Great service", 5);
        Feedback f2 = new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com");
        Feedback f3 = new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7);

        portal.addFeedback(f1);
        portal.addFeedback(f2);
        portal.addFeedback(f3);

        portal.printReport();

        System.out.println("Average rating: " + String.format("%.1f", portal.getAverageRating()));
    }
}
