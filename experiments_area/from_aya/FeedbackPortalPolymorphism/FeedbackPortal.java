package com.FeedbackPortalPolymorphism;


import java.util.ArrayList;

public class FeedbackPortal {
    private ArrayList<Feedback> feedback;

    public FeedbackPortal() {
        feedback = new ArrayList<>();
    }

    public void addFeedback(Feedback feedback) {
        this.feedback.add(feedback);
    }

    public void printReport() {

        if (feedback.isEmpty()) {
            System.out.println("No feedback yet");

        } else {
            for (Feedback f : feedback) {
                System.out.println(f);
            }
        }
    }

    public double getAverageRating() {

        if (feedback.isEmpty()) {
            return 0;
        }

        int total = 0;

        for (Feedback f : feedback) {
            total += f.getRating();
        }

        return (double) total / feedback.size();
    }
}
