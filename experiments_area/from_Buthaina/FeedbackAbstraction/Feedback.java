package com.FeedbackAbstraction;

public abstract class Feedback {
    //private fields
    private int id;
    private String CustomerName;
    private int rating;
    private String message;

    public abstract String getSummary();

    //constructor
    public Feedback(int id, String customerName,String message, int rating) {
        this.id = id;
        this.CustomerName = customerName;
        //setters
        setMessage(message);
        setRating(rating);
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getMessage() {
        return message;
    }

    public int getRating() {
        return rating;
    }

    // Setter for rating
    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Invalid rating: " + rating);
        }
    }

    // Setter for message
    public void setMessage(String message) {
        if (!message.isEmpty()) {
            this.message = message;
        } else {
            System.out.println("Message cannot be empty");
        }
    }

    // Implement abstract method

}


