package com.FeedbackEncapsulation;

public class Main {
    public static void main(String[] args){
        Feedback f = new Feedback(1, "Aisha", "Great service", 5);
        f.setRating(4);
        f.setMessage("nice ");
        System.out.println(f.getCustomerName() + " | " + f.getMessage() + " | " + f.getRating());
    }
}