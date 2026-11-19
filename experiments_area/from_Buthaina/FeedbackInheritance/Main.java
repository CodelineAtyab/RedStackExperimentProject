package com.FeedbackInheritance;

public class Main {
    public static void main(String[]args){
        EmailFeedback e = new EmailFeedback(2, "Omar", "Slow reply", 3, "omar@mail.com");
        PhoneFeedback p = new PhoneFeedback(3, "Salma", "Helpful agent", 4, "99112233", 7);
        System.out.println(e.getSummary());
        System.out.println(p.getSummary());
        p.setRating(9);
    }
}