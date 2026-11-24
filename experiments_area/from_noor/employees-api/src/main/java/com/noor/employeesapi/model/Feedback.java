package com.noor.employeesapi.model;

public class Feedback {

    private int id;
    private int customerId;
    private String message;
    private int rating;

    public Feedback() {
    }

    public Feedback(int id, int customerId, String message, int rating) {
        this.id = id;
        this.customerId = customerId;
        this.message = message;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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