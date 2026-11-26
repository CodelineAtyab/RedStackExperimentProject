package com.CustomerCustomerFeedbackAPI.Customer.model;

public class Feedback {

    private String id;
    private String message;
    private String customerId;

    public Feedback() {
    }

    public Feedback(String id, String message, String customerId) {
        this.id = id;
        this.message = message;
        this.customerId = customerId;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getCustomerId() {
        return customerId;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
