package com.FeedbackPolymorphisim;
public class EmailFeedback extends Feedback {

    // Extra private field
    private String emailAddress;

    // Constructor
    public EmailFeedback(int id, String customerName,
                         String message, int rating,
                         String emailAddress) {

        super(id, customerName, message, rating);

        this.emailAddress = emailAddress;
    }

    // Getter
    public String getEmailAddress() {
        return emailAddress;
    }

    // Implement abstract method
    @Override
    public String getSummary() {
        return "[Email] " + getCustomerName()
                + " <" + getEmailAddress() + ">: "
                + getMessage() + " (" + getRating() + "/5)";
    }
}
