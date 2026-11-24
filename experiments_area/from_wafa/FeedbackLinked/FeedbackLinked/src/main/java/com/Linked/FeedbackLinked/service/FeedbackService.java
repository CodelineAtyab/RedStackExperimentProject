package com.Linked.FeedbackLinked.service;

import com.Linked.FeedbackLinked.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {

    private List<Feedback> feedbacks = new ArrayList<>();

    @Autowired
    private CustomerService customerService;

    public ResponseEntity<List<Feedback>> getAllFeedback() {
        return ResponseEntity.status(200).body(feedbacks);
    }

    public ResponseEntity<?> getFeedback(String id) {
        Feedback foundFeedback = feedbacks.stream()
                .filter(currFeedback -> currFeedback.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (foundFeedback != null) {
            return ResponseEntity.status(200).body(foundFeedback);
        }

        return ResponseEntity.status(404).body("Feedback " + id + " not found");
    }

    public ResponseEntity<?> addFeedback(Feedback feedback) {
        if (!customerService.customerExists(feedback.getCustomerId())) {
            return ResponseEntity.status(404)
                    .body("Customer " + feedback.getCustomerId() + " not found");
        }

        feedbacks.add(feedback);
        return ResponseEntity.status(201).body(feedback);
    }
}