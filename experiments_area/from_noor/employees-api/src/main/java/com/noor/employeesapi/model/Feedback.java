package com.noor.employeesapi.model;

public class Feedback {

    private String id;
    private String customerId;
    private String message;
    private int rating;

    public Feedback() {
    }

    public Feedback(String id, String customerId, String message, int rating) {
        this.id = id;
        this.customerId = customerId;
        this.message = message;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}