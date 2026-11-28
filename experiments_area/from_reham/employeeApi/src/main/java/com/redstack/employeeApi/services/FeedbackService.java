
package com.redstack.employeeApi.services;

import com.redstack.employeeApi.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private CustomerService customerService;

    private final List<Feedback> feedbacks = new ArrayList<>();

    // Get all feedback
    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    // Get feedback by id
    public Feedback getFeedbackById(int id) {
        for (Feedback feedback : feedbacks) {
            if (feedback.getId() == id) {
                return feedback;
            }
        }
        return null;
    }

    // Add feedback
    public boolean addFeedback(Feedback feedback) {
        if (!customerService.customerExists(feedback.getCustomerId())) {
            return false;
        }

        feedbacks.add(feedback);
        return true;
    }

    // Update feedback
    public boolean updateFeedback(int id, Feedback updatedFeedback) {
        Feedback feedback = getFeedbackById(id);

        if (feedback == null) {
            return false;
        }

        if (!customerService.customerExists(updatedFeedback.getCustomerId())) {
            return false;
        }

        feedback.setMessage(updatedFeedback.getMessage());
        feedback.setCustomerId(updatedFeedback.getCustomerId());

        return true;
    }

    // Delete feedback by id
    public boolean deleteFeedback(int id) {
        Feedback feedback = getFeedbackById(id);

        if (feedback == null) {
            return false;
        }

        feedbacks.remove(feedback);
        return true;
    }

    // Delete all feedback belonging to one customer
    public void deleteFeedbackByCustomerId(String customerId) {
        feedbacks.removeIf(
                feedback -> customerId.equals(feedback.getCustomerId()));
    }

    // Get feedback belonging to one customer
    public List<Feedback> getFeedbackByCustomerId(String customerId) {
        return feedbacks.stream()
                .filter(feedback -> customerId.equals(feedback.getCustomerId()))
                .toList();
    }
}
