
package com.FeedbackEncapsulation;

public class Main {
    public static void main(String[] args) {

        // Create Feedback object
        Feedback f = new Feedback(1, "Aisha", "Great service", 5);

        // Test invalid changes
        f.setRating(9);
        f.setMessage("");

        // Display feedback
        System.out.println(
                f.getCustomerName() + " | " +
                        f.getMessage() + " | " +
                        f.getRating()
        );
    }
}
