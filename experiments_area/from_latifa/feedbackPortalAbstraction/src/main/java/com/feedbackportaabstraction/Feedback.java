package com.feedbackportaabstraction;

public abstract class Feedback {
    private int id;
    private String customerName;
    private String message;
    private int rating;

    public Feedback(int id, String customerName, String message, int rating) {
        this.id = id;
        this.customerName = customerName;
        this.rating = 1;
        this.setMessage(message);
        this.setRating(rating);
    }

    public int getId() {
        return this.id;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getMessage() {
        return this.message;
    }

    public int getRating() {
        return this.rating;
    }

    public void setMessage(String message) {
        if (message.isEmpty()) {
            System.out.println("Message cannot be empty.");
        } else {
            this.message = message;
        }

    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Invalid rating: " + rating);
        }

    }

    public abstract String getSummary();
}
