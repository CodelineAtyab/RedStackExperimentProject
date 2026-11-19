package com.redstack.EmployeesApi.model;

public class Feedback {
    public String id;
    public String message;
    public String customerId;

    public Feedback() {
    }

    public Feedback(String id, String message, String customerId) {
        this.id = id;
        this.message = message;
        this.customerId = customerId;
    }
}
