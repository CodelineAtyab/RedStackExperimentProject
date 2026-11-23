package com.redstack.feedbackcrudcustomerlink.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.redstack.feedbackcrudcustomerlink.model.Feedback;
import com.redstack.feedbackcrudcustomerlink.store.InMemoryDataStore;

@Service
public class FeedbackService {

    private final List<Feedback> feedbackList = InMemoryDataStore.feedbackList;
    private final CustomerService customerService;

    public FeedbackService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Feedback> getAllFeedback() {
        return feedbackList;
    }

    public Optional<Feedback> getFeedbackById(String id) {
        return feedbackList.stream()
                .filter(currFeedback -> id.equals(currFeedback.id))
                .findFirst();
    }

    public List<Feedback> getFeedbackByCustomerId(String customerId) {
        if (!customerExists(customerId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found: id=" + customerId);
        }
        return feedbackList.stream()
                .filter(currFeedback -> customerId.equals(currFeedback.customerId))
                .toList();
    }

    public Feedback createFeedback(Feedback feedback) {
        requireExistingCustomer(feedback.customerId);
        feedbackList.add(feedback);
        return feedback;
    }

    public Optional<Feedback> updateFeedback(String id, Feedback request) {
        Optional<Feedback> existing = getFeedbackById(id);
        if (existing.isEmpty()) {
            return Optional.empty();
        }
        requireExistingCustomer(request.customerId);
        Feedback feedback = existing.get();
        feedback.message = request.message;
        feedback.customerId = request.customerId;
        return Optional.of(feedback);
    }

    public boolean deleteFeedback(String id) {
        return feedbackList.removeIf(currFeedback -> id.equals(currFeedback.id));
    }

    public void deleteAllFeedback() {
        feedbackList.clear();
    }

    private boolean customerExists(String customerId) {
        return customerService.getCustomerById(customerId).isPresent();
    }

    private void requireExistingCustomer(String customerId) {
        if (!customerExists(customerId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Customer does not exist: customerId=" + customerId);
        }
    }
}
