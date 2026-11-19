package com.example.employees_api.Models;

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

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getMessage() {
        return message;
    }

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