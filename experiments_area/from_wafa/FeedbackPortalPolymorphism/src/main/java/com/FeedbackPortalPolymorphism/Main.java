package com.FeedbackPortalPolymorphism;

public class Main {
    public static void main(String[] args) {

        FeedbackPortal f = new FeedbackPortal();

        f.addFeedback(new WebFormFeedback(1, "Aisha", "Great service", 5));
        f.addFeedback(new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com"));
        f.addFeedback(new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7));
        f.printReport();

        double average = f.getAverageRating();
        System.out.printf("Average rating: "+"%.1f",average);

        /*
        overrode getSummary in the parent class so each child class could print its own summary.
        similar in the feedback parent class by overriding toString to get the exact output format
        */

    }
}