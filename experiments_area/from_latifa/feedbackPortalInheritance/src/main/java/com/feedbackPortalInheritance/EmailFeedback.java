package com.feedbackPortalInheritance;

public class EmailFeedback extends Feedback {
    private String emailAddress;

    public EmailFeedback(int id, String customerName, String message, int rating, String emailAddress) {
        super(id, customerName, message, rating);
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getSummary() {
        String var10000 = this.getCustomerName();
        return "[Email] " + var10000 + " <" + this.getEmailAddress() + ">: " + this.getMessage() + " (" + this.getRating() + "/5)";
    }
}
