package com.FeedbackAbstraction;
public class Main {
    public static void main(String[] args) {

        WebFormFeedback f = new WebFormFeedback(1, "Aisha", "Great service", 5);
        System.out.println(f.getSummary());
    }
}

