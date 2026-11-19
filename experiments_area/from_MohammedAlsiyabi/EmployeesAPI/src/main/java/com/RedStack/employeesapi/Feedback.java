package com.teamred.employees;

public class Feedback {

    private String id;
    private String name;
    private String message;
    private String customerId; // the id of the customer who wrote this feedback

    public Feedback() {
    }

    public Feedback(String id, String name, String message, String customerId) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.customerId = customerId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
}
