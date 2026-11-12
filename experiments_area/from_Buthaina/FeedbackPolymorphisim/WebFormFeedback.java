
package com.FeedbackPolymorphisim;

public class WebFormFeedback extends Feedback {

    // Constructor
    public WebFormFeedback(int id, String customerName,String message, int rating) {

        super(id, customerName, message, rating);
    }

    // Implement abstract method
    @Override
    public String getSummary() {
        return "[Web] " + getCustomerName() + ": " + getMessage() + " (" + getRating() + "/5)";
    }
}

