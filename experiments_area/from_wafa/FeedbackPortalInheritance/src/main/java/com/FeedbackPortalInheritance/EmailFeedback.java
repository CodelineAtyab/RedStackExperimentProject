package com.FeedbackPortalInheritance;

public class EmailFeedback extends Feedback {

    public EmailFeedback(int id, String customerName, String message, int rating, String emailAddress) {
        super(id, customerName, message, rating);
        this.emailAddress= emailAddress;

    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getSummary() {
        return "[Email] " + getCustomerName() + " <" + emailAddress + ">: " + getMessage() + " (" + getRating() + "/5)";
    }

    private String emailAddress;
}
