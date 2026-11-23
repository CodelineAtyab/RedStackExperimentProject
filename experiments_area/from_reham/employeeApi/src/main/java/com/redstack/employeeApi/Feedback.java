package com.redstack.employeeApi;

public class Feedback {
    private int id;
    private String message;
    private String customerId;

    public Feedback(){}

    public Feedback(int id, String message, String customerId) {
        this.id = id;
        this.message = message;
        this.customerId = customerId;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public String getCustomerId() {return customerId;}
    public void setCustomerId(String customerId) {this.customerId = customerId;}


}
