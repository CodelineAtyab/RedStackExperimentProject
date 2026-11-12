package com.FeedbackPortalPolymorphism;

public class PhoneFeedback extends Feedback{
    private String phoneNumber;
    private int callMinutes;

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

    @Override
    public String getSummary() {
        return "[Phone] " + getCustomerName() + " " + phoneNumber + ", " + callMinutes + " min: " + getMessage() + " (" + getRating() + "/5)";
    }
}
