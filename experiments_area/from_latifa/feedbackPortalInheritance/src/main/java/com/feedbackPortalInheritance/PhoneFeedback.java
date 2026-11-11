package com.feedbackPortalInheritance;

public class PhoneFeedback extends Feedback {
    private String phoneNumber;
    private int callMinutes;

    public PhoneFeedback(int id, String customerName, String message, int rating, String phoneNumber, int callMinutes) {
        super(id, customerName, message, rating);
        this.phoneNumber = phoneNumber;
        this.callMinutes = callMinutes;
    }

    public String PhoneNumber() {
        return this.phoneNumber;
    }

    public int getCallMinutes() {
        return this.callMinutes;
    }

    public String getSummary() {
        String var10000 = this.getCustomerName();
        return "[Phone] " + var10000 + " " + this.phoneNumber + ", " + this.callMinutes + " min: " + this.getMessage() + " (" + this.getRating() + "/5)";
    }
}

