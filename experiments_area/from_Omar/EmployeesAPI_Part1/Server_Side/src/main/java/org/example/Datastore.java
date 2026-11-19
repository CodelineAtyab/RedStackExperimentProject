package org.example;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Datastore {

    private final List<Customer> customers = new ArrayList<>();
    private final List<Feedback> feedbackList = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }
}