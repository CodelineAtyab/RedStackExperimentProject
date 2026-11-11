package com.FeedbackPortalPolymorphism;

import java.util.ArrayList;

public class FeedbackPortal {
    private ArrayList<Feedback> allFeedback;

    public FeedbackPortal(){
        allFeedback = new ArrayList<>();
    }
    public void addFeedback(Feedback feedback){
        allFeedback.add(feedback);
    }

    public void printReport(){
        if(allFeedback.isEmpty()){
            System.out.println("No feedback yet.");
        }else {
            for (int i = 0; i < allFeedback.size(); i++) {
                System.out.println(allFeedback.get(i));
            }
        }
    }
    public double getAverageRating(){
        double sum = 0;
        if(allFeedback.isEmpty()){
            return 0;
        }
        for (int i = 0; i < allFeedback.size(); i++) {
            sum = sum + allFeedback.get(i).getRating();
        }
        sum = sum / allFeedback.size();

        return sum;
    }
}