package com.example.employee_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.employee_api.Exceptions.FeedbackNotFoundException;
import com.example.employee_api.Exceptions.InvalidFeedbackCustomerException;
import com.example.employee_api.Model.Feedback;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    private final List<Feedback> feedbacks = new ArrayList<>();
    private final CustomerService customerService;

    public FeedbackService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Feedback> getAll() {
        return feedbacks;
    }

    public Feedback findById(String id) {
        return feedbacks.stream()
                .filter(feedback -> Objects.equals(feedback.id, id))
                .findFirst()
                .orElseThrow(() -> new FeedbackNotFoundException(
                        "Feedback with ID " + id + " not found."));
    }

    public List<Feedback> findByCustomerId(String customerId) {
        return feedbacks.stream()
                .filter(feedback -> Objects.equals(feedback.customerId, customerId))
                .toList();
    }

    public Feedback create(Feedback feedback) {
        requireExistingCustomer(feedback.customerId);
        feedbacks.add(feedback);
        return feedback;
    }

    public Feedback update(String id, Feedback updatedFeedback) {
        Feedback existingFeedback = findById(id);
        requireExistingCustomer(updatedFeedback.customerId);
        updatedFeedback.id = id;
        feedbacks.set(feedbacks.indexOf(existingFeedback), updatedFeedback);
        return updatedFeedback;
    }

    public void delete(String id) {
        feedbacks.remove(findById(id));
    }

    public void deleteByCustomerId(String customerId) {
        feedbacks.removeIf(feedback -> Objects.equals(feedback.customerId, customerId));
    }

    private void requireExistingCustomer(String customerId) {
        if (!customerService.exists(customerId)) {
            throw new InvalidFeedbackCustomerException(
                    "Customer with ID " + customerId + " does not exist.");
        }
    }
}
