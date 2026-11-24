package com.teamred.employees;

public class Feedback {
    private String id;
    private String message;
    private String customerId;

    public Feedback() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
}