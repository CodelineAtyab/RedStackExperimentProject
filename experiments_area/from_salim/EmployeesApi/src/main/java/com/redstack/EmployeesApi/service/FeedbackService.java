package com.redstack.EmployeesApi.service;

import com.redstack.EmployeesApi.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {
    private final List<Feedback> feedbackItems = new ArrayList<>();

    @Autowired
    private CustomerService customerService;

    public List<Feedback> getAllFeedback() {
        return feedbackItems;
    }

    public Optional<Feedback> getFeedbackById(String id) {
        return feedbackItems.stream()
                .filter(item -> item.id.equals(id))
                .findFirst();
    }

    public Optional<Feedback> createFeedback(Feedback feedback) {
        if (customerService.getCustomerById(feedback.customerId).isEmpty()) {
            return Optional.empty();
        }

        feedbackItems.add(feedback);
        return Optional.of(feedback);
    }

    public Optional<Feedback> updateFeedback(String id, Feedback replacement) {
        Optional<Feedback> existing = getFeedbackById(id);

        if (existing.isEmpty() || customerService.getCustomerById(replacement.customerId).isEmpty()) {
            return Optional.empty();
        }

        replacement.id = id;
        feedbackItems.set(feedbackItems.indexOf(existing.get()), replacement);
        return Optional.of(replacement);
    }

    public Optional<Feedback> deleteFeedback(String id) {
        Optional<Feedback> existing = getFeedbackById(id);
        existing.ifPresent(feedbackItems::remove);
        return existing;
    }

    public List<Feedback> getFeedbackForCustomer(String customerId) {
        return feedbackItems.stream()
                .filter(item -> item.customerId.equals(customerId))
                .toList();
    }

    public void deleteFeedbackForCustomer(String customerId) {
        feedbackItems.removeIf(item -> item.customerId.equals(customerId));
    }
}