package com.FeedbackPortalInheritance;

public class PhoneFeedback extends Feedback {

    public PhoneFeedback(int id, String customerName, String message, int rating, String phoneNumber, int callMinutes) {
        super(id, customerName, message, rating);
        this.phoneNumber = phoneNumber;
        this.callMinutes = callMinutes;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getCallMinutes() {
        return callMinutes;
    }


    public String getSummary() {
        return "[Phone] " + getCustomerName() + " " + phoneNumber + ", " + callMinutes + " min: " + getMessage() + " (" + getRating() + "/5)";
    }


    private String phoneNumber;
    private int callMinutes;
}
