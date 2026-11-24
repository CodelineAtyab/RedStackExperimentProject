package com.redstack.feedbacklinkedtocustomer.service;

import com.redstack.feedbacklinkedtocustomer.model.Customer;
import com.redstack.feedbacklinkedtocustomer.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FeedbackService {
    private ArrayList<Feedback> feedbackList = new ArrayList<>();

    @Autowired
    private CustomerService customerService;

    // Get all feedback
    public ArrayList<Feedback> getAllFeedback() {
        return feedbackList;
    }

    // Get feedback by ID
    public Feedback getFeedbackById(String id) {

        return feedbackList.stream()
                .filter(currFeedback -> currFeedback.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Add feedback
    public Feedback addFeedback(Feedback feedbackToAdd) {

        Customer customer = customerService.getCustomerById(
                feedbackToAdd.getCustomerId()
        );

        if (customer == null) {
            throw new IllegalArgumentException(
                    "Customer " + feedbackToAdd.getCustomerId() + " not found"
            );
        }

        feedbackList.add(feedbackToAdd);

        return feedbackToAdd;
    }
}
