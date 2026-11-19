package org.example;

public class Feedback {
    private String id;
    private String message;
    private String customerId;   // the id of the customer who wrote it

    public Feedback() {
    }

    public Feedback(String id, String message, String customerId) {
        this.id = id;
        this.message = message;
        this.customerId = customerId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
}
