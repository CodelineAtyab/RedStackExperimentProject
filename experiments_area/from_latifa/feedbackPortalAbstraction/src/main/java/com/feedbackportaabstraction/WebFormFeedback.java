package com.feedbackportaabstraction;


public class WebFormFeedback extends Feedback {
    public WebFormFeedback(int id, String customerName, String message, int rating) {
        super(id, customerName, message, rating);
    }

    public String getSummary() {
        String var10000 = this.getCustomerName();
        return "[Web] " + var10000 + ": " + this.getMessage() + " (" + this.getRating() + "/5)";
    }
}
