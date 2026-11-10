package com.FeedbackPortal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Feedback f = new Feedback(1, "Wafa", "Great service", 5);
        f.setRating(9);
        f.setMessage("");
        System.out.println(f.getCustomerName() + " | " + f.getMessage() + " | " + f.getRating());

    }
}