package com.example.EmployeeApi.service;

import com.example.EmployeeApi.model.Feedback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final List<Feedback> feedbackList = new ArrayList<>();
    private final CustomerService customerService;

    public FeedbackService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Feedback> getAllFeedback() {
        return feedbackList;
    }

    public ResponseEntity<?> getFeedbackById(String id) {
        Optional<Feedback> found = feedbackList.stream()
                .filter(f -> id.equals(f.getId()))
                .findFirst();

        return found.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Feedback not found: " + id));
    }

    public ResponseEntity<?> createFeedback(Feedback feedback) {
        if (feedback.getCustomerId() == null || feedback.getCustomerId().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("customerId is required");
        }

        boolean customerExists = customerService.getAllCustomers().stream()
                .anyMatch(c -> feedback.getCustomerId().equals(c.getId()));

        if (!customerExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer not found: " + feedback.getCustomerId());
        }

        feedbackList.add(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedback);
    }
}